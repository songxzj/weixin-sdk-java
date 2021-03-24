package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorCouponReturnResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.11.04
 * 申请退券API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_13.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorCouponReturnRequest extends BaseWxPayV3Request<WxBusifavorCouponReturnResult> {
    private static final long serialVersionUID = -7122006675873314645L;

    /**
     * 券code
     * coupon_code
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("coupon_code")
    private String couponCode;

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
     * 退券请求单据号
     * return_request_no
     * string[1, 128]
     * 是
     */
    @Required
    @SerializedName("return_request_no")
    private String returnRequestNo;

    @Override
    public String routing() {
        return "/v3/marketing/busifavor/coupons/return";
    }

    @Override
    public Class<WxBusifavorCouponReturnResult> getResultClass() {
        return WxBusifavorCouponReturnResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
