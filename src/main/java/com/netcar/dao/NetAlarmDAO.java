package com.netcar.dao;

import com.netcar.dataModle.*;
import com.netcar.entity.*;

import java.sql.Date;
import java.util.List;

/**
 * Created by Wby on 2017/5/10.
 * 报警数据库操作接口
 */
public interface NetAlarmDAO {

    /**
     * 获取一段时间内报警统计
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @return
     */
    List<SOSStatisticsData> getSOSStatistics(String addressCode, String stTime, String endTime);

    /**
     * @param addressCode
     * @param stTime
     * @param endTime
     * @param alarmType
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    List getAlarmAllByType(String addressCode, Date stTime, Date endTime, int alarmType, int limit, int offset, String sort);

    int getAlarmAllByTypeCount(String addressCode, Date stTime, Date endTime, int alarmType);


    /**
     * 获取一段时间的聚集报警
     *
     * @param addressCode
     * @param stTime
     * @param endTime
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    List<OutageAlarmData> getNetOutagealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort);

    int getNetOutagealarmCount(String addressCode, Date stTime, Date endTime);


    /**
     * 获取一段时间的司机报警
     *
     * @param addressCode
     * @param stTime
     * @param endTime
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    List<DriverSOSData> getNetDriversosalarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort);

    int getNetDriversosCount(String addressCode, Date stTime, Date endTime);

    /**
     * 获取一段时间内重点区域报警
     *
     * @param addressCode
     * @param stTime
     * @param endTime
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    List<KeyAreaData> getNetKeyareaalarmalarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort);

    int getNetKeyareaalarmCount(String addressCode, Date stTime, Date endTime);

    /**
     * 获取一段时间的围栏报警信息
     *
     * @param addressCode
     * @param stTime
     * @param endTime
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    List<ElectricfenceAlarmData> getNetElectricfencealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort);

    int getNetElectricfencealarmCount(String addressCode, Date stTime, Date endTime);

    /**
     * 获取一段时间跨区经营报警
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    List<OperatealarmData> getNetOperatealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort);

    int getNetOperatealarmCount(String addressCode, Date stTime, Date endTime);


    /**
     * 获取一段时间的聚集报警
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    List<NetAggregationalarm> getAggregationalarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort);

    int getAggregationalarmCount(String addressCode, Date stTime, Date endTime);
//

    /**
     * 获取一段时间的出城报警
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    List<OuttownalarmData> getNetOuttownalarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort);

    int getNetOuttownalarmCount(String addressCode, Date stTime, Date endTime);


    /**
     * 获取一段时间内的分离报警
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    List<SeparatealarmData> getNetSeparatealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort);

    int getNetSeparatealarmCount(String addressCode, Date stTime, Date endTime);


    /**
     * 获取一段时间内的计价异常
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    List<PricealarmData> getNetPricealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort);

    int getNetPricealarmCount(String addressCode, Date stTime, Date endTime);


    /**
     * 获取报警类型
     *
     * @return
     */
    List<NetAlarmtype> getAlarmType();

    NetAlarmtype getAlarmType(int type);

    /**
     * 获取报警位置
     *
     * @param areaCode  区划
     * @param tablename 报警表名
     * @param stTime    开始时间
     * @param emdTime   结束时间
     * @return
     */
    List<ThermalPoint> getAlarmPoint(String areaCode, String tablename, String stTime, String emdTime);

    /**
     * 修改用户订阅的报警
     *
     * @param userid     用户id
     * @param alarmTypes 报警id
     * @return
     */
    boolean updateAlarmSubscription(int userid, List<Integer> alarmTypes);

    /**
     * 获取用户订阅的报警
     *
     * @param userid
     * @return
     */
    List<NetAlarmsubscription> getAlarmSubscription(int userid);

    List<NetAlarmtype> getAlarmTypeBySubscription(int userid);


    /**
     * 获取当日报警
     * @param areaCode
     * @return
     */
    List<NetTodayalarm> getTodayAlarmAll(String areaCode,int limit, int offset, String sort);

    int getTodayAlarmAllCount(String areaCode);



    /**
     * 获取当日报警
     * @param areaCode
     * @return
     */
    int getTodayAlarmAllCount(String areaCode,String alarmType);
    List<NetTodayalarm> getTodayAlarmAll(String areaCode,String alarmType,int limit,int offset,String sort);

}
