package com.github.songxzj.wxpay.v2.bean.request.redpack;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.redpack.WxSendMiniProgramHbResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 小程序发放红包
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=18_2&index=3">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon_sl.php?chapter=18_2&index=3">
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
@Accessors(chain = true)
public class WxSendMiniProgramHbRequest extends BaseWxPayRequest<WxSendMiniProgramHbResult> {
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
     * 通知用户形式
     * notify_way
     * 是
     * MINI_PROGRAM_JSAPI
     * String(256)
     * 通过JSAPI方式领取红包,小程序红包固定传MINI_PROGRAM_JSAPI
     */
    @Required
    @XStreamAlias("notify_way")
    private String notifyWay;

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

    @Override
    public String[] getIgnoredParamsForSign() {
        return new String[]{"appid", "sub_appid", "sign_type"};
    }

    @Override
    public String routing() {
        return "/mmpaymkttransfers/sendminiprogramhb";
    }

    @Override
    public Class<WxSendMiniProgramHbResult> getResultClass() {
        return WxSendMiniProgramHbResult.class;
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
        map.put("mch_billno", this.mchBillNo);
        map.put("wxAppid", this.wxAppid);
        map.put("send_name", this.sendName);
        map.put("re_openid", this.reOpenid);
        map.put("total_amount", this.totalAmount.toString());
        map.put("total_num", this.totalNum.toString());
        map.put("wishing", this.wishing);
        map.put("act_name", this.actName);
        map.put("remark", this.remark);
        map.put("scene_id", this.sceneId);
        map.put("notify_way", this.notifyWay);
    }
}
