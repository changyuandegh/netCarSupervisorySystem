package com.netcar.listenner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by Mander on 2017/4/12.
 * 发布端
 */
public class PublishClient {

  @Autowired
  private RedisTemplate redisTemplate;



  /**
   * 发布客户端
   * @param channel 频道
   * @param message 消息
   */
  public void publish(String channel,String message){
    redisTemplate.convertAndSend(channel,message);
  }




}
