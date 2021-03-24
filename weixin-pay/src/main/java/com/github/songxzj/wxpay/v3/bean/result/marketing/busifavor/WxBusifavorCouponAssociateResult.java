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
public class WxBusifavorCouponAssociateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -1122472242848335644L;

    /**
     * 关联成功时间
     * wechatpay_associate_time
     * string[1,32]
     * 是
     */
    @SerializedName("wechatpay_associate_time")
    private String wechatpayAssociateTime;

}
