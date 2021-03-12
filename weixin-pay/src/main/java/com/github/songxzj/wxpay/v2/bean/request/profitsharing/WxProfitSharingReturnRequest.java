package com.github.songxzj.wxpay.v2.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.profitsharing.WxProfitSharingReturnResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 分账回退
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation.php?chapter=27_7&index=8">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_7&index=9">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxProfitSharingReturnRequest extends BaseWxPayRequest<WxProfitSharingReturnResult> {
    private static final long serialVersionUID = -5703331417803417832L;

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

    /**
     * 回退方类型
     * return_account_type
     * 是
     * string(32)
     * MERCHANT_ID
     * 枚举值：
     * MERCHANT_ID：商户号（mch_id或者sub_mch_id）
     */
    @Required
    @XStreamAlias("return_account_type")
    private String returnAccountType;

    /**
     * 回退方账号
     * return_account
     * 是
     * string(64)
     * 86693852
     * 回退方类型是MERCHANT_ID时，商户号（mch_id或者sub_mch_id）
     */
    @Required
    @XStreamAlias("return_account")
    private String returnAccount;

    /**
     * 回退金额
     * return_amount
     * 是
     * int
     * 888
     * 回退金额，整数，单位为分
     */
    @Required
    @XStreamAlias("return_amount")
    private Integer returnAmount;

    /**
     * 回退描述
     * description
     * 是
     * string(80)
     * 用户退款
     * 分账回退的原因描述
     */
    @Required
    @XStreamAlias("description")
    private String description;

    @Override
    public String routing() {
        return "/secapi/pay/profitsharingreturn";
    }

    @Override
    public Class<WxProfitSharingReturnResult> getResultClass() {
        return WxProfitSharingReturnResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
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
        map.put("return_account_type", this.returnAccountType);
        map.put("return_account", this.returnAccount);
        map.put("return_amount", this.returnAmount.toString());
        map.put("description", this.description);
    }
}
