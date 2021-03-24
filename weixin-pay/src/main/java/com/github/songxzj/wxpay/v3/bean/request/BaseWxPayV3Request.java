package com.github.songxzj.wxpay.v3.bean.request;


import com.github.songxzj.common.annotation.GsonExclude;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.json.WxGsonBuilder;
import com.github.songxzj.common.util.WxBeanUtils;
import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public abstract class BaseWxPayV3Request<T extends BaseWxPayV3Result> implements Serializable {
    private static final long serialVersionUID = -501560305156478941L;


    /**
     * 业务请求幂等值
     * Idempotency-Key
     * string[1,48）
     */
    @GsonExclude
    @SerializedName("Idempotency-Key")
    protected String idempotencyKey;
    /**
     * 具体路由
     */
    public abstract String routing();

    /**
     * 得到当前API的响应结果类型
     *
     * @return 响应类型
     */
    public abstract Class<T> getResultClass();

    /**
     * 请求方式
     */
    public abstract HttpMethod getHttpMethod();

    /**
     * To Json string.
     *
     * @return the string
     */
    public String toJsonString() {
        if (isCreateJson()) {
            return WxGsonBuilder.create().toJson(this);
        }
        return null;
    }

    public String toSignString() {
        if (isCreateJson()) {
            return WxGsonBuilder.create().toJson(this);
        }
        return "";
    }

    private boolean isCreateJson() {
        HttpMethod httpMethod = getHttpMethod();
        return HttpMethod.POST.equals(httpMethod) || HttpMethod.PUT.equals(httpMethod) || HttpMethod.PATCH.equals(httpMethod);
    }


    /**
     * 检查请求参数内容，包括必填参数以及特殊约束.
     */
    public void checkFields() throws WxErrorException {
        //check required fields
        WxBeanUtils.checkRequiredV3Fields(this);
        //check other parameters
        checkConstraints();
    }

    /**
     * 检查约束情况.
     *
     * @throws WxErrorException the wx pay exception
     */
    protected abstract void checkConstraints() throws WxErrorException;

    /**
     * 默认检查签名
     */
    public boolean isCheckSign() {
        return true;
    }

    /**
     * 默认不进行敏感加密
     */
    public boolean isSensitiveEncrypt() {
        return false;
    }


}
