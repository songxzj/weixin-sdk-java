/*
package com.github.songxzj.wxpay.v2.bean.result.micro;

import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxUploadMediaResult extends BaseWxPayResult {
    private static final long serialVersionUID = -2595631560521777952L;
    */
/**
     * 媒体标识Id
     * media_id
     * 是
     * String(256)
     * 9UYfXi- WMUhgWXvJtEw4_gBl e_EfrD_pIL0bS8GAsK8
     * 微信返回的媒体文件标识Id
     **//*

    @XStreamAlias("media_id")
    private String mediaId;


    @Override
    protected void loadXml(Document d) {
        this.mediaId = readXmlString(d, "media_id");
    }
}
*/
