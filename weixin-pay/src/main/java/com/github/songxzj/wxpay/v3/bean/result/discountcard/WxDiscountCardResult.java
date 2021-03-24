package com.github.songxzj.wxpay.v3.bean.result.discountcard;

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
public class WxDiscountCardResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 1061593896127390051L;

    /**
     * 预领卡请求token
     * prepare_card_token
     * string[1,256]
     * 是
     */
    @SerializedName("prepare_card_token")
    private String prepareCardToken;
}
