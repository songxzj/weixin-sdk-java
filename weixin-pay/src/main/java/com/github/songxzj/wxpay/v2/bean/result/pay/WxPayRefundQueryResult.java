package com.github.songxzj.wxpay.v2.bean.result.pay;


import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

import java.io.Serializable;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxPayRefundQueryResult extends BaseWxPayResult {
    private static final long serialVersionUID = 1002049686675489309L;


    /**
     * 微信订单号
     * transaction_id
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 微信生成的订单号，在支付通知中有返回
     **/
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * out_trade_no
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     * transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no
     **/
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 订单金额
     * total_fee
     * 是
     * Int
     * 100
     * 订单总金额，单位为分，只能为整数，详见支付金额
     */
    @XStreamAlias("total_fee")
    private Integer totalFee;

    /**
     * 应结订单金额
     * settlement_total_fee
     * 否
     * Int
     * 100
     * 应结订单金额=订单金额-免充值代金券金额，应结订单金额<=订单金额。
     */
    @XStreamAlias("settlement_total_fee")
    private Integer settlementTotalFee;

    /**
     * 货币种类
     * fee_type
     * 否
     * String(8)
     * CNY
     * 订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @XStreamAlias("fee_type")
    private String feeType;

    /**
     * 现金支付金额
     * cash_fee
     * 是
     * Int
     * 100
     * 现金支付金额，单位为分，只能为整数，详见支付金额
     */
    @XStreamAlias("cash_fee")
    private Integer cashFee;

    /**
     * 订单总退款次数
     * total_refund_count
     * 否
     * Int
     * 35
     * 订单总共已发生的部分退款次数，当请求参数传入offset后有返回
     */
    @XStreamAlias("total_refund_count")
    private Integer totalRefundCount;


    /**
     * 退款笔数
     * refund_count
     * 是
     * Int
     * 1
     * 当前返回退款笔数
     */
    @XStreamAlias("refund_count")
    private Integer refundCount;

    /**
     * 营销详情.
     * promotion_detail
     * 否
     * String(6000)
     * 示例见下文
     * 新增返回，单品优惠功能字段，需要接入请见详细说明
     *
     **/
    @XStreamAlias("promotion_detail")
    private String promotionDetail;


    private List<RefundRecord> refundRecords;

    @Override
    public void compose() {
        composeRefundRecords();
    }

    /**
     * 组装生成退款记录属性的内容.
     */
    public void composeRefundRecords() {
        if (this.refundCount != null && this.refundCount > 0) {
            this.refundRecords = Lists.newArrayList();

            for (int i = 0; i < this.refundCount; i++) {
                RefundRecord refundRecord = new RefundRecord();
                this.refundRecords.add(refundRecord);

                refundRecord.setOutRefundNo(this.getXmlValue("xml/out_refund_no_" + i));
                refundRecord.setRefundId(this.getXmlValue("xml/refund_id_" + i));
                refundRecord.setRefundChannel(this.getXmlValue("xml/refund_channel_" + i));
                refundRecord.setRefundFee(this.getXmlValueAsInt("xml/refund_fee_" + i));
                refundRecord.setSettlementRefundFee(this.getXmlValueAsInt("xml/settlement_refund_fee_" + i));
                refundRecord.setCouponRefundFee(this.getXmlValueAsInt("xml/coupon_refund_fee_" + i));
                refundRecord.setCouponRefundCount(this.getXmlValueAsInt("xml/coupon_refund_count_" + i));
                refundRecord.setRefundStatus(this.getXmlValue("xml/refund_status_" + i));
                refundRecord.setRefundRecvAccount(this.getXmlValue("xml/refund_recv_accout_" + i));
                refundRecord.setRefundAccount(this.getXmlValue("xml/refund_account_" + i));
                refundRecord.setRefundSuccessTime(this.getXmlValue("xml/refund_success_time_" + i));

                if (refundRecord.getCouponRefundCount() == null || refundRecord.getCouponRefundCount() == 0) {
                    continue;
                }

                List<WxPayRefundCouponInfo> coupons = Lists.newArrayList();
                for (int j = 0; j < refundRecord.getCouponRefundCount(); j++) {
                    coupons.add(
                            new WxPayRefundCouponInfo(
                                    this.getXmlValue("xml/coupon_refund_id_" + i + "_" + j),
                                    this.getXmlValueAsInt("xml/coupon_refund_fee_" + i + "_" + j),
                                    this.getXmlValue("xml/coupon_type_" + i + "_" + j)
                            )
                    );
                }

                refundRecord.setRefundCoupons(coupons);
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
        this.transactionId = readXmlString(d, "transaction_id");
        this.outTradeNo = readXmlString(d, "out_trade_no");
        this.totalFee = readXmlInteger(d, "total_fee");
        this.settlementTotalFee = readXmlInteger(d, "settlement_total_fee");
        this.feeType = readXmlString(d, "fee_type");
        this.cashFee = readXmlInteger(d, "cash_fee");
        this.refundCount = readXmlInteger(d, "refund_count");
        this.totalRefundCount = readXmlInteger(d, "total_refund_count");
        this.promotionDetail = readXmlString(d, "promotion_detail");
    }

    /**
     * 退款代金券信息.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WxPayRefundCouponInfo implements Serializable {
        private static final long serialVersionUID = 4280122381292401036L;

        /**
         * 字段名：退款代金券ID.
         * 变量名：coupon_refund_id_$n
         * 是否必填：否
         * 类型：String(20)
         * 示例值：10000
         * 描述：退款代金券ID, $n为下标，从0开始编号
         */
        @XStreamAlias("coupon_refund_id")
        private String couponRefundId;

        /**
         * 字段名：单个代金券退款金额.
         * 变量名：coupon_refund_fee_$n
         * 是否必填：否
         * 类型：Int
         * 示例值：100
         * 描述：单个退款代金券支付金额, $n为下标，从0开始编号
         */
        @XStreamAlias("coupon_refund_fee")
        private Integer couponRefundFee;

        /**
         * 字段名：代金券类型.
         * 变量名：coupon_type_$n
         * 是否必填：否
         * 类型：String(8)
         * 示例值：CASH
         * 描述：CASH--充值代金券 , NO_CASH---非充值代金券。
         * 开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。
         * 订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_0
         */
        @XStreamAlias("coupon_type")
        private String couponType;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RefundRecord implements Serializable {
        private static final long serialVersionUID = 2203565006469783706L;
        /**
         * 字段名：商户退款单号.
         * 变量名：out_refund_no_$n
         * 是否必填：是
         * 类型：String(32)
         * 示例值：1217752501201407033233368018
         * 描述：商户退款单号
         */
        @XStreamAlias("out_refund_no")
        private String outRefundNo;

        /**
         * 字段名：微信退款单号.
         * 变量名：refund_id_$n
         * 是否必填：是
         * 类型：String(28)
         * 示例值：1217752501201407033233368018
         * 描述：微信退款单号
         */
        @XStreamAlias("refund_id")
        private String refundId;

        /**
         * 字段名：退款渠道.
         * 变量名：refund_channel_$n
         * 是否必填：否
         * 类型：String(16)
         * 示例值：ORIGINAL
         * 描述：ORIGINAL—原路退款 BALANCE—退回到余额
         */
        @XStreamAlias("refund_channel")
        private String refundChannel;

        /**
         * 字段名：申请退款金额.
         * 变量名：refund_fee_$n
         * 是否必填：是
         * 类型：Int
         * 示例值：100
         * 描述：退款总金额,单位为分,可以做部分退款
         */
        @XStreamAlias("refund_fee")
        private Integer refundFee;

        /**
         * 字段名：退款金额.
         * 变量名：settlement_refund_fee_$n
         * 是否必填：否
         * 类型：Int
         * 示例值：100
         * 描述：退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
         */
        @XStreamAlias("settlement_refund_fee")
        private Integer settlementRefundFee;

        /**
         * 字段名：退款资金来源.
         * 变量名：refund_account
         * 是否必填：否
         * 类型：String(30)
         * 示例值：REFUND_SOURCE_RECHARGE_FUNDS
         * 描述：REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户, REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
         */
        @XStreamAlias("refund_account")
        private String refundAccount;

        /**
         * 字段名：代金券退款金额.
         * 变量名：coupon_refund_fee_$n
         * 是否必填：否
         * 类型：Int
         * 示例值：100
         * 描述：代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
         */
        @XStreamAlias("coupon_refund_fee")
        private Integer couponRefundFee;

        /**
         * 字段名：退款代金券使用数量.
         * 变量名：coupon_refund_count_$n
         * 是否必填：否
         * 类型：Int
         * 示例值：1
         * 描述：退款代金券使用数量 ,$n为下标,从0开始编号
         */
        @XStreamAlias("coupon_refund_count")
        private Integer couponRefundCount;

        private List<WxPayRefundCouponInfo> refundCoupons;

        /**
         * 字段名：退款状态.
         * 变量名：refund_status_$n
         * 是否必填：是
         * 类型：String(16)
         * 示例值：SUCCESS
         * 描述：退款状态：
         * SUCCESS—退款成功，
         * FAIL—退款失败，
         * PROCESSING—退款处理中，
         * CHANGE—转入代发，
         * 退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，资金回流到商户的现金帐号，需要商户人工干预，通过线下或者财付通转账的方式进行退款。
         */
        @XStreamAlias("refund_status")
        private String refundStatus;

        /**
         * 字段名：退款入账账户.
         * 变量名：refund_recv_accout_$n
         * 是否必填：是
         * 类型：String(64)
         * 示例值：招商银行信用卡0403
         * 描述：取当前退款单的退款入账方，1）退回银行卡：{银行名称}{卡类型}{卡尾号}，2）退回支付用户零钱:支付用户零钱
         */
        @XStreamAlias("refund_recv_accout")
        private String refundRecvAccount;

        /**
         * 字段名：退款成功时间.
         * 变量名：refund_success_time_$n
         * 是否必填：否
         * 类型：String(20)
         * 示例值：2016-07-25 15:26:26
         * 描述：退款成功时间，当退款状态为退款成功时有返回。$n为下标，从0开始编号。
         */
        @XStreamAlias("refund_success_time")
        private String refundSuccessTime;

    }


}

