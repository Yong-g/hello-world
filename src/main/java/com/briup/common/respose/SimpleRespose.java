package com.briup.common.respose;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *  code   0 成功  1 失败
 *
 * @param <T>
 */
public class SimpleRespose<T> {

    private  T body;

    private String message;

    private String code;

    private Date time;

    public SimpleRespose(T body, String message, String code, Date time) {
        this.body = body;
        this.message = message;
        this.code = code;
        this.time = new Date();
    }

    public SimpleRespose(T body) {
        this.body = body;
        this.message = null;
        this.code = "0";
        this.time = new Date();
    }

    public SimpleRespose(T body,String message,String code){
        this.body = body;
        this.message = message;
        this.code = code;
        this.time = new Date();
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @JsonFormat(pattern = "yyyy/MM/dd")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
