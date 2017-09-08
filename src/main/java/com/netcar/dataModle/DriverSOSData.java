package com.netcar.dataModle;

import java.util.Date;

/**
 * Created by Wby on 2017/5/17.
 * 司机报警信息
 */
public class DriverSOSData {
    private int id;
    private int companyId;
    private String companyName;
    private int driverId;
    private String driverName;
    private String vehicleNo;
    private int address;
    private String addressName;
    private String position;
    private double longitude;
    private double latitude;
    private int encrypt;
    private Date alarmTime;
    private int state;
    private String result;
    private Date processTime;

    public DriverSOSData() {
    }

    public DriverSOSData(int id, int companyId, String companyName, int driverId, String driverName, String vehicleNo, int address, String addressName, String position, double longitude, double latitude, int encrypt, Date alarmTime, int state, String result, Date processTime) {
        this.id = id;
        this.companyId = companyId;
        this.companyName = companyName;
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehicleNo = vehicleNo;
        this.address = address;
        this.addressName = addressName;
        this.position = position;
        this.longitude = longitude;
        this.latitude = latitude;
        this.encrypt = encrypt;
        this.alarmTime = alarmTime;
        this.state = state;
        this.result = result;
        this.processTime = processTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
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
        return "DriverSOSData{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", address=" + address +
                ", addressName='" + addressName + '\'' +
                ", position='" + position + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", encrypt=" + encrypt +
                ", alarmTime=" + alarmTime +
                ", state=" + state +
                ", result='" + result + '\'' +
                ", processTime=" + processTime +
                '}';
    }
}
