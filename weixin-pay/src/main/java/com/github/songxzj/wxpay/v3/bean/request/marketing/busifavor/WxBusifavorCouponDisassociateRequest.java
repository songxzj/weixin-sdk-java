package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorCouponDisassociateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2019.06.10
 * 取消关联订单信息API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_10.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorCouponDisassociateRequest extends BaseWxPayV3Request<WxBusifavorCouponDisassociateResult> {
    private static final long serialVersionUID = -6347099125574891352L;

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
     * 券code
     * coupon_code
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("coupon_code")
    private String couponCode;

    /**
     * 关联的商户订单号
     * out_trade_no
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 商户请求单号
     * out_request_no
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("mchid")
    private String mchid;


    @Override
    public String routing() {
        return "/v3/marketing/busifavor/coupons/disassociate";
    }

    @Override
    public Class<WxBusifavorCouponDisassociateResult> getResultClass() {
        return WxBusifavorCouponDisassociateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
