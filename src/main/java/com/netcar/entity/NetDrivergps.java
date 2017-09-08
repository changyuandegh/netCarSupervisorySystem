package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDrivergps {

    private int drivergpsid;
    private String licenseid;
    private int driverregioncode;
    private String vehicleno;
    private Timestamp positiontime;
    private double longitude;
    private double latitude;
    private int encrypt;
    private int direction;
    private int elevation;
    private int speed;
    private int bizstatus;
    private Long orderno;
    private Integer orderstatus;
    private Integer alarmstate;
    private Integer isonline;

    public int getDrivergpsid() {
        return drivergpsid;
    }

    public void setDrivergpsid(int drivergpsid) {
        this.drivergpsid = drivergpsid;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public int getDriverregioncode() {
        return driverregioncode;
    }

    public void setDriverregioncode(int driverregioncode) {
        this.driverregioncode = driverregioncode;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public Timestamp getPositiontime() {
        return positiontime;
    }

    public void setPositiontime(Timestamp positiontime) {
        this.positiontime = positiontime;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBizstatus() {
        return bizstatus;
    }

    public void setBizstatus(int bizstatus) {
        this.bizstatus = bizstatus;
    }

    public Long getOrderno() {
        return orderno;
    }

    public void setOrderno(Long orderno) {
        this.orderno = orderno;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Integer getAlarmstate() {
        return alarmstate;
    }

    public void setAlarmstate(Integer alarmstate) {
        this.alarmstate = alarmstate;
    }

    public Integer getIsonline() {
        return isonline;
    }

    public void setIsonline(Integer isonline) {
        this.isonline = isonline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetDrivergps that = (NetDrivergps) o;
        return drivergpsid == that.drivergpsid &&
                driverregioncode == that.driverregioncode &&
                Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.latitude, latitude) == 0 &&
                encrypt == that.encrypt &&
                direction == that.direction &&
                elevation == that.elevation &&
                speed == that.speed &&
                bizstatus == that.bizstatus &&
                Objects.equals(licenseid, that.licenseid) &&
                Objects.equals(vehicleno, that.vehicleno) &&
                Objects.equals(positiontime, that.positiontime) &&
                Objects.equals(orderno, that.orderno) &&
                Objects.equals(orderstatus, that.orderstatus) &&
                Objects.equals(alarmstate, that.alarmstate) &&
                Objects.equals(isonline, that.isonline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drivergpsid, licenseid, driverregioncode, vehicleno, positiontime, longitude, latitude, encrypt, direction, elevation, speed, bizstatus, orderno, orderstatus, alarmstate, isonline);
    }
}
