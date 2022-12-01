package com.github.songxzj.wxpay.v3.core.authcipher;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Slf4j
public abstract class AbstractAuthCipher implements AuthCipher {

    private final String transformation;

    private final byte[] apiv3Key;

    private final String algorithm;

    private final int tagLengthBit;


    protected AbstractAuthCipher(byte[] apiv3Key, String transformation, String algorithm, int tagLengthBit) {
        this.apiv3Key = apiv3Key;
        this.transformation = transformation;
        this.algorithm = algorithm;
        this.tagLengthBit = tagLengthBit;
    }


    @Override
    public String decrypt(String nonce, String associatedData, String cipherText) throws WxErrorException {
        try {
            final Cipher cipher = Cipher.getInstance(this.transformation);
            SecretKeySpec key = new SecretKeySpec(this.apiv3Key, this.algorithm);
            GCMParameterSpec spec = new GCMParameterSpec(this.tagLengthBit, nonce.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            if (!StringUtils.isBlank(associatedData)) {
                cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));
            }
            return new String(cipher.doFinal(Base64Utils.decodeFromString(cipherText)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.DECRYPT_CERTIFICATE_ERROR);
        }
    }
}
