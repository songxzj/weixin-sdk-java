package com.github.songxzj.wxpay.v3.bean.request.smartguide;

import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.annotation.SensitiveEncrypt;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.result.smartguide.WxSmartGuideUpdateResult;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

/**
 * version:2020.07.10
 * 服务人员信息更新API
 * <a href="https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/smartguide/chapter3_4.shtml">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxSmartGuideUpdateRequest extends BaseWxPayV3Request<WxSmartGuideUpdateResult> {
    private static final long serialVersionUID = -1290970679444169643L;

    /**
     * 服务人员ID
     * guide_id
     * string[1,64]
     * 是
     */
    @Required
    @GsonExclude
    @SerializedName("guide_id")
    private String guideId;

    /**
     * 子商户号
     * sub_mchid
     * string[1,64]
     * 否
     */
    @SerializedName("sub_mchid")
    private String subMchid;

    /**
     * 服务人员姓名
     * name
     * string[1,512]
     * 否
     */
    @SensitiveEncrypt
    @SerializedName("name")
    private String name;

    /**
     * 服务人员手机号码
     * mobile
     * string[1,512]
     * 否
     */
    @SensitiveEncrypt
    @SerializedName("mobile")
    private String mobile;

    /**
     * 服务人员二维码URL
     * qr_code
     * string[1,1024]
     * 否
     */
    @SerializedName("qr_code")
    private String qrCode;

    /**
     * 服务人员头像URL
     * avatar
     * string[1,1024]
     * 否
     */
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
        return "/v3/smartguide/guides/" + this.guideId;
    }

    @Override
    public Class<WxSmartGuideUpdateResult> getResultClass() {
        return WxSmartGuideUpdateResult.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.PATCH;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }
}
