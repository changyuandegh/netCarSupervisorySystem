package com.netcar.entity;

import java.sql.Date;

/**
 * Created by Mander on 2017/6/13.
 */
public class NetRatedDriver {

    private int id;
    private String companyidc;
    private String licenseid;
    private int level;//'服务质量等级'
    private Date testdate;//'考核日期'
    private String testdepartment;//'考核机构'

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
}
