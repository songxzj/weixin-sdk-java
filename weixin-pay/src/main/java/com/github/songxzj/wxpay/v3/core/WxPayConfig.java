package com.github.songxzj.wxpay.v3.core;

import com.github.songxzj.wxpay.v3.core.authcipher.AuthCipher;
import com.github.songxzj.wxpay.v3.core.signer.Signer;
import com.github.songxzj.wxpay.v3.core.verifier.Verifier;

import java.security.PrivateKey;

public interface WxPayConfig {


    String getMchId();


    String getSerialNo();


    Signer getSigner();

    Verifier getVerifier();


    AuthCipher getAuthCipher();

    PrivateKey getPrivateKey();


}
