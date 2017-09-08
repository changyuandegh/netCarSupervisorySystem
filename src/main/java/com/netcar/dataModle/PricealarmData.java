package com.netcar.dataModle;

import java.util.Date;

/**
 * Created by Work on 2017/5/17.
 */
public class PricealarmData {

    private int id;
    private int companyid;
    private String companyName;
    private int driverid;
    private String driverName;
    private String vehicleno;
    private int address;
    private long orderid;
    private double ordermileage;
    private int ordertime;
    private double ordermoney;
    private double avespeed;
    private int type;
    private Date alarmtime;
    private int state;
    private String result;
    private Date processtime;

    public PricealarmData() {
    }

    public PricealarmData(int id, int companyid, String companyName, int driverid, String driverName, String vehicleno, int address, long orderid, double ordermileage, int ordertime, double ordermoney, double avespeed, int type, Date alarmtime, int state, String result, Date processtime) {
        this.id = id;
        this.companyid = companyid;
        this.companyName = companyName;
        this.driverid = driverid;
        this.driverName = driverName;
        this.vehicleno = vehicleno;
        this.address = address;
        this.orderid = orderid;
        this.ordermileage = ordermileage;
        this.ordertime = ordertime;
        this.ordermoney = ordermoney;
        this.avespeed = avespeed;
        this.type = type;
        this.alarmtime = alarmtime;
        this.state = state;
        this.result = result;
        this.processtime = processtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public double getOrdermileage() {
        return ordermileage;
    }

    public void setOrdermileage(double ordermileage) {
        this.ordermileage = ordermileage;
    }

    public int getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(int ordertime) {
        this.ordertime = ordertime;
    }

    public double getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(double ordermoney) {
        this.ordermoney = ordermoney;
    }

    public double getAvespeed() {
        return avespeed;
    }

    public void setAvespeed(double avespeed) {
        this.avespeed = avespeed;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(Date alarmtime) {
        this.alarmtime = alarmtime;
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

    public Date getProcesstime() {
        return processtime;
    }

    public void setProcesstime(Date processtime) {
        this.processtime = processtime;
    }

    @Override
    public String toString() {
        return "PricealarmData{" +
                "id=" + id +
                ", companyid=" + companyid +
                ", companyName='" + companyName + '\'' +
                ", driverid=" + driverid +
                ", driverName='" + driverName + '\'' +
                ", vehicleno='" + vehicleno + '\'' +
                ", address=" + address +
                ", orderid=" + orderid +
                ", ordermileage=" + ordermileage +
                ", ordertime=" + ordertime +
                ", ordermoney=" + ordermoney +
                ", avespeed=" + avespeed +
                ", type=" + type +
                ", alarmtime=" + alarmtime +
                ", state=" + state +
                ", result='" + result + '\'' +
                ", processtime=" + processtime +
                '}';
    }
}

