package com.github.songxzj.wxpay.v3.bean.request.goldplan;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.goldplan.enums.SwitchOperationTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.goldplan.WxGoldPlanResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.03.27
 * 点金计划管理API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/goldplan/chapter3_1.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxGoldPlanRequest extends BaseWxPayV3Request<WxGoldPlanResult> {
    private static final long serialVersionUID = 6226491809961683128L;


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
        return "/v3/goldplan/merchants/changegoldplanstatus";
    }

    @Override
    public Class<WxGoldPlanResult> getResultClass() {
        return WxGoldPlanResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
