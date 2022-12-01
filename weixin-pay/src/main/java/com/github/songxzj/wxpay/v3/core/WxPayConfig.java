package com.github.songxzj.wxpay.v3.core;

import com.github.songxzj.wxpay.v3.core.authcipher.AuthCipher;
import com.github.songxzj.wxpay.v3.core.signer.Signer;

import java.security.PrivateKey;

public interface WxPayConfig {


    String getMchId();


    String getSerialNo();


    Signer getSigner();


    AuthCipher getAuthCipher();

    PrivateKey getPrivateKey();


}
