package com.netcar.listenner;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

/**
 * Created by Mander on 2017/4/12.
 */
public class RegisterMessageListener implements MessageListener {


  private RedisTemplate redisTemplate;

  public RedisTemplate getRedisTemplate(){
    return redisTemplate;
  }

  public void setRedisTemplate(RedisTemplate redisTemplate){
    this.redisTemplate=redisTemplate;
  }

  @Override
  public void onMessage(Message message, byte[] bytes){
    System.out.println(message.toString());
    byte[] body = message.getBody();// 请使用valueSerializer
    byte[] channel = message.getChannel();
    // 参考配置文件，本例中key，value的序列化方式均为string。
    // 其中key必须为stringSerializer。和redisTemplate.convertAndSend对应
    String msgContent = (String) redisTemplate.getValueSerializer().deserialize(body);
    String topic = (String) redisTemplate.getStringSerializer().deserialize(channel);
    System.out.println(topic + ":" + msgContent);
    Map<String, String> map = new Gson().fromJson(msgContent, Map.class);
    String from = map.get("from");

  }



}
