package com.fhhk.utils;

public class ResultVo<T> {
    private String message;
    private int code;
    private T data;

    public ResultVo() {
    }

    public ResultVo(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    /**
     * 获取
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "ResultVo{message = " + message + ", code = " + code + ", data = " + data + "}";
    }
}
