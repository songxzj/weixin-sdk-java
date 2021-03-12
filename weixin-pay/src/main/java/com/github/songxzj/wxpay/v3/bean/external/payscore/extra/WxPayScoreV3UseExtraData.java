package com.github.songxzj.wxpay.v3.bean.external.payscore.extra;

import cn.hutool.core.util.RandomUtil;
import com.github.songxzj.common.annotation.SignExclude;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import com.github.songxzj.wxpay.util.SignUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.StringUtils;

/**
 * 确认订单
 */
public class WxPayScoreV3UseExtraData extends AbstractWxPayScoreV3ExtraData {
    private static final long serialVersionUID = 6895679382582076057L;

    /**
     * 商户号
     * mch_id
     * string[1,32]
     * 是
     */
    private String mch_id;

    /**
     * 扩展字符串
     * package
     * string[1,128]
     * 是
     */
    @XStreamAlias("package")
    private String packageValue;


    /**
     * 时间戳
     * timestamp
     * string[1,32]
     * 是
     */
    private String timestamp;

    /**
     * 随机字符串
     * nonce_str
     * string[1,32]
     * 是
     */
    private String nonce_str;

    /**
     * 签名方式
     * sign_type
     * string[1,32]
     * 是
     */
    private String sign_type;

    /**
     * 签名
     * sign
     * string[1,64]
     * 是
     */
    @SignExclude
    private String sign;

    public WxPayScoreV3UseExtraData(String mchId, String packageValue, String mchKey) throws WxErrorException {
        this.mch_id = mchId;
        this.packageValue = packageValue;
        this.timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        this.nonce_str = RandomUtil.randomString(32);
        this.sign_type = WxPayConstants.SignType.HMAC_SHA256;
        this.sign = SignUtils.createSign(this, this.sign_type, mchKey, new String[0]);
    }

    public static WxPayScoreV3UseExtraDataBuilder newBuilder() {
        return new WxPayScoreV3UseExtraDataBuilder();
    }

    public static class WxPayScoreV3UseExtraDataBuilder {

        private String mchId;

        private String packageValue;

        public WxPayScoreV3UseExtraDataBuilder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public WxPayScoreV3UseExtraDataBuilder packageValue(String packageValue) {
            this.packageValue = packageValue;
            return this;
        }

        public WxPayScoreV3UseExtraData buildWithMchKey(String mchKey) throws WxErrorException {
            if (StringUtils.isBlank(mchKey)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "mchKey 必须提供值");
            }
            if (StringUtils.isBlank(this.mchId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "mchId 必须提供值");
            }
            if (StringUtils.isBlank(this.packageValue)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "packageValue 必须提供值");
            }
            return new WxPayScoreV3UseExtraData(this.mchId, this.packageValue, mchKey);
        }
    }


    @Override
    public String getQueryString() {
        StringBuffer queryString = new StringBuffer("mch_id=").append(urlEncode(this.mch_id));
        queryString.append("&package=").append(urlEncode(this.packageValue))
                .append("&timestamp=").append(urlEncode(this.timestamp))
                .append("&nonce_str=").append(urlEncode(this.nonce_str))
                .append("&sign_type=").append(urlEncode(this.sign_type))
                .append("&sign=").append(urlEncode(this.sign));

        return queryString.toString();
    }
}
