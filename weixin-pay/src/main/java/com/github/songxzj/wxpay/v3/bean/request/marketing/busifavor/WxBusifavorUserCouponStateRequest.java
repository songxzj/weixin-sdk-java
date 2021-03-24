package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorUserCouponStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.07.24
 * 查询用户单张券详情API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_5.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorUserCouponStateRequest extends BaseWxPayV3Request<WxBusifavorUserCouponStateResult> {
    private static final long serialVersionUID = 3205414634355163422L;


    /**
     * 券code
     * coupon_code
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("coupon_code")
    private String couponCode;

    /**
     * 公众账号ID
     * appid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 用户标识
     * openid
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("openid")
    private String openid;


    @Override
    public String routing() {
        return "/v3/marketing/busifavor/users/" + this.openid + "/coupons/" + this.couponCode + "/appids/" + this.appid;
    }

    @Override
    public Class<WxBusifavorUserCouponStateResult> getResultClass() {
        return WxBusifavorUserCouponStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
