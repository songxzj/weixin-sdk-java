package com.github.songxzj.wxpay.v3.bean.result.applyment;


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
public class WxApplymentAuthorizeVerifyStateResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 1473687025896489163L;


    /**
     * 授权状态
     * authorize_state	string(32)
     * 是
     */
    @SerializedName("authorize_state")
    private String authorizeState;
}
