package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;


import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorCouponUserResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.27
 * 发放代金券API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_2.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxFavorCouponUserRequest extends BaseWxPayV3Request<WxFavorCouponUserResult> {
    private static final long serialVersionUID = -1040102949259277835L;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 用户openid
     * openid
     * string[1,128]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("openid")
    private String openid;

    /**
     * 商户单据号
     * out_request_no
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("out_request_no")
    private String outRequestNo;

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
     * 创建批次的商户号
     * stock_creator_mchid
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("stock_creator_mchid")
    private String stockCreatorMchid;

    /**
     * 指定面额发券，面额
     * coupon_value
     * uint64
     * 否
     */
    @SerializedName("coupon_value")
    private Integer couponValue;

    /**
     * 指定面额发券，券门槛
     * coupon_minimum
     * uint64
     * 否
     */
    @SerializedName("coupon_minimum")
    private Integer couponMinimum;

    @Override
    public String routing() {
        return "/v3/marketing/favor/users/" + this.openid + "/coupons";
    }

    @Override
    public Class<WxFavorCouponUserResult> getResultClass() {
        return WxFavorCouponUserResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
