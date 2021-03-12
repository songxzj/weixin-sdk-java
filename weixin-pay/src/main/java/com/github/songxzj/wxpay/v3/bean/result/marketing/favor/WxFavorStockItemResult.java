package com.github.songxzj.wxpay.v3.bean.result.marketing.favor;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxFavorStockItemResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -3741314566670358595L;

    /**
     * 分页页码
     * offset
     * uint32
     * 是
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * 分页大小
     * limit
     * uint32
     * 是
     */
    @SerializedName("limit")
    private Integer limit;

    /**
     * 批次总数
     * total_count
     * uint32
     * 是
     */
    @SerializedName("total_count")
    private Integer totalCount;

    /**
     * 可用单品编码
     * data
     * array
     * 否
     */
    @SerializedName("data")
    private List<String> data;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @SerializedName("stock_id")
    private String stockId;



}
