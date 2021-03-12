package com.github.songxzj.wxpay.v3.bean.request.businesscircle;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.businesscircle.WxBusinessCirclePointResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.08.03
 * 商圈积分同步
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/businesscircle/chapter3_2.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusinessCirclePointRequest extends BaseWxPayV3Request<WxBusinessCirclePointResult> {
    private static final long serialVersionUID = 6780991968097595436L;

    /**
     * 商圈商户ID
     * sub_mchid
     * string[1,64]
     * 否
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 微信订单号
     * transaction_id
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 小程序appid
     * appid
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 用户标识
     * openid
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("openid")
    private String openid;

    /**
     * 是否获得积分
     * earn_points
     * boolean
     * 是
     */
    @Required
    @SerializedName("earn_points")
    private Boolean earnPoints;

    /**
     * 订单新增积分值
     * increased_points
     * int
     * 是
     */
    @Required
    @SerializedName("increased_points")
    private Integer increasedPoints;

    /**
     * 积分更新时间
     * points_update_time
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("points_update_time")
    private String pointsUpdateTime;

    /**
     * 未获得积分的备注信息
     * no_points_remarks
     * string[1,128]
     * 否
     */
    @SerializedName("no_points_remarks")
    private String noPointsRemarks;

    /**
     * 顾客积分总额
     * total_points
     * int
     * 否
     */
    @SerializedName("total_points")
    private Integer totalPoints;

    @Override
    public String routing() {
        return "/v3/businesscircle/points/notify";
    }

    @Override
    public Class<WxBusinessCirclePointResult> getResultClass() {
        return WxBusinessCirclePointResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
