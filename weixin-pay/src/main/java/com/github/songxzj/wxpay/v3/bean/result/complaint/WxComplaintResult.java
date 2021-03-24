package com.github.songxzj.wxpay.v3.bean.result.complaint;

import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxComplaintResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 5849490199054029039L;

    /**
     * 商户订单号
     * out_trade_no
     * string[1,64]
     * 是
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 投诉时间
     * complaint_time
     * string[1,32]
     * 是
     */
    @SerializedName("complaint_time")
    private String complaintTime;

    /**
     * 投诉金额
     * amount
     * uint64
     * 是
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * 投诉人联系方式
     * payer_phone
     * string[1,256]
     * 否
     */
    @SensitiveEncrypt
    @SerializedName("payer_phone")
    private String payerPhone;

    /**
     * 投诉描述
     * complaint_detail
     * string[1,300]
     * 是
     */
    @SerializedName("complaint_detail")
    private String complaintDetail;

    /**
     * 投诉单状态
     * complaint_state
     * string[1,30]
     * 否
     */
    @SerializedName("complaint_state")
    private String complaintState;

    /**
     * 微信订单号
     * transaction_id
     * string[1,64]
     * 是
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 冻结结束时间
     * frozen_end_time
     * string[1,32]
     * 否
     */
    @SerializedName("frozen_end_time")
    private String frozenEndTime;

    /**
     * 特约商户号
     * sub_mchid
     * string[1,64]
     * 否
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 投诉单处理进展状态
     * complaint_handle_state
     * string[1, 64]
     * 是
     */
    @SerializedName("complaint_handle_state")
    private String complaintHandleState;

    /**
     * 动作类型
     * action_type
     * string[1, 64]
     * 是
     */
    @SerializedName("action_type")
    private String actionType;


}
