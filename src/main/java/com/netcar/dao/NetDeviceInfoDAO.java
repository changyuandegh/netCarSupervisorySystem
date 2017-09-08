package com.netcar.dao;

import com.netcar.dataModle.ShowDevice;
import com.netcar.entity.NetDevice;

import java.util.List;

/**
 * Created by Wby on 2017/5/4.
 * 终端数据库操作接口类
 */
public interface NetDeviceInfoDAO {


    /**
     * 根据字段参数查询
     *
     * @param address 行政区划代码
     * @param sort    排序字段名
     * @param limit   总条数
     * @param offset  开始条数
     * @return
     */
    List<ShowDevice> findAll(String address, String sort, int limit, int offset);

    int findAllCount(String address);

    /**
     * 根据车辆信息查询终端
     *
     * @param address 行政区划代码
     * @param param   字段名
     * @param value   字段值
     * @param sort    排序字段名
     * @param limit   总条数
     * @param offset  开始条数
     * @return
     */
    List<ShowDevice> findByCarInfo(String address, String param, String value, String sort, int limit, int offset);

    int findByCarInfoCount(String address, String param, String value);

    /**
     * 添加终端信息
     *
     * @param info 终端信息
     * @param num  绑定车牌
     * @return
     */
   // boolean add(NetDeviceInfo info, String num);


    boolean add(NetDevice info, String num);


    boolean saveDevice(NetDevice device);

    boolean edit(NetDevice netDevice);

    boolean delete(String deviceid);



}
