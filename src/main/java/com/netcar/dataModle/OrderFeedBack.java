package com.netcar.dataModle;

/**
 * Created by Mander on 2017/6/14.
 * 评价反馈内容显示
 */
public class OrderFeedBack {

    private String orderid;
    private String ordertime;
    private String vechelno;
    private String passagetPhone;
    private String licenseid;

    private String servicescore;//评价等级
    private String detail;//评价内容

    //投诉建议
    private String complaintDetail;//投诉内容
    private String result;//处理结果

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getVechelno() {
        return vechelno;
    }

    public void setVechelno(String vechelno) {
        this.vechelno = vechelno;
    }

    public String getPassagetPhone() {
        return passagetPhone;
    }

    public void setPassagetPhone(String passagetPhone) {
        this.passagetPhone = passagetPhone;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public String getServicescore() {
        return servicescore;
    }

    public void setServicescore(String servicescore) {
        this.servicescore = servicescore;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getComplaintDetail() {
        return complaintDetail;
    }

    public void setComplaintDetail(String complaintDetail) {
        this.complaintDetail = complaintDetail;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
