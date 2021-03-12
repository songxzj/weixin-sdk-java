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
public class WxPayUnifiedOrderResult extends BaseWxPayResult {
    private static final long serialVersionUID = -7711770890008302641L;


    /**
     * 交易类型
     * trade_type
     * 是
     * String(16)
     * JSAPI
     * JSAPI 公众号支付
     * NATIVE Native支付
     * APP APP支付
     * 说明详见参数规定
     **/
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * 预支付交易会话标识
     * prepay_id
     * 是
     * String(64)
     * wx201410272009395522657a690389285100
     * 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    @XStreamAlias("prepay_id")
    private String prepayId;

    /**
     * 二维码链接
     * code_url
     * 否
     * String(64)
     * weixin://wxpay/bizpayurl/up?pr=NwY5Mz9&groupid=00
     * trade_type=NATIVE时有返回，此url用于生成支付二维码，然后提供给用户进行扫码支付。
     * 注意：code_url的值并非固定，使用时按照URL格式转成二维码即可
     */
    @XStreamAlias("code_url")
    private String codeUrl;

    /**
     * 支付跳转链接
     * mweb_url
     * 是
     * String(64)
     */
    @XStreamAlias("mweb_url")
    private String mwebUrl;


    /**
     * 从XML结构中加载额外的熟悉
     *
     * @param d Document
     */
    @Override
    protected void loadXml(Document d) {
        this.tradeType = readXmlString(d, "trade_type");
        this.prepayId = readXmlString(d, "prepay_id");
        this.codeUrl = readXmlString(d, "code_url");
        this.mwebUrl = readXmlString(d, "mweb_url");
    }

}
