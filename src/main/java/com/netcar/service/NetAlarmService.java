package com.netcar.service;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.ProportionData;
import com.netcar.dataModle.ThermalPoint;

import java.util.Date;

import com.netcar.entity.NetAlarmsubscription;
import com.netcar.entity.NetAlarmtype;

import java.util.List;

/**
 * Created by Mander on 2017/5/10.
 * 报警业务
 */
public interface NetAlarmService {


    /**
     * 获取各个报警类型占比
     *
     * @param areacode  地区编码
     * @param cycleTime 可能值: 1(月),2(周),3(日)
     * @return
     */
    List<ProportionData> getProportionAlarmType(String areacode, int cycleTime);


    /**
     * 获取各个公司报警占比
     *
     * @param areacode  地区编码
     * @param cycleTime 可能值: 1(月),2(周),3(日)
     * @return
     */
    List<ProportionData> getProportionCompanyAlarm(String areacode, int cycleTime);


    //{"lng":116.418261,"lat":39.921984,"count":50},

    /**
     * 获取各报警的位置点,(用于报警热力图)
     *
     * @param areacode  地区编码
     * @param cycleTime 可能值: 1(月),2(周),3(日)
     * @return
     */
    List<ThermalPoint> getThermalPointAlarm(String areacode, int cycleTime);


    /**
     * 按报警类型获取时间段的报警信息
     *
     * @param areacode    地区编码
     * @param alarmTypeid 报警类型id
     * @param starttme    开始时间
     * @param endtime     结束时间
     * @return
     */
    BaseTable getAlarmByTypeTime(String areacode, int alarmTypeid, Date starttme, Date endtime, String sort, int limit, int offset);


    /**
     * 查询所有报警类型
     *
     * @return
     */
    List<NetAlarmtype> findAllAlarmType();

    /**
     * 修改订阅
     *
     * @param userid     用户id
     * @param alarmTypes 报警类型id集合
     */
    boolean updateAlarmSubscription(int userid, List<Integer> alarmTypes);


    /**
     * 获取订阅信息
     *
     * @param userid 用户id
     * @return
     */
    List<NetAlarmsubscription> getAlarmSubscription(int userid);

    /**
     * 获取订阅的报警
     * @param userid 用户id
     * @return
     */
    List<NetAlarmtype> getAlarmTypeBySubscription(int userid);


    /**
     * 获取当日报警
     *
     * @param areaCode
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    BaseTable getTodayAlarm(String areaCode, int limit, int offset, String sort);



    BaseTable getTodayAlarm(String areaCode,String alarmType, int limit, int offset, String sort);



}
