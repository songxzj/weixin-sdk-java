package com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayGiftActivityMerchantDeleteResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -7293633215082710979L;

    /**
     * 活动id
     * activity_id
     * string[1,20]
     * 是
     */
    @SerializedName("activity_id")
    private String activityId;

    /**
     * 删除时间
     * delete_time
     * string[1,32]
     * 否
     */
    @SerializedName("delete_time")
    private String deleteTime;


}
