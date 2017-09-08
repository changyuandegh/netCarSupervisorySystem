package com.netcar.service;

import com.netcar.dataModle.Devicegps;
import com.netcar.entity.NetDevice;
import com.netcar.entity.NetDevicegps;

import java.util.List;

/**
 * Created by Mander on 2017/5/18.
 * 车辆gps
 */

public interface NetCarGpsService {

    /**
     * 根据地区车辆查询GPS
     *
     * @param areacode
     * @param vehicleno
     * @return
     */
    Devicegps findGPSByAreacodeVehicleno(String areacode, String vehicleno);


    /**
     * 根据地区获取车辆定位
     *
     * @param areaCode
     * @return
     */
    List<Devicegps> findGPSByAreacode(String areaCode);



    List<Devicegps> findGPSByAreaCompany(String areaCode, String companyidc);


}
