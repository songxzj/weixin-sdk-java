package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorStockResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2021.12.09
 * 创建商家券API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter9_2_1.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorStockRequest extends BaseWxPayV3Request<WxBusifavorStockResult> {
    private static final long serialVersionUID = 3829619905061679530L;

    /**
     * 商家券批次名称
     * stock_name
     * string[1,21]
     * 是
     */
    @Required
    @SerializedName("stock_name")
    private String stockName;

    /**
     * 批次归属商户号
     * belong_merchant
     * string[8,15]
     * 是
     */
    @Required
    @SerializedName("belong_merchant")
    private String belongMerchant;

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
    @Required
    @SerializedName("goods_name")
    private String goodsName;

    /**
     * 批次类型
     * stock_type
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("stock_type")
    private String stockType;

    /**
     * 核销规则
     * coupon_use_rule
     * object
     * 是
     */
    @Required
    @SerializedName("coupon_use_rule")
    private CouponUseRule couponUseRule;

    /**
     * 发放规则
     * stock_send_rule
     * object
     * 是
     */
    @Required
    @SerializedName("stock_send_rule")
    private StockSendRule stockSendRule;

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
     * 自定义入口
     * custom_entrance
     * object
     * 否
     */
    @SerializedName("custom_entrance")
    private CustomEntrance customEntrance;

    /**
     * 样式信息
     * display_pattern_info
     * object
     * 否
     */
    @SerializedName("display_pattern_info")
    private DisplayPatternInfo displayPatternInfo;

    /**
     * 券code模式
     * coupon_code_mode
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("coupon_code_mode")
    private String couponCodeMode;

    /**
     * 事件通知配置
     * notify_config
     * object
     * 否
     */
    @SerializedName("notify_config")
    private NotifyConfig notifyConfig;


    @Override
    public String routing() {
        return "/v3/marketing/busifavor/stocks";
    }

    @Override
    public Class<WxBusifavorStockResult> getResultClass() {
        return WxBusifavorStockResult.class;
    }


    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.couponUseRule != null) {
            this.couponUseRule.checkConstraints();
        }
        if (this.stockSendRule != null) {
            this.stockSendRule.checkConstraints();
        }
        if (this.customEntrance != null) {
            this.customEntrance.checkConstraints();
        }
        if (this.displayPatternInfo != null) {
            this.displayPatternInfo.checkConstraints();
        }
        if (this.notifyConfig != null) {
            this.notifyConfig.checkConstraints();
        }
    }


    /**
     * 核销规则
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CouponUseRule extends BaseV3Inner {
        private static final long serialVersionUID = -788248167358309814L;

        /**
         * 券可核销时间
         * coupon_available_time
         * object
         * 是
         */
        @Required
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
        @Required
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

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.couponAvailableTime != null) {
                this.couponAvailableTime.checkConstraints();
            }
            if (this.fixedNormalCoupon != null) {
                this.fixedNormalCoupon.checkConstraints();
            }
            if (this.discountCoupon != null) {
                this.discountCoupon.checkConstraints();
            }
            if (this.exchangeCoupon != null) {
                this.exchangeCoupon.checkConstraints();
            }
        }
    }


    /**
     * 发放规则
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StockSendRule extends BaseV3Inner {
        private static final long serialVersionUID = -2518578213385819278L;

        /**
         * 批次最大发放个数
         * max_coupons
         * int
         * 是
         */
        @Required
        @SerializedName("max_coupons")
        private Integer maxCoupons;

        /**
         * 用户最大可领个数
         * max_coupons_per_user
         * int
         * 是
         */
        @Required
        @SerializedName("max_coupons_per_user")
        private Integer maxCouponsPerUser;

        /**
         * 单天发放上限个数
         * max_coupons_by_day
         * int
         * 否
         */
        @SerializedName("max_coupons_by_day")
        private Integer maxCouponsByDay;

        /**
         * 是否开启自然人限制
         * natural_person_limit
         * bool
         * 否
         */
        @SerializedName("natural_person_limit")
        private Boolean naturalPersonLimit;

        /**
         * 可疑账号拦截
         * prevent_api_abuse
         * bool
         * 否
         */
        @SerializedName("prevent_api_abuse")
        private Boolean preventApiAbuse;

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

        @Override
        public void checkConstraints() throws WxErrorException {
            if (!(this.maxCoupons >= 1 && this.maxCoupons <= 1000000000)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "批次最大可发放个数限制 取值范围 1 ≤ value ≤ 1000000000");
            }
            if (!(this.maxCouponsPerUser <= 100)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "用户可领个数，每个用户最多100张券");
            }
            if (this.maxCouponsByDay != null && !(this.maxCouponsByDay >= 1 && this.maxCouponsByDay <= 1000000000)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "单天发放上限个数 取值范围 1 ≤ value ≤ 1000000000");
            }
        }
    }

    /**
     * 自定义入口
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomEntrance extends BaseV3Inner {
        private static final long serialVersionUID = 2693439356724952554L;

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


        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.miniProgramsInfo != null) {
                this.miniProgramsInfo.checkConstraints();
            }
        }
    }

    /**
     * 小程序入口
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MiniProgramsInfo extends BaseV3Inner {
        private static final long serialVersionUID = 443281826416179879L;

        /**
         * 商家小程序appid
         * mini_programs_appid
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("mini_programs_appid")
        private String miniProgramsAppid;

        /**
         * 商家小程序path
         * mini_programs_path
         * string[1,128]
         * 是
         */
        @Required
        @SerializedName("mini_programs_path")
        private String miniProgramsPath;

        /**
         * 入口文案
         * entrance_words
         * string[1,5]
         * 是
         */
        @Required
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


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 样式信息
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DisplayPatternInfo extends BaseV3Inner {
        private static final long serialVersionUID = 6009966906453328730L;

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

        /**
         * 视频号相关信息
         * finder_info
         * object
         * 否
         */
        @SerializedName("finder_info")
        private FinderInfo finderInfo;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 视频号相关信息
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FinderInfo extends BaseV3Inner {
        private static final long serialVersionUID = 6824164997182074098L;


        /**
         * 视频号ID
         * finder_id
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("finder_id")
        private String finderId;

        /**
         * 视频号视频ID
         * finder_video_id
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("finder_video_id")
        private String finderVideoId;


        /**
         * 视频号封面图
         * finder_video_cover_image_url
         * string[1,256]
         * 是
         */
        @Required
        @SerializedName("finder_video_cover_image_url")
        private String finderVideoCoverImageUrl;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 事件通知配置
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NotifyConfig extends BaseV3Inner {
        private static final long serialVersionUID = 3135495673286753710L;

        /**
         * 事件通知appid
         * notify_appid
         * string[1,64]
         * 否
         */
        @SerializedName("notify_appid")
        private String notifyAppid;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 固定面额满减券使用规则
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FixedNormalCoupon extends BaseV3Inner {
        private static final long serialVersionUID = -4637334366094829351L;

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

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.discountAmount != null && !(this.discountAmount >= 1 && this.discountAmount <= 10000000)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "优惠金额 取值范围 1 ≤ value ≤ 10000000");
            }
            if (this.transactionMinimum != null && !(this.transactionMinimum >= 1 && this.transactionMinimum <= 10000000)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "消费门槛 取值范围 1 ≤ value ≤ 10000000");
            }
        }
    }

    /**
     * 折扣券使用规则
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DiscountCoupon extends BaseV3Inner {
        private static final long serialVersionUID = -4637334366094829351L;

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

        @Override
        public void checkConstraints() throws WxErrorException {

            if (this.transactionMinimum != null && !(this.transactionMinimum >= 1 && this.transactionMinimum <= 10000000)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "消费门槛 取值范围 1 ≤ value ≤ 10000000");
            }
        }
    }

    /**
     * 换购券使用规则
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExchangeCoupon extends BaseV3Inner {
        private static final long serialVersionUID = -763997274244778853L;


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

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.exchangePrice != null && !(this.exchangePrice >= 1 && this.exchangePrice <= 10000000)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "单品换购价 取值范围 1 ≤ value ≤ 10000000");
            }
            if (this.transactionMinimum != null && !(this.transactionMinimum >= 1 && this.transactionMinimum <= 10000000)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "消费门槛 取值范围 1 ≤ value ≤ 10000000");
            }
        }
    }

    /**
     * 券可核销时间
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CouponAvailableTime extends BaseV3Inner {
        private static final long serialVersionUID = 6192200128364349365L;

        /**
         * 开始时间
         * available_begin_time
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("available_begin_time")
        private String availableBeginTime;

        /**
         * 结束时间
         * available_end_time
         * string[1,32]
         * 是
         */
        @Required
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


        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.availableWeek != null) {
                this.availableWeek.checkConstraints();
            }
            if (this.irregularyAvaliableTime != null) {
                for (IrregularyAvaliableTime time : this.irregularyAvaliableTime) {
                    time.checkConstraints();
                }
            }
        }
    }

    /**
     * 固定周期有效时间段
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AvailableWeek extends BaseV3Inner {
        private static final long serialVersionUID = 8193327155348647169L;

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

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.availableDayTime != null) {
                if (this.weekDay == null) {
                    throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "当填写available_day_time时，week_day必填");
                }
                for (AvailableDayTime time : this.availableDayTime) {
                    time.checkConstraints();
                }
            }
        }
    }

    /**
     * 当天可用时间段
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AvailableDayTime extends BaseV3Inner {
        private static final long serialVersionUID = 7583880133966538298L;

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

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IrregularyAvaliableTime extends BaseV3Inner {
        private static final long serialVersionUID = 7427041194576661629L;

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

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

}
