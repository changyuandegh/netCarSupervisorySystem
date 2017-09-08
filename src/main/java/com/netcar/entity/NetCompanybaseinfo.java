package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetCompanybaseinfo {

    private int companyid;
    private String companyidc;
    private String companyname;
    private String identifier;
    private int address;
    private String businessscope;
    private String contactaddress;
    private String economictype;
    private String regcapital;
    private String organization;
    private Date startdate;
    private Date stopdate;
    private String certificate;
    private Date certifydate;
    private String certifystate;
    private String operationarea;
    private int vehiclenum;
    private int drivernum;
    private Integer state;
    private Integer serviceinstitutionsid;
    private Integer legalpersonid;
    private Integer fareid;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getCompanyidc() {
        return companyidc;
    }

    public void setCompanyidc(String companyidc) {
        this.companyidc = companyidc;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getBusinessscope() {
        return businessscope;
    }

    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope;
    }

    public String getContactaddress() {
        return contactaddress;
    }

    public void setContactaddress(String contactaddress) {
        this.contactaddress = contactaddress;
    }

    public String getEconomictype() {
        return economictype;
    }

    public void setEconomictype(String economictype) {
        this.economictype = economictype;
    }

    public String getRegcapital() {
        return regcapital;
    }

    public void setRegcapital(String regcapital) {
        this.regcapital = regcapital;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getStopdate() {
        return stopdate;
    }

    public void setStopdate(Date stopdate) {
        this.stopdate = stopdate;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Date getCertifydate() {
        return certifydate;
    }

    public void setCertifydate(Date certifydate) {
        this.certifydate = certifydate;
    }

    public String getCertifystate() {
        return certifystate;
    }

    public void setCertifystate(String certifystate) {
        this.certifystate = certifystate;
    }

    public String getOperationarea() {
        return operationarea;
    }

    public void setOperationarea(String operationarea) {
        this.operationarea = operationarea;
    }

    public int getVehiclenum() {
        return vehiclenum;
    }

    public void setVehiclenum(int vehiclenum) {
        this.vehiclenum = vehiclenum;
    }

    public int getDrivernum() {
        return drivernum;
    }

    public void setDrivernum(int drivernum) {
        this.drivernum = drivernum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getServiceinstitutionsid() {
        return serviceinstitutionsid;
    }

    public void setServiceinstitutionsid(Integer serviceinstitutionsid) {
        this.serviceinstitutionsid = serviceinstitutionsid;
    }

    public Integer getLegalpersonid() {
        return legalpersonid;
    }

    public void setLegalpersonid(Integer legalpersonid) {
        this.legalpersonid = legalpersonid;
    }

    public Integer getFareid() {
        return fareid;
    }

    public void setFareid(Integer fareid) {
        this.fareid = fareid;
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
        NetCompanybaseinfo that = (NetCompanybaseinfo) o;
        return companyid == that.companyid &&
                address == that.address &&
                vehiclenum == that.vehiclenum &&
                drivernum == that.drivernum &&
                Objects.equals(companyidc, that.companyidc) &&
                Objects.equals(companyname, that.companyname) &&
                Objects.equals(identifier, that.identifier) &&
                Objects.equals(businessscope, that.businessscope) &&
                Objects.equals(contactaddress, that.contactaddress) &&
                Objects.equals(economictype, that.economictype) &&
                Objects.equals(regcapital, that.regcapital) &&
                Objects.equals(organization, that.organization) &&
                Objects.equals(startdate, that.startdate) &&
                Objects.equals(stopdate, that.stopdate) &&
                Objects.equals(certificate, that.certificate) &&
                Objects.equals(certifydate, that.certifydate) &&
                Objects.equals(certifystate, that.certifystate) &&
                Objects.equals(operationarea, that.operationarea) &&
                Objects.equals(state, that.state) &&
                Objects.equals(serviceinstitutionsid, that.serviceinstitutionsid) &&
                Objects.equals(legalpersonid, that.legalpersonid) &&
                Objects.equals(fareid, that.fareid) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyid, companyidc, companyname, identifier, address, businessscope, contactaddress, economictype, regcapital, organization, startdate, stopdate, certificate, certifydate, certifystate, operationarea, vehiclenum, drivernum, state, serviceinstitutionsid, legalpersonid, fareid, createtime, updatetime);
    }
}
