package com.github.songxzj.wxpay.v2.bean.request.tool;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.tool.WxToolAuthCodeToOpenidResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;


/**
 * 付款码查询openid
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_12&index=8">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_13&index=9">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxToolAuthCodeToOpenidRequest extends BaseWxPayRequest<WxToolAuthCodeToOpenidResult> {
    private static final long serialVersionUID = -2148026409339989978L;


    /**
     * 付款码
     * auth_code
     * 是
     * String(128)
     * 120061098828009406
     * 扫码支付付款码，设备读取用户微信中的条码或者二维码信息
     **/
    @Required
    @XStreamAlias("auth_code")
    private String authCode;

    @Override
    public String routing() {
        return "/tools/authcodetoopenid";
    }

    @Override
    public Class<WxToolAuthCodeToOpenidResult> getResultClass() {
        return WxToolAuthCodeToOpenidResult.class;
    }

    @Override
    public boolean isUseKey() {
        return false;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("auth_code", this.authCode);
    }
}
