package com.ricemarch.cms.pms.common.facade;

import com.ricemarch.cms.pms.common.enums.BizEnum;
import com.ricemarch.cms.pms.common.enums.BizErrorCodeEnum;

import java.io.Serializable;

/**
 * @author RiceMarch
 * @date 2021/3/7 16:23
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private T data;

    /**
     * 成功返回 无结果
     */
    public BaseResponse() {
        this(BizErrorCodeEnum.SUCCESS, BizErrorCodeEnum.SUCCESS.getDesc());
    }

    /**
     * 错误返回
     *
     * @param errorCode 错误枚举类型
     */
    public BaseResponse(BizEnum errorCode) {
        this(errorCode, errorCode.getDesc());
    }

    /**
     * 成功返回
     *
     * @param data 携带数据
     */
    public BaseResponse(T data) {
        this(BizErrorCodeEnum.SUCCESS, BizErrorCodeEnum.SUCCESS.getDesc(), data);
    }

    /**
     * 错误返回
     *
     * @param errorCode 错误代码
     * @param message   错误信息
     */
    public BaseResponse(BizEnum errorCode, String message) {
        this(errorCode, message, null);
    }

    public BaseResponse(BizEnum errorCode, String message, T data) {
        this.code = errorCode.getCode();
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

