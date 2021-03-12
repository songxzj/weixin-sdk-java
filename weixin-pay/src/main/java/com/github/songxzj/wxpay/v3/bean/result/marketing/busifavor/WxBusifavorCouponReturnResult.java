package com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxBusifavorCouponReturnResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 3799048851738104801L;

    /**
     * 微信退券成功的时间
     * wechatpay_return_time
     * string[1,32]
     * 是
     */
    @SerializedName("wechatpay_return_time")
    private String wechatpayReturnTime;

}
