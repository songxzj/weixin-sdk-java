package com.github.songxzj.wxpay.v3.bean.request.marketing.paygiftactivity;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity.WxPayGiftActivityResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.06.09
 * 创建全场满额送活动API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/paygiftactivity/chapter3_2.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayGiftActivityRequest extends BaseWxPayV3Request<WxPayGiftActivityResult> {
    private static final long serialVersionUID = -1552680269183444026L;

    /**
     * 活动基本信息
     * activity_base_info
     * object
     * 是
     */
    @Required
    @SerializedName("activity_base_info")
    private ActivityBaseInfo activityBaseInfo;

    /**
     * 活动奖品发放规则
     * award_send_rule
     * object
     * 是
     */
    @Required
    @SerializedName("award_send_rule")
    private AwardSendRule awardSendRule;

    /**
     * 活动高级设置
     * advanced_setting
     * object
     * 否
     */
    @SerializedName("advanced_setting")
    private AdvancedSetting advancedSetting;

    @Override
    public String routing() {
        return "/v3/marketing/paygiftactivity/unique-threshold-activity";
    }

    @Override
    public Class<WxPayGiftActivityResult> getResultClass() {
        return WxPayGiftActivityResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.activityBaseInfo != null) {
            this.activityBaseInfo.checkConstraints();
        }
        if (this.awardSendRule != null) {
            this.awardSendRule.checkConstraints();
        }
        if (this.advancedSetting != null) {
            this.advancedSetting.checkConstraints();
        }
    }

    /**
     * 活动基本信息
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActivityBaseInfo extends BaseV3Inner {
        private static final long serialVersionUID = 8405011188892864774L;

        /**
         * 活动名称
         * activity_name
         * string[1,10]
         * 是
         */
        @Required
        @SerializedName("activity_name")
        private String activityName;

        /**
         * 活动副标题
         * activity_second_title
         * string[1,9]
         * 是
         */
        @Required
        @SerializedName("activity_second_title")
        private String activitySecondTitle;

        /**
         * 商户logo
         * merchant_logo_url
         * string[10,128]
         * 是
         */
        @Required
        @SerializedName("merchant_logo_url")
        private String merchantLogoUrl;

        /**
         * 背景颜色
         * background_color
         * string[1,8]
         * 否
         */
        @SerializedName("background_color")
        private String backgroundColor;

        /**
         * 活动开始时间
         * begin_time
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("begin_time")
        private String beginTime;

        /**
         * 活动结束时间
         * end_time
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("end_time")
        private String endTime;

        /**
         * 可用时间段
         * available_periods
         * object
         * 否
         */
        @SerializedName("available_periods")
        private AvailablePeriods availablePeriods;

        /**
         * 商户请求单号
         * out_request_no
         * string[1,128]
         * 是
         */
        @Required
        @SerializedName("out_request_no")
        private String outRequestNo;

        /**
         * 投放目的
         * delivery_purpose
         * string[1,14]
         * 是
         */
        @Required
        @SerializedName("delivery_purpose")
        private String deliveryPurpose;

        /**
         * 商家小程序appid
         * mini_programs_appid
         * string[1,32]
         * 否
         */
        @SerializedName("mini_programs_appid")
        private String miniProgramsAppid;

        /**
         * 商家小程序path
         * mini_programs_path
         * string[1,128]
         * 否
         */
        @SerializedName("mini_programs_path")
        private String miniProgramsPath;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.availablePeriods != null) {
                this.availablePeriods.checkConstraints();
            }
        }
    }

    /**
     * 可用时间段
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AvailablePeriods extends BaseV3Inner {
        private static final long serialVersionUID = 3145184114809232178L;

        /**
         * 可用时间
         * available_time
         * array
         * 否
         */
        @SerializedName("available_time")
        private List<AvailableTime> availableTimeList;

        /**
         * 每日可用时间
         * available_day_time
         * array
         * 否
         */
        @SerializedName("available_day_time")
        private List<AvailableDayTime> availableDayTimeList;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.availableTimeList != null) {
                for (AvailableTime availableTime : this.availableTimeList) {
                    availableTime.checkConstraints();
                }
            }
            if (this.availableDayTimeList != null) {
                for (AvailableDayTime availableDayTime : this.availableDayTimeList) {
                    availableDayTime.checkConstraints();
                }
            }
        }
    }

    /**
     * 可用时间
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AvailableTime extends BaseV3Inner {
        private static final long serialVersionUID = 7822548243840445462L;

        /**
         * 可用开始时间
         * begin_time
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("begin_time")
        private String beginTime;

        /**
         * 可用结束时间
         * end_time
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("end_time")
        private String endTime;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 每日可用时间
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AvailableDayTime extends BaseV3Inner {
        private static final long serialVersionUID = -1082121149566693261L;

        /**
         * 每日可用开始时间
         * begin_day_time
         * string[1,6]
         * 是
         */
        @Required
        @SerializedName("begin_day_time")
        private String beginDayTime;

        /**
         * 每日可用结束时间
         * end_day_time
         * string[1,6]
         * 是
         */
        @Required
        @SerializedName("end_day_time")
        private String endDayTime;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 活动奖品发放规则
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AwardSendRule extends BaseV3Inner {
        private static final long serialVersionUID = 6988351955223882251L;

        /**
         * 消费金额门槛
         * transaction_amount_minimum
         * int
         * 条件选填
         */
        @SerializedName("transaction_amount_minimum")
        private Integer transactionAmountMinimum;

        /**
         * 发放内容
         * send_content
         * string[1,16]
         * 是
         */
        @Required
        @SerializedName("send_content")
        private String sendContent;

        /**
         * 奖品类型
         * award_type
         * string[1,10]
         * 是
         */
        @Required
        @SerializedName("award_type")
        private String awardType;

        /**
         * 奖品基本信息列表
         * award_list
         * array
         * 否
         */
        @SerializedName("award_list")
        private List<Award> awardList;

        /**
         * 发券商户号选项
         * merchant_option
         * string[1,26]
         * 是
         */
        @Required
        @SerializedName("merchant_option")
        private String merchantOption;

        /**
         * 发券商户号
         * merchant_id_list
         * array
         * 否
         */
        @SerializedName("merchant_id_list")
        private List<String> merchantIdList;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.awardList != null) {
                for (Award award : this.awardList) {
                    award.checkConstraints();
                }
            }
            if (this.merchantIdList != null && !(this.merchantIdList.size() >= 1 && this.merchantIdList.size() <= 500)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "发券商户号条目个数限制：[1，500]");
            }
        }
    }

    /**
     * 奖品基本信息
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Award extends BaseV3Inner {
        private static final long serialVersionUID = -6058065668009602802L;

        /**
         * 批次id
         * stock_id
         * string[1,20]
         * 是
         */
        @Required
        @SerializedName("stock_id")
        private String stockId;

        /**
         * 奖品原始图（大图）
         * original_image_url
         * string[10,128]
         * 是
         */
        @Required
        @SerializedName("original_image_url")
        private String originalImageUrl;

        /**
         * 奖品缩略图（小图）
         * thumbnail_url
         * string[10,128]
         * 否
         */
        @SerializedName("thumbnail_url")
        private String thumbnailUrl;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 活动高级设置
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdvancedSetting extends BaseV3Inner {
        private static final long serialVersionUID = 2283100848856969456L;

        /**
         * 投放用户类别
         * delivery_user_category
         * string[1,28]
         * 否
         */
        @SerializedName("delivery_user_category")
        private String deliveryUserCategory;

        /**
         * 商家会员appid
         * merchant_member_appid
         * string[1,32]
         * 否
         */
        @SerializedName("merchant_member_appid")
        private String merchantMemberAppid;

        /**
         * 订单优惠标记
         * goods_tags
         * array
         * 否
         */
        @SerializedName("goods_tags")
        private List<String> goodsTags;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


}
