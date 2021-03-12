package com.github.songxzj.wxpay.v3.bean.request.marketing.busifavor;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.busifavor.WxBusifavorStockBudgetResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.11.04
 * 修改批次预算API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/busifavor/chapter3_11.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBusifavorStockBudgetRequest extends BaseWxPayV3Request<WxBusifavorStockBudgetResult> {
    private static final long serialVersionUID = -3538428048674462303L;

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
     * 目标批次最大发放个数
     * target_max_coupons
     * int
     */
    @SerializedName("target_max_coupons")
    private Integer targetMaxCoupons;

    /**
     * 目标单天发放上限个数
     * target_max_coupons_by_day
     * int
     */
    @SerializedName("target_max_coupons_by_day")
    private Integer targetMaxCouponsByDay;

    /**
     * 当前批次最大发放个数
     * current_max_coupons
     * int
     * 否
     */
    @SerializedName("current_max_coupons")
    private Integer currentMaxCoupons;

    /**
     * 当前单天发放上限个数
     * current_max_coupons_by_day
     * int
     * 否
     */
    @SerializedName("current_max_coupons_by_day")
    private Integer currentMaxCouponsByDay;

    /**
     * 修改预算请求单据号
     * modify_budget_request_no
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("modify_budget_request_no")
    private String modifyBudgetRequestNo;

    @Override
    public String routing() {
        return "/v3/marketing/busifavor/stocks/" + this.stockId + "/budget";
    }

    @Override
    public Class<WxBusifavorStockBudgetResult> getResultClass() {
        return WxBusifavorStockBudgetResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.PATCH;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if ((this.targetMaxCoupons == null) == (this.targetMaxCouponsByDay == null)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "批次最大发放个数 与 单天发放上限个数，二选一必填");
        }
    }
}
