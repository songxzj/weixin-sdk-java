package com.github.songxzj.wxpay.v2.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.profitsharing.WxProfitSharingFinishResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 完结分账
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_5&index=6">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_5&index=6">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxProfitSharingFinishRequest extends BaseWxPayRequest<WxProfitSharingFinishResult> {
    private static final long serialVersionUID = 8816154780284323528L;

    /**
     * 品牌主商户号
     * brand_mch_id
     * 否
     * string(32)
     * 1900000108
     * 当服务商开通了“连锁品牌工具”后，使用品牌供应链分账时，此参数传入品牌主商户号。传入后，分账方的分账比例，校验品牌主配置的全局分账。
     * 使用普通分账，未开通“连锁品牌工具”的商户，可忽略此字段。
     */
    @XStreamAlias("brand_mch_id")
    private String brandMchId;

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

    /**
     * 分账完结描述
     * description
     * 是
     * string(80)
     * 分账已完成
     * 分账完结的原因描述
     */
    @Required
    @XStreamAlias("description")
    private String description;

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"sub_appid"};
    }

    @Override
    public String routing() {
        return "/secapi/pay/profitsharingfinish";
    }

    @Override
    public Class<WxProfitSharingFinishResult> getResultClass() {
        return WxProfitSharingFinishResult.class;
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
        map.put("brand_mch_id", this.brandMchId);
        map.put("transaction_id", this.transactionId);
        map.put("out_order_no", this.outOrderNo);
        map.put("description", this.description);
    }
}
