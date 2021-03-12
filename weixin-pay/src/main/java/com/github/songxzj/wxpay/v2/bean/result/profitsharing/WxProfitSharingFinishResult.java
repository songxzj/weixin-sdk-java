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
public class WxProfitSharingFinishResult extends BaseWxPayResult {
    private static final long serialVersionUID = 6761000920310148645L;

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
     * 品牌主商户号
     * brand_mch_id
     * 否
     * string(32)
     * 1900000108
     * 调用接口时提供的品牌主商户号。
     */
    @XStreamAlias("brand_mch_id")
    private String brandMchId;

    @Override
    protected void loadXml(Document d) {
        this.transactionId = readXmlString(d, "transaction_id");
        this.outOrderNo = readXmlString(d, "out_order_no");
        this.orderId = readXmlString(d, "order_id");
        this.brandMchId = readXmlString(d, "brand_mch_id");
    }
}
