package com.github.songxzj.wxpay.v2.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.profitsharing.WxProfitSharingQueryResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 查询分账结果
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_2&index=3">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_2&index=3">
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
public class WxProfitSharingQueryRequest extends BaseWxPayRequest<WxProfitSharingQueryResult> {
    private static final long serialVersionUID = -3951965913250397801L;



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

    /**
     * 商户分账单号
     * out_order_no
     * 是
     * string(64)
     * P20150806125346
     * 商户系统内部的分账单号，在商户系统内部唯一（单次分账、多次分账、完结分账应使用不同的商户分账单号），同一分账单号多次请求等同一次。只能是数字、大小写字母_-|*@
     */
    @Required
    @XStreamAlias("out_order_no")
    private String outOrderNo;


    @Override
    public String routing() {
        return "/pay/profitsharingquery";
    }

    @Override
    public Class<WxProfitSharingQueryResult> getResultClass() {
        return WxProfitSharingQueryResult.class;
    }

    @Override
    public boolean isUseKey() {
        return false;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"appid", "sub_appid"};
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("transaction_id", this.transactionId);
        map.put("out_order_no", this.outOrderNo);
    }
}
