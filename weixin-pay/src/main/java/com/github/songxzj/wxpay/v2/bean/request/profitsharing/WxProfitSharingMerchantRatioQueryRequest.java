package com.github.songxzj.wxpay.v2.bean.request.profitsharing;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.profitsharing.WxProfitSharingMerchantRatioQueryResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 查询订单最大分账比例
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_11&index=8">
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
public class WxProfitSharingMerchantRatioQueryRequest extends BaseWxPayRequest<WxProfitSharingMerchantRatioQueryResult> {
    private static final long serialVersionUID = -4257036964978838923L;

    /**
     * 品牌主商户号
     * brand_mch_id
     * string(32)
     * 1900000108
     * 当服务商开通了“连锁品牌工具”后，使用品牌供应链分账时，传入品牌主商户号，查询品牌主设置的全局分账比例，品牌主下的门店适用于此比例。
     */
    @XStreamAlias("brand_mch_id")
    private String brandMchId;



    @Override
    public String routing() {
        return "/pay/profitsharingmerchantratioquery";
    }

    @Override
    public Class<WxProfitSharingMerchantRatioQueryResult> getResultClass() {
        return WxProfitSharingMerchantRatioQueryResult.class;
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
        map.put("brand_mch_id", this.brandMchId);
    }
}
