package com.github.songxzj.wxpay.v3.bean.external.payorder;


import cn.hutool.core.util.RandomUtil;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.util.SignUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.security.PrivateKey;

/**
 * JSAPI/小程序支付
 */
@Data
public class WxPayV3JsapiOrderData implements Serializable {
    private static final long serialVersionUID = 7566617252319722544L;

    /**
     * 应用ID
     * appId
     * string[1,16]
     * 是
     */
    private String appId;

    /**
     * 时间戳
     * timeStamp
     * string[1,32]
     * 是
     */
    private String timeStamp;

    /**
     * 随机字符串
     * nonceStr
     * string[1,32]
     * 是
     */
    private String nonceStr;

    /**
     * 订单详情扩展字符串
     * package
     * string[1,128]
     * 是
     * 由于package为java保留关键字，因此改为packageValue. 前端使用时记得要更改为package
     */
    private String packageValue;

    /**
     * 签名方式
     * signType
     * string[1,32]
     * 是
     */
    private String signType;


    /**
     * 签名
     * paySign
     * string[1,256]
     * 是
     */
    private String paySign;

    private WxPayV3JsapiOrderData(String appId, String prepayId) {
        this.appId = appId;
        this.timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        this.nonceStr = RandomUtil.randomString(32);
        this.packageValue = "prepay_id=" + prepayId;
        this.signType = "RSA";
    }


    public static WxPayV3JsapiOrderDataBuilder newBuilder() {
        return new WxPayV3JsapiOrderDataBuilder();
    }

    public static class WxPayV3JsapiOrderDataBuilder {

        private String appId;

        private String prepayId;

        public WxPayV3JsapiOrderDataBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }


        public WxPayV3JsapiOrderDataBuilder prepayId(String prepayId) {
            this.prepayId = prepayId;
            return this;
        }

        public WxPayV3JsapiOrderData buildWithPrivateKey(PrivateKey privateKey) throws WxErrorException {
            if (StringUtils.isBlank(this.appId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "appId 必须提供值");
            }
            if (StringUtils.isBlank(this.prepayId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "prepayId 必须提供值");
            }
            WxPayV3JsapiOrderData data = new WxPayV3JsapiOrderData(this.appId, this.prepayId);
            StringBuilder toSign = new StringBuilder();
            toSign.append(data.appId).append("\n")
                    .append(data.timeStamp).append("\n")
                    .append(data.nonceStr).append("\n")
                    .append(data.packageValue).append("\n");
            data.paySign = SignUtils.createSHA256withRSASign(toSign.toString(), privateKey);

            return data;
        }
    }
}
