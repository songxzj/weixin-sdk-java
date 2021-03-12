package com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxBusifavorStockBudgetResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -6792495151320843646L;

    /**
     * 批次当前最大发放个数
     * max_coupons
     * int
     * 是
     */
    @SerializedName("max_coupons")
    private Integer maxCoupons;

    /**
     * 当前单天发放上限个数
     * max_coupons_by_day
     * int
     * 否
     */
    @SerializedName("max_coupons_by_day")
    private Integer maxCouponsByDay;

}
