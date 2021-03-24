package com.github.songxzj.wxpay.v3.bean.result.notify;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxNotifyResult<T extends BaseWxPayV3Result> extends BaseWxPayV3Result {
    private static final long serialVersionUID = -6489635647461474994L;

    /**
     * 通知ID
     * id
     * string[1,32]
     * 是
     */
    @SerializedName("id")
    private String id;

    /**
     * 通知创建时间
     * create_time
     * string[1,16]
     * 是
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 通知类型
     * event_type
     * string[1,32]
     * 是
     */
    @SerializedName("event_type")
    private String eventType;

    /**
     * 通知数据类型
     * resource_type
     * string[1,32]
     * 是
     */
    @SerializedName("resource_type")
    private String resourceType;

    /**
     * 通知数据
     * resource
     * object
     * 是
     */
    @SerializedName("resource")
    private Resource resource;

    /**
     * 回调摘要
     * summary
     * string[1,64]
     * 是
     */
    @SerializedName("summary")
    private String summary;

    /**
     * 最终的解密出来的数据
     */
    private T wxPayResult;

    /**
     * 通知数据
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class Resource implements Serializable {
        private static final long serialVersionUID = -8878853020585554882L;

        /**
         * 加密算法类型
         * algorithm
         * string[1,32]
         * 是
         */
        @SerializedName("algorithm")
        private String algorithm;

        /**
         * 数据密文
         * ciphertext
         * string[1,1048576]
         * 是
         */
        @SerializedName("ciphertext")
        private String cipherText;

        /**
         * 附加数据
         * associated_data
         * string[1,16]
         * 否
         */
        @SerializedName("associated_data")
        private String associatedData;

        /**
         * 原始类型
         * original_type
         * string[1,16]
         * 是
         */
        @SerializedName("original_type")
        private String originalType;

        /**
         * 随机串
         * nonce
         * string[1,16]
         * 是
         */
        @SerializedName("nonce")
        private String nonce;
    }


}
