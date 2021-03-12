package com.github.songxzj.wxpay.v2.bean.result.profitsharing;

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
public class WxProfitSharingQueryResult extends BaseWxPayResult {
    private static final long serialVersionUID = -8822603716265187341L;

    /**
     * 微信订单号
     * transaction_id
     * 是
     * string(32)
     * 4208450740201411110007820472
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户分账单号
     * out_order_no
     * 是
     * string(64)
     * P20150806125346
     * 调用接口提供的商户系统内部的分账单号
     */
    @XStreamAlias("out_order_no")
    private String outOrderNo;

    /**
     * 微信分账单号
     * order_id
     * 是
     * string(64)
     * 3008450740201411110007820472
     * 微信分账单号，微信系统返回的唯一标识
     */
    @XStreamAlias("order_id")
    private String orderId;


    /**
     * 分账单状态
     * status
     * 是
     * string(16)
     * SUCCESS
     * 分账单状态：
     * PROCESSING—处理中
     * FINISHED—处理完成
     */
    @XStreamAlias("status")
    private String status;

    /**
     * 关单原因
     * close_reason
     * 否
     * string(32)
     * NO_AUTH
     * NO_AUTH:分账授权已解除
     */
    @XStreamAlias("close_reason")
    private String closeReason;

    /**
     * 分账接收方列表
     * receivers
     * 是
     * string(10240)
     * 分账接收方列表，不超过50个json对象，仅当查询分账结果时，存在本字段
     * 点击行前的+展开字段详情
     */
    @XStreamAlias("receivers")
    private String receivers;

    /**
     * 分账金额
     * amount
     * 是
     * int
     * 888
     * 分账完结的分账金额，单位为分， 仅当查询分账完结的执行结果时，存在本字段
     */
    @XStreamAlias("amount")
    private Integer amount;

    /**
     * 分账描述
     * description
     * 是
     * string(80)
     * 分给商户A
     * 分账完结的原因描述，仅当查询分账完结的执行结果时，存在本字段
     */
    @XStreamAlias("description")
    private String description;


    @Override
    protected void loadXml(Document d) {
        this.transactionId = readXmlString(d, "transaction_id");
        this.outOrderNo = readXmlString(d, "out_order_no");
        this.orderId = readXmlString(d, "order_id");
        this.status = readXmlString(d, "status");
        this.closeReason = readXmlString(d, "close_reason");
        this.receivers = readXmlString(d, "receivers");
        this.amount = readXmlInteger(d, "amount");
        this.description = readXmlString(d, "description");
    }
}
