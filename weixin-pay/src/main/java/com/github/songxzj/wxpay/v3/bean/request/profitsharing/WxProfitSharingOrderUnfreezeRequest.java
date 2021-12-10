package com.github.songxzj.wxpay.v3.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingOrderStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2021.05.11
 * 解冻剩余资金API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_5.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxProfitSharingOrderUnfreezeRequest extends BaseWxPayV3Request<WxProfitSharingOrderStateResult> {
    private static final long serialVersionUID = -3970030751607044430L;

    /**
     * 微信订单号
     * transaction_id
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 商户分账单号
     * out_order_no
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 分账描述
     * description
     * string[1, 80]
     * 是
     */
    @Required
    @SerializedName("description")
    private String description;

    @Override
    public String routing() {
        return "/v3/profitsharing/orders/unfreeze";
    }

    @Override
    public Class<WxProfitSharingOrderStateResult> getResultClass() {
        return WxProfitSharingOrderStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
