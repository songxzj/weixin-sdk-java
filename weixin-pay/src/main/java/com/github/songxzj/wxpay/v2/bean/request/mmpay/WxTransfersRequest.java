package com.github.songxzj.wxpay.v2.bean.request.mmpay;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.mmpay.WxTransfersResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 企业付款
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxTransfersRequest extends BaseWxPayRequest<WxTransfersResult> {
    private static final long serialVersionUID = -7230472184303853130L;

    /**
     * 商户appid	mch_appid
     * 是
     * wx8888888888888888
     * String(128)
     * 申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）
     */
    @Required
    @XStreamAlias("mch_appid")
    private String mchAppid;

    /**
     * 商户号
     * mchid
     * 是
     * 1900000109
     * String(32)
     * 微信支付分配的商户号
     */
    @Required
    @XStreamAlias("mchid")
    private String mchid;

    /**
     * 设备号
     * device_info
     * 否
     * 123456sb
     * String(32)
     * 微信支付分配的终端设备号，
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 商户订单号	partner_trade_no
     * 是
     * 1217752501201407033233368018
     * String(32)
     * 商户订单号，需保持历史全局唯一性(只能是字母或者数字，不能包含有其它字符)
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 用户openid
     * openid
     * 是
     * oxTWIuGaIt6gTKsQRLau2M0yL16E
     * String(64)
     * 商户appid下，某用户的openid
     */
    @Required
    @XStreamAlias("openid")
    private String openid;

    /**
     * 校验用户姓名选项
     * check_name
     * 是
     * FORCE_CHECK
     * String(16)
     * NO_CHECK：不校验真实姓名
     * FORCE_CHECK：强校验真实姓名
     */
    @Required
    @XStreamAlias("check_name")
    private String checkName;

    /**
     * 收款用户姓名
     * re_user_name
     * 否
     * 王小王
     * String(64)
     * 收款用户真实姓名。
     * 如果check_name设置为FORCE_CHECK，则必填用户真实姓名
     * 如需电子回单，需要传入收款用户姓名
     */
    @XStreamAlias("re_user_name")
    private String reUserName;

    /**
     * 金额
     * amount
     * 是
     * 10099
     * int
     * 企业付款金额，单位为分
     */
    @Required
    @XStreamAlias("amount")
    private Integer amount;

    /**
     * 企业付款备注
     * desc
     * 是
     * 理赔
     * String(100)
     * 企业付款备注，必填。注意：备注中的敏感词会被转成字符*
     */
    @Required
    @XStreamAlias("desc")
    private String desc;

    /**
     * Ip地址
     * spbill_create_ip
     * 否
     * 192.168.0.1
     * String(32)
     * 该IP同在商户平台设置的IP白名单中的IP没有关联，该IP可传用户端或者服务端的IP。
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"appid", "mch_id", "sign_type"};
    }

    @Override
    public String routing() {
        return "/mmpaymkttransfers/promotion/transfers";
    }

    @Override
    public Class<WxTransfersResult> getResultClass() {
        return WxTransfersResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if ("FORCE_CHECK".equals(this.checkName) && StringUtils.isBlank(this.reUserName)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "check_name 设置为 FORCE_CHECK，则必填用户真实姓名");
        }
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("mch_appid", this.mchAppid);
        map.put("mchid", this.mchid);
        map.put("device_info", this.deviceInfo);
        map.put("partner_trade_no", this.partnerTradeNo);
        map.put("openid", this.openid);
        map.put("check_name", this.checkName);
        map.put("re_user_name", this.reUserName);
        map.put("amount", this.amount.toString());
        map.put("desc", this.desc);
        map.put("spbill_create_ip", this.spbillCreateIp);
    }
}
