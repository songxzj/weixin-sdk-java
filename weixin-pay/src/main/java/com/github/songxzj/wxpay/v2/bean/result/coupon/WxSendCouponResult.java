package com.github.songxzj.wxpay.v2.bean.result.coupon;

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
public class WxSendCouponResult extends BaseWxPayResult {
    private static final long serialVersionUID = -4419007735603092462L;

    /**
     * 设备号
     * device_info
     * 否
     * 123456sb
     * String(32)
     * 微信支付分配的终端设备号，
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 代金券批次id
     * coupon_stock_id
     * 是
     * 1757
     * String
     * 创建代金券时生成的批次号，可在商户平台-代金券管理页面查看
     */
    @XStreamAlias("coupon_stock_id")
    private String couponStockId;

    /**
     * 返回记录数
     * resp_count
     * 是
     * 1
     * Int
     * 返回记录数
     */
    @XStreamAlias("resp_count")
    private Integer respCount;

    /**
     * 成功记录数
     * success_count
     * 是
     * 1或者0
     * Int
     * 成功记录数
     */
    @XStreamAlias("success_count")
    private Integer successCount;

    /**
     * 失败记录数
     * failed_count
     * 是
     * 1或者0
     * Int
     * 失败记录数
     */
    @XStreamAlias("failed_count")
    private Integer failedCount;

    /**
     * 用户标识
     * openid
     * 是
     * onqOjjrXT-776SpHnfexGm1_P7iE
     * String
     * 用户在商户appid下的唯一标识
     */
    @XStreamAlias("openid")
    private String openid;

    /**
     * 返回码
     * ret_code
     * 是
     * SUCCESS或者FAILED
     * String
     * 返回码，SUCCESS/FAILED
     * </pre>
     */
    @XStreamAlias("ret_code")
    private String retCode;

    /**
     * 代金券id
     * coupon_id
     * 是
     * 1870
     * String
     * 对一个用户成功发放代金券则返回代金券id，即ret_code为SUCCESS的时候；
     * 如果ret_code为FAILED则填写空串""
     */
    @XStreamAlias("coupon_id")
    private String couponId;

    /**
     * 返回信息
     * ret_msg
     * 是
     * 失败描述信息，例如：“用户已达领用上限”
     * String
     * 返回信息，当返回码是FAILED的时候填写，否则填空串“”
     */
    @XStreamAlias("ret_msg")
    private String retMsg;

    @Override
    protected void loadXml(Document d) {
        this.deviceInfo = readXmlString(d, "device_info");
        this.couponStockId = readXmlString(d, "coupon_stock_id");
        this.respCount = readXmlInteger(d, "resp_count");
        this.successCount = readXmlInteger(d, "success_count");
        this.failedCount = readXmlInteger(d, "failed_count");
        this.openid = readXmlString(d, "openid");
        this.retCode = readXmlString(d, "ret_code");
        this.couponId = readXmlString(d, "coupon_id");
        this.retMsg = readXmlString(d, "ret_msg");
    }
}
