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
public class WxApplymentAuthorizeSubStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 1473687025896489163L;


    /**
     * 申请单状态
     * applyment_state
     * string(32)
     * 是
     */
    @SerializedName("applyment_state")
    private String applymentState;

    /**
     * 小程序码图片
     * qrcode_data
     * string
     * (30000)
     * 否
     */
    @SerializedName("qrcode_data")
    private String qrcodeData;

    /**
     * 驳回参数
     * reject_param
     * string (256)
     * 否
     */
    @SerializedName("reject_param")
    private String rejectParam;

    /**
     * 驳回原因
     * reject_reason
     * string
     * (1024)
     * 否
     */
    @SerializedName("reject_reason")
    private String rejectReason;
}
