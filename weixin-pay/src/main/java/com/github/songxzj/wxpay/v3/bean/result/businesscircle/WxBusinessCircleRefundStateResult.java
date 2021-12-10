package com.github.songxzj.wxpay.v3.bean.result.businesscircle;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * version:2020.08.03
 * 商圈退款成功
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_6_3.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxBusinessCircleRefundStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -443212636009757477L;

    /**
     * 商户号
     * mchid
     * string[1,32]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 商圈商户名称
     * merchant_name
     * string[1,128]
     * 是
     */
    @SerializedName("merchant_name")
    private String merchantName;

    /**
     * 门店名称
     * shop_name
     * string[1,32]
     * 是
     */
    @SerializedName("shop_name")
    private String shopName;

    /**
     * 门店编号
     * shop_number
     * string[1,128]
     * 是
     */
    @SerializedName("shop_number")
    private String shopNumber;

    /**
     * 小程序APPID
     * appid
     * string[1,32]
     * 是
     */
    @SerializedName("appid")
    private String appid;

    /**
     * 用户标识
     * openid
     * string[1,128]
     * 是
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 退款完成时间
     * refund_time
     * string[1,32]
     * 是
     */
    @SerializedName("refund_time")
    private String refundTime;

    /**
     * 消费金额
     * pay_amount
     * int64
     * 是
     */
    @SerializedName("pay_amount")
    private Integer payAmount;

    /**
     * 退款金额
     * refund_amount
     * int64
     * 是
     */
    @SerializedName("refund_amount")
    private Integer refundAmount;

    /**
     * 微信支付订单号
     * transaction_id
     * string[1,32]
     * 是
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 微信支付退款单号
     * refund_id
     * string[1,32]
     * 是
     */
    @SerializedName("refund_id")
    private String refundId;
}
