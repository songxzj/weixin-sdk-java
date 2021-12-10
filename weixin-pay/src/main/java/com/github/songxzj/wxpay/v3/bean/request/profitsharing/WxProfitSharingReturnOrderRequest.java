package com.github.songxzj.wxpay.v3.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingReturnOrderStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2021.05.11
 * 请求分账回退API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_3.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxProfitSharingReturnOrderRequest extends BaseWxPayV3Request<WxProfitSharingReturnOrderStateResult> {
    private static final long serialVersionUID = -1556256527656985752L;


    /**
     * 微信分账单号
     * order_id
     * string[1, 64]
     */
    @SerializedName("order_id")
    private String orderId;

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

    /**
     * 回退商户号
     * return_mchid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("return_mchid")
    private String returnMchid;

    /**
     * 回退金额
     * amount
     * int
     * 是
     */
    @Required
    @SerializedName("amount")
    private Integer amount;

    /**
     * 回退描述
     * description
     * string[1, 80]
     * 是
     */
    @Required
    @SerializedName("description")
    private String description;


    @Override
    public String routing() {
        return "/v3/profitsharing/return-orders";
    }

    @Override
    public Class<WxProfitSharingReturnOrderStateResult> getResultClass() {
        return WxProfitSharingReturnOrderStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isBlank(this.orderId) == StringUtils.isBlank(this.outOrderNo)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "微信分账单号与商户分账单号不能同时存在或同时为空，必须二选一");
        }
    }
}
