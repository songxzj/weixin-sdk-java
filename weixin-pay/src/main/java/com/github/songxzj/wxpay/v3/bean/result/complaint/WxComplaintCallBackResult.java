package com.github.songxzj.wxpay.v3.bean.result.complaint;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

/**
 * version:2021.04.01
 * 投诉通知回调API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_2_16.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxComplaintCallBackResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2754697633239875759L;

    /**
     * 投诉单号
     * complaint_id
     * string[1,64]
     * 是
     */
    @SerializedName("complaint_id")
    private String complaintId;

    /**
     * 动作类型
     * action_type
     * string[1, 64]
     * 是
     */
    @SerializedName("action_type")
    private String actionType;
}
