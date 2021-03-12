package com.github.songxzj.wxpay.v3.bean.request.discountcard;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.discountcard.WxDiscountCardStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.06.12
 * 查询先享卡订单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_3_3.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxDiscountCardStateRequest extends BaseWxPayV3Request<WxDiscountCardStateResult> {
    private static final long serialVersionUID = 8364642628452227391L;

    /**
     * 商户领卡号
     * out_card_code
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("out_card_code")
    private String outCardCode;


    @Override
    public String routing() {
        return "/v3/discount-card/cards/" + this.outCardCode;
    }

    @Override
    public Class<WxDiscountCardStateResult> getResultClass() {
        return WxDiscountCardStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
