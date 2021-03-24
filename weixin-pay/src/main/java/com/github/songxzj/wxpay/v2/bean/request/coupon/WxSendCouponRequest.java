package com.github.songxzj.wxpay.v2.bean.request.coupon;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.coupon.WxSendCouponResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 发放代金券
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/sp_coupon.php?chapter=12_3&index=4">
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxSendCouponRequest extends BaseWxPayRequest<WxSendCouponResult> {
    private static final long serialVersionUID = -1487429845000329627L;

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
     * openid记录数
     * openid_count
     * 是
     * 1
     * int
     * openid记录数（目前支持num=1）
     */
    @Required
    @XStreamAlias("openid_count")
    private Integer openidCount;

    /**
     * 商户单据号
     * partner_trade_no
     * 是
     * 1000009820141203515766
     * String
     * 商户此次发放凭据号（格式：商户id+日期+流水号），商户侧需保持唯一性
     */
    @Required
    @XStreamAlias("partner_trade_no")
    private String partnerTradeNo;

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
        return "/mmpaymkttransfers/send_coupon";
    }

    @Override
    public Class<WxSendCouponResult> getResultClass() {
        return WxSendCouponResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("coupon_stock_id", this.couponStockId);
        map.put("openid_count", this.openidCount.toString());
        map.put("partner_trade_no", this.partnerTradeNo);
        map.put("openid", this.openid);
        map.put("op_user_id", this.opUserId);
        map.put("device_info", this.deviceInfo);
        map.put("version", this.version);
        map.put("type", this.type);
    }
}
