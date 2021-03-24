package com.github.songxzj.wxpay.v3.bean.request;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v3.bean.result.WxCertificatesV3Result;
import lombok.Builder;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
//@AllArgsConstructor
@Accessors(chain = true)
public class WxCertificatesV3Request extends BaseWxPayV3Request<WxCertificatesV3Result> {
    private static final long serialVersionUID = -7864487295430623885L;

    @Override
    public String routing() {
        return "/v3/certificates";
    }

    @Override
    public Class<WxCertificatesV3Result> getResultClass() {
        return WxCertificatesV3Result.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }

    @Override
    public boolean isCheckSign() {
        return false;
    }

}
