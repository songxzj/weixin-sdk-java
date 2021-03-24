/*
package com.github.songxzj.wxpay.v2.bean.request.micro;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.micro.WxMicroGetStateResult;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

*/
/**
 * 小微商户查询申请状态
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=19_3">
 *//*


@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxMicroGetStateRequest extends BaseWxPayRequest<WxMicroGetStateResult> {
    private static final long serialVersionUID = 5493243051548605837L;


    */
/**
     * 接口版本号
     * version
     * 是
     * String(32)
     * 1.0
     * 默认值1.0
     *//*

    @Builder.Default
    @Required
    @XStreamAlias("version")
    private String version = "1.0";

    */
/**
     * 商户申请单号
     * applyment_id
     * 否
     * String(32)
     * 1230000109
     * 微信支付分配的申请单号。applyment_id、business_code两者不能同时为空。
     *//*

    @XStreamAlias("applyment_id")
    private String applymentId;

    */
/**
     * 业务申请编号
     * business_code
     * 否
     * String(32)
     * 123456
     * 服务商自定义的商户唯一编号。当applyment_id已填写时，此字段无效。
     *//*

    @XStreamAlias("business_code")
    private String businessCode;


    @Override
    public String routing() {
        return "/applyment/micro/getstate";
    }

    @Override
    public Class<WxMicroGetStateResult> getResultClass() {
        return WxMicroGetStateResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if ((StringUtils.isBlank(this.applymentId) && StringUtils.isBlank(this.businessCode))) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "applyment_id、business_code 两者不能同时为空");
        }

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("version", this.version);
        map.put("applyment_id", this.applymentId);
        map.put("business_code", this.businessCode);
    }

    @Override
    public boolean isIgnoreAppid() {
        return true;
    }

    @Override
    public boolean isIgnoreSubAppId() {
        return true;
    }

    @Override
    public boolean isIgnoreSubMchId() {
        return true;
    }
}
*/
