package com.github.songxzj.wxpay.v3.bean.request.complaint;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.11.27
 * 查询投诉详情API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/tool/merchant-service/chapter3_8.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintRequest extends BaseWxPayV3Request<WxComplaintResult> {
    private static final long serialVersionUID = 4118288809060151866L;


    /**
     * 微信支付订单号
     * transaction_id
     * string[1, 64]
     * 是
     */
    @Required
    @SerializedName("transaction_id")
    private String transactionId;

    @Override
    public String routing() {
        return "/v3/merchant-service/complaints/" + this.transactionId;
    }

    @Override
    public Class<WxComplaintResult> getResultClass() {
        return WxComplaintResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
