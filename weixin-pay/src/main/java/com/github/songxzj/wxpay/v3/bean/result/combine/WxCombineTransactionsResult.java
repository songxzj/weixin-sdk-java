package com.github.songxzj.wxpay.v3.bean.result.combine;

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
public class WxCombineTransactionsResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 370781775389076672L;


    /**
     * 预支付交易会话标识
     * prepay_id
     * string[1,64]
     * 是
     */
    @SerializedName("prepay_id")
    private String prepayId;

    /**
     * 支付跳转链接
     * h5_url
     * string[1,512]
     * 是
     */
    @SerializedName("h5_url")
    private String h5Url;

    /**
     * 二维码链接
     * code_url
     * string（512）
     * 是
     */
    @SerializedName("code_url")
    private String codeUrl;

}
