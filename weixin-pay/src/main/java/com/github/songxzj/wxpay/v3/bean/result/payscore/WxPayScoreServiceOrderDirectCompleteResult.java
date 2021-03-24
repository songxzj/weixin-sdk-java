package com.github.songxzj.wxpay.v3.bean.result.payscore;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayScoreServiceOrderDirectCompleteResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 8564244425177942126L;

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
     * 总金额
     * total_amount
     * uint64
     * 是
     */
    @SerializedName("total_amount")
    private Integer totalAmount;

    /**
     * 后付费项目
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class PostPayment implements Serializable {
        private static final long serialVersionUID = -5677872145131567760L;

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
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class PostDiscount implements Serializable {
        private static final long serialVersionUID = -4054490861650115309L;

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
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class TimeRange implements Serializable {
        private static final long serialVersionUID = -3398591334197973741L;

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
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class Location implements Serializable {
        private static final long serialVersionUID = 6775463711721993067L;

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




}
