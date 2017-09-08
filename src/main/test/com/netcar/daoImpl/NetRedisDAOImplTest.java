package com.netcar.daoImpl;

import com.netcar.dao.NetRedisDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Work on 2017/5/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetRedisDAOImplTest {

    @Autowired
    NetRedisDAO redisDAOImpl;

    @Test
    public void getOnlineDevice() throws Exception {
        int num = redisDAOImpl.getOnlineDevice("410101");
        System.out.println("在线数 -- > " + num);
    }

    @Test
    public void getDeviceLocation() throws Exception {

        redisDAOImpl.getDeviceLocation("410000");
//        System.out.println("终端数 -- > " + list.size());
    }

}