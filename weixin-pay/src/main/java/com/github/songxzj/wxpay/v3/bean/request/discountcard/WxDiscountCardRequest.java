package com.github.songxzj.wxpay.v3.bean.request.discountcard;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.discountcard.WxDiscountCardResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.06.12
 * 预受理领卡请求API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_3_1.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxDiscountCardRequest extends BaseWxPayV3Request<WxDiscountCardResult> {
    private static final long serialVersionUID = 3694575000786213375L;

    /**
     * 商户领卡号
     * out_card_code
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("out_card_code")
    private String outCardCode;

    /**
     * 先享卡模板ID
     * card_template_id
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("card_template_id")
    private String cardTemplateId;

    /**
     * 公众账号ID
     * appid
     * string[10,32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 通知商户URL
     * notify_url
     * string[1,255]
     * 是
     */
    @Required
    @SerializedName("notify_url")
    private String notifyUrl;

    @Override
    public String routing() {
        return "/v3/discount-card/cards";
    }

    @Override
    public Class<WxDiscountCardResult> getResultClass() {
        return WxDiscountCardResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
