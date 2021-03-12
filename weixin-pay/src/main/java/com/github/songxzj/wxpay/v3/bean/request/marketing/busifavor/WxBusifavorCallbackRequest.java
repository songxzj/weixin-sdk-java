package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorCallbackResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2019.12.20
 * 设置商家券事件通知地址API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_7.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorCallbackRequest extends BaseWxPayV3Request<WxBusifavorCallbackResult> {
    private static final long serialVersionUID = -6347099125574891352L;

    /**
     * 商户号
     * mchid
     * string[8,15]
     * 否
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 通知URL地址
     * notify_url
     * string[10,256]
     * 是
     */
    @Required
    @SerializedName("notify_url")
    private String notifyUrl;


    @Override
    public String routing() {
        return "/v3/marketing/busifavor/callbacks";
    }

    @Override
    public Class<WxBusifavorCallbackResult> getResultClass() {
        return WxBusifavorCallbackResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
