package com.netcar.dataModle;

import java.util.Date;

/**
 * Created by Work on 2017/5/17.
 */
public class SeparatealarmData {

    private int id;
    private int companyid;
    private String companyName;
    private int driverid;
    private String driverName;
    private String vehicleno;
    private int address;
    private String driverposition;
    private double driverlng;
    private double driverlat;
    private String vehicleposition;
    private double vehiclelng;
    private double vehiclelat;
    private int encrypt;
    private int orderid;
    private Date alarmtime;
    private int state;
    private String result;
    private Date processtime;

    public SeparatealarmData() {
    }

    public SeparatealarmData(int id, int companyid, String companyName, int driverid, String driverName, String vehicleno, int address, String driverposition, double driverlng, double driverlat, String vehicleposition, double vehiclelng, double vehiclelat, int encrypt, int orderid, Date alarmtime, int state, String result, Date processtime) {
        this.id = id;
        this.companyid = companyid;
        this.companyName = companyName;
        this.driverid = driverid;
        this.driverName = driverName;
        this.vehicleno = vehicleno;
        this.address = address;
        this.driverposition = driverposition;
        this.driverlng = driverlng;
        this.driverlat = driverlat;
        this.vehicleposition = vehicleposition;
        this.vehiclelng = vehiclelng;
        this.vehiclelat = vehiclelat;
        this.encrypt = encrypt;
        this.orderid = orderid;
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

    public int getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(int encrypt) {
        this.encrypt = encrypt;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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
        return "SeparatealarmData{" +
                "id=" + id +
                ", companyid=" + companyid +
                ", companyName='" + companyName + '\'' +
                ", driverid=" + driverid +
                ", driverName='" + driverName + '\'' +
                ", vehicleno='" + vehicleno + '\'' +
                ", address=" + address +
                ", driverposition='" + driverposition + '\'' +
                ", driverlng=" + driverlng +
                ", driverlat=" + driverlat +
                ", vehicleposition='" + vehicleposition + '\'' +
                ", vehiclelng=" + vehiclelng +
                ", vehiclelat=" + vehiclelat +
                ", encrypt=" + encrypt +
                ", orderid=" + orderid +
                ", alarmtime=" + alarmtime +
                ", state=" + state +
                ", result='" + result + '\'' +
                ", processtime=" + processtime +
                '}';
    }
}
