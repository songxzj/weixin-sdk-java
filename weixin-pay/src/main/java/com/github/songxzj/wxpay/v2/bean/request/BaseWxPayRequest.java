package com.github.songxzj.wxpay.v2.bean.request;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.util.WxBeanUtils;
import com.github.songxzj.common.xml.XStreamInitializer;
import com.github.songxzj.wxpay.util.XmlConfig;
import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.experimental.Accessors;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;


/**
 * 微信支付请求对象共用的参数存放类
 */
@Data
@Accessors(chain = true)
public abstract class BaseWxPayRequest<T extends BaseWxPayResult> implements Serializable {
    private static final long serialVersionUID = -4766915659779847060L;

    /**
     * 字段名：公众账号ID.
     * 变量名：appid
     * 是否必填：是
     * 类型：String(32)
     * 示例值：wxd678efh567hg6787
     * 描述：微信分配的公众账号ID（企业号corpid即为此appId）
     */
    @XStreamAlias("appid")
    protected String appid;
    /**
     * 字段名：商户号.
     * 变量名：mch_id
     * 是否必填：是
     * 类型：String(32)
     * 示例值：1230000109
     * 描述：微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    protected String mchId;
    /**
     * 字段名：服务商模式下的子商户公众账号ID.
     * 变量名：sub_appid
     * 是否必填：是
     * 类型：String(32)
     * 示例值：wxd678efh567hg6787
     * 描述：微信分配的子商户公众账号ID
     */
    @XStreamAlias("sub_appid")
    protected String subAppId;
    /**
     * 字段名：服务商模式下的子商户号.
     * 变量名：sub_mch_id
     * 是否必填：是
     * 类型：String(32)
     * 示例值：1230000109
     * 描述：微信支付分配的子商户号，开发者模式下必填
     */
    @XStreamAlias("sub_mch_id")
    protected String subMchId;
    /**
     * 字段名：随机字符串.
     * 变量名：nonce_str
     * 是否必填：是
     * 类型：String(32)
     * 示例值：5K8264ILTKCH16CQ2502SI8ZNMTM67VS
     * 描述：随机字符串，不长于32位。推荐随机数生成算法
     */
    @XStreamAlias("nonce_str")
    protected String nonceStr;
    /**
     * 字段名：签名.
     * 变量名：sign
     * 是否必填：是
     * 类型：String(32)
     * 示例值：C380BEC2BFD727A4B6845133519F3AD6
     * 描述：签名，详见签名生成算法
     */
    @XStreamAlias("sign")
    protected String sign;

    /**
     * 签名类型.
     * sign_type
     * 否
     * String(32)
     * HMAC-SHA256
     * 签名类型，目前支持HMAC-SHA256和MD5
     */
    @XStreamAlias("sign_type")
    private String signType;


    /**
     * 具体路由
     */
    public abstract String routing();

    /**
     * 得到当前API的响应结果类型
     */
    public abstract Class<T> getResultClass();


    /**
     * 是否用到证书
     */
    public abstract boolean isUseKey();

    /**
     * 是否有自己特有的请求域名
     */
    public String ownServerUrl() {
        return null;
    }

    /**
     * 将单位为元转换为单位为分.
     *
     * @param yuan 将要转换的元的数值字符串
     * @return the integer
     */
    public static Integer yuanToFen(String yuan) {
        return new BigDecimal(yuan).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).intValue();
    }

    /**
     * 检查请求参数内容，包括必填参数以及特殊约束.
     */
    public void checkFields() throws WxErrorException {
        //check required fields
        WxBeanUtils.checkRequiredFields(this);
        //check other parameters
        checkConstraints();
    }

    /**
     * 检查约束情况.
     *
     * @throws WxErrorException the wx pay exception
     */
    protected abstract void checkConstraints() throws WxErrorException;

    /**
     * To xml string.
     *
     * @return the string
     */
    public String toXml() {
        if (XmlConfig.fastMode) {
            return toFastXml();
        }
        XStream xstream = XStreamInitializer.getInstance();
        xstream.processAnnotations(this.getClass());
        return xstream.toXML(this);
    }

    /**
     * 使用快速算法组装xml
     *
     * @return
     */
    private String toFastXml() {
        try {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement(xmlRootTagName());

            Map<String, String> signParams = getSignParams();
            signParams.put("sign", this.sign);
            for (Map.Entry<String, String> entry : signParams.entrySet()) {
                if (entry.getValue() == null) {
                    continue;
                }
                Element elm = root.addElement(entry.getKey());
                elm.addText(entry.getValue());
            }

            return document.asXML();
        } catch (Exception e) {
            throw new RuntimeException("generate xml error", e);
        }
    }

    /**
     * 返回xml结构的根节点名称
     *
     * @return 默认返回"xml", 特殊情况可以在子类中覆盖
     */
    protected String xmlRootTagName() {
        return "xml";
    }


    /**
     * 签名时，忽略的参数.
     *
     * @return the string [ ]
     */
    public String[] getIgnoredParamsForSign() {
        return new String[0];
    }

    /**
     * 获取签名时需要的参数.
     * 注意：不含sign属性
     */
    public Map<String, String> getSignParams() {
        Map<String, String> map = Maps.newHashMap();
        map.put("appid", this.appid);
        map.put("mch_id", this.mchId);
        map.put("sub_appid", this.subAppId);
        map.put("sub_mch_id", this.subMchId);
        map.put("nonce_str", this.nonceStr);
        map.put("sign_type", this.signType);

        storeMap(map);
        return map;
    }

    /**
     * 将属性组装到一个Map中，供签名和最终发送XML时使用.
     * 这里需要将所有的属性全部保存进来，签名的时候会自动调用getIgnoredParamsForSign进行忽略，
     * 不用担心。否则最终生成的XML会缺失。
     *
     * @param map 传入的属性Map
     */
    abstract protected void storeMap(Map<String, String> map);


}
