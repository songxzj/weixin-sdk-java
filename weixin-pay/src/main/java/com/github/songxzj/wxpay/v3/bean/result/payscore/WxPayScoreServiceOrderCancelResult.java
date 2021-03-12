package com.github.songxzj.wxpay.v3.bean.result.payscore;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayScoreServiceOrderCancelResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 6889780210037412887L;


    /**
     * 应用ID
     * appid
     * string[1,32]
     * 是
     */
    @SerializedName("appid")
    private String appid;

    /**
     * 商户号
     * mchid
     * string[1,32]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 商户服务订单号
     * out_order_no
     * string[1,32]
     * 是
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 服务ID
     * service_id
     * string[1,32]
     * 是
     */
    @SerializedName("service_id")
    private String serviceId;

    /**
     * 微信支付服务订单号
     * order_id
     * string[1,64]
     * 是
     */
    @SerializedName("order_id")
    private String orderId;

}