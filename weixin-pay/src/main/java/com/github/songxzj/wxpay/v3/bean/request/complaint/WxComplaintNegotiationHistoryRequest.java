package com.github.songxzj.wxpay.v3.bean.request.complaint;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintNegotiationHistoryResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2021.08.27
 * 查询投诉协商历史API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_2_12.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintNegotiationHistoryRequest extends BaseWxPayV3Request<WxComplaintNegotiationHistoryResult> {
    private static final long serialVersionUID = -8038225318162310743L;

    /**
     * 投诉单号
     * complaint_id
     * string[1, 64]
     * 是
     */
    @Required
    @SerializedName("complaint_id")
    private String complaintId;

    /**
     * 分页大小
     * limit
     * int
     * 否
     */
    @SerializedName("limit")
    private Integer limit;

    /**
     * 分页开始位置
     * offset
     * int
     * 否
     */
    @SerializedName("offset")
    private Integer offset;

    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/merchant-service/complaints-v2/").append(this.complaintId).append("/negotiation-historys");
        if (this.limit != null) {
            routing.append("&limit=").append(this.limit);
        }
        if (this.offset != null) {
            routing.append("&offset=").append(this.offset);
        }
        return routing.toString();
    }

    @Override
    public Class<WxComplaintNegotiationHistoryResult> getResultClass() {
        return WxComplaintNegotiationHistoryResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
