/*
package com.github.songxzj.wxpay.v2.bean.result.micro;

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
public class WxMicroGetUpgradeStateResult extends BaseWxPayResult {
    private static final long serialVersionUID = -8056996652406893718L;

    */
/**
     * 申请状态
     * applyment_state
     * 是
     * String(32)
     * REJECTED
     * CHECKING:资料校验中
     * ACCOUNT_NEED_VERIFY：待账户验证
     * AUDITING:审核中
     * REJECTED:已驳回
     * NEED_SIGN:待签约
     * FINISH:完成
     * FROZEN:已冻结
     **//*

    @XStreamAlias("applyment_state")
    private String applymentState;

    */
/**
     * 申请状态描述
     * applyment_state_desc
     * 是
     * String(32)
     * 已驳回
     * 申请状态描述
     * UPGRADED:已升级
     * 已驳回
     **//*

    @XStreamAlias("applyment_state_desc")
    private String applymentStateDesc;


    */
/**
     * 签约二维码
     * sign_qrcode
     * 否
     * String(256)
     * https://pay.weixin.qq.com
     * 当申请状态为NEED_SIGN或FINISH时才返回
     **//*

    @XStreamAlias("sign_qrcode")
    private String signQrcode;

    */
/**
     * 签约链接
     * sign_url
     * 否
     * String(256)
     * https://pay.weixin.qq.com
     * 当申请状态为NEED_SIGN或FINISH时才返回
     **//*

    @XStreamAlias("sign_url")
    private String signUrl;

    */
/**
     * 审核详情
     * audit_detail
     * 否
     * String(1024)
     * {
     * "audit_detail": [
     * {
     * "param_name": "account_no",
     * "reject_reason": "银行账户不存在"
     * },
     * {
     * "param_name": "mobile_phone",
     * "reject_reason ": "电话为空号"
     * }
     * ]
     * }
     * 各项资料的审核情况。当申请状态为REJECTED或 FROZEN时才返回。字段值为json格式，详情参考2.2.5。
     **//*

    @XStreamAlias("audit_detail")
    private String auditDetail;


    //以下字段当 applyment_state 为ACCOUNT_NEED_VERIFY 时有返回，请商户按照以下信息进行汇款，以完成账户验证
    //注：1、个体户、企业，无此账户验证环节；2、验证结束后，汇款金额将全额退还至汇款账户。
    */
/**
     * 付款户名
     * account_name
     * 是
     * String(32)
     * 需商户使用该户名的账户进行汇款
     **//*

    @XStreamAlias("account_name")
    private String accountName;


    */
/**
     * 汇款金额
     * pay_amount
     * 是
     * String(32)
     * 124
     * 需要汇款的金额(单位 分)
     **//*

    @XStreamAlias("pay_amount")
    private String payAmount;

    */
/**
     * 收款卡号
     * destination_account_number
     * 是
     * String(128)
     * 7222223333322332
     * 收款账户的卡号
     **//*

    @XStreamAlias("destination_account_number")
    private String destinationAccountNumber;

    */
/**
     * 收款户名
     * destination_account_name
     * 是
     * String(256)
     * 财付通支付科技有限公司
     * 收款账户名
     **//*

    @XStreamAlias("destination_account_name")
    private String destinationAccountName;

    */
/**
     * 开户银行
     * destination_account_bank
     * 是
     * String(256)
     * 招商银行威盛大厦支行
     * 收款账户的开户银行名称
     **//*

    @XStreamAlias("destination_account_bank")
    private String destinationAccountBank;

    */
/**
     * 省市信息
     * city
     * 是
     * String(128)
     * 深圳
     * 收款账户的省市
     **//*

    @XStreamAlias("city")
    private String city;

    */
/**
     * 备注信息
     * remark
     * 是
     * String(128)
     * 入驻账户验证
     * 商户汇款时，需要填写的备注信息
     **//*

    @XStreamAlias("remark")
    private String remark;

    */
/**
     * 汇款截止时间
     * deadline_time
     * 是
     * String(20)
     * 2018-12-1017:09:01
     * 请在此时间前完成汇款
     **//*

    @XStreamAlias("deadline_time")
    private String deadlineTime;


    @Override
    protected void loadXml(Document d) {
        this.applymentState = readXmlString(d, "applyment_state");
        this.applymentStateDesc = readXmlString(d, "applyment_state_desc");
        this.signQrcode = readXmlString(d, "sign_qrcode");
        this.signUrl = readXmlString(d, "sign_url");
        this.auditDetail = readXmlString(d, "audit_detail");
        this.accountName = readXmlString(d, "account_name");
        this.payAmount = readXmlString(d, "pay_amount");
        this.destinationAccountNumber = readXmlString(d, "destination_account_number");
        this.destinationAccountName = readXmlString(d, "destination_account_name");
        this.destinationAccountBank = readXmlString(d, "destination_account_bank");
        this.city = readXmlString(d, "city");
        this.remark = readXmlString(d, "remark");
        this.deadlineTime = readXmlString(d, "deadline_time");
    }
}
*/
