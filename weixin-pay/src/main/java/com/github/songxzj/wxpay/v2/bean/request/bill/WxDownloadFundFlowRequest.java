package com.github.songxzj.wxpay.v2.bean.request.bill;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.bill.WxDownloadFundFlowResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 下载交易账单
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_18&index=7">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_18&index=7">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_18&index=7">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_18&index=9">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_18&index=7">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_18&index=7">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxDownloadFundFlowRequest extends BaseWxPayRequest<WxDownloadFundFlowResult> {
    private static final long serialVersionUID = 8022736176977862090L;


    /**
     * 资金账单日期
     * bill_date
     * 是
     * String(8)
     * 20140603
     * 下载对账单的日期，格式：20140603
     */
    @Required
    @XStreamAlias("bill_date")
    private String billDate;


    /**
     * 资金账户类型
     * account_type
     * 是
     * String(8)
     * Basic
     * 账单的资金来源账户：
     * Basic  基本账户
     * Operation 运营账户
     * Fees 手续费账户
     */
    @Required
    @XStreamAlias("account_type")
    private String accountType;

    /**
     * 压缩账单
     * tar_type
     * 否
     * String
     * GZIP
     * 非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
     */
    @XStreamAlias("tar_type")
    private String tarType;

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"sub_appid", "sub_mch_id"};
    }

    @Override
    public String routing() {
        return "/pay/downloadfundflow";
    }

    @Override
    public Class<WxDownloadFundFlowResult> getResultClass() {
        return WxDownloadFundFlowResult.class;
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
        map.put("bill_date", this.billDate);
        map.put("account_type", this.accountType);
        map.put("tar_type", this.tarType);
    }
}
