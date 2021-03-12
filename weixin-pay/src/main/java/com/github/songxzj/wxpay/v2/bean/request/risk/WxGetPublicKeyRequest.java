package com.github.songxzj.wxpay.v2.bean.request.risk;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.risk.WxGetPublicKeyResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 获取RSA加密公钥API
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_7&index=4">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
//@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxGetPublicKeyRequest extends BaseWxPayRequest<WxGetPublicKeyResult> {
    private static final long serialVersionUID = 5747008278510054753L;

    @Override
    public String routing() {
        return "/risk/getpublickey";
    }

    @Override
    public String ownServerUrl() {
        return "https://fraud.mch.weixin.qq.com";
    }

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"appid"};
    }

    @Override
    public Class<WxGetPublicKeyResult> getResultClass() {
        return WxGetPublicKeyResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {

    }
}
