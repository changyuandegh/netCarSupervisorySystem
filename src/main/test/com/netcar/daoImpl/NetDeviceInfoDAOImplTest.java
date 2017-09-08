package com.netcar.daoImpl;

import com.netcar.dao.NetDeviceInfoDAO;
import com.netcar.dataModle.ShowDevice;
import com.netcar.entity.NetDevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wby on 2017/5/4.
 * 终端数据库操作测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetDeviceInfoDAOImplTest {

    @Autowired
    NetDeviceInfoDAO netDeviceInfoDAOImpl;

    @Test
    public void findAll() throws Exception {
        List<ShowDevice> list = netDeviceInfoDAOImpl.findAll("410000", "deviceid", 1, 0);
        System.out.println(" 结果数 -- > " + list.size() + " : " + list.toString());
    }

    @Test
    public void findAllCount() throws Exception {
        System.out.println(" 结果数 -- > " + netDeviceInfoDAOImpl.findAllCount("410000"));
    }

    @Test
    public void findByCarInfo() throws Exception {
        List<ShowDevice> list = netDeviceInfoDAOImpl.findByCarInfo("410000", "vehicleno", "豫C12345", "deviceid", 1, 0);
        System.out.println(" 结果数 -- > " + list.size() + " : " + list.toString());

    }

    @Test
    public void findByCarInfoCount() throws Exception {
        System.out.println(" 结果数 -- > " + netDeviceInfoDAOImpl.findByCarInfoCount("410000", "vehicleno", "豫C12345"));
    }

//    @Test
//    public void add() throws Exception {
//        NetDeviceInfo info = new NetDeviceInfo();
//        info.setDeviceid(222222222);
//        info.setBrand("厂商1");
//        info.setModel("x220");
//        info.setImei("222222222");
//        info.setSim("13300000000");
//        info.setInstalldate(new Date());
//        info.setCreatetime(Timestamp.valueOf("2017-05-04 16:20:00"));
//        info.setUpdatetime(Timestamp.valueOf("2017-05-04 16:20:00"));
//        System.out.println("结果 -- > " + netDeviceInfoDAOImpl.add(info, "豫AT0002"));
//    }豫AT0002

    @Test
    public void add() throws Exception {
        NetDevice device = new NetDevice();
        device.setDeviceid(100000129);
        device.setBrand("厂商1000");
        device.setModel("UN02");
        device.setImei("10000000012");
        device.setSim("1330090900");
        device.setCreatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
        device.setUpdatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
        //netDeviceInfoDAOImpl.add(device,"豫AT0010");
        boolean reg= netDeviceInfoDAOImpl.saveDevice(device);
        System.out.println(reg);
    }



    @Test
    public void edit() throws Exception {
        NetDevice device = new NetDevice();
        device.setDeviceid(100000001);
        device.setBrand("厂商2");
        device.setModel("xx2");
        device.setImei("10000000013");
        device.setSim("1330090901");
        device.setCreatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
        device.setUpdatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
        netDeviceInfoDAOImpl.edit(device);
    }

    @Test
    public void delete() throws Exception {
        netDeviceInfoDAOImpl.delete("100000001");
    }
}