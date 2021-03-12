package com.github.songxzj.wxpay.v3.bean.request.marketing.partnership;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.partnership.WxPartnershipBuildResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.04.09
 * 建立合作关系API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/partnerships/chapter3_1.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPartnershipBuildRequest extends BaseWxPayV3Request<WxPartnershipBuildResult> {
    private static final long serialVersionUID = 2643933110941534795L;

    /**
     * 合作方信息
     * partner
     * object
     * 是
     */
    @Required
    @SerializedName("partner")
    private Partner partner;

    /**
     * 被授权数据
     * authorized_data
     * object
     * 是
     */
    @Required
    @SerializedName("authorized_data")
    private AuthorizedData authorizedData;

    @Override
    public String routing() {
        return "/v3/marketing/partnerships/build";
    }

    @Override
    public Class<WxPartnershipBuildResult> getResultClass() {
        return WxPartnershipBuildResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.partner != null) {
            this.partner.checkConstraints();
        }
        if (this.authorizedData != null) {
            this.authorizedData.checkConstraints();
        }
    }

    /**
     * 合作方信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Partner extends BaseV3Inner {
        private static final long serialVersionUID = 6497504032914084315L;
        /**
         * 合作方类别
         * type
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("type")
        private String type;

        /**
         * 合作方APPID
         * appid
         * string[1,32]
         * 否
         */
        @SerializedName("appid")
        private String appid;

        /**
         * 合作方商户ID
         * merchant_id
         * string[8,15]
         * 否
         */
        @SerializedName("merchant_id")
        private String merchantId;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }

    /**
     * 被授权数据
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthorizedData extends BaseV3Inner {
        private static final long serialVersionUID = -2493565731111315934L;

        /**
         * 授权业务类别
         * business_type
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("business_type")
        private String businessType;

        /**
         * 授权批次ID
         * stock_id
         * string[1,20]
         * 否
         */
        @SerializedName("stock_id")
        private String stockId;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }
}
