package com.github.songxzj.wxpay.v3.bean.request.applyment;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.applyment.WxApplymentAuthorizeVerifyStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;


/**
 * 获取商户开户意愿确认状态API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/applysubject/chapter5_4.shtml">
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxApplymentAuthorizeVerifyStateRequest extends BaseWxPayV3Request<WxApplymentAuthorizeVerifyStateResult> {
    private static final long serialVersionUID = -497855020735377041L;


    /**
     * 特约商户号
     * sub_mchid
     * string(32)
     * 是
     */
    @Required
    @SerializedName("sub_mchid")
    private String subMchid;

    @Override
    public String routing() {
        return "/v3/apply4subject/applyment/merchants/" + this.subMchid + "/state";
    }

    @Override
    public Class<WxApplymentAuthorizeVerifyStateResult> getResultClass() {
        return WxApplymentAuthorizeVerifyStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
