package com.netcar.serviceImpl;

import com.netcar.service.NetCarGpsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Work on 2017/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetGpsServiceImplTest {

    @Autowired
    NetCarGpsService netCarGpsServiceImpl;

    @Test
    public void findGPSByAreacodeVehicleno() throws Exception {
    }

    @Test
    public void findGPSByAreacode() throws Exception {
        netCarGpsServiceImpl.findGPSByAreacode("410101");
    }

    @Test
    public void findGPSByAreaComapny() throws Exception {
        netCarGpsServiceImpl.findGPSByAreaCompany("410000", "111");
    }

}