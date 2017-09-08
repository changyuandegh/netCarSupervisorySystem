package com.netcar.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Work on 2017/5/18.
 */
public interface NetRedisDAO {

    String findString(String key);


    Map<Object, Object> findHash(String key);




    Set findKey(String key);


    int getOnlineDevice(String areaCode);

    List<Map<Object, Object>> getDeviceLocation(String areaCode);

    List<Map<Object, Object>> getDeviceLocationByCompany(String areaCode, String companyId);

}
