package com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor;

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
public class WxBusifavorUserCouponStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -6973168366054678209L;

    /**
     * 批次归属商户号
     * belong_merchant
     * string[8,15]
     * 是
     */
    @SerializedName("belong_merchant")
    private String belongMerchant;

    /**
     * 商家券批次名称
     * stock_name
     * string[1,21]
     * 是
     */
    @SerializedName("stock_name")
    private String stockName;


    /**
     * 批次备注
     * comment
     * string[1,20]
     * 否
     */
    @SerializedName("comment")
    private String comment;

    /**
     * 适用商品范围
     * goods_name
     * string[1,15]
     * 是
     */
    @SerializedName("goods_name")
    private String goodsName;

    /**
     * 批次类型
     * stock_type
     * string[1,32]
     * 是
     */
    @SerializedName("stock_type")
    private String stockType;

    /**
     * 是否允许转赠
     * transferable
     * bool
     * 否
     */
    @SerializedName("transferable")
    private Boolean transferable;

    /**
     * 是否允许分享链接
     * shareable
     * bool
     * 否
     */
    @SerializedName("shareable")
    private Boolean shareable;

    /**
     * 券状态
     * coupon_state
     * string[1,16]
     * 否
     */
    @SerializedName("coupon_state")
    private String couponState;

    /**
     * 样式信息
     * display_pattern_info
     * object
     * 否
     */
    @SerializedName("display_pattern_info")
    private DisplayPatternInfo displayPatternInfo;

    /**
     * 核销规则
     * coupon_use_rule
     * object
     * 是
     */
    @SerializedName("coupon_use_rule")
    private CouponUseRule couponUseRule;

    /**
     * 自定义入口
     * custom_entrance
     * object
     * 否
     */
    @SerializedName("custom_entrance")
    private CustomEntrance customEntrance;


    /**
     * 券code
     * coupon_code
     * string[1,32]
     * 否
     */
    @SerializedName("coupon_code")
    private String couponCode;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 券可使用开始时间
     * available_start_time
     * string[1,32]
     * 是
     */
    @SerializedName("available_start_time")
    private String availableStartTime;

    /**
     * 券过期时间
     * expire_time
     * string[1,32]
     * 是
     */
    @SerializedName("expire_time")
    private String expireTime;

    /**
     * 券领券时间
     * receive_time
     * string[1,32]
     * 是
     */
    @SerializedName("receive_time")
    private String receiveTime;

    /**
     * 发券请求单号
     * send_request_no
     * string[1,32]
     * 是
     */
    @SerializedName("send_request_no")
    private String sendRequestNo;

    /**
     * 核销请求单号
     * use_request_no
     * string[1,32]
     * 否
     */
    @SerializedName("use_request_no")
    private String useRequestNo;

    /**
     * 券核销时间
     * use_time
     * string[1,32]
     * 否
     */
    @SerializedName("use_time")
    private String useTime;


    /**
     * 核销规则
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class CouponUseRule implements Serializable {
        private static final long serialVersionUID = -8613918476565743734L;
        /**
         * 券可核销时间
         * coupon_available_time
         * object
         * 是
         */
        @SerializedName("coupon_available_time")
        private CouponAvailableTime couponAvailableTime;

        /**
         * 固定面额满减券使用规则
         * fixed_normal_coupon
         * object
         */
        @SerializedName("fixed_normal_coupon")
        private FixedNormalCoupon fixedNormalCoupon;

        /**
         * 折扣券使用规则
         * discount_coupon
         * object
         */
        @SerializedName("discount_coupon")
        private DiscountCoupon discountCoupon;

        /**
         * 换购券使用规则
         * exchange_coupon
         * object
         */
        @SerializedName("exchange_coupon")
        private ExchangeCoupon exchangeCoupon;

        /**
         * 核销方式
         * use_method
         * string[1,128]
         * 是
         */
        @SerializedName("use_method")
        private String useMethod;

        /**
         * 小程序appid
         * mini_programs_appid
         * string[1,32]
         */
        @SerializedName("mini_programs_appid")
        private String miniProgramsAppid;

        /**
         * 小程序path
         * mini_programs_path
         * string[1,128]
         */
        @SerializedName("mini_programs_path")
        private String miniProgramsPath;
    }


    /**
     * 自定义入口
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class CustomEntrance implements Serializable {
        private static final long serialVersionUID = -3538686841966657503L;
        /**
         * 小程序入口
         * mini_programs_info
         * object
         * 否
         */
        @SerializedName("mini_programs_info")
        private MiniProgramsInfo miniProgramsInfo;

        /**
         * 商户公众号appid
         * appid
         * string[1,32]
         * 否
         */
        @SerializedName("appid")
        private String appid;

        /**
         * 营销馆id
         * hall_id
         * string[1,64]
         * 否
         */
        @SerializedName("hall_id")
        private String hallId;

        /**
         * 可用门店id
         * store_id
         * string[1,64]
         * 否
         */
        @SerializedName("store_id")
        private String storeId;

        /**
         * code展示模式
         * code_display_mode
         * string[1,8]
         * 否
         */
        @SerializedName("code_display_mode")
        private String codeDisplayMode;

    }

    /**
     * 小程序入口
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class MiniProgramsInfo implements Serializable {
        private static final long serialVersionUID = 2998924458569580428L;
        /**
         * 商家小程序appid
         * mini_programs_appid
         * string[1,32]
         * 是
         */
        @SerializedName("mini_programs_appid")
        private String miniProgramsAppid;

        /**
         * 商家小程序path
         * mini_programs_path
         * string[1,128]
         * 是
         */
        @SerializedName("mini_programs_path")
        private String miniProgramsPath;

        /**
         * 入口文案
         * entrance_words
         * string[1,5]
         * 是
         */
        @SerializedName("entrance_words")
        private String entranceWords;

        /**
         * 引导文案
         * guiding_words
         * string[1,6]
         * 否
         */
        @SerializedName("guiding_words")
        private String guidingWords;
    }

    /**
     * 样式信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class DisplayPatternInfo implements Serializable {
        private static final long serialVersionUID = 9207371190836685397L;
        /**
         * 使用须知
         * description
         * string[1,1000]
         * 否
         */
        @SerializedName("description")
        private String description;

        /**
         * 商户logo
         * merchant_logo_url
         * string[1,128]
         * 否
         */
        @SerializedName("merchant_logo_url")
        private String merchantLogoUrl;

        /**
         * 商户名称
         * merchant_name
         * string[1,16]
         * 否
         */
        @SerializedName("merchant_name")
        private String merchantName;

        /**
         * 背景颜色
         * background_color
         * string[1,16]
         * 否
         */
        @SerializedName("background_color")
        private String backgroundColor;

        /**
         * 券详情图片
         * coupon_image_url
         * string[1,128]
         * 否
         */
        @SerializedName("coupon_image_url")
        private String couponImageUrl;
    }


    /**
     * 固定面额满减券使用规则
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class FixedNormalCoupon implements Serializable {
        private static final long serialVersionUID = -6515515122305537108L;
        /**
         * 优惠金额
         * discount_amount
         * int
         * 否
         */
        @SerializedName("discount_amount")
        private Integer discountAmount;

        /**
         * 消费门槛
         * transaction_minimum
         * int
         * 否
         */
        @SerializedName("transaction_minimum")
        private Integer transactionMinimum;

    }

    /**
     * 折扣券使用规则
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class DiscountCoupon implements Serializable {
        private static final long serialVersionUID = -6739190491283862684L;
        /**
         * 折扣比例
         * discount_percent
         * int
         * 否
         */
        @SerializedName("discount_percent")
        private Integer discountPercent;

        /**
         * 消费门槛
         * transaction_minimum
         * int
         * 否
         */
        @SerializedName("transaction_minimum")
        private Integer transactionMinimum;

    }

    /**
     * 换购券使用规则
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class ExchangeCoupon implements Serializable {
        private static final long serialVersionUID = -8239681834729409044L;
        /**
         * 单品换购价
         * exchange_price
         * int
         * 否
         */
        @SerializedName("exchange_price")
        private Integer exchangePrice;

        /**
         * 消费门槛
         * transaction_minimum
         * int
         * 否
         */
        @SerializedName("transaction_minimum")
        private Integer transactionMinimum;


    }

    /**
     * 券可核销时间
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class CouponAvailableTime implements Serializable {
        private static final long serialVersionUID = 9032402444895288640L;
        /**
         * 开始时间
         * available_begin_time
         * string[1,32]
         * 是
         */
        @SerializedName("available_begin_time")
        private String availableBeginTime;

        /**
         * 结束时间
         * available_end_time
         * string[1,32]
         * 是
         */
        @SerializedName("transaction_minimum")
        private String transactionMinimum;

        /**
         * 生效后N天内有效
         * available_day_after_receive
         * int
         * 否
         */
        @SerializedName("available_day_after_receive")
        private Integer availableDayAfterReceive;

        /**
         * 固定周期有效时间段
         * available_week
         * object
         * 否
         */
        @SerializedName("available_week")
        private AvailableWeek availableWeek;

        /**
         * 无规律的有效时间段
         * irregulary_avaliable_time
         * array
         * 否
         */
        @SerializedName("irregulary_avaliable_time")
        private List<IrregularyAvaliableTime> irregularyAvaliableTime;

        /**
         * 领取后N天开始生效
         * wait_days_after_receive
         * int
         * 否
         */
        @SerializedName("wait_days_after_receive")
        private Integer waitDaysAfterReceive;

    }

    /**
     * 固定周期有效时间段
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class AvailableWeek implements Serializable {
        private static final long serialVersionUID = -5234961816985367581L;
        /**
         * 可用星期数
         * week_day
         * array[int]
         * 条件选填
         */
        @SerializedName("week_day")
        private List<Integer> weekDay;

        /**
         * 当天可用时间段
         * available_day_time
         * array
         * 否
         */
        @SerializedName("available_day_time")
        private List<AvailableDayTime> availableDayTime;

    }

    /**
     * 当天可用时间段
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class AvailableDayTime implements Serializable {
        private static final long serialVersionUID = -45866392533126659L;
        /**
         * 当天可用开始时间
         * begin_time
         * int
         * 否
         */
        @SerializedName("begin_time")
        private Integer beginTime;

        /**
         * 当天可用结束时间
         * end_time
         * int
         * 否
         */
        @SerializedName("end_time")
        private Integer endTime;
    }

    /**
     * 无规律的有效时间段
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class IrregularyAvaliableTime implements Serializable {
        private static final long serialVersionUID = -7522745903667624121L;
        /**
         * 开始时间
         * begin_time
         * string[1,32]
         * 否
         */
        @SerializedName("begin_time")
        private String beginTime;

        /**
         * 当天可用结束时间
         * end_time
         * string[1,32]
         * 否
         */
        @SerializedName("end_time")
        private String endTime;
    }


}
