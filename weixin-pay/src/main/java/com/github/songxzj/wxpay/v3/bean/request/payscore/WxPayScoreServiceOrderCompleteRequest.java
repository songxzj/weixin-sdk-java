package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScoreServiceOrderCompleteResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.06.02
 * 完结支付分订单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_18.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScoreServiceOrderCompleteRequest extends BaseWxPayV3Request<WxPayScoreServiceOrderCompleteResult> {
    private static final long serialVersionUID = 7852922488742318037L;

    /**
     * 商户服务订单号
     * out_order_no
     * string[1,32]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 应用ID
     * appid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 服务ID
     * service_id
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("service_id")
    private String serviceId;

    /**
     * 后付费项目
     * post_payments
     * array
     * 否
     */
    @Required
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
     * 总金额
     * total_amount
     * int64
     * 是
     */
    @Required
    @SerializedName("total_amount")
    private Integer totalAmount;

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
     * 微信支付服务分账标记
     * profit_sharing
     * bool
     * 否
     */
    @SerializedName("profit_sharing")
    private Boolean profitSharing;

    /**
     * 订单优惠标记
     * goods_tag
     * string（32）
     * 否
     */
    @SerializedName("goods_tag")
    private String goodsTag;


    @Override
    public String routing() {
        return "/v3/payscore/serviceorder/" + this.outOrderNo + "/complete";
    }

    @Override
    public Class<WxPayScoreServiceOrderCompleteResult> getResultClass() {
        return WxPayScoreServiceOrderCompleteResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.postPayments != null) {
            for (PostPayment postPayment : this.postPayments) {
                postPayment.checkConstraints();
            }
        }
        if (this.postDiscounts != null) {
            for (PostDiscount postDiscount : this.postDiscounts) {
                postDiscount.checkConstraints();
            }
        }
        if (this.timeRange != null) {
            this.timeRange.checkConstraints();
        }
        if (this.location != null) {
            this.location.checkConstraints();
        }
    }

    /**
     * 后付费项目
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostPayment extends BaseV3Inner {
        private static final long serialVersionUID = -7182495554760756234L;
        /**
         * 付费项目名称
         * name
         * string[1,20]
         * 是
         */
        @Required
        @SerializedName("name")
        private String name;

        /**
         * 金额
         * amount
         * int64
         * 是
         */
        @Required
        @SerializedName("amount")
        private Integer amount;

        /**
         * 计费说明
         * description
         * string[1,30]
         * 否
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

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


    /**
     * 后付费商户优惠
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostDiscount extends BaseV3Inner {
        private static final long serialVersionUID = -8490819019820177176L;

        /**
         * 优惠名称
         * name
         * string[1,20]
         * 否
         */
        @SerializedName("name")
        private String name;

        /**
         * 优惠说明
         * description
         * string[1,30]
         * 否
         */
        @SerializedName("description")
        private String description;

        /**
         * 优惠金额
         * amount
         * int64
         * 条件选填
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

        @Override
        public void checkConstraints() throws WxErrorException {
            if (!StringUtils.isBlank(this.name) && this.amount == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "若填写了优惠名称，则优惠金额必填");
            }
        }
    }

    /**
     * 服务时间段
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TimeRange extends BaseV3Inner {
        private static final long serialVersionUID = 7383624831712418375L;

        /**
         * 服务开始时间
         * start_time
         * string[1,14]
         * 否
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

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 服务位置
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Location extends BaseV3Inner {
        private static final long serialVersionUID = 338940116948435741L;


        /**
         * 预计服务结束位置
         * end_location
         * string[1,50]
         * 条件选填
         */
        @SerializedName("end_location")
        private String endLocation;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }
}
