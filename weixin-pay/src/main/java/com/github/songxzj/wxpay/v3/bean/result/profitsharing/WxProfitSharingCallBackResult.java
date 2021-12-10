package com.github.songxzj.wxpay.v3.bean.result.profitsharing;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

/**
 * version:2020.11.03
 * 分账动账通知API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_10.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxProfitSharingCallBackResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 7143356745083636596L;


    /**
     * 直连商户号
     * mchid
     * string[1,32]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 微信订单号
     * transaction_id
     * string[1, 32]
     * 是
     */
    @SerializedName("transaction_id")
    private String transactionId;


    /**
     * 微信分账/回退单号
     * order_id
     * string[1, 64]
     * 是
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 商户分账/回退单号
     * out_order_no
     * string[1, 64]
     * 是
     */
    @SerializedName("out_order_no")
    private String outOrderNo;


    /**
     * 分账接收方列表
     * receivers
     * array
     * 否
     */
    @SerializedName("receiver")
    private Receiver receiver;

    /**
     * 成功时间
     * success_time
     * string[1,32]
     * 是
     */
    @SerializedName("success_time")
    private String successTime;


    /**
     * 分账接收方
     */
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    public static class Receiver implements Serializable {
        private static final long serialVersionUID = 5228096545545725034L;

        /**
         * 分账接收方类型
         * type
         * string[1, 32]
         * 是
         */
        @SerializedName("type")
        private String type;

        /**
         * 分账接收方账号
         * account
         * string[1, 64]
         * 是
         */
        @SerializedName("account")
        private String account;

        /**
         * 分账动账金额
         * amount
         * int
         * 是
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 分账/回退描述
         * description
         * string[1, 80]
         * 是
         */
        @SerializedName("description")
        private String description;

    }
}
