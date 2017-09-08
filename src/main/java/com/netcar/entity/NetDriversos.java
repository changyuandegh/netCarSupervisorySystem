package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDriversos {

    private int id;
    private int companyid;
    private int driverid;
    private String vehicleno;
    private int address;
    private String position;
    private double longitude;
    private double latitude;
    private int encrypt;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
        NetDriversos that = (NetDriversos) o;
        return id == that.id &&
                companyid == that.companyid &&
                driverid == that.driverid &&
                address == that.address &&
                Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.latitude, latitude) == 0 &&
                encrypt == that.encrypt &&
                Objects.equals(vehicleno, that.vehicleno) &&
                Objects.equals(position, that.position) &&
                Objects.equals(alarmtime, that.alarmtime) &&
                Objects.equals(state, that.state) &&
                Objects.equals(result, that.result) &&
                Objects.equals(processtime, that.processtime) &&
                Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, driverid, vehicleno, address, position, longitude, latitude, encrypt, alarmtime, state, result, processtime, userid);
    }

    @Override
    public String toString() {
        return "NetDriversos{" +
                "id=" + id +
                ", companyid=" + companyid +
                ", driverid=" + driverid +
                ", vehicleno='" + vehicleno + '\'' +
                ", address=" + address +
                ", position='" + position + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", encrypt=" + encrypt +
                ", alarmtime=" + alarmtime +
                ", state=" + state +
                ", result='" + result + '\'' +
                ", processtime=" + processtime +
                ", userid=" + userid +
                '}';
    }
}
