package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorCouponDeactivateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.11.04
 * 使券失效API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_14.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorCouponDeactivateRequest extends BaseWxPayV3Request<WxBusifavorCouponDeactivateResult> {
    private static final long serialVersionUID = -6240930825633665487L;

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
     * 失效请求单据号
     * deactivate_request_no
     * string[1, 128]
     * 是
     */
    @Required
    @SerializedName("deactivate_request_no")
    private String deactivateRequestNo;

    /**
     * 失效原因
     * deactivate_reason
     * string[1, 64]
     * 否
     */
    @SerializedName("deactivate_reason")
    private String deactivateReason;

    @Override
    public String routing() {
        return "/v3/marketing/busifavor/coupons/deactivate";
    }

    @Override
    public Class<WxBusifavorCouponDeactivateResult> getResultClass() {
        return WxBusifavorCouponDeactivateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
