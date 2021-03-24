package com.github.songxzj.wxpay.v3.bean.request.complaint;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintNegotiationHistoryResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2021.1.8
 * 查询投诉协商历史API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/merchant-service/chapter3_7.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintNegotiationHistoryRequest extends BaseWxPayV3Request<WxComplaintNegotiationHistoryResult> {
    private static final long serialVersionUID = -8038225318162310743L;

    /**
     * 微信支付订单号
     * transaction_id
     * string[1, 64]
     * 是
     */
    @Required
    @SerializedName("transaction_id")
    private String transactionId;

    @Override
    public String routing() {
        return "/v3/merchant-service/complaints/" + this.transactionId + "/negotiation-historys";
    }

    @Override
    public Class<WxComplaintNegotiationHistoryResult> getResultClass() {
        return WxComplaintNegotiationHistoryResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
