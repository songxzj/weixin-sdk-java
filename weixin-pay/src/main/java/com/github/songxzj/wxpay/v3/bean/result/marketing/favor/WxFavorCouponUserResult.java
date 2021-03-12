package com.github.songxzj.wxpay.v3.bean.result.marketing.favor;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxFavorCouponUserResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2641877523251787729L;

    /**
     * 代金券id
     * coupon_id
     * string[1,20]
     * 是
     */
    @SerializedName("coupon_id")
    private String couponId;

}
