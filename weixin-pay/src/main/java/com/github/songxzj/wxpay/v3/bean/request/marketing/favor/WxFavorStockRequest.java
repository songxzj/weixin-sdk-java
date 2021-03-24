package com.github.songxzj.wxpay.v3.bean.request.marketing.favor;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.marketing.favor.enums.StockOperateTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.marketing.favor.WxFavorStockResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.27
 * 激活代金券批次API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_3.shtml">
 * version:2019.10.22
 * 暂停代金券批次API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_13.shtml">
 * version:2019.10.22
 * 重启代金券批次API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/convention/chapter3_14.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxFavorStockRequest extends BaseWxPayV3Request<WxFavorStockResult> {
    private static final long serialVersionUID = -4625019808746202660L;

    @Required
    @GsonExclude
    private StockOperateTypeEnum stockOperateTypeEnum;
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
    @GsonExclude
    @SerializedName("stock_id")
    private String stockId;


    @Override
    public String routing() {
        return "/v3/marketing/favor/stocks/" + this.stockId + "/" + this.stockOperateTypeEnum.name().toLowerCase();
    }

    @Override
    public Class<WxFavorStockResult> getResultClass() {
        return WxFavorStockResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
