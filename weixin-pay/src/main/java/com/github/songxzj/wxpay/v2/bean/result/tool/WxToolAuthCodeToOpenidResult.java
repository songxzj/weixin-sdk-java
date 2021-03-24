package com.github.songxzj.wxpay.v2.bean.result.tool;

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
public class WxToolAuthCodeToOpenidResult extends BaseWxPayResult {
    private static final long serialVersionUID = -1431914561026335909L;

    /**
     * 用户标识.
     * openid
     * 是
     * String(128)
     * 用户在商户appid 下的唯一标识
     **/
    @XStreamAlias("openid")
    private String openid;

    /**
     * 用户子标识
     * sub_openid
     * 否
     * String(128)
     * 用户在子商户appid下的唯一标识
     **/
    @XStreamAlias("sub_openid")
    private String subOpenid;


    @Override
    protected void loadXml(Document d) {
        this.openid = readXmlString(d, "openid");
        this.subOpenid = readXmlString(d, "sub_openid");
    }
}
