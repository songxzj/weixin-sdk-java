package com.github.songxzj.common.exception;

import java.io.Serializable;

public class WxErrorException extends Exception implements Serializable {

    private static final long serialVersionUID = 6954409258001549414L;

    private String errorCode;

    public WxErrorException() {
    }

    public WxErrorException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public WxErrorException(WxErrorExceptionFactor exceptionFactor) {
        super(exceptionFactor.getErrorMessage());
        this.errorCode = exceptionFactor.getErrorCode();
    }
}
