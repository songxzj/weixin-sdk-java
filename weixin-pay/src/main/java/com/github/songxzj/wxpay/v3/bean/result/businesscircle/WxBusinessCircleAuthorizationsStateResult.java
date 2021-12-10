package com.github.songxzj.wxpay.v3.bean.result.businesscircle;


import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxBusinessCircleAuthorizationsStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -650507570091307742L;


    /**
     * 顾客openid
     * openid
     * string[1, 64]
     * 是
     */
    @SerializedName("openid")
    private String openid;

    /**
     * 授权状态
     * authorize_state
     * string[1, 32]
     * 是
     */
    @SerializedName("authorize_state")
    private String authorizeState;

    /**
     * 授权时间
     * authorize_time
     * string[1, 32]
     * 否
     */
    @SerializedName("authorize_time")
    private String authorizeTime;


    /**
     * 取消授权时间
     * deauthorize_time
     * string[1, 32]
     * 否
     */
    @SerializedName("deauthorize_time")
    private String deauthorizeTime;
}
