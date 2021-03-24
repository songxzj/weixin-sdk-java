package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorCouponUserStateBatchResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.29
 * 根据商户号查用户的券
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_9.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxFavorCouponUserStateBatchRequest extends BaseWxPayV3Request<WxFavorCouponUserStateBatchResult> {
    private static final long serialVersionUID = 547129076026495048L;


    /**
     * 用户openid
     * openid
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("openid")
    private String openid;

    /**
     * 公众账号ID
     * appid
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 否
     */
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 券状态
     * status
     * string[1,6]
     * 否
     */
    @SerializedName("status")
    private String status;

    /**
     * 创建批次的商户号
     * creator_mchid
     * string[1,20]
     * 否
     */
    @SerializedName("creator_mchid")
    private String creatorMchid;

    /**
     * 批次发放商户号
     * sender_mchid
     * string[1,20]
     * 否
     */
    @SerializedName("sender_mchid")
    private String senderMchid;

    /**
     * 可用商户号
     * available_mchid
     * string
     * 否
     */
    @SerializedName("available_mchid")
    private String availableMchid;

    /**
     * 分页页码
     * offset
     * uint32
     * 否
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * 分页大小
     * limit
     * uint32
     * 否
     */
    @SerializedName("limit")
    private Integer limit;


    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/marketing/favor/users/" + this.openid + "/coupons?appid=").append(this.appid);
        if (!StringUtils.isBlank(this.stockId)) {
            routing.append("&stock_id=").append(this.stockId);
        }
        if (!StringUtils.isBlank(this.status)) {
            routing.append("&status=").append(this.status);
        }
        if (!StringUtils.isBlank(this.creatorMchid)) {
            routing.append("&creator_mchid=").append(this.creatorMchid);
        }
        if (!StringUtils.isBlank(this.senderMchid)) {
            routing.append("&sender_mchid=").append(this.senderMchid);
        }
        if (!StringUtils.isBlank(this.availableMchid)) {
            routing.append("&available_mchid=").append(this.availableMchid);
        }
        if (this.offset != null) {
            routing.append("&offset=").append(this.offset);
        }
        if (this.limit != null) {
            routing.append("&limit=").append(this.limit);
        }

        return routing.toString();
    }

    @Override
    public Class<WxFavorCouponUserStateBatchResult> getResultClass() {
        return WxFavorCouponUserStateBatchResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
