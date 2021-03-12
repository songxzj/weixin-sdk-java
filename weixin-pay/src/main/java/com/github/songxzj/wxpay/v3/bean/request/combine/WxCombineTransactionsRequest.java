package com.github.songxzj.wxpay.v3.bean.request.combine;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.combine.WxCombineTransactionsResult;
import com.github.songxzj.wxpay.v3.enums.TradeTypeEnum;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * 合单支付
 * 合单APP下单API version:2020.05.21
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_1.shtml">
 * 合单H5下单API version:2020.06.09
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_2.shtml">
 * 合单JSAPI/小程序下单API version:2020.05.21
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_3.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_4.shtml">
 * 合单Native下单API version:2020.05.14
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_5.shtml">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxCombineTransactionsRequest extends BaseWxPayV3Request<WxCombineTransactionsResult> {
    private static final long serialVersionUID = -6426154877331041225L;

    /**
     * 支付方式
     */
    @Required
    @GsonExclude
    private TradeTypeEnum tradeTypeEnum;

    /**
     * 合单商户appid
     * combine_appid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("combine_appid")
    private String combineAppid;

    /**
     * 合单商户号
     * combine_mchid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("combine_mchid")
    private String combineMchid;

    /**
     * 合单商户订单号
     * combine_out_trade_no
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("combine_out_trade_no")
    private String combineOutTradeNo;

    /**
     * 场景信息
     * scene_info
     * object
     * 否
     */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;

    /**
     * 子单信息
     * sub_orders
     * array
     * 是
     */
    @Required
    @SerializedName("sub_orders")
    private List<SubOrder> subOrders;

    /**
     * 支付者
     * combine_payer_info
     * object
     * 否
     */
    @SerializedName("combine_payer_info")
    private CombinePayerInfo combinePayerInfo;

    /**
     * 交易起始时间
     * time_start
     * string[1,14]
     * 否
     */
    @SerializedName("time_start")
    private String timeStart;

    /**
     * 交易结束时间
     * time_expire
     * string[1,14]
     * 否
     */
    @SerializedName("time_expire")
    private String timeExpire;

    /**
     * 通知地址
     * notify_url
     * string[1,256]
     * 是
     */
    @Required
    @SerializedName("notify_url")
    private String notifyUrl;


    /**
     * 场景信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SceneInfo extends BaseV3Inner {
        private static final long serialVersionUID = -510864668211498663L;
        /**
         * 商户端设备号
         * device_id
         * string[7,16]
         * 否
         */
        @SerializedName("device_id")
        private String deviceId;

        /**
         * 用户终端IP
         * payer_client_ip
         * string[1,45]
         * 是
         */
        @SerializedName("payer_client_ip")
        private String payerClientIp;

        /**
         * H5场景信息
         * h5_info
         * object
         * 是
         */
        @SerializedName("h5_info")
        private H5Info h5Info;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.h5Info != null) {
                this.h5Info.checkConstraints();
            }
        }
    }

    /**
     * 子单信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubOrder extends BaseV3Inner {
        private static final long serialVersionUID = -8802511140286091893L;
        /**
         * 子单商户号
         * mchid
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("mchid")
        private String mchid;

        /**
         * 附加数据
         * attach
         * string[1,128]
         * 是
         */
        @Required
        @SerializedName("attach")
        private String attach;

        /**
         * 订单金额
         * amount
         * object
         * 是
         */
        @Required
        @SerializedName("amount")
        private Amount amount;

        /**
         * 子单商户订单号
         * out_trade_no
         * string[6,32]
         * 是
         */
        @Required
        @SerializedName("out_trade_no")
        private String outTradeNo;

        /**
         * 二级商户号
         * sub_mchid
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("sub_mchid")
        private String subMchid;

        /**
         * 商品描述
         * description
         * string[1,127]
         * 是
         */
        @Required
        @SerializedName("description")
        private String description;

        /**
         * 结算信息
         * settle_info
         * object
         * 否
         */
        @SerializedName("settle_info")
        private SettleInfo settleInfo;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.amount != null) {
                this.amount.checkConstraints();
            }
            if (this.settleInfo != null) {
                this.settleInfo.checkConstraints();
            }
        }
    }

    /**
     * 支付者
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CombinePayerInfo extends BaseV3Inner {
        private static final long serialVersionUID = -1632408375620085095L;
        /**
         * 用户标识
         * openid
         * string[1,128]
         * 否
         */
        @SerializedName("openid")
        private String openid;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }

    /**
     * 订单金额
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Amount extends BaseV3Inner {
        private static final long serialVersionUID = -6396940858028825728L;
        /**
         * 标价金额
         * total_amount
         * int
         * 是
         */
        @Required
        @SerializedName("total_amount")
        private Integer totalAmount;

        /**
         * 标价币种
         * currency
         * string[1,8]
         * 是
         */
        @Required
        @SerializedName("currency")
        private String currency;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }

    /**
     * 结算信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SettleInfo extends BaseV3Inner {
        private static final long serialVersionUID = -7367230131300974701L;
        /**
         * 是否指定分账
         * profit_sharing
         * bool
         * 否
         */
        @SerializedName("profit_sharing")
        private Boolean profitSharing;

        /**
         * 补差金额
         * subsidy_amount
         * int64
         * 否
         */
        @SerializedName("subsidy_amount")
        private Integer subsidyAmount;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }

    /**
     * H5场景信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class H5Info extends BaseV3Inner {
        private static final long serialVersionUID = 7312193211841566135L;

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
         * 应用名称
         * app_name
         * string[1,64]
         * 否
         */
        @SerializedName("app_name")
        private String appName;

        /**
         * 网站URL
         * app_url
         * string[1,128]
         * 否
         */
        @SerializedName("app_url")
        private String appUrl;

        /**
         * iOS平台BundleID
         * bundle_id
         * string[1,128]
         * 否
         */
        @SerializedName("bundle_id")
        private String bundleId;

        /**
         * Android平台PackageName
         * package_name
         * string[1,128]
         * 否
         */
        @SerializedName("package_name")
        private String packageName;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }


    @Override
    public String routing() {
        return "/v3/combine-transactions/" + this.tradeTypeEnum.getTypeName();
    }

    @Override
    public Class<WxCombineTransactionsResult> getResultClass() {
        return WxCombineTransactionsResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (TradeTypeEnum.JSAPI.equals(this.tradeTypeEnum) && this.combinePayerInfo == null) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "JSAPI 支付，支付者必填");
        }
        if (TradeTypeEnum.H5.equals(tradeTypeEnum) && this.sceneInfo == null) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "H5 支付，场景信息必填");
        }
        if (this.sceneInfo != null) {
            this.sceneInfo.checkConstraints();
        }
        if (this.subOrders != null) {
            for (SubOrder subOrder : this.subOrders) {
                subOrder.checkConstraints();
            }
        }
        if (this.combinePayerInfo != null) {
            this.combinePayerInfo.checkConstraints();
        }
    }
}
