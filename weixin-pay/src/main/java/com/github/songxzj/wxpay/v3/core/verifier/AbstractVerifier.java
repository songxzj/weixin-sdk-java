package com.github.songxzj.wxpay.v3.core.verifier;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;

@Slf4j
public abstract class AbstractVerifier implements Verifier {

    private final Signature signature;

    protected AbstractVerifier(String algorithmName) throws WxErrorException {
        try {
            this.signature = Signature.getInstance(algorithmName);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SIGN_ERROR_CODE, "不支持此算法：" + algorithmName);
        }
    }


    public boolean verify(X509Certificate certificate, String message, String signature) throws WxErrorException {
        try {
            this.signature.initVerify(certificate);
            this.signature.update(message.getBytes(StandardCharsets.UTF_8));
            return this.signature.verify(Base64Utils.decodeFromString(signature));
        } catch (InvalidKeyException | SignatureException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SIGN_ERROR_ERROR);
        }
    }
}
