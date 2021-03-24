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
public class WxFavorCouponUserStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2303241226110601749L;


    /**
     * 创建批次的商户号
     * stock_creator_mchid
     * string[1,20]
     * 是
     */
    @SerializedName("stock_creator_mchid")
    private String stockCreatorMchid;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 代金券id
     * coupon_id
     * string[1,20]
     * 是
     */
    @SerializedName("coupon_id")
    private String couponId;

    /**
     * 单品优惠特定信息
     * cut_to_message
     * object
     * 否
     */
    @SerializedName("cut_to_message")
    private CutToMessage cutToMessage;

    /**
     * 单品优惠特定信息
     * singleitem_discount_off
     * object
     * 否
     */
    @SerializedName("singleitem_discount_off")
    private CutToMessage singleitemDiscountOff;

    /**
     * 减至优惠特定信息
     * discount_to
     * object
     * 否
     */
    @SerializedName("discount_to")
    private DiscountTo discountTo;

    /**
     * 代金券名称
     * coupon_name
     * string[1,20]
     * 是
     */
    @SerializedName("coupon_name")
    private String couponName;

    /**
     * 代金券状态
     * status
     * string[1,16]
     * 是
     */
    @SerializedName("status")
    private String status;

    /**
     * 使用说明
     * description
     * string[1,3000]
     * 是
     */
    @SerializedName("description")
    private String description;

    /**
     * 领券时间
     * create_time
     * string[1,32]
     * 是
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 券类型
     * coupon_type
     * string[1,16]
     * 是
     */
    @SerializedName("coupon_type")
    private String couponType;

    /**
     * 是否无资金流
     * no_cash
     * bool
     * 是
     */
    @SerializedName("no_cash")
    private Boolean noCash;
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
     * 是否单品优惠
     * singleitem
     * bool
     * 是
     */
    @SerializedName("singleitem")
    private Boolean singleitem;

    /**
     * 满减券信息
     * normal_coupon_information
     * object
     * 否
     */
    @SerializedName("normal_coupon_information")
    private NormalCouponInformation normalCouponInformation;

    /**
     * 已实扣代金券核销信息
     * consume_information
     * object
     * 否
     */
    @SerializedName("consume_information")
    private ConsumeInformation consumeInformation;

    /**
     * 单品优惠特定信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class CutToMessage implements Serializable {
        private static final long serialVersionUID = 550551054089500055L;

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

    /**
     * 减至优惠特定信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class DiscountTo implements Serializable {
        private static final long serialVersionUID = -1186665114277957870L;

        /**
         * 减至后的优惠单价
         * cut_to_price
         * uint64
         * 是
         */
        @SerializedName("cut_to_price")
        private Integer cutToPrice;

        /**
         * 最高价格
         * max_price
         * int64
         * 否
         */
        @SerializedName("max_price")
        private Integer maxPrice;


    }

    /**
     * 满减券信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class NormalCouponInformation implements Serializable {
        private static final long serialVersionUID = -5311645073607562949L;

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
     * 已实扣代金券核销信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class ConsumeInformation implements Serializable {
        private static final long serialVersionUID = 550551054089500055L;

        /**
         * 核销时间
         * consume_time
         * string[1,32]
         * 是
         */
        @SerializedName("consume_time")
        private String consumeTime;

        /**
         * 核销商户号
         * consume_mchid
         * string[1,20]
         * 是
         */
        @SerializedName("consume_mchid")
        private String consumeMchid;


        /**
         * 支付单号
         * transaction_id
         * string[1,32]
         * 是
         */
        @SerializedName("transaction_id")
        private String transactionId;

        /**
         * 单品信息
         * goods_detail
         * array
         * 是
         */
        @SerializedName("goods_detail")
        private List<Goods> goodsDetail;
    }

    /**
     * 单品信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class Goods implements Serializable {
        private static final long serialVersionUID = -7806617141591327144L;

        /**
         * 商品编码
         * goods_id
         * string[1,128]
         * 是
         */
        @SerializedName("goods_id")
        private String goodsId;

        /**
         * 商品数量
         * quantity
         * uint32
         * 是
         */
        @SerializedName("quantity")
        private Integer quantity;

        /**
         * 商品价格
         * price
         * uint64
         * 是
         */
        @SerializedName("price")
        private Integer price;

        /**
         * 优惠金额
         * discount_amount
         * uint64
         * 是
         */
        @SerializedName("discount_amount")
        private Integer discountAmount;
    }


}
