package com.github.songxzj.wxpay.v3.bean.external.payscore.extra;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import org.apache.commons.lang3.StringUtils;

/**
 * 授权服务
 */
public class WxPayScoreV3EnableExtraData extends AbstractWxPayScoreV3ExtraData {
    private static final long serialVersionUID = 5449377395976062114L;

    /**
     * 预授权token
     * apply_permissions_token
     * string[1,2048]
     * 是
     */
    private String apply_permissions_token;


    private WxPayScoreV3EnableExtraData(String applyPermissionsToken) {
        this.apply_permissions_token = applyPermissionsToken;
    }

    public static WxPayScoreV3EnableExtraDataBuilder newBuilder() {
        return new WxPayScoreV3EnableExtraDataBuilder();
    }

    public static class WxPayScoreV3EnableExtraDataBuilder {

        String applyPermissionsToken;

        public WxPayScoreV3EnableExtraDataBuilder applyPermissionsToken(String applyPermissionsToken) {
            this.applyPermissionsToken = applyPermissionsToken;
            return this;
        }

        public WxPayScoreV3EnableExtraData build() throws WxErrorException {
            if (StringUtils.isBlank(this.applyPermissionsToken)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "applyPermissionsToken 必须提供值");
            }
            return new WxPayScoreV3EnableExtraData(this.applyPermissionsToken);
        }
    }


    @Override
    public String getQueryString() {
        StringBuffer queryString = new StringBuffer("apply_permissions_token=").append(urlEncode(this.apply_permissions_token));
        return queryString.toString();
    }


}
