package com.github.songxzj.wxpay.v2.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.profitsharing.WxProfitSharingOrderAmountQueryResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;


/**
 * 查询订单待分账金额
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_10&index=7">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_10&index=7">
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
public class WxProfitSharingOrderAmountQueryRequest extends BaseWxPayRequest<WxProfitSharingOrderAmountQueryResult> {
    private static final long serialVersionUID = 5748278200121190252L;


    /**
     * 微信订单号
     * transaction_id
     * 是
     * string(32)
     * 4208450740201411110007820472
     * 微信支付订单号
     */
    @Required
    @XStreamAlias("transaction_id")
    private String transactionId;

    @Override
    public String routing() {
        return "/pay/profitsharingorderamountquery";
    }

    @Override
    public Class<WxProfitSharingOrderAmountQueryResult> getResultClass() {
        return WxProfitSharingOrderAmountQueryResult.class;
    }

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"appid", "sub_appid", "sub_mch_id"};
    }

    @Override
    public boolean isUseKey() {
        return false;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("transaction_id", this.transactionId);
    }
}
