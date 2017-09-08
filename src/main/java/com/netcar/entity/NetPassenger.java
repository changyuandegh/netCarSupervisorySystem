package com.netcar.entity;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetPassenger {

    private int psgid;
    private String psgername;
    private String psggender;
    private String companyidc;
    private Date registerdate;
    private int state;
    private String psgphone;
    private String psgpass;

    public int getPsgid() {
        return psgid;
    }

    public void setPsgid(int psgid) {
        this.psgid = psgid;
    }

    public String getPsgername() {
        return psgername;
    }

    public void setPsgername(String psgername) {
        this.psgername = psgername;
    }

    public String getPsggender() {
        return psggender;
    }

    public void setPsggender(String psggender) {
        this.psggender = psggender;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPsgphone() {
        return psgphone;
    }

    public void setPsgphone(String psgphone) {
        this.psgphone = psgphone;
    }

    public String getPsgpass() {
        return psgpass;
    }

    public void setPsgpass(String psgpass) {
        this.psgpass = psgpass;
    }

    public String getCompanyidc() {
        return companyidc;
    }

    public void setCompanyidc(String companyidc) {
        this.companyidc = companyidc;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetPassenger that = (NetPassenger) o;
        return psgid == that.psgid &&
                state == that.state &&
                Objects.equals(psggender,that.psggender)&&
                Objects.equals(psgername, that.psgername) &&
                Objects.equals(psgphone, that.psgphone) &&
                Objects.equals(psgpass, that.psgpass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(psgid, psgername, psggender, state, psgphone, psgpass);
    }
}
