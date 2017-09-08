package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetPassengerstatistics {

    private int id;
    private int psgid;
    private int ordercount;
    private double moneycount;
    private int ordercancelcount;
    private int ordercompletecount;
    private int violatecount;
    private double mileage;
    private int complainedcount;
    private Timestamp updatetime;
    private Timestamp createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPsgid() {
        return psgid;
    }

    public void setPsgid(int psgid) {
        this.psgid = psgid;
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

    public int getViolatecount() {
        return violatecount;
    }

    public void setViolatecount(int violatecount) {
        this.violatecount = violatecount;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getComplainedcount() {
        return complainedcount;
    }

    public void setComplainedcount(int complainedcount) {
        this.complainedcount = complainedcount;
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
        NetPassengerstatistics that = (NetPassengerstatistics) o;
        return id == that.id &&
                psgid == that.psgid &&
                ordercount == that.ordercount &&
                Double.compare(that.moneycount, moneycount) == 0 &&
                ordercancelcount == that.ordercancelcount &&
                ordercompletecount == that.ordercompletecount &&
                violatecount == that.violatecount &&
                Double.compare(that.mileage, mileage) == 0 &&
                complainedcount == that.complainedcount &&
                Objects.equals(updatetime, that.updatetime) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, psgid, ordercount, moneycount, ordercancelcount, ordercompletecount, violatecount, mileage, complainedcount, updatetime, createtime);
    }
}
