package com.github.songxzj.wxpay.v3.bean.request.marketing.paygiftactivity;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity.WxPayGiftActivityTerminateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2019.11.28
 * 终止活动API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/paygiftactivity/chapter3_7.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayGiftActivityTerminateRequest extends BaseWxPayV3Request<WxPayGiftActivityTerminateResult> {
    private static final long serialVersionUID = 6889446459959225082L;

    /**
     * 活动id
     * activity_id
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("activity_id")
    private String activityId;

    @Override
    public String routing() {
        return "/v3/marketing/paygiftactivity/activities/" + this.activityId + "/terminate";
    }

    @Override
    public Class<WxPayGiftActivityTerminateResult> getResultClass() {
        return WxPayGiftActivityTerminateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
