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
public class WxBusifavorCouponDeactivateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -1898325629229948021L;

    /**
     * 券成功失效的时间
     * wechatpay_deactivate_time
     * string[1,32]
     * 是
     */
    @SerializedName("wechatpay_deactivate_time")
    private String wechatpayDeactivateTime;

}
