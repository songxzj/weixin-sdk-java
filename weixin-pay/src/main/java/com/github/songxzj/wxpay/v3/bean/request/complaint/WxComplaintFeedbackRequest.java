package com.github.songxzj.wxpay.v3.bean.request.complaint;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintFeedbackResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2021.01.08
 * 商户反馈API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/merchant-service/chapter3_6.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintFeedbackRequest extends BaseWxPayV3Request<WxComplaintFeedbackResult> {
    private static final long serialVersionUID = 5265160079688421819L;

    /**
     * 微信支付订单号
     * transaction_id
     * string[1, 64]
     * 是
     */
    @Required
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 被诉商户号
     * complainted_mchid
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("complainted_mchid")
    private String complaintedMchid;

    /**
     * 反馈内容类型
     * feedback_type
     * int
     * 否
     */
    @Deprecated
    @SerializedName("feedback_type")
    private Integer feedbackType;

    /**
     * 反馈内容
     * feedback_content
     * string[1, 200]
     * 是
     */
    @Required
    @SerializedName("feedback_content")
    private String feedbackContent;

    /**
     * 图片凭证
     * feedback_images
     * array
     * 否
     */
    @SerializedName("feedback_images")
    private List<String> feedbackImages;

    /**
     * 反馈处理完成
     * launch_confirm_process
     * boolean
     * 否
     */
    @SerializedName("launch_confirm_process")
    private Boolean launchConfirmProcess;



    @Override
    public String routing() {
        return "/v3/merchant-service/feedbacks";
    }

    @Override
    public Class<WxComplaintFeedbackResult> getResultClass() {
        return WxComplaintFeedbackResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
