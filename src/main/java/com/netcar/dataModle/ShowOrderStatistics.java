package com.netcar.dataModle;

import com.netcar.entity.NetOrderstatistics;

import java.util.List;

/**
 * Created by Wby on 2017/5/16.
 */
public class ShowOrderStatistics {

    List<AjaxMessage> timeStatistics;//当日各时段订单量、完成量图表数据
    List<AjaxMessage> companyStatistics;//当日各公司订单量、完成量图标数据
    List<ProportionData> companyProportion;//当日各公司订单占比

    public List<AjaxMessage> getTimeStatistics() {
        return timeStatistics;
    }

    public void setTimeStatistics(List<AjaxMessage> timeStatistics) {
        this.timeStatistics = timeStatistics;
    }

    public List<AjaxMessage> getCompanyStatistics() {
        return companyStatistics;
    }

    public void setCompanyStatistics(List<AjaxMessage> companyStatistics) {
        this.companyStatistics = companyStatistics;
    }

    public List<ProportionData> getCompanyProportion() {
        return companyProportion;
    }

    public void setCompanyProportion(List<ProportionData> companyProportion) {
        this.companyProportion = companyProportion;
    }



}
