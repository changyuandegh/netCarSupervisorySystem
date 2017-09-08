package com.netcar.serviceImpl;

import com.netcar.dao.NetCarbaseinfoDAO;
import com.netcar.dao.NetDevicegpsDAO;
import com.netcar.dao.NetDriverbaseinfoDAO;
import com.netcar.dao.NetDriversigninDAO;
import com.netcar.dataModle.*;
import com.netcar.dataModle.Driver;
import com.netcar.entity.NetCarbaseinfo;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.entity.NetDriversignin;
import com.netcar.service.NetCarbaseinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class NetCarbaseinfoServiceImpl implements NetCarbaseinfoService {


    @Autowired
    private NetCarbaseinfoDAO NetCarbaseinfodaoImpl;

    @Autowired
    private NetDriversigninDAO netDriversignindaoImpl;

    @Autowired
    private NetDriverbaseinfoDAO netDriverbaseinfodaoImpl;

    @Autowired
    private NetDevicegpsDAO netDevicegpsdaoImpl;

    @Override
    public BaseTable findAll(String address, String sort, int limit, int offset) {
        BaseTable baseTable = new BaseTable();
        List<NetCarbaseinfo> list = NetCarbaseinfodaoImpl.findAll(address, sort, limit, offset);
        if (list!=null) {
            baseTable.setTotal(NetCarbaseinfodaoImpl.findAllCount(address));
            baseTable.setRows(list);
        } else {
            baseTable.setTotal(0);
        }
        return baseTable;
    }

    @Override
    public BaseTable findByParm(String address, String parm, String value, String sort, int limit, int offset) {
        BaseTable baseTable = new BaseTable();
        List<NetCarbaseinfo> list = NetCarbaseinfodaoImpl.findByParm(address, parm, value, sort, limit, offset);
        if (list!=null) {
            baseTable.setTotal(NetCarbaseinfodaoImpl.findByParmCount(address, parm, value));
            baseTable.setRows(list);
        } else {
            baseTable.setTotal(0);
        }
        return baseTable;
    }





    /**
     *查询该时间段的司机,车辆信息
     * @param vehicleno
     * @return
     */
    @Override
    public Cardriver findbyVehicleno(String address, String vehicleno, String starttime, String endtime) {
        Cardriver cardriver = new Cardriver();

        //查询车辆信息
        NetCarbaseinfo car = NetCarbaseinfodaoImpl.findByCarNum(address, vehicleno);
        if (car != null) {
            cardriver.setVehicleno(car.getVehicleno());
            cardriver.setModel(car.getModel());
            cardriver.setVehiclecolor(car.getVehiclecolor());

            //查询司机信息（查询签到表时间段内的司机）
            List<Driver> drivers = new ArrayList<>();
            List<NetDriversignin> signins = netDriversignindaoImpl.findByCarTime(vehicleno, starttime, endtime);
            List<NetDriverbaseinfo> driverbaseinfos;
            Map<String, NetDriversignin> driverMap = new HashMap<>();
            for(int i=0; i<signins.size(); i++){
                if (!driverMap.containsKey(signins.get(i).getLicenseid())){
                    driverMap.put(signins.get(i).getLicenseid(), signins.get(i));
                    driverbaseinfos = netDriverbaseinfodaoImpl.findAllByParm("000000", "licenseid", signins.get(i).getLicenseid(), "driverid", 10,0);
                    if (driverbaseinfos!=null && driverbaseinfos.size()>0){
                        Driver driver = new Driver();
                        driver.setLicenseid(driverbaseinfos.get(0).getLicenseid());
                        driver.setDrivername(driverbaseinfos.get(0).getDrivername());
                        driver.setDrivergender(driverbaseinfos.get(0).getDrivergender());
                        driver.setContracton(driverbaseinfos.get(0).getContracton());
                        drivers.add(driver);
                    }
                }
            }
            cardriver.setDriverList(drivers);
            return cardriver;
        } else {
            return null;
        }
    }

    /**
     * 查询gps信息
     * @param vehicleno
     * @param starttime
     * @param endtime
     * @return
     */
    @Override
    public List<ShowGps> getDevicePgs(String vehicleno, String starttime, String endtime) {
        List<ShowGps> gps;
        gps = netDevicegpsdaoImpl.findByTime(vehicleno, starttime, endtime);
        return gps;
    }

    @Override
    public List<AjaxMessage> findidNameby(String aracode, String vehicleno) {
        List<AjaxMessage> list = new ArrayList<>();
        NetCarbaseinfo carInfo = NetCarbaseinfodaoImpl.findByCarNum(aracode, vehicleno);
        if (carInfo != null){
            AjaxMessage msg = new AjaxMessage();
            msg.setName(carInfo.getCarid()+"");
            msg.setDesc(carInfo.getVehicleno());
            list.add(msg);
        }
        return list;
    }

    @Override
    public List<HashMap<String, Object>> findVehiclePhoto(String companyidc) {
        return NetCarbaseinfodaoImpl.findVehiclePhoto(companyidc);
    }


}
