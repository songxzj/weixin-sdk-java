package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorStockCouponCodeResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2019.11.08
 * 上传预存code API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_6.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorStockCouponCodeRequest extends BaseWxPayV3Request<WxBusifavorStockCouponCodeResult> {
    private static final long serialVersionUID = 2642439224987350606L;

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
     * 券code列表
     * coupon_code_list
     * array
     * 否
     */
    @SerializedName("coupon_code_list")
    private List<String> couponCodeList;

    /**
     * 请求业务单据号
     * upload_request_no
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("upload_request_no")
    private String uploadRequestNo;

    @Override
    public String routing() {
        return "/v3/marketing/busifavor/stocks/" + this.stockId + "/couponcodes";
    }

    @Override
    public Class<WxBusifavorStockCouponCodeResult> getResultClass() {
        return WxBusifavorStockCouponCodeResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
