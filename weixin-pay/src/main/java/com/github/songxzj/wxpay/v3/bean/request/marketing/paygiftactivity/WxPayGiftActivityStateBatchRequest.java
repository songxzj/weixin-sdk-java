package com.github.songxzj.wxpay.v3.bean.request.marketing.paygiftactivity;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity.WxPayGiftActivityStateBatchResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2020.06.09
 * 获取支付有礼活动列表API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/paygiftactivity/chapter3_9.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayGiftActivityStateBatchRequest extends BaseWxPayV3Request<WxPayGiftActivityStateBatchResult> {
    private static final long serialVersionUID = -399514608209756234L;

    /**
     * 分页页码
     * offset
     * uint64
     * 是
     */
    @Required
    @SerializedName("offset")
    private Integer offset;

    /**
     * 分页大小
     * limit
     * uint64
     * 是
     */
    @Required
    @SerializedName("limit")
    private Integer limit;

    /**
     * 活动名称
     * activity_name
     * string[1,10]
     * 否
     */
    @SerializedName("activity_name")
    private String activityName;

    /**
     * 活动状态
     * activity_status
     * string[1,30]
     * 否
     */
    @SerializedName("activity_status")
    private String activityStatus;

    /**
     * 奖品类型
     * award_type
     * string[1,30]
     * 否
     */
    @SerializedName("award_type")
    private String awardType;


    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/marketing/paygiftactivity/activities?offset=").append(this.offset).append("&limit=").append(this.limit);
        if (!StringUtils.isBlank(this.activityName)) {
            routing.append("&activity_name=").append(this.activityName);
        }
        if (!StringUtils.isBlank(this.activityStatus)) {
            routing.append("&activity_status=").append(this.activityStatus);
        }
        if (!StringUtils.isBlank(this.awardType)) {
            routing.append("&award_type=").append(this.awardType);
        }

        return routing.toString();
    }

    @Override
    public Class<WxPayGiftActivityStateBatchResult> getResultClass() {
        return WxPayGiftActivityStateBatchResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
