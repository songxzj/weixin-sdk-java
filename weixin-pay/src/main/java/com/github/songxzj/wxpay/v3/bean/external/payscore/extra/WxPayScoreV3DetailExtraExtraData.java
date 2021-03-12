package com.github.songxzj.wxpay.v3.bean.external.payscore.extra;

import cn.hutool.core.util.RandomUtil;
import com.github.songxzj.common.annotation.SignExclude;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import com.github.songxzj.wxpay.util.SignUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 订单详情
 */
public class WxPayScoreV3DetailExtraExtraData extends AbstractWxPayScoreV3ExtraData {
    private static final long serialVersionUID = 8360600017404109454L;
    /**
     * 商户号
     * mch_id
     * string[1,32]
     * 是
     */
    private String mch_id;

    /**
     * 服务ID
     * service_id
     * string[1,32]
     * 是
     */
    private String service_id;

    /**
     * 商户服务订单号
     * out_order_no
     * string[1,32]
     * 是
     */
    private String out_order_no;

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

    private WxPayScoreV3DetailExtraExtraData(String mchId, String serviceId, String outOrderNo, String mchKey) throws WxErrorException {
        this.mch_id = mchId;
        this.service_id = serviceId;
        this.out_order_no = outOrderNo;
        this.timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        this.nonce_str = RandomUtil.randomString(32);
        this.sign_type = WxPayConstants.SignType.HMAC_SHA256;
        this.sign = SignUtils.createSign(this, this.sign_type, mchKey, new String[0]);
    }

    public static WxPayScoreV3DetailExtraExtraDataBuilder newBuilder() {
        return new WxPayScoreV3DetailExtraExtraDataBuilder();
    }

    public static class WxPayScoreV3DetailExtraExtraDataBuilder {

        private String mchId;

        private String serviceId;

        private String outOrderNo;

        public WxPayScoreV3DetailExtraExtraDataBuilder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public WxPayScoreV3DetailExtraExtraDataBuilder serviceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public WxPayScoreV3DetailExtraExtraDataBuilder outOrderNo(String outOrderNo) {
            this.outOrderNo = outOrderNo;
            return this;
        }

        public WxPayScoreV3DetailExtraExtraData buildWithMchKey(String mchKey) throws WxErrorException {
            if (StringUtils.isBlank(mchKey)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "mchKey 必须提供值");
            }
            if (StringUtils.isBlank(this.mchId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "mchId 必须提供值");
            }
            if (StringUtils.isBlank(this.serviceId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "serviceId 必须提供值");
            }
            if (StringUtils.isBlank(this.outOrderNo)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "outOrderNo 必须提供值");
            }
            return new WxPayScoreV3DetailExtraExtraData(this.mchId, this.serviceId, this.outOrderNo, mchKey);
        }
    }

    @Override
    public String getQueryString() {
        StringBuffer queryString = new StringBuffer("mch_id=").append(urlEncode(this.mch_id));
        queryString.append("&service_id=").append(urlEncode(this.service_id))
                .append("&out_order_no=").append(urlEncode(this.out_order_no))
                .append("&timestamp=").append(urlEncode(this.timestamp))
                .append("&nonce_str=").append(urlEncode(this.nonce_str))
                .append("&sign_type=").append(urlEncode(this.sign_type))
                .append("&sign=").append(urlEncode(this.sign));

        return queryString.toString();
    }

}
