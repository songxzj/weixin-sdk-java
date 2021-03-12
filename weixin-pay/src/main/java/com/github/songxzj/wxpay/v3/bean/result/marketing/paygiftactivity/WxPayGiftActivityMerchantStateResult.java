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
public class WxPayGiftActivityMerchantStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -6967021913719104675L;

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
    private List<Merchant> data;

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
    public static class Merchant implements Serializable {
        private static final long serialVersionUID = -8477977013278363941L;

        /**
         * 商户号
         * mchid
         * string[8,15]
         * 是
         */
        @SerializedName("mchid")
        private String mchid;

        /**
         * 商户名称
         * merchant_name
         * string
         * 否
         */
        @SerializedName("merchant_name")
        private String merchantName;

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
