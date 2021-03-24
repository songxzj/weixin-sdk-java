/*package com.github.songxzj.wxpay.v2.bean.result.micro;

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
public class WxMicroSubmitResult extends BaseWxPayResult {
    private static final long serialVersionUID = 1569904795662168417L;
    */
/**
     * 商户申请单号
     * applyment_id
     * 是
     * String(32)
     * 1230000109
     * 微信支付分配的申请单号
     **//*

    @XStreamAlias("applyment_id")
    private String applymentId;

    @Override
    protected void loadXml(Document d) {
        applymentId = readXmlString(d, "applyment_id");
    }
}
*/
