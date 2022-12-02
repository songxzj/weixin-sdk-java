package com.github.songxzj.wxpay.v3.core.privacyencryptor;

import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

@Slf4j
public abstract class AbstractPrivacyEncryptor implements PrivacyEncryptor {
    private final String transformation;


    protected AbstractPrivacyEncryptor(String transformation) {
        this.transformation = transformation;
    }

    /**
     * v3 对象敏感加密
     */
    public Object encrypt(Object plaintextObject, X509Certificate certificate) throws WxErrorException {
        try {
            return encryptField(plaintextObject, certificate);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SENSITIVE_ENCRYPT_ERROR);
        }
    }


    private Object encryptField(Object plaintextObject, X509Certificate certificate) throws Exception {
        List<Field> fields = Lists.newArrayList(Arrays.asList(plaintextObject.getClass().getDeclaredFields()));
        for (Field field : fields) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            if (field.isAnnotationPresent(SensitiveEncrypt.class) && field.get(plaintextObject) != null) {
                //字段使用了@SpecEncrypt进行标识
                Object obj = field.get(plaintextObject);
                if (obj instanceof String) {
                    String oldStr = obj.toString();
                    field.set(plaintextObject, encryptText(oldStr, certificate));
                } else {
                    plaintextObject = encryptField(obj, certificate);
                }
            }
            field.setAccessible(isAccessible);
        }
        return plaintextObject;
    }

    /**
     * 对敏感内容（入参 plaintext）加密
     *
     * @param plaintext
     * @param certificate
     * @return
     */
    private String encryptText(String plaintext, X509Certificate certificate) throws Exception {
        if (StringUtils.isBlank(plaintext)) {
            return null;
        }
        Cipher cipher = Cipher.getInstance(this.transformation);
        cipher.init(Cipher.ENCRYPT_MODE, certificate.getPublicKey());

        return Base64Utils.encodeToString(cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8)));
    }


}
