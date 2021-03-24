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
public class WxBusifavorCouponSendResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2816391308915980346L;

    /**
     * 消费卡code
     * card_code
     * string[1,15]
     * 是
     */
    @SerializedName("card_code")
    private String cardCode;

}
