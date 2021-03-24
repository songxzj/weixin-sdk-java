package com.github.songxzj.wxpay.v3.bean.cert;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class WxPayV3Certificate implements Serializable {
    private static final long serialVersionUID = 2715254016526450667L;


    /**
     * 证书序列号
     */
    @SerializedName("serial_no")
    private String serialNo;

    /**
     * 证书启用时间.
     * effective_time
     * 是
     * String
     * 2019-09-04T10:12:51+08:00
     */
    @SerializedName("effective_time")
    private String effectiveTime;

    /**
     * 证书弃用时间.
     * expire_time
     * 是
     * String
     * 2019-09-04T10:12:51+08:00
     */
    @SerializedName("expire_time")
    private String expireTime;

    /**
     * 加密证书.
     * certificate
     * 是
     */
    @SerializedName("encrypt_certificate")
    private EncryptV3Certificate encryptV3Certificate;

    private String certificateStr;

    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class EncryptV3Certificate implements Serializable {
        private static final long serialVersionUID = 8098660117605659126L;

        @SerializedName("algorithm")
        private String algorithm;

        @SerializedName("nonce")
        private String nonce;

        @SerializedName("associated_data")
        private String associatedData;

        @SerializedName("ciphertext")
        private String cipherText;
    }
}
