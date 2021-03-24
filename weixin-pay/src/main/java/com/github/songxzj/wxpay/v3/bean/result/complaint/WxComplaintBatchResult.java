package com.github.songxzj.wxpay.v3.bean.result.complaint;

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
public class WxComplaintBatchResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 6009014042667751249L;

    /**
     * 用户投诉信息详情
     * data
     * array
     * 是
     */
    @SerializedName("data")
    private List<WxComplaintResult> data;

    /**
     * 分页开始位置
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
     * 投诉总条数
     * total_count
     * uint64
     * 否
     */
    @SerializedName("total_count")
    private Integer totalCount;

}
