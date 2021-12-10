package com.github.songxzj.wxpay.v3.bean.request.businesscircle;


import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.businesscircle.WxBusinessCircleAuthorizationsStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2021.01.29
 * 商圈积分授权查询
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_6_4.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusinessCircleAuthorizationsStateRequest extends BaseWxPayV3Request<WxBusinessCircleAuthorizationsStateResult> {
    private static final long serialVersionUID = -252247581285511922L;


    /**
     * 小程序appid
     * appid
     * string[1, 128]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 顾客openid
     * openid
     * string[1, 64]
     * 是
     */
    @Required
    @SerializedName("openid")
    private String openid;


    @Override
    public String routing() {
        return "/v3/businesscircle/user-authorizations/" + this.openid + "?appid=" + this.appid;
    }

    @Override
    public Class<WxBusinessCircleAuthorizationsStateResult> getResultClass() {
        return WxBusinessCircleAuthorizationsStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
