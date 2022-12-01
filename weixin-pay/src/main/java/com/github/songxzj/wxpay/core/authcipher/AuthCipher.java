package com.github.songxzj.wxpay.core.authcipher;

import com.github.songxzj.common.exception.WxErrorException;

public interface AuthCipher {

    /**
     * 解密
     */
    String decrypt(String nonce, String associatedData, String cipherText) throws WxErrorException;
}
