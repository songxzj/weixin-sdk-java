package com.github.songxzj.wxpay.v3.bean.result.smartguide;

import com.github.songxzj.common.annotation.SensitiveEncrypt;
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
public class WxSmartGuideQueryResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -1622480712128805260L;

    /**
     * 服务人员列表
     * data
     * array
     * 是
     */
    @SensitiveEncrypt
    @SerializedName("data")
    private List<Guide> data;

    /**
     * 服务人员数量
     * total_count
     * int
     * 是
     */
    @SerializedName("total_count")
    private Integer totalCount;

    /**
     * 最大资源条数
     * limit
     * int
     * 是
     */
    @SerializedName("limit")
    private Integer limit;

    /**
     * 请求资源起始位置
     * offset
     * int
     * 是
     */
    @SerializedName("offset")
    private Integer offset;

    @Override
    public boolean isSensitiveEncrypt() {
        return true;
    }

    /**
     * 服务人员
     */
    @Data
    @NoArgsConstructor
    public static class Guide implements Serializable {
        private static final long serialVersionUID = -625929242690332454L;

        /**
         * 服务人员ID
         * guide_id
         * string[1,32]
         * 是
         */
        @SerializedName("guide_id")
        private String guideId;

        /**
         * 门店ID
         * store_id
         * int
         * 是
         */
        @SerializedName("store_id")
        private Integer storeId;

        /**
         * 服务人员姓名
         * name
         * string[1,512]
         * 是
         */
        @SensitiveEncrypt
        @SerializedName("name")
        private String name;

        /**
         * 服务人员手机号码
         * mobile
         * string[1,512]
         * 是
         */
        @SensitiveEncrypt
        @SerializedName("mobile")
        private String mobile;

        /**
         * 企业微信的员工ID
         * userid
         * string[1,64]
         * 否
         */
        @SerializedName("userid")
        private String userid;

        /**
         * 工号
         * work_id
         * string[1,20]
         * 否
         */
        @SerializedName("work_id")
        private String workId;


    }
}
