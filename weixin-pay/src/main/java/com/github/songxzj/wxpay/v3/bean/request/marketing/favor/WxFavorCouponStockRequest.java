package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorCouponStockResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.12.27
 * 创建代金券批次API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_1.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxFavorCouponStockRequest extends BaseWxPayV3Request<WxFavorCouponStockResult> {
    private static final long serialVersionUID = 8690508842043573020L;

    /**
     * 批次名称
     * stock_name
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("stock_name")
    private String stockName;

    /**
     * 批次备注
     * comment
     * string[1,60]
     * 否
     */
    @SerializedName("comment")
    private String comment;

    /**
     * 归属商户号
     * belong_merchant
     * string[1,20]
     * 是
     */
    //@Required
    @SerializedName("belong_merchant")
    private String belongMerchant;

    /**
     * 可用时间-开始时间
     * available_begin_time
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("available_begin_time")
    private String availableBeginTime;

    /**
     * 可用时间-结束时间
     * available_end_time
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("available_end_time")
    private String availableEndTime;

    /**
     * 发放规则
     * stock_use_rule
     * object
     * 是
     */
    @Required
    @SerializedName("stock_use_rule")
    private StockUseRule stockUseRule;

    /**
     * 样式设置
     * pattern_info
     * object
     * 否
     */
    @SerializedName("pattern_info")
    private PatternInfo patternInfo;

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
     * 营销经费
     * no_cash
     * bool
     * 是
     */
    @Required
    @SerializedName("no_cash")
    private Boolean noCash;

    /**
     * 批次类型
     * stock_type
     * string[1,16]
     * 是
     */
    @Required
    @SerializedName("stock_type")
    private String stockType;

    /**
     * 商户单据号
     * out_request_no
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("out_request_no")
    private String outRequestNo;

    /**
     * 扩展属性
     * ext_info
     * string[1,128]
     * 否
     */
    @SerializedName("ext_info")
    private String extInfo;

    @Override
    public String routing() {
        return "/v3/marketing/favor/coupon-stocks";
    }

    @Override
    public Class<WxFavorCouponStockResult> getResultClass() {
        return WxFavorCouponStockResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.stockUseRule != null) {
            this.stockUseRule.checkConstraints();
        }
        if (this.patternInfo != null) {
            this.patternInfo.checkConstraints();
        }
        if (this.couponUseRule != null) {
            this.couponUseRule.checkConstraints();
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
    public static class StockUseRule extends BaseV3Inner {
        private static final long serialVersionUID = -4042172080290440934L;

        /**
         * 发放总上限
         * max_coupons
         * uint64
         * 是
         */
        @Required
        @SerializedName("max_coupons")
        private Integer maxCoupons;

        /**
         * 总预算
         * max_amount
         * uint64
         * 是
         */
        @Required
        @SerializedName("max_amount")
        private Integer maxAmount;

        /**
         * 单天预算发放上限
         * max_amount_by_day
         * uint64
         * 否
         */
        @SerializedName("max_amount_by_day")
        private Integer maxAmountByDay;

        /**
         * 单个用户可领个数
         * max_coupons_per_user
         * uint32
         * 是
         */
        @Required
        @SerializedName("max_coupons_per_user")
        private Integer maxCouponsPerUser;

        /**
         * 是否开启自然人限制
         * natural_person_limit
         * bool
         * 是
         */
        @Required
        @SerializedName("natural_person_limit")
        private Boolean naturalPersonLimit;

        /**
         * 是否开启防刷拦截
         * prevent_api_abuse
         * bool
         * 是
         */
        @Required
        @SerializedName("prevent_api_abuse")
        private Boolean preventApiAbuse;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (!(this.maxCoupons >= 5 && this.maxCoupons <= 10000000)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "最大发券数最少5个，最多1000万个");
            }
            if (this.maxAmountByDay != null && this.maxAmountByDay > this.maxAmount) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "单天预算发放上限不能大于总预算");
            }
            if (this.maxCouponsPerUser > this.maxCoupons) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "单个用户可领个数不能大于发放总个数");
            }
            if (!(this.maxCouponsPerUser >= 1 && this.maxCoupons <= 60)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "单个用户可领个数最少为1个，最多为60个");
            }
        }
    }


    /**
     * 样式设置
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PatternInfo extends BaseV3Inner {
        private static final long serialVersionUID = -6765694534509852805L;

        /**
         * 使用说明
         * description
         * string[1,3000]
         * 是
         */
        @Required
        @SerializedName("description")
        private String description;

        /**
         * 商户logo
         * merchant_logo
         * string[1,128]
         * 否
         */
        @SerializedName("merchant_logo")
        private String merchantLogo;

        /**
         * 品牌名称
         * merchant_name
         * string[1,128]
         * 否
         */
        @SerializedName("merchant_name")
        private String merchantName;

        /**
         * 背景颜色
         * background_color
         * string[1,15]
         * 否
         */
        @SerializedName("background_color")
        private String backgroundColor;

        /**
         * 券详情图片
         * coupon_image
         * string[1,128]
         * 否
         */
        @SerializedName("coupon_image")
        private String couponImage;


        @Override
        public void checkConstraints() throws WxErrorException {
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
        private static final long serialVersionUID = -3917487863161561231L;


        /**
         * 券生效时间
         * coupon_available_time
         * object
         * 否
         */
        @SerializedName("coupon_available_time")
        private CouponAvailableTime couponAvailableTime;

        /**
         * 固定面额满减券使用规则
         * fixed_normal_coupon
         * object
         * 否
         */
        @SerializedName("fixed_normal_coupon")
        private FixedNormalCoupon fixedNormalCoupon;

        /**
         * 订单优惠标记
         * goods_tag
         * array
         * 否
         */
        @SerializedName("goods_tag")
        private List<String> goodsTag;

        /**
         * 指定付款方式
         * limit_pay
         * array[1,1]
         * 否
         */
        @SerializedName("limit_pay")
        private List<String> limitPay;

        /**
         * 指定银行卡BIN
         * limit_card
         * object
         * 否
         */
        @SerializedName("limit_card")
        private LimitCard limitCard;

        /**
         * 支付方式
         * trade_type
         * array
         * 否
         */
        @SerializedName("trade_type")
        private List<String> tradeType;

        /**
         * 是否可叠加其他优惠
         * combine_use
         * bool
         * 否
         */
        @SerializedName("combine_use")
        private Boolean combineUse;

        /**
         * 可核销商品编码
         * available_items
         * array
         * 否
         */
        @SerializedName("available_items")
        private List<String> availableItems;

        /**
         * 不可核销商品编码
         * unavailable_items
         * array
         * 否
         */
        @SerializedName("unavailable_items")
        private List<String> unavailableItems;

        /**
         * 可用商户号
         * available_merchants
         * array
         * 是
         */
        @Required
        @SerializedName("available_merchants")
        private List<String> availableMerchants;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.couponAvailableTime != null) {
                this.couponAvailableTime.checkConstraints();
            }
            if (this.fixedNormalCoupon != null) {
                this.fixedNormalCoupon.checkConstraints();
            }
            if (this.goodsTag != null && goodsTag.size() > 50) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "订单优惠标记最多允许录入50个");
            }
            if (this.limitCard != null) {
                this.limitCard.checkConstraints();
            }
            if (this.availableItems != null && availableItems.size() > 50) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "可核销商品编码条目个数限制为50个");
            }
            if (this.unavailableItems != null && unavailableItems.size() > 50) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "可核销商品编码条目个数限制为50个");
            }
            if (this.limitPay != null && limitPay.size() > 1) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "指定付款方式限制为1个");
            }
        }
    }

    /**
     * 券生效时间
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CouponAvailableTime extends BaseV3Inner {
        private static final long serialVersionUID = -761302505457726792L;

        /**
         * 固定时间段可用
         * fix_available_time
         * object
         * 否
         */
        @SerializedName("fix_available_time")
        private FixAvailableTime fixAvailableTime;

        /**
         * 领取后N天有效
         * second_day_available
         * bool
         * 否
         */
        @SerializedName("second_day_available")
        private Boolean secondDayAvailable;

        /**
         * 领取后有效时间
         * available_time_after_receive
         * uint32
         * 否
         */
        @SerializedName("available_time_after_receive")
        private Integer availableTimeAfterReceive;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.fixAvailableTime != null) {
                this.fixAvailableTime.checkConstraints();
            }
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
        private static final long serialVersionUID = -8037208471241409307L;

        /**
         * 面额
         * coupon_amount
         * uint64
         * 是
         */
        @Required
        @SerializedName("coupon_amount")
        private Integer couponAmount;

        /**
         * 门槛
         * transaction_minimum
         * uint64
         * 是
         */
        @Required
        @SerializedName("transaction_minimum")
        private Integer transactionMinimum;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (!(this.couponAmount > 1 && this.couponAmount <= 100000)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "固定面额满减券面额必须大于1分且小于等于1000元");
            }
            if (this.transactionMinimum <= this.couponAmount) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "使用门槛必须大于优惠金额");
            }
        }
    }

    /**
     * 指定银行卡BIN
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LimitCard extends BaseV3Inner {
        private static final long serialVersionUID = -426870158914447931L;

        /**
         * 银行卡名称
         * name
         * string[1,4]
         * 否
         */
        @SerializedName("name")
        private String name;

        /**
         * 指定卡BIN
         * bin
         * array
         * 否
         */
        @SerializedName("bin")
        private List<String> bin;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.bin != null && this.bin.size() > 10) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "指定卡BIN条目个数限制为10个");
            }
        }
    }


    /**
     * 固定时间段可用
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FixAvailableTime extends BaseV3Inner {
        private static final long serialVersionUID = -3422160924465446045L;

        /**
         * 可用星期数
         * available_week_day
         * uint32
         * 否
         */
        @SerializedName("available_week_day")
        private Integer availableWeekDay;

        /**
         * 当天开始时间
         * begin_time
         * uint32
         * 否
         */
        @SerializedName("begin_time")
        private Integer beginTime;

        /**
         * 当天结束时间
         * end_time
         * uint32
         * 否
         */
        @SerializedName("end_time")
        private Integer endTime;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


}
