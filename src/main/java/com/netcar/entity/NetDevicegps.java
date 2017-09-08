package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDevicegps {

    private int id;
    private long deviceid;
    private int driverregioncode;
    private Timestamp positiontime;
    private double longitude;
    private double latitude;
    private int encrypt;
    private int direction;
    private int elevation;
    private int speed;
    private int alarmstate;
    private int acc;
    private int islocation;
    private double mileage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public int getDriverregioncode() {
        return driverregioncode;
    }

    public void setDriverregioncode(int driverregioncode) {
        this.driverregioncode = driverregioncode;
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

    public int getAlarmstate() {
        return alarmstate;
    }

    public void setAlarmstate(int alarmstate) {
        this.alarmstate = alarmstate;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public int getIslocation() {
        return islocation;
    }

    public void setIslocation(int islocation) {
        this.islocation = islocation;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetDevicegps that = (NetDevicegps) o;
        return id == that.id &&
                deviceid == that.deviceid &&
                driverregioncode == that.driverregioncode &&
                Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.latitude, latitude) == 0 &&
                encrypt == that.encrypt &&
                direction == that.direction &&
                elevation == that.elevation &&
                speed == that.speed &&
                alarmstate == that.alarmstate &&
                acc == that.acc &&
                islocation == that.islocation &&
                Double.compare(that.mileage, mileage) == 0 &&
                Objects.equals(positiontime, that.positiontime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceid, driverregioncode, positiontime, longitude, latitude, encrypt, direction, elevation, speed, alarmstate, acc, islocation, mileage);
    }
}
