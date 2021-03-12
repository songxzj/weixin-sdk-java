package com.github.songxzj.wxpay.v2.bean.cert;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class WxPayCertificate implements Serializable {
    private static final long serialVersionUID = 1460975937156822707L;

    /**
     * 平台证书序列号.
     * serial_no
     * 是
     * String
     * 42A5C4F7F70D57D0576BBEDA0E0928D6E5C4F003
     */
    @SerializedName("serial_no")
    private String serialNo;

    /**
     * 证书启用时间.
     * effective_time
     * 是
     * String
     * 2017-08-18 14:52:04
     */
    @SerializedName("effective_time")
    private String effectiveTime;

    /**
     * 证书弃用时间.
     * expire_time
     * 是
     * String
     * 2022-08-17 14:52:04
     */
    @SerializedName("expire_time")
    private String expireTime;

    /**
     * 加密证书.
     * certificate
     * 是
     */
    @SerializedName("encrypt_certificate")
    private EncryptCertificate encryptCertificate;

    private String certificateStr;

    @Data
    public static class EncryptCertificate implements Serializable {
        private static final long serialVersionUID = -6225726818335888179L;

        private String algorithm;

        private String nonce;

        @SerializedName("associated_data")
        private String associatedData;

        @SerializedName("ciphertext")
        private String cipherText;
    }


}
