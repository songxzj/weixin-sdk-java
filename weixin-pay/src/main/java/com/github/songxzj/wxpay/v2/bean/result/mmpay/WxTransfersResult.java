package com.github.songxzj.wxpay.v2.bean.result.mmpay;

import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxTransfersResult extends BaseWxPayResult {
    private static final long serialVersionUID = -3513530505954909692L;

    /**
     * 商户appid	mch_appid
     * 是
     * wx8888888888888888
     * String(128)
     * 申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）
     */
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
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 微信付款单号
     * payment_no
     * 是
     * 1007752501201407033233368018
     * String(64)
     * 企业付款成功，返回的微信付款单号
     */
    @XStreamAlias("payment_no")
    private String paymentNo;

    /**
     * 付款成功时间
     * payment_time
     * 是
     * 2015-05-19 15：26：59
     * String(32)
     * 企业付款成功时间
     */
    @XStreamAlias("payment_time")
    private String paymentTime;

    @Override
    protected void loadXml(Document d) {
        this.mchAppid = readXmlString(d, "mch_appid");
        this.mchid = readXmlString(d, "mchid");
        this.deviceInfo = readXmlString(d, "device_info");
        this.partnerTradeNo = readXmlString(d, "partner_trade_no");
        this.paymentNo = readXmlString(d, "payment_no");
        this.paymentTime = readXmlString(d, "payment_time");
    }
}
