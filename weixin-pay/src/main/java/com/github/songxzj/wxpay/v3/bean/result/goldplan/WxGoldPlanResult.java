package com.github.songxzj.wxpay.v3.bean.result.goldplan;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxGoldPlanResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -6467090922010448447L;

    /**
     * 特约商户号
     * sub_mchid
     * string[1,32]
     * 是
     */
    @SerializedName("sub_mchid")
    private String subMchid;
}
