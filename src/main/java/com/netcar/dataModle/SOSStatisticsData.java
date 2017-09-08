package com.netcar.dataModle;

import com.netcar.entity.NetSosstatistics;

/**
 * Created by Work on 2017/5/10.
 */
public class SOSStatisticsData {
    private int companyid;
    private String companyName;
    private int areaCode;
    private String area;
    private int total;
    private String category;




    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SOSStatisticsData{" +
                "companyid=" + companyid +
                ", companyName='" + companyName + '\'' +
                ", areaCode=" + areaCode +
                ", area='" + area + '\'' +
                ", total=" + total +
                ", category='" + category + '\'' +
                '}';
    }
}
