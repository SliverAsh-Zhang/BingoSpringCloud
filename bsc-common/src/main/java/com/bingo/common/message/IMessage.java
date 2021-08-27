package com.bingo.common.message;

import java.io.Serializable;

public interface IMessage<T> extends Serializable {
  /**
   * 报文唯一标识
   * @return 唯一标识
   */
  String getUid();
  /**
   * 报文加密字符串
   * @return 加密后的字符串
   */
  String getSecretId();
  /**
   * 报文消息体
   * @return 报文消息体
   */
  T getBody();
}
