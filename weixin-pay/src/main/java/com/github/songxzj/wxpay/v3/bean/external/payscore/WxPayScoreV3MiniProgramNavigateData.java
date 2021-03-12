package com.github.songxzj.wxpay.v3.bean.external.payscore;

import com.github.songxzj.wxpay.v3.bean.external.payscore.enums.PayScoreBusinessTypeEnum;
import com.github.songxzj.wxpay.v3.bean.external.payscore.extra.AbstractWxPayScoreV3ExtraData;
import lombok.Data;

import java.io.Serializable;

/**
 * 小程序调起支付分(navigateToMiniProgram)
 */
@Data
public class WxPayScoreV3MiniProgramNavigateData implements Serializable {
    private static final long serialVersionUID = -895136642245464228L;

    /**
     * 应用ID
     * appId
     * string[1,32]
     * 是
     */
    private String appId;

    /**
     * 路径
     * path
     * string[1,64]
     * 是
     */
    private String path;

    /**
     * 业务参数
     * extraData
     * Object
     * 是
     */
    private AbstractWxPayScoreV3ExtraData extraData;

    public WxPayScoreV3MiniProgramNavigateData(String appId, PayScoreBusinessTypeEnum payScoreBusinessTypeEnum, AbstractWxPayScoreV3ExtraData extraData) {
        this.appId = appId;
        this.path = payScoreBusinessTypeEnum.getNavigateToMiniProgramPath();
        this.extraData = extraData;
    }


}
