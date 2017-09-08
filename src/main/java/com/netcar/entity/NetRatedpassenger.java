package com.netcar.entity;

import java.sql.Timestamp;

/**
 * Created by Mander on 2017/6/13.
 */
public class NetRatedpassenger {

    private int id;
    private String companyidc;
    private String orderid;
    private Timestamp evaluatetime;
    private int servicescore;
    private Integer driverscore;
    private Integer vehiclescore;
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyidc() {
        return companyidc;
    }

    public void setCompanyidc(String companyidc) {
        this.companyidc = companyidc;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Timestamp getEvaluatetime() {
        return evaluatetime;
    }

    public void setEvaluatetime(Timestamp evaluatetime) {
        this.evaluatetime = evaluatetime;
    }

    public int getServicescore() {
        return servicescore;
    }

    public void setServicescore(int servicescore) {
        this.servicescore = servicescore;
    }

    public Integer getDriverscore() {
        return driverscore;
    }

    public void setDriverscore(Integer driverscore) {
        this.driverscore = driverscore;
    }

    public Integer getVehiclescore() {
        return vehiclescore;
    }

    public void setVehiclescore(Integer vehiclescore) {
        this.vehiclescore = vehiclescore;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetRatedpassenger that = (NetRatedpassenger) o;

        if (id != that.id) return false;
        if (servicescore != that.servicescore) return false;
        if (companyidc != null ? !companyidc.equals(that.companyidc) : that.companyidc != null) return false;
        if (orderid != null ? !orderid.equals(that.orderid) : that.orderid != null) return false;
        if (evaluatetime != null ? !evaluatetime.equals(that.evaluatetime) : that.evaluatetime != null) return false;
        if (driverscore != null ? !driverscore.equals(that.driverscore) : that.driverscore != null) return false;
        if (vehiclescore != null ? !vehiclescore.equals(that.vehiclescore) : that.vehiclescore != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (companyidc != null ? companyidc.hashCode() : 0);
        result = 31 * result + (orderid != null ? orderid.hashCode() : 0);
        result = 31 * result + (evaluatetime != null ? evaluatetime.hashCode() : 0);
        result = 31 * result + servicescore;
        result = 31 * result + (driverscore != null ? driverscore.hashCode() : 0);
        result = 31 * result + (vehiclescore != null ? vehiclescore.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }
}
