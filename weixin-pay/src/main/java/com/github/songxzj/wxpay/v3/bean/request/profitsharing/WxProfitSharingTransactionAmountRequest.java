package com.github.songxzj.wxpay.v3.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingOrderStateResult;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingTransactionAmountResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2021.05.11
 * 查询剩余待分金额API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_6.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxProfitSharingTransactionAmountRequest extends BaseWxPayV3Request<WxProfitSharingTransactionAmountResult> {
    private static final long serialVersionUID = -2657381599674700610L;

    /**
     * 微信订单号
     * transaction_id
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("transaction_id")
    private String transactionId;


    @Override
    public String routing() {
        return "/v3/profitsharing/transactions/" + this.transactionId + "/amounts";
    }

    @Override
    public Class<WxProfitSharingTransactionAmountResult> getResultClass() {
        return WxProfitSharingTransactionAmountResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
