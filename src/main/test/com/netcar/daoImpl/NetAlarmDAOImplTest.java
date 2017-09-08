package com.netcar.daoImpl;

import com.netcar.dao.NetAlarmDAO;
import com.netcar.dataModle.*;
import com.netcar.entity.NetAggregationalarm;
import com.netcar.entity.NetAlarmsubscription;
import com.netcar.entity.NetAlarmtype;
import com.netcar.entity.NetDriversos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Work on 2017/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetAlarmDAOImplTest {

    @Autowired
    NetAlarmDAO netAlarmDAOImpl;

    @Test
    public void getSOSStatistics() throws Exception {
    }

    @Test
    public void getAlarmAllByType() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<NetDriversos> list = netAlarmDAOImpl.getAlarmAllByType("410000", stDate, endDate, 1, 10, 0, "id");
        System.out.println("结果 -- 》" + list.size());
        System.out.println(list.get(0).toString());
    }

    @Test
    public void getAlarmAllByTypeCount() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        int i = netAlarmDAOImpl.getAlarmAllByTypeCount("410000", stDate, endDate, 1);
        System.out.println("count -- > " + i);
    }

    @Test
    public void getAlarmType() throws Exception {
    }

    @Test
    public void getAlarmType1() throws Exception {
    }

    @Test
    public void getAlarmPoint() throws Exception {
    }

    @Test
    public void getAlarmSubscription() throws Exception {
        List<NetAlarmsubscription> list = netAlarmDAOImpl.getAlarmSubscription(1);
        System.out.println("结果 -- > size :" + list.size());
    }

    @Test
    public void getAlarmTypeBySubscription() throws Exception {
        List<NetAlarmtype> list = netAlarmDAOImpl.getAlarmTypeBySubscription(2);
        System.out.println("结果 --- > " + list.size());
        for (NetAlarmtype type :
                list) {
            System.out.println(type.toString());
        }
    }

    @Test
    public void updateAlarmSubscription() throws Exception {
        List<Integer> alarmIdList = new ArrayList<>();
        alarmIdList.add(2);
        alarmIdList.add(3);
        alarmIdList.add(4);
        alarmIdList.add(7);
        alarmIdList.add(8);
        netAlarmDAOImpl.updateAlarmSubscription(2, alarmIdList);
    }

    @Test
    public void getNetOutagealarm() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<OutageAlarmData> list = netAlarmDAOImpl.getNetOutagealarm("410100", stDate, endDate, 10, 0, "id");
        System.out.println("结果 -- > " + list.size());
        System.out.println(list.get(0).toString());
    }

    @Test
    public void getNetOutagealarmCount() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        int count = netAlarmDAOImpl.getNetOutagealarmCount("410000", stDate, endDate);
        System.out.println("结果 ---> " + count);
    }


    @Test
    public void getNetDriversosalarm() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<DriverSOSData> list = netAlarmDAOImpl.getNetDriversosalarm("410101", stDate, endDate, 10, 0, "id");
        System.out.println("结果 -- > " + list.size());
        System.out.println(list.get(0).toString());
    }

    @Test
    public void getNetDriversosalarmCount() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        int count = netAlarmDAOImpl.getNetDriversosCount("410100", stDate, endDate);
        System.out.println("结果 ---> " + count);
    }

    @Test
    public void getNetKeyareaalarmalarm() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<KeyAreaData> list = netAlarmDAOImpl.getNetKeyareaalarmalarm("410101", stDate, endDate, 10, 0, "id");
        System.out.println("结果 -- > " + list.size());
        System.out.println(list.get(0).toString());
    }


    @Test
    public void getNetKeyareaalarmCount() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        int count = netAlarmDAOImpl.getNetKeyareaalarmCount("410101", stDate, endDate);
        System.out.println("结果 ---> " + count);
    }


    @Test
    public void getNetElectricfencealarm() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<ElectricfenceAlarmData> list = netAlarmDAOImpl.getNetElectricfencealarm("410100", stDate, endDate, 10, 0, "id");
        System.out.println("结果 -- > " + list.size());
        System.out.println(list.get(0).toString());
    }

    @Test
    public void getNetOperatealarm() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<OperatealarmData> list = netAlarmDAOImpl.getNetOperatealarm("410300", stDate, endDate, 10, 0, "id");
        System.out.println("结果 -- > " + list.size());
        System.out.println(list.get(0).toString());
    }

    @Test
    public void getAggregationalarm() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<NetAggregationalarm> list = netAlarmDAOImpl.getAggregationalarm("410100", stDate, endDate, 10, 0, "id");
        System.out.println("结果 -- > " + list.size());
        System.out.println(list.get(0).toString());
    }

    @Test
    public void getNetOuttownalarm() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<OuttownalarmData> list = netAlarmDAOImpl.getNetOuttownalarm("410000", stDate, endDate, 10, 0, "id");
        System.out.println("结果 -- > " + list.size());
        System.out.println(list.get(0).toString());
    }

    @Test
    public  void getNetSeparatealarm() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<SeparatealarmData> list = netAlarmDAOImpl.getNetSeparatealarm("410100", stDate, endDate, 10, 0, "id");
        System.out.println("结果 -- > " + list.size());
        System.out.println(list.get(0).toString());
    }

    @Test
    public void getNetPricealarm() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-05-02");
        java.sql.Date stDate = new java.sql.Date(date.getTime());
        java.sql.Date endDate = new java.sql.Date(System.currentTimeMillis());
        List<PricealarmData> list = netAlarmDAOImpl.getNetPricealarm("410000", stDate, endDate, 10, 0, "id");
        System.out.println("结果 -- > " + list.size());
        System.out.println(list.get(0).toString());
    }
}