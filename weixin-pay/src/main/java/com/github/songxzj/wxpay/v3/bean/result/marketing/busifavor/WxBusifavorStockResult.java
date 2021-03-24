package com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor;

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
public class WxBusifavorStockResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 2593040125778356972L;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 创建时间
     * create_time
     * string[1,32]
     * 是
     */
    @SerializedName("create_time")
    private String createTime;
}
