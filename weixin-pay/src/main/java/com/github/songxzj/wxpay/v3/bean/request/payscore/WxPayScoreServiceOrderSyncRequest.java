package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScoreServiceOrderSyncResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.03.05
 * 同步服务订单信息API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_20.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScoreServiceOrderSyncRequest extends BaseWxPayV3Request<WxPayScoreServiceOrderSyncResult> {
    private static final long serialVersionUID = 8745713387907906598L;

    /**
     * 商户服务订单号
     * out_order_no
     * string[1,32]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 应用ID
     * appid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 服务ID
     * service_id
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("service_id")
    private String serviceId;

    /**
     * 场景类型
     * type
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("type")
    private String type;

    /**
     * 内容信息详情
     * detail
     * object
     * 否
     */
    @SerializedName("detail")
    private Detail detail;

    @Override
    public String routing() {
        return "/v3/payscore/serviceorder/" + this.outOrderNo + "/sync";
    }

    @Override
    public Class<WxPayScoreServiceOrderSyncResult> getResultClass() {
        return WxPayScoreServiceOrderSyncResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.detail != null) {
            detail.checkConstraints();
        }
    }

    /**
     * 内容信息详情
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Detail extends BaseV3Inner {
        private static final long serialVersionUID = -459416115870243043L;

        /**
         * 收款成功时间
         * paid_time
         * string[1,14]
         * 是
         */
        @Required
        @SerializedName("paid_time")
        private String paidTime;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }
}
