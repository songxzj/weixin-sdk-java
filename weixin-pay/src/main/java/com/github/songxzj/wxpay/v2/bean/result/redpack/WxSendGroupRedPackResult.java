package com.github.songxzj.wxpay.v2.bean.result.redpack;

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
public class WxSendGroupRedPackResult extends BaseWxPayResult {
    private static final long serialVersionUID = -8685307763232528724L;
    /**
     * 商户订单号
     * mch_billno
     * 是
     * 10000098201411111234567890
     * String(28)
     * 商户订单号（每个订单号必须唯一）
     * 组成：mch_id+yyyymmdd+10位一天内不能重复的数字
     */
    @XStreamAlias("mch_billno")
    private String mchBillno;

    /**
     * 公众账号appid
     * wxappid
     * 是
     * wx8888888888888888
     * String(32)
     * 商户appid，接口传入的所有appid应该为公众号的appid（在mp.weixin.qq.com申请的），不能为APP的appid（在open.weixin.qq.com申请的）。
     */
    @XStreamAlias("wxappid")
    private String wxappid;


    /**
     * 用户openid
     * re_openid
     * 是
     * oxTWIuGaIt6gTKsQRLau2M0yL16E
     * String(32)
     * 接受收红包的用户
     * 用户在wxappid下的openid
     */
    @XStreamAlias("re_openid")
    private String reOpenid;

    /**
     * 付款金额
     * total_amount
     * 是
     * 1000
     * int
     * 付款金额，单位分
     */
    @XStreamAlias("total_amount")
    private Integer totalAmount;

    /**
     * 微信单号
     * send_listid
     * 是
     * 100000000020150520314766074200
     * String(32)
     * 红包订单的微信单号
     */
    @XStreamAlias("send_listid")
    private String sendListid;

    @Override
    protected void loadXml(Document d) {
        this.mchBillno = readXmlString(d, "mch_billno");
        this.wxappid = readXmlString(d, "wxappid");
        this.reOpenid = readXmlString(d, "re_openid");
        this.totalAmount = readXmlInteger(d, "total_amount");
        //sendTime = readXmlString(d, "send_time");
        this.sendListid = readXmlString(d, "send_listid");
    }
}
