package com.netcar.service;

import com.netcar.dataModle.ProportionData;
import com.netcar.dataModle.ShowOrderStatistics;
import com.netcar.dataModle.StatisticsNumData;
import com.netcar.dataModle.ThermalPoint;

import java.util.Date;
import java.util.List;

/**
 * Created by Wby on 2017/5/16.
 * 统计类服务
 */
public interface NetStatisticsService {

    /**
     * 获取首页订单统计信息
     *
     * @param areaCode
     * @param stTime
     * @param endTime
     * @return
     */
    ShowOrderStatistics getOrderStatistics(String areaCode, Date stTime, Date endTime);


    /**
     * 获取各统计数量
     *
     * @return
     */
    StatisticsNumData getStatisticsNum(String areaCode);


    int getOnlineNum(String areaCode);

    /**
     * 报警数
     * @param areaCode
     * @return
     */
    int getAlarmNum(String areaCode);

    /**
     * 在线率
     */
    ProportionData getOnlineProportion(String areaCode);


    /**
     * 获取司机重载比例
     * @param areaCode
     * @return
     */
    ProportionData getOperationProportion(String areaCode);

    /**
     * 获取司机签到比例
     * @param areaCode
     * @return
     */
    ProportionData getSignProportion(String areaCode);


    /**
     * 获取用户活跃度
     *
     * @return
     */
    ProportionData getUserLiveness(String areaCode);


    /**
     * 获取订单位置点（预计上车点）
     *
     * @param areaCode
     * @param stTime
     * @param endTime
     * @return
     */
    List<ThermalPoint> getOrderPoint(String areaCode, Date stTime, Date endTime);

    /**
     * 获取乘客位置点（热力图）
     * @param areaCode
     * @param stTime
     * @param endTime
     * @return
     */
    List<ThermalPoint> getPsgPotin(String areaCode, Date stTime, Date endTime);

    /**
     * 获取司机位置点（热力图）
     * @param areaCode
     * @param stTime
     * @param endTime
     * @return
     */
    List<ThermalPoint> getDriverPotin(String areaCode, Date stTime, Date endTime);
}
