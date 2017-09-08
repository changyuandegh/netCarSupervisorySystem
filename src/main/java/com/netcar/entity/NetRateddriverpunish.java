package com.netcar.entity;

import java.sql.Timestamp;

/**
 * Created by Mander on 2017/6/13.
 */
public class NetRateddriverpunish {

    private int id;
    private String companyidc;
    private String licenseid;
    private Timestamp punishtime;
    private String punishreason;
    private String punishresult;

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

    public Timestamp getPunishtime() {
        return punishtime;
    }

    public void setPunishtime(Timestamp punishtime) {
        this.punishtime = punishtime;
    }

    public String getPunishreason() {
        return punishreason;
    }

    public void setPunishreason(String punishreason) {
        this.punishreason = punishreason;
    }

    public String getPunishresult() {
        return punishresult;
    }

    public void setPunishresult(String punishresult) {
        this.punishresult = punishresult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetRateddriverpunish that = (NetRateddriverpunish) o;

        if (id != that.id) return false;
        if (companyidc != null ? !companyidc.equals(that.companyidc) : that.companyidc != null) return false;
        if (licenseid != null ? !licenseid.equals(that.licenseid) : that.licenseid != null) return false;
        if (punishtime != null ? !punishtime.equals(that.punishtime) : that.punishtime != null) return false;
        if (punishreason != null ? !punishreason.equals(that.punishreason) : that.punishreason != null) return false;
        if (punishresult != null ? !punishresult.equals(that.punishresult) : that.punishresult != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (companyidc != null ? companyidc.hashCode() : 0);
        result = 31 * result + (licenseid != null ? licenseid.hashCode() : 0);
        result = 31 * result + (punishtime != null ? punishtime.hashCode() : 0);
        result = 31 * result + (punishreason != null ? punishreason.hashCode() : 0);
        result = 31 * result + (punishresult != null ? punishresult.hashCode() : 0);
        return result;
    }
}
