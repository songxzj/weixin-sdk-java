package com.github.songxzj.wxpay.v3.bean.request.marketing.favor.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  StockFlowEnum {

    USE("use-flow"),

    REFUND("refund-flow"),

    ;

    private final String flowName;
}
