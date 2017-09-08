package com.netcar.daoImpl;

import com.netcar.dao.NetElectricfenceDAO;
import com.netcar.dao.NetOrderDAO;
import com.netcar.dao.NetStatisticsDAO;
import com.netcar.dataModle.OrderPoint;

import com.netcar.dataModle.OrderStatisticsData;
import com.netcar.dataModle.StatisticsNumData;
import com.netcar.dataModle.ThermalPoint;
import com.netcar.entity.NetElectricfence;
import com.netcar.entity.NetOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml", "classpath:spring-dispatcher-servlet.xml"})
public class NetOrderDAOImplTest {

    @Autowired
    private NetOrderDAO netOrderdaoImpl;

    @Autowired
    private NetElectricfenceDAO netElectricfenceDAOImpl;

    @Autowired
    private NetStatisticsDAO netStatisticsDAOImpl;

    @Test
    public void findBycar() throws Exception{
        List<NetOrder> list = netOrderdaoImpl.findBycar("豫AT0001", "2017-05-09 12:15:00", "2017-05-09 17:15:00");
        System.out.print("\n\n 结果数 -- > " + list.size()+"\n");
        for(int i=0; i<list.size(); i++){
            System.out.println("carNum:"+list.get(i).getVehicleno()+" orderId:"+list.get(i).getOrderid());
        }
    }

    @Test
    public void findOrderPointsByorderid() throws Exception{
        List<OrderPoint> list = netOrderdaoImpl.findOrderPointsByorderid("10000001234");
        System.out.print("\n\n 结果数 -- > " + list.size()+"\n");
        for(int i=0; i<50; i++){
            System.out.println("lng:"+list.get(i).getLng()+" lat:"+list.get(i).getLat()+" time"+list.get(i).getLocTime());
        }
    }

    @Test
    public void findNetElectricfence() throws Exception{


        List<NetElectricfence> list = netElectricfenceDAOImpl.findAll("000000", 10, 0);
        System.out.print("\n\n 结果数 -- > " + list.size()+"\n");
        for(int i=0; i<list.size(); i++){
            //System.out.println("id:"+list.get(i).getId()+" name:"+list.get(i).getName());
            System.out.println("item:"+list.get(i).toString());
        }


        NetElectricfence item = list.get(2);
        item.setName("测试围栏11");
        //netElectricfenceDAOImpl.add(item);
        netElectricfenceDAOImpl.update(item);
        //netElectricfenceDAOImpl.delete(list.get(2));

        list = netElectricfenceDAOImpl.findAll("000000", 10, 0);
        System.out.print("\n\n 结果数 -- > " + list.size()+"\n");
        for(int i=0; i<list.size(); i++){
            //System.out.println("id:"+list.get(i).getId()+" name:"+list.get(i).getName());
            System.out.println("item:"+list.get(i).toString());
        }

    }

    @Test
    public void StatisticsTest() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse("2017-05-01");
        Date endDate = format.parse("2017-06-01");

        StatisticsNumData numData = netStatisticsDAOImpl.getOrderStatistics("410000", startDate, endDate);
        System.out.println("numData:"+numData.toString());
        System.out.println("========================");

        List<OrderStatisticsData> list = netStatisticsDAOImpl.getCompanyOrderStatistics("410000", startDate, endDate);
        if (list!=null && list.size()>0){
            System.out.println(list.toString());
        } else {
            System.out.println("could not found company order statistics data.");
        }
        System.out.println("========================");

        List<OrderStatisticsData> list1 = netStatisticsDAOImpl.getTimeOrderStatistics("410000", startDate, endDate);
        if (list1!=null && list1.size()>0){
            System.out.println(list1.toString());
        } else {
            System.out.println("could not found time order statistics data.");
        }
        System.out.println("========================");

        System.out.println("alarmNum:"+netStatisticsDAOImpl.getTodayAlarmNum("410000"));
        System.out.println("========================");
        System.out.println("DriverRegisterNum:"+netStatisticsDAOImpl.getDriverRegisterNum("410000"));
        System.out.println("========================");
        System.out.println("PassengerRegisterNum:"+netStatisticsDAOImpl.getPassengerRegisterNum());
        System.out.println("========================");
        System.out.println("getGetonRate:"+netStatisticsDAOImpl.getGetonRate("410000"));
        System.out.println("========================");
        System.out.println("getSigninRate:"+netStatisticsDAOImpl.getSigninRate("410000"));
        System.out.println("========================");
        System.out.println("getActiveRate:"+netStatisticsDAOImpl.getActiveRate("410000", startDate, endDate));
        System.out.println("========================");
        List<ThermalPoint> list2 = netStatisticsDAOImpl.getOrderThermalPoint("410000", startDate, endDate);
        if (list2!=null && list2.size()>0){
            for(int i=0;i<list2.size(); i++) {
                System.out.println("point:lng:" + list2.get(i).getLng().toString()+" lat:"+ list2.get(i).getLat().toString());
            }
        } else {
            System.out.println("could not found time order statistics data.");
        }
    }

}
