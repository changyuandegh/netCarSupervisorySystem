package com.netcar.tet;

import java.sql.Date;

/**
 * Created by Mander on 2017/6/13.
 */
public class NetRateddriver {

    private int id;
    private String companyidc;
    private String licenseid;
    private int level;
    private Date testdate;
    private String testdepartment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyidc() {
        return companyidc;
    }

    public void setCompanyidc(String companyidc) {
        this.companyidc = companyidc;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
    }

    public String getTestdepartment() {
        return testdepartment;
    }

    public void setTestdepartment(String testdepartment) {
        this.testdepartment = testdepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetRateddriver that = (NetRateddriver) o;

        if (id != that.id) return false;
        if (level != that.level) return false;
        if (companyidc != null ? !companyidc.equals(that.companyidc) : that.companyidc != null) return false;
        if (licenseid != null ? !licenseid.equals(that.licenseid) : that.licenseid != null) return false;
        if (testdate != null ? !testdate.equals(that.testdate) : that.testdate != null) return false;
        if (testdepartment != null ? !testdepartment.equals(that.testdepartment) : that.testdepartment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (companyidc != null ? companyidc.hashCode() : 0);
        result = 31 * result + (licenseid != null ? licenseid.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + (testdate != null ? testdate.hashCode() : 0);
        result = 31 * result + (testdepartment != null ? testdepartment.hashCode() : 0);
        return result;
    }
}
