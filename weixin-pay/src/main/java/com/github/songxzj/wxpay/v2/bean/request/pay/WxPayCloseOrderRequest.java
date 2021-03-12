package com.github.songxzj.wxpay.v2.bean.request.pay;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.pay.WxPayCloseOrderResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 关闭订单
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_3">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_3">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_3&index=5">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_3">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_3">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_3">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/app/app_sl.php?chapter=9_3&index=5">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/H5_sl.php?chapter=9_3&index=3">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxPayCloseOrderRequest extends BaseWxPayRequest<WxPayCloseOrderResult> {
    private static final long serialVersionUID = -6715696158607499392L;


    /**
     * 商户订单号
     * out_trade_no
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @Required
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @Override
    public String routing() {
        return "/pay/closeorder";
    }

    @Override
    public Class<WxPayCloseOrderResult> getResultClass() {
        return WxPayCloseOrderResult.class;
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
        map.put("out_trade_no", this.outTradeNo);

    }
}
