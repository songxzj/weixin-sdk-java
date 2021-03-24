package com.github.songxzj.wxpay.v3.bean.result;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.common.json.WxGsonBuilder;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;


@Setter
@Getter
@ToString
@Slf4j
public abstract class BaseWxPayV3Result implements Serializable {
    private static final long serialVersionUID = 7765784097135990901L;

    private byte[] bytes;

    public void compose() {
    }

    /**
     * 默认不进行敏感加密
     */
    public boolean isSensitiveEncrypt() {
        return false;
    }
    public static <T extends BaseWxPayV3Result> T createStreamInstance(byte[] bytes, Class<T> clz) throws WxErrorException {
        try {
            BaseWxPayV3Result result = clz.newInstance();
            result.setBytes(bytes);
            return (T) result;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.CREATE_STREAM_INSTANCE_ERROR);
        }
    }

    public static <T extends BaseWxPayV3Result> T fromJson(String jsonString, Class<T> clz) throws WxErrorException {
        try {
            BaseWxPayV3Result result = WxGsonBuilder.create().fromJson(jsonString, clz);
            if (result == null) {
                result = clz.newInstance();
            }
            result.compose();
            return (T) result;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.PARSE_JSON_ERROR);
        }
    }
}
