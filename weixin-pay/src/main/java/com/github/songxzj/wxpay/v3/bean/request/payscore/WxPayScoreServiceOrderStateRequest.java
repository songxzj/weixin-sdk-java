package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScoreServiceOrderStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2020.05.25
 * 查询支付分订单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_15.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScoreServiceOrderStateRequest extends BaseWxPayV3Request<WxPayScoreServiceOrderStateResult> {
    private static final long serialVersionUID = -7863823400132150076L;

    /**
     * 商户服务订单号
     * out_order_no
     * string[1,32]
     */
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 回跳查询ID
     * query_id
     * string[1,64]
     */
    @SerializedName("query_id")
    private String queryId;

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
     * 应用ID
     * appid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;


    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/payscore/serviceorder?service_id=").append(this.serviceId).append("&appid=").append(this.appid);
        if (!StringUtils.isBlank(this.outOrderNo)) {
            routing.append("&out_order_no=").append(this.outOrderNo);
        }
        if (!StringUtils.isBlank(this.queryId)) {
            routing.append("&query_id=").append(this.queryId);
        }

        return routing.toString();
    }

    @Override
    public Class<WxPayScoreServiceOrderStateResult> getResultClass() {
        return WxPayScoreServiceOrderStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isBlank(this.outOrderNo) == StringUtils.isBlank(this.queryId)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "商户单号与回跳查询id不能同时存在或同时为空，必须二选一");
        }
    }
}
