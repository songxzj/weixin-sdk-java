package com.github.songxzj.wxpay.v3;


import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.github.songxzj.common.bean.SignatureHeader;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.github.songxzj.common.util.WxIOUtils;
import com.github.songxzj.wxpay.constant.WxPayConstants;
import com.github.songxzj.wxpay.util.CertKeyUtils;
import com.github.songxzj.wxpay.util.SensitiveUtils;
import com.github.songxzj.wxpay.v3.bean.cert.WxPayV3Certificate;
import com.github.songxzj.wxpay.v3.bean.request.BaseWxPayV3Request;
import com.github.songxzj.wxpay.v3.bean.request.WxCertificatesV3Request;
import com.github.songxzj.wxpay.v3.bean.request.media.WxMediaUploadRequest;
import com.github.songxzj.wxpay.v3.bean.result.BaseWxPayV3Result;
import com.github.songxzj.wxpay.v3.bean.result.WxCertificatesV3Result;
import com.github.songxzj.wxpay.v3.bean.result.media.WxMediaUploadResult;
import com.github.songxzj.wxpay.v3.bean.result.notify.WxNotifyResult;
import com.github.songxzj.wxpay.v3.core.WxPayConfig;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
public class WxPayV3Client {

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
     * 微信证书更新间隔时间
     */
    private int hoursInterval = 12;

    /**
     * 微信证书上一次更新时间
     */
    private LocalDateTime lastDateTime;

    /**
     * 微信证书更新锁
     */
    private final Object lock = new Object();

    /**
     * 返回所设置的微信支付接口请求地址域名.
     *
     * @return 微信支付接口请求地址域名
     */
    private String getServerUrl() {
        return this.serverUrl;
    }

    private String getSchema() {
        return "WECHATPAY2-" + wxPayConfig.getSigner().getAlgorithm();
    }

    private final WxPayConfig wxPayConfig;

    /**
     * 微信支付平台证书序列号
     */
    private String wxSerialNo;

    /**
     * 平台证书
     */
    private X509Certificate wxCertificate;

    public WxPayConfig getWxPayConfig() {
        return wxPayConfig;
    }

    private X509Certificate getWxCertificate(String responseWxSerialNo) throws WxErrorException {
        if (!StringUtils.isBlank(responseWxSerialNo) && responseWxSerialNo.equals(this.wxSerialNo)) {
            return this.wxCertificate;
        }
        LocalDateTime nowDateTime = LocalDateTimeUtil.now();
        if (!ObjectUtils.isEmpty(this.lastDateTime) && nowDateTime.isBefore(this.lastDateTime.plusHours(this.hoursInterval))) {
            return this.wxCertificate;
        }
        synchronized (this.lock) {
            getWxV3Certificate(responseWxSerialNo);
            this.lastDateTime = nowDateTime;
        }
        return this.wxCertificate;
    }

    /**
     * 根据返回的平台序列号去查询平台证书
     *
     * @param responseWxSerialNo
     * @return
     * @throws WxErrorException
     */
    private void getWxV3Certificate(String responseWxSerialNo) throws WxErrorException {
        WxCertificatesV3Request request = WxCertificatesV3Request.newBuilder().build();
        WxCertificatesV3Result result = execute(request);
        List<WxPayV3Certificate> wxPayV3CertificateList = result.getWxPayV3CertificateList();
        WxPayV3Certificate wxPayV3Certificate = wxPayV3CertificateList.get(0);
        if (!StringUtils.isBlank(responseWxSerialNo)) {
            for (WxPayV3Certificate temp : wxPayV3CertificateList) {
                if (wxPayV3Certificate.getSerialNo().equals(responseWxSerialNo)) {
                    wxPayV3Certificate = temp;
                    break;
                }
            }
        }
        WxPayV3Certificate.EncryptV3Certificate encryptV3Certificate = wxPayV3Certificate.getEncryptV3Certificate();

        this.wxSerialNo = wxPayV3Certificate.getSerialNo();
        this.wxCertificate = CertKeyUtils.loadCertificate(this.wxPayConfig.getAuthCipher().decrypt(encryptV3Certificate.getNonce(), encryptV3Certificate.getAssociatedData(), encryptV3Certificate.getCipherText()));
    }

    private WxPayV3Client(WxPayConfig wxPayConfig) throws WxErrorException {
        this.wxPayConfig = wxPayConfig;
        getWxCertificate(null);
    }

    public static WxPayV3ClientBuilder newBuilder() {
        return new WxPayV3ClientBuilder();
    }

    public static class WxPayV3ClientBuilder {

        private WxPayConfig wxPayConfig;

        private WxPayV3ClientBuilder() {
        }

        public WxPayV3ClientBuilder algorithmConfig(WxPayConfig wxPayConfig) {
            this.wxPayConfig = wxPayConfig;
            return this;
        }

        public WxPayV3Client build() throws WxErrorException {
            if (this.wxPayConfig == null) {
                throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, "算法密钥必须提供值");
            }

            return new WxPayV3Client(this.wxPayConfig);
        }
    }


    /**
     * 通用执行方法
     */
    public <T extends BaseWxPayV3Result> T execute(BaseWxPayV3Request<T> request) throws WxErrorException {
        String token = checkAndSignAndGetToken(request);
        String requestUrl = getServerUrl() + request.routing();
        byte[] bytes = restExchange(requestUrl, request, token);

        return bytesToResult(bytes, request.getResultClass());
    }

    private <T extends BaseWxPayV3Result> T bytesToResult(byte[] bytes, Class<T> clz) throws WxErrorException {
        String responseContent = WxIOUtils.bytesToString(bytes);
        if (!(StringUtils.startsWith(responseContent, "{") && StringUtils.endsWith(responseContent, "}"))) {
            return BaseWxPayV3Result.createStreamInstance(bytes, clz);
        }

        T result = BaseWxPayV3Result.fromJson(responseContent, clz);
        if (result.isSensitiveEncrypt()) {
            result = (T) this.wxPayConfig.getPrivacyDecryptor().decrypt(result);
        }
        return result;
    }


    /**
     * 检查参数，并设置签名.
     * 1、检查参数（注意：子类实现需要检查参数的而外功能时，请在调用父类的方法前进行相应判断）
     * 2、敏感信息加密
     * 3、生成签名
     * 2、生成 http 头认证
     *
     * @throws WxErrorException the wx pay exception
     */
    private <T extends BaseWxPayV3Result> String checkAndSignAndGetToken(BaseWxPayV3Request<T> request) throws WxErrorException {
        request.checkFields();
        if (request.isSensitiveEncrypt()) {
            request = (BaseWxPayV3Request<T>) this.wxPayConfig.getPrivacyEncryptor().encrypt(request, getWxCertificate(null));
        }

        long timestamp = System.currentTimeMillis() / 1000;
        String nonceStr = RandomUtil.randomString(32);

        StringBuilder toSign = new StringBuilder();
        toSign.append(request.getHttpMethod().name()).append("\n")
                .append(request.routing()).append("\n")
                .append(timestamp).append("\n")
                .append(nonceStr).append("\n")
                .append(request.toSignString()).append("\n");


        String signature = this.wxPayConfig.getSigner().sign(toSign.toString());

        StringBuilder token = new StringBuilder();
        token.append("mchid=\"").append(this.wxPayConfig.getMchId()).append("\",")
                .append("serial_no=\"").append(this.wxPayConfig.getSerialNo()).append("\",")
                .append("nonce_str=\"").append(nonceStr).append("\",")
                .append("timestamp=\"").append(timestamp).append("\",")
                .append("signature=\"").append(signature).append("\"");

        return token.toString();
    }

    private <T extends BaseWxPayV3Result> byte[] restExchange(String requestUrl, BaseWxPayV3Request<T> request, String token) throws WxErrorException {
        boolean hasError = false;
        String requestHeaderStr = null;
        String requestContent = request.toJsonString();
        String responseHeaderStr = null;
        HttpStatus httpStatus = null;
        String responseContent = null;
        long begin = System.currentTimeMillis();
        try {
            RestTemplate restClient = getRestClient();
            HttpHeaders requestHeaders = getRequestHeaders(token, request.getIdempotencyKey());
            requestHeaderStr = requestHeaders.toString();

            HttpEntity<String> requestEntity = new HttpEntity<>(requestContent, requestHeaders);
            ResponseEntity<byte[]> responseEntity = restClient.exchange(requestUrl, request.getHttpMethod(), requestEntity, byte[].class);

            httpStatus = responseEntity.getStatusCode();
            HttpHeaders responseHeaders = responseEntity.getHeaders();
            byte[] bytes = responseEntity.getBody();
            responseContent = WxIOUtils.bytesToString(bytes);

            responseHeaderStr = responseHeaders.toString();

            // 校验签名
            if (request.isCheckSign()) {
                checkResult(responseHeaders, responseContent);
            }

            return bytes;
        } catch (Exception e) {
            String errMsg = e.getMessage();
            if (e instanceof HttpStatusCodeException) {
                HttpStatusCodeException e1 = (HttpStatusCodeException) e;
                httpStatus = e1.getStatusCode();
                errMsg = e1.getMessage() + e1.getResponseBodyAsString();
            }
            log.error(errMsg, e);
            hasError = true;
            throw new WxErrorException(WxErrorExceptionFactor.HTTP_REQUEST_FAIL_CODE, errMsg);
        } finally {
            log.warn("wxpay url: {}\n" +
                            "request header: \n{}\n" +
                            "request content: \n{}\n" +
                            "wxpay request {}, cost time: {}, http status code: {}\n" +
                            "response header: \n{}\n" +
                            "response content: \n{}",
                    requestUrl, requestHeaderStr, requestContent, hasError ? "failed" : "succeeded", System.currentTimeMillis() - begin, httpStatus, responseHeaderStr, responseContent);
        }
    }

    /**
     * 图片上传特定
     *
     * @param request
     * @return
     * @throws WxErrorException
     */
    public WxMediaUploadResult uploadMedia(WxMediaUploadRequest request) throws WxErrorException {
        String sha256;
        File file = request.getFile();
        try {
            InputStream data = new FileInputStream(file);
            request.setFilename(file.getName());
            sha256 = DigestUtil.sha256Hex(data);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.FILE_ERROR);
        }
        request.setSha256(sha256);

        String token = checkAndSignAndGetToken(request);
        String requestUrl = getServerUrl() + request.routing();

        boolean hasError = false;
        String requestHeaderStr = null;
        String responseHeaderStr = null;
        HttpStatus httpStatus = null;
        String responseContent = null;
        long begin = System.currentTimeMillis();
        try {
            RestTemplate restClient = getRestClient();
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE);
            requestHeaders.set("Authorization", getSchema() + " " + token);
            ByteArrayOutputStream output = getRequestByteArray(request);

            requestHeaderStr = requestHeaders.toString();

            HttpEntity<byte[]> requestEntity = new HttpEntity<>(output.toByteArray(), requestHeaders);
            ResponseEntity<String> responseEntity = restClient.exchange(requestUrl, request.getHttpMethod(), requestEntity, String.class);

            httpStatus = responseEntity.getStatusCode();
            HttpHeaders responseHeaders = responseEntity.getHeaders();
            responseContent = responseEntity.getBody();

            responseHeaderStr = responseHeaders.toString();

            // 校验签名
            if (request.isCheckSign()) {
                checkResult(responseHeaders, responseContent);
            }

            return BaseWxPayV3Result.fromJson(responseContent, request.getResultClass());
        } catch (Exception e) {
            String errMsg = e.getMessage();
            if (e instanceof HttpStatusCodeException) {
                HttpStatusCodeException e1 = (HttpStatusCodeException) e;
                httpStatus = e1.getStatusCode();
                errMsg = e1.getMessage() + e1.getResponseBodyAsString();
            }
            log.error(errMsg, e);
            hasError = true;
            throw new WxErrorException(WxErrorExceptionFactor.HTTP_REQUEST_FAIL_CODE, errMsg);
        } finally {
            log.warn("wxpay url: {}\n" +
                            "request header: \n{}\n" +
                            "wxpay request {}, cost time: {}, http status code: {}\n" +
                            "response header: \n{}\n" +
                            "response content: \n{}",
                    requestUrl, requestHeaderStr, hasError ? "failed" : "succeeded", System.currentTimeMillis() - begin, httpStatus, responseHeaderStr, responseContent);
        }

    }

    private ByteArrayOutputStream getRequestByteArray(WxMediaUploadRequest request) throws WxErrorException {
        StringBuffer sb1 = new StringBuffer();
        sb1.append("--boundary").append("\r\n")
                .append("Content-Disposition: form-data; name=\"meta\";").append("\r\n")
                .append("Content-Type: application/json").append("\r\n")
                .append("\r\n")
                .append(request.toJsonString()).append("\r\n")
                .append("--boundary").append("\r\n")
                .append("Content-Disposition: form-data; name=\"file\"; filename=\"").append(request.getFilename()).append("\";").append("\r\n");
        if (request.isImageFile()) {
            sb1.append("Content-Type: image/jpg");
        } else if (request.isVideoFile()) {
            sb1.append("Content-Type: video/mp4");
        } else {
            throw new WxErrorException(WxErrorExceptionFactor.FILE_ERROR);
        }
        sb1.append("\r\n")
                .append("\r\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("\r\n")
                .append("--boundary--").append("\r\n");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            output.write(sb1.toString().getBytes());
            output.write(IOUtils.toByteArray(new FileInputStream(request.getFile())));
            output.write(sb2.toString().getBytes());
            return output;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.FILE_ERROR);
        }
    }


    /**
     * 验签
     *
     * @param responseHeaders
     * @param responseContent
     * @throws WxErrorException
     */
    private void checkResult(HttpHeaders responseHeaders, String responseContent) throws WxErrorException {
        SignatureHeader header = SignatureHeader.newBuilder()
                .timestamp(responseHeaders.getFirst("Wechatpay-Timestamp"))
                .nonce(responseHeaders.getFirst("Wechatpay-Nonce"))
                .signature(responseHeaders.getFirst("Wechatpay-Signature"))
                .serialNo(responseHeaders.getFirst("Wechatpay-Serial"))
                .signatureType(responseHeaders.getFirst("Wechatpay-Signature-Type"))
                .build();

        if (!verifySignature(header, responseContent)) {
            throw new WxErrorException(WxErrorExceptionFactor.CHECK_SIGN_ERROR);
        }
    }

    /**
     * 校验签名
     *
     * @param header
     * @param responseContent
     * @return
     * @throws WxErrorException
     */
    public boolean verifySignature(SignatureHeader header, String responseContent) throws WxErrorException {
        if (ObjectUtil.isNull(header) || StringUtils.isAnyBlank(header.getTimestamp(), header.getNonce(), header.getSignature(), header.getSerialNo())) {
            return false;
        }
        if (StringUtils.isBlank(responseContent)) {
            responseContent = "";
        }

        StringBuilder toSign = new StringBuilder();
        toSign.append(header.getTimestamp()).append("\n")
                .append(header.getNonce()).append("\n")
                .append(responseContent).append("\n");

        if (!this.wxPayConfig.getVerifier().verify(getWxCertificate(header.getSerialNo()), toSign.toString(), header.getSignature())) {
            return false;
        }
        return true;
    }

    /**
     * 校验并转换成实体类
     *
     * @param header
     * @param responseContent
     * @param clz
     * @param <T>
     * @return
     * @throws WxErrorException
     */
    public <T extends BaseWxPayV3Result> WxNotifyResult verifyNotifySignatureAndGetResult(SignatureHeader header, String responseContent, Class<T> clz) throws WxErrorException {
        if (!verifySignature(header, responseContent)) {
            throw new WxErrorException(WxErrorExceptionFactor.CHECK_SIGN_ERROR);
        }
        WxNotifyResult wxNotifyResult = BaseWxPayV3Result.fromJson(responseContent, WxNotifyResult.class);
        if (ObjectUtil.isNull(wxNotifyResult) || ObjectUtil.isNull(wxNotifyResult.getResource())) {
            throw new WxErrorException(WxErrorExceptionFactor.NOTIFY_CONTENT_ERROR);
        }

        WxNotifyResult.Resource resource = wxNotifyResult.getResource();
        wxNotifyResult.setWxPayResult(BaseWxPayV3Result.fromJson(this.wxPayConfig.getAuthCipher().decrypt(resource.getNonce(), resource.getAssociatedData(), resource.getCipherText()), clz));

        return wxNotifyResult;
    }

    /**
     * 获取 RestTemplate
     *
     * @return
     */
    private RestTemplate getRestClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.build();
        OkHttp3ClientHttpRequestFactory requestFactory = new OkHttp3ClientHttpRequestFactory(okHttpClient);
        requestFactory.setConnectTimeout(this.connectTimeout);
        requestFactory.setReadTimeout(this.readTimeout);

        RestTemplate restClient = new RestTemplate(requestFactory);
        restClient.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        return restClient;
    }

    /**
     * 获取请求头
     *
     * @param token
     * @param idempotencyKey
     * @return
     */
    private HttpHeaders getRequestHeaders(String token, String idempotencyKey) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
        requestHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        requestHeaders.set("Authorization", getSchema() + " " + token);
        if (!StringUtils.isBlank(this.wxSerialNo)) {
            requestHeaders.set("Wechatpay-Serial", this.wxSerialNo);
        }
        if (!StringUtils.isBlank(idempotencyKey)) {
            requestHeaders.set("Idempotency-Key", idempotencyKey);
        }
        return requestHeaders;
    }

}
