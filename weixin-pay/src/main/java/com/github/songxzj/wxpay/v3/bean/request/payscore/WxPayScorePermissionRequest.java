package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScorePermissionResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.07.20
 * 商户预授权API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_2.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScorePermissionRequest extends BaseWxPayV3Request<WxPayScorePermissionResult> {
    private static final long serialVersionUID = -2790238747270012141L;

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
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 授权协议号
     * authorization_code
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("authorization_code")
    private String authorizationCode;

    /**
     * 通知地址
     * notify_url
     * string[1,255 ]
     * 否
     */
    @SerializedName("notify_url")
    private String notifyUrl;


    @Override
    public String routing() {
        return "/v3/payscore/permissions";
    }

    @Override
    public Class<WxPayScorePermissionResult> getResultClass() {
        return WxPayScorePermissionResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
