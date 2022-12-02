package com.github.songxzj.wxpay.util;


import cn.hutool.core.io.IoUtil;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.tencent.kona.KonaProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

@Slf4j
public class CertKeyUtils {

    static {
        Security.addProvider(new KonaProvider());
    }

    /*private static final int TAG_LENGTH_BIT = 128;
    private static final String CIPHER_PROVIDER = "SunJCE";
    private static final String TRANSFORMATION_NoPadding = "AES/GCM/NoPadding";
    private static final String ALGORITHM = "AES";*/


    /**
     * 平台证书解密 （v2）
     *
     * @param apiv3Key
     * @return
     * @throws Exception
     */
    /*public static WxPayCertificate decryptCertificate(String apiv3Key, WxPayCertificate wxPayCertificate) throws WxErrorException {
        try {
            WxPayCertificate.EncryptCertificate encryptCertificate = wxPayCertificate.getEncryptCertificate();

            final Cipher cipher = Cipher.getInstance(TRANSFORMATION_NoPadding, CIPHER_PROVIDER);
            SecretKeySpec key = new SecretKeySpec(apiv3Key.getBytes(), ALGORITHM);
            GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH_BIT, encryptCertificate.getNonce().getBytes());
            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            cipher.updateAAD(encryptCertificate.getAssociatedData().getBytes());
            wxPayCertificate.setCertificateStr(new String(cipher.doFinal(Base64Utils.decodeFromString(encryptCertificate.getCipherText()))));
            return wxPayCertificate;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.DECRYPT_CERTIFICATE_ERROR);
        }
    }*/

    /**
     * 加载 v3 商户密钥
     *
     * @param inputStream
     * @return
     * @throws WxErrorException
     */
    public static PrivateKey loadPrivateKey(InputStream inputStream) throws WxErrorException {
        String privateKeyStr = IoUtil.readUtf8(inputStream);
        return loadPrivateKey(privateKeyStr);
    }

    /**
     * 加载 v3 商户密钥
     *
     * @param privateKeyStr
     * @return
     * @throws WxErrorException
     */
    public static PrivateKey loadPrivateKey(String privateKeyStr) throws WxErrorException {
        try {
            String privateKey = getReplacePrivateKey(privateKeyStr);

            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(new PKCS8EncodedKeySpec(Base64Utils.decodeFromString(privateKey)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.KEY_ERROR_ERROR);
        }
    }


    /**
     * 加载 v3 商户密钥
     *
     * @param inputStream
     * @return
     * @throws WxErrorException
     */
    public static PrivateKey loadPrivateKey(InputStream inputStream, String algorithm, String provider) throws WxErrorException {
        String privateKeyStr = IoUtil.readUtf8(inputStream);
        return loadPrivateKey(privateKeyStr, algorithm, provider);
    }

    /**
     * 从字符串中加载指定算法的私钥
     *
     * @param privateKeyStr 私钥字符串
     * @param algorithm     私钥算法
     * @param provider      the provider
     * @return 私钥
     */
    public static PrivateKey loadPrivateKey(String privateKeyStr, String algorithm, String provider) throws WxErrorException {
        try {
            String privateKey = getReplacePrivateKey(privateKeyStr);

            KeyFactory kf = KeyFactory.getInstance(algorithm, provider);
            return kf.generatePrivate(new PKCS8EncodedKeySpec(Base64Utils.decodeFromString(privateKey)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchProviderException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.KEY_ERROR_ERROR);
        }
    }

    private static String getReplacePrivateKey(String privateKeyStr) {
        return privateKeyStr
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");
    }


    /**
     * 加载证书
     *
     * @param inputStream
     * @return
     * @throws WxErrorException
     */
    public static X509Certificate loadCertificate(InputStream inputStream) throws WxErrorException {
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inputStream);
            cert.checkValidity();
            return cert;
        } catch (CertificateException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.KEY_FILE_ERROR);
        }
    }

    /**
     * 加载证书
     *
     * @param certificateStr
     * @return
     * @throws WxErrorException
     */
    public static X509Certificate loadCertificate(String certificateStr) throws WxErrorException {
        return loadCertificate(new ByteArrayInputStream(certificateStr.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * 加载证书
     *
     * @param inputStream
     * @return
     * @throws WxErrorException
     */
    public static X509Certificate loadCertificate(InputStream inputStream, String provider) throws WxErrorException {
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X509", provider);
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inputStream);
            cert.checkValidity();
            return cert;
        } catch (CertificateException | NoSuchProviderException e) {
            log.error(e.getMessage(), e);
            throw new WxErrorException(WxErrorExceptionFactor.KEY_FILE_ERROR);
        }
    }

    /**
     * 加载证书
     *
     * @param certificateStr
     * @return
     * @throws WxErrorException
     */
    public static X509Certificate loadCertificate(String certificateStr, String provider) throws WxErrorException {
        return loadCertificate(new ByteArrayInputStream(certificateStr.getBytes(StandardCharsets.UTF_8)), provider);
    }


    /**
     * 从配置路径 加载文件 信息（classpath、本地路径、网络url）
     *
     * @param filePath 配置路径
     * @return
     * @throws WxErrorException
     */
    public static InputStream loadInputStream(String filePath) throws WxErrorException {
        InputStream inputStream;
        if (filePath.startsWith("http://") || filePath.startsWith("https://")) {
            try {
                inputStream = new URL(filePath).openStream();
                if (inputStream == null) {
                    throw new WxErrorException(WxErrorExceptionFactor.KEY_FILE_NOT_EXIST);
                }
            } catch (IOException e) {
                throw new WxErrorException(WxErrorExceptionFactor.KEY_FILE_NOT_EXIST);
            }
        } else {
            try {
                inputStream = new FileInputStream(ResourceUtils.getFile(filePath));
            } catch (FileNotFoundException e) {
                log.error(e.getMessage(), e);
                throw new WxErrorException(WxErrorExceptionFactor.KEY_FILE_NOT_EXIST);
            }
        }
        return inputStream;
    }

}
