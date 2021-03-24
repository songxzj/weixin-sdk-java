package com.github.songxzj.wxpay.v2.bean.result.notify;

import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxPayNotifyResult extends BaseWxPayResult {
    private static final long serialVersionUID = -1910216372973299972L;

    /**
     * 设备号.
     * device_info
     * 否
     * String(32)
     * 013467007045764
     * 微信支付分配的终端设备号，
     */
    @XStreamAlias("device_info")
    private String deviceInfo;


    /**
     * 用户标识.
     * openid
     * 是
     * String(128)
     * wxd930ea5d5a258f4f
     * 用户在商户appid下的唯一标识
     */
    @XStreamAlias("openid")
    private String openid;


    /**
     * 是否关注公众账号.
     * is_subscribe
     * 否
     * String(1)
     * Y
     * 用户是否关注公众账号，Y-关注，N-未关注（机构商户不返回）
     */
    @XStreamAlias("is_subscribe")
    private String isSubscribe;

    /**
     * 用户子标识
     * sub_openid
     * 否
     * String(128)
     * wxd930ea5d5a258f4f
     * 用户在子商户appid下的唯一标识
     */
    @XStreamAlias("sub_openid")
    private String subOpenid;

    /**
     * 是否关注子公众账号
     * sub_is_subscribe
     * 否
     * String(1)
     * Y
     * 用户是否关注子公众账号，Y-关注，N-未关注（机构商户不返回）
     */
    @XStreamAlias("sub_is_subscribe")
    private String subIsSubscribe;


    /**
     * 交易类型.
     * trade_type
     * 是
     * String(16)
     * JSAPI
     * 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY，详细说明见参数规定
     */
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * 付款银行.
     * bank_type
     * 是
     * String(16)
     * CMC
     * 银行类型，采用字符串类型的银行标识
     */
    @XStreamAlias("bank_type")
    private String bankType;

    /**
     * 订单金额.
     * total_fee
     * 是
     * Int
     * 100
     * 订单总金额，单位为分
     */
    @XStreamAlias("total_fee")
    private Integer totalFee;


    /**
     * 货币种类.
     * fee_type
     * 否
     * String(8)
     * CNY
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @XStreamAlias("fee_type")
    private String feeType;


    /**
     * 现金支付金额.
     * cash_fee
     * 是
     * Int
     * 100
     * 现金支付金额订单现金支付金额，详见支付金额
     */
    @XStreamAlias("cash_fee")
    private Integer cashFee;

    /**
     * 现金支付货币类型.
     * cash_fee_type
     * 否
     * String(16)
     * CNY
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;

    /**
     * 应结订单金额.
     * settlement_total_fee
     * 否
     * Int
     * 100
     * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
     */
    @XStreamAlias("settlement_total_fee")
    private Integer settlementTotalFee;

    /**
     * 代金券金额.
     * coupon_fee
     * 否
     * Int
     * 100
     * “代金券或立减优惠”金额<=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额，详见支付金额
     */
    @XStreamAlias("coupon_fee")
    private Integer couponFee;

    /**
     * 代金券使用数量.
     * coupon_count
     * 否
     * Int
     * 1
     * 代金券或立减优惠使用数量
     */
    @XStreamAlias("coupon_count")
    private Integer couponCount;

    private List<Coupon> coupons;
    /**
     * 微信支付订单号.
     * transaction_id
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号.
     * out_trade_no
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 商家数据包
     * attach
     * 否
     * String(128)
     * 123456
     * 商家数据包，原样返回
     */
    @XStreamAlias("attach")
    private String attach;

    /**
     * 支付完成时间.
     * time_end
     * 是
     * String(14)
     * 20141030133525
     * 订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    @XStreamAlias("time_end")
    private String timeEnd;


    /**
     * 字段名：营销详情.
     * 变量名：promotion_detail
     * 是否必填：否，单品优惠才有
     * 类型：String(6000)
     * 示例值：[{"promotion_detail":[{"promotion_id":"109519","name":"单品惠-6","scope":"SINGLE","type":"DISCOUNT","amount":5,"activity_id":"931386","wxpay_contribute":0,"merchant_contribute":0,"other_contribute":5,"goods_detail":[{"goods_id":"a_goods1","goods_remark":"商品备注","quantity":7,"price":1,"discount_amount":4},{"goods_id":"a_goods2","goods_remark":"商品备注","quantity":1,"price":2,"discount_amount":1}]}]}
     * 描述：单品优惠专用参数，详见https://pay.weixin.qq.com/wiki/doc/api/danpin.php?chapter=9_201&index=3
     */
    @XStreamAlias("promotion_detail")
    private String promotionDetail;

    @Override
    public void compose() {
        composeCoupons();
    }

    /**
     * 通过xml组装coupons属性内容.
     */
    public void composeCoupons() {
        if (this.couponCount != null && this.couponCount > 0) {
            this.coupons = Lists.newArrayList();
            for (int i = 0; i < this.couponCount; i++) {
                this.coupons.add(new Coupon(this.getXmlValue("xml/coupon_id_" + i),
                        this.getXmlValue("xml/coupon_type_" + i),
                        this.getXmlValueAsInt("xml/coupon_fee_" + i)));
            }
        }
    }

    /**
     * 从XML结构中加载额外的熟悉
     *
     * @param d Document
     */
    @Override
    protected void loadXml(Document d) {
        this.deviceInfo = readXmlString(d, "device_info");
        this.openid = readXmlString(d, "openid");
        this.isSubscribe = readXmlString(d, "is_subscribe");
        this.subOpenid = readXmlString(d, "sub_openid");
        this.subIsSubscribe = readXmlString(d, "sub_is_subscribe");
        this.tradeType = readXmlString(d, "trade_type");
        this.bankType = readXmlString(d, "bank_type");
        this.totalFee = readXmlInteger(d, "total_fee");
        this.feeType = readXmlString(d, "fee_type");
        this.settlementTotalFee = readXmlInteger(d, "settlement_total_fee");
        this.cashFee = readXmlInteger(d, "cash_fee");
        this.cashFeeType = readXmlString(d, "cash_fee_type");
        this.couponFee = readXmlInteger(d, "coupon_fee");
        this.couponCount = readXmlInteger(d, "coupon_count");
        this.transactionId = readXmlString(d, "transaction_id");
        this.outTradeNo = readXmlString(d, "out_trade_no");
        this.attach = readXmlString(d, "attach");
        this.timeEnd = readXmlString(d, "time_end");
        this.promotionDetail = readXmlString(d, "promotion_detail");
    }

    /**
     * The type Coupon.
     */
    @Setter
@Getter
@ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Coupon implements Serializable {
        private static final long serialVersionUID = 2804713926351456949L;

        /**
         * 代金券ID.
         * coupon_id_$n
         * 否
         * String(20)
         * 10000
         * 代金券ID, $n为下标，从0开始编号
         */
        private String couponId;

        /**
         * 代金券类型.
         * coupon_type_$n
         * 否
         * String
         * CASH
         * <li>CASH--充值代金券
         * <li>NO_CASH---非充值代金券
         * 订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
         */
        private String couponType;


        /**
         * 单个代金券支付金额.
         * coupon_fee_$n
         * 否
         * Int
         * 100
         * 单个代金券支付金额, $n为下标，从0开始编号
         */
        private Integer couponFee;
    }

}