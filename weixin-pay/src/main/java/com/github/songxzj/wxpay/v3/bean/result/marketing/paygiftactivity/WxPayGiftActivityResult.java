package com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayGiftActivityResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -4034674124232385202L;

    /**
     * 活动id
     * activity_id
     * string[1,20]
     * 是
     */
    @SerializedName("activity_id")
    private String activityId;

    /**
     * 创建时间
     * create_time
     * string[1,32]
     * 是
     */
    @SerializedName("create_time")
    private String createTime;


}
