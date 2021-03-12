package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorStockItemResult;
import com.google.gson.annotations.SerializedName;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.29
 * 查询代金券可用单品API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_8.shtml">
 */
public class WxFavorStockItemRequest extends BaseWxPayV3Request<WxFavorStockItemResult> {
    private static final long serialVersionUID = 7813947956511117932L;
    /**
     * 分页页码
     * offset
     * uint32
     * 是
     */
    @Required
    @SerializedName("offset")
    private Integer offset;

    /**
     * 分页大小
     * limit
     * uint32
     * 是
     */
    @Required
    @SerializedName("limit")
    private Integer limit;

    /**
     * 创建批次的商户号
     * stock_creator_mchid
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("stock_creator_mchid")
    private String stockCreatorMchid;

    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("stock_id")
    private String stockId;

    @Override
    public String routing() {
        StringBuffer routing = new StringBuffer("/v3/marketing/favor/stocks/" + this.stockId + "/items?offset=").append(this.offset)
                .append("&limit=").append(this.limit)
                .append("&stock_creator_mchid=").append(this.stockCreatorMchid);

        return routing.toString();
    }

    @Override
    public Class<WxFavorStockItemResult> getResultClass() {
        return WxFavorStockItemResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
