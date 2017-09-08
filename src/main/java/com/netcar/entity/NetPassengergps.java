package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetPassengergps {

    private long psggpsid;
    private String phone;
    private int driverregioncode;
    private Timestamp positiontime;
    private double longitude;
    private double latitude;
    private int encrypt;
    private int direction;
    private int elevation;
    private int speed;
    private long orderno;

    public long getPsggpsid() {
        return psggpsid;
    }

    public void setPsggpsid(long psggpsid) {
        this.psggpsid = psggpsid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public long getOrderno() {
        return orderno;
    }

    public void setOrderno(long orderno) {
        this.orderno = orderno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetPassengergps that = (NetPassengergps) o;
        return psggpsid == that.psggpsid &&
                driverregioncode == that.driverregioncode &&
                Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.latitude, latitude) == 0 &&
                encrypt == that.encrypt &&
                direction == that.direction &&
                elevation == that.elevation &&
                speed == that.speed &&
                orderno == that.orderno &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(positiontime, that.positiontime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(psggpsid, phone, driverregioncode, positiontime, longitude, latitude, encrypt, direction, elevation, speed, orderno);
    }
}
