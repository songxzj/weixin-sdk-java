package com.github.songxzj.wxpay.v3.bean.result.bill;

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
public class WxBillTradeBillResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = 999539107441808168L;

    /**
     * 哈希类型
     * hash_type
     * string[1,32]
     * 是
     */
    @SerializedName("hash_type")
    private String hashType;

    /**
     * 哈希值
     * hash_value
     * string[1,1024]
     * 是
     */
    @SerializedName("hash_value")
    private String hashValue;

    /**
     * 账单下载地址
     * download_url
     * string[1,2048]
     * 是
     */
    @SerializedName("download_url")
    private String downloadUrl;
}
