package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetKeyareaalarm {

    private int id;
    private int areaid;
    private int address;
    private int vehiclenum;
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

    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getVehiclenum() {
        return vehiclenum;
    }

    public void setVehiclenum(int vehiclenum) {
        this.vehiclenum = vehiclenum;
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
        NetKeyareaalarm that = (NetKeyareaalarm) o;
        return id == that.id &&
                areaid == that.areaid &&
                address == that.address &&
                vehiclenum == that.vehiclenum &&
                Objects.equals(alarmtime, that.alarmtime) &&
                Objects.equals(state, that.state) &&
                Objects.equals(result, that.result) &&
                Objects.equals(processtime, that.processtime) &&
                Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, areaid, address, vehiclenum, alarmtime, state, result, processtime, userid);
    }
}
