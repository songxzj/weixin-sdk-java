package com.github.songxzj.wxpay.v3.bean.result.combine;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 通用如下：
 * 支付通知（https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_13.shtml）
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxCombineTransactionsStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 8106926247257904392L;

    /**
     * 合单商户appid
     * combine_appid
     * string[1,32]
     * 是
     */
    @SerializedName("combine_appid")
    private String combineAppid;

    /**
     * 合单商户号
     * combine_mchid
     * string[1,32]
     * 是
     */
    @SerializedName("combine_mchid")
    private String combineMchid;

    /**
     * 合单商户订单号
     * combine_out_trade_no
     * string[1,32]
     * 是
     */
    @SerializedName("combine_out_trade_no")
    private String combineOutTradeNo;

    /**
     * 场景信息
     * scene_info
     * object
     * 否
     */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;

    /**
     * 子单信息
     * sub_orders
     * array
     * 是
     */
    @SerializedName("sub_orders")
    private List<SubOrder> subOrders;

    /**
     * 支付者
     * combine_payer_info
     * object
     * 否
     */
    @SerializedName("combine_payer_info")
    private CombinePayerInfo combinePayerInfo;


    /**
     * 场景信息
     */
    @Data
    @NoArgsConstructor
    public static class SceneInfo implements Serializable {
        private static final long serialVersionUID = 7573674519776180059L;

        /**
         * 商户端设备号
         * device_id
         * string[7,16]
         * 否
         */
        @SerializedName("device_id")
        private String deviceId;
    }

    /**
     * 子单信息
     */
    @Data
    @NoArgsConstructor
    public static class SubOrder implements Serializable {
        private static final long serialVersionUID = 9213074386247061216L;

        /**
         * 子单商户号
         * mchid
         * string[1,32]
         * 是
         */
        @SerializedName("mchid")
        private String mchid;

        /**
         * 交易类型
         * trade_type
         * string[1,16]
         * 否
         */
        @SerializedName("trade_type")
        private String tradeType;

        /**
         * 交易状态
         * trade_state
         * string[1,32]
         * 是
         */
        @SerializedName("trade_state")
        private String tradeState;

        /**
         * 付款银行
         * bank_type
         * string[1,16]
         * 否
         */
        @SerializedName("bank_type")
        private String bankType;

        /**
         * 附加数据
         * attach
         * string[1,128]
         * 否
         */
        @SerializedName("attach")
        private String attach;

        /**
         * 支付完成时间
         * success_time
         * string[1,64]
         * 否
         */
        @SerializedName("success_time")
        private String successTime;


        /**
         * 微信支付订单号
         * transaction_id
         * string[1,32]
         * 否
         */
        @SerializedName("transaction_id")
        private String transactionId;

        /**
         * 子单商户订单号
         * out_trade_no
         * string[6,32]
         * 是
         */
        @SerializedName("out_trade_no")
        private String outTradeNo;

        /**
         * 二级商户号
         * sub_mchid
         * string[1,32]
         * 是
         */
        @SerializedName("sub_mchid")
        private String subMchid;

        /**
         * 订单金额
         * amount
         * object
         * 是
         */
        @SerializedName("amount")
        private Amount amount;
    }

    /**
     * 订单金额
     */
    @Data
    @NoArgsConstructor
    public static class Amount implements Serializable {
        private static final long serialVersionUID = 6412751184390720459L;
        /**
         * 标价金额
         * total_amount
         * int64
         * 是
         */
        @SerializedName("total_amount")
        private Integer totalAmount;

        /**
         * 标价币种
         * currency
         * string[1,8]
         * 否
         */
        @SerializedName("currency")
        private String currency;

        /**
         * 现金支付金额
         * payer_amount
         * int64
         * 是
         */
        @SerializedName("payer_amount")
        private Integer payerAmount;

        /**
         * 现金支付币种
         * payer_currency
         * string[1,8]
         * 否
         */
        @SerializedName("payer_currency")
        private String payerCurrency;
    }

    /**
     * 支付者
     */
    @Data
    @NoArgsConstructor
    public static class CombinePayerInfo implements Serializable {
        private static final long serialVersionUID = -1514375948726783878L;

        /**
         * 用户标识
         * openid
         * string[1,128]
         * 是
         */
        @SerializedName("openid")
        private String openid;
    }
}
