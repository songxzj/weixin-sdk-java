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
public class WxMicroGetStateResult extends BaseWxPayResult {
    private static final long serialVersionUID = -1064912358526092310L;


    */
/**
     * 商户申请单号
     * applyment_id
     * 是
     * String(32)
     * 1230000109
     * 微信支付分配的申请单号
     **//*

    @XStreamAlias("applyment_id")
    private String applymentId;

    */
/**
     * 申请状态
     * applyment_state
     * 是
     * String(32)
     * REJECTED
     * AUDITING:审核中
     * REJECTED:已驳回
     * FROZEN:已冻结
     * TO_BE_SIGNED:待签约
     * FINISH:完成
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
     **//*

    @XStreamAlias("applyment_state_desc")
    private String applymentStateDesc;


    */
/**
     * 签约链接
     * sign_url
     * 否
     * String(256)
     * https://pay.weixin.qq.com
     * 当申请状态为TO_BE_SIGNED或FINISH时才返回
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
     *     "audit_detail": [
     *         {
     *             "param_name": "account_number",
     *             "reject_reason": "银行账户不存在"
     *         },
     *         {
     *             "param_name ": "mobile_phone",
     *             "reject_reason": "号码不存在"
     *         }
     *     ]
     * }
     * 各项被驳回资料的驳回理由。当申请状态为REJECTED时才返回。字段值为json格式
     **//*

    @XStreamAlias("audit_detail")
    private String auditDetail;

    @Override
    protected void loadXml(Document d) {
        this.applymentId = readXmlString(d, "applyment_id");
        this.applymentState = readXmlString(d, "applyment_state");
        this.applymentStateDesc = readXmlString(d, "applyment_state_desc");
        this.signUrl = readXmlString(d, "sign_url");
        this.auditDetail = readXmlString(d, "audit_detail");
    }
}
*/
