package com.github.songxzj.wxpay.v3.bean.external.payscore;

import com.github.songxzj.wxpay.v3.bean.external.payscore.enums.PayScoreBusinessTypeEnum;
import com.github.songxzj.wxpay.v3.bean.external.payscore.extra.AbstractWxPayScoreV3ExtraData;
import lombok.*;

import java.io.Serializable;

/**
 * 小程序调起支付分(openBusinessView)
 */
@Setter
@Getter
@ToString
public class WxPayScoreV3MiniProgramData implements Serializable {
    private static final long serialVersionUID = 944183053229361318L;

    /**
     * 跳转类型
     * businessType
     * string[1,16]
     * 是
     */
    private String businessType;

    /**
     * 业务参数
     * extraData
     * Object
     * 是
     */
    private AbstractWxPayScoreV3ExtraData extraData;

    public WxPayScoreV3MiniProgramData(PayScoreBusinessTypeEnum payScoreBusinessTypeEnum, AbstractWxPayScoreV3ExtraData extraData) {
        this.businessType = payScoreBusinessTypeEnum.getTypeName();
        this.extraData = extraData;
    }


}
