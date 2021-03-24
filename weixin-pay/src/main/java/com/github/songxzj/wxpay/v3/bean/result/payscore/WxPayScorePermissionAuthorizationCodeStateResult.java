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
public class WxPayScorePermissionAuthorizationCodeStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -5371045792744269137L;


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
     * 用户标识
     * openid
     * string[1,128]
     * 否
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 授权协议号
     * authorization_code
     * string[1,32]
     * 是
     */
    @SerializedName("authorization_code")
    private String authorizationCode;

    /**
     * 授权状态
     * authorization_state
     * string[1, 16]
     * 是
     */
    @SerializedName("authorization_state")
    private String authorizationState;

    /**
     * 授权通知地址
     * notify_url
     * string[1,255]
     * 否
     */
    @SerializedName("notify_url")
    private String notifyUrl;

    /**
     * 最近一次解除授权时间
     * cancel_authorization_time
     * string[1.32]
     * 否
     */
    @SerializedName("cancel_authorization_time")
    private String cancelAuthorizationTime;

    /**
     * 最近一次授权成功时间
     * authorization_success_time
     * string[1,32]
     * 否
     */
    @SerializedName("authorization_success_time")
    private String authorizationSuccessTime;

}