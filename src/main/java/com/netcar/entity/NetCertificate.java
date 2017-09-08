package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetCertificate {

    private int netcertificateid;
    private String certificateno;
    private String networkcarinsueorganization;
    private Date getnetworkcarissuedate;
    private Date getnetworkcarproofdate;
    private Date networkcarproofon;
    private Date getnetworkcarproofoff;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getNetcertificateid() {
        return netcertificateid;
    }

    public void setNetcertificateid(int netcertificateid) {
        this.netcertificateid = netcertificateid;
    }

    public String getCertificateno() {
        return certificateno;
    }

    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno;
    }

    public String getNetworkcarinsueorganization() {
        return networkcarinsueorganization;
    }

    public void setNetworkcarinsueorganization(String networkcarinsueorganization) {
        this.networkcarinsueorganization = networkcarinsueorganization;
    }

    public Date getGetnetworkcarissuedate() {
        return getnetworkcarissuedate;
    }

    public void setGetnetworkcarissuedate(Date getnetworkcarissuedate) {
        this.getnetworkcarissuedate = getnetworkcarissuedate;
    }

    public Date getGetnetworkcarproofdate() {
        return getnetworkcarproofdate;
    }

    public void setGetnetworkcarproofdate(Date getnetworkcarproofdate) {
        this.getnetworkcarproofdate = getnetworkcarproofdate;
    }

    public Date getNetworkcarproofon() {
        return networkcarproofon;
    }

    public void setNetworkcarproofon(Date networkcarproofon) {
        this.networkcarproofon = networkcarproofon;
    }

    public Date getGetnetworkcarproofoff() {
        return getnetworkcarproofoff;
    }

    public void setGetnetworkcarproofoff(Date getnetworkcarproofoff) {
        this.getnetworkcarproofoff = getnetworkcarproofoff;
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
        NetCertificate that = (NetCertificate) o;
        return netcertificateid == that.netcertificateid &&
                Objects.equals(certificateno, that.certificateno) &&
                Objects.equals(networkcarinsueorganization, that.networkcarinsueorganization) &&
                Objects.equals(getnetworkcarissuedate, that.getnetworkcarissuedate) &&
                Objects.equals(getnetworkcarproofdate, that.getnetworkcarproofdate) &&
                Objects.equals(networkcarproofon, that.networkcarproofon) &&
                Objects.equals(getnetworkcarproofoff, that.getnetworkcarproofoff) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(netcertificateid, certificateno, networkcarinsueorganization, getnetworkcarissuedate, getnetworkcarproofdate, networkcarproofon, getnetworkcarproofoff, createtime, updatetime);
    }
}
