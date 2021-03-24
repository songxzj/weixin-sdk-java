package com.github.songxzj.wxpay.v2.bean.request.mmpay;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.mmpay.WxQueryBankResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 查询企业付款到银行卡API
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=24_3">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxQueryBankRequest extends BaseWxPayRequest<WxQueryBankResult> {
    private static final long serialVersionUID = -4295694831688339560L;

    /**
     * 商户企业付款单号
     * partner_trade_no
     * 是
     * string(32)
     * 商户单号
     */
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    @Override
    public String routing() {
        return "/mmpaysptrans/query_bank";
    }

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"appid", "sign_type"};
    }

    @Override
    public Class<WxQueryBankResult> getResultClass() {
        return WxQueryBankResult.class;
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

    }
}
