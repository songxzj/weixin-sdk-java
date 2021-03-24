package com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity;

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
public class WxPayGiftActivityStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2249180229874753501L;

    /**
     * 活动id
     * activity_id
     * string[1,20]
     * 是
     */
    @SerializedName("activity_id")
    private String activityId;

    /**
     * 活动类型
     * activity_type
     * string[1,32]
     * 否
     */
    @SerializedName("activity_type")
    private String activityType;

    /**
     * 活动基本信息
     * activity_base_info
     * object
     * 是
     */
    @SerializedName("activity_base_info")
    private ActivityBaseInfo activityBaseInfo;

    /**
     * 活动奖品发放规则
     * award_send_rule
     * object
     * 是
     */
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

    /**
     * 活动状态
     * activity_status
     * string[1,32]
     * 是
     */
    @SerializedName("activity_status")
    private String activityStatus;

    /**
     * 创建商户号
     * creator_merchant_id
     * string[8,15]
     * 是
     */
    @SerializedName("creator_merchant_id")
    private String creatorMerchantId;

    /**
     * 所属商户号
     * belong_merchant_id
     * string[8,15]
     * 是
     */
    @SerializedName("belong_merchant_id")
    private String belongMerchantId;

    /**
     * 活动暂停时间
     * pause_time
     * string[1,32]
     * 否
     */
    @SerializedName("pause_time")
    private String pauseTime;

    /**
     * 活动恢复时间
     * recovery_time
     * string[1,32]
     * 否
     */
    @SerializedName("recovery_time")
    private String recoveryTime;

    /**
     * 活动创建时间
     * create_time
     * string[1,32]
     * 否
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 活动更新时间
     * update_time
     * string[1,32]
     * 否
     */
    @SerializedName("update_time")
    private String updateTime;


    /**
     * 活动基本信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class ActivityBaseInfo implements Serializable {
        private static final long serialVersionUID = -7472664129710707944L;

        /**
         * 活动名称
         * activity_name
         * string[1,10]
         * 是
         */
        @SerializedName("activity_name")
        private String activityName;

        /**
         * 活动副标题
         * activity_second_title
         * string[1,9]
         * 是
         */
        @SerializedName("activity_second_title")
        private String activitySecondTitle;

        /**
         * 商户logo
         * merchant_logo_url
         * string[10,128]
         * 是
         */
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
        @SerializedName("begin_time")
        private String beginTime;

        /**
         * 活动结束时间
         * end_time
         * string[1,32]
         * 是
         */
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
        @SerializedName("out_request_no")
        private String outRequestNo;

        /**
         * 投放目的
         * delivery_purpose
         * string[1,14]
         * 是
         */
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

    }

    /**
     * 可用时间段
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class AvailablePeriods implements Serializable {
        private static final long serialVersionUID = -8747136358163835855L;

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


    }

    /**
     * 可用时间
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class AvailableTime implements Serializable {
        private static final long serialVersionUID = 6237262836339373554L;

        /**
         * 可用开始时间
         * begin_time
         * string[1,32]
         * 是
         */
        @SerializedName("begin_time")
        private String beginTime;

        /**
         * 可用结束时间
         * end_time
         * string[1,32]
         * 是
         */
        @SerializedName("end_time")
        private String endTime;


    }

    /**
     * 每日可用时间
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class AvailableDayTime implements Serializable {
        private static final long serialVersionUID = -8422621420719839226L;

        /**
         * 每日可用开始时间
         * begin_day_time
         * string[1,6]
         * 是
         */
        @SerializedName("begin_day_time")
        private String beginDayTime;

        /**
         * 每日可用结束时间
         * end_day_time
         * string[1,6]
         * 是
         */
        @SerializedName("end_day_time")
        private String endDayTime;

    }

    /**
     * 活动奖品发放规则
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class AwardSendRule implements Serializable {
        private static final long serialVersionUID = 6213637047235661684L;

        /**
         * 满送活动奖品发放规则
         * full_send_rule
         * object
         * 否
         */
        @SerializedName("full_send_rule")
        private FullSendRule fullSendRule;
    }

    /**
     * 满送活动奖品发放规则
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class FullSendRule implements Serializable {
        private static final long serialVersionUID = -3875404743366802909L;

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
        @SerializedName("send_content")
        private String sendContent;

        /**
         * 奖品类型
         * award_type
         * string[1,10]
         * 是
         */
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
    }

    /**
     * 奖品基本信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class Award implements Serializable {
        private static final long serialVersionUID = 8575998767536135560L;

        /**
         * 批次id
         * stock_id
         * string[1,20]
         * 是
         */
        @SerializedName("stock_id")
        private String stockId;

        /**
         * 奖品原始图（大图）
         * original_image_url
         * string[10,128]
         * 是
         */
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

    }

    /**
     * 活动高级设置
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class AdvancedSetting implements Serializable {
        private static final long serialVersionUID = -1089560916351530804L;

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

    }


}

