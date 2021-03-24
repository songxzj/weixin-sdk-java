package com.github.songxzj.wxpay.v3.bean.result.applyment;

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
public class WxApplymentSubResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 1077154716465200038L;

    /**
     * 微信支付申请单号
     * applyment_id
     * uint64
     * 是
     */
    @SerializedName("applyment_id")
    private String applymentId;


}
