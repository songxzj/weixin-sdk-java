package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorUserCouponStateBatchResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2020.07.24
 * 根据过滤条件查询用户券API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_4.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorUserCouponStateBatchRequest extends BaseWxPayV3Request<WxBusifavorUserCouponStateBatchResult> {
    private static final long serialVersionUID = -7325439525683913515L;

    /**
     * 用户标识
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
     * string[1,32]
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
     * coupon_state
     * string[1,16]
     * 否
     */
    @SerializedName("coupon_state")
    private String couponState;

    /**
     * 创建批次的商户号
     * creator_merchant
     * string[1,32]
     * 否
     */
    @SerializedName("creator_merchant")
    private String creatorMerchant;

    /**
     * 批次归属商户号
     * belong_merchant
     * string[8,15]
     * 否
     */
    @SerializedName("belong_merchant")
    private String belongMerchant;

    /**
     * 批次发放商户号
     * sender_merchant
     * string[1,32]
     * 否
     */
    @SerializedName("sender_merchant")
    private String senderMerchant;

    /**
     * 分页页码
     * offset
     * int
     * 否
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * 分页大小
     * limit
     * int
     * 否
     */
    @SerializedName("limit")
    private Integer limit;

    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/marketing/busifavor/users/" + this.openid + "/coupons?appid=").append(this.appid);
        if (!StringUtils.isBlank(this.stockId)) {
            routing.append("&stock_id=").append(this.stockId);
        }
        if (!StringUtils.isBlank(this.couponState)) {
            routing.append("&coupon_state=").append(this.couponState);
        }
        if (!StringUtils.isBlank(this.creatorMerchant)) {
            routing.append("&creator_merchant=").append(this.creatorMerchant);
        }
        if (!StringUtils.isBlank(this.belongMerchant)) {
            routing.append("&belong_merchant=").append(this.belongMerchant);
        }
        if (!StringUtils.isBlank(this.senderMerchant)) {
            routing.append("&sender_merchant=").append(this.senderMerchant);
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
    public Class<WxBusifavorUserCouponStateBatchResult> getResultClass() {
        return WxBusifavorUserCouponStateBatchResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
