package com.github.songxzj.wxpay.v3.bean.request.marketing.partnership;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.json.WxGsonBuilder;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.partnership.WxPartnershipStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.net.URLEncoder;

/**
 * version:2020.04.09
 * 查询合作关系列表API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/partnerships/chapter3_3.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPartnershipStateRequest extends BaseWxPayV3Request<WxPartnershipStateResult> {
    private static final long serialVersionUID = 6855211354998167164L;

    /**
     * 合作方信息
     * partner
     * object
     * 否
     */
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

    /**
     * 分页大小
     * limit
     * uint64
     * 否
     */
    @SerializedName("limit")
    private Integer limit;

    /**
     * 分页页码
     * offset
     * uint64
     * 否
     */
    @SerializedName("offset")
    private Integer offset;

    @SneakyThrows
    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/marketing/partnerships?authorized_data=").append(URLEncoder.encode(WxGsonBuilder.create().toJson(this.authorizedData), WxPayConstants.DEFAULT_CHARSET));
        if (this.partner != null) {
            routing.append("&partner=").append(URLEncoder.encode(WxGsonBuilder.create().toJson(this.partner), WxPayConstants.DEFAULT_CHARSET));
        }
        if (this.limit != null) {
            routing.append("&limit=").append(this.limit);
        }
        if (this.offset != null) {
            routing.append("&offset=").append(this.offset);
        }
        return routing.toString();
    }

    @Override
    public Class<WxPartnershipStateResult> getResultClass() {
        return WxPartnershipStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
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
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Partner extends BaseV3Inner {
        private static final long serialVersionUID = -4148454161061027378L;

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
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthorizedData extends BaseV3Inner {
        private static final long serialVersionUID = 4167743002570987513L;
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
