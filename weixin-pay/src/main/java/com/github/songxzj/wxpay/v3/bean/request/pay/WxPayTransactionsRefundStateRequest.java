package com.github.songxzj.wxpay.v3.bean.request.pay;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.pay.WxPayTransactionsRefundStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;


/**
 * version:2022.08.29
 * 基础支付（直连模式）
 * 查询单笔退款API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_10.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_10.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_10.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_10.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_10.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayTransactionsRefundStateRequest extends BaseWxPayV3Request<WxPayTransactionsRefundStateResult> {
    private static final long serialVersionUID = 801829753124736032L;


    /**
     * 商户退款单号
     * out_refund_no
     * string[1, 64]
     * 是
     */
    @Required
    @SerializedName("out_refund_no")
    private String outRefundNo;

    @Override
    public String routing() {
        return "/v3/refund/domestic/refunds/" + this.outRefundNo;
    }

    @Override
    public Class<WxPayTransactionsRefundStateResult> getResultClass() {
        return WxPayTransactionsRefundStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
