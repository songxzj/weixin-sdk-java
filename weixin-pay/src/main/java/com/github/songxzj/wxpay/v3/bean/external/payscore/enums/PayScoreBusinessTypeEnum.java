package com.github.songxzj.wxpay.v3.bean.external.payscore.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  PayScoreBusinessTypeEnum {

    USE("wxpayScoreUse", "pages/use/use"),

    DETAIL("wxpayScoreDetail", "pages/record/detail"),

    ENABLE("wxpayScoreEnable", "pages/use/enable"),

    ;

    private final String typeName;

    private final String navigateToMiniProgramPath;
}
