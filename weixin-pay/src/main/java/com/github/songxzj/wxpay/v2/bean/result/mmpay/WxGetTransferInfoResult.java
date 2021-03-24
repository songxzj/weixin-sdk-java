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
public class WxGetTransferInfoResult extends BaseWxPayResult {
    private static final long serialVersionUID = 1171164194735408238L;

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
     * 付款单号
     * detail_id
     * 是
     * 1000000000201503283103439304
     * String(64)
     * 调用企业付款API时，微信系统内部产生的单号
     */
    @XStreamAlias("detail_id")
    private String detailId;

    /**
     * 转账状态
     * status
     * 是
     * SUCCESS
     * string(16)
     * SUCCESS:转账成功
     * FAILED:转账失败
     * PROCESSING:处理中
     */
    @XStreamAlias("status")
    private String status;

    /**
     * 失败原因
     * reason
     * 否
     * 余额不足
     * String(128)
     * 如果失败则有失败原因
     */
    @XStreamAlias("reason")
    private String reason;

    /**
     * 收款用户openid
     * openid
     * 是
     * oxTWIuGaIt6gTKsQRLau2M0yL16E
     * String(64)
     * 转账的openid
     */
    @XStreamAlias("openid")
    private String openid;

    /**
     * 收款用户姓名
     * transfer_name
     * 否
     * 马华
     * String(64)
     * 收款用户姓名
     */
    @XStreamAlias("transfer_name")
    private String transferName;

    /**
     * 付款金额
     * payment_amount
     * 是
     * 5000
     * int
     * 付款金额单位为“分”
     */
    @XStreamAlias("payment_amount")
    private Integer paymentAmount;

    /**
     * 转账时间
     * transfer_time
     * 是
     * 2015-04-21 20:00:00
     * String(32)
     * 发起转账的时间
     */
    @XStreamAlias("transfer_time")
    private String transferTime;

    /**
     * 付款成功时间
     * payment_time
     * 是
     * 2015-04-21 20:01:00
     * String(32)
     * 企业付款成功时间
     */
    @XStreamAlias("payment_time")
    private String paymentTime;

    /**
     * 企业付款备注
     * desc
     * 是
     * 车险理赔
     * String(100)
     * 企业付款备注
     */
    @XStreamAlias("desc")
    private String desc;

    @Override
    protected void loadXml(Document d) {
        this.partnerTradeNo = readXmlString(d, "partner_trade_no");
        this.detailId = readXmlString(d, "detail_id");
        this.status = readXmlString(d, "status");
        this.reason = readXmlString(d, "reason");
        this.openid = readXmlString(d, "openid");
        this.transferName = readXmlString(d, "transfer_name");
        this.paymentAmount = readXmlInteger(d, "payment_amount");
        this.transferTime = readXmlString(d, "transfer_time");
        this.paymentTime = readXmlString(d, "payment_time");
        this.desc = readXmlString(d, "desc");
    }
}
