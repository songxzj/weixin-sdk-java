package com.github.songxzj.wxpay.v3.bean.request.bill;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.bill.WxBillDownloadBillResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2019.09.16
 * 下载账单API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_1_8.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_2_8.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_3_8.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_4_8.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_8.shtml">
 *
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_8.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_2_8.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_8.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_8.shtml">
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_8.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxBillDownloadBillRequest extends BaseWxPayV3Request<WxBillDownloadBillResult> {
    private static final long serialVersionUID = 9015582895079592905L;

    /**
     * 账单下载地址
     * download_url
     * string[1,2048]
     * 是
     */
    @Required
    @SerializedName("download_url")
    private String downloadUrl;

    @Override
    public String routing() {
        return StringUtils.substringAfter(this.downloadUrl, WxPayConstants.DEFAULT_PAY_BASE_URL);
    }

    @Override
    public Class<WxBillDownloadBillResult> getResultClass() {
        return WxBillDownloadBillResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }

    @Override
    public boolean isCheckSign() {
        return false;
    }
}
