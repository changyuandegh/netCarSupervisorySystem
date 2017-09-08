package com.netcar.dao;

import com.netcar.dataModle.ShowGps;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public interface NetDevicegpsDAO {
    /**
     * 根据车牌号、起止时间查询终端历史轨迹
     * @param vehicleno
     * @param starttime
     * @param endtime
     * @return
     */
    List<ShowGps> findByTime(String vehicleno, String starttime, String endtime);
}
