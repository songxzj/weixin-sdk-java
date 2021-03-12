package com.github.songxzj.wxpay.v2.bean.request.pay;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.pay.WxPayOrderQueryResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 查询订单
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_2">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_2">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_2&index=4">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_2&index=2">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_2">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_2">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_2">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_2">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/app/app_sl.php?chapter=9_2&index=4">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/H5_sl.php?chapter=9_2&index=2">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_sl_api.php?chapter=9_2">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxPayOrderQueryRequest extends BaseWxPayRequest<WxPayOrderQueryResult> {
    private static final long serialVersionUID = -7763874253238697120L;


    /**
     * 字段名：接口版本号.
     * 变量名：version
     * 是否必填：单品优惠必填
     * 类型：String(32)
     * 示例值：1.0
     * 描述：单品优惠新增字段，区分原接口，固定填写1.0
     * 更多信息，详见文档：https://pay.weixin.qq.com/wiki/doc/api/danpin.php?chapter=9_201&index=5
     */
    @XStreamAlias("version")
    private String version;

    /**
     * 微信订单号
     * transaction_id
     * 二选一
     * String(32)
     * 013467007045764
     * 微信的订单号，优先使用
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * out_trade_no
     * 二选一
     * String(32)
     * 1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @Override
    public String routing() {
        return "/pay/orderquery";
    }

    @Override
    public Class<WxPayOrderQueryResult> getResultClass() {
        return WxPayOrderQueryResult.class;
    }

    @Override
    public boolean isUseKey() {
        return false;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isBlank(this.transactionId) == StringUtils.isBlank(this.outTradeNo)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "transaction_id 和 out_trade_no 不能同时存在或同时为空，必须二选一");
        }

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("version", this.version);
        map.put("transaction_id", this.transactionId);
        map.put("out_trade_no", this.outTradeNo);
    }
}
