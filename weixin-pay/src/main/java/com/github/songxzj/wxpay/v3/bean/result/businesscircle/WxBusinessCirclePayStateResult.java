package com.github.songxzj.wxpay.v3.bean.result.businesscircle;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * version:2020.07.01
 * 商圈支付结果
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_6_1.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxBusinessCirclePayStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 8641976169565903913L;


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
     * 交易完成时间
     * time_end
     * string[1,16]
     * 是
     */
    @SerializedName("time_end")
    private String timeEnd;

    /**
     * 金额
     * amount
     * int
     * 是
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 微信支付订单号
     * transaction_id
     * string[1,32]
     * 是
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 手动提交积分标记
     * commit_tag
     * string[1,32]
     * 否
     */
    @SerializedName("commit_tag")
    private String commitTag;
}
