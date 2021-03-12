package com.github.songxzj.wxpay.v3.bean.result.applyment;

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
public class WxApplymentSubStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -241227059481834449L;


    /**
     * 业务申请编号
     * business_code
     * string
     * 否
     */
    @SerializedName("business_code")
    private String businessCode;

    /**
     * 微信支付申请单号
     * applyment_id
     * uint64
     * 否
     */
    @SerializedName("applyment_id")
    private String applymentId;

    /**
     * 特约商户号
     * sub_mchid
     * string
     * 否
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 超级管理员签约链接
     * sign_url
     * string
     * 否
     */
    @SerializedName("sign_url")
    private String signUrl;


    /**
     * 申请单状态
     * applyment_state
     * enum
     * 是
     */
    @SerializedName("applyment_state")
    private String applymentState;

    /**
     * 申请状态描述
     * applyment_state_msg
     * string
     * 否
     */
    @SerializedName("applyment_state_msg")
    private String applymentStateMsg;


    /**
     * 驳回原因详情
     * audit_detail
     * array
     * 否
     */
    @SerializedName("audit_detail")
    private List<AuditDetail> auditDetailList;

    /**
     * 驳回原因详情
     */
    @Data
    @NoArgsConstructor
    public static class AuditDetail implements Serializable {
        private static final long serialVersionUID = 4909218873339164626L;

        /**
         * 字段名
         * field
         * string
         * 否
         */
        @SerializedName("field")
        private String field;


        /**
         * 字段名称
         * field_name
         * string
         * 否
         */
        @SerializedName("field_name")
        private String fieldName;

        /**
         * 驳回原因
         * reject_reason
         * string
         * 否
         */
        @SerializedName("reject_reason")
        private String rejectReason;

    }




}
