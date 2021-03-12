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
public class WxProfitSharingOrderAmountQueryResult extends BaseWxPayResult {
    private static final long serialVersionUID = -5870036551355650779L;

    /**
     * 返回信息
     * err_msg
     * 否
     * string(256)
     * 参数格式校验错误
     * 如果返回状态码为FAIL，则本字段存在，且为失败的错误信息
     */
    @XStreamAlias("err_msg")
    private String errMsg;

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
     * 订单剩余待分金额
     * unsplit_amount
     * 是
     * int
     * 1000
     * 订单剩余待分金额，整数，单位为分
     */
    @XStreamAlias("unsplit_amount")
    private Integer unsplitAmount;

    @Override
    protected void loadXml(Document d) {
        this.errMsg = readXmlString(d, "err_msg");
        this.transactionId = readXmlString(d, "transaction_id");
        this.unsplitAmount = readXmlInteger(d, "unsplit_amount");
    }
}
