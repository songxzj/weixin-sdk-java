/*
package com.github.songxzj.wxpay.v2.bean.result.micro;

import com.github.songxzj.common.json.WxGsonBuilder;
import com.github.songxzj.wxpay.v2.bean.cert.WxPayCertificate;
import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxRiskGetCertficatesResult extends BaseWxPayResult {
    private static final long serialVersionUID = -9068944046721157238L;
    */
/**
     * 平台证书信息
     * certificates
     * 是
     * String(6000)
     * 包含了平台证书序列号serial_no、证书启用时间effective_time、证书弃用时间expire_time、加密证书信息包encrypt_certificate，请根据平台证书解密指引获取证书明文（证书明文为PEM格式），方可使用
     **//*

    @XStreamAlias("certificates")
    private String certificates;

    private List<WxPayCertificate> wxPayCertificateList;

    @Override
    public void compose() {
        composeCertificates();
    }

    */
/**
     * 组装解密生成证书.
     *//*

    public void composeCertificates() {
        Gson gson = WxGsonBuilder.create();
        JsonArray data = gson.fromJson(this.certificates, JsonObject.class).getAsJsonArray("data");
        this.wxPayCertificateList = gson.fromJson(data.toString(), new TypeToken<List<WxPayCertificate>>() {
        }.getType());
    }


    @Override
    protected void loadXml(Document d) {
        this.certificates = readXmlString(d, "certificates");
    }
}
*/
