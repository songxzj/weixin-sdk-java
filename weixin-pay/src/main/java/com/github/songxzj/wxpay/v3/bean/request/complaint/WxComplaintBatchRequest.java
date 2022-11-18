package com.github.songxzj.wxpay.v3.bean.request.complaint;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintBatchResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2022.06.08
 * 查询投诉单列表API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_2_11.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintBatchRequest extends BaseWxPayV3Request<WxComplaintBatchResult> {
    private static final long serialVersionUID = -8655471260424027777L;

    /**
     * 分页大小
     * limit
     * int32
     * 否
     */
    @SerializedName("limit")
    private Integer limit;

    /**
     * 分页开始位置
     * offset
     * int32
     * 否
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * 开始日期
     * begin_date
     * string[1,10]
     * 是
     */
    @Required
    @SerializedName("begin_date")
    private String beginDate;

    /**
     * 结束日期
     * end_date
     * string[1,10]
     * 是
     */
    @Required
    @SerializedName("end_date")
    private String endDate;

    /**
     * 被诉商户号
     * complainted_mchid
     * string[1, 64]
     * 否
     */
    @SerializedName("complainted_mchid")
    private String complaintedMchid;

    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/merchant-service/complaints-v2?begin_date=").append(this.beginDate).append("&end_date=").append(this.endDate);
        if (this.limit != null) {
            routing.append("&limit=").append(this.limit);
        }
        if (this.offset != null) {
            routing.append("&offset=").append(this.offset);
        }
        if (!StringUtils.isBlank(this.complaintedMchid)) {
            routing.append("&complainted_mchid=").append(this.complaintedMchid);
        }

        return routing.toString();
    }

    @Override
    public Class<WxComplaintBatchResult> getResultClass() {
        return WxComplaintBatchResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
