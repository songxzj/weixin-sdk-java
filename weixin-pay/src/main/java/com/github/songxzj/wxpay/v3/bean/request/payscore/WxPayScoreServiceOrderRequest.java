package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScoreServiceOrderResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.03.05
 * 创建支付分订单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_14.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScoreServiceOrderRequest extends BaseWxPayV3Request<WxPayScoreServiceOrderResult> {
    private static final long serialVersionUID = -2778638176133803381L;
    /**
     * 商户服务订单号
     * out_order_no
     * string[1,32]
     * 是
     */
    @Required
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
     * 服务信息
     * service_introduction
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("service_introduction")
    private String serviceIntroduction;

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
    @Required
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
     * 订单风险金
     * risk_fund
     * object
     * 是
     */
    @Required
    @SerializedName("risk_fund")
    private RiskFund riskFund;

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
    @Required
    @SerializedName("notify_url")
    private String notifyUrl;

    /**
     * 用户标识
     * openid
     * string[1,128]
     * 条件选填
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 是否需要用户确认
     * need_user_confirm
     * bool
     * 否
     */
    @SerializedName("need_user_confirm")
    private Boolean needUserConfirm;

    @Override
    public String routing() {
        return "/v3/payscore/serviceorder";
    }

    @Override
    public Class<WxPayScoreServiceOrderResult> getResultClass() {
        return WxPayScoreServiceOrderResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (Boolean.FALSE.equals(this.needUserConfirm) && StringUtils.isBlank(this.openid)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "免确认订单, openid 必填");
        }
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
        if (this.riskFund != null) {
            this.riskFund.checkConstraints();
        }
    }

    /**
     * 后付费项目
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostPayment extends BaseV3Inner {
        private static final long serialVersionUID = 7820763185898251788L;

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

        @Override
        public void checkConstraints() throws WxErrorException {
            if (!StringUtils.isBlank(this.name) && this.amount == null && StringUtils.isBlank(this.description)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "如果填写了付费项目名称，则 amount 或 description 必须填写其一，或都填");
            }
        }
    }

    /**
     * 后付费商户优惠
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostDiscount extends BaseV3Inner {
        private static final long serialVersionUID = -6178714010700804131L;

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

        @Override
        public void checkConstraints() throws WxErrorException {
            if (StringUtils.isBlank(this.name) != StringUtils.isBlank(this.description)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "name 和 description 若填写，则必须同时填写");
            }
        }
    }

    /**
     * 服务时间段
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TimeRange extends BaseV3Inner {
        private static final long serialVersionUID = -1155305009687654119L;

        /**
         * 服务开始时间
         * start_time
         * string[1,14]
         * 是
         */
        @Required
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
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Location extends BaseV3Inner {
        private static final long serialVersionUID = -853074253184172517L;

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

        @Override
        public void checkConstraints() throws WxErrorException {
            if (StringUtils.isBlank(this.startLocation) && !StringUtils.isBlank(endLocation)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "填写了服务开始地点，才能填写服务结束地点");
            }
        }
    }

    /**
     * 订单风险金
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RiskFund extends BaseV3Inner {
        private static final long serialVersionUID = -3213871596818444960L;

        /**
         * 风险金名称
         * name
         * string[1,64]
         * 是
         */
        @Required
        @SerializedName("name")
        private String name;

        /**
         * 风险金额
         * amount
         * int64
         * 是
         */
        @Required
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

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


}
