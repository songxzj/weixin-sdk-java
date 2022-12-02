package com.github.songxzj.wxpay.v3.core;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.util.CertKeyUtils;
import com.github.songxzj.wxpay.v3.core.authcipher.SM4AuthCipher;
import com.github.songxzj.wxpay.v3.core.privacydecryptor.SM2PrivacyDecryptor;
import com.github.songxzj.wxpay.v3.core.privacyencryptor.SM2PrivacyEncryptor;
import com.github.songxzj.wxpay.v3.core.signer.SM2Signer;
import com.github.songxzj.wxpay.v3.core.verifier.SM2Verifier;
import org.apache.commons.lang3.StringUtils;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class WxPaySMConfig extends WxPayAbstractConfig {

    private WxPaySMConfig(String mchId, String serialNo, X509Certificate certificate, PrivateKey privateKey, String apiv3Key) throws WxErrorException {
        this.mchId = mchId;
        this.serialNo = serialNo;
        this.certificate = certificate;
        this.privateKey = privateKey;
        this.apiv3Key = apiv3Key;
        this.signer = new SM2Signer(privateKey);
        this.verifier = new SM2Verifier();
        this.authCipher = new SM4AuthCipher(apiv3Key);
        this.privacyEncryptor = new SM2PrivacyEncryptor();
        this.privacyDecryptor = new SM2PrivacyDecryptor(privateKey);
    }

    public static WxPayV3SMConfigBuilder newBuilder() {
        return new WxPayV3SMConfigBuilder();
    }

    public static class WxPayV3SMConfigBuilder {

        private String mchId;

        private String serialNo;

        private String privateCertStr;

        private String privateCertPath;

        private String privateKeyStr;

        private String privateKeyPath;

        private String apiv3Key;

        private WxPayV3SMConfigBuilder() {
        }

        public WxPayV3SMConfigBuilder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public WxPayV3SMConfigBuilder serialNo(String serialNo) {
            this.serialNo = serialNo;
            return this;
        }

        public WxPayV3SMConfigBuilder privateCertStr(String privateCertStr) {
            this.privateCertStr = privateCertStr;
            return this;
        }

        public WxPayV3SMConfigBuilder privateCertPath(String privateCertPath) {
            this.privateCertPath = privateCertPath;
            return this;
        }

        public WxPayV3SMConfigBuilder privateKeyStr(String privateKeyStr) {
            this.privateKeyStr = privateKeyStr;
            return this;
        }

        public WxPayV3SMConfigBuilder privateKeyPath(String privateKeyPath) {
            this.privateKeyPath = privateKeyPath;
            return this;
        }

        public WxPayV3SMConfigBuilder apiv3Key(String apiv3Key) {
            this.apiv3Key = apiv3Key;
            return this;
        }

        public WxPaySMConfig build() throws WxErrorException {
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

            return new WxPaySMConfig(this.mchId, this.serialNo, certificate, privateKey, this.apiv3Key);
        }
    }
}

