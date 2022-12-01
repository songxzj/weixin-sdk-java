package com.github.songxzj.wxpay.core.authcipher;

import java.nio.charset.StandardCharsets;

public class AesAuthCipher extends AbstractAuthCipher {

    private static final int TAG_LENGTH_BIT = 128;

    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding"; // "AES/ECB/PKCS7Padding";
    private static final String ALGORITHM = "AES";


    public AesAuthCipher(String apiv3Key) {
        super(apiv3Key.getBytes(StandardCharsets.UTF_8), TRANSFORMATION, ALGORITHM, TAG_LENGTH_BIT);
    }
}
