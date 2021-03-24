package com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayGiftActivityStateBatchResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -954806798942408495L;

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
     * 商户信息列表
     * data
     * array
     * 否
     */
    @SerializedName("data")
    private List<WxPayGiftActivityStateResult> data;





}
