package com.github.songxzj.wxpay.v3.bean.request.complaint;


import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintNotificationResult;
import com.github.songxzj.wxpay.v3.enums.OperateTypeEnum;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2020.02.17
 * 创建投诉通知回调地址API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/merchant-service/chapter3_2.shtml">
 * 查询投诉通知回调地址API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/merchant-service/chapter3_3.shtml">
 * 更新投诉通知回调地址API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/merchant-service/chapter3_4.shtml">
 * 删除投诉通知回调地址API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/merchant-service/chapter3_5.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintNotificationRequest extends BaseWxPayV3Request<WxComplaintNotificationResult> {
    private static final long serialVersionUID = -8132864544391077383L;

    /**
     * 操作类型
     */
    @Required
    @GsonExclude
    OperateTypeEnum operateTypeEnum;

    /**
     * 通知地址
     * url
     * string[1,255]
     * 是
     */
    @SerializedName("url")
    private String url;

    @Override
    public String routing() {
        return "/v3/merchant-service/complaint-notifications";
    }

    @Override
    public Class<WxComplaintNotificationResult> getResultClass() {
        return WxComplaintNotificationResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        if (OperateTypeEnum.CREATE.equals(this.operateTypeEnum)) {
            return HttpMethod.POST;
        }
        if (OperateTypeEnum.QUERY.equals(this.operateTypeEnum)) {
            return HttpMethod.GET;
        }
        if (OperateTypeEnum.UPDATE.equals(this.operateTypeEnum)) {
            return HttpMethod.PUT;
        }
        if (OperateTypeEnum.DELETE.equals(this.operateTypeEnum)) {
            return HttpMethod.DELETE;
        }
        return null;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if ((OperateTypeEnum.CREATE.equals(this.operateTypeEnum) || OperateTypeEnum.UPDATE.equals(this.operateTypeEnum))
                && StringUtils.isBlank(this.url)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "创建/更新时，通知地址必填");
        }
    }
}
