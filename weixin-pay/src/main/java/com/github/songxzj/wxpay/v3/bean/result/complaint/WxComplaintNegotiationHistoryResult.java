package com.github.songxzj.wxpay.v3.bean.result.complaint;

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
public class WxComplaintNegotiationHistoryResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 1520944328556622515L;

    /**
     * 投诉协商历史
     * complaint_negotiation_history
     * array
     * 否
     */
    @SerializedName("complaint_negotiation_history")
    private List<ComplaintNegotiationHistory> complaintNegotiationHistoryList;

    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class ComplaintNegotiationHistory implements Serializable {
        private static final long serialVersionUID = 9145286028492800183L;

        /**
         * 操作人
         * operate_user
         * string[1, 64]
         * 是
         */
        @SerializedName("operate_user")
        private String operateUser;

        /**
         * 操作时间
         * operate_time
         * string[1, 32]
         * 是
         */
        @SerializedName("operate_time")
        private String operateTime;

        /**
         * 操作类型
         * operate_type
         * string[1, 64]
         * 是
         */
        @SerializedName("operate_type")
        private String operateType;

        /**
         * 操作内容
         * operate_details
         * string[1, 200]
         * 否
         */
        @SerializedName("operate_details")
        private String operateDetails;

        /**
         * 协商历史图片凭证
         * image_list
         * array
         * 否
         */
        @SerializedName("image_list")
        private List<String> imageList;
    }
}
