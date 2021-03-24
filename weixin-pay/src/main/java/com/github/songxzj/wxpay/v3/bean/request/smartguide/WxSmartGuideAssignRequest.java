package com.github.songxzj.wxpay.v3.bean.request.smartguide;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.smartguide.WxSmartGuideAssignResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.04.28
 * 服务人员分配API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/smartguide/chapter3_2.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxSmartGuideAssignRequest extends BaseWxPayV3Request<WxSmartGuideAssignResult> {
    private static final long serialVersionUID = -2543575601181855215L;

    /**
     * 服务人员ID
     * guide_id
     * string[1,32]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("guide_id")
    private String guideId;

    /**
     * 子商户号
     * sub_mchid
     * string[1,32]
     * 否
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 商户订单号
     * out_trade_no
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("out_trade_no")
    private String outTradeNo;


    @Override
    public String routing() {
        return "/v3/smartguide/guides/" + this.guideId + "/assign";
    }

    @Override
    public Class<WxSmartGuideAssignResult> getResultClass() {
        return WxSmartGuideAssignResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
