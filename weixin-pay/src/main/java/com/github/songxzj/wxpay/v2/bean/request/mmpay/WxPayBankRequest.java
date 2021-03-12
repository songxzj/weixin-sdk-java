package com.github.songxzj.wxpay.v2.bean.request.mmpay;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.mmpay.WxPayBankResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 企业付款到银行卡API
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_2">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxPayBankRequest extends BaseWxPayRequest<WxPayBankResult> {
    private static final long serialVersionUID = -8476840537311213932L;

    /**
     * 商户企业付款单号
     * partner_trade_no
     * 是
     * 1212121221227
     * string(32)
     * 商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]，最短8位，最长32位）
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    /**
     * 收款方银行卡号
     * enc_bank_no
     * 是
     * 8609cb22e1774a50a930e414cc71eca06121bcd266335cda230d24a7886a8d9f
     * string(1024)
     * 收款方银行卡号（采用标准RSA算法，公钥由微信侧提供）,详见获取RSA加密公钥API
     */
    @Required
    @XStreamAlias("enc_bank_no")
    private String encBankNo;

    /**
     * 收款方用户名
     * enc_true_name
     * 是
     * ca775af5f841bdf424b2e6eb86a6e21e
     * string(1024)
     * 收款方用户名（采用标准RSA算法，公钥由微信侧提供）详见获取RSA加密公钥API
     */
    @Required
    @XStreamAlias("enc_true_name")
    private String encTrueName;

    /**
     * 收款方开户行
     * bank_code
     * 是
     * 1001
     * string(64)
     * 银行卡所在开户行编号,详见银行编号列表
     */
    @Required
    @XStreamAlias("bank_code")
    private String bankCode;

    /**
     * 付款金额
     * amount
     * 是
     * 100000
     * int
     * 付款金额：RMB分（支付总额，不含手续费）
     * 注：大于0的整数
     */
    @Required
    @XStreamAlias("amount")
    private Integer amount;

    /**
     * 付款说明
     * desc
     * 否
     * 理财
     * string(512)
     * 企业付款到银行卡付款说明,即订单备注（UTF8编码，允许100个字符以内）
     */
    @XStreamAlias("desc")
    private String desc;

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"appid", "sign_type"};
    }

    @Override
    public String routing() {
        return "/mmpaysptrans/pay_bank";
    }

    @Override
    public Class<WxPayBankResult> getResultClass() {
        return WxPayBankResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("partner_trade_no", this.partnerTradeNo);
        map.put("enc_bank_no", this.encBankNo);
        map.put("enc_true_name", this.encTrueName);
        map.put("bank_code", this.bankCode);
        map.put("amount", this.amount.toString());
        map.put("desc", this.desc);
    }
}
