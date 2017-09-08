package com.netcar.dataModle;

/**
 * Created by Mander on 2017/6/15.
 */
public class OrderAfterSales {

    private String servicescore;//评分
    private String detail;//评价内容
    private String complaintDetail;//投诉建议

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
}
