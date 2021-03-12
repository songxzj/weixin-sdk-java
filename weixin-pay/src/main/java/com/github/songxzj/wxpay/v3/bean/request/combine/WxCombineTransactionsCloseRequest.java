package com.github.songxzj.wxpay.v3.bean.request.combine;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.combine.WxCombineTransactionsCloseResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.03.31
 * 合单支付
 * 合单关闭订单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_12.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxCombineTransactionsCloseRequest extends BaseWxPayV3Request<WxCombineTransactionsCloseResult> {
    private static final long serialVersionUID = 4209645710187633848L;

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
     * 合单商户订单号
     * combine_out_trade_no
     * string[1,32]
     * 是
     */
    @GsonExclude
    @Required
    @SerializedName("combine_out_trade_no")
    private String combineOutTradeNo;

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


        @Override
        public void checkConstraints() throws WxErrorException {
        }
    }

    @Override
    public String routing() {
        return "/v3/combine-transactions/out-trade-no/" + this.combineOutTradeNo + "/close";
    }

    @Override
    public Class<WxCombineTransactionsCloseResult> getResultClass() {
        return WxCombineTransactionsCloseResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (this.subOrders != null) {
            for (SubOrder subOrder : this.subOrders) {
                subOrder.checkConstraints();
            }
        }
    }
}
