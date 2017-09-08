package com.netcar.service;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.Cardriver;
import com.netcar.dataModle.ShowGps;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mander on 2017/5/3.
 */
public interface NetCarbaseinfoService {


    /**
     * 根据字段参数查询
     * @param address 行政区划代码
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    BaseTable findAll(String address, String sort, int limit, int offset);


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
    BaseTable findByParm(String address,String parm,String value,String sort,int limit,int offset);




    /**
     * 查询该时间段的司机,车辆信息
     * @param vehicleno 车牌号
     * @param starttime 开始时间
     * @param endtime  结束时间
     * @return
     */
    Cardriver findbyVehicleno(String address, String vehicleno, String starttime, String endtime);



    List<ShowGps> getDevicePgs(String vehicleno, String starttime, String endtime);


    /**
     * 按地区查询车牌
     * @param aracode
     * @param vehicleno
     * AjaxMessage.id=carid;
     * AjaxMessage.name=vehicleno;
     * @return
     */
    List<AjaxMessage> findidNameby(String aracode,String vehicleno);


    List<HashMap<String,Object>> findVehiclePhoto(String companyidc);
}
