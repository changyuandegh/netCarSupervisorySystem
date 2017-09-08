package com.netcar.service;

import com.netcar.entity.NetOrder;

import java.util.List;

/**
 * Created by Mander on 2017/5/8.
 *订单接口
 */
public interface Order {


    //根据车牌.时间查询
    List<NetOrder> findBy(String vehicleno, String starttime, String endtime);

}
