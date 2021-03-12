/*package com.github.songxzj.wxpay.v2.bean.request.micro;

import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.micro.WxRiskGetCertficatesResult;
import com.github.songxzj.common.exception.WxErrorException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

*/
/**
 * 获取平台证书
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/xiaowei.php?chapter=19_11">
 *//*


@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
//@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxRiskGetCertficatesRequest extends BaseWxPayRequest<WxRiskGetCertficatesResult> {
    private static final long serialVersionUID = 3463110222695795855L;

    @Override
    public String routing() {
        return "/risk/getcertficates";
    }

    @Override
    public Class<WxRiskGetCertficatesResult> getResultClass() {
        return WxRiskGetCertficatesResult.class;
    }

    @Override
    public boolean isUseKey() {
        return false;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
    }

    @Override
    protected void storeMap(Map<String, String> map) {
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
