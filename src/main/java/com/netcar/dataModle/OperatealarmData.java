package com.netcar.dataModle;

import java.util.Date;

/**
 * Created by Wby on 2017/5/17.
 *
 */
public class OperatealarmData {

    private int id;
    private int companyid;
    private String companyName;
    private int driverid;
    private String driverName;
    private String vehicleno;
    private long orderid;
    private String depposition; //上车
    private double deplng;
    private double deplat;
    private String destposition;//下车
    private double destlng;
    private double destlat;
    private int address;
    private int realaddress;
    private Double longitude;
    private Double latitude;
    private Integer encrypt;
    private Date alarmtime;
    private int state;
    private String result;
    private Date processtime;

    public OperatealarmData() {
    }

    public OperatealarmData(int id, int companyid, String companyName, int driverid, String driverName, String vehicleno, long orderid, String depposition, double deplng, double deplat, String destposition, double destlng, double destlat, int address, int realaddress, Double longitude, Double latitude, Integer encrypt, Date alarmtime, int state, String result, Date processtime) {
        this.id = id;
        this.companyid = companyid;
        this.companyName = companyName;
        this.driverid = driverid;
        this.driverName = driverName;
        this.vehicleno = vehicleno;
        this.orderid = orderid;
        this.depposition = depposition;
        this.deplng = deplng;
        this.deplat = deplat;
        this.destposition = destposition;
        this.destlng = destlng;
        this.destlat = destlat;
        this.address = address;
        this.realaddress = realaddress;
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
        return "OperatealarmData{" +
                "id=" + id +
                ", companyid=" + companyid +
                ", companyName='" + companyName + '\'' +
                ", driverid=" + driverid +
                ", driverName='" + driverName + '\'' +
                ", vehicleno='" + vehicleno + '\'' +
                ", orderid=" + orderid +
                ", depposition='" + depposition + '\'' +
                ", deplng=" + deplng +
                ", deplat=" + deplat +
                ", destposition='" + destposition + '\'' +
                ", destlng=" + destlng +
                ", destlat=" + destlat +
                ", address=" + address +
                ", realaddress=" + realaddress +
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
