package com.netcar.dataModle;

import java.util.Date;

/**
 * Created by Work on 2017/5/17.
 */
public class ElectricfenceAlarmData {

    private int id;
    private int fenceId;
    private String fenceName;
    private int address;
    private String addressName;
    private int companyid;
    private String companyName;
    private int driverid;
    private String driverName;
    private String vehicleno;
    private double longitude;
    private double latitude;
    private int encrypt;
    private Date alarmtime;
    private int state;
    private String result;
    private Date processtime;

    public ElectricfenceAlarmData() {
    }

    public ElectricfenceAlarmData(int id, int fenceId, String fenceName, int address, String addressName, int companyid, String companyName, int driverid, String driverName, String vehicleno, double longitude, double latitude, int encrypt, Date alarmtime, int state, String result, Date processtime) {
        this.id = id;
        this.fenceId = fenceId;
        this.fenceName = fenceName;
        this.address = address;
        this.addressName = addressName;
        this.companyid = companyid;
        this.companyName = companyName;
        this.driverid = driverid;
        this.driverName = driverName;
        this.vehicleno = vehicleno;
        this.longitude = longitude;
        this.latitude = latitude;
        this.encrypt = encrypt;
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

    public int getFenceId() {
        return fenceId;
    }

    public void setFenceId(int fenceId) {
        this.fenceId = fenceId;
    }

    public String getFenceName() {
        return fenceName;
    }

    public void setFenceName(String fenceName) {
        this.fenceName = fenceName;
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
        return "ElectricfenceAlarmData{" +
                "id=" + id +
                ", fenceId=" + fenceId +
                ", fenceName='" + fenceName + '\'' +
                ", address=" + address +
                ", addressName='" + addressName + '\'' +
                ", companyid=" + companyid +
                ", companyName='" + companyName + '\'' +
                ", driverid=" + driverid +
                ", driverName='" + driverName + '\'' +
                ", vehicleno='" + vehicleno + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", encrypt=" + encrypt +
                ", alarmtime=" + alarmtime +
                ", state=" + state +
                ", result='" + result + '\'' +
                ", processtime=" + processtime +
                '}';
    }
}
