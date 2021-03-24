package com.github.songxzj.wxpay.v3.bean.result.paypartner;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayPartnerTransactionsResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 373277517176703694L;


    /**
     * 预支付交易会话标识(APP, JSAPI)
     * prepay_id
     * string(64)
     * 是
     */
    @SerializedName("prepay_id")
    private String prepayId;

    /**
     * 二维码链接(NATIVE)
     * code_url
     * string[1,512]
     * 是
     */
    @SerializedName("code_url")
    private String codeUrl;

    /**
     * 支付跳转链接(H5)
     * h5_url
     * string[1,512]
     * 是
     */
    @SerializedName("h5_url")
    private String h5Url;
}
