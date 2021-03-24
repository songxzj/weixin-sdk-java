package com.github.songxzj.wxpay.v2.bean.result.pay;

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
public class WxPayitilReportResult extends BaseWxPayResult {
    private static final long serialVersionUID = -6057942155324516902L;

    @Override
    protected void loadXml(Document d) {

    }
}
