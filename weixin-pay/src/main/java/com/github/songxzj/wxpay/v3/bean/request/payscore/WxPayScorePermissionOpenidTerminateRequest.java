package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScorePermissionOpenidTerminateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.07.20
 * 解除用户授权关系（openid）API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_6.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScorePermissionOpenidTerminateRequest extends BaseWxPayV3Request<WxPayScorePermissionOpenidTerminateResult> {
    private static final long serialVersionUID = 1493714011845600874L;

    /**
     * 用户标识
     * openid
     * string[1, 128]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("openid")
    private String openid;

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
     * 应用ID
     * appid
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

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
        return "/v3/payscore/permissions/openid/" + this.openid + "/terminate";
    }

    @Override
    public Class<WxPayScorePermissionOpenidTerminateResult> getResultClass() {
        return WxPayScorePermissionOpenidTerminateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
