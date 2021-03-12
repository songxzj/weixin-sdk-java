package com.github.songxzj.wxpay.v3.bean.result.complaint;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxComplaintNotificationResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 4887866984235431573L;

    /**
     * 商户号
     * mchid
     * string[1,64]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 通知地址
     * url
     * string[1,255]
     * 是
     */
    @SerializedName("url")
    private String url;
}
