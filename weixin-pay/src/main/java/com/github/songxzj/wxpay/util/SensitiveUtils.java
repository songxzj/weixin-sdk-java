package com.github.songxzj.wxpay.util;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.security.cert.X509Certificate;

/**
 * 敏感信息加/解密
 */
@Slf4j
public class SensitiveUtils {

    private static final String JAVA_LANG_STRING = "java.lang.String";
    private static final String CIPHER_PROVIDER = "SunJCE";
    private static final String TRANSFORMATION_PKCS1PADDING = "RSA/ECB/PKCS1Padding";


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


}
