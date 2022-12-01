package com.github.songxzj.wxpay.core.signer;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.constant.WxPayConstants;

import java.security.PrivateKey;

public final class RSASigner extends AbstractSigner {


    public RSASigner(PrivateKey privateKey) throws WxErrorException {
        super(WxPayConstants.AlgorithmType.SHA256_RSA2048, WxPayConstants.SignType.SHA256WithRSA, privateKey);
    }


}
