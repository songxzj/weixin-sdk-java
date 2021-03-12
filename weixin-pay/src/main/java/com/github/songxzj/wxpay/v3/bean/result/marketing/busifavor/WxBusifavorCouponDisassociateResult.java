package com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxBusifavorCouponDisassociateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 6518767558249382834L;

    /**
     * 取消关联成功时间
     * wechatpay_disassociate_time
     * string[1,32]
     * 是
     */
    @SerializedName("wechatpay_disassociate_time")
    private String wechatpay_disassociate_time;

}
