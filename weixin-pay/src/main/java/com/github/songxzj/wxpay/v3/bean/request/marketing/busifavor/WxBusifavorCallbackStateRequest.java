package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorCallbackStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2019.12.20
 * 查询商家券事件通知地址API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_8.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorCallbackStateRequest extends BaseWxPayV3Request<WxBusifavorCallbackStateResult> {
    private static final long serialVersionUID = -6347099125574891352L;

    /**
     * 商户号
     * mchid
     * string[8,15]
     * 否
     */
    @SerializedName("mchid")
    private String mchid;


    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/marketing/busifavor/callbacks");
        if (!StringUtils.isBlank(this.mchid)) {
            routing.append("?mchid=").append(this.mchid);
        }

        return routing.toString();
    }

    @Override
    public Class<WxBusifavorCallbackStateResult> getResultClass() {
        return WxBusifavorCallbackStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
