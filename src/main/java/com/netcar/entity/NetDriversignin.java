package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDriversignin {

    private int driversigninid;
    private String vehicleno;
    private String licenseid;
    private Timestamp ontime;
    private Timestamp outtime;
    private double latitude;
    private double longitude;

    public int getDriversigninid() {
        return driversigninid;
    }

    public void setDriversigninid(int driversigninid) {
        this.driversigninid = driversigninid;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public Timestamp getOntime() {
        return ontime;
    }

    public void setOntime(Timestamp ontime) {
        this.ontime = ontime;
    }

    public Timestamp getOuttime() {
        return outtime;
    }

    public void setOuttime(Timestamp outtime) {
        this.outtime = outtime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetDriversignin that = (NetDriversignin) o;
        return driversigninid == that.driversigninid &&
                Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(vehicleno, that.vehicleno) &&
                Objects.equals(licenseid, that.licenseid) &&
                Objects.equals(ontime, that.ontime) &&
                Objects.equals(outtime, that.outtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driversigninid, vehicleno, licenseid, ontime, outtime, latitude, longitude);
    }
}
