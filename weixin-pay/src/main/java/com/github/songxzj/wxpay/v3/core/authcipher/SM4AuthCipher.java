package com.github.songxzj.wxpay.v3.core.authcipher;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.tencent.kona.KonaProvider;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Arrays;

@Slf4j
public class SM4AuthCipher extends AbstractAuthCipher {
    static {
        Security.addProvider(new KonaProvider());
    }

    private static final String TRANSFORMATION = "SM4/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT = 128;
    private static final String ALGORITHM = "SM4";


    public SM4AuthCipher(String apiV3Key) throws WxErrorException {
        super(covertSM4Key(apiV3Key), TRANSFORMATION, ALGORITHM, TAG_LENGTH_BIT);
    }

    /**
     * 取SM3摘要的前128位，将APIv3Key转化成SM4使用的密钥
     *
     * @param apiV3Key APIv3Key
     * @return SM4Gcm的密钥
     */
    private static byte[] covertSM4Key(String apiV3Key) throws WxErrorException {
        try {
            MessageDigest md = MessageDigest.getInstance("SM3", KonaProvider.NAME);
            return Arrays.copyOf(md.digest(apiV3Key.getBytes(StandardCharsets.UTF_8)), 16);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.KEY_ERROR_ERROR);
        }
    }
}