package com.github.songxzj.wxpay.v3.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingOrderStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2022.06.14
 * 请求分账API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_1.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxProfitSharingOrderRequest extends BaseWxPayV3Request<WxProfitSharingOrderStateResult> {
    private static final long serialVersionUID = 482424761194229814L;


    /**
     * 应用ID
     * appid
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 微信订单号
     * transaction_id
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 商户分账单号
     * out_order_no
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("out_order_no")
    private String outOrderNo;

    /**
     * 分账接收方列表
     * receivers
     * array
     * 是
     */
    @Required
    @SerializedName("receivers")
    private List<Receiver> receivers;

    /**
     * 是否解冻剩余未分资金
     * unfreeze_unsplit
     * boolean
     * 是
     */
    @Required
    @SerializedName("unfreeze_unsplit")
    private Boolean unfreeze_unsplit;


    /**
     * 分账接收方
     */
    @Setter
    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Receiver extends BaseV3Inner {
        private static final long serialVersionUID = 3821748422794981983L;

        /**
         * 分账接收方类型
         * type
         * string[1, 32]
         * 是
         */
        @Required
        @SerializedName("type")
        private String type;

        /**
         * 分账接收方账号
         * account
         * string[1, 64]
         * 是
         */
        @Required
        @SerializedName("account")
        private String account;

        /**
         * 分账个人接收方姓名
         * name
         * string[1, 1024]
         * 否
         */
        @SensitiveEncrypt
        @SerializedName("name")
        private String name;

        /**
         * 分账金额
         * amount
         * int
         * 是
         */
        @Required
        @SerializedName("amount")
        private Integer amount;

        /**
         * 分账描述
         * description
         * string[1, 80]
         * 是
         */
        @Required
        @SerializedName("description")
        private String description;


        @Override
        public void checkConstraints() throws WxErrorException {

        }
    }


    @Override
    public String routing() {
        return "/v3/profitsharing/orders";
    }

    @Override
    public Class<WxProfitSharingOrderStateResult> getResultClass() {
        return WxProfitSharingOrderStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
