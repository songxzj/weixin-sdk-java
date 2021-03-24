package com.github.songxzj.wxpay.v3.bean.result.payscore;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxPayScorePermissionStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -3181199945383714094L;

    /**
     * 服务ID
     * service_id
     * string[1,32]
     * 是
     */
    @SerializedName("service_id")
    private String serviceId;

    /**
     * 应用ID
     * appid
     * string[1,32]
     * 是
     */
    @SerializedName("appid")
    private String appid;

    /**
     * 商户号
     * mchid
     * string[1,32]
     * 是
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 商户签约单号
     * out_request_no
     * string[1,64]
     * 否
     */
    @SerializedName("out_request_no")
    private String outRequestNo;

    /**
     * 用户标识
     * openid
     * string[1,128]
     * 是
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 回调状态
     * user_service_status
     * string[1,32]
     * 否
     */
    @SerializedName("user_service_status")
    private String userServiceStatus;

    /**
     * 授权协议号
     * authorization_code
     * string[1,32]
     * 是
     */
    @SerializedName("authorization_code")
    private String authorizationCode;

    /**
     * 服务开启/解除授权时间
     * openorclose_time
     * string[1,32]
     * 否
     */
    @SerializedName("openorclose_time")
    private String openorcloseTime;

}