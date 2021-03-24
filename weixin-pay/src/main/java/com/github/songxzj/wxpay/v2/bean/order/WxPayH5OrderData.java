package com.github.songxzj.wxpay.v2.bean.order;

import lombok.Builder;
import lombok.*;

import java.io.Serializable;

/**
 * H5 支付
 */
@Setter
@Getter
@ToString
@Builder
public class WxPayH5OrderData implements Serializable {
    private static final long serialVersionUID = -7427427635279463172L;

    private String mwebUrl;
}
