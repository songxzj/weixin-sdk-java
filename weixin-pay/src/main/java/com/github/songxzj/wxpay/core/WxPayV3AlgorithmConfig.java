package com.github.songxzj.wxpay.core;

import com.github.songxzj.wxpay.core.authcipher.AuthCipher;
import com.github.songxzj.wxpay.core.signer.Signer;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public abstract class WxPayV3AlgorithmConfig {

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

    protected AuthCipher authCipher;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public X509Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(X509Certificate certificate) {
        this.certificate = certificate;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public String getApiv3Key() {
        return apiv3Key;
    }

    public void setApiv3Key(String apiv3Key) {
        this.apiv3Key = apiv3Key;
    }

    public Signer getSigner() {
        return signer;
    }

    public void setSigner(Signer signer) {
        this.signer = signer;
    }

    public AuthCipher getAuthCipher() {
        return authCipher;
    }

    public void setAuthCipher(AuthCipher authCipher) {
        this.authCipher = authCipher;
    }
}
