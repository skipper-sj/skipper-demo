package com.skipper.api.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skipper.api.common.enums.ApiResponseCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 统一返回结果实体
 *
 * Created by shoujian on 2017/5/8.
 */
public class Result<T> implements Serializable{

    private static final long serialVersionUID = 4573661725819000001L;

    /**
     * 错误码
     */
    private Integer code = ApiResponseCode.SUCCESS.get();

    /**
     * 返回结果描述
     */
    private String message;

    /**
     * 返回结果数据
     */
    private T data;

    /**
     * 返回结果时间
     */
    private String serverTime;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        setServerTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public static <T> Result<T> createSuccess(){
        return createSuccess(null);
    }


    public static <T> Result<T> createSuccess(T t){
        return createSuccess(t, null);
    }

    public  static <T> Result<T> createSuccess(T t,String message){
        return new Result<T>(ApiResponseCode.SUCCESS.get(), message, t);
    }

    public static <T> Result<T> createFail(Integer code, String message) {
        return new Result<T>(code, message, null);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }
}
