package com.github.songxzj.wxpay.v2.bean.order;


import cn.hutool.core.util.RandomUtil;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.util.SignUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * APP支付
 */
@Setter
@Getter
@ToString
public class WxPayAppOrderData implements Serializable {
    private static final long serialVersionUID = -3997925111530175505L;

    /**
     * 应用id
     * appid
     * string[1,32]
     * 是
     */
    private String appid;

    /**
     * 商户号
     * partnerid
     * string[1,32]
     * 是
     */
    private String partnerid;

    /**
     * 预支付交易会话ID
     * prepayid
     * string[1,64]
     * 是
     */
    private String prepayid;

    /**
     * 扩展字段
     * package
     * string[1,128]
     * 是
     * 由于package为java保留关键字，因此改为packageValue. 前端使用时记得要更改为package
     */
    @XStreamAlias("package")
    private String packageValue;

    /**
     * 随机字符串
     * noncestr
     * String(32)
     * 是
     */
    private String noncestr;

    /**
     * 时间戳
     * timestamp
     * String(10)
     * 是
     */
    private String timestamp;

    /**
     * 签名
     * sign
     * String(64)
     * 是
     */
    private String sign;

    private WxPayAppOrderData(String appid, String partnerid, String prepayid) {
        this.appid = appid;
        this.partnerid = partnerid;
        this.prepayid = prepayid;
        this.packageValue = "Sign=WXPay";
        this.noncestr = RandomUtil.randomString(32);
        this.timestamp = String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static class WxPayAppOrderDataBuilder {

        private String appid;

        private String partnerid;

        private String prepayid;

        private String signType;

        public WxPayAppOrderDataBuilder appid(String appid) {
            this.appid = appid;
            return this;
        }

        public WxPayAppOrderDataBuilder partnerid(String partnerid) {
            this.partnerid = partnerid;
            return this;
        }

        public WxPayAppOrderDataBuilder prepayid(String prepayid) {
            this.prepayid = prepayid;
            return this;
        }

        public WxPayAppOrderData buildWithMchKey(String mchKey) throws WxErrorException {
            if (StringUtils.isBlank(this.appid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "appid 必须提供值");
            }
            if (StringUtils.isBlank(this.partnerid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "partnerid 必须提供值");
            }
            if (StringUtils.isBlank(this.prepayid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "prepayid 必须提供值");
            }
            if (StringUtils.isBlank(this.signType)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "signType 必须提供值");
            }
            WxPayAppOrderData data = new WxPayAppOrderData(this.appid, this.partnerid, this.prepayid);
            data.sign = SignUtils.createSign(data, this.signType, mchKey, new String[0]);

            return data;
        }
    }
}
