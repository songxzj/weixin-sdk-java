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
public class WxQueryBankResult extends BaseWxPayResult {
    private static final long serialVersionUID = -1882302256299351814L;

    /**
     * 商户企业付款单号
     * partner_trade_no
     * 是
     * string(32)
     * 商户单号
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 微信企业付款单号
     * payment_no
     * 是
     * string(64)
     * 即为微信内部业务单号
     */
    @XStreamAlias("payment_no")
    private String paymentNo;

    /**
     * 银行卡号
     * bank_no_md5
     * 是
     * string(32)
     * 收款用户银行卡号(MD5加密)
     */
    @XStreamAlias("bank_no_md5")
    private String bankNoMd5;

    /**
     * 用户真实姓名
     * true_name_md5
     * 是
     * string(32)
     * 收款人真实姓名（MD5加密）
     */
    @XStreamAlias("true_name_md5")
    private String trueNameMd5;

    /**
     * 代付金额
     * amount
     * 是
     * int
     * 代付订单金额RMB：分
     */
    @XStreamAlias("amount")
    private Integer amount;

    /**
     * 代付单状态
     * status
     * 是
     * string(16)
     * 代付订单状态：
     * PROCESSING（处理中，如有明确失败，则返回额外失败原因；否则没有错误原因）
     * SUCCESS（付款成功）
     * FAILED（付款失败,需要替换付款单号重新发起付款）
     * BANK_FAIL（银行退票，订单状态由付款成功流转至退票,退票时付款金额和手续费会自动退还）
     */
    @XStreamAlias("status")
    private String status;

    /**
     * 手续费金额
     * cmms_amt
     * 是
     * int
     * 手续费订单金额 RMB：分
     */
    @XStreamAlias("cmms_amt")
    private Integer cmmsAmt;

    /**
     * 商户下单时间
     * create_time
     * 是
     * String(32)
     * 微信侧订单创建时间
     */
    @XStreamAlias("create_time")
    private String createTime;

    /**
     * 成功付款时间
     * pay_succ_time
     * 否
     * String(32)
     * 微信侧付款成功时间（依赖银行的处理进度，可能出现延迟返回，甚至被银行退票的情况）
     */
    @XStreamAlias("pay_succ_time")
    private String paySuccTime;

    /**
     * 失败原因
     * reason
     * 否
     * String(128)
     * 订单失败原因（如：余额不足）
     */
    @XStreamAlias("reason")
    private String reason;

    @Override
    protected void loadXml(Document d) {
        this.partnerTradeNo = readXmlString(d, "partner_trade_no");
        this.paymentNo = readXmlString(d, "payment_no");
        this.bankNoMd5 = readXmlString(d, "bank_no_md5");
        this.trueNameMd5 = readXmlString(d, "true_name_md5");
        this.amount = readXmlInteger(d, "amount");
        this.status = readXmlString(d, "status");
        this.cmmsAmt = readXmlInteger(d, "cmms_amt");
        this.createTime = readXmlString(d, "create_time");
        this.paySuccTime = readXmlString(d, "pay_succ_time");
        this.reason = readXmlString(d, "reason");
    }
}
