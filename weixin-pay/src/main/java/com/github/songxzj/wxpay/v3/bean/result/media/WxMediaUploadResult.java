package com.github.songxzj.wxpay.v3.bean.result.media;

import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class WxMediaUploadResult extends BaseWxPayV3Result {
    private static final long serialVersionUID = -5296759796748982463L;

    /**
     * 媒体文件标识 Id
     * media_id
     * string(512)
     * 是
     */
    @SerializedName("media_id")
    private String mediaId;
}
