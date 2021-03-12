package com.github.songxzj.wxpay.v2.bean.order;

import cn.hutool.core.util.RandomUtil;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.util.SignUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * JSAPI/小程序支付
 */
@Data
public class WxPayJsapiOrderData implements Serializable {
    private static final long serialVersionUID = -1596569775320792912L;

    /**
     * 公众号id
     * appId
     * 是
     * String(16)
     */
    private String appId;

    /**
     * 时间戳
     * timeStamp
     * 是
     * String(32)
     */
    private String timeStamp;

    /**
     * 随机字符串
     * nonceStr
     * 是
     * String(32)
     */
    private String nonceStr;

     /**
     * 订单详情扩展字符串
     * package
     * 是
     * String(128)
     * 由于package为java保留关键字，因此改为packageValue. 前端使用时记得要更改为package
     */
    @XStreamAlias("package")
    private String packageValue;

    /**
     * 签名方式
     * signType
     * 是
     * String(32)
     */
    private String signType;

    /**
     * 签名
     * paySign
     * 是
     * String(64)
     */
    private String paySign;

    private WxPayJsapiOrderData(String appId, String prepayId, String signType) {
        this.appId = appId;
        this.timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        this.nonceStr = RandomUtil.randomString(32);
        this.packageValue = "prepay_id=" + prepayId;
        this.signType = signType;
    }

    public static WxPayJsapiOrderDataBuilder newBuilder() {
        return new WxPayJsapiOrderDataBuilder();
    }

    public static class WxPayJsapiOrderDataBuilder {

        private String appId;

        private String prepayId;

        private String signType;

        public WxPayJsapiOrderDataBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public WxPayJsapiOrderDataBuilder prepayId(String prepayId) {
            this.prepayId = prepayId;
            return this;
        }

        public WxPayJsapiOrderDataBuilder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public WxPayJsapiOrderData buildWithMchKey(String mchKey) throws WxErrorException {
            if (StringUtils.isBlank(this.appId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "appId 必须提供值");
            }
            if (StringUtils.isBlank(this.prepayId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "prepayId 必须提供值");
            }
            if (StringUtils.isBlank(this.signType)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "signType 必须提供值");
            }
            WxPayJsapiOrderData data = new WxPayJsapiOrderData(this.appId, this.prepayId, this.signType);
            data.paySign = SignUtils.createSign(data, data.getSignType(), mchKey, new String[0]);

            return data;
        }
    }

}
