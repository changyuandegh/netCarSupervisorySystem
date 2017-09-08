package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetPricealarm {

    private int id;
    private int companyid;
    private int driverid;
    private String vehicleno;
    private int address;
    private long orderid;
    private Double ordermileage;
    private Integer ordertime;
    private Double ordermoney;
    private Double avespeed;
    private int type;
    private Timestamp alarmtime;
    private Integer state;
    private String result;
    private Timestamp processtime;
    private Integer userid;

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

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
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

    public Double getOrdermileage() {
        return ordermileage;
    }

    public void setOrdermileage(Double ordermileage) {
        this.ordermileage = ordermileage;
    }

    public Integer getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Integer ordertime) {
        this.ordertime = ordertime;
    }

    public Double getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(Double ordermoney) {
        this.ordermoney = ordermoney;
    }

    public Double getAvespeed() {
        return avespeed;
    }

    public void setAvespeed(Double avespeed) {
        this.avespeed = avespeed;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Timestamp getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(Timestamp alarmtime) {
        this.alarmtime = alarmtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getProcesstime() {
        return processtime;
    }

    public void setProcesstime(Timestamp processtime) {
        this.processtime = processtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetPricealarm that = (NetPricealarm) o;
        return id == that.id &&
                companyid == that.companyid &&
                driverid == that.driverid &&
                address == that.address &&
                orderid == that.orderid &&
                type == that.type &&
                Objects.equals(vehicleno, that.vehicleno) &&
                Objects.equals(ordermileage, that.ordermileage) &&
                Objects.equals(ordertime, that.ordertime) &&
                Objects.equals(ordermoney, that.ordermoney) &&
                Objects.equals(avespeed, that.avespeed) &&
                Objects.equals(alarmtime, that.alarmtime) &&
                Objects.equals(state, that.state) &&
                Objects.equals(result, that.result) &&
                Objects.equals(processtime, that.processtime) &&
                Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, driverid, vehicleno, address, orderid, ordermileage, ordertime, ordermoney, avespeed, type, alarmtime, state, result, processtime, userid);
    }
}
