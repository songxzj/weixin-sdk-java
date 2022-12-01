package com.github.songxzj.wxpay.v3.core.verifier;

import com.github.songxzj.common.exception.WxErrorException;

import java.security.cert.X509Certificate;

public interface Verifier {


    /**
     * 签名验证
     * @param certificate
     * @param message
     * @param signature
     * @return
     * @throws WxErrorException
     */
    boolean verify(X509Certificate certificate, String message, String signature) throws WxErrorException;
}
