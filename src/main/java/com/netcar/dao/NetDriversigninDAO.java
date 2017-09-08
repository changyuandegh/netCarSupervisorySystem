package com.netcar.dao;

import com.netcar.entity.NetDriversignin;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public interface NetDriversigninDAO {

    /**
     * 根据车牌号、起止时间查询司机签到信息
     * @param vehicleno
     * @param starttime
     * @param endtime
     * @return
     */
    List<NetDriversignin> findByCarTime(String vehicleno, String starttime, String endtime);

}
