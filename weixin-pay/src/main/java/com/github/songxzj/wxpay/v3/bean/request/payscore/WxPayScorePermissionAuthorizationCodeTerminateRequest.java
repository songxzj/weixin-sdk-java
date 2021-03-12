package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScorePermissionAuthorizationCodeTerminateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.07.20
 * 解除用户授权关系（授权协议号）API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_4.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScorePermissionAuthorizationCodeTerminateRequest extends BaseWxPayV3Request<WxPayScorePermissionAuthorizationCodeTerminateResult> {
    private static final long serialVersionUID = 8051715736307318551L;

    /**
     * 授权协议号
     * authorization_code
     * string[1, 32]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("authorization_code")
    private String authorizationCode;

    /**
     * 服务ID
     * service_id
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("service_id")
    private String serviceId;

    /**
     * 撤销原因
     * reason
     * string[1, 50]
     * 是
     */
    @Required
    @SerializedName("reason")
    private String reason;


    @Override
    public String routing() {
        return "/v3/payscore/permissions/authorization-code/" + this.authorizationCode + "/terminate";
    }

    @Override
    public Class<WxPayScorePermissionAuthorizationCodeTerminateResult> getResultClass() {
        return WxPayScorePermissionAuthorizationCodeTerminateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
