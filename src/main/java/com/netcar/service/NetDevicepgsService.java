package com.netcar.service;

import com.netcar.dataModle.ShowGps;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Mander on 2017/5/8.
 * 定位和历史轨迹接口
 */

public interface NetDevicepgsService {



    /**
     * 根据GPS编号查询deviceid
     * @param deviceid 设备编号
     * @param startTime 开始时间yyyy-MM-dd HH:mm:ss
     * @param endTime 结束时间yyyy-MM-dd HH:mm:ss
     * @return
     */
    List<ShowGps> findGpsby(String deviceid,String startTime,String endTime);





}
