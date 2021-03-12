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
 * APP支付
 */
@Data
public class WxPayV3AppOrderData implements Serializable {
    private static final long serialVersionUID = 8078818859528001964L;


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
     * 订单详情扩展字符串
     * package
     * string[1,128]
     * 是
     * 由于package为java保留关键字，因此改为packageValue. 前端使用时记得要更改为package
     */
    private String packageValue;

    /**
     * 随机字符串
     * noncestr
     * string[1,32]
     * 是
     */
    private String noncestr;

    /**
     * 时间戳
     * timestamp
     * string[1,10]
     * 是
     */
    private String timestamp;

    /**
     * 签名
     * paySign
     * string[1,256]
     * 是
     */
    private String paySign;

    private WxPayV3AppOrderData(String appid, String partnerid, String prepayid) {
        this.appid = appid;
        this.partnerid = partnerid;
        this.prepayid = prepayid;
        this.packageValue = "Sign=WXPay";
        this.noncestr = RandomUtil.randomString(32);
        this.timestamp = String.valueOf(System.currentTimeMillis() / 1000);
    }


    public static WxPayV3AppOrderDataBuilder newBuilder() {
        return new WxPayV3AppOrderDataBuilder();
    }

    public static class WxPayV3AppOrderDataBuilder {

        private String appid;

        private String partnerid;

        private String prepayid;

        public WxPayV3AppOrderDataBuilder appid(String appid) {
            this.appid = appid;
            return this;
        }

        public WxPayV3AppOrderDataBuilder partnerid(String partnerid) {
            this.partnerid = partnerid;
            return this;
        }

        public WxPayV3AppOrderDataBuilder prepayid(String prepayid) {
            this.prepayid = prepayid;
            return this;
        }

        public WxPayV3AppOrderData buildWithPrivateKey(PrivateKey privateKey) throws WxErrorException {
            if (StringUtils.isBlank(this.appid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "appid 必须提供值");
            }
            if (StringUtils.isBlank(this.partnerid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "partnerid 必须提供值");
            }
            if (StringUtils.isBlank(this.prepayid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "prepayid 必须提供值");
            }
            WxPayV3AppOrderData data = new WxPayV3AppOrderData(this.appid, this.partnerid, this.prepayid);
            StringBuilder toSign = new StringBuilder();
            toSign.append(data.appid).append("\n")
                    .append(data.timestamp).append("\n")
                    .append(data.noncestr).append("\n")
                    .append(data.prepayid).append("\n");
            data.paySign = SignUtils.createSHA256withRSASign(toSign.toString(), privateKey);

            return data;
        }
    }
}
