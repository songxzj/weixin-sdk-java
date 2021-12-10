package com.github.songxzj.wxpay.v3.bean.result.profitsharing;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxProfitSharingReceiverDeleteResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 3119043589520840092L;

    /**
     * 分账接收方类型
     * type
     * string[1, 32]
     * 是
     */
    @SerializedName("type")
    private String type;


    /**
     * 分账接收方账号
     * account
     * string[1, 64]
     * 是
     */
    @SerializedName("account")
    private String account;
}
