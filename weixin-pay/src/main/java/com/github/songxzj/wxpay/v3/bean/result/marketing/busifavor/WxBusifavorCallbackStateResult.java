package com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor;

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
public class WxBusifavorCallbackStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 7490670190496798L;


    /**
     * 通知URL地址
     * notify_url
     * string[10,256]
     * 是
     */
    @SerializedName("notify_url")
    private String notifyUrl;

    /**
     * 商户号
     * mchid
     * string[8,15]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;
}
