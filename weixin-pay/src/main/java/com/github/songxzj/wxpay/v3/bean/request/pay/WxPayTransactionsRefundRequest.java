package com.github.songxzj.wxpay.v3.bean.request.pay;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.pay.WxPayTransactionsRefundResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2021.01.15
 * 基础支付（直连模式）
 * 申请退款API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_9.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_9.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_9.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_9.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_9.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayTransactionsRefundRequest extends BaseWxPayV3Request<WxPayTransactionsRefundResult> {
    private static final long serialVersionUID = -2503436353079565442L;

    /**
     * 微信支付订单号
     * transaction_id
     * string[1, 32]
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     * out_trade_no
     * string[1, 32]
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 商户退款单号
     * out_refund_no
     * string[1, 64]
     * 是
     */
    @Required
    @SerializedName("out_refund_no")
    private String outRefundNo;

    /**
     * 退款原因
     * reason
     * string[1, 80]
     * 否
     */
    @SerializedName("reason")
    private String reason;

    /**
     * 退款结果回调url
     * notify_url
     * string[8, 256]
     * 否
     */
    @SerializedName("notify_url")
    private String notifyUrl;


    /**
     * 退款资金来源
     * funds_account
     * string[1,16]
     * 否
     */
    @SerializedName("funds_account")
    private String fundsAccount;

    /**
     * 金额信息
     * amount
     * object
     * 是
     */
    @Required
    @SerializedName("amount")
    private Amount amount;

    /**
     * 退款商品
     * goods_detail
     * array
     * 否
     */
    @SerializedName("goods_detail")
    private List<GoodsDetail> goodsDetail;

    /**
     * 金额信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Amount extends BaseV3Inner {
        private static final long serialVersionUID = -5584318904431386294L;

        /**
         * 退款金额
         * refund
         * int
         * 是
         */
        @Required
        @SerializedName("refund")
        private Integer refund;

        /**
         * 原订单金额
         * total
         * int
         * 是
         */
        @Required
        @SerializedName("total")
        private Integer total;

        /**
         * 退款币种
         * currency
         * string[1, 16]
         * 是
         */
        @Required
        @SerializedName("currency")
        private String currency;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }


    @Data
    @EqualsAndHashCode(callSuper = true)
    @Builder(builderMethodName = "newBuilder")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GoodsDetail extends BaseV3Inner {
        private static final long serialVersionUID = -7100085932146564241L;
        /**
         * 商户侧商品编码
         * merchant_goods_id
         * string[1, 32]
         * 是
         */
        @Required
        @SerializedName("merchant_goods_id")
        private String merchantGoodsId;

        /**
         * 微信侧商品编码
         * wechatpay_goods_id
         * string[1, 32]
         * 否
         */
        @SerializedName("wechatpay_goods_id")
        private String wechatpayGoodsId;

        /**
         * 商品名称
         * goods_name
         * string[1, 256]
         * 否
         */
        @SerializedName("goods_name")
        private String goodsName;

        /**
         * 商品单价
         * unit_price
         * int
         * 是
         */
        @Required
        @SerializedName("unit_price")
        private Integer unitPrice;

        /**
         * 商品退款金额
         * refund_amount
         * int
         * 是
         */
        @Required
        @SerializedName("refund_amount")
        private Integer refundAmount;

        /**
         * 商品退货数量
         * refund_quantity
         * int
         * 是
         */
        @Required
        @SerializedName("refund_quantity")
        private Integer refundQuantity;

        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }

    @Override
    public String routing() {
        return "/v3/refund/domestic/refunds";
    }

    @Override
    public Class<WxPayTransactionsRefundResult> getResultClass() {
        return WxPayTransactionsRefundResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (StringUtils.isBlank(this.transactionId) == StringUtils.isBlank(this.outTradeNo)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "transaction_id 和 out_trade_no 不能同时存在或同时为空，必须二选一");
        }
        if (this.amount != null) {
            this.amount.checkConstraints();
        }
        if (this.goodsDetail != null) {
            for (GoodsDetail detail : this.goodsDetail) {
                detail.checkConstraints();
            }
        }
    }

}
