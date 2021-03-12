package com.github.songxzj.wxpay.v3.bean.result.marketing.favor;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxFavorStockResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2724206757377416945L;

    /**
     * 生效时间
     * start_time
     * string[1,32]
     * 是
     */
    @SerializedName("start_time")
    private String startTime;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @SerializedName("stock_id")
    private String stockId;
}
