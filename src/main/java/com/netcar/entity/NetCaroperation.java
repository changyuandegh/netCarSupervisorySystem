package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetCaroperation {

    private long id;
    private int companyid;
    private long appid;
    private String licenseid;
    private String vehicleno;
    private Timestamp logintime;
    private Timestamp logouttime;
    private Double loginlongitude;
    private Double loginlatitude;
    private Double logoutlongitute;
    private Double logoutlatitude;
    private Integer encrypt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public long getAppid() {
        return appid;
    }

    public void setAppid(long appid) {
        this.appid = appid;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    public Timestamp getLogouttime() {
        return logouttime;
    }

    public void setLogouttime(Timestamp logouttime) {
        this.logouttime = logouttime;
    }

    public Double getLoginlongitude() {
        return loginlongitude;
    }

    public void setLoginlongitude(Double loginlongitude) {
        this.loginlongitude = loginlongitude;
    }

    public Double getLoginlatitude() {
        return loginlatitude;
    }

    public void setLoginlatitude(Double loginlatitude) {
        this.loginlatitude = loginlatitude;
    }

    public Double getLogoutlongitute() {
        return logoutlongitute;
    }

    public void setLogoutlongitute(Double logoutlongitute) {
        this.logoutlongitute = logoutlongitute;
    }

    public Double getLogoutlatitude() {
        return logoutlatitude;
    }

    public void setLogoutlatitude(Double logoutlatitude) {
        this.logoutlatitude = logoutlatitude;
    }

    public Integer getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(Integer encrypt) {
        this.encrypt = encrypt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetCaroperation that = (NetCaroperation) o;
        return id == that.id &&
                companyid == that.companyid &&
                appid == that.appid &&
                Objects.equals(licenseid, that.licenseid) &&
                Objects.equals(vehicleno, that.vehicleno) &&
                Objects.equals(logintime, that.logintime) &&
                Objects.equals(logouttime, that.logouttime) &&
                Objects.equals(loginlongitude, that.loginlongitude) &&
                Objects.equals(loginlatitude, that.loginlatitude) &&
                Objects.equals(logoutlongitute, that.logoutlongitute) &&
                Objects.equals(logoutlatitude, that.logoutlatitude) &&
                Objects.equals(encrypt, that.encrypt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, appid, licenseid, vehicleno, logintime, logouttime, loginlongitude, loginlatitude, logoutlongitute, logoutlatitude, encrypt);
    }
}
