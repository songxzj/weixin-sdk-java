package com.github.songxzj.wxpay.v3.bean.result.pay;


import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 通用如下：
 * 支付通知
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_5.shtml）
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_5.shtml）
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_5.shtml）
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_5.shtml）
 * （https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_5.shtml）
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayTransactionsStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 4198949149306010671L;


    /**
     * 应用ID
     * appid
     * string[1,32]
     * 是
     */
    @SerializedName("appid")
    private String appid;

    /**
     * 直连商户号
     * mchid
     * string[1,32]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     商户订单号
     out_trade_no
     string[6,32]
     是
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     微信支付订单号
     transaction_id
     string[1,32]
     否
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 交易类型
     * trade_type
     * string[1,16]
     * 否
     */
    @SerializedName("trade_type")
    private String tradeType;

    /**
     *交易状态
     *  trade_state
     *  string[1,32]
     *  是
     */
    @SerializedName("trade_state")
    private String tradeState;

    /**
     * 交易状态描述
     * trade_state_desc
     * string[1,256]
     * 是
     */
    @SerializedName("trade_state_desc")
    private String tradeStateDesc;

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
     * 支付者
     * payer
     * object
     * 是
     */
    @SerializedName("payer")
    private Payer payer;

    /**
     * 订单金额
     * amount
     * object
     * 否
     */
    @SerializedName("amount")
    private Amount amount;

    /**
     * 场景信息
     * scene_info
     * object
     * 否
     */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;

    /**
     * 优惠功能
     * promotion_detail
     * array
     * 否
     */
    @SerializedName("promotion_detail")
    private List<PromotionDetail> promotionDetails;

    /**
     * 场景信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class SceneInfo implements Serializable {
        private static final long serialVersionUID = 6470631386723741309L;
        /**
         * 商户端设备号
         * device_id
         * string[1,32]
         * 否
         */
        @SerializedName("device_id")
        private String deviceId;
    }

    /**
     * 支付者
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class Payer implements Serializable {
        private static final long serialVersionUID = -6219351812130271158L;
        /**
         * 用户标识
         * openid
         * string[1,128]
         * 是
         */
        @SerializedName("openid")
        private String openid;
    }

    /**
     * 订单金额
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class Amount implements Serializable {
        private static final long serialVersionUID = 6341873471086570457L;
        /**
         * 总金额
         * total
         * int
         * 否
         */
        @SerializedName("total")
        private Integer total;


        /**
         * 用户支付金额
         * payer_total
         * int
         * 否
         */
        @SerializedName("payer_total")
        private Integer payerTotal;


        /**
         * 货币类型
         * currency
         * string[1,16]
         * 否
         */
        @SerializedName("currency")
        private String currency;


        /**
         * 用户支付币种
         * payer_currency
         * string[1,16]
         * 否
         */
        @SerializedName("payer_currency")
        private String payerCurrency;
    }

    /**
     * 优惠功能
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class PromotionDetail implements Serializable {
        private static final long serialVersionUID = -3120568670426727370L;

        /**
         * 券ID
         * coupon_id
         * string[1,32]
         * 是
         */
        @SerializedName("coupon_id")
        private String couponId;

        /**
         * 优惠名称
         * name
         * string[1,64]
         * 否
         */
        @SerializedName("name")
        private String name;
        /**
         * 优惠范围
         * scope
         * string[1,32]
         * 否
         */
        @SerializedName("scope")
        private String scope;

        /**
         * 优惠类型
         * type
         * string[1,32]
         * 否
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
         * 活动ID
         * stock_id
         * string[1,32]
         * 否
         */
        @SerializedName("stock_id")
        private String stockId;

        /**
         * 微信出资
         * wechatpay_contribute
         * int
         * 否
         */
        @SerializedName("wechatpay_contribute")
        private Integer wechatpayContribute;

        /**
         * 商户出资
         * merchant_contribute
         * int
         * 否
         */
        @SerializedName("merchant_contribute")
        private Integer merchantContribute;

        /**
         * 其他出资
         * other_contribute
         * int
         * 否
         */
        @SerializedName("other_contribute")
        private Integer otherContribute;

        /**
         * 优惠币种
         * currency
         * string[1,16]
         * 否
         */
        @SerializedName("currency")
        private String currency;

        /**
         * 单品列表
         * goods_detail
         * array
         * 否
         */
        @SerializedName("goods_detail")
        private List<GoodsDetail> goodsDetails;
    }

    /**
     * 单品列表
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class GoodsDetail implements Serializable {
        private static final long serialVersionUID = 6801463866895472029L;
        /**
         * 商品编码
         * goods_id
         * string[1,32]
         * 是
         */
        @SerializedName("goods_id")
        private String goodsId;

        /**
         * 商品数量
         * quantity
         * int
         * 是
         */
        @SerializedName("quantity")
        private Integer quantity;

        /**
         * 商品单价
         * unit_price
         * int
         * 是
         */
        @SerializedName("unit_price")
        private Integer unitPrice;

        /**
         * 商品优惠金额
         * discount_amount
         * int
         * 是
         */
        @SerializedName("discount_amount")
        private Integer discountAmount;

        /**
         * 商品备注
         * goods_remark
         * string[1,128]
         * 否
         */
        @SerializedName("goods_remark")
        private String goodsRemark;
    }
}
