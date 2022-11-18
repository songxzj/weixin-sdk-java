package com.github.songxzj.wxpay.v3.bean.request.complaint;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.complaint.WxComplaintUpdateRefundProgressResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2022.08.05
 * 更新退款审批结果API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_2_19.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxComplaintUpdateRefundProgressRequest extends BaseWxPayV3Request<WxComplaintUpdateRefundProgressResult> {
    private static final long serialVersionUID = -7526107204393040772L;

    /**
     * 投诉单号
     * complaint_id
     * string[1,64]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("complaint_id")
    private String complaintId;

    /**
     * 审批动作
     * action
     * string
     * 是
     */
    @Required
    @SerializedName("action")
    private String action;

    /**
     * 预计发起退款时间
     * launch_refund_day
     * int
     * 否
     */
    @SerializedName("launch_refund_day")
    private Integer launchRefundDay;

    /**
     * 拒绝退款原因
     * reject_reason
     * string[1, 200]
     * 否
     */
    @SerializedName("reject_reason")
    private String rejectReason;

    /**
     * 拒绝退款的举证图片列表
     * reject_media_list
     * array
     * 否
     */
    @SerializedName("reject_media_list")
    private List<String> rejectMediaList;

    /**
     * 备注
     * remark
     * string[1, 200]
     * 否
     */
    @SerializedName("remark")
    private String remark;

    @Override
    public String routing() {
        return "/v3/merchant-service/complaints-v2/" + this.complaintId + "/update-refund-progress";
    }

    @Override
    public Class<WxComplaintUpdateRefundProgressResult> getResultClass() {
        return WxComplaintUpdateRefundProgressResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
