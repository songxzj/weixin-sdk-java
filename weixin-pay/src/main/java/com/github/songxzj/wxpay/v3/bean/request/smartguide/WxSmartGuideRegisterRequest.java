package com.github.songxzj.wxpay.v3.bean.request.smartguide;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.smartguide.WxSmartGuideRegisterResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.09.15
 * 服务人员注册API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/smartguide/chapter3_1.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxSmartGuideRegisterRequest extends BaseWxPayV3Request<WxSmartGuideRegisterResult> {
    private static final long serialVersionUID = 689069235681705719L;

    /**
     * 子商户号
     * sub_mchid
     * string[1,32]
     * 否
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 企业ID
     * corpid
     * string[1,32]
     * 是
     */
    @Required
    @SerializedName("corpid")
    private String corpid;

    /**
     * 门店ID
     * store_id
     * int
     * 是
     */
    @Required
    @SerializedName("store_id")
    private Integer storeId;

    /**
     * 企业微信的员工ID
     * userid
     * string[1,64]
     * 是
     */
    @Required
    @SerializedName("userid")
    private String userid;

    /**
     * 企业微信的员工姓名
     * name
     * string[1,512]
     * 是
     */
    @Required
    @SensitiveEncrypt
    @SerializedName("name")
    private String name;

    /**
     * 手机号码
     * mobile
     * string[5,512]
     * 是
     */
    @Required
    @SensitiveEncrypt
    @SerializedName("mobile")
    private String mobile;

    /**
     * 员工个人二维码
     * qr_code
     * string[1,256]
     * 是
     */
    @Required
    @SerializedName("qr_code")
    private String qrCode;

    /**
     * 头像URL
     * avatar
     * string[1,256]
     * 是
     */
    @Required
    @SerializedName("avatar")
    private String avatar;

    /**
     * 群二维码URL
     * group_qrcode
     * string[1,256]
     * 否
     */
    @SerializedName("group_qrcode")
    private String groupQrcode;


    @Override
    public String routing() {
        return "/v3/smartguide/guides";
    }

    @Override
    public Class<WxSmartGuideRegisterResult> getResultClass() {
        return WxSmartGuideRegisterResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
