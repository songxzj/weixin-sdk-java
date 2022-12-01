package com.github.songxzj.wxpay.v3.core;

import com.github.songxzj.wxpay.v3.core.authcipher.AuthCipher;
import com.github.songxzj.wxpay.v3.core.signer.Signer;
import com.github.songxzj.wxpay.v3.core.verifier.Verifier;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public abstract class WxPayAbstractConfig implements WxPayConfig {


    /**
     * 商户号.
     */
    protected String mchId;
    /**
     * 商户API证书序列号
     */
    protected String serialNo;
    /**
     * 商户API证书
     */
    protected X509Certificate certificate;

    /**
     * 商户私钥.
     */
    protected PrivateKey privateKey;

    /**
     * apiv3 密钥
     */
    protected String apiv3Key;

    protected Signer signer;

    protected Verifier verifier;

    protected AuthCipher authCipher;

    @Override
    public String getMchId() {
        return mchId;
    }


    @Override
    public String getSerialNo() {
        return serialNo;
    }


    @Override
    public Signer getSigner() {
        return signer;
    }

    @Override
    public Verifier getVerifier() {
        return verifier;
    }

    @Override
    public AuthCipher getAuthCipher() {
        return authCipher;
    }

    @Override
    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
