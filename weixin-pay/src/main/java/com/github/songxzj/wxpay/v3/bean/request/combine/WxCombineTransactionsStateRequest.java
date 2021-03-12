package com.github.songxzj.wxpay.v3.bean.request.combine;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.combine.WxCombineTransactionsStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.03.27
 * 合单支付
 * 合单查询订单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_11.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxCombineTransactionsStateRequest extends BaseWxPayV3Request<WxCombineTransactionsStateResult> {
    private static final long serialVersionUID = 2324939290148259623L;


    /**
     * 合单商户订单号
     * combine_out_trade_no
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("combine_out_trade_no")
    private String combineOutTradeNo;

    @Override
    public String routing() {
        return "/v3/combine-transactions/out-trade-no/" + this.combineOutTradeNo;
    }

    @Override
    public Class<WxCombineTransactionsStateResult> getResultClass() {
        return WxCombineTransactionsStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
