package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorCouponUserStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.27
 * 查询代金券详情API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_6.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxFavorCouponUserStateRequest extends BaseWxPayV3Request<WxFavorCouponUserStateResult> {
    private static final long serialVersionUID = -653831068710334707L;

    /**
     * 代金券id
     * coupon_id
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("coupon_id")
    private String couponId;

    /**
     * 公众账号ID
     * appid
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 用户openid
     * openid
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("openid")
    private String openid;

    @Override
    public String routing() {
        return "/v3/marketing/favor/users/" + this.openid + "/coupons/" + this.couponId + "?appid=" + this.appid;
    }

    @Override
    public Class<WxFavorCouponUserStateResult> getResultClass() {
        return WxFavorCouponUserStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
