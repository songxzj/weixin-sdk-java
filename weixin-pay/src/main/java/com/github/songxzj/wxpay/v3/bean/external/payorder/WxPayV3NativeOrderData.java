package com.github.songxzj.wxpay.v3.bean.external.payorder;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Native支付
 */
@Data
@Builder
public class WxPayV3NativeOrderData implements Serializable {
    private static final long serialVersionUID = -7084791652535361321L;

    /**
     * 二维码链接(NATIVE)
     * code_url
     * string[1,512]
     * 是
     */
    private String codeUrl;
}
