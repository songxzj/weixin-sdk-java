package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScorePermissionAuthorizationCodeStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.14
 * 查询用户授权记录（授权协议号）API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_3.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScorePermissionAuthorizationCodeStateRequest extends BaseWxPayV3Request<WxPayScorePermissionAuthorizationCodeStateResult> {
    private static final long serialVersionUID = 2465466142250949323L;

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
     * 授权协议号
     * authorization_code
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("authorization_code")
    private String authorizationCode;

    @Override
    public String routing() {
        return "/v3/payscore/permissions/authorization-code/" + this.authorizationCode + "?service_id=" + this.serviceId;
    }

    @Override
    public Class<WxPayScorePermissionAuthorizationCodeStateResult> getResultClass() {
        return WxPayScorePermissionAuthorizationCodeStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
