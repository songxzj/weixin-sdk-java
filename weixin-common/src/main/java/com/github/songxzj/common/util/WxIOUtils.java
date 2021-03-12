package com.github.songxzj.common.util;

import cn.hutool.core.util.ObjectUtil;

import java.nio.charset.StandardCharsets;

public class WxIOUtils {

    public static String bytesToString(byte[] bytes) {
        if (ObjectUtil.isNull(bytes)) {
            return null;
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
