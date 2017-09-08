package com.netcar.dataModle;

import java.util.List;

/**
 * Created by Mander on 2017/5/8
 * 车辆司机实体
 */
public class Cardriver {


//姓名、手机号、所属公司、营运状态
//车牌号、车辆状态、最后定位时间、车辆最后位置


    private String vehicleno;//车牌号
    private String  model;//车型
    private String  vehiclecolor;//车身颜色
    private List<Driver> driverList;//司机集合

    private String state;//车辆状态





    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehiclecolor() {
        return vehiclecolor;
    }

    public void setVehiclecolor(String vehiclecolor) {
        this.vehiclecolor = vehiclecolor;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
