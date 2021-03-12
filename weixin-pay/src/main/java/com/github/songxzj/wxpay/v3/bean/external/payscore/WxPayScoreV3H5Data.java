package com.github.songxzj.wxpay.v3.bean.external.payscore;

import com.github.songxzj.wxpay.v3.bean.external.payscore.enums.PayScoreBusinessTypeEnum;
import com.github.songxzj.wxpay.v3.bean.external.payscore.extra.AbstractWxPayScoreV3ExtraData;
import lombok.Data;

import java.io.Serializable;

/**
 * H5调起支付分
 */
@Data
public class WxPayScoreV3H5Data implements Serializable {
    private static final long serialVersionUID = -2500309906410237132L;

    /**
     * 跳转类型
     * businessType
     * string[1,16]
     * 是
     */
    private String businessType;

    /**
     * 业务参数
     * queryString
     * string[1,2048]
     * 是
     */
    private String queryString;

    public WxPayScoreV3H5Data(PayScoreBusinessTypeEnum payScoreBusinessTypeEnum, AbstractWxPayScoreV3ExtraData extraData) {
        this.businessType = payScoreBusinessTypeEnum.getTypeName();
        this.queryString = extraData.getQueryString();
    }


}
