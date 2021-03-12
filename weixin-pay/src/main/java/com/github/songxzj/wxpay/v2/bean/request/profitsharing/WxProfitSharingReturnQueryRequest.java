package com.github.songxzj.wxpay.v2.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.profitsharing.WxProfitSharingReturnQueryResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 回退结果查询
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_8&index=9">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_8&index=10">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxProfitSharingReturnQueryRequest extends BaseWxPayRequest<WxProfitSharingReturnQueryResult> {
    private static final long serialVersionUID = 3405013765660792712L;

    /**
     * 微信分账单号
     * order_id
     * 是
     * string(32)
     * 3008450740201411110007820472
     * 原发起分账请求时，微信返回的微信分账单号
     */
    @XStreamAlias("order_id")
    private String orderId;

    /**
     * 微商户分账单号
     * out_order_no
     * 是
     * string(64)
     * P20150806125346
     * 原发起分账请求时使用的商户系统内部的分账单号。
     */
    @XStreamAlias("out_order_no")
    private String outOrderNo;

    /**
     * 商户回退单号
     * out_return_no
     * 是
     * string(64)
     * R20150806125346
     * 调用接口提供的商户系统内部的回退单号
     */
    @Required
    @XStreamAlias("out_return_no")
    private String outReturnNo;


    @Override
    public String routing() {
        return "/pay/profitsharingreturnquery";
    }

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"sub_appid"};
    }
    @Override
    public Class<WxProfitSharingReturnQueryResult> getResultClass() {
        return WxProfitSharingReturnQueryResult.class;
    }

    @Override
    public boolean isUseKey() {
        return false;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isBlank(this.orderId) == StringUtils.isBlank(this.outOrderNo)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "order_id 和 out_order_no 不能同时存在或同时为空，必须二选一");
        }
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("order_id", this.orderId);
        map.put("out_order_no", this.outOrderNo);
        map.put("out_return_no", this.outReturnNo);
    }
}
