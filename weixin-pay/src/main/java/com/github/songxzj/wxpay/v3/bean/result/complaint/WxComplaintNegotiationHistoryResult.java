package com.github.songxzj.wxpay.v3.bean.result.complaint;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

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
     * data
     * array
     * 否
     */
    @SerializedName("data")
    private List<ComplaintNegotiationHistory> data;

    /**
     * 分页开始位置
     * offset
     * int
     * 是
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * 分页大小
     * limit
     * int
     * 是
     */
    @SerializedName("limit")
    private Integer limit;

    /**
     * 投诉协商历史总条数
     * total_count
     * uint64
     * 否
     */
    @SerializedName("total_count")
    private Integer totalCount;


    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    public static class ComplaintNegotiationHistory implements Serializable {
        private static final long serialVersionUID = 9145286028492800183L;

        /**
         * 投诉资料列表
         * complaint_media_list
         * array
         * 是
         */
        @SerializedName("complaint_media_list")
        private List<ComplaintMedia> complaintMediaList;

        /**
         * 操作流水号
         * log_id
         * string[1, 64]
         * 是
         */
        @SerializedName("log_id")
        private String logId;

        /**
         * 操作人
         * operator
         * string[1, 64]
         * 是
         */
        @SerializedName("operator")
        private String operator;

        /**
         * 操作时间
         * operate_time
         * string[1, 64]
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

    /**
     * 投诉资料
     */
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    public static class ComplaintMedia implements Serializable {
        private static final long serialVersionUID = -5418772758719900999L;

        /**
         * 媒体文件业务类型
         * media_type
         * string[1, 32]
         * 是
         */
        @SerializedName("media_type")
        private String mediaType;


        /**
         * 媒体文件请求url
         * media_url
         * array
         * 是
         */
        @SerializedName("media_url")
        private List<String> mediaUrls;
    }
}
