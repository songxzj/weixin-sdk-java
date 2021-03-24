package com.github.songxzj.wxpay.v2.bean.order;

import cn.hutool.core.util.RandomUtil;
import com.github.songxzj.common.annotation.SignExclude;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import com.github.songxzj.wxpay.util.SignUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 领取小程序红包
 */
@Setter
@Getter
@ToString
public class WxRedPacketMiniProgramOrderData implements Serializable {
    private static final long serialVersionUID = -6538734571124813526L;

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
     * 签名方式
     * signType
     * 是
     * String(32)
     */
    @SignExclude
    private String signType;

    /**
     * 签名
     * paySign
     * 是
     * String(64)
     */
    private String paySign;

    /**
     * 红包详情的扩展
     * package
     * 是
     * sendid%3D242e8abd163d300019b2cae74ba8e8c06e3f0e51ab84d16b3c80decd22a5b672%26ver%3D8%26sign%3D4110d649a5aef52dd6b95654ddf91ca7d5411ac159ace4e1a766b7d3967a1c3dfe1d256811445a4abda2d9cfa4a9b377a829258bd00d90313c6c346f2349fe5d%26mchid%3D11475856%26appid%3Dwxd27ebc41b85ce36d
     * String(256)
     * 商户将红包信息组成该串，具体方案参见package的说明，package需要进行urlencode再传给页面
     */
    @XStreamAlias("package")
    private String packageValue;

    public WxRedPacketMiniProgramOrderData(String appId, String signType, String packageValue) {
        this.appId = appId;
        this.timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        this.nonceStr = RandomUtil.randomString(32);
        this.signType = signType;
        this.packageValue = packageValue;
    }

    public static WxRedPacketMiniProgramOrderDataBuilder newBuilder() {
        return new WxRedPacketMiniProgramOrderDataBuilder();
    }

    public static class WxRedPacketMiniProgramOrderDataBuilder {

        private String appId;

        private String signType;

        private String packageValue;

        public WxRedPacketMiniProgramOrderDataBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public WxRedPacketMiniProgramOrderDataBuilder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public WxRedPacketMiniProgramOrderDataBuilder packageValue(String packageValue) {
            this.packageValue = packageValue;
            return this;
        }

        public WxRedPacketMiniProgramOrderData buildWithMchKey(String mchKey) throws WxErrorException, UnsupportedEncodingException {
            if (StringUtils.isBlank(this.appId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "appId 必须提供值");
            }
            if (StringUtils.isBlank(this.packageValue)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "packageValue 必须提供值");
            }
            if (StringUtils.isBlank(this.signType)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "signType 必须提供值");
            }
            WxRedPacketMiniProgramOrderData data = new WxRedPacketMiniProgramOrderData(this.appId, this.signType, URLEncoder.encode(this.packageValue, WxPayConstants.DEFAULT_CHARSET));
            data.paySign = SignUtils.createSign(data, data.getSignType(), mchKey, new String[0]);

            return data;
        }


    }
}
