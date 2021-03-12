package com.github.songxzj.wxpay.v2.bean.request.bill;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.bill.WxDownloadBillResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 下载交易账单
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_6">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_6">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_6">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_6&index=8">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_6&index=6">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_6">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_6">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_6">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_6">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/app/app_sl.php?chapter=9_6&index=8">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/H5_sl.php?chapter=9_6&index=6">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_sl_api.php?chapter=9_6">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxDownloadBillRequest extends BaseWxPayRequest<WxDownloadBillResult> {
    private static final long serialVersionUID = 8022736176977862090L;


    /**
     * 对账单日期
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
     * 账单类型
     * bill_type
     * 否
     * String(8)
     * ALL
     * ALL（默认值），返回当日所有订单信息（不含充值退款订单）
     * SUCCESS，返回当日成功支付的订单（不含充值退款订单）
     * REFUND，返回当日退款订单（不含充值退款订单）
     * RECHARGE_REFUND，返回当日充值退款订单
     */
    @XStreamAlias("bill_type")
    private String billType;

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
        return "/pay/downloadbill";
    }

    @Override
    public Class<WxDownloadBillResult> getResultClass() {
        return WxDownloadBillResult.class;
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
        map.put("bill_date", this.billDate);
        map.put("bill_type", this.billType);
        map.put("tar_type", this.tarType);
    }
}
