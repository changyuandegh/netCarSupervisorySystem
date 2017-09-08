package com.netcar.service;

import com.netcar.dataModle.BaseTable;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface NetDriverOnlineTimeService {

    public BaseTable findOnlinTime(String search,String  stime,String etime,String company,String areacode);
}
