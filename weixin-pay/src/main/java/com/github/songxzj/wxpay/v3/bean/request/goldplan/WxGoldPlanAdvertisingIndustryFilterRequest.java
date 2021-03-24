package com.github.songxzj.wxpay.v3.bean.request.goldplan;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.goldplan.WxGoldPlanAdvertisingIndustryFilterResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.03.27
 * 同业过滤标签管理API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/goldplan/chapter3_3.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxGoldPlanAdvertisingIndustryFilterRequest extends BaseWxPayV3Request<WxGoldPlanAdvertisingIndustryFilterResult> {
    private static final long serialVersionUID = -3142347759090202814L;

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
    @SerializedName("advertising_industry_filters")
    private List<String> advertisingIndustryFilters;

    @Override
    public String routing() {
        return "/v3/goldplan/merchants/set-advertising-industry-filter";
    }

    @Override
    public Class<WxGoldPlanAdvertisingIndustryFilterResult> getResultClass() {
        return WxGoldPlanAdvertisingIndustryFilterResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        int size = this.advertisingIndustryFilters.size();
        if (!(size > 0 && size < 4)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "同业过滤标签最少传一个，最多三个");
        }
    }
}
