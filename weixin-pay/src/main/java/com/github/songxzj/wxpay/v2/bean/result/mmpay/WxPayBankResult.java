package com.github.songxzj.wxpay.v2.bean.result.mmpay;

import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxPayBankResult extends BaseWxPayResult {
    private static final long serialVersionUID = 4641026071362304047L;

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
     * 代付金额
     * amount
     * 是
     * int
     * 代付金额RMB:分
     */
    @XStreamAlias("amount")
    private Integer amount;

    /**
     * 微信企业付款单号
     * payment_no
     * 是
     * string(64)
     * 代付成功后，返回的内部业务单号
     */
    @XStreamAlias("payment_no")
    private String paymentNo;

    /**
     * 手续费金额
     * cmms_amt
     * 是
     * int
     * 手续费金额 RMB：分
     */
    @XStreamAlias("cmms_amt")
    private Integer cmmsAmt;

    @Override
    protected void loadXml(Document d) {
        this.partnerTradeNo = readXmlString(d, "partner_trade_no");
        this.amount = readXmlInteger(d, "amount");
        this.paymentNo = readXmlString(d, "payment_no");
        this.cmmsAmt = readXmlInteger(d, "cmms_amt");
    }
}
