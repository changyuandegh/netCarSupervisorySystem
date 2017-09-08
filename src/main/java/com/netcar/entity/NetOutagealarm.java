package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetOutagealarm {

    private int id;
    private int companyid;
    private int address;
    private int outagenum;
    private int vehicletotal;
    private Timestamp alarmtime;
    private Integer state;
    private String result;
    private Timestamp processtime;
    private Integer userid;

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

    public int getOutagenum() {
        return outagenum;
    }

    public void setOutagenum(int outagenum) {
        this.outagenum = outagenum;
    }

    public int getVehicletotal() {
        return vehicletotal;
    }

    public void setVehicletotal(int vehicletotal) {
        this.vehicletotal = vehicletotal;
    }

    public Timestamp getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(Timestamp alarmtime) {
        this.alarmtime = alarmtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getProcesstime() {
        return processtime;
    }

    public void setProcesstime(Timestamp processtime) {
        this.processtime = processtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetOutagealarm that = (NetOutagealarm) o;
        return id == that.id &&
                companyid == that.companyid &&
                address == that.address &&
                outagenum == that.outagenum &&
                vehicletotal == that.vehicletotal &&
                Objects.equals(alarmtime, that.alarmtime) &&
                Objects.equals(state, that.state) &&
                Objects.equals(result, that.result) &&
                Objects.equals(processtime, that.processtime) &&
                Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyid, address, outagenum, vehicletotal, alarmtime, state, result, processtime, userid);
    }
}
