package com.skipper.helper.exception;


import com.skipper.helper.enums.ApiResponseCode;

/**
 * 自定义抛错类型
 *
 * Created by shoujian on 2017/5/8.
 */
public class SkipperException extends RuntimeException {

    private static final long serialVersionUID = 4983697260674492941L;

    private Integer code;

    private String message;

    public SkipperException(Integer code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 自定义抛错
     * @param apiResponseCode 错误码
     */
    public static void fail(ApiResponseCode apiResponseCode) {
        throw new SkipperException(apiResponseCode.get(), apiResponseCode.getName());
    }

    /**
     * 自定义抛错
     * @param code 抛错码
     *
     */
    public static void fail(Integer code) {
        throw new SkipperException(code, ApiResponseCode.getNameByCode(code));
    }

    /**
     * 自定义抛错
     * @param apiResponseCode 错误码
     * @param message 错误描述内容
     */
    public static void fail(ApiResponseCode apiResponseCode, String message) {
        throw new SkipperException(apiResponseCode.get(), message == null ? apiResponseCode.getName() : message);
    }

    /**
     * 自定义抛错
     *
     * @param code 错误码
     * @param message 错误描述内容
     */
    public static void fail(Integer code, String message) {
        throw new SkipperException(code, message == null ? ApiResponseCode.getNameByCode(code) : message);
    }

    /**
     * 自定义空抛错
     *
     * @param obj 需要验证的数据
     * @param message   错误描述内容
     */
    public static void isNull(Object obj, String message) {
        if (obj == null || obj.equals("")) {
            throw new SkipperException(ApiResponseCode.PARA_NIL.get(), message);
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
