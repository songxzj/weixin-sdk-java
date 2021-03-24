package com.github.songxzj.wxpay.v3.bean.result.marketing.partnership;

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
public class WxPartnershipStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 1167062658854298142L;

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
     * 合作关系结果集
     * data
     * array
     * 否
     */
    @SerializedName("data")
    private List<Partnership> data;


    /**
     * 合作关系
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class Partnership implements Serializable {
        private static final long serialVersionUID = 5929689478214434291L;

        /**
         * 合作方信息
         * partner
         * object
         * 是
         */
        @SerializedName("partner")
        private Partner partner;

        /**
         * 被授权数据
         * authorized_data
         * object
         * 是
         */
        @SerializedName("authorized_data")
        private AuthorizedData authorizedData;

        /**
         * 建立合作关系时间
         * build_time
         * string[1,32]
         * 是
         */
        @SerializedName("build_time")
        private String buildTime;

        /**
         * 终止合作关系时间
         * terminate_time
         * string[1,32]
         * 否
         */
        @SerializedName("terminate_time")
        private String terminateTime;

        /**
         * 创建时间
         * create_time
         * string[1,32]
         * 是
         */
        @SerializedName("create_time")
        private String createTime;

        /**
         * 更新时间
         * update_time
         * string[1,32]
         * 是
         */
        @SerializedName("update_time")
        private String updateTime;
    }


    /**
     * 合作方信息
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class Partner implements Serializable {
        private static final long serialVersionUID = -9084305331814876833L;

        /**
         * 合作方类别
         * type
         * string[1,32]
         * 是
         */
        @SerializedName("type")
        private String type;

        /**
         * 合作方APPID
         * appid
         * string[1,32]
         * 否
         */
        @SerializedName("appid")
        private String appid;

        /**
         * 合作方商户ID
         * merchant_id
         * string[8,15]
         * 否
         */
        @SerializedName("merchant_id")
        private String merchantId;
    }

    /**
     * 被授权数据
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    public static class AuthorizedData implements Serializable {
        private static final long serialVersionUID = 4528230286557923678L;

        /**
         * 授权业务类别
         * business_type
         * string[1,32]
         * 是
         */
        @SerializedName("business_type")
        private String businessType;

        /**
         * 授权批次ID
         * stock_id
         * string[1,20]
         * 否
         */
        @SerializedName("stock_id")
        private String stockId;
    }

}
