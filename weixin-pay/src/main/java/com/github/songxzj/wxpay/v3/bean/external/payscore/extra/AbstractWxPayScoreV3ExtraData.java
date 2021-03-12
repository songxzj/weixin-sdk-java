package com.github.songxzj.wxpay.v3.bean.external.payscore.extra;

import com.github.songxzj.wxpay.constant.WxPayConstants;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class AbstractWxPayScoreV3ExtraData implements Serializable {
    private static final long serialVersionUID = -5688689453607464095L;

    public abstract String getQueryString();

    protected String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, WxPayConstants.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
