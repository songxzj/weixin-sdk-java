package com.github.songxzj.wxpay.v3.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付方式
 */
@Getter
@AllArgsConstructor
public enum TradeTypeEnum {
    /**
     * APP
     */
    APP("app"),
    /**
     * JSAPI
     */
    JSAPI("jsapi"),
    /**
     * NATIVE
     */
    NATIVE("native"),
    /**
     * MWEB
     */
    H5("h5");

    /**
     * 类型名称
     */
    private final String typeName;

}
