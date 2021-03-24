package com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayGiftActivityMerchantAddResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -7818263752332186097L;

    /**
     * 活动id
     * activity_id
     * string[1,20]
     * 是
     */
    @SerializedName("activity_id")
    private String activityId;

    /**
     * 校验失败的发券商户号
     * invalid_merchant_id_list
     * array
     * 否
     */
    @SerializedName("invalid_merchant_id_list")
    private List<InvalidMerchantId> invalidMerchantIdList;

    /**
     * 添加时间
     * add_time
     * string[1,32]
     * 否
     */
    @SerializedName("add_time")
    private String addTime;


    /**
     * 校验失败的发券商户号
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class InvalidMerchantId implements Serializable {
        private static final long serialVersionUID = -6501031754642233638L;

        /**
         * 商户号
         * mchid
         * string[8,15]
         * 是
         */
        @SerializedName("mchid")
        private String mchid;

        /**
         * 无效原因
         * invalid_reason
         * string[1,512]
         * 否
         */
        @SerializedName("invalid_reason")
        private String invalidReason;
    }


}
