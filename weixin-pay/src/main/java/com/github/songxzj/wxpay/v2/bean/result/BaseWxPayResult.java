package com.github.songxzj.wxpay.v2.bean.result;


import com.github.songxzj.common.xml.XStreamInitializer;
import com.github.songxzj.wxpay.util.XmlConfig;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 微信支付结果共用属性类.
 */
@Setter
@Getter
@ToString
public abstract class BaseWxPayResult implements Serializable {
    private static final long serialVersionUID = -6073353956986210229L;
    /**
     * 返回状态码.
     */
    @XStreamAlias("return_code")
    protected String returnCode;
    /**
     * 返回信息.
     */
    @XStreamAlias("return_msg")
    protected String returnMsg;

    //当return_code为SUCCESS的时候，还会包括以下字段：

    /**
     * 业务结果.
     */
    @XStreamAlias("result_code")
    private String resultCode;
    /**
     * 错误代码.
     */
    @XStreamAlias("err_code")
    private String errCode;
    /**
     * 错误代码描述.
     */
    @XStreamAlias("err_code_des")
    private String errCodeDes;

    @XStreamAlias("err_param")
    private String errParam;
    /**
     * 公众账号ID.
     */
    @XStreamAlias("appid")
    private String appid;
    /**
     * 商户号.
     */
    @XStreamAlias("mch_id")
    private String mchId;
    /**
     * 服务商模式下的子公众账号ID.
     */
    @XStreamAlias("sub_appid")
    private String subAppId;
    /**
     * 服务商模式下的子商户号.
     */
    @XStreamAlias("sub_mch_id")
    private String subMchId;
    /**
     * 随机字符串.
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;
    /**
     * 签名.
     */
    @XStreamAlias("sign")
    private String sign;

    /**
     * 签名类型
     */
    @XStreamAlias("sign_type")
    private String signType;


    //以下为辅助属性
    /**
     * xml字符串.
     */
    private String xmlString;

    /**
     * xml的Document对象，用于解析xml文本.
     * make xmlDoc transient to ensure toString() can work.
     */
    private transient Document xmlDoc;

    private byte[] bytes;

    /**
     * 从xml字符串创建bean对象.
     *
     * @param <T>       the type parameter
     * @param xmlString the xml string
     * @param clz       the clz
     * @return the t
     */
    public static <T extends BaseWxPayResult> T fromXml(String xmlString, Class<T> clz) {
        if (XmlConfig.fastMode) {
            try {
                BaseWxPayResult result = clz.newInstance();
                result.setXmlString(xmlString);
                Document doc = result.getXmlDoc();
                result.loadBasicXml(doc);
                result.loadXml(doc);
                result.compose();
                return (T) result;
            } catch (Exception e) {
                throw new RuntimeException("转换 xml 格式失败", e);
            }
        }
        XStream xstream = XStreamInitializer.getInstance();
        xstream.processAnnotations(clz);
        T result = (T) xstream.fromXML(xmlString);
        result.setXmlString(xmlString);
        result.compose();
        return result;
    }

    /**
     * 只有流信息的
     * @param bytes
     * @param clz
     * @param <T>
     * @return
     */
    public static <T extends BaseWxPayResult> T createStreamInstance(byte[] bytes, Class<T> clz) {
        try {
            BaseWxPayResult result = clz.newInstance();
            result.setBytes(bytes);
            return (T) result;
        } catch (Exception e) {
            throw new RuntimeException("创建对象失败", e);
        }
    }
    /**
     * 从XML文档中加载属性,供子类覆盖加载额外的属性
     *
     * @param d Document
     */
    protected abstract void loadXml(Document d);

    public void compose() {
    }

    /**
     * 从XML文档中加载基础属性
     *
     * @param d Document
     */
    private void loadBasicXml(Document d) {
        this.returnCode = readXmlString(d, "return_code");
        this.returnMsg = readXmlString(d, "return_msg");
        this.resultCode = readXmlString(d, "result_code");
        this.errCode = readXmlString(d, "err_code");
        this.errCodeDes = readXmlString(d, "err_code_des");
        this.errParam = readXmlString(d, "err_param");
        this.appid = readXmlString(d, "appid");
        this.mchId = readXmlString(d, "mch_id");
        this.subAppId = readXmlString(d, "sub_appid");
        this.subMchId = readXmlString(d, "sub_mch_id");
        this.nonceStr = readXmlString(d, "nonce_str");
        this.sign = readXmlString(d, "sign");
        this.signType = readXmlString(d, "sign_type");
    }


    protected static String readXmlString(Document d, String tagName) {
        NodeList elements = d.getElementsByTagName(tagName);
        if (elements == null || elements.getLength() == 0) {
            return null;
        }

        Node node = elements.item(0).getFirstChild();
        if (node == null) {
            return null;
        }
        return node.getNodeValue();
    }

    protected static String readXmlString(Node d, String tagName) {
        if (!d.hasChildNodes()) {
            return null;
        }
        NodeList childNodes = d.getChildNodes();
        for (int i = 0, j = childNodes.getLength(); i < j; i++) {
            Node node = childNodes.item(i);
            if (tagName.equals(node.getNodeName())) {
                if (!node.hasChildNodes()) {
                    return null;
                }
                return node.getFirstChild().getNodeValue();
            }
        }
        return null;
    }

    protected static Integer readXmlInteger(Document d, String tagName) {
        String content = readXmlString(d, tagName);
        if (content == null || content.trim().length() == 0) {
            return null;
        }
        return Integer.parseInt(content);
    }

    protected static Integer readXmlInteger(Node d, String tagName) {
        String content = readXmlString(d, tagName);
        if (content == null || content.trim().length() == 0) {
            return null;
        }
        return Integer.parseInt(content);
    }


    /**
     * 将bean通过保存的xml字符串转换成map.
     *
     * @return the map
     */
    public Map<String, String> toMap() {
        if (StringUtils.isBlank(this.xmlString)) {
            throw new RuntimeException("xml数据有问题，请核实！");
        }

        Map<String, String> result = Maps.newHashMap();
        Document doc = getXmlDoc();

        try {
            NodeList list = (NodeList) XPathFactory.newInstance().newXPath()
                    .compile("/xml/*")
                    .evaluate(doc, XPathConstants.NODESET);
            int len = list.getLength();
            for (int i = 0; i < len; i++) {
                result.put(list.item(i).getNodeName(), list.item(i).getTextContent());
            }
        } catch (XPathExpressionException e) {
            throw new RuntimeException("非法的xml文本内容：\n" + this.xmlString);
        }

        return result;
    }

    /**
     * 将xml字符串转换成Document对象，以便读取其元素值.
     */
    private Document getXmlDoc() {
        if (this.xmlDoc != null) {
            return this.xmlDoc;
        }
        this.xmlDoc = openXML(this.xmlString);
        return this.xmlDoc;
    }

    protected Document openXML(String content) {
        try {
            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setExpandEntityReferences(false);
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            return factory.newDocumentBuilder().parse(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("非法的xml文本内容：\n" + this.xmlString, e);
        }
    }


    /**
     * 获取xml中元素的值，作为int值返回.
     *
     * @param path the path
     * @return the xml value as int
     */
    protected Integer getXmlValueAsInt(String... path) {
        String result = getXmlValue(path);
        if (StringUtils.isBlank(result)) {
            return null;
        }

        return Integer.valueOf(result);
    }


    /**
     * 获取xml中元素的值.
     *
     * @param path the path
     * @return the xml value
     */
    protected String getXmlValue(String... path) {
        Document doc = getXmlDoc();
        String expression = String.format("/%s//text()", Joiner.on("/").join(path));
        try {
            return (String) XPathFactory
                    .newInstance()
                    .newXPath()
                    .compile(expression)
                    .evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            throw new RuntimeException("未找到相应路径的文本：" + expression);
        }
    }


}
