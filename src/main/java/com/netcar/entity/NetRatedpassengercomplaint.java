package com.netcar.entity;

import java.sql.Timestamp;

/**
 * Created by Mander on 2017/6/13.
 */
public class NetRatedpassengercomplaint {

    private int id;
    private String companyidc;
    private String orderid;
    private Timestamp complainttime;
    private String detail;
    private String result;

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

    public Timestamp getComplainttime() {
        return complainttime;
    }

    public void setComplainttime(Timestamp complainttime) {
        this.complainttime = complainttime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetRatedpassengercomplaint that = (NetRatedpassengercomplaint) o;

        if (id != that.id) return false;
        if (companyidc != null ? !companyidc.equals(that.companyidc) : that.companyidc != null) return false;
        if (orderid != null ? !orderid.equals(that.orderid) : that.orderid != null) return false;
        if (complainttime != null ? !complainttime.equals(that.complainttime) : that.complainttime != null)
            return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id;
        result1 = 31 * result1 + (companyidc != null ? companyidc.hashCode() : 0);
        result1 = 31 * result1 + (orderid != null ? orderid.hashCode() : 0);
        result1 = 31 * result1 + (complainttime != null ? complainttime.hashCode() : 0);
        result1 = 31 * result1 + (detail != null ? detail.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }
}
