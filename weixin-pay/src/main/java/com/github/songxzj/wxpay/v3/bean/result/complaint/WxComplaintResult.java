package com.github.songxzj.wxpay.v3.bean.result.complaint;

import com.github.songxzj.common.annotation.SensitiveEncrypt;
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
public class WxComplaintResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 5849490199054029039L;

    /**
     * 投诉单号
     * complaint_id
     * string[1, 64]
     * 是
     */
    @SerializedName("complaint_id")
    private String complaintId;

    /**
     * 投诉时间
     * complaint_time
     * string[1,32]
     * 是
     */
    @SerializedName("complaint_time")
    private String complaintTime;

    /**
     * 投诉详情
     * complaint_detail
     * string[1,300]
     * 是
     */
    @SerializedName("complaint_detail")
    private String complaintDetail;

    /**
     * 被诉商户号
     * complainted_mchid
     * string[1, 64]
     * 否
     */
    @SerializedName("complainted_mchid")
    private String complaintedMchid;

    /**
     * 投诉单状态
     * complaint_state
     * string[1,30]
     * 否
     */
    @SerializedName("complaint_state")
    private String complaintState;

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
     * 投诉人openid
     * payer_openid
     * string[1, 128]
     * 是
     */
    @SerializedName("payer_openid")
    private String payerOpenid;


    /**
     * 投诉资料列表
     * complaint_media_list
     * array
     * 是
     */
    @SerializedName("complaint_media_list")
    private List<ComplaintMedia> complaintMediaList;

    /**
     * 投诉单关联订单信息
     * complaint_order_info
     * array
     * 是
     */
    @SerializedName("complaint_order_info")
    private List<ComplaintOrderInfo> complaintOrderInfos;

    /**
     * 投诉单关联服务单信息
     * service_order_info
     * array
     * 否
     */
    @SerializedName("service_order_info")
    private List<ServiceOrderInfo> serviceOrderInfos;

    /**
     * 投诉单是否已全额退款
     * complaint_full_refunded
     * boolean
     * 是
     */
    @SerializedName("complaint_full_refunded")
    private Boolean complaintFullRefunded;

    /**
     * 是否有待回复的用户留言
     * incoming_user_response
     * boolean
     * 是
     */
    @SerializedName("incoming_user_response")
    private Boolean incomingUserResponse;

    /**
     * 问题描述
     * problem_description
     * string[1, 256]
     * 是
     */
    @SerializedName("problem_description")
    private String problemDescription;

    /**
     * 用户投诉次数
     * user_complaint_times
     * int
     * 是
     */
    @SerializedName("user_complaint_times")
    private Integer userComplaintTimes;

    /**
     * 问题类型
     * problem_type
     * string
     * 否
     */
    @SerializedName("problem_type")
    private String problemType;

    /**
     * 申请退款金额
     * apply_refund_amount
     * int
     * 否
     */
    @SerializedName("apply_refund_amount")
    private Integer applyRefundAmount;

    /**
     * 用户标签列表
     * user_tag_list
     * array
     * 否
     */
    @SerializedName("user_tag_list")
    private List<String> userTagList;


    /**
     * 投诉资料
     */
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    public static class ComplaintMedia implements Serializable {
        private static final long serialVersionUID = -7051137063680091638L;


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

    /**
     * 投诉单关联订单信息
     */
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    public static class ComplaintOrderInfo implements Serializable {
        private static final long serialVersionUID = -8924114983961003057L;

        /**
         * 微信订单号
         * transaction_id
         * string[1,64]
         * 是
         */
        @SerializedName("transaction_id")
        private String transactionId;

        /**
         * 商户订单号
         * out_trade_no
         * string[1,64]
         * 是
         */
        @SerializedName("out_trade_no")
        private String outTradeNo;

        /**
         * 投诉金额
         * amount
         * uint64
         * 是
         */
        @SerializedName("amount")
        private Integer amount;

    }


    /**
     * 投诉单关联服务单信息
     */
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    public static class ServiceOrderInfo implements Serializable {
        private static final long serialVersionUID = 5589227619199595743L;
        /**
         * 微信支付服务订单号
         * order_id
         * string[1, 128]
         * 否
         */
        @SerializedName("order_id")
        private String orderId;

        /**
         * 商户服务订单号
         * out_order_no
         * string[1, 128]
         * 否
         */
        @SerializedName("out_order_no")
        private String outOrderNo;

        /**
         * 支付分服务单状态
         * state
         * string
         * 否
         */
        @SerializedName("state")
        private String state;

    }


}
