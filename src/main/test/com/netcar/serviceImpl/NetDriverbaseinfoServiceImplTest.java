package com.netcar.serviceImpl;

import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.service.NetDriverbaseinfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Work on 2017/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetDriverbaseinfoServiceImplTest {

    @Autowired
    private NetDriverbaseinfoService netDriverbaseinfoServiceImpl;

    @Test
    public void findAll() throws Exception {
        BaseTable<NetDriverbaseinfo> baseTable = netDriverbaseinfoServiceImpl.findAll("410000", "driverid", 1, 0);
        System.out.print(" reslut num -- > " + baseTable.getTotal() + baseTable.getRows().get(0).getDrivername());
    }

    @Test
    public void findAllByParm() throws Exception {
        BaseTable<NetDriverbaseinfo> baseTable = netDriverbaseinfoServiceImpl.findAllByParm("410000", "drivername", "张三", "driverid", 1, 0);
        System.out.print(" reslut num -- > " + baseTable.getTotal() + baseTable.getRows().get(0).getDrivername());

    }

}