package com.github.songxzj.wxpay.core.signer;

import com.github.songxzj.common.exception.WxErrorException;

public interface Signer {

    /**
     * 生成签名结果
     *
     * @param message
     * @return
     * @throws WxErrorException
     */
    String sign(String message) throws WxErrorException;

    /**
     * 获取签名算法
     */
    String getAlgorithm();
}
