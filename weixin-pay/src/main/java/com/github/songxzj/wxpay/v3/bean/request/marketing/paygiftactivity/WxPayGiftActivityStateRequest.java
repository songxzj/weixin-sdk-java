package com.github.songxzj.wxpay.v3.bean.request.marketing.paygiftactivity;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity.WxPayGiftActivityStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2019.11.28
 * 查询活动详情接口API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/paygiftactivity/chapter3_4.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayGiftActivityStateRequest extends BaseWxPayV3Request<WxPayGiftActivityStateResult> {
    private static final long serialVersionUID = -1306056380458038599L;

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
        return "/v3/marketing/paygiftactivity/activities/" + this.activityId;
    }

    @Override
    public Class<WxPayGiftActivityStateResult> getResultClass() {
        return WxPayGiftActivityStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
