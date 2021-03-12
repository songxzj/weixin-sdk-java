package com.github.songxzj.wxpay.constant;

import com.google.common.collect.Lists;
import org.springframework.http.MediaType;

import java.util.List;

/**
 * 微信支付常量类
 */
public class WxPayConstants {

    public static final String DEFAULT_PAY_BASE_URL = "https://api.mch.weixin.qq.com";

    public static final String APPLICATION_FORM_URLENCODED_UTF8_VALUE = MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=" + WxPayConstants.DEFAULT_CHARSET;

    public static final String MULTIPART_FORM_DATA_UTF8_VALUE = MediaType.MULTIPART_FORM_DATA_VALUE + ";charset=" + WxPayConstants.DEFAULT_CHARSET;

    /**
     * 默认编码
     */
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 交易类型.
     */
    public static class TradeType {
        /**
         * 原生扫码支付.
         */
        public static final String NATIVE = "NATIVE";

        /**
         * App支付.
         */
        public static final String APP = "APP";

        /**
         * 公众号支付/小程序支付.
         */
        public static final String JSAPI = "JSAPI";

        /**
         * H5支付.
         */
        public static final String MWEB = "MWEB";

        /**
         * 刷卡支付.
         * 刷卡支付有单独的支付接口，不调用统一下单接口
         */
        public static final String MICROPAY = "MICROPAY";
    }


    /**
     * 签名类型.
     */
    public static class SignType {
        /**
         * The constant HMAC_SHA256.
         */
        public static final String HMAC_SHA256 = "HMAC-SHA256";
        /**
         * The constant MD5.
         */
        public static final String MD5 = "MD5";
        /**
         * The constant ALL_SIGN_TYPES.
         */
        public static final List<String> ALL_SIGN_TYPES = Lists.newArrayList(HMAC_SHA256, MD5);
    }

    /**
     * 业务结果代码.
     */
    public static class ResultCode {
        /**
         * 成功.
         */
        public static final String SUCCESS = "SUCCESS";

        /**
         * 失败.
         */
        public static final String FAIL = "FAIL";
    }

    /**
     * 错误代码
     */
    public static class ErrCode {
        /**
         * 接口返回错误.
         */
        public static final String SYSTEMERROR = "SYSTEMERROR";

        /**
         * 银行系统异常
         */
        public static final String BANKERROR = "BANKERROR";


        /**
         * 用户支付中，需要输入密码
         */
        public static final String USERPAYING = "USERPAYING";

        /**
         * 退款业务流程错误，需要商户触发重试来解决.
         */
        public static final String BIZERR_NEED_RETRY = "BIZERR_NEED_RETRY";


        /**
         * 订单已关闭
         */
        public static final String ORDERCLOSED = "ORDERCLOSED";

        /**
         * 参数错误
         */
        public static final String PARAM_ERROR = "PARAM_ERROR";
    }

}
