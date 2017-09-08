package com.netcar.daoImpl;

import com.netcar.dao.NetDriversigninDAO;
import com.netcar.entity.NetDriversignin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetDriversigninDAOImplTest {

    @Autowired
    private NetDriversigninDAO netDriversigninDAOImpl;

    @Test
    public void findByCarTime() throws Exception{
        List<NetDriversignin> list = netDriversigninDAOImpl.findByCarTime("豫AT0001", "2017-05-09 12:15:00", "2017-05-09 13:15:00");
        System.out.print("\n\n 结果数 -- > " + list.size()+"\n");
        for(int i=0; i<list.size(); i++){
            System.out.print("carNum:"+list.get(i).getVehicleno()+" start:"+list.get(i).getOntime()+" end:"+list.get(i).getOuttime()+"\n");
        }
    }
}
