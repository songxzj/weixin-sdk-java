package com.github.songxzj.wxpay.v2.bean.order;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Native支付
 */
@Data
@Builder
public class WxPayNativeOrderData implements Serializable {
    private static final long serialVersionUID = -8280926784905245526L;


    /**
     * 二维码链接(NATIVE)
     * code_url
     * string[1,512]
     * 是
     */
    private String codeUrl;
}
