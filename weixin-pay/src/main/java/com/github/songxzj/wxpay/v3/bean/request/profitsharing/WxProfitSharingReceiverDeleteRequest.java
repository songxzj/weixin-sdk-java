package com.github.songxzj.wxpay.v3.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.profitsharing.enums.ProfitSharingReceiverRelationTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingReceiverAddResult;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingReceiverDeleteResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2021.05.11
 * 删除分账接收方API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_9.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxProfitSharingReceiverDeleteRequest extends BaseWxPayV3Request<WxProfitSharingReceiverDeleteResult> {
    private static final long serialVersionUID = 7126083460515705214L;
    /**
     * 应用ID
     * appid
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("appid")
    private String appid;

    /**
     * 分账接收方类型
     * type
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("type")
    private String type;


    /**
     * 分账接收方账号
     * account
     * string[1, 64]
     * 是
     */
    @Required
    @SerializedName("account")
    private String account;



    @Override
    public String routing() {
        return "/v3/profitsharing/receivers/delete";
    }

    @Override
    public Class<WxProfitSharingReceiverDeleteResult> getResultClass() {
        return WxProfitSharingReceiverDeleteResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }
}
