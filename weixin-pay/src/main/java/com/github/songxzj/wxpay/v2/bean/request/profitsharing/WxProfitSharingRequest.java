package com.github.songxzj.wxpay.v2.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.profitsharing.WxProfitSharingResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 请求单次分账
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_1&index=1">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_1&index=1">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxProfitSharingRequest extends BaseWxPayRequest<WxProfitSharingResult> {
    private static final long serialVersionUID = -5961154501118633014L;

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
     * 分账接收方列表
     * receivers
     * 是
     * string(10240)
     * [
     *     {
     *          "type": "MERCHANT_ID",
     *          "account":"190001001",
     *          "amount":100,
     *          "description": "分到商户"
     * },
     *     {
     *          "type": "PERSONAL_OPENID",
     *          "account":"86693952",
     *          "amount":888,
     *          "description": "分到个人"
     * }
     * ]
     * 分账接收方列表，不超过50个json对象，不能设置分账方作为分账接受方
     * 点击行前的+展开字段详情
     */
    @Required
    @XStreamAlias("receivers")
    private String receivers;

    @Override
    public String routing() {
        return "/secapi/pay/profitsharing";
    }

    @Override
    public Class<WxProfitSharingResult> getResultClass() {
        return WxProfitSharingResult.class;
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
        map.put("receivers", this.receivers);
    }
}
