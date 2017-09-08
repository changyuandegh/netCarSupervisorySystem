package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetUseraddstatistics {

    private int id;
    private int companyid;
    private int address;
    private int psgtotal;
    private int psgnewcount;
    private int drivertotal;
    private int drivernewcount;
    private int vechiletotal;
    private int vechilenewtotal;
    private Date statisticsdate;
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

    public int getPsgtotal() {
        return psgtotal;
    }

    public void setPsgtotal(int psgtotal) {
        this.psgtotal = psgtotal;
    }

    public int getPsgnewcount() {
        return psgnewcount;
    }

    public void setPsgnewcount(int psgnewcount) {
        this.psgnewcount = psgnewcount;
    }

    public int getDrivertotal() {
        return drivertotal;
    }

    public void setDrivertotal(int drivertotal) {
        this.drivertotal = drivertotal;
    }

    public int getDrivernewcount() {
        return drivernewcount;
    }

    public void setDrivernewcount(int drivernewcount) {
        this.drivernewcount = drivernewcount;
    }

    public int getVechiletotal() {
        return vechiletotal;
    }

    public void setVechiletotal(int vechiletotal) {
        this.vechiletotal = vechiletotal;
    }

    public int getVechilenewtotal() {
        return vechilenewtotal;
    }

    public void setVechilenewtotal(int vechilenewtotal) {
        this.vechilenewtotal = vechilenewtotal;
    }

    public Date getStatisticsdate() {
        return statisticsdate;
    }

    public void setStatisticsdate(Date statisticsdate) {
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
        NetUseraddstatistics that = (NetUseraddstatistics) o;
        return id == that.id &&
                companyid == that.companyid &&
                address == that.address &&
                psgtotal == that.psgtotal &&
                psgnewcount == that.psgnewcount &&
                drivertotal == that.drivertotal &&
                drivernewcount == that.drivernewcount &&
                vechiletotal == that.vechiletotal &&
                vechilenewtotal == that.vechilenewtotal &&
                Objects.equals(statisticsdate, that.statisticsdate) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, address, psgtotal, psgnewcount, drivertotal, drivernewcount, vechiletotal, vechilenewtotal, statisticsdate, createtime);
    }
}
