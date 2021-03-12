package com.github.songxzj.wxpay.util;

import cn.hutool.crypto.digest.DigestUtil;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
public class DecryptUtils {

    private static final int TAG_LENGTH_BIT = 128;
    private static final String CIPHER_PROVIDER = "SunJCE";
    private static final String TRANSFORMATION_NoPadding = "AES/GCM/NoPadding";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding"; // "AES/ECB/PKCS7Padding";
    private static final String ALGORITHM = "AES";

    /**
     * apiv3 解密
     */
    public static String decryptV3(String apiv3Key, String nonce, String associatedData, String cipherText) throws WxErrorException {
        try {
            final Cipher cipher = Cipher.getInstance(TRANSFORMATION_NoPadding);
            SecretKeySpec key = new SecretKeySpec(apiv3Key.getBytes(), ALGORITHM);
            GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH_BIT, nonce.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            cipher.updateAAD(associatedData.getBytes());
            return new String(cipher.doFinal(Base64Utils.decodeFromString(cipherText)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.DECRYPT_CERTIFICATE_ERROR);
        }
    }

    /**
     * 退款通知解密
     *
     * @param mchKey
     * @param cipherText
     * @return
     * @throws WxErrorException
     */
    public static String decryptV2RefundNotify(String mchKey, String cipherText) throws WxErrorException {
        try {
            final Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            String keyMd5String = DigestUtil.md5Hex(mchKey).toLowerCase();
            SecretKeySpec key = new SecretKeySpec(keyMd5String.getBytes(), ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);

            return new String(cipher.doFinal(Base64Utils.decodeFromString(cipherText)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.DECRYPT_CERTIFICATE_ERROR);
        }
    }
}
