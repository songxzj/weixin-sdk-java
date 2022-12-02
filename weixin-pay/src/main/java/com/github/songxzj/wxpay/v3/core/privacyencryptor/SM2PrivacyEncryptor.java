package com.github.songxzj.wxpay.v3.core.privacyencryptor;

import com.github.songxzj.common.core.kona.KonaProvider;

import java.security.Security;

public final class SM2PrivacyEncryptor extends AbstractPrivacyEncryptor {
    private static final String TRANSFORMATION = "SM2";

    static {
        Security.addProvider(new KonaProvider());
    }


    public SM2PrivacyEncryptor() {
        super(TRANSFORMATION);
    }
}