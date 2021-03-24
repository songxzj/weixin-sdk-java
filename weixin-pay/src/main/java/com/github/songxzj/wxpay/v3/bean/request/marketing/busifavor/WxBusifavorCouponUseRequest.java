package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorCouponUseResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2019.08.20
 * 核销用户券API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_3.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorCouponUseRequest extends BaseWxPayV3Request<WxBusifavorCouponUseResult> {
    private static final long serialVersionUID = -8173900018120644826L;

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
     * 批次号
     * stock_id
     * string[1,20]
     * 否
     */
    @SerializedName("stock_id")
    private String stockId;

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
     * 请求核销时间
     * use_time
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("use_time")
    private String useTime;

    /**
     * 核销请求单据号
     * use_request_no
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("use_request_no")
    private String useRequestNo;

    /**
     * 用户标识
     * openid
     * string[1,128]
     * 否
     */
    @SerializedName("openid")
    private String openid;

    @Override
    public String routing() {
        return "/v3/marketing/busifavor/coupons/use";
    }

    @Override
    public Class<WxBusifavorCouponUseResult> getResultClass() {
        return WxBusifavorCouponUseResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
