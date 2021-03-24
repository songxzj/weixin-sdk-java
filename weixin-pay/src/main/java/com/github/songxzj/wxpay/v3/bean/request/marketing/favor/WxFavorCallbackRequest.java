package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorCallbackResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.12.27
 * 设置消息通知地址API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_12.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxFavorCallbackRequest extends BaseWxPayV3Request<WxFavorCallbackResult> {
    private static final long serialVersionUID = -683641490561030505L;

    /**
     * 商户号
     * mchid
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("mchid")
    private String mchid;

    /**
     * 通知url地址
     * notify_url
     * string[1,256]
     * 是
     */
    @Required
    @SerializedName("notify_url")
    private String notifyUrl;

    /**
     * 回调开关
     * switch
     * bool
     * 否
     */
    @SerializedName("switch")
    private Boolean switchValue;


    @Override
    public String routing() {
        return "/v3/marketing/favor/callbacks";
    }

    @Override
    public Class<WxFavorCallbackResult> getResultClass() {
        return WxFavorCallbackResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
