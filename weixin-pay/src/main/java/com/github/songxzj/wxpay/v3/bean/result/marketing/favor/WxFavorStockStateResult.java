package com.github.songxzj.wxpay.v3.bean.result.marketing.favor;

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
public class WxFavorStockStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -3245092779928714862L;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 创建批次的商户号
     * stock_creator_mchid
     * string[1,20]
     * 是
     */
    @SerializedName("stock_creator_mchid")
    private String stockCreatorMchid;

    /**
     * 批次名称
     * stock_name
     * string[1,20]
     * 是
     */
    @SerializedName("stock_name")
    private String stockName;

    /**
     * 批次状态
     * status
     * string[1,12]
     * 是
     */
    @SerializedName("status")
    private String status;

    /**
     * 创建时间
     * create_time
     * string[1,32]
     * 是
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 使用说明
     * description
     * string[1,3000]
     * 是
     */
    @SerializedName("description")
    private String description;

    /**
     * 满减券批次使用规则
     * stock_use_rule
     * object
     * 否
     */
    @SerializedName("stock_use_rule")
    private StockUseRule stockUseRule;

    /**
     * 可用开始时间
     * available_begin_time
     * string[1,32]
     * 是
     */
    @SerializedName("available_begin_time")
    private String availableBeginTime;

    /**
     * 可用结束时间
     * available_end_time
     * string[1,32]
     * 是
     */
    @SerializedName("available_end_time")
    private String availableEndTime;

    /**
     * 已发券数量
     * distributed_coupons
     * uint32
     * 是
     */
    @SerializedName("distributed_coupons")
    private Integer distributedCoupons;

    /**
     * 是否无资金流
     * no_cash
     * bool
     * 是
     */
    @SerializedName("no_cash")
    private Boolean noCash;

    /**
     * 激活批次的时间
     * start_time
     * string[1,32]
     * 否
     */
    @SerializedName("start_time")
    private String startTime;

    /**
     * 终止批次的时间
     * stop_time
     * string[1,32]
     * 否
     */
    @SerializedName("stop_time")
    private String stopTime;

    /**
     * 单品优惠特定信息
     * cut_to_message
     * object
     * 否
     */
    @SerializedName("cut_to_message")
    private CutToMessage cutToMessage;

    /**
     * 是否单品优惠
     * singleitem
     * bool
     * 是
     */
    @SerializedName("singleitem")
    private Boolean singleitem;

    /**
     * 次类型
     * stock_type
     * string[1,16]
     * 是
     */
    @SerializedName("stock_type")
    private String stockType;


    /**
     * 满减券批次使用规则
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class StockUseRule implements Serializable {
        private static final long serialVersionUID = -9128962197745232550L;

        /**
         * 发放总上限
         * max_coupons
         * uint64
         * 是
         */
        @SerializedName("max_coupons")
        private Integer maxCoupons;

        /**
         * 总预算
         * max_amount
         * uint64
         * 是
         */
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
         * 固定面额批次特定信息
         * fixed_normal_coupon
         * object
         * 否
         */
        @SerializedName("fixed_normal_coupon")
        private FixedNormalCoupon fixedNormalCoupon;

        /**
         * 单个用户可领个数
         * max_coupons_per_user
         * uint32
         * 是
         */
        @SerializedName("max_coupons_per_user")
        private Integer maxCouponsPerUser;

        /**
         * 券类型
         * coupon_type
         * string[1,16]
         * 否
         */
        @SerializedName("coupon_type")
        private String couponType;

        /**
         * 订单优惠标记
         * goods_tag
         * array
         * 否
         */
        @SerializedName("goods_tag")
        private List<String> goodsTag;

        /**
         * 支付方式
         * trade_type
         * array
         * 是
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
    }

    /**
     * 固定面额批次特定信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class FixedNormalCoupon implements Serializable {
        private static final long serialVersionUID = 8332673421708430553L;

        /**
         * 面额
         * coupon_amount
         * uint64
         * 是
         */
        @SerializedName("coupon_amount")
        private Integer couponAmount;

        /**
         * 门槛
         * transaction_minimum
         * uint64
         * 是
         */
        @SerializedName("transaction_minimum")
        private Integer transactionMinimum;
    }

    /**
     * 单品优惠特定信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class CutToMessage implements Serializable {
        private static final long serialVersionUID = 6017921618052748498L;

        /**
         * 可用优惠的商品最高单价
         * single_price_max
         * uint64
         * 是
         */
        @SerializedName("single_price_max")
        private Integer singlePriceMax;

        /**
         * 减至后的优惠单价
         * cut_to_price
         * uint64
         * 是
         */
        @SerializedName("cut_to_price")
        private Integer cutToPrice;
    }


}
