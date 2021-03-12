package com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor;

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
public class WxBusifavorStockCouponCodeResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 5263311935754076729L;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 去重后上传code总数
     * total_count
     * uint64
     * 是
     */
    @SerializedName("total_count")
    private Integer totalCount;

    /**
     * 上传成功code个数
     * success_count
     * uint64
     * 是
     */
    @SerializedName("success_count")
    private Integer successCount;

    /**
     * 上传成功的code列表
     * success_codes
     * array
     * 否
     */
    @SerializedName("success_codes")
    private List<String> successCodes;

    /**
     * 上传成功时间
     * success_time
     * string[1,32]
     * 是
     */
    @SerializedName("success_time")
    private String successTime;

    /**
     * 上传失败code个数
     * fail_count
     * uint64
     * 否
     */
    @SerializedName("fail_count")
    private Integer failCount;

    /**
     * 上传失败的code及原因
     * fail_codes
     * array
     * 否
     */
    @SerializedName("fail_codes")
    private List<FailCode> failCodes;

    /**
     * 已存在的code列表
     * exist_codes
     * array
     * 否
     */
    @SerializedName("exist_codes")
    private List<String> existCodes;

    /**
     * 本次请求中重复的code列表
     * duplicate_codes
     * array
     * 否
     */
    @SerializedName("duplicate_codes")
    private List<String> duplicateCodes;

    /**
     * 上传失败的code及原因
     */
    @Data
    @NoArgsConstructor
    public static class FailCode implements Serializable {
        private static final long serialVersionUID = -4315965925633634778L;

        /**
         * 上传失败的券code
         * coupon_code
         * string[1,32]
         * 是
         */
        @SerializedName("coupon_code")
        private String couponCode;
        /**
         * 上传失败错误码
         * code
         * string[1,32]
         * 是
         */
        @SerializedName("code")
        private String code;

        /**
         * 上传失败错误信息
         * message
         * string[1,128]
         * 是
         */
        @SerializedName("message")
        private String message;

    }
}
