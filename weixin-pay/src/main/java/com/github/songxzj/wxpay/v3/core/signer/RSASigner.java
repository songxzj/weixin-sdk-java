package com.github.songxzj.wxpay.v3.core.signer;

import com.github.songxzj.common.exception.WxErrorException;

import java.security.PrivateKey;

public final class RSASigner extends AbstractSigner {

    public static final String ALGORITHM = "SHA256-RSA2048";
    public static final String ALGORITHM_NAME = "SHA256withRSA";

    public RSASigner(PrivateKey privateKey) throws WxErrorException {
        super(ALGORITHM, ALGORITHM_NAME, privateKey);
    }


}
