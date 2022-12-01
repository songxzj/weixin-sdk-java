package com.github.songxzj.wxpay.v3.core;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.util.CertKeyUtils;
import com.github.songxzj.wxpay.v3.core.authcipher.AesAuthCipher;
import com.github.songxzj.wxpay.v3.core.signer.RSASigner;
import com.github.songxzj.wxpay.v3.core.verifier.RSAVerifier;
import org.apache.commons.lang3.StringUtils;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class WxPayRSAConfig extends WxPayAbstractConfig {

    private WxPayRSAConfig(String mchId, String serialNo, X509Certificate certificate, PrivateKey privateKey, String apiv3Key) throws WxErrorException {
        this.mchId = mchId;
        this.serialNo = serialNo;
        this.certificate = certificate;
        this.privateKey = privateKey;
        this.apiv3Key = apiv3Key;
        this.signer = new RSASigner(privateKey);
        this.verifier = new RSAVerifier();
        this.authCipher = new AesAuthCipher(apiv3Key);
    }

    public static WxPayV3RSAConfigBuilder newBuilder() {
        return new WxPayV3RSAConfigBuilder();
    }

    public static class WxPayV3RSAConfigBuilder {

        private String mchId;

        private String serialNo;

        private String privateCertStr;

        private String privateCertPath;

        private String privateKeyStr;

        private String privateKeyPath;

        private String apiv3Key;

        private WxPayV3RSAConfigBuilder() {
        }

        public WxPayV3RSAConfigBuilder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public WxPayV3RSAConfigBuilder serialNo(String serialNo) {
            this.serialNo = serialNo;
            return this;
        }

        public WxPayV3RSAConfigBuilder privateCertStr(String privateCertStr) {
            this.privateCertStr = privateCertStr;
            return this;
        }

        public WxPayV3RSAConfigBuilder privateCertPath(String privateCertPath) {
            this.privateCertPath = privateCertPath;
            return this;
        }

        public WxPayV3RSAConfigBuilder privateKeyStr(String privateKeyStr) {
            this.privateKeyStr = privateKeyStr;
            return this;
        }

        public WxPayV3RSAConfigBuilder privateKeyPath(String privateKeyPath) {
            this.privateKeyPath = privateKeyPath;
            return this;
        }

        public WxPayV3RSAConfigBuilder apiv3Key(String apiv3Key) {
            this.apiv3Key = apiv3Key;
            return this;
        }

        public WxPayRSAConfig build() throws WxErrorException {
            if (StringUtils.isBlank(this.mchId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "mchId 必须提供值");
            }
            if (StringUtils.isBlank(this.serialNo)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "商户API证书序列号必须提供值");
            }
            if (StringUtils.isAllBlank(this.privateCertPath, this.privateCertStr)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "商户证书信息必须提供值");
            }
            if (StringUtils.isAllBlank(this.privateKeyPath, this.privateKeyStr)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "商户密钥信息必须提供值");
            }
            if (StringUtils.isBlank(this.apiv3Key)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "apiv3Key 必须提供值");
            }

            X509Certificate certificate;
            if (!StringUtils.isBlank(this.privateCertPath)) {
                certificate = CertKeyUtils.loadCertificate(CertKeyUtils.loadInputStream(this.privateCertPath));
            } else {
                certificate = CertKeyUtils.loadCertificate(this.privateCertStr);
            }
            PrivateKey privateKey;
            if (!StringUtils.isBlank(this.privateKeyPath)) {
                privateKey = CertKeyUtils.loadPrivateKey(CertKeyUtils.loadInputStream(this.privateKeyPath));
            } else {
                privateKey = CertKeyUtils.loadPrivateKey(this.privateKeyStr);
            }

            return new WxPayRSAConfig(this.mchId, this.serialNo, certificate, privateKey, this.apiv3Key);
        }
    }
}

