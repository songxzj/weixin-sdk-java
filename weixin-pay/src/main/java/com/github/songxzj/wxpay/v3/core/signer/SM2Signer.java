package com.github.songxzj.wxpay.v3.core.signer;

import com.github.songxzj.common.core.kona.KonaProvider;
import com.github.songxzj.common.exception.WxErrorException;

import java.security.PrivateKey;
import java.security.Security;

public class SM2Signer extends AbstractSigner {

    static {
        Security.addProvider(new KonaProvider());
    }

    public static final String ALGORITHM = "SM2-WITH-SM3";
    public static final String ALGORITHM_NAME = "SM2";

    public SM2Signer(PrivateKey privateKey) throws WxErrorException {
        super(ALGORITHM, ALGORITHM_NAME, privateKey);
    }
}
