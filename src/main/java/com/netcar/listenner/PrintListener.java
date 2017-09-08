package com.netcar.listenner;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.apache.commons.lang.builder.ToStringBuilder;
import redis.clients.jedis.JedisPubSub;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Mander on 2017/4/12.
 * 订阅器监听器
 */
public class PrintListener  {


  public void handleMessage(Serializable message) {
    //什么都不做,只输出
    if(message == null){
      System.out.println("null");
    } else if(message.getClass().isArray()){
      System.out.println(Arrays.toString((Object[]) message));
    } else if(message instanceof List<?>) {
      System.out.println(message);
    } else if(message instanceof Iterators.Map<? , ?>) {
      System.out.println(message);
    } else {
      System.out.println(ToStringBuilder.reflectionToString(message));
      System.out.println(message);
    }
  }



}
