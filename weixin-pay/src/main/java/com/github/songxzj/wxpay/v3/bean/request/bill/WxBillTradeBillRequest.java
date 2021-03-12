package com.github.songxzj.wxpay.v3.bean.request.bill;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.bill.WxBillTradeBillResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2019.09.16
 * 申请交易账单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_6.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_6.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_6.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_6.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_6.shtml">
 *
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_6.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_2_6.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_6.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_6.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_6.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBillTradeBillRequest extends BaseWxPayV3Request<WxBillTradeBillResult> {
    private static final long serialVersionUID = -657305545655025565L;

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
     * 二级商户号
     * sub_mchid
     * string[1,12]
     * 否
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 账单类型
     * bill_type
     * string[1,32]
     * 否
     */
    @SerializedName("bill_type")
    private String billType;


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
        StringBuffer routing = new StringBuffer("/v3/bill/tradebill?bill_date=").append(this.billDate);
        if (!StringUtils.isBlank(this.subMchid)) {
            routing.append("&sub_mchid=").append(this.subMchid);
        }
        if (!StringUtils.isBlank(this.billType)) {
            routing.append("&bill_type=").append(this.billType);
        }
        if (!StringUtils.isBlank(this.tarType)) {
            routing.append("&tar_type=").append(this.tarType);
        }
        return routing.toString();
    }

    @Override
    public Class<WxBillTradeBillResult> getResultClass() {
        return WxBillTradeBillResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
