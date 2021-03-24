package com.github.songxzj.wxpay.v3.bean.result.marketing.favor;

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
public class WxFavorCallbackResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -999365413451475997L;

    /**
     * 修改时间
     * update_time
     * string[1,32]
     * 是
     */
    @SerializedName("update_time")
    private String updateTime;

    /**
     * 通知地址
     * notify_url
     * string[1,256]
     * 是
     */
    @SerializedName("notify_url")
    private String notifyUrl;
}
