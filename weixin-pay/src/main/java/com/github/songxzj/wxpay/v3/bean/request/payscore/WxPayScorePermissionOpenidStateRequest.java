package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScorePermissionOpenidStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.14
 * 查询用户授权记录（openid）API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_5.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScorePermissionOpenidStateRequest extends BaseWxPayV3Request<WxPayScorePermissionOpenidStateResult> {
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
     * 应用ID
     * appid
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;
    /**
     * 用户标识
     * openid
     * string[1, 128]
     * 是
     */
    @Required
    @SerializedName("openid")
    private String openid;

    @Override
    public String routing() {
        return "/v3/payscore/permissions/openid/" + this.openid + "?service_id=" + this.serviceId + "&appid=" + this.appid;
    }

    @Override
    public Class<WxPayScorePermissionOpenidStateResult> getResultClass() {
        return WxPayScorePermissionOpenidStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
