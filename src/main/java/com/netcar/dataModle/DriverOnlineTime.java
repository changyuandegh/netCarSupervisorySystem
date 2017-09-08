package com.netcar.dataModle;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/13.
 */
public class DriverOnlineTime {
    //设备号
    private String equipment;

    //车牌号
    private String license;
    //司机姓名
    private String drivername;
    //所属公司
    private String company;
    //最早在线时间
    private String earlytime;
    //最晚在线时间
    private String endtime;
    //在线时长
    private int onlinetime;

    public DriverOnlineTime(){}
    public DriverOnlineTime(String equipment, String license, String drivername, String company, String earlytime, String endtime, int onlinetime) {
        this.equipment = equipment;
        this.license = license;
        this.drivername = drivername;
        this.company = company;
        this.earlytime = earlytime;
        this.endtime = endtime;
        this.onlinetime = onlinetime;
    }


    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEarlytime() {
        return earlytime;
    }

    public void setEarlytime(String earlytime) {
        this.earlytime = earlytime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(int onlinetime) {
        this.onlinetime = onlinetime;
    }
}
