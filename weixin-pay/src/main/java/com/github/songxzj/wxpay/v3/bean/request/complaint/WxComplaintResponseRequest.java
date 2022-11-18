package com.github.songxzj.wxpay.v3.bean.request.complaint;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.applyment.enums.AuthorizeSubjectTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintResponseResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2022.5.20
 * 回复用户API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_2_14.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintResponseRequest extends BaseWxPayV3Request<WxComplaintResponseResult> {
    private static final long serialVersionUID = 8257484638496137945L;

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

    /**
     * 回复内容
     * response_content
     * string[1, 200]
     * 是
     */
    @Required
    @SerializedName("response_content")
    private String responseContent;


    /**
     * 回复图片
     * response_images
     * array
     * 否
     */
    @SerializedName("response_images")
    private List<String> responseImages;

    /**
     * 跳转链接
     * jump_url
     * string[1, 512]
     * 否
     */
    @SerializedName("jump_url")
    private String jumpUrl;

    /**
     * 跳转链接文案
     * jump_url_text
     * string[1, 10]
     * 否
     */
    @SerializedName("jump_url_text")
    private String jumpUrlText;


    @Override
    public String routing() {
        return "/v3/merchant-service/complaints-v2/" + this.complaintId + "/response";
    }

    @Override
    public Class<WxComplaintResponseResult> getResultClass() {
        return WxComplaintResponseResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isNotBlank(this.jumpUrl) && StringUtils.isBlank(this.jumpUrlText)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "若传入跳转链接，则跳转链接文案为必传项");
        }

    }
}
