package com.netcar.serviceImpl;

import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.ProportionData;
import com.netcar.service.NetAlarmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Work on 2017/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetAlarmServiceImplTest {

    @Autowired
    NetAlarmService netAlarmServiceImpl;

    @Test
    public void getProportionAlarmType() throws Exception {
        List<ProportionData> list = netAlarmServiceImpl.getProportionAlarmType("410000", 1);
        System.out.println("结果 --- > " + list.size());
        for (ProportionData data :
                list) {
            System.out.println(data.toString());
        }
    }

    @Test
    public void getProportionCompanyAlarm() throws Exception {
    }

    @Test
    public void getThermalPointAlarm() throws Exception {
    }

    @Test
    public void getAlarmByTypeTime() throws Exception {
    }

}