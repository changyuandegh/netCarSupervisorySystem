package com.netcar.dataModle;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 运价信息
 * Created by Administrator on 2017/6/14.
 */
public class FareInfoData {

    private int fareid;
    //公司名称
    private String company;
    //行政区域
    private String name;
    //有效期起
    private Timestamp farevalidon;
    //有效期止
    private Timestamp farevalidoff;
    //起步价(元)
    private Double startfare;
    //起步里程(km)
    private Double startmile;
    //计程单价
    private Double unitpricepermile;
    //计时单价
    private Double unitpriceperminute;
    //夜间费:元（公里）
    private Double nightpricepermile;
    //夜间费：（分）
    private Double nightpriceperminute;
    //状态
    private int pricestate;
    //运价类型编码
    private String faretype;
    //运价类型说明
    private String faretypenote;
    //营运早高峰时间起
    private Timestamp morningpeaktimeon;
    //营运早高峰时间止
    private Timestamp morningpeaktimeoff;
    //晚高峰时间起
    private Timestamp eveningpeaktimeon;
    //晚高峰时间止
    private Timestamp eveningpeaktimeoff;
    //其它高峰时间起
    private Timestamp otherpeaktimeon;
    //其它高峰时间止
    private Timestamp otherpeaktimeoff;
    //高峰时间单程加价单价
    private Double peakunitprice;
    //高峰时间单价加价公里
    private Double peakpricestartmile;
    //低速计时加价(分钟)：元
    private Double lowspeedpriceperminute;
    //其它加价金额：元
    private Double otherprice;
    //记录更新时间
    private Timestamp updatetime;
    //单程单程加价单价
    private Double upprice;
    //单程加价公里
    private Double uppricestartmile;
    public Double getUpprice() {
        return upprice;
    }

    public void setUpprice(Double upprice) {
        this.upprice = upprice;
    }

    public Double getUppricestartmile() {
        return uppricestartmile;
    }

    public int getFareid() {
        return fareid;
    }

    public void setFareid(int fareid) {
        this.fareid = fareid;
    }

    public void setUppricestartmile(Double uppricestartmile) {
        this.uppricestartmile = uppricestartmile;
    }

    public FareInfoData(){};

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getFarevalidon() {
        return farevalidon;
    }

    public void setFarevalidon(Timestamp farevalidon) {
        this.farevalidon = farevalidon;
    }

    public Timestamp getFarevalidoff() {
        return farevalidoff;
    }

    public void setFarevalidoff(Timestamp farevalidoff) {
        this.farevalidoff = farevalidoff;
    }

    public Double getStartfare() {
        return startfare;
    }

    public void setStartfare(Double startfare) {
        this.startfare = startfare;
    }

    public Double getStartmile() {
        return startmile;
    }

    public void setStartmile(Double startmile) {
        this.startmile = startmile;
    }

    public Double getUnitpricepermile() {
        return unitpricepermile;
    }

    public void setUnitpricepermile(Double unitpricepermile) {
        this.unitpricepermile = unitpricepermile;
    }

    public Double getUnitpriceperminute() {
        return unitpriceperminute;
    }

    public void setUnitpriceperminute(Double unitpriceperminute) {
        this.unitpriceperminute = unitpriceperminute;
    }

    public Double getNightpricepermile() {
        return nightpricepermile;
    }

    public void setNightpricepermile(Double nightpricepermile) {
        this.nightpricepermile = nightpricepermile;
    }

    public Double getNightpriceperminute() {
        return nightpriceperminute;
    }

    public void setNightpriceperminute(Double nightpriceperminute) {
        this.nightpriceperminute = nightpriceperminute;
    }

    public int getPricestate() {
        return pricestate;
    }

    public void setPricestate(int pricestate) {
        this.pricestate = pricestate;
    }

    public String getFaretype() {
        return faretype;
    }

    public void setFaretype(String faretype) {
        this.faretype = faretype;
    }

    public String getFaretypenote() {
        return faretypenote;
    }

    public void setFaretypenote(String faretypenote) {
        this.faretypenote = faretypenote;
    }

    public Timestamp getMorningpeaktimeon() {
        return morningpeaktimeon;
    }

    public void setMorningpeaktimeon(Timestamp morningpeaktimeon) {
        this.morningpeaktimeon = morningpeaktimeon;
    }

    public Timestamp getMorningpeaktimeoff() {
        return morningpeaktimeoff;
    }

    public void setMorningpeaktimeoff(Timestamp morningpeaktimeoff) {
        this.morningpeaktimeoff = morningpeaktimeoff;
    }

    public Timestamp getEveningpeaktimeon() {
        return eveningpeaktimeon;
    }

    public void setEveningpeaktimeon(Timestamp eveningpeaktimeon) {
        this.eveningpeaktimeon = eveningpeaktimeon;
    }

    public Timestamp getEveningpeaktimeoff() {
        return eveningpeaktimeoff;
    }

    public void setEveningpeaktimeoff(Timestamp eveningpeaktimeoff) {
        this.eveningpeaktimeoff = eveningpeaktimeoff;
    }

    public Timestamp getOtherpeaktimeon() {
        return otherpeaktimeon;
    }

    public void setOtherpeaktimeon(Timestamp otherpeaktimeon) {
        this.otherpeaktimeon = otherpeaktimeon;
    }

    public Timestamp getOtherpeaktimeoff() {
        return otherpeaktimeoff;
    }

    public void setOtherpeaktimeoff(Timestamp otherpeaktimeoff) {
        this.otherpeaktimeoff = otherpeaktimeoff;
    }

    public Double getPeakunitprice() {
        return peakunitprice;
    }

    public void setPeakunitprice(Double peakunitprice) {
        this.peakunitprice = peakunitprice;
    }

    public Double getPeakpricestartmile() {
        return peakpricestartmile;
    }

    public void setPeakpricestartmile(Double peakpricestartmile) {
        this.peakpricestartmile = peakpricestartmile;
    }

    public Double getLowspeedpriceperminute() {
        return lowspeedpriceperminute;
    }

    public void setLowspeedpriceperminute(Double lowspeedpriceperminute) {this.lowspeedpriceperminute = lowspeedpriceperminute;}
    public Double getOtherprice() {
        return otherprice;
    }

    public void setOtherprice(Double otherprice) {
        this.otherprice = otherprice;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }
}
