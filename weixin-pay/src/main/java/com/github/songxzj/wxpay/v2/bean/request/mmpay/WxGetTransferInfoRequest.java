package com.github.songxzj.wxpay.v2.bean.request.mmpay;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.mmpay.WxGetTransferInfoResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 查询企业付款
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_3">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxGetTransferInfoRequest extends BaseWxPayRequest<WxGetTransferInfoResult> {
    private static final long serialVersionUID = 656060590380796795L;

    /**
     * 商户订单号	partner_trade_no
     * 是
     * 1217752501201407033233368018
     * String(32)
     * 商户订单号，需保持历史全局唯一性(只能是字母或者数字，不能包含有其它字符)
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"sign_type"};
    }

    @Override
    public String routing() {
        return "/mmpaymkttransfers/gettransferinfo";
    }

    @Override
    public Class<WxGetTransferInfoResult> getResultClass() {
        return WxGetTransferInfoResult.class;
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
