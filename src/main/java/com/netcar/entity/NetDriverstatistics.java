package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDriverstatistics {

    private int id;
    private int driverid;
    private int ordercount;
    private double moneycount;
    private int ordercancelcount;
    private int ordercompletecount;
    private int soscount;
    private int violatecount;
    private double mileage;
    private double duration;
    private int complainedcount;
    private Timestamp updatetime;
    private Timestamp createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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
        NetDriverstatistics that = (NetDriverstatistics) o;
        return id == that.id &&
                driverid == that.driverid &&
                ordercount == that.ordercount &&
                Double.compare(that.moneycount, moneycount) == 0 &&
                ordercancelcount == that.ordercancelcount &&
                ordercompletecount == that.ordercompletecount &&
                soscount == that.soscount &&
                violatecount == that.violatecount &&
                Double.compare(that.mileage, mileage) == 0 &&
                Double.compare(that.duration, duration) == 0 &&
                complainedcount == that.complainedcount &&
                Objects.equals(updatetime, that.updatetime) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driverid, ordercount, moneycount, ordercancelcount, ordercompletecount, soscount, violatecount, mileage, duration, complainedcount, updatetime, createtime);
    }
}
