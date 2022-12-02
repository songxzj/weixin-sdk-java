package com.github.songxzj.wxpay.v3.core.privacydecryptor;


import com.github.songxzj.common.core.kona.KonaProvider;
import com.github.songxzj.common.exception.WxErrorException;

import java.security.PrivateKey;
import java.security.Security;

public final class SM2PrivacyDecryptor extends AbstractPrivacyDecryptor {
    private static final String TRANSFORMATION = "SM2";

    static {
        Security.addProvider(new KonaProvider());
    }

    public SM2PrivacyDecryptor(PrivateKey privateKey) throws WxErrorException {
        super(TRANSFORMATION, privateKey);
    }
}
