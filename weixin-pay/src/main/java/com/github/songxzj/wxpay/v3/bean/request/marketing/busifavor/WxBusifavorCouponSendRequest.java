package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorCouponSendResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.05.12
 * 发放消费卡API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/coupons/chapter3_1.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorCouponSendRequest extends BaseWxPayV3Request<WxBusifavorCouponSendResult> {
    private static final long serialVersionUID = -5818595261658742819L;

    /**
     * 消费卡ID
     * card_id
     * string[1,28]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("card_id")
    private String cardId;

    /**
     * 消费卡归属appid
     * appid
     * string[1,18]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 用户openid
     * openid
     * string[1,28]
     * 是
     */
    @Required
    @SerializedName("openid")
    private String openid;

    /**
     * 商户单据号
     * out_request_no
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("out_request_no")
    private String outRequestNo;

    /**
     * 请求发卡时间
     * send_time
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("send_time")
    private String sendTime;


    @Override
    public String routing() {
        return "/v3/marketing/busifavor/coupons/" + this.cardId + "/send";
    }

    @Override
    public Class<WxBusifavorCouponSendResult> getResultClass() {
        return WxBusifavorCouponSendResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
