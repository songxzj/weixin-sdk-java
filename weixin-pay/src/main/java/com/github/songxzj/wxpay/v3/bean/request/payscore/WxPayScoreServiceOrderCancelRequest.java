package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScoreServiceOrderCancelResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.04.23
 * 取消支付分订单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_16.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScoreServiceOrderCancelRequest extends BaseWxPayV3Request<WxPayScoreServiceOrderCancelResult> {
    private static final long serialVersionUID = -7863823400132150076L;

    /**
     * 商户服务订单号
     * out_order_no
     * string[1,32]
     */
    @Required
    @GsonExclude
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 应用ID
     * appid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 服务ID
     * service_id
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("service_id")
    private String serviceId;

    /**
     * 取消原因
     * reason
     * string[1,30]
     * 是
     */
    @Required
    @SerializedName("reason")
    private String reason;


    @Override
    public String routing() {
        return "/v3/payscore/serviceorder/" + this.outOrderNo + "/cancel";
    }

    @Override
    public Class<WxPayScoreServiceOrderCancelResult> getResultClass() {
        return WxPayScoreServiceOrderCancelResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
