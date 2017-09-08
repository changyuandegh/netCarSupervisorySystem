package com.netcar.dao;

import com.netcar.dataModle.*;
import com.netcar.entity.NetOrderstatistics;

import java.util.Date;
import java.util.List;

/**
 * Created by wbj on 2017/5/16.
 */
public interface NetStatisticsDAO {

    /**
     * 获取首页订单统计信息（实时）
     * @param areaCode
     * @param stTime
     * @param endTime
     * @return
     */
    StatisticsNumData getOrderStatistics(String areaCode, Date stTime, Date endTime);

    /**
     * 获取各公司订单统计信息 1天24小时
     * @param areaCode 区划代码
     * @param stTime 开始时间
     * @param endTime 结束时间
     */
    List<OrderStatisticsData> getCompanyOrderStatistics(String areaCode, Date stTime, Date endTime);

    /**
     * 获取各时间段统计信息
     * @param areaCode
     * @param stTime
     * @param endTime
     * @return
     */
    List<OrderStatisticsData> getTimeOrderStatistics(String areaCode, Date stTime, Date endTime);

    /**
     * 获取当日报警数
     * @return
     */
    int getTodayAlarmNum(String areaCode);

    /**
     * 获取司机注册数
     * @return
     */
    int getDriverRegisterNum(String areaCode);

    /**
     * 获取乘客注册数
     * @return
     */
    int getPassengerRegisterNum();

    /**
     * 获取车辆在线率
     * @return
     */
    int getCarOnlineRate(String areaCode);

    /**
     * 获取重载率
     * @return
     */
    int getGetonRate(String areaCode);


    /**
     * 获取司机签到率
     * @return
     */
    int getSigninRate(String areaCode);


    /**
     * 获取用户活跃度
     * @return
     */
    int getActiveRate(String areaCode, Date stTime, Date endTime);

    /**
     * 获取订单热力图点
     * @param stTime
     * @param endTime
     * @return
     */
    List<ThermalPoint> getOrderThermalPoint(String areaCode, Date stTime, Date endTime);

    /**
     * 获取司机位置热力图点
     * @param stTime
     * @param endTime
     * @return
     */
    List<ThermalPoint> getDriverThermalPoint(String areaCode, Date stTime, Date endTime);

    /**
     * 获取乘客位置热力图点
     * @param stTime
     * @param endTime
     * @return
     */
    List<ThermalPoint> getPassengerThermalPoint(String areaCode, Date stTime, Date endTime);
}
