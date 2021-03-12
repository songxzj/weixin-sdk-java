package com.github.songxzj.wxpay.util;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.github.songxzj.common.annotation.SignExclude;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * 签名相关工具类.
 */
@Slf4j
public class SignUtils {

    /**
     * 签名的时候不携带的参数
     */
    private static List<String> NO_SIGN_PARAMS = Lists.newArrayList("sign", "key", "xmlString", "xmlDoc", "couponList");

    /**
     * 微信支付签名算法(详见:https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3).
     *
     * @param xmlBean       Bean里的属性如果存在XML注解，则使用其作为key，否则使用变量名
     * @param signType      签名类型，如果为空，则默认为MD5
     * @param signKey       签名Key
     * @param ignoredParams 签名时需要忽略的特殊参数
     * @return 签名字符串 string
     */
    public static String createSign(Object xmlBean, String signType, String signKey, String[] ignoredParams) throws WxErrorException {
        Map<String, String> map = null;

        if (XmlConfig.fastMode) {
            if (xmlBean instanceof BaseWxPayRequest) {
                map = ((BaseWxPayRequest) xmlBean).getSignParams();
            }
        }
        if (map == null) {
            map = xmlBean2Map(xmlBean);
        }

        return createSign(map, signType, signKey, ignoredParams);
    }

    /**
     * 微信支付签名算法(详见:https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3).
     *
     * @param params        参数信息
     * @param signType      签名类型，如果为空，则默认为MD5
     * @param signKey       签名Key
     * @param ignoredParams 签名时需要忽略的特殊参数
     * @return 签名字符串 string
     */
    public static String createSign(Map<String, String> params, String signType, String signKey, String[] ignoredParams) throws WxErrorException {
        SortedMap<String, String> sortedMap = new TreeMap<>(params);

        StringBuilder toSign = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            String value = params.get(key);
            boolean shouldSign = false;
            if (StringUtils.isNotEmpty(value) && !ArrayUtils.contains(ignoredParams, key)
                    && !NO_SIGN_PARAMS.contains(key)) {
                shouldSign = true;
            }

            if (shouldSign) {
                toSign.append(key).append("=").append(value).append("&");
            }
        }

        toSign.append("key=").append(signKey);
        if (WxPayConstants.SignType.HMAC_SHA256.equals(signType)) {
            return createHmacSha256Sign(toSign.toString(), signKey);
        } else {
            return DigestUtil.md5Hex(toSign.toString()).toUpperCase();
        }
    }

    /**
     * 校验签名是否正确.
     *
     * @param xmlBean  Bean需要标记有XML注解
     * @param signType 签名类型，如果为空，则默认为MD5
     * @param signKey  校验的签名Key
     * @return true - 签名校验成功，false - 签名校验失败
     */
    public static boolean checkSign(Object xmlBean, String signType, String signKey) throws WxErrorException {
        return checkSign(xmlBean2Map(xmlBean), signType, signKey);
    }

    /**
     * 校验签名是否正确.
     *
     * @param params   需要校验的参数Map
     * @param signType 签名类型，如果为空，则默认为MD5
     * @param signKey  校验的签名Key
     * @return true - 签名校验成功，false - 签名校验失败
     */
    public static boolean checkSign(Map<String, String> params, String signType, String signKey) throws WxErrorException {
        String sign = createSign(params, signType, signKey, new String[0]);
        return sign.equals(params.get("sign"));
    }

    /**
     * 将bean按照@XStreamAlias标识的字符串内容生成以之为key的map对象.
     *
     * @param bean 包含@XStreamAlias的xml bean对象
     * @return map对象 map
     */
    public static Map<String, String> xmlBean2Map(Object bean) {
        Map<String, String> result = Maps.newHashMap();
        List<Field> fields = new ArrayList<>(Arrays.asList(bean.getClass().getDeclaredFields()));
        fields.addAll(Arrays.asList(bean.getClass().getSuperclass().getDeclaredFields()));
        if (bean.getClass().getSuperclass().getSuperclass() == BaseWxPayRequest.class) {
            fields.addAll(Arrays.asList(BaseWxPayRequest.class.getDeclaredFields()));
        }

        if (bean.getClass().getSuperclass().getSuperclass() == BaseWxPayResult.class) {
            fields.addAll(Arrays.asList(BaseWxPayResult.class.getDeclaredFields()));
        }

        for (Field field : fields) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                if (field.get(bean) == null) {
                    field.setAccessible(isAccessible);
                    continue;
                }

                if (field.isAnnotationPresent(XStreamAlias.class)) {
                    result.put(field.getAnnotation(XStreamAlias.class).value(), field.get(bean).toString());
                } else if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(SignExclude.class)) {
                    //忽略掉静态成员变量
                    result.put(field.getName(), field.get(bean).toString());
                }

                field.setAccessible(isAccessible);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }
        return result;
    }


    /**
     * HmacSHA256 签名算法
     *
     * @param message 签名数据
     * @param key     签名密钥
     */
    public static String createHmacSha256Sign(String message, String key) throws WxErrorException {
        try {
            Mac sha256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256.init(secretKeySpec);
            byte[] bytes = sha256.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return HexUtil.encodeHexStr(bytes).toUpperCase();
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SIGN_ERROR_ERROR);
        }
    }

    /**
     * SHA256withRSA 签名算法
     *
     * @param message
     * @param privateKey
     * @return
     */
    public static String createSHA256withRSASign(String message, PrivateKey privateKey) throws WxErrorException {
        try {
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initSign(privateKey);
            sign.update(message.getBytes(StandardCharsets.UTF_8));
            return Base64Utils.encodeToString(sign.sign());
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SIGN_ERROR_ERROR);
        }
    }


    /**
     * SHA256withRSA 签名验证
     *
     * @param certificate
     * @param message
     * @param signature
     * @return
     * @throws WxErrorException
     */
    public static boolean checkSHA256withRSASign(X509Certificate certificate, String message, String signature) throws WxErrorException {
        try {
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initVerify(certificate);

            sign.update(message.getBytes(StandardCharsets.UTF_8));
            return sign.verify(Base64Utils.decodeFromString(signature));
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.SIGN_ERROR_ERROR);
        }
    }
}
