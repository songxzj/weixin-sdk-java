package com.github.songxzj.wxpay.v3.bean.external.payscore;

import cn.hutool.core.util.ObjectUtil;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v3.bean.external.payscore.enums.PayScoreBusinessTypeEnum;
import com.github.songxzj.wxpay.v3.bean.external.payscore.extra.AbstractWxPayScoreV3ExtraData;
import com.github.songxzj.wxpay.v3.bean.external.payscore.extra.WxPayScoreV3DetailExtraExtraData;
import com.github.songxzj.wxpay.v3.bean.external.payscore.extra.WxPayScoreV3EnableExtraData;
import com.github.songxzj.wxpay.v3.bean.external.payscore.extra.WxPayScoreV3UseExtraData;

public class WxPayScoreV3ExtraDataFactory {

    private PayScoreBusinessTypeEnum payScoreBusinessTypeEnum;

    private String mchId;

    private String serviceId;

    private String outOrderNo;

    private String applyPermissionsToken;

    private String packageValue;


    private WxPayScoreV3ExtraDataFactory() {

    }

    public static WxPayScoreV3ExtraDataFactory newInstance() {
        return new WxPayScoreV3ExtraDataFactory();
    }

    public WxPayScoreV3ExtraDataFactory payScoreBusinessTypeEnum(PayScoreBusinessTypeEnum payScoreBusinessTypeEnum) {
        this.payScoreBusinessTypeEnum = payScoreBusinessTypeEnum;
        return this;
    }


    public WxPayScoreV3ExtraDataFactory mchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public WxPayScoreV3ExtraDataFactory serviceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public WxPayScoreV3ExtraDataFactory outOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
        return this;
    }

    public WxPayScoreV3ExtraDataFactory applyPermissionsToken(String applyPermissionsToken) {
        this.applyPermissionsToken = applyPermissionsToken;
        return this;
    }

    public WxPayScoreV3ExtraDataFactory packageValue(String packageValue) {
        this.packageValue = packageValue;
        return this;
    }

    public AbstractWxPayScoreV3ExtraData buildWithMchKey(String mchKey) throws WxErrorException {
        if (ObjectUtil.isNull(this.payScoreBusinessTypeEnum)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "payScoreBusinessTypeEnum 必须提供值");
        }

        if (PayScoreBusinessTypeEnum.DETAIL.equals(this.payScoreBusinessTypeEnum)) {
            return WxPayScoreV3DetailExtraExtraData.newBuilder()
                    .mchId(this.mchId)
                    .serviceId(this.serviceId)
                    .outOrderNo(this.outOrderNo)
                    .buildWithMchKey(mchKey);
        }
        if (PayScoreBusinessTypeEnum.ENABLE.equals(this.payScoreBusinessTypeEnum)) {
            return WxPayScoreV3EnableExtraData.newBuilder()
                    .applyPermissionsToken(this.applyPermissionsToken)
                    .build();
        }
        if (PayScoreBusinessTypeEnum.USE.equals(this.payScoreBusinessTypeEnum)) {
            return WxPayScoreV3UseExtraData.newBuilder()
                    .mchId(this.mchId)
                    .packageValue(this.packageValue)
                    .buildWithMchKey(mchKey);
        }

        throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "不支持的 payScoreBusinessTypeEnum 类型");
    }
}
