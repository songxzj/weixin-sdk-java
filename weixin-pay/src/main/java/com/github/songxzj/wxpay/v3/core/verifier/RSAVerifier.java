package com.github.songxzj.wxpay.v3.core.verifier;

import com.github.songxzj.common.exception.WxErrorException;

public class RSAVerifier extends AbstractVerifier {

    public static final String ALGORITHM_NAME = "SHA256withRSA";

    public RSAVerifier() throws WxErrorException {
        super(ALGORITHM_NAME);
    }
}
