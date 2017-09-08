package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetSosstatistics {

    private int id;
    private int companyid;
    private int address;
    private int total;
    private String category;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        NetSosstatistics that = (NetSosstatistics) o;
        return id == that.id &&
                companyid == that.companyid &&
                address == that.address &&
                total == that.total &&
                Objects.equals(category, that.category) &&
                Objects.equals(statisticsdate, that.statisticsdate) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, address, total, category, statisticsdate, createtime);
    }
}
