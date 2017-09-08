package com.netcar.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mander on 2017/5/18.
 */
public interface RedisDAO {


    String  findString(String key);


    Map<Object,Object> findHash(String key);


}
