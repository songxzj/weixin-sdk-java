package com.github.songxzj.wxpay.v3.core.privacyencryptor;

import com.github.songxzj.common.exception.WxErrorException;

import java.security.cert.X509Certificate;

public interface PrivacyEncryptor {


    /**
     * 敏感信息加密
     *
     * @param plaintextObject
     * @param certificate
     * @return
     * @throws WxErrorException
     */
    Object encrypt(Object plaintextObject, X509Certificate certificate) throws WxErrorException;
}
