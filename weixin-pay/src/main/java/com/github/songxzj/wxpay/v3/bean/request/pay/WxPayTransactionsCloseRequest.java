package com.github.songxzj.wxpay.v3.bean.request.pay;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.pay.WxPayTransactionsCloseResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;


/**
 * version:2020.05.26
 * 基础支付（直连模式）
 * 关单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_3.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_3.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_3.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_3.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_3.shtml">
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayTransactionsCloseRequest extends BaseWxPayV3Request<WxPayTransactionsCloseResult> {
    private static final long serialVersionUID = -2342754678897535357L;

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
     * 商户订单号
     * out_trade_no
     * string[6,32]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("out_trade_no")
    private String outTradeNo;


    @Override
    public String routing() {
        return "/v3/pay/transactions/out-trade-no/" + this.outTradeNo + "/close";
    }

    @Override
    public Class<WxPayTransactionsCloseResult> getResultClass() {
        return WxPayTransactionsCloseResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
