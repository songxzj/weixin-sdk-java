package com.github.songxzj.wxpay.v3.bean.request.pay;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.pay.WxPayTransactionsStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2020.05.26
 * 基础支付（直连模式）
 * 查询订单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_2.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_2.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_2.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_2.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_2.shtml">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayTransactionsStateRequest extends BaseWxPayV3Request<WxPayTransactionsStateResult> {
    private static final long serialVersionUID = 4840283048651859076L;


    /**
     * 直连商户号
     * mchid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("mchid")
    private String mchid;


    /**
     * 微信支付订单号
     * transaction_id
     * string[1,32]
     * 是
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * out_trade_no
     * string[1,32]
     * 是
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    @Override
    public String routing() {
        if (!StringUtils.isBlank(this.transactionId)) {
            return "/v3/pay/transactions/id/" + this.transactionId + "?mchid=" + this.mchid;
        } else {
            return "/v3/pay/transactions/out-trade-no/" + this.outTradeNo + "?mchid=" + this.mchid;
        }
    }

    @Override
    public Class<WxPayTransactionsStateResult> getResultClass() {
        return WxPayTransactionsStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isAllBlank(this.transactionId, this.outTradeNo)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "微信支付订单号与商户订单号不能都为空");
        }

    }
}
