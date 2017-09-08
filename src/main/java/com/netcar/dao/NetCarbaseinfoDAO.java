package com.netcar.dao;

import com.netcar.entity.NetCarbaseinfo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
public interface NetCarbaseinfoDAO {

    /**
     * 根据字段参数查询
     * @param address 行政区划代码
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    List<NetCarbaseinfo> findAll(String address, String sort, int limit, int offset);


    /**
     * 根据字段参数查询
     * @param address 行政区划代码
     * @param parm 字段名
     * @param value 字段值
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    List<NetCarbaseinfo> findByParm(String address,String parm,String value, String sort, int limit,int offset);
    List<NetCarbaseinfo> findByParm(String address,String parm,String value, String sort);



    /**
     *
     * @param address 行政区划代码
     * @return
     */
    int findAllCount(String address);

    /**
     *
     * @param address 行政区划代码
     * @param parm 字段名
     * @param value 字段值
     * @return
     */
    int findByParmCount(String address, String parm,String value);


    /**
     * 通过车牌号查询车辆信息
     * @param address 行政区划代码
     * @param vehicleno 车牌号
     * @return
     */
    NetCarbaseinfo findByCarNum(String address, String vehicleno);

    List<HashMap<String,Object>> findVehiclePhoto(String companyidc);
}
