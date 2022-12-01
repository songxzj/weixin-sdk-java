package com.github.songxzj.common.exception;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class WxErrorExceptionFactor implements Serializable {
    private static final long serialVersionUID = -1839532807293322813L;

    private String errorCode;
    private String errorMessage;

    public WxErrorExceptionFactor(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }



    public static final String INVALID_PARAMETER_CODE = "80001";

    public static final String KEY_FILE_NOT_EXIST_CODE = "80002";
    public static final WxErrorExceptionFactor KEY_FILE_NOT_EXIST = new WxErrorExceptionFactor(KEY_FILE_NOT_EXIST_CODE, "证书文件不存在");

    public static final String KEY_FILE_ERROR_CODE = "80003";
    public static final WxErrorExceptionFactor KEY_FILE_ERROR = new WxErrorExceptionFactor(KEY_FILE_ERROR_CODE, "证书文件有问题");

    public static final String ILLEGAL_SIGN_TYPE_CODE = "80004";
    public static final WxErrorExceptionFactor ILLEGAL_SIGN_TYPE =
            new WxErrorExceptionFactor(ILLEGAL_SIGN_TYPE_CODE, "非法的签名类型");

    public static final String CHECK_SIGN_ERROR_CODE = "80005";
    public static final WxErrorExceptionFactor CHECK_SIGN_ERROR =
            new WxErrorExceptionFactor(CHECK_SIGN_ERROR_CODE, "参数格式签名校验错误");

    public static final String RESULT_FAIL_CODE = "80006";
    public static final WxErrorExceptionFactor RESULT_FAIL =
            new WxErrorExceptionFactor(RESULT_FAIL_CODE, "微信结果处理失败");

    public static final String HTTP_REQUEST_FAIL_CODE = "80007";
    public static final WxErrorExceptionFactor HTTP_REQUEST_FAIL =
            new WxErrorExceptionFactor(HTTP_REQUEST_FAIL_CODE, "http 请求微信失败");

    public static final String HTTP_TRUST_ERROR_CODE = "80008";
    public static final WxErrorExceptionFactor HTTP_TRUST_ERROR =
            new WxErrorExceptionFactor(HTTP_TRUST_ERROR_CODE, "http 信任证书错误");

    public static final String IMAGE_ERROR_CODE = "80009";
    public static final WxErrorExceptionFactor IMAGE_ERROR =
            new WxErrorExceptionFactor(IMAGE_ERROR_CODE, "所需图片处理错误");

    public static final String DECRYPT_ERROR_CODE = "80010";
    public static final WxErrorExceptionFactor DECRYPT_ERROR =
            new WxErrorExceptionFactor(DECRYPT_ERROR_CODE, "解密错误");

    public static final String SENSITIVE_ENCRYPT_ERROR_CODE = "80011";
    public static final WxErrorExceptionFactor SENSITIVE_ENCRYPT_ERROR =
            new WxErrorExceptionFactor(SENSITIVE_ENCRYPT_ERROR_CODE, "敏感信息加密错误");

    public static final String SIGN_ERROR_CODE = "80012";
    public static final WxErrorExceptionFactor SIGN_ERROR_ERROR =
            new WxErrorExceptionFactor(SIGN_ERROR_CODE, "签名错误");

    public static final String KEY_ERROR_CODE = "80013";
    public static final WxErrorExceptionFactor KEY_ERROR_ERROR =
            new WxErrorExceptionFactor(KEY_ERROR_CODE, "密钥转换错误");

    public static final String FILE_ERROR_CODE = "80014";
    public static final WxErrorExceptionFactor FILE_ERROR =
            new WxErrorExceptionFactor(FILE_ERROR_CODE, "所需文件处理错误");

    public static final String PARSE_JSON_ERROR_CODE = "80015";
    public static final WxErrorExceptionFactor PARSE_JSON_ERROR =
            new WxErrorExceptionFactor(PARSE_JSON_ERROR_CODE, "解析JSON错误");

    public static final String NOTIFY_CONTENT_ERROR_CODE = "80016";
    public static final WxErrorExceptionFactor NOTIFY_CONTENT_ERROR =
            new WxErrorExceptionFactor(NOTIFY_CONTENT_ERROR_CODE, "回调通知数据错误");

    public static final String CREATE_STREAM_INSTANCE_ERROR_CODE = "80017";
    public static final WxErrorExceptionFactor CREATE_STREAM_INSTANCE_ERROR =
            new WxErrorExceptionFactor(CREATE_STREAM_INSTANCE_ERROR_CODE, "创建对象错误");


    public static final String ENCRYPT_ERROR_CODE = "80018";
    public static final WxErrorExceptionFactor ENCRYPT_ERROR =
            new WxErrorExceptionFactor(ENCRYPT_ERROR_CODE, "加密错误");


}
