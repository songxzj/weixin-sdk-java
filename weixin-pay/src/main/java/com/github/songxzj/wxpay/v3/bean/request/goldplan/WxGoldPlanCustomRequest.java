package com.github.songxzj.wxpay.v3.bean.request.goldplan;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.goldplan.enums.SwitchOperationTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.goldplan.WxGoldPlanCustomResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.04.29
 * 商家小票管理API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/goldplan/chapter3_2.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxGoldPlanCustomRequest extends BaseWxPayV3Request<WxGoldPlanCustomResult> {
    private static final long serialVersionUID = -6782803091036093363L;


    /**
     * 特约商户号
     * sub_mchid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 操作类型
     * operation_type
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("operation_type")
    private SwitchOperationTypeEnum operationType;

    @Override
    public String routing() {
        return "/v3/goldplan/merchants/changecustompagestatus";
    }

    @Override
    public Class<WxGoldPlanCustomResult> getResultClass() {
        return WxGoldPlanCustomResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
