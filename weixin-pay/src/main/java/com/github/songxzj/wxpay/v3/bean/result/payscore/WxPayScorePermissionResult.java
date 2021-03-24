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
public class WxPayScorePermissionResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 3095244260038283779L;

    /**
     * 预授权token
     * apply_permissions_token
     * string[1, 300]
     * 是
     */
    @SerializedName("apply_permissions_token")
    private String applyPermissionsToken;

}