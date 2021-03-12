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
public class WxQueryCouponsInfoResult extends BaseWxPayResult {
    private static final long serialVersionUID = -6573870109803331996L;

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
     * 批次ID
     * coupon_stock_id
     * 是
     * 1567
     * String
     * 代金券批次Id
     */
    @XStreamAlias("coupon_stock_id")
    private String couponStockId;

    /**
     * 代金券id
     * coupon_id
     * 是
     * 4242
     * String
     * 代金券id
     */
    @XStreamAlias("coupon_id")
    private String couponId;

    /**
     * 代金券面额
     * coupon_value
     * 是
     * 4
     * Unsinged int
     * 代金券面值,单位是分
     */
    @XStreamAlias("coupon_value")
    private Integer couponValue;

    /**
     * 代金券使用门槛
     * coupon_minimum
     * 是
     * 10
     * Unsinged int
     * 代金券使用最低限额,单位是分
     */
    @XStreamAlias("coupon_minimum")
    private Integer couponMinimum;

    /**
     * 代金券名称
     * coupon_name
     * 是
     * 测试代金券
     * String
     * 代金券名称
     */
    @XStreamAlias("coupon_name")
    private String couponName;

    /**
     * 代金券状态
     * coupon_state
     * 是
     * SENDED
     * String
     * 代金券状态：SENDED-可用，USED-已实扣，EXPIRED-已过期
     */
    @XStreamAlias("coupon_state")
    private String couponState;

    /**
     * 代金券描述
     * coupon_desc
     * 是
     * 微信支付-代金券
     * String
     * 代金券描述
     */
    @XStreamAlias("coupon_desc")
    private String couponDesc;

    /**
     * 实际优惠金额
     * coupon_use_value
     * 是
     * 0
     * Unsinged int
     * 代金券实际使用金额
     */
    @XStreamAlias("coupon_use_value")
    private Integer couponUseValue;

    /**
     * 优惠剩余可用额
     * coupon_remain_value
     * 是
     * 4
     * Unsinged int
     * 代金券剩余金额：部分使用情况下，可能会存在券剩余金额
     */
    @XStreamAlias("coupon_remain_value")
    private Integer couponRemainValue;

    /**
     * 发放来源
     * send_source
     * 是
     * FULL_SEND
     * String
     * 代金券发放来源：FULL_SEND-满送 NORMAL-普通发放场景
     */
    @XStreamAlias("send_source")
    private String sendSource;


    /**
     * 是否允许部分使用
     * is_partial_use
     * 否
     * 1
     * String
     * 该代金券是否允许部分使用标识：1-表示支持部分使用
     */
    @XStreamAlias("is_partial_use")
    private String isPartialUse;

    @Override
    protected void loadXml(Document d) {
        this.deviceInfo = readXmlString(d, "device_info");
        this.couponStockId = readXmlString(d, "coupon_stock_id");
        this.couponId = readXmlString(d, "coupon_id");
        this.couponValue = readXmlInteger(d, "coupon_value");
        this.couponMinimum = readXmlInteger(d, "coupon_minimum");
        this.couponName = readXmlString(d, "coupon_name");
        this.couponState = readXmlString(d, "coupon_state");
        this.couponDesc = readXmlString(d, "coupon_desc");
        this.couponUseValue = readXmlInteger(d, "coupon_use_value");
        this.couponRemainValue = readXmlInteger(d, "coupon_remain_value");
        this.sendSource = readXmlString(d, "send_source");
        this.isPartialUse = readXmlString(d, "is_partial_use");
    }
}

