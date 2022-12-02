package com.github.songxzj.wxpay.v3.core.privacydecryptor;

import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.List;

@Slf4j
public abstract class AbstractPrivacyDecryptor implements PrivacyDecryptor {
    private final Cipher cipher;

    protected AbstractPrivacyDecryptor(String transformation, PrivateKey privateKey) throws WxErrorException {
        try {
            this.cipher = Cipher.getInstance(transformation);
            this.cipher.init(Cipher.DECRYPT_MODE, privateKey);
        }  catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SENSITIVE_ENCRYPT_ERROR);
        }
    }

    /**
     * v3 对象敏感解密
     *
     * @param ciphertextObject
     * @throws WxErrorException
     */
    public Object decrypt(Object ciphertextObject) throws WxErrorException {
        try {
            return decryptField(ciphertextObject);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SENSITIVE_ENCRYPT_ERROR);
        }
    }

    private Object decryptField(Object ciphertextObject) throws Exception {
        List<Field> fields = Lists.newArrayList(Arrays.asList(ciphertextObject.getClass().getDeclaredFields()));
        for (Field field : fields) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            if (field.isAnnotationPresent(SensitiveEncrypt.class) && field.get(ciphertextObject) != null) {
                //字段使用了@SpecEncrypt进行标识
                Object obj = field.get(ciphertextObject);
                if (obj instanceof String) {
                    String oldStr = obj.toString();
                    field.set(ciphertextObject, decryptText(oldStr));
                } else {
                    ciphertextObject = decryptField(obj);
                }
            }
            field.setAccessible(isAccessible);
        }
        return ciphertextObject;
    }

    /**
     * 对敏感内容（入参 ciphertext）解密
     *
     * @param ciphertext
     * @return
     */
    private String decryptText(String ciphertext) throws Exception {
        if (StringUtils.isBlank(ciphertext)) {
            return null;
        }

        return new String(this.cipher.doFinal(Base64Utils.decodeFromString(ciphertext)), StandardCharsets.UTF_8);
    }
}
