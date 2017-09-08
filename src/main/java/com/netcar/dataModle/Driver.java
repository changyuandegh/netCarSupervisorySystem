package com.netcar.dataModle;

import java.sql.Timestamp;

/**
 * Created by Mander on 2017/5/8.
 * 显示的司机
 */
public class Driver {
    //姓名、手机号、所属公司、营运状态
    private String drivername;
    private String drivergender;
    private Timestamp contracton;//合同有效期起
    private  String licenseid;//驾驶证

    private String phone;//手机号
    private String company;//所属公司名称
    private String operationState;//营运状态



    public Driver() {

    }

    public Driver(String drivername, String drivergender, Timestamp contracton, String licenseid) {
        this.drivername = drivername;
        this.drivergender = drivergender;
        this.contracton = contracton;
        this.licenseid = licenseid;
    }

    public Driver(String drivername, String drivergender, Timestamp contracton, String licenseid, String phone, String company, String operationState) {
        this.drivername = drivername;
        this.drivergender = drivergender;
        this.contracton = contracton;
        this.licenseid = licenseid;
        this.phone = phone;
        this.company = company;
        this.operationState = operationState;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDrivergender() {
        return drivergender;
    }

    public void setDrivergender(String drivergender) {
        this.drivergender = drivergender;
    }

    public Timestamp getContracton() {
        return contracton;
    }

    public void setContracton(Timestamp contracton) {
        this.contracton = contracton;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOperationState() {
        return operationState;
    }

    public void setOperationState(String operationState) {
        this.operationState = operationState;
    }
}
