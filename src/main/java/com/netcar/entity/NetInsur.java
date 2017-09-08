package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetInsur {

    private int insurid;
    private String insurcom;
    private String insurnum;
    private String insurtype;
    private double insurcount;
    private Date insureff;
    private Date insurexp;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getInsurid() {
        return insurid;
    }

    public void setInsurid(int insurid) {
        this.insurid = insurid;
    }

    public String getInsurcom() {
        return insurcom;
    }

    public void setInsurcom(String insurcom) {
        this.insurcom = insurcom;
    }

    public String getInsurnum() {
        return insurnum;
    }

    public void setInsurnum(String insurnum) {
        this.insurnum = insurnum;
    }

    public String getInsurtype() {
        return insurtype;
    }

    public void setInsurtype(String insurtype) {
        this.insurtype = insurtype;
    }

    public double getInsurcount() {
        return insurcount;
    }

    public void setInsurcount(double insurcount) {
        this.insurcount = insurcount;
    }

    public Date getInsureff() {
        return insureff;
    }

    public void setInsureff(Date insureff) {
        this.insureff = insureff;
    }

    public Date getInsurexp() {
        return insurexp;
    }

    public void setInsurexp(Date insurexp) {
        this.insurexp = insurexp;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetInsur netInsur = (NetInsur) o;
        return insurid == netInsur.insurid &&
                Double.compare(netInsur.insurcount, insurcount) == 0 &&
                Objects.equals(insurcom, netInsur.insurcom) &&
                Objects.equals(insurnum, netInsur.insurnum) &&
                Objects.equals(insurtype, netInsur.insurtype) &&
                Objects.equals(insureff, netInsur.insureff) &&
                Objects.equals(insurexp, netInsur.insurexp) &&
                Objects.equals(createtime, netInsur.createtime) &&
                Objects.equals(updatetime, netInsur.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insurid, insurcom, insurnum, insurtype, insurcount, insureff, insurexp, createtime, updatetime);
    }
}
