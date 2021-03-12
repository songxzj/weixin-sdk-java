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
public class WxProfitSharingRemoveReceiverResult extends BaseWxPayResult {
    private static final long serialVersionUID = 590617735182307842L;
    /**
     * 分账接收方
     * receiver
     * 是
     * String(128)
     * {"type":"MERCHANT_ID","account":"190001001" }
     * 分账接收方对象（不包含分账接收方全称），json格式
     */
    @XStreamAlias("receiver")
    private String receiver;



    @Override
    protected void loadXml(Document d) {
        this.receiver = readXmlString(d, "receiver");
    }
}
