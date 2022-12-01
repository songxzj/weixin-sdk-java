package com.github.songxzj.wxpay.v3.core.verifier;

import com.github.songxzj.common.core.kona.KonaProvider;
import com.github.songxzj.common.exception.WxErrorException;

import java.security.Security;

public class SM2Verifier extends AbstractVerifier {
    public static final String ALGORITHM_NAME = "SM2";

    static {
        Security.addProvider(new KonaProvider());
    }

    public SM2Verifier() throws WxErrorException {
        super(ALGORITHM_NAME);
    }
}
