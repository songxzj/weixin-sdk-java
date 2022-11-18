package com.github.songxzj.wxpay.v3.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingReturnOrderStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2022.07.19
 * 查询分账回退结果API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_4.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxProfitSharingReturnOrderStateRequest extends BaseWxPayV3Request<WxProfitSharingReturnOrderStateResult> {
    private static final long serialVersionUID = -3132236457692841533L;

    /**
     * 商户分账单号
     * out_order_no
     * string[1,64]
     * 是
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 商户回退单号
     * out_return_no
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("out_return_no")
    private String outReturnNo;


    @Override
    public String routing() {
        return "/v3/profitsharing/return-orders" + this.outReturnNo + "&out_order_no=" + this.outOrderNo;
    }

    @Override
    public Class<WxProfitSharingReturnOrderStateResult> getResultClass() {
        return WxProfitSharingReturnOrderStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
