package com.web.onlineLibrary.base.exception;

import lombok.Getter;

/**
 * @author TCW
 * 统一运行时异常处理
 */
@Getter
public class ServiceException extends RuntimeException {

    private int code;
    private String message;
    private Object data;

    public ServiceException(Object data, String message) {
        this.code = 400;
        this.message = message;
        this.data = data;
    }

    public ServiceException(Object data, String message, int code) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ServiceException(String message) {
        this.code = 400;
        this.message = message;
    }

    public ServiceException(String message, int code) {
        this.code = code;
        this.message = message;
    }



}
