package com.netcar.dataModle;

import java.util.Date;

/**
 * Created by Wby on 2017/5/17.
 * 重点区域历史信息
 */
public class KeyAreaData {
    private int id;
    private int areaid;
    private String areaName;
    private int address;
    private String addressName;
    private int vehicleNum;
    private Date alarmTime;
    private int state;
    private String result;
    private Date processTime;

    public KeyAreaData() {
    }

    public KeyAreaData(int id, int areaid, String areaName, int address, String addressName, int vehicleNum, Date alarmTime, int state, String result, Date processTime) {
        this.id = id;
        this.areaid = areaid;
        this.areaName = areaName;
        this.address = address;
        this.addressName = addressName;
        this.vehicleNum = vehicleNum;
        this.alarmTime = alarmTime;
        this.state = state;
        this.result = result;
        this.processTime = processTime;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public void setVehicleNum(int vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "KeyAreaData{" +
                "id=" + id +
                ", areaid=" + areaid +
                ", areaName='" + areaName + '\'' +
                ", vehicleNum='" + vehicleNum + '\'' +
                ", alarmTime=" + alarmTime +
                ", state=" + state +
                ", result='" + result + '\'' +
                ", processTime=" + processTime +
                '}';
    }
}

