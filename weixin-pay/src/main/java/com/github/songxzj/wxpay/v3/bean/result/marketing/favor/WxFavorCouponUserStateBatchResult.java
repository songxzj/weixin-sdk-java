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
public class WxFavorCouponUserStateBatchResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -7466818325995006971L;

    /**
     * 结果集
     * data
     * array
     * 是
     */
    @SerializedName("data")
    private List<WxFavorCouponUserStateResult> data;

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
     * int64
     * 是
     */
    @SerializedName("total_count")
    private Integer totalCount;


}
