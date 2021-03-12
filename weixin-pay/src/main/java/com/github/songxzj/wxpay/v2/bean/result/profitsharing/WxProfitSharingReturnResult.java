package com.github.songxzj.wxpay.v2.bean.result.profitsharing;

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
public class WxProfitSharingReturnResult extends BaseWxPayResult {
    private static final long serialVersionUID = -5422713123607351900L;

    /**
     * 返回信息
     * error_msg
     * 否
     * string(256)
     * 参数格式校验错误
     * 如果返回状态码为FAIL，则本字段存在，且为失败的错误信息
     */
    @XStreamAlias("error_msg")
    private String errorMsg;

    /**
     * 微信分账单号
     * order_id
     * 是
     * string(32)
     * 3008450740201411110007820472
     * 原发起分账请求时，微信返回的微信分账单号
     */
    @XStreamAlias("order_id")
    private String orderId;

    /**
     * 微商户分账单号
     * out_order_no
     * 是
     * string(64)
     * P20150806125346
     * 原发起分账请求时使用的商户系统内部的分账单号。
     */
    @XStreamAlias("out_order_no")
    private String outOrderNo;

    /**
     * 商户回退单号
     * out_return_no
     * 是
     * string(64)
     * R20150806125346
     * 调用接口提供的商户系统内部的回退单号
     */
    @XStreamAlias("out_return_no")
    private String outReturnNo;

    /**
     * 微信回退单号
     * return_no
     * 是
     * string(64)
     * 3008450740201411110007820472
     * 微信分账回退单号，微信系统返回的唯一标识
     */
    @XStreamAlias("return_no")
    private String returnNo;

    /**
     * 回退方类型
     * return_account_type
     * 是
     * string(32)
     * MERCHANT_ID
     * 枚举值：
     * MERCHANT_ID：商户号（mch_id或者sub_mch_id）
     */
    @XStreamAlias("return_account_type")
    private String returnAccountType;

    /**
     * 回退方账号
     * return_account
     * 是
     * string(64)
     * 86693852
     * 回退方类型是MERCHANT_ID时，商户号（mch_id或者sub_mch_id）
     */
    @XStreamAlias("return_account")
    private String returnAccount;

    /**
     * 回退金额
     * return_amount
     * 是
     * int
     * 888
     * 回退金额，整数，单位为分
     */
    @XStreamAlias("return_amount")
    private Integer returnAmount;

    /**
     * 回退描述
     * description
     * 是
     * string(80)
     * 用户退款
     * 分账回退的原因描述
     */
    @XStreamAlias("description")
    private String description;

    /**
     * 回退结果
     * result
     * 是
     * string(32)
     * SUCCESS
     * 枚举值：
     * PROCESSING:处理中
     * SUCCESS:已成功
     * FAILED: 已失败
     * 如果返回为处理中，请勿变更商户回退单号，使用相同的参数再次发起分账回退，否则会出现资金风险
     * 在处理中状态的回退单如果5天没有成功，会因为超时被设置为已失败
     */
    @XStreamAlias("result")
    private String result;

    /**
     * 失败原因
     * fail_reason
     * 否
     * string(32)
     * ACCOUNT_ABNORMAL
     * 枚举值：
     * ACCOUNT_ABNORMAL:分账接收方账户异常
     * TIME_OUT_CLOSED: 超时关单
     * 此字段仅回退结果为FAILED时存在
     */
    @XStreamAlias("fail_reason")
    private String failReason;

    /**
     * 完成时间
     * finish_time
     * 是
     * string(16)
     * 20180608170132
     * 分账回退完成时间
     */
    @XStreamAlias("finish_time")
    private String finishTime;


    @Override
    protected void loadXml(Document d) {
        this.errorMsg = readXmlString(d, "error_msg");
        this.orderId = readXmlString(d, "order_id");
        this.outOrderNo = readXmlString(d, "out_order_no");
        this.outReturnNo = readXmlString(d, "out_return_no");
        this.returnNo = readXmlString(d, "return_no");
        this.returnAccountType = readXmlString(d, "return_account_type");
        this.returnAccount = readXmlString(d, "return_account");
        this.returnAmount = readXmlInteger(d, "return_amount");
        this.description = readXmlString(d, "description");
        this.result = readXmlString(d, "result");
        this.failReason = readXmlString(d, "fail_reason");
        this.finishTime = readXmlString(d, "finish_time");
    }
}
