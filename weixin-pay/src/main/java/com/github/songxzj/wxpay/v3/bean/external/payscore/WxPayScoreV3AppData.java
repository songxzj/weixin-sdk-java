package com.github.songxzj.wxpay.v3.bean.external.payscore;

import com.github.songxzj.wxpay.v3.bean.external.payscore.enums.PayScoreBusinessTypeEnum;
import com.github.songxzj.wxpay.v3.bean.external.payscore.extra.AbstractWxPayScoreV3ExtraData;
import lombok.Data;

import java.io.Serializable;

/**
 * APP调起支付分
 */
@Data
public class WxPayScoreV3AppData implements Serializable {
    private static final long serialVersionUID = 5926611829747178474L;

    /**
     * 跳转类型
     * businessType
     * string[1,16]
     * 是
     */
    private String businessType;

    /**
     * 业务参数
     * query
     * string[1,2048]
     * 是
     */
    private String query;

    /**
     * 其他配置
     * extInfo
     * string[1,128]
     * 否
     */
    private String extInfo;

    public WxPayScoreV3AppData(PayScoreBusinessTypeEnum payScoreBusinessTypeEnum, AbstractWxPayScoreV3ExtraData extraData, String extInfo) {
        this.businessType = payScoreBusinessTypeEnum.getTypeName();
        this.query = extraData.getQueryString();
        this.extInfo = extInfo;
    }

}
