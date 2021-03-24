package com.github.songxzj.wxpay.v3.bean.request.marketing.paygiftactivity;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.marketing.paygiftactivity.WxPayGiftActivityMerchantDeleteResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.util.List;

/**
 * version:2020.06.09
 * 删除活动发券商户号API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/marketing/paygiftactivity/chapter3_10.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxPayGiftActivityMerchantDeleteRequest extends BaseWxPayV3Request<WxPayGiftActivityMerchantDeleteResult> {
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
     * 删除的发券商户号
     * merchant_id_list
     * array
     * 否
     */
    @SerializedName("merchant_id_list")
    private List<String> merchantIdList;

    /**
     * 请求业务单据号
     * delete_request_no
     * string[1,128]
     * 否
     */
    @SerializedName("delete_request_no")
    private String deleteRequestNo;

    @Override
    public String routing() {
        return "/v3/marketing/paygiftactivity/activities/" + this.activityId + "/merchants/delete";
    }

    @Override
    public Class<WxPayGiftActivityMerchantDeleteResult> getResultClass() {
        return WxPayGiftActivityMerchantDeleteResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
