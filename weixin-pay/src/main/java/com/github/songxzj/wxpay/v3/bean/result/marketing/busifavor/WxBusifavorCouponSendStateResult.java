package com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxBusifavorCouponSendStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 5498900895234186651L;


    /**
     * 事件类型
     * event_type
     * string[1,32]
     * 是
     */
    @SerializedName("event_type")
    private String eventType;

    /**
     * 券code
     * coupon_code
     * string[1,32]
     * 是
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
     * 发放时间
     * send_time
     * string[1,32]
     * 是
     */
    @SerializedName("send_time")
    private String sendTime;

    /**
     * 用户标识
     * openid
     * string[1,128]
     * 是
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 用户统一标识
     * unionid
     * string[1,128]
     * 否
     */
    @SerializedName("unionid")
    private String unionid;

    /**
     * 发放渠道
     * send_channel
     * string
     * 是
     */
    @SerializedName("send_channel")
    private String sendChannel;

    /**
     * 发券商户号
     * send_merchant
     * string[1,16]
     * 是
     */
    @SerializedName("send_merchant")
    private String sendMerchant;

    /**
     * 发券附加信息
     * attach_info
     * string
     * 否
     */
    @SerializedName("attach_info")
    private AttachInfo attachInfo;

    /**
     * 发券商户号
     */
    @Data
    @NoArgsConstructor
    public static class AttachInfo implements Serializable {
        private static final long serialVersionUID = 793969929564619907L;

        /**
         * 交易订单编号
         * transaction_id
         * string[1,32]
         * 否
         */
        @SerializedName("transaction_id")
        private String transactionId;

        /**
         * 支付有礼活动编号
         * 营销馆活动ID
         * act_code
         * string[1,32]
         */
        @SerializedName("act_code")
        private String actCode;

        /**
         * 营销馆ID
         * hall_code
         * string[1,32]
         * 否
         */
        @SerializedName("hall_code")
        private String hallCode;

        /**
         * 营销馆所属商户号
         * hall_belong_mch_id
         * int
         * 否
         */
        @SerializedName("hall_belong_mch_id")
        private String hallBelongMchId;

        /**
         * 会员卡ID
         * card_id
         * string[1,32]
         * 否
         */
        @SerializedName("card_id")
        private String cardId;

        /**
         * 会员卡code
         * code
         * string[1,32]
         * 否
         */
        @SerializedName("code")
        private String code;

        /**
         * 会员活动ID
         * activity_id
         * string[1,32]
         * 否
         */
        @SerializedName("activity_id")
        private String activityId;

    }
}
