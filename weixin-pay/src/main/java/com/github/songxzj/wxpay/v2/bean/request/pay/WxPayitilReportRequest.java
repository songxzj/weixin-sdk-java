package com.github.songxzj.wxpay.v2.bean.request.pay;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.pay.WxPayitilReportResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 交易保障
 * 普通商户
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_14&index=8">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_8&index=9">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_8&index=9">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_8&index=10">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_8&index=9">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_8&index=9">
 * 服务商
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_14&index=7">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_8">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_8">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/app/app_sl.php?chapter=9_8&index=9">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/H5_sl.php?chapter=9_8&index=8">
 * <a href="https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_sl_api.php?chapter=9_8">
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
public class WxPayitilReportRequest extends BaseWxPayRequest<WxPayitilReportResult> {
    private static final long serialVersionUID = 3343084381069173193L;

    /**
     * 设备号
     * device_info
     * 否
     * String(32)
     * 013467007045764
     * 微信支付分配的终端设备号，商户自定义
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * 接口URL
     * interface_url
     * 是
     * String(127)
     * https://api.mch.weixin.qq.com/pay/batchreport/micropay/total
     * 刷卡支付终端上报统一填：https://api.mch.weixin.qq.com/pay/batchreport/micropay/total
     */
    @Required
    @XStreamAlias("interface_url")
    private String interfaceUrl;

    /**
     * 接口耗时
     * execute_time_
     * 是
     * Int
     * 1000
     * 接口耗时情况，单位为毫秒
     */
    @XStreamAlias("execute_time_")
    private String executeTime;

    /**
     * 返回状态码
     * return_code
     * 是
     * String(16)
     * SUCCESS
     * SUCCESS/FAIL
     * 此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
     */
    @XStreamAlias("return_code")
    private String returnCode;

    /**
     * 返回信息
     * return_msg
     * 是
     * String(128)
     * OK
     * 当return_code为FAIL时返回信息为错误原因 ，例如
     * 签名失败
     * 参数格式校验错误
     */
    @XStreamAlias("return_msg")
    private String returnMsg;

    /**
     * 业务结果
     * result_code
     * 是
     * String(16)
     * SUCCESS
     * SUCCESS/FAIL
     */
    @XStreamAlias("result_code")
    private String resultCode;

    /**
     * 错误代码
     * err_code
     * 否
     * String(32)
     * SYSTEMERROR
     * ORDERNOTEXIST—订单不存在
     * SYSTEMERROR—系统错误
     */
    @XStreamAlias("err_code")
    private String errCode;

    /**
     * 错误代码描述
     * err_code_des
     * 否
     * String(128)
     * 系统错误
     * 结果信息描述
     */
    @XStreamAlias("err_code_des")
    private String errCodeDes;

    /**
     * 商户订单号
     * out_trade_no
     * 否
     * String(32)
     * 1217752501201407033233368018
     * 商户系统内部的订单号,商户可以在上报时提供相关商户订单号方便微信支付更好的提高服务质量。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 访问接口IP
     * user_ip
     * 是
     * String(16)
     * 8.8.8.8
     * 发起接口调用时的机器IP
     */
    @Required
    @XStreamAlias("user_ip")
    private String userIp;

    /**
     * 商户上报时间
     * time
     * 否
     * String(14)
     * 20091227091010
     * 系统时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
     */
    @XStreamAlias("time")
    private String time;

    /**
     * 上报数据包
     * trades
     * 是
     * String(1024)
     * !CDATA[
     * [
     * {
     * "out_trade_no": "out_trade_no_test_1",
     * "begin_time": "20160602203256",
     * "end_time": "20160602203257",
     * "state": "OK",
     * "err_msg": ""
     * },
     * {
     * "out_trade_no": "out_trade_no_test_2",
     * "begin_time": "20160602203260",
     * "end_time": "20160602203262",
     * "state": "FAIL",
     * "err_msg": "SYSTEMERROR"
     * }
     * ]
     * ]
     * POS机采集的交易信息列表，使用JSON格式的数组，每条交易包含：
     * 1. out_trade_no 商户订单号
     * 2. begin_time 交易开始时间（扫码时间)
     * 3. end_time 交易完成时间
     * 4. state 交易结果
     * OK   -成功
     * FAIL -失败
     * CANCLE-取消
     * 5. err_msg 自定义的错误描述信息
     * <p>
     * *注意，将JSON数组的文本串放到XML节点中时，需要使用!CDATA[]标签将JSON文本串保护起来
     */
    @XStreamAlias("trades")
    private String trades;


    @Override
    public String routing() {
        return "/payitil/report";
    }

    @Override
    public Class<WxPayitilReportResult> getResultClass() {
        return WxPayitilReportResult.class;
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
        map.put("device_info", this.deviceInfo);
        map.put("interface_url", this.interfaceUrl);
        map.put("execute_time_", this.executeTime);
        map.put("return_code", this.returnCode);
        map.put("return_msg", this.returnMsg);
        map.put("result_code", this.resultCode);
        map.put("err_code", this.errCode);
        map.put("err_code_des", this.errCodeDes);
        map.put("out_trade_no", this.outTradeNo);
        map.put("user_ip", this.userIp);
        map.put("time", this.time);
        map.put("trades", this.trades);
    }
}
