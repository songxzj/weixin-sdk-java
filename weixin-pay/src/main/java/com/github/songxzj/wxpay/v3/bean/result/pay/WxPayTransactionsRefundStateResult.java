package com.github.songxzj.wxpay.v3.bean.result.pay;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 通用如下：
 * 退款结果通知API
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_11.shtml）
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_11.shtml）
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_11.shtml）
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_11.shtml）
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_11.shtml）
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayTransactionsRefundStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2799829327325509948L;

    /**
     * 直连商户号
     * mchid
     * string[1,32]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 微信支付退款号
     * refund_id
     * string[1, 32]
     * 是
     */
    @SerializedName("refund_id")
    private String refundId;

    /**
     * 商户退款单号
     * out_refund_no
     * string[1, 64]
     * 是
     */
    @SerializedName("out_refund_no")
    private String outRefundNo;

    /**
     * 微信支付订单号
     * transaction_id
     * string[1, 32]
     * 是
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * out_trade_no
     * string[1, 32]
     * 是
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 退款渠道
     * channel
     * string[1, 16]
     * 是
     */
    @SerializedName("channel")
    private String channel;

    /**
     * 退款入账账户
     * user_received_account
     * string[1, 64]
     * 是
     */
    @SerializedName("user_received_account")
    private String userReceivedAccount;

    /**
     * 退款成功时间
     * success_time
     * string[1, 64]
     * 否
     */
    @SerializedName("success_time")
    private String successTime;

    /**
     * 退款创建时间
     * create_time
     * string[1, 64]
     * 是
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 退款状态
     * status
     * string[1, 32]
     * 是
     */
    @SerializedName("status")
    private String status;

    /**
     * 退款状态
     * refund_status
     * string[1,16]
     * 是
     */
    @SerializedName("refund_status")
    private String refundStatus;

    /**
     * 资金账户
     * funds_account
     * string[1, 32]
     * 否
     */
    @SerializedName("funds_account")
    private String fundsAccount;

    /**
     * 金额信息
     * amount
     * object
     * 是
     */
    @SerializedName("amount")
    private Amount amount;

    /**
     * 优惠退款信息
     * promotion_detail
     * array
     * 否
     */
    @SerializedName("promotion_detail")
    private List<PromotionDetail> promotionDetail;


    /**
     * 金额信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class Amount implements Serializable {
        private static final long serialVersionUID = -4142251093840360550L;

        /**
         * 订单金额
         * total
         * int
         * 是
         */
        @SerializedName("total")
        private Integer total;

        /**
         * 退款金额
         * refund
         * int
         * 是
         */
        @SerializedName("refund")
        private Integer refund;

        /**
         * 用户支付金额
         * payer_total
         * int
         * 是
         */
        @SerializedName("payer_total")
        private Integer payerTotal;

        /**
         * 用户退款金额
         * payer_refund
         * int
         * 是
         */
        @SerializedName("payer_refund")
        private Integer payerRefund;

        /**
         * 应结退款金额
         * settlement_refund
         * int
         * 是
         */
        @SerializedName("settlement_refund")
        private Integer settlementRefund;

        /**
         * 应结订单金额
         * settlement_total
         * int
         * 是
         */
        @SerializedName("settlement_total")
        private Integer settlementTotal;

        /**
         * 优惠退款金额
         * discount_refund
         * int
         * 是
         */
        @SerializedName("discount_refund")
        private Integer discountRefund;

        /**
         * 退款币种
         * currency
         * string[1, 16]
         * 是
         */
        @SerializedName("currency")
        private String currency;
    }

    /**
     * 优惠退款信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class PromotionDetail implements Serializable {
        private static final long serialVersionUID = 5146362153277536357L;

        /**
         * 券ID
         * promotion_id
         * string[1, 32]
         * 是
         */
        @SerializedName("promotion_id")
        private String promotionId;

        /**
         * 优惠范围
         * scope
         * string[1, 32]
         * 是
         */
        @SerializedName("scope")
        private String scope;

        /**
         * 优惠类型
         * type
         * string[1, 32]
         * 是
         */
        @SerializedName("type")
        private String type;

        /**
         * 优惠券面额
         * amount
         * int
         * 是
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 优惠退款金额
         * refund_amount
         * int
         * 是
         */
        @SerializedName("refund_amount")
        private Integer refundAmount;

        /**
         * 商品列表
         * goods_detail
         * array
         * 否
         */
        @SerializedName("goods_detail")
        private List<GoodsDetail> goodsDetail;
    }

    /**
     * 商品列表
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class GoodsDetail implements Serializable {
        private static final long serialVersionUID = -6312153501203854971L;
        /**
         * 商户侧商品编码
         * merchant_goods_id
         * string[1, 32]
         * 是
         */
        @SerializedName("merchant_goods_id")
        private String merchantGoodsId;

        /**
         * 微信侧商品编码
         * wechatpay_goods_id
         * string[1, 32]
         * 否
         */
        @SerializedName("wechatpay_goods_id")
        private String wechatpayGoodsId;

        /**
         * 商品名称
         * goods_name
         * string[1, 256]
         * 否
         */
        @SerializedName("goods_name")
        private String goodsName;

        /**
         * 商品单价
         * unit_price
         * int
         * 是
         */
        @SerializedName("unit_price")
        private Integer unitPrice;

        /**
         * 商品退款金额
         * refund_amount
         * int
         * 是
         */
        @SerializedName("refund_amount")
        private Integer refundAmount;

        /**
         * 商品退货数量
         * refund_quantity
         * int
         * 是
         */
        @SerializedName("refund_quantity")
        private Integer refundQuantity;
    }
}
