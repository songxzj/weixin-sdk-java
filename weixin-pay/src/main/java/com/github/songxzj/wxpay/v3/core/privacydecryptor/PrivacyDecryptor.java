package com.github.songxzj.wxpay.v3.core.privacydecryptor;

import com.github.songxzj.common.exception.WxErrorException;

public interface PrivacyDecryptor {


    /**
     * 敏感信息解密
     *
     * @param ciphertextObject
     * @return
     * @throws WxErrorException
     */
    Object decrypt(Object ciphertextObject) throws WxErrorException;
}
