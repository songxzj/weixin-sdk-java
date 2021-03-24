package com.github.songxzj.wxpay.v3.bean.request.marketing.paygiftactivity;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity.WxPayGiftActivityMerchantAddResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.06.09
 * 新增活动发券商户号API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/paygiftactivity/chapter3_8.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayGiftActivityMerchantAddRequest extends BaseWxPayV3Request<WxPayGiftActivityMerchantAddResult> {
    private static final long serialVersionUID = 4034214663405027956L;

    /**
     * 活动id
     * activity_id
     * string[1,20]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("activity_id")
    private String activityId;

    /**
     * 发券商户号
     * merchant_id_list
     * array
     * 否
     */
    @SerializedName("merchant_id_list")
    private List<String> merchantIdList;

    /**
     * 商户请求单号
     * add_request_no
     * string[1,128]
     * 是
     */
    @Required
    @SerializedName("add_request_no")
    private String addRequestNo;

    @Override
    public String routing() {
        return "/v3/marketing/paygiftactivity/activities/" + this.activityId + "/merchants/add";
    }

    @Override
    public Class<WxPayGiftActivityMerchantAddResult> getResultClass() {
        return WxPayGiftActivityMerchantAddResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
