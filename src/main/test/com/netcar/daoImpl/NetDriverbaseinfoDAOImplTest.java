package com.netcar.daoImpl;

import com.netcar.dao.NetDriverbaseinfoDAO;
import com.netcar.entity.NetDriverbaseinfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Work on 2017/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetDriverbaseinfoDAOImplTest {

    @Autowired
    private NetDriverbaseinfoDAO netDriverbaseinfoDAOImpl;

//    @Before
//    public void setUp() throws Exception {
//        netDriverbaseinfoDAOImpl = new NetDriverbaseinfoDAOImpl();
//    }


    @Test
    public void findAll() throws Exception {
        List<NetDriverbaseinfo> list = netDriverbaseinfoDAOImpl.findAll("410101", "driverid", 1, 0);
        System.out.print("\n\n\n\n 结果数 -- > " + list.size() );
        for (NetDriverbaseinfo info : list) {
            System.out.print("\n" + info.getDrivername() + info.getAddress());
        }
    }

    @Test
    public void findAllByParm() throws Exception {
        List<NetDriverbaseinfo> list = netDriverbaseinfoDAOImpl.findAllByParm("410000", "drivername", "张三", "driverid", 1, 0);
        System.out.print("\n\n\n\n 结果数 -- > " + list.size());
        for (NetDriverbaseinfo info : list) {
            System.out.print("\n" + info.getDrivername() + info.getAddress());
        }

    }

    @Test
    public void findAllCount() throws Exception {
        System.out.print("\n\n\n\n 结果数 -- > " + netDriverbaseinfoDAOImpl.findAllCount("410000"));
    }

    @Test
    public void findAllByParmCount() throws Exception {
        System.out.print("\n\n\n\n 结果数 -- > " + netDriverbaseinfoDAOImpl.findAllByParmCount("410101","drivername","张三"));
    }
}