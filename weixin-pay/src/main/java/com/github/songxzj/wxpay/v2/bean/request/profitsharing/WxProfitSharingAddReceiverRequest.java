package com.github.songxzj.wxpay.v2.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.profitsharing.WxProfitSharingAddReceiverResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 添加分账接收方
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_3&index=4">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_3&index=4">
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
public class WxProfitSharingAddReceiverRequest extends BaseWxPayRequest<WxProfitSharingAddReceiverResult> {
    private static final long serialVersionUID = -9000774252700643425L;


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
     * 分账接收方
     * receiver
     * 是
     * String(2048)
     * 分账接收方对象，json格式
     * 点击行前的+展开字段详情
     */
    @Required
    @XStreamAlias("receiver")
    private String receiver;

    @Override
    public String routing() {
        return "/pay/profitsharingaddreceiver";
    }

    @Override
    public Class<WxProfitSharingAddReceiverResult> getResultClass() {
        return WxProfitSharingAddReceiverResult.class;
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
        map.put("brand_mch_id", this.brandMchId);
        map.put("receiver", this.receiver);
    }
}
