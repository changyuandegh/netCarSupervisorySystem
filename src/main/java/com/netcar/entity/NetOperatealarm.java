package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetOperatealarm {

    private int id;
    private int companyid;
    private int driverid;
    private String vehicleno;
    private long orderid;
    private String depposition;
    private double deplng;
    private double deplat;
    private String destposition;
    private double destlng;
    private double destlat;
    private int address;
    private int realaddress;
    private Double longitude;
    private Double latitude;
    private Integer encrypt;
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

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getDepposition() {
        return depposition;
    }

    public void setDepposition(String depposition) {
        this.depposition = depposition;
    }

    public double getDeplng() {
        return deplng;
    }

    public void setDeplng(double deplng) {
        this.deplng = deplng;
    }

    public double getDeplat() {
        return deplat;
    }

    public void setDeplat(double deplat) {
        this.deplat = deplat;
    }

    public String getDestposition() {
        return destposition;
    }

    public void setDestposition(String destposition) {
        this.destposition = destposition;
    }

    public double getDestlng() {
        return destlng;
    }

    public void setDestlng(double destlng) {
        this.destlng = destlng;
    }

    public double getDestlat() {
        return destlat;
    }

    public void setDestlat(double destlat) {
        this.destlat = destlat;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getRealaddress() {
        return realaddress;
    }

    public void setRealaddress(int realaddress) {
        this.realaddress = realaddress;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(Integer encrypt) {
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
        NetOperatealarm that = (NetOperatealarm) o;
        return id == that.id &&
                companyid == that.companyid &&
                driverid == that.driverid &&
                orderid == that.orderid &&
                Double.compare(that.deplng, deplng) == 0 &&
                Double.compare(that.deplat, deplat) == 0 &&
                Double.compare(that.destlng, destlng) == 0 &&
                Double.compare(that.destlat, destlat) == 0 &&
                address == that.address &&
                realaddress == that.realaddress &&
                state == that.state &&
                Objects.equals(vehicleno, that.vehicleno) &&
                Objects.equals(depposition, that.depposition) &&
                Objects.equals(destposition, that.destposition) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(encrypt, that.encrypt) &&
                Objects.equals(alarmtime, that.alarmtime) &&
                Objects.equals(result, that.result) &&
                Objects.equals(processtime, that.processtime) &&
                Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, driverid, vehicleno, orderid, depposition, deplng, deplat, destposition, destlng, destlat, address, realaddress, longitude, latitude, encrypt, alarmtime, state, result, processtime, userid);
    }
}
