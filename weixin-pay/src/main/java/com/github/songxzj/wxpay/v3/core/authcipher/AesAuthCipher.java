package com.github.songxzj.wxpay.v3.core.authcipher;

import java.nio.charset.StandardCharsets;

public class AesAuthCipher extends AbstractAuthCipher {

    private static final int TAG_LENGTH_BIT = 128;
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final String ALGORITHM = "AES";


    public AesAuthCipher(String apiv3Key) {
        super(apiv3Key.getBytes(StandardCharsets.UTF_8), TRANSFORMATION, ALGORITHM, TAG_LENGTH_BIT);
    }
}
