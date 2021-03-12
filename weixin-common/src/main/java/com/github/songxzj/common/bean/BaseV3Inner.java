package com.github.songxzj.common.bean;

import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.util.WxBeanUtils;

import java.io.Serializable;

public abstract class BaseV3Inner implements Serializable {
    private static final long serialVersionUID = -108105094738133587L;


    /**
     * 检查约束情况.
     *
     * @throws WxErrorException the wx pay exception
     */
    public abstract void checkConstraints() throws WxErrorException;

    public <T extends BaseV3Inner> T finalBuild() {
        if (WxBeanUtils.isAllFieldNull(this)) {
            return null;
        }
        return (T) this;

    }
}
