package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDriveronlinestatistics {

    private int id;
    private int companyid;
    private int address;
    private int onlinecount;
    private int total;
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

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getOnlinecount() {
        return onlinecount;
    }

    public void setOnlinecount(int onlinecount) {
        this.onlinecount = onlinecount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
        NetDriveronlinestatistics that = (NetDriveronlinestatistics) o;
        return id == that.id &&
                companyid == that.companyid &&
                address == that.address &&
                onlinecount == that.onlinecount &&
                total == that.total &&
                statisticsdate == that.statisticsdate &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, address, onlinecount, total, statisticsdate, createtime);
    }
}
