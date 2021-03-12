package com.github.songxzj.wxpay.v3.bean.request.paypartner;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.pay.WxPayTransactionsResult;
import com.github.songxzj.wxpay.v3.enums.TradeTypeEnum;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.05.26
 * 基础支付（服务商模式）
 * JSAPI/小程序下单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_1.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_1.shtml">
 * APP下单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_2_1.shtml">
 * H5下单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_1.shtml">
 * Native下单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_1.shtml">
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayPartnerTransactionsRequest extends BaseWxPayV3Request<WxPayTransactionsResult> {
    private static final long serialVersionUID = -7292862638513689478L;


    /**
     * 支付方式
     */
    @Required
    @GsonExclude
    private TradeTypeEnum tradeTypeEnum;

    /**
     * 公服务商公众号ID
     * sp_appid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("sp_appid")
    private String spAppid;

    /**
     * 服务商户号
     * sp_mchid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("sp_mchid")
    private String spMchid;

    /**
     * 子商户公众号ID
     * sub_appid
     * string[1,32]
     * 否
     */
    @SerializedName("sub_appid")
    private String subAppid;

    /**
     * 子商户号
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
     * 商户订单号
     * out_trade_no
     * string[6,32]
     * 是
     */
    @Required
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 交易结束时间
     * time_expire
     * string[1,64]
     * 否
     */
    @SerializedName("time_expire")
    private String timeExpire;

    /**
     * 附加数据
     * attach
     * string[1,128]
     * 否
     */
    @SerializedName("attach")
    private String attach;

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
     * 订单优惠标记
     * goods_tag
     * string[1,32]
     * 否
     */
    @SerializedName("goods_tag")
    private String goodsTag;

    /**
     * 结算信息
     * settle_info
     * object
     * 否
     */
    @SerializedName("settle_info")
    private SettleInfo settleInfo;

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
     * 支付者
     * payer
     * object
     * (jsapi必填)
     */
    @SerializedName("payer")
    private Payer payer;

    /**
     * 优惠功能
     * detail
     * object
     * 否
     */
    @SerializedName("detail")
    private Detail detail;

    /**
     * 场景信息
     * scene_info
     * object
     * 否
     */
    @SerializedName("scene_info")
    private SceneInfo sceneInfo;


    /**
     * 结算信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SettleInfo extends BaseV3Inner {
        private static final long serialVersionUID = -8178339787382876652L;

        /**
         * 是否指定分账
         * profit_sharing
         * bool
         * 否
         */
        @SerializedName("profit_sharing")
        private Boolean profitSharing;


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
        private static final long serialVersionUID = 7513057422184518449L;

        /**
         * 总金额
         * total
         * int
         * 是
         */
        @Required
        @SerializedName("total")
        private Integer total;

        /**
         * 货币类型
         * currency
         * string[1,16]
         * 否
         */
        @SerializedName("currency")
        private String currency;

        @Override
        public void checkConstraints() throws WxErrorException {
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
    public static class Payer extends BaseV3Inner {
        private static final long serialVersionUID = 181793370535433723L;
        /**
         * 用户服务标识
         * sp_openid
         * string[1,128]
         */
        @SerializedName("sp_openid")
        private String spOpenid;

        /**
         * 用户子标识
         * sub_openid
         * string[1,128]
         */
        @SerializedName("sub_openid")
        private String subOpenid;

        @Override
        public void checkConstraints() throws WxErrorException {
            if (StringUtils.isBlank(this.spOpenid) == StringUtils.isBlank(this.subOpenid)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "用户服务标识 与 用户子标识，二选一必填");
            }
        }
    }


    /**
     * 优惠功能
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Detail extends BaseV3Inner {
        private static final long serialVersionUID = 2593576050466838013L;

        /**
         * 订单原价
         * cost_price
         * int
         * 否
         */
        @SerializedName("cost_price")
        private Integer costPrice;

        /**
         * 商品小票ID
         * invoice_id
         * string[1,32]
         * 否
         */
        @SerializedName("invoice_id")
        private String invoiceId;

        /**
         * 单品列表
         * goods_detail
         * array
         * 否
         */
        @SerializedName("goods_detail")
        private List<GoodsDetail> goodsDetails;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.goodsDetails != null) {
                for (GoodsDetail goodsDetail : this.goodsDetails) {
                    goodsDetail.checkConstraints();
                }
            }
        }
    }


    /**
     * 单品列表
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GoodsDetail extends BaseV3Inner {
        private static final long serialVersionUID = -2153998737178060201L;
        /**
         * 商户侧商品编码
         * merchant_goods_id
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("merchant_goods_id")
        private String merchantGoodsId;

        /**
         * 微信侧商品编码
         * wechatpay_goods_id
         * string[1,32]
         * 否
         */
        @SerializedName("wechatpay_goods_id")
        private String wechatpayGoodsId;

        /**
         * 商品名称
         * goods_name
         * string[1,256]
         * 否
         */
        @SerializedName("goods_name")
        private String goodsName;

        /**
         * 商品数量
         * quantity
         * int
         * 是
         */
        @Required
        @SerializedName("quantity")
        private Integer quantity;

        /**
         * 商品单价
         * unit_price
         * int
         * 是
         */
        @Required
        @SerializedName("unit_price")
        private Integer unitPrice;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }

    /**
     * 场景信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SceneInfo extends BaseV3Inner {
        private static final long serialVersionUID = -6234354245419040234L;

        /**
         * 用户终端IP
         * payer_client_ip
         * string[1,45]
         * 是
         */
        @Required
        @SerializedName("payer_client_ip")
        private String payerClientIp;

        /**
         * 商户端设备号
         * device_id
         * string[1,32]
         * 否
         */
        @SerializedName("device_id")
        private String deviceId;

        /**
         * 商户门店信息
         * store_info
         * object
         * 否
         */
        @SerializedName("store_info")
        private StoreInfo storeInfo;

        /**
         * H5场景信息
         * h5_info
         * object
         * (h5必填)
         */
        @SerializedName("h5_info")
        private H5Info h5Info;


        @Override
        public void checkConstraints() throws WxErrorException {
            if (this.storeInfo != null) {
                this.storeInfo.checkConstraints();
            }
            if (this.h5Info != null) {
                this.h5Info.checkConstraints();
            }
        }
    }

    /**
     * 商户门店信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreInfo extends BaseV3Inner {
        private static final long serialVersionUID = 5851696948595696488L;
        /**
         * 门店编号
         * id
         * string[1,32]
         * 是
         */
        @Required
        @SerializedName("id")
        private String id;

        /**
         * 门店名称
         * name
         * string[1,256]
         * 否
         */
        @SerializedName("name")
        private String name;

        /**
         * 地区编码
         * area_code
         * string[1,32]
         * 否
         */
        @SerializedName("area_code")
        private String areaCode;

        /**
         * 详细地址
         * address
         * string[1,512]
         * 否
         */
        @SerializedName("address")
        private String address;

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
        return "/v3/pay/partner/transactions/" + this.tradeTypeEnum.getTypeName();
    }

    @Override
    public Class<WxPayTransactionsResult> getResultClass() {
        return WxPayTransactionsResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (TradeTypeEnum.JSAPI.equals(this.tradeTypeEnum) && this.payer == null) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "JSAPI 支付，支付者必填");
        }
        if (TradeTypeEnum.H5.equals(this.tradeTypeEnum) && this.sceneInfo == null) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "H5 支付，场景信息必填");
        }

        if (this.settleInfo != null) {
            this.settleInfo.checkConstraints();
        }
        if (this.amount != null) {
            this.amount.checkConstraints();
        }
        if (this.payer != null) {
            this.payer.checkConstraints();
        }
        if (this.detail != null) {
            this.detail.checkConstraints();
        }
        if (this.sceneInfo != null) {
            this.sceneInfo.checkConstraints();
        }


    }
}
