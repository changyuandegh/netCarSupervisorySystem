package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDriverbaseinfo {

    private int driverid;
    private int companyid;
    private int address;
    private String drivername;
    private String driverphone;
    private String drivergender;
    private Date driverbirthday;
    private String drivernationality;
    private String drirvernation;
    private String drivermaritalstatus;
    private String drirverlanguagelevel;
    private String drivereducation;
    private String drivercensus;
    private String driveraddress;
    private String drirvercontactaddress;
    private String photoid;
    private String licenseid;
    private String licensephotoid;
    private String drivertype;
    private Date getdriverlicensedate;
    private Date driverlicenseon;
    private Date drverlicenseoff;
    private int tavidriver;
    private String emergencycontact;
    private String emergencycontactphone;
    private String emergencycontactaddress;
    private int state;
    private Date registerdate;
    private String contractcompany;
    private Timestamp contracton;
    private Timestamp getnetworkcarproofdate;
    private Integer fulltimedriver;
    private Integer indriverblacklist;
    private int commercialtype;
    private double cycle;
    private String ordercount;
    private String trafficviolationcount;
    private String complainedcount;
    private int creditpoints;
    private Integer netcertificateid;
    private Integer driverappinfoid;
    private Integer courseid;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
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

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
    }

    public String getDrivergender() {
        return drivergender;
    }

    public void setDrivergender(String drivergender) {
        this.drivergender = drivergender;
    }

    public Date getDriverbirthday() {
        return driverbirthday;
    }

    public void setDriverbirthday(Date driverbirthday) {
        this.driverbirthday = driverbirthday;
    }

    public String getDrivernationality() {
        return drivernationality;
    }

    public void setDrivernationality(String drivernationality) {
        this.drivernationality = drivernationality;
    }

    public String getDrirvernation() {
        return drirvernation;
    }

    public void setDrirvernation(String drirvernation) {
        this.drirvernation = drirvernation;
    }

    public String getDrivermaritalstatus() {
        return drivermaritalstatus;
    }

    public void setDrivermaritalstatus(String drivermaritalstatus) {
        this.drivermaritalstatus = drivermaritalstatus;
    }

    public String getDrirverlanguagelevel() {
        return drirverlanguagelevel;
    }

    public void setDrirverlanguagelevel(String drirverlanguagelevel) {
        this.drirverlanguagelevel = drirverlanguagelevel;
    }

    public String getDrivereducation() {
        return drivereducation;
    }

    public void setDrivereducation(String drivereducation) {
        this.drivereducation = drivereducation;
    }

    public String getDrivercensus() {
        return drivercensus;
    }

    public void setDrivercensus(String drivercensus) {
        this.drivercensus = drivercensus;
    }

    public String getDriveraddress() {
        return driveraddress;
    }

    public void setDriveraddress(String driveraddress) {
        this.driveraddress = driveraddress;
    }

    public String getDrirvercontactaddress() {
        return drirvercontactaddress;
    }

    public void setDrirvercontactaddress(String drirvercontactaddress) {
        this.drirvercontactaddress = drirvercontactaddress;
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public String getLicensephotoid() {
        return licensephotoid;
    }

    public void setLicensephotoid(String licensephotoid) {
        this.licensephotoid = licensephotoid;
    }

    public String getDrivertype() {
        return drivertype;
    }

    public void setDrivertype(String drivertype) {
        this.drivertype = drivertype;
    }

    public Date getGetdriverlicensedate() {
        return getdriverlicensedate;
    }

    public void setGetdriverlicensedate(Date getdriverlicensedate) {
        this.getdriverlicensedate = getdriverlicensedate;
    }

    public Date getDriverlicenseon() {
        return driverlicenseon;
    }

    public void setDriverlicenseon(Date driverlicenseon) {
        this.driverlicenseon = driverlicenseon;
    }

    public Date getDrverlicenseoff() {
        return drverlicenseoff;
    }

    public void setDrverlicenseoff(Date drverlicenseoff) {
        this.drverlicenseoff = drverlicenseoff;
    }

    public int getTavidriver() {
        return tavidriver;
    }

    public void setTavidriver(int tavidriver) {
        this.tavidriver = tavidriver;
    }

    public String getEmergencycontact() {
        return emergencycontact;
    }

    public void setEmergencycontact(String emergencycontact) {
        this.emergencycontact = emergencycontact;
    }

    public String getEmergencycontactphone() {
        return emergencycontactphone;
    }

    public void setEmergencycontactphone(String emergencycontactphone) {
        this.emergencycontactphone = emergencycontactphone;
    }

    public String getEmergencycontactaddress() {
        return emergencycontactaddress;
    }

    public void setEmergencycontactaddress(String emergencycontactaddress) {
        this.emergencycontactaddress = emergencycontactaddress;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getContractcompany() {
        return contractcompany;
    }

    public void setContractcompany(String contractcompany) {
        this.contractcompany = contractcompany;
    }

    public Timestamp getContracton() {
        return contracton;
    }

    public void setContracton(Timestamp contracton) {
        this.contracton = contracton;
    }

    public Timestamp getGetnetworkcarproofdate() {
        return getnetworkcarproofdate;
    }

    public void setGetnetworkcarproofdate(Timestamp getnetworkcarproofdate) {
        this.getnetworkcarproofdate = getnetworkcarproofdate;
    }

    public Integer getFulltimedriver() {
        return fulltimedriver;
    }

    public void setFulltimedriver(Integer fulltimedriver) {
        this.fulltimedriver = fulltimedriver;
    }

    public Integer getIndriverblacklist() {
        return indriverblacklist;
    }

    public void setIndriverblacklist(Integer indriverblacklist) {
        this.indriverblacklist = indriverblacklist;
    }

    public int getCommercialtype() {
        return commercialtype;
    }

    public void setCommercialtype(int commercialtype) {
        this.commercialtype = commercialtype;
    }

    public double getCycle() {
        return cycle;
    }

    public void setCycle(double cycle) {
        this.cycle = cycle;
    }

    public String getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(String ordercount) {
        this.ordercount = ordercount;
    }

    public String getTrafficviolationcount() {
        return trafficviolationcount;
    }

    public void setTrafficviolationcount(String trafficviolationcount) {
        this.trafficviolationcount = trafficviolationcount;
    }

    public String getComplainedcount() {
        return complainedcount;
    }

    public void setComplainedcount(String complainedcount) {
        this.complainedcount = complainedcount;
    }

    public int getCreditpoints() {
        return creditpoints;
    }

    public void setCreditpoints(int creditpoints) {
        this.creditpoints = creditpoints;
    }

    public Integer getNetcertificateid() {
        return netcertificateid;
    }

    public void setNetcertificateid(Integer netcertificateid) {
        this.netcertificateid = netcertificateid;
    }

    public Integer getDriverappinfoid() {
        return driverappinfoid;
    }

    public void setDriverappinfoid(Integer driverappinfoid) {
        this.driverappinfoid = driverappinfoid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
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
        NetDriverbaseinfo that = (NetDriverbaseinfo) o;
        return driverid == that.driverid &&
                companyid == that.companyid &&
                address == that.address &&
                tavidriver == that.tavidriver &&
                state == that.state &&
                commercialtype == that.commercialtype &&
                Double.compare(that.cycle, cycle) == 0 &&
                creditpoints == that.creditpoints &&
                Objects.equals(drivername, that.drivername) &&
                Objects.equals(driverphone, that.driverphone) &&
                Objects.equals(drivergender, that.drivergender) &&
                Objects.equals(driverbirthday, that.driverbirthday) &&
                Objects.equals(drivernationality, that.drivernationality) &&
                Objects.equals(drirvernation, that.drirvernation) &&
                Objects.equals(drivermaritalstatus, that.drivermaritalstatus) &&
                Objects.equals(drirverlanguagelevel, that.drirverlanguagelevel) &&
                Objects.equals(drivereducation, that.drivereducation) &&
                Objects.equals(drivercensus, that.drivercensus) &&
                Objects.equals(driveraddress, that.driveraddress) &&
                Objects.equals(drirvercontactaddress, that.drirvercontactaddress) &&
                Objects.equals(photoid, that.photoid) &&
                Objects.equals(licenseid, that.licenseid) &&
                Objects.equals(licensephotoid, that.licensephotoid) &&
                Objects.equals(drivertype, that.drivertype) &&
                Objects.equals(getdriverlicensedate, that.getdriverlicensedate) &&
                Objects.equals(driverlicenseon, that.driverlicenseon) &&
                Objects.equals(drverlicenseoff, that.drverlicenseoff) &&
                Objects.equals(emergencycontact, that.emergencycontact) &&
                Objects.equals(emergencycontactphone, that.emergencycontactphone) &&
                Objects.equals(emergencycontactaddress, that.emergencycontactaddress) &&
                Objects.equals(registerdate, that.registerdate) &&
                Objects.equals(contractcompany, that.contractcompany) &&
                Objects.equals(contracton, that.contracton) &&
                Objects.equals(getnetworkcarproofdate, that.getnetworkcarproofdate) &&
                Objects.equals(fulltimedriver, that.fulltimedriver) &&
                Objects.equals(indriverblacklist, that.indriverblacklist) &&
                Objects.equals(ordercount, that.ordercount) &&
                Objects.equals(trafficviolationcount, that.trafficviolationcount) &&
                Objects.equals(complainedcount, that.complainedcount) &&
                Objects.equals(netcertificateid, that.netcertificateid) &&
                Objects.equals(driverappinfoid, that.driverappinfoid) &&
                Objects.equals(courseid, that.courseid) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverid, companyid, address, drivername, driverphone, drivergender, driverbirthday, drivernationality, drirvernation, drivermaritalstatus, drirverlanguagelevel, drivereducation, drivercensus, driveraddress, drirvercontactaddress, photoid, licenseid, licensephotoid, drivertype, getdriverlicensedate, driverlicenseon, drverlicenseoff, tavidriver, emergencycontact, emergencycontactphone, emergencycontactaddress, state, registerdate, contractcompany, contracton, getnetworkcarproofdate, fulltimedriver, indriverblacklist, commercialtype, cycle, ordercount, trafficviolationcount, complainedcount, creditpoints, netcertificateid, driverappinfoid, courseid, createtime, updatetime);
    }
}
