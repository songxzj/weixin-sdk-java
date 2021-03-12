package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.marketing.favor.enums.StockFlowEnum;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorStockFlowResult;
import com.google.gson.annotations.SerializedName;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.29
 * 下载批次核销明细API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_10.shtml">
 * version:2020.09.29
 * 下载批次退款明细API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_11.shtml">
 */
public class WxFavorStockFlowRequest extends BaseWxPayV3Request<WxFavorStockFlowResult> {
    private static final long serialVersionUID = -7459975251657053313L;

    @Required
    private StockFlowEnum stockFlowEnum;
    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 否
     */
    @Required
    @SerializedName("stock_id")
    private String stockId;

    @Override
    public String routing() {
        return "/v3/marketing/favor/stocks/" + this.stockId + "/" + this.stockFlowEnum.getFlowName();
    }

    @Override
    public Class<WxFavorStockFlowResult> getResultClass() {
        return WxFavorStockFlowResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
