package com.netcar.serviceImpl;

import com.netcar.dao.NetDriverOnlineTimeDAO;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.DriverOnlineTime;
import com.netcar.service.NetDriverOnlineTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 司机在线时长
 * Created by Administrator on 2017/6/13.
 */
@Service
public class NetDriverOnlineTimeServiceImpl implements NetDriverOnlineTimeService{

    @Autowired
    private NetDriverOnlineTimeDAO netDriverOnlineTimeDAOImpl;

    @Override
    public BaseTable findOnlinTime(String search, String stime, String etime, String company, String areacode) {
        BaseTable baseTable=new BaseTable();
        DateFormat dateFormat=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date date=new Date();
        List<DriverOnlineTime> driverOnlineTimeList=new ArrayList<DriverOnlineTime>();
        DriverOnlineTime driverOnlineTime=new DriverOnlineTime();
        driverOnlineTime.setEquipment("IE0028965");
        driverOnlineTime.setCompany("久久出行");
        driverOnlineTime.setLicense("豫A123");
        driverOnlineTime.setDrivername("张三");
        driverOnlineTime.setEarlytime(dateFormat.format(date));
        driverOnlineTime.setEndtime(dateFormat.format(date));
        driverOnlineTime.setOnlinetime(120);
        DriverOnlineTime driverOnlineTime1=new DriverOnlineTime("IE003445","豫A8888","娃娃鱼","滴滴出行",
                dateFormat.format(date),dateFormat.format(date),68);
        DriverOnlineTime driverOnlineTime2=new DriverOnlineTime("Iw0WW445","豫A00000","橡皮妮","久久出行1",
                dateFormat.format(date),dateFormat.format(date),240);
        DriverOnlineTime driverOnlineTime3=new DriverOnlineTime("IE00sa","豫A4321","儿童劫","滴滴出行",
                dateFormat.format(date),dateFormat.format(date),68);
        DriverOnlineTime driverOnlineTime4=new DriverOnlineTime("Iw0Wwqwq","豫A5566","鱼尾纹","曹操专车",
                dateFormat.format(date),dateFormat.format(date),214);
        DriverOnlineTime driverOnlineTime5=new DriverOnlineTime("IE00ds","豫A9456","小学僧","久久出行",
                dateFormat.format(date),dateFormat.format(date),168);
        DriverOnlineTime driverOnlineTime6=new DriverOnlineTime("Iw0WW34","豫A4356","喜之螂","久久出行1",
                dateFormat.format(date),dateFormat.format(date),240);
        DriverOnlineTime driverOnlineTime7=new DriverOnlineTime("IE0552","豫A3443","托儿索","滴滴出行",
                dateFormat.format(date),dateFormat.format(date),232);
        DriverOnlineTime driverOnlineTime8=new DriverOnlineTime("Iw0W122","豫A3355","提款姬","曹操专车",
                dateFormat.format(date),dateFormat.format(date),456);
        DriverOnlineTime driverOnlineTime9=new DriverOnlineTime("IE0034","豫A8060","鸡毛信","穷克出行",
                dateFormat.format(date),dateFormat.format(date),22);
        driverOnlineTimeList.add(driverOnlineTime);
        driverOnlineTimeList.add(driverOnlineTime1);
        driverOnlineTimeList.add(driverOnlineTime2);
        driverOnlineTimeList.add(driverOnlineTime3);
        driverOnlineTimeList.add(driverOnlineTime4);
        driverOnlineTimeList.add(driverOnlineTime5);
        driverOnlineTimeList.add(driverOnlineTime6);
        driverOnlineTimeList.add(driverOnlineTime7);
        driverOnlineTimeList.add(driverOnlineTime8);
        driverOnlineTimeList.add(driverOnlineTime9);
        baseTable.setRows(driverOnlineTimeList);
        baseTable.setTotal(driverOnlineTimeList.size());
        return baseTable;
    }
}
