package com.bingo.common.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * 序列化，泛型，枚举
 * 报文统一封装，方便报文接收，有助于功能分离，JSON格式
 * 添加公共字段，比如错误信息，TOKEN认证信息
 */

public class ResponseMessage<T> implements Serializable{

    public static final long serializableUID = 1L;

    @ApiModelProperty(value = "流水号", required = true)
    private String uid;

    @ApiModelProperty(value = "token", required = true)
    @JsonIgnore
    private String token;

    @ApiModelProperty(value = "返回码", required = true)
    private String code;

    @ApiModelProperty(value = "返回描述", required = true)
    private String desc;

    @ApiModelProperty(value = "报文体", required = true)
    public T body;

    public ResponseMessage(){}

    public ResponseMessage(T body, String code, String desc){
        this.body = body;
        this.code = code;
        this.desc = desc;
    }

    public static <T> ResponseMessage<T> build(T body){
        return build(body,MessageHeader.SUCCESS);
    }
    public static <T> ResponseMessage<T> build(MessageHeader header){
        return build(null,header);
    }
    public static <T> ResponseMessage<T> build(T body, MessageHeader header){
        return build(body,header.code,header.desc);
    }
    public static <T> ResponseMessage<T> build(String code, String desc){
        return build(null,code,desc);
    }
    public static <T> ResponseMessage<T> build(T body, String code, String desc){
        return new ResponseMessage<>(body,code,desc);
    }

    public enum MessageHeader
    {
        SUCCESS("0000","success"),
        PARAMS_VALID_ERROR("1000","请求参数验证错误"),
        PARAMS_FORMAT_ERROR("1001", "请求参数格式转换错误"),
        SERVER_ERROR("2000", "server error"),
        EMPTY_DATA("2001", "empty data");

        @ApiModelProperty(value = "返回码", required = true)
        private String code;

        @ApiModelProperty(value = "返回描述", required = true)
        private String desc;

        MessageHeader(String code, String desc){
            this.code = code;
            this.desc = desc;
        }
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

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }
}
