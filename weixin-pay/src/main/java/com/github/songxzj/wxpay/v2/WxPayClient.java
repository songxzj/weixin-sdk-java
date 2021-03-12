package com.github.songxzj.wxpay.v2;

import cn.hutool.core.util.RandomUtil;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.common.util.WxIOUtils;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import com.github.songxzj.wxpay.util.DecryptUtils;
import com.github.songxzj.wxpay.util.SignUtils;
import com.github.songxzj.wxpay.v2.bean.request.BaseWxPayRequest;
import com.github.songxzj.wxpay.v2.bean.result.BaseWxPayResult;
import com.github.songxzj.wxpay.v2.bean.result.notify.WxPayNotifyResult;
import com.github.songxzj.wxpay.v2.bean.result.notify.WxPayRefundNotifyResult;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.*;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

@Slf4j
public class WxPayClient {

    /**
     * 微信支付接口请求地址域名部分.
     */
    private String serverUrl = WxPayConstants.DEFAULT_PAY_BASE_URL;

    /**
     * http请求连接超时时间.
     */
    private int connectTimeout = 5000;

    /**
     * http请求数据读取等待时间.
     */
    private int readTimeout = 10000;

    /**
     * 公众号appid.
     */
    private final String appId;
    /**
     * 服务商模式下的子商户公众账号ID.
     */
    private final String subAppId;
    /**
     * 商户号.
     */
    private final String mchId;

    /**
     * 服务商模式下的子商户号.
     */
    private final String subMchId;

    /**
     * 商户密钥.
     */
    private final String mchKey;

    /**
     * p12证书文件的绝对路径或者以classpath:开头的类路径.
     */
    private final String keyPath;

    /**
     * 签名方式.
     * 有两种HMAC_SHA256 和MD5
     */
    private final String signType;

    /**
     * 微信支付是否使用仿真测试环境.
     * 默认不使用
     */
    private boolean useSandboxEnv = false;


    /**
     * 返回所设置的微信支付接口请求地址域名.
     *
     * @return 微信支付接口请求地址域名
     */
    private String getServerUrl() {
        return this.serverUrl;
    }


    public static WxPayClientBuilder newBuilder() {
        return new WxPayClientBuilder();
    }

    public static class WxPayClientBuilder {

        private String appId;

        private String subAppId;

        private String mchId;

        private String subMchId;

        private String mchKey;

        private String keyPath;

        private String signType;

        private WxPayClientBuilder() {
        }

        public WxPayClientBuilder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public WxPayClientBuilder subAppId(String subAppId) {
            this.subAppId = subAppId;
            return this;
        }

        public WxPayClientBuilder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public WxPayClientBuilder subMchId(String subMchId) {
            this.subMchId = subMchId;
            return this;
        }

        public WxPayClientBuilder mchKey(String mchKey) {
            this.mchKey = mchKey;
            return this;
        }

        public WxPayClientBuilder keyPath(String keyPath) {
            this.keyPath = keyPath;
            return this;
        }

        public WxPayClientBuilder signType(String signType) {
            this.signType = signType;
            return this;
        }

        public WxPayClient build() throws WxErrorException {
            if (StringUtils.isBlank(this.mchId)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "mchId 必须提供值");
            }
            if (StringUtils.isBlank(this.mchKey)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "mchKey 必须提供值");
            }
            if (StringUtils.isBlank(this.signType)) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "signType 必须提供值");
            }
            return new WxPayClient(this.appId, this.subAppId, this.mchId, this.subMchId, this.mchKey, this.keyPath, this.signType);
        }
    }

    /**
     * 支付接口相关构造函数
     *
     * @param appId
     * @param subAppId
     * @param mchId
     * @param subMchId
     * @param keyPath
     * @param mchKey
     * @param signType
     */
    private WxPayClient(String appId, String subAppId, String mchId, String subMchId, String mchKey, String keyPath, String signType) {
        this.appId = appId;
        this.subAppId = subAppId;
        this.mchId = mchId;
        this.subMchId = subMchId;
        this.mchKey = mchKey;
        this.keyPath = keyPath;
        this.signType = signType;
    }

    private <T extends BaseWxPayResult> void setRequestSignType(BaseWxPayRequest<T> request) throws WxErrorException {
        if (StringUtils.isBlank(request.getSignType())) {
            request.setSignType(this.signType);
        }
        if (!WxPayConstants.SignType.ALL_SIGN_TYPES.contains(request.getSignType())) {
            throw new WxErrorException(WxErrorExceptionFactor.ILLEGAL_SIGN_TYPE);
        }
    }

    /**
     * 图片上传特定
     *
     * @param request
     * @return
     * @throws WxErrorException
     */
    /*public WxUploadMediaResult uploadMedia(WxUploadMediaRequest request) throws WxErrorException {
        String MediaHash;
        try {
            InputStream data = new FileInputStream(request.getFile());
            MediaHash = DigestUtil.md5Hex(data).toLowerCase();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.IMAGE_ERROR);
        }

        request.setMediaHash(MediaHash);
        request.checkFields();
        if (StringUtils.isBlank(request.getMchId())) {
            request.setMchId(this.mchId);
        }

        setRequestSignType(request);

        //设置签名字段的值
        request.setSign(SignUtils.createSign(request, request.getSignType(), this.mchKey, request.getIgnoredParamsForSign()));

        String requestUrl = getServerUrl() + request.routing();
        boolean hasError = false;
        String responseContent = null;
        long begin = System.currentTimeMillis();
        try {
            RestTemplate restClient = getRestClient(request.isUseKey());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(WxPayConstants.MULTIPART_FORM_DATA_UTF8_VALUE));

            FileSystemResource resource = new FileSystemResource(request.getFile());
            MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
            form.add("mch_id", request.getMchId());
            form.add("media", resource);
            form.add("media_hash", request.getMediaHash());
            form.add("sign_type", request.getSignType());
            form.add("sign", request.getSign());

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(form, headers);
            ResponseEntity<String> responseEntity = restClient.exchange(requestUrl, HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode() != HttpStatus.OK) {
                throw new WxErrorException(WxErrorExceptionFactor.HTTP_REQUEST_FAIL_CODE, "http status code error: " + responseEntity.getStatusCodeValue());
            }

            responseContent = responseEntity.getBody();

            return verifyAndGetResult(responseContent, request);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            hasError = true;
            throw new WxErrorException(WxErrorExceptionFactor.HTTP_REQUEST_FAIL_CODE, e.getMessage());
        } finally {
            log.warn("wxpay url: {}\n" +
                            "wxpay request {}, cost time: {},\n" +
                            "response content: \n{}",
                    requestUrl, hasError ? "failed" : "succeeded", System.currentTimeMillis() - begin, responseContent);
        }
    }*/


    /**
     * 通用执行方法
     *
     * @param request
     * @param <T>
     * @return
     * @throws WxErrorException
     */
    public <T extends BaseWxPayResult> T execute(BaseWxPayRequest<T> request) throws WxErrorException {
        checkAndSign(request);
        String serverUrl = StringUtils.isBlank(request.ownServerUrl()) ? getServerUrl() : request.ownServerUrl();
        String requestUrl = serverUrl + request.routing();
        byte[] bytes = post(requestUrl, request.toXml(), request.isUseKey());

        return verifyAndGetResult(bytes, request);
    }


    /**
     * 检查参数，并设置签名.
     * 1、检查参数（注意：子类实现需要检查参数的而外功能时，请在调用父类的方法前进行相应判断）
     * 2、生成签名，并设置进去
     *
     * @throws WxErrorException the wx pay exception
     */
    private <T extends BaseWxPayResult> void checkAndSign(BaseWxPayRequest<T> request) throws WxErrorException {
        request.checkFields();

        if (StringUtils.isBlank(request.getAppid())) {
            request.setAppid(this.appId);
        }

        if (StringUtils.isBlank(request.getMchId())) {
            request.setMchId(this.mchId);
        }

        if (StringUtils.isBlank(request.getSubAppId())) {
            request.setSubAppId(this.subAppId);
        }

        if (StringUtils.isBlank(request.getSubMchId())) {
            request.setSubMchId(this.subMchId);
        }

        setRequestSignType(request);

        if (StringUtils.isBlank(request.getNonceStr())) {
            request.setNonceStr(RandomUtil.randomString(32));
        }

        //设置签名字段的值
        request.setSign(SignUtils.createSign(request, request.getSignType(), this.mchKey, request.getIgnoredParamsForSign()));
    }


    /**
     * 发送post请求，得到响应数据
     *
     * @param requestUrl     请求地址
     * @param requestContent 请求信息
     * @param isUseKey       是否使用证书
     * @return 返回请求结果二进制数据
     * @throws WxErrorException the wx pay exception
     */
    private byte[] post(String requestUrl, String requestContent, boolean isUseKey) throws WxErrorException {
        boolean hasError = false;
        String responseContent = null;
        long begin = System.currentTimeMillis();
        try {
            RestTemplate restClient = getRestClient(isUseKey);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(WxPayConstants.APPLICATION_FORM_URLENCODED_UTF8_VALUE));

            HttpEntity<String> requestEntity = new HttpEntity<>(requestContent, headers);
            ResponseEntity<byte[]> responseEntity = restClient.exchange(requestUrl, HttpMethod.POST, requestEntity, byte[].class);

            if (responseEntity.getStatusCode() != HttpStatus.OK) {
                throw new WxErrorException(WxErrorExceptionFactor.HTTP_REQUEST_FAIL_CODE, "http status code error: " + responseEntity.getStatusCodeValue());
            }
            byte[] bytes = responseEntity.getBody();
            responseContent = WxIOUtils.bytesToString(bytes);

            return bytes;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            hasError = true;
            throw new WxErrorException(WxErrorExceptionFactor.HTTP_REQUEST_FAIL_CODE, e.getMessage());
        } finally {
            log.warn("wxpay url: {}\n" +
                            "request content: \n{}\n" +
                            "wxpay request {}, cost time: {},\n" +
                            "response content: \n{}",
                    requestUrl, requestContent, hasError ? "failed" : "succeeded", System.currentTimeMillis() - begin, responseContent);
        }
    }

    /**
     * 获取 RestTemplate
     *
     * @param isUseKey
     * @return
     * @throws WxErrorException
     */
    private RestTemplate getRestClient(boolean isUseKey) throws WxErrorException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (isUseKey) {
            TrustManager[] trustManagers;
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                        TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                    throw new IllegalStateException("Unexpected default trust managers:"
                            + Arrays.toString(trustManagers));
                }
            } catch (NoSuchAlgorithmException | KeyStoreException e) {
                log.error(e.getMessage(), e);
                throw new WxErrorException(WxErrorExceptionFactor.HTTP_TRUST_ERROR);
            }

            X509TrustManager trustManager = (X509TrustManager) trustManagers[0];
            builder.sslSocketFactory(initSSLContext().getSocketFactory(), trustManager);
        }
        OkHttpClient okHttpClient = builder.build();
        OkHttp3ClientHttpRequestFactory requestFactory = new OkHttp3ClientHttpRequestFactory(okHttpClient);
        requestFactory.setConnectTimeout(this.connectTimeout);
        requestFactory.setReadTimeout(this.readTimeout);

        RestTemplate restClient = new RestTemplate(requestFactory);
        restClient.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(WxPayConstants.DEFAULT_CHARSET)));

        return restClient;
    }

    /**
     * 初始化ssl.
     *
     * @return the ssl context
     */
    private SSLContext initSSLContext() throws WxErrorException {
        if (StringUtils.isBlank(this.keyPath)) {
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "keyPath 必须提供值");
        }

        File file = new File(this.keyPath);
        if (!file.exists()) {
            throw new WxErrorException(WxErrorExceptionFactor.KEY_FILE_NOT_EXIST);
        }

        try (InputStream inputStream = new FileInputStream(file)) {
            KeyStore keystore = KeyStore.getInstance("PKCS12");
            char[] partnerId2charArray = this.mchId.toCharArray();
            keystore.load(inputStream, partnerId2charArray);
            return SSLContexts.custom().loadKeyMaterial(keystore, partnerId2charArray).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.KEY_FILE_ERROR_CODE, e.getMessage());
        }
    }

    /**
     * 校验返回结果签名
     *
     * @param bytes
     * @param request
     * @param <T>
     * @throws WxErrorException
     */
    private <T extends BaseWxPayResult> T verifyAndGetResult(byte[] bytes, BaseWxPayRequest<T> request) throws WxErrorException {
        String responseContent = WxIOUtils.bytesToString(bytes);
        if (!(StringUtils.startsWith(responseContent, "<") && StringUtils.endsWith(responseContent, ">"))) {
            return BaseWxPayResult.createStreamInstance(bytes, request.getResultClass());
        }

        T result = BaseWxPayResult.fromXml(responseContent, request.getResultClass());
        //校验返回结果签名
        if (!StringUtils.isBlank(result.getSign()) && !SignUtils.checkSign(result.toMap(), request.getSignType(), this.mchKey)) {
            throw new WxErrorException(WxErrorExceptionFactor.CHECK_SIGN_ERROR);
        }
        // return_code 不成功
        if (!WxPayConstants.ResultCode.SUCCESS.equals(result.getReturnCode())) {
            throw new WxErrorException(WxErrorExceptionFactor.RESULT_FAIL_CODE, result.getReturnMsg());
        }

        return result;
    }

    /**
     * 支付通知
     *
     * @param responseXml
     * @return
     * @throws WxErrorException
     */
    public WxPayNotifyResult verifyPayNotifyAndGetResult(String responseXml) throws WxErrorException {
        WxPayNotifyResult result = BaseWxPayResult.fromXml(responseXml, WxPayNotifyResult.class);
        //校验返回结果签名
        Map<String, String> map = result.toMap();
        String signType = !StringUtils.isBlank(result.getSignType()) ? result.getSignType() : WxPayConstants.SignType.MD5;
        if (StringUtils.isBlank(result.getSign()) || !SignUtils.checkSign(map, signType, this.mchKey)) {
            throw new WxErrorException(WxErrorExceptionFactor.CHECK_SIGN_ERROR);
        }
        // return_code 不成功
        if (!WxPayConstants.ResultCode.SUCCESS.equals(result.getReturnCode())) {
            throw new WxErrorException(WxErrorExceptionFactor.RESULT_FAIL_CODE, result.getReturnMsg());
        }

        return result;
    }

    /**
     * 退款通知
     *
     * @param responseXml
     * @return
     * @throws WxErrorException
     */
    public WxPayRefundNotifyResult verifyRefundNotifyAndGetResult(String responseXml) throws WxErrorException {
        WxPayRefundNotifyResult result = BaseWxPayResult.fromXml(responseXml, WxPayRefundNotifyResult.class);

        // return_code 不成功
        if (!WxPayConstants.ResultCode.SUCCESS.equals(result.getReturnCode())) {
            throw new WxErrorException(WxErrorExceptionFactor.RESULT_FAIL_CODE, result.getReturnMsg());
        }
        String decryptedReqInfo = DecryptUtils.decryptV2RefundNotify(this.mchKey, result.getReqInfoStr());
        result.setReqInfo(BaseWxPayResult.fromXml(decryptedReqInfo, WxPayRefundNotifyResult.ReqInfo.class));

        return result;
    }
}
