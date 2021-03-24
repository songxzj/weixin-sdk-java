package com.github.songxzj.wxpay.v2.bean.result.redpack;

import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxGetHbInfoResult extends BaseWxPayResult {
    private static final long serialVersionUID = 7082760395620617077L;

    /**
     * 商户订单号
     * mch_billno
     * 是
     * 10000098201411111234567890
     * String(28)
     * 商户订单号（每个订单号必须唯一）
     * 组成：mch_id+yyyymmdd+10位一天内不能重复的数字
     */
    @XStreamAlias("mch_billno")
    private String mchBillno;

    /**
     * 红包单号
     * detail_id
     * 是
     * 1000000000201503283103439304
     * String(32)
     * 使用API发放现金红包时返回的红包单号
     */
    @XStreamAlias("detail_id")
    private String detailId;

    /**
     * 红包状态
     * status
     * 是
     * RECEIVED
     * string(16)
     * SENDING:发放中
     * SENT:已发放待领取
     * FAILED：发放失败
     * RECEIVED:已领取
     * RFUND_ING:退款中
     * REFUND:已退款
     */
    @XStreamAlias("status")
    private String status;

    /**
     * 发放类型
     * send_type
     * 是
     * API
     * String(32)
     * API:通过API接口发放
     * UPLOAD:通过上传文件方式发放
     * ACTIVITY:通过活动方式发放
     */
    @XStreamAlias("send_type")
    private String sendType;

    /**
     * 红包类型
     * hb_type
     * 是
     * GROUP
     * String(32)
     * GROUP:裂变红包
     * NORMAL:普通红包
     */
    @XStreamAlias("hb_type")
    private String hbType;

    /**
     * 红包个数
     * total_num
     * 是
     * 1
     * int
     * 红包个数
     */
    @XStreamAlias("total_num")
    private Integer totalNum;

    /**
     * 红包金额
     * total_amount
     * 是
     * 5000
     * int
     * 红包总金额（单位分）
     */
    @XStreamAlias("total_amount")
    private Integer totalAmount;

    /**
     * 失败原因
     * reason
     * 否
     * 余额不足
     * String(32)
     * 发送失败原因
     */
    @XStreamAlias("reason")
    private String reason;

    /**
     * 红包发送时间
     * send_time
     * 是
     * 2015-04-21 20:00:00
     * String(32)
     */
    @XStreamAlias("send_time")
    private String sendTime;

    /**
     * 红包退款时间
     * refund_time
     * 否
     * 2015-04-21 23:03:00
     * String(32)
     * 红包的退款时间（如果其未领取的退款）
     */
    @XStreamAlias("refund_time")
    private String refundTime;

    /**
     * 红包退款金额
     * refund_amount
     * 否
     * 8000
     * Int
     * 红包退款金额
     */
    @XStreamAlias("refund_amount")
    private Integer refundAmount;

    /**
     * 祝福语
     * wishing
     * 否
     * 新年快乐
     * String(128)
     * 祝福语
     */
    @XStreamAlias("wishing")
    private String wishing;

    /**
     * 活动描述
     * remark
     * 否
     * 新年红包
     * String(256)
     * 活动描述，低版本微信可见
     */
    @XStreamAlias("remark")
    private String remark;

    /**
     * 活动名称
     * act_name
     * 否
     * 新年红包
     * String(32)
     * 发红包的活动名称
     */
    @XStreamAlias("act_name")
    private String actName;

    /**
     * 裂变红包领取列表
     * hblist
     * 否
     * 内容如下表
     * 裂变红包的领取列表
     */
    @XStreamAlias("hblist")
    private List<HbInfo> hblist;

    @Override
    protected void loadXml(Document d) {
        this.mchBillno = readXmlString(d, "mch_billno");
        this.detailId = readXmlString(d, "detail_id");
        this.status = readXmlString(d, "status");
        this.sendType = readXmlString(d, "send_type");
        this.hbType = readXmlString(d, "hb_type");
        this.totalNum = readXmlInteger(d, "total_num");
        this.totalAmount = readXmlInteger(d, "total_amount");
        this.reason = readXmlString(d, "reason");
        this.sendTime = readXmlString(d, "send_time");
        this.refundTime = readXmlString(d, "refund_time");
        this.refundAmount = readXmlInteger(d, "refund_amount");
        this.wishing = readXmlString(d, "wishing");
        this.remark = readXmlString(d, "remark");
        this.actName = readXmlString(d, "act_name");

        NodeList nodeList = d.getElementsByTagName("hbinfo");
        this.hblist = Lists.newArrayList();

        for (int i = 0, j = nodeList.getLength(); i < j; i++) {
            Node node = nodeList.item(i);
            HbInfo hbInfo = new HbInfo();
            hbInfo.openid = readXmlString(node, "openid");
            hbInfo.amount = readXmlInteger(node, "amount");
            hbInfo.receiveTime = readXmlString(node, "rcv_time");
            this.hblist.add(hbInfo);
        }
    }

    /**
     * 裂变红包领取列表
     */
    @Setter
@Getter
@ToString
    @XStreamAlias("hbinfo")
    public static class HbInfo implements Serializable {
        private static final long serialVersionUID = 8656751471237489643L;

        /**
         * 领取红包的Openid
         * openid
         * 是
         * ohO4GtzOAAYMp2yapORH3dQB3W18
         * String(32)
         * 领取红包的openid
         */
        @XStreamAlias("openid")
        private String openid;

        /**
         * 金额
         * amount
         * 是
         * 100
         * int
         * 领取金额
         */
        @XStreamAlias("amount")
        private Integer amount;

        /**
         * 接收时间
         * rcv_time
         * 是
         * 2015-04-21 20:00:00
         * String(32)
         * 领取红包的时间
         */
        @XStreamAlias("rcv_time")
        private String receiveTime;
    }
}
