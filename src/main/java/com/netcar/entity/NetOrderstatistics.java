package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetOrderstatistics {

    private int id;
    private int companyid;
    private int address;
    private int total;
    private int completecount;
    private int cancelcount;
    private Integer immediatecount;
    private Integer reservationcount;
    private double money;
    private double mileage;
    private Timestamp updatetime;
    private Timestamp createtime;
    private double duration;
    private Timestamp statisticsdate;

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

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCompletecount() {
        return completecount;
    }

    public void setCompletecount(int completecount) {
        this.completecount = completecount;
    }

    public int getCancelcount() {
        return cancelcount;
    }

    public void setCancelcount(int cancelcount) {
        this.cancelcount = cancelcount;
    }

    public Integer getImmediatecount() {
        return immediatecount;
    }

    public void setImmediatecount(Integer immediatecount) {
        this.immediatecount = immediatecount;
    }

    public Integer getReservationcount() {
        return reservationcount;
    }

    public void setReservationcount(Integer reservationcount) {
        this.reservationcount = reservationcount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Timestamp getStatisticsdate() {
        return statisticsdate;
    }

    public void setStatisticsdate(Timestamp statisticsdate) {
        this.statisticsdate = statisticsdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetOrderstatistics that = (NetOrderstatistics) o;
        return id == that.id &&
                companyid == that.companyid &&
                address == that.address &&
                total == that.total &&
                completecount == that.completecount &&
                cancelcount == that.cancelcount &&
                Double.compare(that.money, money) == 0 &&
                Double.compare(that.mileage, mileage) == 0 &&
                Double.compare(that.duration, duration) == 0 &&
                Objects.equals(immediatecount, that.immediatecount) &&
                Objects.equals(reservationcount, that.reservationcount) &&
                Objects.equals(updatetime, that.updatetime) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(statisticsdate, that.statisticsdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, address, total, completecount, cancelcount, immediatecount, reservationcount, money, mileage, updatetime, createtime, duration, statisticsdate);
    }

    @Override
    public String toString() {
        return "NetOrderstatistics{" +
                "id=" + id +
                ", companyid=" + companyid +
                ", address=" + address +
                ", total=" + total +
                ", completecount=" + completecount +
                ", cancelcount=" + cancelcount +
                ", immediatecount=" + immediatecount +
                ", reservationcount=" + reservationcount +
                ", money=" + money +
                ", mileage=" + mileage +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", duration=" + duration +
                ", statisticsdate=" + statisticsdate +
                '}';
    }
}
