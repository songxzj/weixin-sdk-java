package com.github.songxzj.wxpay.v3.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingBillResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2021.07.22
 * 申请分账账单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_11.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxProfitSharingBillRequest extends BaseWxPayV3Request<WxProfitSharingBillResult> {
    private static final long serialVersionUID = 1133953679976932919L;

    /**
     * 账单日期
     * bill_date
     * string[1,10]
     * 是
     */
    @Required
    @SerializedName("bill_date")
    private String billDate;

    /**
     * 压缩类型
     * tar_type
     * string[1,32]
     * 否
     */
    @SerializedName("tar_type")
    private String tarType;


    @Override
    public String routing() {
        return "/v3/profitsharing/bills";
    }

    @Override
    public Class<WxProfitSharingBillResult> getResultClass() {
        return WxProfitSharingBillResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
