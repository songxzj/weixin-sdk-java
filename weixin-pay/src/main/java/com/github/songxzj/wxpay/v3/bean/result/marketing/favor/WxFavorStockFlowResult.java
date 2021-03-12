package com.github.songxzj.wxpay.v3.bean.result.marketing.favor;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxFavorStockFlowResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -8386420116195224980L;

    /**
     * 下载链接
     * url
     * string[1,2048]
     * 是
     */
    @SerializedName("url")
    private String url;

    /**
     * 安全校验码
     * hash_value
     * string[1,1024]
     * 是
     */
    @SerializedName("hash_value")
    private String hashValue;

    /**
     * 哈希算法类型
     * hash_type
     * string[1,32]
     * 是
     */
    @SerializedName("hash_type")
    private String hashType;
}
