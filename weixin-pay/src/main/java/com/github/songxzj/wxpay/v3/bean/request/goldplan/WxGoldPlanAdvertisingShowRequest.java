package com.github.songxzj.wxpay.v3.bean.request.goldplan;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.goldplan.enums.SwitchOperationTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.goldplan.WxGoldPlanAdvertisingShowResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.08.27
 * 开通广告展示API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/goldplan/chapter3_4.shtml">
 * 关闭广告展示API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/goldplan/chapter3_5.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxGoldPlanAdvertisingShowRequest extends BaseWxPayV3Request<WxGoldPlanAdvertisingShowResult> {
    private static final long serialVersionUID = -3915883696622475413L;


    /**
     * 广告操作类型
     */
    @Required
    @GsonExclude
    private SwitchOperationTypeEnum operationType;

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
    @SerializedName("advertising_industry_filters")
    private List<String> advertisingIndustryFilters;

    @Override
    public String routing() {
        return "/v3/goldplan/merchants/" + this.operationType.name().toLowerCase() + "-advertising-show";
    }

    @Override
    public Class<WxGoldPlanAdvertisingShowResult> getResultClass() {
        return WxGoldPlanAdvertisingShowResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        if (SwitchOperationTypeEnum.OPEN.equals(this.operationType)) {
            return HttpMethod.PATCH;
        }
        if (SwitchOperationTypeEnum.CLOSE.equals(this.operationType)) {
            return HttpMethod.POST;
        }
        return null;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (SwitchOperationTypeEnum.OPEN.equals(this.operationType)) {
            if (CollectionUtils.isEmpty(this.advertisingIndustryFilters) || !(this.advertisingIndustryFilters.size() > 0 && this.advertisingIndustryFilters.size() < 4)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "开通广告展示时，同业过滤标签最少传一个，最多三个");
            }
        }
    }

}
