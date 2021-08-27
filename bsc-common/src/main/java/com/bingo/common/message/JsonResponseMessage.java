package com.bingo.common.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 涉及Serializable
 * 报文统一封装，方便报文接收，有助于功能分离，JSON格式
 * 添加公共字段，比如错误信息，TOKEN认证信息
 */
@Data
public class JsonResponseMessage<T>{

    public static final long serializableUID = 1L;

    @ApiModelProperty(value = "流水号", required = true)
//    @NotNull(message = "[uid] {tile.notNull}") //
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

    public T getBody(){
        return body;
    }
    public void setBody(T body){
        this.body = body;
    }

    public JsonResponseMessage (T body,String code,String desc){
        this.body = body;
        this.code = code;
        this.desc = desc;
    }

    public <t> JsonResponseMessage<T> build(MessageHeader header){
        return new JsonResponseMessage<>(null,header.code,header.desc);
    }
    public <t> JsonResponseMessage<T> build(T body, MessageHeader header){
        return new JsonResponseMessage<>(body,header.code,header.desc);
    }
    public <t> JsonResponseMessage<T> build(String code,String desc){
        return new JsonResponseMessage<>(null,code,desc);
    }
    public <t> JsonResponseMessage<T> build(T body,String code,String desc){
        return new JsonResponseMessage<>(body,code,desc);
    }

    protected enum MessageHeader
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
        public String getCode(){ return code; }
        public String getDesc(){ return desc; }

        @Override
        public String toString() {
            return "{ 'code': '" + code + "', 'desc': '" + desc + "' }";
        }
    }
}
