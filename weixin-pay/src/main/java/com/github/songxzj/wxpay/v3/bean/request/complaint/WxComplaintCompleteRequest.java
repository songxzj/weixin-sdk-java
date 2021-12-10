package com.github.songxzj.wxpay.v3.bean.request.complaint;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintCompleteResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2021.04.01
 * 反馈处理完成API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_2_15.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintCompleteRequest extends BaseWxPayV3Request<WxComplaintCompleteResult> {
    private static final long serialVersionUID = -4724204888544093357L;

    /**
     * 投诉单号
     * complaint_id
     * string[1,64]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("complaint_id")
    private String complaintId;

    /**
     * 被诉商户号
     * complainted_mchid
     * string[1, 64]
     * 是
     */
    @Required
    @SerializedName("complainted_mchid")
    private String complaintedMchid;

    @Override
    public String routing() {
        return "/v3/merchant-service/complaints-v2/" + this.complaintId + "/complete";
    }

    @Override
    public Class<WxComplaintCompleteResult> getResultClass() {
        return WxComplaintCompleteResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
