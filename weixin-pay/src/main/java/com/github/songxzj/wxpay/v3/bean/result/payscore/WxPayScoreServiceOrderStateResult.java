package com.github.songxzj.wxpay.v3.bean.result.payscore;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayScoreServiceOrderStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -3817731917565636784L;

    /**
     * 应用ID
     * appid
     * string[1,32]
     * 是
     */
    @SerializedName("appid")
    private String appid;

    /**
     * 商户号
     * mchid
     * string[1,32]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 商户服务订单号
     * out_order_no
     * string[1,32]
     * 是
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 服务ID
     * service_id
     * string[1,32]
     * 是
     */
    @SerializedName("service_id")
    private String serviceId;

    /**
     * 服务信息
     * service_introduction
     * string[1,20]
     * 是
     */
    @SerializedName("service_introduction")
    private String serviceIntroduction;

    /**
     * 服务订单状态
     * state
     * string[1,32]
     * 是
     */
    @SerializedName("state")
    private String state;

    /**
     * 订单状态说明
     * state_description
     * string (32)
     * 否
     */
    @SerializedName("state_description")
    private String stateDescription;

    /**
     * 商户收款总金额
     * total_amount
     * int64
     * 否
     */
    @SerializedName("total_amount")
    private Integer totalAmount;

    /**
     * 后付费项目
     * post_payments
     * array
     * 否
     */
    @SerializedName("post_payments")
    private List<PostPayment> postPayments;

    /**
     * 后付费商户优惠
     * post_discounts
     * array
     * 否
     */
    @SerializedName("post_discounts")
    private List<PostDiscount> postDiscounts;

    /**
     * 订单风险金
     * risk_fund
     * object
     * 是
     */
    @SerializedName("risk_fund")
    private RiskFund riskFund;

    /**
     * 服务时间段
     * time_range
     * object
     * 是
     */
    @SerializedName("time_range")
    private TimeRange timeRange;

    /**
     * 服务位置
     * location
     * object
     * 否
     */
    @SerializedName("location")
    private Location location;


    /**
     * 商户数据包	attach
     * string[1,256]
     * 否
     */
    @SerializedName("attach")
    private String attach;

    /**
     * 商户回调地址
     * notify_url
     * string[1,255]
     * 是
     */
    @SerializedName("notify_url")
    private String notifyUrl;

    /**
     * 微信支付服务订单号
     * order_id
     * string[1,64]
     * 是
     */
    @SerializedName("order_id")
    private String orderId;

    /**
     * 是否需要收款
     * need_collection
     * bool
     * 条件选填
     */
    @SerializedName("need_collection")
    private Boolean needCollection;

    /**
     * 收款信息
     * collection
     * object
     * 条件选填
     */
    @SerializedName("collection")
    private Collection collection;

    /**
     * 用户标识
     * openid
     * string[1,128]
     * 否
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 后付费项目
     */
    @Data
    @NoArgsConstructor
    public static class PostPayment implements Serializable {
        private static final long serialVersionUID = -4694931039858907062L;

        /**
         * 付费项目名称
         * name
         * string[1,20]
         * 否
         */
        @SerializedName("name")
        private String name;

        /**
         * 金额
         * amount
         * int64
         * 条件选填
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 计费说明
         * description
         * string[1,30]
         * 条件选填
         */
        @SerializedName("description")
        private String description;

        /**
         * 付费数量
         * count
         * uint32
         * 否
         */
        @SerializedName("count")
        private Integer count;
    }

    /**
     * 后付费商户优惠
     */
    @Data
    @NoArgsConstructor
    public static class PostDiscount implements Serializable {
        private static final long serialVersionUID = -1235417652093452035L;

        /**
         * 优惠名称
         * name
         * string[1,20]
         * 条件选填
         */
        @SerializedName("name")
        private String name;

        /**
         * 优惠说明
         * description
         * string[1,30]
         * 条件选填
         */
        @SerializedName("description")
        private String description;

        /**
         * 优惠金额
         * amount
         * int
         * 否
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 优惠数量
         * count
         * uint32
         * 否
         */
        @SerializedName("count")
        private Integer count;
    }

    /**
     * 服务时间段
     */
    @Data
    @NoArgsConstructor
    public static class TimeRange implements Serializable {
        private static final long serialVersionUID = -4530028594283254202L;
        /**
         * 服务开始时间
         * start_time
         * string[1,14]
         * 是
         */
        @SerializedName("start_time")
        private String startTime;

        /**
         * 服务开始时间备注
         * start_time_remark
         * string[1,20]
         * 否
         */
        @SerializedName("start_time_remark")
        private String startTimeRemark;

        /**
         * 预计服务结束时间
         * end_time
         * string[1,14]
         * 否
         */
        @SerializedName("end_time")
        private String endTime;

        /**
         * 预计服务结束时间备注
         * end_time_remark
         * string[1,20]
         * 否
         */
        @SerializedName("end_time_remark")
        private String endTimeRemark;
    }

    /**
     * 服务位置
     */
    @Data
    @NoArgsConstructor
    public static class Location implements Serializable {
        private static final long serialVersionUID = 275418943155817014L;

        /**
         * 服务开始地点
         * start_location
         * string[1,50]
         * 否
         */
        @SerializedName("start_location")
        private String startLocation;

        /**
         * 预计服务结束位置
         * end_location
         * string[1,50]
         * 条件选填
         */
        @SerializedName("end_location")
        private String endLocation;
    }

    /**
     * 订单风险金
     */
    @Data
    @NoArgsConstructor
    public static class RiskFund implements Serializable {
        private static final long serialVersionUID = 5853198509551872666L;

        /**
         * 风险金名称
         * name
         * string[1,64]
         * 是
         */
        @SerializedName("name")
        private String name;

        /**
         * 风险金额
         * amount
         * int64
         * 是
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 风险说明
         * description
         * string[1,30]
         * 否
         */
        @SerializedName("description")
        private String description;
    }

    /**
     * 收款信息
     */
    @Data
    @NoArgsConstructor
    public static class Collection implements Serializable {
        private static final long serialVersionUID = -6425746106571022141L;

        /**
         * 收款状态
         * state
         * string[1,32]
         * 是
         */
        @SerializedName("state")
        private String state;

        /**
         * 总收款金额
         * total_amount
         * int64
         * 否
         */
        @SerializedName("total_amount")
        private Integer totalAmount;

        /**
         * 待收金额
         * paying_amount
         * int64
         * 否
         */
        @SerializedName("paying_amount")
        private Integer payingAmount;

        /**
         * 已收金额
         * paid_amount
         * int64
         * 否
         */
        @SerializedName("paid_amount")
        private Integer paidAmount;

        /**
         * 收款明细列表
         * details
         * array
         * 否
         */
        @SerializedName("details")
        private List<Detail> details;
    }

    /**
     * 收款明细
     */
    @Data
    @NoArgsConstructor
    public static class Detail implements Serializable {
        private static final long serialVersionUID = 399893006872476354L;

        /**
         * 收款序号
         * seq
         * int
         * 否
         */
        @SerializedName("seq")
        private Integer seq;

        /**
         * 单笔收款金额
         * amount
         * int64
         * 否
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 收款成功渠道
         * paid_type
         * string[1,32]
         * 否
         */
        @SerializedName("paid_type")
        private String paidType;

        /**
         * 收款成功时间
         * paid_time
         * string[1,14]
         * 否
         */
        @SerializedName("paid_time")
        private String paidTime;

        /**
         * 微信支付交易单号
         * transaction_id
         * string[1,200]
         * 否
         */
        @SerializedName("transaction_id")
        private String transactionId;

        /**
         * 优惠功能
         * promotion_detail
         * array
         * 否
         */
        @SerializedName("promotion_detail")
        private List<Promotion> promotionDetail;
    }

    /**
     * 优惠
     */
    @Data
    @NoArgsConstructor
    public static class Promotion implements Serializable {
        private static final long serialVersionUID = -4548270935733744595L;

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
         * string[1,12]
         * 否
         */
        @SerializedName("scope")
        private String scope;

        /**
         * 优惠类型
         * type
         * string[1,12]
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
         * int64
         * 否
         */
        @SerializedName("merchant_contribute")
        private Integer merchantContribute;

        /**
         * 其他出资
         * other_contribute
         * int64
         * 否
         */
        @SerializedName("other_contribute")
        private Integer otherContribute;

        /**
         * 优惠币种
         * currency
         * string
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
        private List<Goods> goodsDetail;
    }

    /**
     * 单品
     */
    @Data
    @NoArgsConstructor
    public static class Goods implements Serializable {
        private static final long serialVersionUID = 8205243700113245772L;

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
         * uint32
         * 否
         */
        @SerializedName("quantity")
        private Integer quantity;

        /**
         * 商品价格
         * unit_price
         * int64
         * 否
         */
        @SerializedName("unit_price")
        private Integer unitPrice;

        /**
         * 商品优惠金额
         * discount_amount
         * int64
         * 否
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
