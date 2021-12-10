package com.github.songxzj.wxpay.v3.bean.result.profitsharing;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxProfitSharingOrderStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -836025626433144585L;
    /**
     * 微信订单号
     * transaction_id
     * string[1, 32]
     * 是
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 商户分账单号
     * out_order_no
     * string[1, 64]
     * 是
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 微信分账单号
     * order_id
     * string[1, 64]
     * 是
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 分账单状态
     * state
     * string[1, 32]
     * 是
     */
    @SerializedName("state")
    private String state;

    /**
     * 分账接收方列表
     * receivers
     * array
     * 否
     */
    @SerializedName("receivers")
    private List<Receiver> receivers;


    /**
     * 分账接收方列表
     */
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    public static class Receiver implements Serializable {
        private static final long serialVersionUID = -7333686331175363L;

        /**
         * 分账金额
         * amount
         * int
         * 是
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 分账描述
         * description
         * string[1, 80]
         * 是
         */
        @SerializedName("description")
        private String description;

        /**
         * 接收方类型
         * type
         * string[1, 32]
         * 是
         */
        @SerializedName("type")
        private String type;

        /**
         * 接收方账号
         * account
         * string[1, 64]
         * 是
         */
        @SerializedName("account")
        private String account;

        /**
         * 分账结果
         * result
         * string[1, 32]
         * 是
         */
        @SerializedName("result")
        private String result;

        /**
         * 分账失败原因
         * fail_reason
         * string[1, 64]
         * 是
         */
        @SerializedName("fail_reason")
        private String failReason;

        /**
         * 分账创建时间
         * create_time
         * string[1, 64]
         * 是
         */
        @SerializedName("create_time")
        private String createTime;

        /**
         * 分账完成时间
         * finish_time
         * string[1, 64]
         * 是
         */
        @SerializedName("finish_time")
        private String finishTime;

        /**
         * 分账明细单号
         * detail_id
         * string[1,64]
         * 是
         */
        @SerializedName("detail_id")
        private String detailId;
    }
}
