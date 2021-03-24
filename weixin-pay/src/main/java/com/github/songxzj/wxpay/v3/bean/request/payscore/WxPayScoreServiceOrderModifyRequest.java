package com.github.songxzj.wxpay.v3.bean.request.payscore;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.payscore.WxPayScoreServiceOrderModifyResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.03.05
 * 修改订单金额API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter6_1_17.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayScoreServiceOrderModifyRequest extends BaseWxPayV3Request<WxPayScoreServiceOrderModifyResult> {
    private static final long serialVersionUID = 8307818833159903394L;


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
     * 后付费项目
     * post_payments
     * array
     * 否
     */
    @Required
    @SerializedName("post_payments")
    private List<PostPayment> postPayments;

    /**
     * 后付费商户优惠
     * post_discounts
     * array
     * 否
     */
    @SerializedName("post_discounts")
    private List<PostDiscount> postDiscounts;

    /**
     * 总金额
     * total_amount
     * int64
     * 是
     */
    @Required
    @SerializedName("total_amount")
    private Integer totalAmount;

    /**
     * 修改原因
     * reason
     * string[1,50]
     * 是
     */
    @Required
    @SerializedName("reason")
    private String reason;


    @Override
    public String routing() {
        return "/v3/payscore/serviceorder/" + this.outOrderNo + "/modify";
    }

    @Override
    public Class<WxPayScoreServiceOrderModifyResult> getResultClass() {
        return WxPayScoreServiceOrderModifyResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.postPayments != null) {
            for (PostPayment postPayment : this.postPayments) {
                postPayment.checkConstraints();
            }
        }
        if (this.postDiscounts != null) {
            for (PostDiscount postDiscount : this.postDiscounts) {
                postDiscount.checkConstraints();
            }
        }
    }

    /**
     * 后付费项目
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostPayment extends BaseV3Inner {
        private static final long serialVersionUID = -656455420200467145L;

        /**
         * 付费项目名称
         * name
         * string[1,20]
         * 是
         */
        @Required
        @SerializedName("name")
        private String name;

        /**
         * 金额
         * amount
         * int64
         * 是
         */
        @Required
        @SerializedName("amount")
        private Integer amount;

        /**
         * 计费说明
         * description
         * string[1,30]
         * 否
         */
        @SerializedName("description")
        private String description;

        /**
         * 付费数量
         * count
         * uint32
         * 否
         */
        @SerializedName("count")
        private Integer count;

        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }

    /**
     * 后付费商户优惠
     */
    @Setter
@Getter
@ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostDiscount extends BaseV3Inner {
        private static final long serialVersionUID = 5088996480546595912L;

        /**
         * 优惠名称
         * name
         * string[1,20]
         * 否
         */
        @SerializedName("name")
        private String name;

        /**
         * 优惠说明
         * description
         * string[1,30]
         * 条件选填
         */
        @SerializedName("description")
        private String description;

        /**
         * 优惠金额
         * amount
         * int64
         * 条件选填
         */
        @SerializedName("amount")
        private Integer amount;

        /**
         * 优惠数量
         * count
         * uint32
         * 否
         */
        @SerializedName("count")
        private Integer count;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.name == null != StringUtils.isBlank(this.description)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "name 和 description 若填写，则必须同时填写");
            }
        }
    }

}
