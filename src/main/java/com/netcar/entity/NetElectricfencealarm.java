package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetElectricfencealarm {

    private int id;
    private int fenceid;
    private int address;
    private int companyid;
    private int driverid;
    private String vehicleno;
    private double longitude;
    private double latitude;
    private int encrypt;
    private Timestamp alarmtime;
    private int state;
    private String result;
    private Timestamp processtime;
    private Integer userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFenceid() {
        return fenceid;
    }

    public void setFenceid(int fenceid) {
        this.fenceid = fenceid;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(int encrypt) {
        this.encrypt = encrypt;
    }

    public Timestamp getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(Timestamp alarmtime) {
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
        NetElectricfencealarm that = (NetElectricfencealarm) o;
        return id == that.id &&
                fenceid == that.fenceid &&
                address == that.address &&
                companyid == that.companyid &&
                driverid == that.driverid &&
                Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.latitude, latitude) == 0 &&
                encrypt == that.encrypt &&
                state == that.state &&
                Objects.equals(vehicleno, that.vehicleno) &&
                Objects.equals(alarmtime, that.alarmtime) &&
                Objects.equals(result, that.result) &&
                Objects.equals(processtime, that.processtime) &&
                Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fenceid, address, companyid, driverid, vehicleno, longitude, latitude, encrypt, alarmtime, state, result, processtime, userid);
    }
}
