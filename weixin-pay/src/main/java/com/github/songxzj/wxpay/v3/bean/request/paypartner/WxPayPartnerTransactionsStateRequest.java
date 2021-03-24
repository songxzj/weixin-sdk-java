package com.github.songxzj.wxpay.v3.bean.request.paypartner;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.paypartner.WxPayPartnerTransactionsStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2020.05.26
 * 基础支付（服务商模式）
 * 查询订单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_2.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_2_2.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_2.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_2.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_2.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayPartnerTransactionsStateRequest extends BaseWxPayV3Request<WxPayPartnerTransactionsStateResult> {
    private static final long serialVersionUID = -739992290915734248L;


    /**
     * 服务商户号
     * sp_mchid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("spMchid")
    private String spMchid;


    /**
     * 子商户号
     * sub_mchid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("sub_mchid")
    private String subMchid;

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
            return "/v3/pay/partner/transactions/id/" + this.transactionId + "?sp_mchid=" + this.spMchid + "&sub_mchid=" + this.subMchid;
        } else {
            return "/v3/pay/partner/transactions/out-trade-no/" + this.outTradeNo + "?sp_mchid=" + this.spMchid + "&sub_mchid=" + this.subMchid;
        }
    }

    @Override
    public Class<WxPayPartnerTransactionsStateResult> getResultClass() {
        return WxPayPartnerTransactionsStateResult.class;
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
