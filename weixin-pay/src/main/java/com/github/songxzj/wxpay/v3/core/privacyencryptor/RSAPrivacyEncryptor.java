package com.github.songxzj.wxpay.v3.core.privacyencryptor;

public class RSAPrivacyEncryptor extends AbstractPrivacyEncryptor {
    private static final String TRANSFORMATION = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";

    public RSAPrivacyEncryptor() {
        super(TRANSFORMATION);
    }
}
