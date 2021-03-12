package com.github.songxzj.wxpay.v2.bean.request.coupon;


import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.coupon.WxQueryCouponsInfoResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 查询代金券信息
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/sp_coupon.php?chapter=12_5&index=6">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxQueryCouponsInfoRequest extends BaseWxPayRequest<WxQueryCouponsInfoResult> {
    private static final long serialVersionUID = -1275961578298912781L;

    /**
     * 代金券id
     * coupon_id
     * 是
     * 1565
     * String
     * 代金券id
     */
    @Required
    @XStreamAlias("coupon_id")
    private String couponId;

    /**
     * 用户openid
     * openid
     * 是
     * onqOjjrXT-776SpHnfexGm1_P7iE
     * String
     * Openid信息，用户在appid下的唯一标识
     */
    @Required
    @XStreamAlias("openid")
    private String openid;

    /**
     * 批次号
     * stock_id
     * 是
     * 58818
     * String(32)
     * 代金劵对应的批次号
     */
    @Required
    @XStreamAlias("stock_id")
    private String stockId;

    /**
     * 操作员
     * op_user_id
     * 否
     * 10000098
     * String(32)
     * 操作员帐号, 默认为商户号
     * 可在商户平台配置操作员对应的api权限
     */
    @XStreamAlias("op_user_id")
    private String opUserId;

    /**
     * 设备号
     * device_info
     * 否
     * String(32)
     * 微信支付分配的终端设备号
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 协议版本
     * version
     * 否
     * 1.0
     * String(32)
     * 默认1.0
     */
    @XStreamAlias("version")
    private String version;

    /**
     * 协议类型
     * type
     * 否
     * XML
     * String(32)
     * XML【目前仅支持默认XML】
     */
    @XStreamAlias("type")
    private String type;

    @Override
    public String routing() {
        return "/mmpaymkttransfers/querycouponsinfo";
    }

    @Override
    public Class<WxQueryCouponsInfoResult> getResultClass() {
        return WxQueryCouponsInfoResult.class;
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
        map.put("coupon_id", this.couponId);
        map.put("openid", this.openid);
        map.put("stock_id", this.stockId);
        map.put("op_user_id", this.opUserId);
        map.put("device_info", this.deviceInfo);
        map.put("version", this.version);
        map.put("type", this.type);
    }
}
