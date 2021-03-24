package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorStockStateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.27
 * 查询批次详情API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_5.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxFavorStockStateRequest extends BaseWxPayV3Request<WxFavorStockStateResult> {
    private static final long serialVersionUID = -1074099349318098887L;


    /**
     * 批次号
     * stock_id
     * string[1,20]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("stock_id")
    private String stockId;

    /**
     * 创建批次的商户号
     * stock_creator_mchid
     * string[1,20]
     * 是
     */
    @Required
    @SerializedName("stock_creator_mchid")
    private String stockCreatorMchid;


    @Override
    public String routing() {
        return "/v3/marketing/favor/stocks/" +this.stockId;
    }

    @Override
    public Class<WxFavorStockStateResult> getResultClass() {
        return WxFavorStockStateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
