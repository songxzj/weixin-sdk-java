package com.github.songxzj.wxpay.v3.bean.request.paypartner;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.paypartner.WxPayPartnerTransactionsCloseResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.05.26
 * 基础支付（服务商模式）
 * 关单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_3.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_2_3.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_3.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_3.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_3.shtml">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayPartnerTransactionsCloseRequest extends BaseWxPayV3Request<WxPayPartnerTransactionsCloseResult> {
    private static final long serialVersionUID = -7285348705357808030L;


    /**
     * 服务商户号
     * sp_mchid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("sp_mchid")
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
     * 商户订单号
     * out_trade_no
     * string[1,32]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("out_trade_no")
    private String outTradeNo;

    @Override
    public String routing() {
        return "/v3/pay/partner/transactions/out-trade-no/" + this.outTradeNo + "/close";
    }

    @Override
    public Class<WxPayPartnerTransactionsCloseResult> getResultClass() {
        return WxPayPartnerTransactionsCloseResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
