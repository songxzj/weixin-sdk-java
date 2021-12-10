package com.github.songxzj.wxpay.v3.bean.request.profitsharing;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.profitsharing.enums.ProfitSharingReceiverRelationTypeEnum;
import com.github.songxzj.wxpay.v3.bean.result.profitsharing.WxProfitSharingReceiverAddResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

/**
 * version:2021.05.11
 * 添加分账接收方API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_1_8.shtml">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxProfitSharingReceiverAddRequest extends BaseWxPayV3Request<WxProfitSharingReceiverAddResult> {
    private static final long serialVersionUID = 8119120288236211814L;

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


    /**
     * 分账个人接收方姓名
     * name
     * string[1, 1024]
     * 否
     */
    @SensitiveEncrypt
    @SerializedName("name")
    private String name;

    /**
     * 与分账方的关系类型
     * relation_type
     * string[1, 32]
     * 是
     */
    @Required
    @SerializedName("relation_type")
    private String relationType;

    /**
     * 自定义的分账关系
     * custom_relation
     * string[1, 10]
     * 否
     */
    @SerializedName("custom_relation")
    private String customRelation;


    @Override
    public String routing() {
        return "/v3/profitsharing/receivers/add";
    }

    @Override
    public Class<WxProfitSharingReceiverAddResult> getResultClass() {
        return WxProfitSharingReceiverAddResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if (ProfitSharingReceiverRelationTypeEnum.CUSTOM.name().equals(this.relationType) && StringUtils.isBlank(this.customRelation)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "当字段relation_type的值为CUSTOM时，自定义的分账关系必填");
        }

    }
}
