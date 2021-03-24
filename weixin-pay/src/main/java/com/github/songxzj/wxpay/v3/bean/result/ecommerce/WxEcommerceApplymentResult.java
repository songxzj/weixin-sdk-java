package com.github.songxzj.wxpay.v3.bean.result.ecommerce;

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
public class WxEcommerceApplymentResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -3234763348949899139L;

    /**
     * 微信支付申请单号
     * applyment_id
     * uint64
     * 是
     */
    @SerializedName("applyment_id")
    private String applymentId;

    /**
     * 业务申请编号
     * out_request_no
     * string[1,124]
     * 是
     */
    @SerializedName("out_request_no")
    private String outRequestNo;
}
