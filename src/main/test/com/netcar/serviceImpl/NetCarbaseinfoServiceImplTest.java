package com.netcar.serviceImpl;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.Cardriver;
import com.netcar.dataModle.ShowGps;
import com.netcar.entity.NetCarbaseinfo;
import com.netcar.entity.NetElectricfence;
import com.netcar.service.NetCarbaseinfoService;
import com.netcar.service.NetCompanybaseinfoService;
import com.netcar.service.NetElectricfenceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetCarbaseinfoServiceImplTest {

    @Autowired
    private NetCarbaseinfoService netCarbaseinfoServiceImpl;

    @Autowired
    private NetElectricfenceService netElectricfenceServiceImpl;

    @Autowired
    private NetCompanybaseinfoService netCompanybaseinfoServiceImpl;

    @Test
    public void findAll() throws Exception {
        BaseTable<NetCarbaseinfo> baseTable = netCarbaseinfoServiceImpl.findAll("410000", "driverid", 100, 0);

        for (int i=0; i<baseTable.getRows().size(); i++){
            System.out.println(" total:"+baseTable.getTotal()+" carNum:" + baseTable.getRows().get(i).getVehicleno()+ " owner:"+baseTable.getRows().get(i).getOwnername());
        }

    }

    @Test
    public void findAllByParm() throws Exception {
        BaseTable<NetCarbaseinfo> baseTable = netCarbaseinfoServiceImpl.findByParm("410000", "ownername", "王", "driverid", 10, 0);
        for (int i=0; i<baseTable.getRows().size(); i++){
            System.out.println(" total:"+baseTable.getTotal()+" carNum:" + baseTable.getRows().get(i).getVehicleno()+ " owner:"+baseTable.getRows().get(i).getOwnername());
        }

    }

    @Test
    public void findbyVehicleno() throws Exception {
        String carNum = "豫AT0001";
        Cardriver cardriver = netCarbaseinfoServiceImpl.findbyVehicleno("410000", carNum, "2017-05-09 12:15:00", "2017-05-09 16:15:00");
        if (cardriver != null) {
            System.out.println("carNum:" + cardriver.getVehicleno());
            System.out.println("model:" + cardriver.getModel());
            System.out.println("vehiclecolor:" + cardriver.getVehiclecolor());
            for (int i = 0; i < cardriver.getDriverList().size(); i++) {
                System.out.println("driver:" + cardriver.getDriverList().get(i).getDrivername()
                        + " gender:" + cardriver.getDriverList().get(i).getDrivergender()
                        + " id:" + cardriver.getDriverList().get(i).getLicenseid()
                        + " time:" + cardriver.getDriverList().get(i).getContracton());
            }
        } else {
            System.out.println("\nCould not found the car:" + carNum+"!!!");
        }
    }

    @Test
    public void getDevicePgs() throws Exception{
        List<ShowGps> gps = netCarbaseinfoServiceImpl.getDevicePgs("豫AT0001", "2017-05-08 00:00:00", "2017-05-09 15:00:00");
        if (gps != null) {
            System.out.println("gps size:" + gps.size());
            for (int i = 0; i < gps.size(); i++) {
                System.out.println("lng:" + gps.get(i).getLng() + " lat:" + gps.get(i).getLat() + " speed:" + gps.get(i).getSpeed() + " time:" + gps.get(i).getTime());
            }
        } else {
            System.out.println("\nCould not found location data of the car!!!");
        }
    }


    @Test
    public void findNetElectricfence() throws Exception{


        BaseTable table = netElectricfenceServiceImpl.findAll("000000", 10, 0);
        System.out.print("\n\n 结果数 -- > " + table.getTotal()+"\n");
        for(int i=0; i<table.getRows().size(); i++){
            System.out.println("item:"+((NetElectricfence)table.getRows().get(i)).toString());
        }


        NetElectricfence item = (NetElectricfence)table.getRows().get(2);
        item.setName("测试围栏1");
        //netElectricfenceDAOImpl.add(item);
        netElectricfenceServiceImpl.update(item);
        //netElectricfenceDAOImpl.delete(list.get(2));

        table = netElectricfenceServiceImpl.findAll("000000", 10, 0);
        System.out.print("\n\n 结果数 -- > " + table.getTotal()+"\n");
        for(int i=0; i<table.getRows().size(); i++){
            System.out.println("item:"+((NetElectricfence)table.getRows().get(i)).toString());
        }

    }

    @Test
    public void findCarIdName() throws Exception{
        List<AjaxMessage> list = netCarbaseinfoServiceImpl.findidNameby("410000", "豫AT0002");
        if (list != null && list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("id:" + list.get(i).getName()
                        + " name:" + list.get(i).getDesc());
            }
        } else {
            System.out.println("\nCould not found the car!!!");
        }
    }

    @Test
    public void findCompanyIdName() throws Exception{
        List<AjaxMessage> list = netCompanybaseinfoServiceImpl.findidNameByareacode("410000");
        if (list != null && list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("id:" + list.get(i).getName()
                        + " name:" + list.get(i).getDesc());
            }
        } else {
            System.out.println("\nCould not found the company!!!");
        }
    }
}
