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
public class WxPayScoreServiceOrderSyncResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -5008517291863169088L;

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
        private static final long serialVersionUID = -2907420898659664392L;

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
        private static final long serialVersionUID = -8166633668066473837L;

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
    }

    /**
     * 服务时间段
     */
    @Data
    @NoArgsConstructor
    public static class TimeRange implements Serializable {
        private static final long serialVersionUID = 6597246890070208497L;

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
        private static final long serialVersionUID = -1268638551809610230L;

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
        private static final long serialVersionUID = -4560721246103439839L;

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
        private static final long serialVersionUID = 7998065033466700919L;

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
        private static final long serialVersionUID = 1388471795687490295L;

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
    }

}
