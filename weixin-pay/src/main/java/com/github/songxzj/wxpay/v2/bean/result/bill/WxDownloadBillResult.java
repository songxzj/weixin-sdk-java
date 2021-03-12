package com.github.songxzj.wxpay.v2.bean.result.bill;

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
public class WxDownloadBillResult extends BaseWxPayResult {
    private static final long serialVersionUID = -3365075743431230151L;




    @Override
    protected void loadXml(Document d) {
    }
}
