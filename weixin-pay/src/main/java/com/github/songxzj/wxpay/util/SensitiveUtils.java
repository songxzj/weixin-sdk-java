package com.github.songxzj.wxpay.util;

import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.lang.reflect.Field;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

/**
 * 敏感信息加/解密
 */
@Slf4j
public class SensitiveUtils {

    private static final String JAVA_LANG_STRING = "java.lang.String";
    private static final String CIPHER_PROVIDER = "SunJCE";
    private static final String TRANSFORMATION_PKCS1PADDING = "RSA/ECB/PKCS1Padding";
    private static final String TRANSFORMATION_1ANDMGF1PADDING = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";


    /**
     * 对敏感内容（入参 content）加密 (v2)
     *
     * @param content
     * @param certificate
     * @return
     * @throws Exception
     */
    public static String rsaEncrypt(String content, X509Certificate certificate) throws WxErrorException {
        if (StringUtils.isBlank(content)) {
            return null;
        }
        try {
            Cipher ci = Cipher.getInstance(TRANSFORMATION_PKCS1PADDING, CIPHER_PROVIDER);
            ci.init(Cipher.ENCRYPT_MODE, certificate.getPublicKey());

            return Base64Utils.encodeToString(ci.doFinal(content.getBytes(WxPayConstants.DEFAULT_CHARSET)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SENSITIVE_ENCRYPT_ERROR);
        }
    }


    /**
     * v3 对象敏感加密
     *
     * @param encryptObject
     * @param certificate
     * @throws WxErrorException
     */
    public static void encryptFieldsV3(Object encryptObject, X509Certificate certificate) throws WxErrorException {
        try {
            encryptField(encryptObject, certificate);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SENSITIVE_ENCRYPT_ERROR);
        }
    }

    private static void encryptField(Object encryptObject, X509Certificate certificate) throws WxErrorException, IllegalAccessException {
        List<Field> fields = Lists.newArrayList(Arrays.asList(encryptObject.getClass().getDeclaredFields()));
        for (Field field : fields) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            if (field.isAnnotationPresent(SensitiveEncrypt.class) && field.get(encryptObject) != null) {
                //字段使用了@SpecEncrypt进行标识
                Object obj = field.get(encryptObject);
                if (obj instanceof String) {
                    String oldStr = obj.toString();
                    field.set(encryptObject, rsaEncryptOAEPV3(oldStr, certificate));
                } else {
                    encryptField(obj, certificate);
                }
            }
            field.setAccessible(isAccessible);
        }
    }

    /**
     * 对敏感内容（入参 content）加密 (v3)
     *
     * @param content
     * @param certificate
     * @return
     * @throws WxErrorException
     */
    public static String rsaEncryptOAEPV3(String content, X509Certificate certificate) throws WxErrorException {
        if (StringUtils.isBlank(content)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION_1ANDMGF1PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, certificate.getPublicKey());

            return Base64Utils.encodeToString(cipher.doFinal(content.getBytes(WxPayConstants.DEFAULT_CHARSET)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SENSITIVE_ENCRYPT_ERROR);
        }
    }

    /**
     * v3 对象敏感解密
     *
     * @param encryptObject
     * @param privateKey
     * @throws WxErrorException
     */
    public static void decryptFieldsV3(Object encryptObject, PrivateKey privateKey) throws WxErrorException {
        try {
            decryptField(encryptObject, privateKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SENSITIVE_ENCRYPT_ERROR);
        }
    }

    private static void decryptField(Object encryptObject, PrivateKey privateKey) throws WxErrorException, IllegalAccessException {
        List<Field> fields = Lists.newArrayList(Arrays.asList(encryptObject.getClass().getDeclaredFields()));
        for (Field field : fields) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            if (field.isAnnotationPresent(SensitiveEncrypt.class) && field.get(encryptObject) != null) {
                //字段使用了@SpecEncrypt进行标识
                Object obj = field.get(encryptObject);
                if (obj instanceof String) {
                    String oldStr = obj.toString();
                    field.set(encryptObject, rsaDecryptOAEPV3(oldStr, privateKey));
                } else {
                    decryptField(obj, privateKey);
                }
            }
            field.setAccessible(isAccessible);
        }
    }

    /**
     * 对敏感内容（入参 content）解密 (v3)
     *
     * @param content
     * @param privateKey
     * @return
     * @throws WxErrorException
     */
    public static String rsaDecryptOAEPV3(String content, PrivateKey privateKey) throws WxErrorException {
        if (StringUtils.isBlank(content)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION_1ANDMGF1PADDING);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            return new String(cipher.doFinal(Base64Utils.decodeFromString(content)), WxPayConstants.DEFAULT_CHARSET);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SENSITIVE_ENCRYPT_ERROR);
        }
    }


}
