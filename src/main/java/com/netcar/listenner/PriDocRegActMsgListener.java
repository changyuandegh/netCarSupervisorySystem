package com.netcar.listenner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by Mander on 2017/4/12.
 */
public class PriDocRegActMsgListener implements MessageListener {

  private RedisTemplate redisTemplate;





  public RedisTemplate getRedisTemplate(){
    return redisTemplate;
  }

  public void setRedisTemplate(RedisTemplate redisTemplate){
    this.redisTemplate=redisTemplate;
  }

  public PriDocRegActMsgListener(RedisTemplate redisTemplate){
    this.redisTemplate=redisTemplate;
  }

  public PriDocRegActMsgListener(){

  }

  //订阅端接收消息
  @Override
  public void onMessage(Message message, byte[] bytes){
    System.out.println("message="+message);
  }
}
