package com.github.songxzj.wxpay.v3.bean.request.bill;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.bill.WxBillFundFlowBillResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2019.09.16
 * 申请资金账单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_7.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_7.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_7.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_7.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_7.shtml">
 *
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_7.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_2_7.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_7.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_7.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_7.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBillFundFlowBillRequest extends BaseWxPayV3Request<WxBillFundFlowBillResult> {
    private static final long serialVersionUID = -6273007357152756475L;


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
     * 资金账户类型
     * account_type
     * string[1,32]
     * 否
     */
    @SerializedName("account_type")
    private String accountType;


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
        StringBuffer routing = new StringBuffer("/v3/bill/fundflowbill?bill_date=").append(this.billDate);
        if (!StringUtils.isBlank(this.accountType)) {
            routing.append("&account_type=").append(this.accountType);
        }
        if (!StringUtils.isBlank(this.tarType)) {
            routing.append("&tar_type=").append(this.tarType);
        }
        return routing.toString();
    }

    @Override
    public Class<WxBillFundFlowBillResult> getResultClass() {
        return WxBillFundFlowBillResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
