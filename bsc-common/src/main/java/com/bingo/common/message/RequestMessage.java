package com.bingo.common.message;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

//@Data //公共类不建议用lombok，否则会强制引用方使用lombok插件
public class RequestMessage<T> {

    @ApiModelProperty(value = "uid",required = true)
    private String uid;

    @ApiModelProperty(value = "token",required = true)
    private String token;

    @ApiModelProperty(value = "请求报文体",required = true)
    protected T body;

    public RequestMessage(){}

    public RequestMessage(T body){
        this.body = body;
    }
    public static <T> RequestMessage<T> build(T body){
        RequestMessage<T> requestMessage = new RequestMessage<>(body);
        requestMessage.uid = UUID.randomUUID().toString();
        return requestMessage;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }
}
