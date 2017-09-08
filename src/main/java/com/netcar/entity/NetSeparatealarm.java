package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetSeparatealarm {

    private int id;
    private int companyid;
    private int driverid;
    private String vehicleno;
    private int address;
    private String driverposition;
    private double driverlng;
    private double driverlat;
    private String vehicleposition;
    private double vehiclelng;
    private double vehiclelat;
    private int encrypt;
    private Integer orderid;
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

    public String getDriverposition() {
        return driverposition;
    }

    public void setDriverposition(String driverposition) {
        this.driverposition = driverposition;
    }

    public double getDriverlng() {
        return driverlng;
    }

    public void setDriverlng(double driverlng) {
        this.driverlng = driverlng;
    }

    public double getDriverlat() {
        return driverlat;
    }

    public void setDriverlat(double driverlat) {
        this.driverlat = driverlat;
    }

    public String getVehicleposition() {
        return vehicleposition;
    }

    public void setVehicleposition(String vehicleposition) {
        this.vehicleposition = vehicleposition;
    }

    public double getVehiclelng() {
        return vehiclelng;
    }

    public void setVehiclelng(double vehiclelng) {
        this.vehiclelng = vehiclelng;
    }

    public double getVehiclelat() {
        return vehiclelat;
    }

    public void setVehiclelat(double vehiclelat) {
        this.vehiclelat = vehiclelat;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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

    public int getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(int encrypt) {
        this.encrypt = encrypt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetSeparatealarm that = (NetSeparatealarm) o;
        return id == that.id &&
                companyid == that.companyid &&
                driverid == that.driverid &&
                address == that.address &&
                encrypt == that.encrypt &&
                Double.compare(that.driverlng, driverlng) == 0 &&
                Double.compare(that.driverlat, driverlat) == 0 &&
                Double.compare(that.vehiclelng, vehiclelng) == 0 &&
                Double.compare(that.vehiclelat, vehiclelat) == 0 &&
                Objects.equals(vehicleno, that.vehicleno) &&
                Objects.equals(driverposition, that.driverposition) &&
                Objects.equals(vehicleposition, that.vehicleposition) &&
                Objects.equals(orderid, that.orderid) &&
                Objects.equals(alarmtime, that.alarmtime) &&
                Objects.equals(state, that.state) &&
                Objects.equals(result, that.result) &&
                Objects.equals(processtime, that.processtime) &&
                Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, driverid, vehicleno, address, driverposition, driverlng, driverlat, vehicleposition, vehiclelng, vehiclelat, encrypt, orderid, alarmtime, state, result, processtime, userid);
    }
}
