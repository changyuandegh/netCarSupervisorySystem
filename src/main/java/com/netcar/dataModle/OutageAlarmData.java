package com.netcar.dataModle;

import java.util.Date;

/**
 * Created by Wby on 2017/5/17.
 * 聚集报警信息
 */
public class OutageAlarmData {
    private int id;
    private int companyId;
    private String companyName;
    private int address;
    private String addressName;
    private int ougageNum;
    private int vechileTotal;
    private Date alarmTime;
    private int state;
    private String result;
    private Date processTime;

    public OutageAlarmData() {
    }

    public OutageAlarmData(int id, int companyId, String companyName, int address, String addressName, int ougageNum, int vechileTotal, Date alarmTime, int state, String result, Date processTime) {
        this.id = id;
        this.companyId = companyId;
        this.companyName = companyName;
        this.address = address;
        this.addressName = addressName;
        this.ougageNum = ougageNum;
        this.vechileTotal = vechileTotal;
        this.alarmTime = alarmTime;
        this.state = state;
        this.result = result;
        this.processTime = processTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public String getAddressName() {
        return addressName;

    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public int getOugageNum() {
        return ougageNum;
    }

    public void setOugageNum(int ougageNum) {
        this.ougageNum = ougageNum;
    }

    public int getVechileTotal() {
        return vechileTotal;
    }

    public void setVechileTotal(int vechileTotal) {
        this.vechileTotal = vechileTotal;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "OutageAlarmData{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", address=" + address +
                ", addressName='" + addressName + '\'' +
                ", ougageNum=" + ougageNum +
                ", vechileTotal=" + vechileTotal +
                ", alarmTime=" + alarmTime +
                ", state=" + state +
                ", result='" + result + '\'' +
                ", processTime=" + processTime +
                '}';
    }
}
