package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDriveronlinetimestatistics {

    private int id;
    private int companyid;
    private int driverid;
    private double duration;
    private Timestamp statisticsdate;
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

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
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
        NetDriveronlinetimestatistics that = (NetDriveronlinetimestatistics) o;
        return id == that.id &&
                companyid == that.companyid &&
                driverid == that.driverid &&
                Double.compare(that.duration, duration) == 0 &&
                Objects.equals(statisticsdate, that.statisticsdate) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, driverid, duration, statisticsdate, createtime);
    }
}
