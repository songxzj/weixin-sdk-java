package com.github.songxzj.wxpay.v2.bean.request.coupon;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.coupon.WxQueryCouponStockResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 查询代金券批次
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/sp_coupon.php?chapter=12_4&index=5">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxQueryCouponStockRequest extends BaseWxPayRequest<WxQueryCouponStockResult> {
    private static final long serialVersionUID = 8965442424814008269L;

    /**
     * 代金券批次id
     * coupon_stock_id
     * 是
     * 1757
     * String
     * 代金券批次id
     */
    @Required
    @XStreamAlias("coupon_stock_id")
    private String couponStockId;

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
        return "/mmpaymkttransfers/query_coupon_stock";
    }

    @Override
    public Class<WxQueryCouponStockResult> getResultClass() {
        return WxQueryCouponStockResult.class;
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
        map.put("coupon_stock_id", this.couponStockId);
        map.put("op_user_id", this.opUserId);
        map.put("device_info", this.deviceInfo);
        map.put("version", this.version);
        map.put("type", this.type);
    }
}
