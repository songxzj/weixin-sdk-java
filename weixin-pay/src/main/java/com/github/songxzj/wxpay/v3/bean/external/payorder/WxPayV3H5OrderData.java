package com.github.songxzj.wxpay.v3.bean.external.payorder;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * H5支付
 */
@Data
@Builder
public class WxPayV3H5OrderData implements Serializable {
    private static final long serialVersionUID = 3253320865760020427L;

    /**
     * 支付跳转链接(H5)
     * h5_url
     * string[1,512]
     * 是
     */
    private String h5Url;
}
