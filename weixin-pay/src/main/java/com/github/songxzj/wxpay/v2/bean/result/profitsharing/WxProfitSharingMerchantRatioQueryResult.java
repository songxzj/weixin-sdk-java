package com.github.songxzj.wxpay.v2.bean.result.profitsharing;

import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxProfitSharingMerchantRatioQueryResult extends BaseWxPayResult {
    private static final long serialVersionUID = -5175642066706250731L;

    /**
     * 返回信息
     * err_msg
     * 否
     * string(256)
     * 参数格式校验错误
     * 如果返回状态码为FAIL，则本字段存在，且为失败的错误信息
     */
    @XStreamAlias("err_msg")
    private String errMsg;

    /**
     * 最大分账比例
     * max_ratio
     * 是
     * int
     * 2000
     * 子商户允许服务商分账的最大比例，单位万分比，比如2000表示20%
     */
    @XStreamAlias("max_ratio")
    private Integer maxRatio;


    /**
     * 品牌主商户号
     * brand_mch_id
     * 否
     * string(32)
     * 1900000108
     * 调用接口时提供的品牌主商户号。
     */
    @XStreamAlias("brand_mch_id")
    private String brandMchId;

    @Override
    protected void loadXml(Document d) {
        this.errMsg = readXmlString(d, "err_msg");
        this.maxRatio = readXmlInteger(d, "max_ratio");
        this.brandMchId = readXmlString(d, "brand_mch_id");
    }
}
