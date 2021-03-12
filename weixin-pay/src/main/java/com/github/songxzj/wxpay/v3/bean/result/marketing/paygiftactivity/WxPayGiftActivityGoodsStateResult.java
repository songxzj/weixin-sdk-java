package com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayGiftActivityGoodsStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 4207148833352525510L;

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
    private List<Goods> data;

    /**
     * 活动id
     * activity_id
     * string[1,20]
     * 是
     */
    @SerializedName("activity_id")
    private String activityId;

    /**
     * 商户信息
     */
    @Data
    @NoArgsConstructor
    public static class Goods implements Serializable {
        private static final long serialVersionUID = -1801842540052156713L;

        /**
         * 指定商品
         * goods_id
         * string
         * 是
         */
        @SerializedName("goods_id")
        private String goodsId;

        /**
         * 创建时间
         * create_time
         * string[1,32]
         * 否
         */
        @SerializedName("create_time")
        private String createTime;

        /**
         * 更新时间
         * update_time
         * string[1,32]
         * 否
         */
        @SerializedName("update_time")
        private String updateTime;
    }


}
