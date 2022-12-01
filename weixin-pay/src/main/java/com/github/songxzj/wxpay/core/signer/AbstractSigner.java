package com.github.songxzj.wxpay.core.signer;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.security.*;

@Slf4j
public abstract class AbstractSigner implements Signer {

    private final String algorithm;

    private final Signature signature;

    protected AbstractSigner(String algorithm, String algorithmName, PrivateKey privateKey) throws WxErrorException {
        this.algorithm = algorithm;
        try {
            this.signature = Signature.getInstance(algorithmName);
            this.signature.initSign(privateKey);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SIGN_ERROR_CODE, "不支持此算法：" + algorithmName);
        } catch (InvalidKeyException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SIGN_ERROR_CODE, algorithmName + "使用了非法的私钥");
        }
    }

    @Override
    public String sign(String message) throws WxErrorException {
        try {
            this.signature.update(message.getBytes(StandardCharsets.UTF_8));
            return Base64Utils.encodeToString(this.signature.sign());
        } catch (SignatureException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SIGN_ERROR_ERROR);
        }
    }

    @Override
    public String getAlgorithm() {
        return this.algorithm;
    }
}
