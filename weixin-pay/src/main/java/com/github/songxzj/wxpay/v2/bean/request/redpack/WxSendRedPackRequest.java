package com.github.songxzj.wxpay.v2.bean.request.redpack;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.redpack.WxSendRedPackResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 发放红包
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=13_4&index=3">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon_sl.php?chapter=13_4&index=3">
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
public class WxSendRedPackRequest extends BaseWxPayRequest<WxSendRedPackResult> {
    private static final long serialVersionUID = 8372498897686649167L;

    /**
     * 商户订单号
     * mch_billno
     * 是
     * 10000098201411111234567890
     * String(28)
     * 商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z）
     * 接口根据商户订单号支持重入，如出现超时可再调用。
     */
    @Required
    @XStreamAlias("mch_billno")
    private String mchBillNo;

    /**
     * 公众账号appid
     * wxappid
     * 是
     * wx8888888888888888
     * String(32)
     * 微信分配的公众账号ID（企业号corpid即为此appId）。在微信开放平台（open.weixin.qq.com）申请的移动应用appid无法使用该接口。
     */
    @Required
    @XStreamAlias("wxappid")
    private String wxAppid;

    /**
     * 商户名称
     * send_name
     * 是
     * 天虹百货
     * String(32)
     * 红包发送者名称
     * 注意：敏感词会被转义成字符*
     */
    @Required
    @XStreamAlias("send_name")
    private String sendName;

    /**
     * 用户openid
     * re_openid
     * 是
     * oxTWIuGaIt6gTKsQRLau2M0yL16E
     * String(32)
     * 接受红包的用户openid
     * openid为用户在wxappid下的唯一标识（获取openid参见微信公众平台开发者文档：网页授权获取用户基本信息）
     */
    @Required
    @XStreamAlias("re_openid")
    private String reOpenid;

    /**
     * 付款金额
     * total_amount
     * 是
     * 1000
     * int
     * 付款金额，单位分
     */
    @Required
    @XStreamAlias("total_amount")
    private Integer totalAmount;

    /**
     * 红包发放总人数
     * total_num
     * 是
     * 1
     * int
     * 红包发放总人数total_num=1
     */
    @Required
    @XStreamAlias("total_num")
    private Integer totalNum;

    /**
     * 红包祝福语
     * wishing
     * 是
     * 感谢您参加猜灯谜活动，祝您元宵节快乐！	String(128)
     * 红包祝福语
     * 注意：敏感词会被转义成字符*
     */
    @Required
    @XStreamAlias("wishing")
    private String wishing;

    /**
     * Ip地址
     * client_ip
     * 是
     * 192.168.0.1
     * String(15)
     * 调用接口的机器Ip地址
     */
    @Required
    @XStreamAlias("client_ip")
    private String clientIp;

    /**
     * 活动名称
     * act_name
     * 是
     * 猜灯谜抢红包活动
     * String(32)
     * 活动名称
     * 注意：敏感词会被转义成字符*
     */
    @Required
    @XStreamAlias("act_name")
    private String actName;

    /**
     * 备注
     * remark
     * 是
     * 猜越多得越多，快来抢！
     * String(256)
     * 备注信息
     */
    @Required
    @XStreamAlias("remark")
    private String remark;


    /**
     * 场景id
     * scene_id
     * 否
     * PRODUCT_8
     * String(32)
     * 发放红包使用场景，红包金额大于200或者小于1元时必传
     * PRODUCT_1:商品促销
     * PRODUCT_2:抽奖
     * PRODUCT_3:虚拟物品兑奖
     * PRODUCT_4:企业内部福利
     * PRODUCT_5:渠道分润
     * PRODUCT_6:保险回馈
     * PRODUCT_7:彩票派奖
     * PRODUCT_8:税务刮奖
     */
    @XStreamAlias("scene_id")
    private String sceneId;

    /**
     * 活动信息
     * risk_info
     * 否
     * posttime%3d123123412%26clientversion%3d234134%26mobile%3d122344545%26deviceid%3dIOS
     * String(128)
     * posttime:用户操作的时间戳
     * mobile:业务系统账号的手机号，国家代码-手机号。不需要+号
     * deviceid :mac 地址或者设备唯一标识
     * clientversion :用户操作的客户端版本
     * 把值为非空的信息用key=value进行拼接，再进行urlencode
     * urlencode(posttime=xx&mobile=xx&deviceid=xx)
     */
    @XStreamAlias("risk_info")
    private String riskInfo;

    /**
     * 触达用户appid
     * msgappid
     * 是
     * wx28b16568a629bb33
     * String(32)
     * 服务商模式下触达用户时的appid(可填服务商自己的appid或子商户的appid)，服务商模式下必填，服务商模式下填入的子商户appid必须在微信支付商户平台中先录入，否则会校验不过。
     */
    @XStreamAlias("msgappid")
    private String msgappid;

    /**
     * <pre>
     * consume_mch_id.
     * 资金授权商户号
     * 资金授权商户号
     * 服务商替特约商户发放时使用
     * 非必填字段
     * </pre>
     *//*
    @XStreamAlias("consume_mch_id")
    private String consumeMchId;
    */
    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"appid", "sub_appid", "sign_type"};
    }

    @Override
    public String routing() {
        return "/mmpaymkttransfers/sendredpack";
    }

    @Override
    public Class<WxSendRedPackResult> getResultClass() {
        return WxSendRedPackResult.class;
    }

    @Override
    public boolean isUseKey() {
        return true;
    }

    @Override
    protected void checkConstraints() throws WxErrorException {
        if ((this.totalAmount > 2000 || this.totalAmount < 100) && StringUtils.isBlank(this.sceneId)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "红包金额大于200或者小于1元时 sceneId 必传");
        }
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("mch_billno", this.mchBillNo);
        map.put("wxAppid", this.wxAppid);
        map.put("send_name", this.sendName);
        map.put("re_openid", this.reOpenid);
        map.put("total_amount", this.totalAmount.toString());
        map.put("total_num", this.totalNum.toString());
        map.put("wishing", this.wishing);
        map.put("client_ip", this.clientIp);
        map.put("act_name", this.actName);
        map.put("remark", this.remark);
        map.put("scene_id", this.sceneId);
        map.put("risk_info", this.riskInfo);
        map.put("msgappid", this.msgappid);
    }
}
