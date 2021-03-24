package com.github.songxzj.wxpay.v3.bean.request.marketing.paygiftactivity;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity.WxPayGiftActivityGoodsStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2019.11.28
 * 查询活动指定商品列表API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/paygiftactivity/chapter3_6.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayGiftActivityGoodsStateRequest extends BaseWxPayV3Request<WxPayGiftActivityGoodsStateResult> {
    private static final long serialVersionUID = -6826443321938150356L;

    /**
     * 活动id
     * activity_id
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("activity_id")
    private String activityId;

    /**
     * 分页页码
     * offset
     * uint64
     * 否
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * 分页大小
     * limit
     * uint64
     * 否
     */
    @SerializedName("limit")
    private Integer limit;

    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/marketing/paygiftactivity/activities/" + this.activityId + "/goods");
        StringBuffer appendRouting = new StringBuffer();
        if (this.offset != null) {
            appendRouting.append("&offset=").append(this.offset);
        }
        if (this.limit != null) {
            appendRouting.append("&limit=").append(this.limit);
        }
        if (appendRouting.length() > 0) {
            routing.append("?").append(appendRouting.substring(1));
        }
        return routing.toString();
    }

    @Override
    public Class<WxPayGiftActivityGoodsStateResult> getResultClass() {
        return WxPayGiftActivityGoodsStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
