package com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayGiftActivityTerminateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -6937037621779421678L;
    /**
     * 活动id
     * activity_id
     * string[1,20]
     * 是
     */
    @SerializedName("activity_id")
    private String activityId;

    /**
     * 生效时间
     * terminate_time
     * string[1,32]
     * 是
     */
    @SerializedName("terminate_time")
    private String terminateTime;


}
