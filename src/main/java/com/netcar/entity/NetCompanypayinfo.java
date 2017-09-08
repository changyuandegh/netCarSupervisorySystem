package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetCompanypayinfo {

    private int id;
    private String companyid;
    private String payname;
    private String payid;
    private String paytype;
    private String payscope;
    private String preparebank;
    private int countdate;
    private int state;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPayscope() {
        return payscope;
    }

    public void setPayscope(String payscope) {
        this.payscope = payscope;
    }

    public String getPreparebank() {
        return preparebank;
    }

    public void setPreparebank(String preparebank) {
        this.preparebank = preparebank;
    }

    public int getCountdate() {
        return countdate;
    }

    public void setCountdate(int countdate) {
        this.countdate = countdate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
        NetCompanypayinfo that = (NetCompanypayinfo) o;
        return id == that.id &&
                countdate == that.countdate &&
                state == that.state &&
                Objects.equals(companyid, that.companyid) &&
                Objects.equals(payname, that.payname) &&
                Objects.equals(payid, that.payid) &&
                Objects.equals(paytype, that.paytype) &&
                Objects.equals(payscope, that.payscope) &&
                Objects.equals(preparebank, that.preparebank) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, payname, payid, paytype, payscope, preparebank, countdate, state, createtime, updatetime);
    }
}
