package com.github.songxzj.wxpay.v3.core.privacydecryptor;

import com.github.songxzj.common.exception.WxErrorException;

import java.security.PrivateKey;

/**
 * RSA敏感信息解密器
 */
public final class RSAPrivacyDecryptor extends AbstractPrivacyDecryptor {
    private static final String TRANSFORMATION = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";


    public RSAPrivacyDecryptor(PrivateKey privateKey) throws WxErrorException {
        super(TRANSFORMATION, privateKey);
    }
}
