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
public class WxBusifavorCouponUseResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -236280810458174797L;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 用户标识
     * openid
     * string[1,128]
     * 是
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 系统核销券成功的时间
     * wechatpay_use_time
     * string[1,32]
     * 是
     */
    @SerializedName("wechatpay_use_time")
    private String wechatpayUseTime;
}
