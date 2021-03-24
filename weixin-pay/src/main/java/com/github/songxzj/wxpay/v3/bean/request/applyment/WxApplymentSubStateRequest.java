package com.github.songxzj.wxpay.v3.bean.request.applyment;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.applyment.WxApplymentSubStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * 查询申请单状态API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/applyment4sub/chapter3_2.shtml">
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxApplymentSubStateRequest extends BaseWxPayV3Request<WxApplymentSubStateResult> {
    private static final long serialVersionUID = -7055710642500290503L;

    /**
     * 业务申请编号
     * business_code
     * string(124)
     * 是
     */
    @SerializedName("business_code")
    private String businessCode;

    /**
     * 申请单号
     * applyment_id
     * uint64
     * 是
     */
    @SerializedName("applyment_id")
    private String applymentId;

    @Override
    public String routing() {
        if (!StringUtils.isBlank(this.businessCode)) {
            return "/v3/applyment4sub/applyment/business_code/" + this.businessCode;
        } else {
            return "/v3/applyment4sub/applyment/applyment_id/" + this.applymentId;
        }
    }

    @Override
    public Class<WxApplymentSubStateResult> getResultClass() {
        return WxApplymentSubStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isAllBlank(this.businessCode, this.applymentId)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "业务申请编号与业务申请编号不能都为空");
        }

    }
}
