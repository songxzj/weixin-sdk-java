package com.github.songxzj.wxpay.v2.bean.result.risk;

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
public class WxGetPublicKeyResult extends BaseWxPayResult {
    private static final long serialVersionUID = 2698121887315691730L;

    /**
     * 密钥
     * pub_key
     * 是
     * String(2048)
     * RSA 公钥
     **/
    @XStreamAlias("pub_key")
    private String pubKey;

    @Override
    protected void loadXml(Document d) {
        this.pubKey = readXmlString(d, "pub_key");
    }
}
