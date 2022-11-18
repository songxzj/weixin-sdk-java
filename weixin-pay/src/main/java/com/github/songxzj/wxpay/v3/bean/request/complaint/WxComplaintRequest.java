package com.github.songxzj.wxpay.v3.bean.request.complaint;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2022.06.08
 * 查询投诉单详情API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_2_13.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintRequest extends BaseWxPayV3Request<WxComplaintResult> {
    private static final long serialVersionUID = 4118288809060151866L;


    /**
     * 投诉单号
     * complaint_id
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("complaint_id")
    private String complaintId;

    @Override
    public String routing() {
        return "/v3/merchant-service/complaints-v2/" + this.complaintId;
    }

    @Override
    public Class<WxComplaintResult> getResultClass() {
        return WxComplaintResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
