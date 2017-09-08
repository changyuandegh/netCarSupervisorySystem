package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetCompanystatistics {

    private int id;
    private int companyid;
    private int ordercount;
    private double moneycount;
    private int ordercancelcount;
    private int ordercompletecount;
    private int soscount;
    private int complaintcount;
    private Timestamp updatetime;
    private Timestamp createtime;

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

    public int getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(int ordercount) {
        this.ordercount = ordercount;
    }

    public double getMoneycount() {
        return moneycount;
    }

    public void setMoneycount(double moneycount) {
        this.moneycount = moneycount;
    }

    public int getOrdercancelcount() {
        return ordercancelcount;
    }

    public void setOrdercancelcount(int ordercancelcount) {
        this.ordercancelcount = ordercancelcount;
    }

    public int getOrdercompletecount() {
        return ordercompletecount;
    }

    public void setOrdercompletecount(int ordercompletecount) {
        this.ordercompletecount = ordercompletecount;
    }

    public int getSoscount() {
        return soscount;
    }

    public void setSoscount(int soscount) {
        this.soscount = soscount;
    }

    public int getComplaintcount() {
        return complaintcount;
    }

    public void setComplaintcount(int complaintcount) {
        this.complaintcount = complaintcount;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetCompanystatistics that = (NetCompanystatistics) o;
        return id == that.id &&
                companyid == that.companyid &&
                ordercount == that.ordercount &&
                Double.compare(that.moneycount, moneycount) == 0 &&
                ordercancelcount == that.ordercancelcount &&
                ordercompletecount == that.ordercompletecount &&
                soscount == that.soscount &&
                complaintcount == that.complaintcount &&
                Objects.equals(updatetime, that.updatetime) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, ordercount, moneycount, ordercancelcount, ordercompletecount, soscount, complaintcount, updatetime, createtime);
    }
}
