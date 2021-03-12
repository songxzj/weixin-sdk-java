package com.github.songxzj.wxpay.v2.bean.result.pay;


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
public class WxPayCloseOrderResult extends BaseWxPayResult {
    private static final long serialVersionUID = 5595349715721632918L;


    /**
     * 业务结果描述
     * result_msg
     * 是
     * String(16)
     * OK
     * 对业务结果的补充说明
     **/
    @XStreamAlias("result_msg")
    private String resultMsg;


    @Override
    protected void loadXml(Document d) {
        this.resultMsg = readXmlString(d, "result_msg");
    }
}
