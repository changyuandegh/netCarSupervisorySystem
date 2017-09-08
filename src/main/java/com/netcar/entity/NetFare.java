package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetFare {

    private int fareid;
    private String companyidc;
    private String faretype;
    private String faretypenote;
    private Timestamp farevalidon;
    private Timestamp farevalidoff;
    private double startfare;
    private double startmile;
    private double unitpricepermile;
    private double unitpriceperminute;
    private Double upprice;
    private Double uppricestartmile;
    private Timestamp morningpeaktimeon;
    private Timestamp morningpeaktimeoff;
    private Timestamp eveningpeaktimeon;
    private Timestamp eveningpeaktimeoff;
    private Timestamp otherpeaktimeoff;
    private Double peakunitprice;
    private Double peakpricestartmile;
    private Double lowspeedpriceperminute;
    private Double nightpricepermile;
    private Double otherprice;
    private int pricestate;
    private String nightpriceperminute;
    private Timestamp otherpeaktimeon;
    private Integer prioritylevel;
    private Double waitfree;
    private Double ratio;
    private Timestamp nightstart;
    private Double waittime;
    private Double waitprice;
    private Timestamp waitstartbillingtime;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getFareid() {
        return fareid;
    }

    public void setFareid(int fareid) {
        this.fareid = fareid;
    }


    public String getCompanyidc() {
        return companyidc;
    }

    public void setCompanyidc(String companyidc) {
        this.companyidc = companyidc;
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

    public double getStartfare() {
        return startfare;
    }

    public void setStartfare(double startfare) {
        this.startfare = startfare;
    }

    public double getStartmile() {
        return startmile;
    }

    public void setStartmile(double startmile) {
        this.startmile = startmile;
    }

    public double getUnitpricepermile() {
        return unitpricepermile;
    }

    public void setUnitpricepermile(double unitpricepermile) {
        this.unitpricepermile = unitpricepermile;
    }

    public double getUnitpriceperminute() {
        return unitpriceperminute;
    }

    public void setUnitpriceperminute(double unitpriceperminute) {
        this.unitpriceperminute = unitpriceperminute;
    }

    public Double getUpprice() {
        return upprice;
    }

    public void setUpprice(Double upprice) {
        this.upprice = upprice;
    }

    public Double getUppricestartmile() {
        return uppricestartmile;
    }

    public void setUppricestartmile(Double uppricestartmile) {
        this.uppricestartmile = uppricestartmile;
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

    public void setLowspeedpriceperminute(Double lowspeedpriceperminute) {
        this.lowspeedpriceperminute = lowspeedpriceperminute;
    }

    public Double getNightpricepermile() {
        return nightpricepermile;
    }

    public void setNightpricepermile(Double nightpricepermile) {
        this.nightpricepermile = nightpricepermile;
    }

    public Double getOtherprice() {
        return otherprice;
    }

    public void setOtherprice(Double otherprice) {
        this.otherprice = otherprice;
    }

    public int getPricestate() {
        return pricestate;
    }

    public void setPricestate(int pricestate) {
        this.pricestate = pricestate;
    }

    public String getNightpriceperminute() {
        return nightpriceperminute;
    }

    public void setNightpriceperminute(String nightpriceperminute) {
        this.nightpriceperminute = nightpriceperminute;
    }

    public Timestamp getOtherpeaktimeon() {
        return otherpeaktimeon;
    }

    public void setOtherpeaktimeon(Timestamp otherpeaktimeon) {
        this.otherpeaktimeon = otherpeaktimeon;
    }

    public Integer getPrioritylevel() {
        return prioritylevel;
    }

    public void setPrioritylevel(Integer prioritylevel) {
        this.prioritylevel = prioritylevel;
    }

    public Double getWaitfree() {
        return waitfree;
    }

    public void setWaitfree(Double waitfree) {
        this.waitfree = waitfree;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Timestamp getNightstart() {
        return nightstart;
    }

    public void setNightstart(Timestamp nightstart) {
        this.nightstart = nightstart;
    }

    public Double getWaittime() {
        return waittime;
    }

    public void setWaittime(Double waittime) {
        this.waittime = waittime;
    }

    public Double getWaitprice() {
        return waitprice;
    }

    public void setWaitprice(Double waitprice) {
        this.waitprice = waitprice;
    }

    public Timestamp getWaitstartbillingtime() {
        return waitstartbillingtime;
    }

    public void setWaitstartbillingtime(Timestamp waitstartbillingtime) {
        this.waitstartbillingtime = waitstartbillingtime;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetFare netFare = (NetFare) o;
        return fareid == netFare.fareid &&
                Double.compare(netFare.startfare, startfare) == 0 &&
                Double.compare(netFare.startmile, startmile) == 0 &&
                Double.compare(netFare.unitpricepermile, unitpricepermile) == 0 &&
                Double.compare(netFare.unitpriceperminute, unitpriceperminute) == 0 &&
                pricestate == netFare.pricestate &&
                Objects.equals(faretype, netFare.faretype) &&
                Objects.equals(faretypenote, netFare.faretypenote) &&
                Objects.equals(farevalidon, netFare.farevalidon) &&
                Objects.equals(farevalidoff, netFare.farevalidoff) &&
                Objects.equals(upprice, netFare.upprice) &&
                Objects.equals(uppricestartmile, netFare.uppricestartmile) &&
                Objects.equals(morningpeaktimeon, netFare.morningpeaktimeon) &&
                Objects.equals(morningpeaktimeoff, netFare.morningpeaktimeoff) &&
                Objects.equals(eveningpeaktimeon, netFare.eveningpeaktimeon) &&
                Objects.equals(eveningpeaktimeoff, netFare.eveningpeaktimeoff) &&
                Objects.equals(otherpeaktimeoff, netFare.otherpeaktimeoff) &&
                Objects.equals(peakunitprice, netFare.peakunitprice) &&
                Objects.equals(peakpricestartmile, netFare.peakpricestartmile) &&
                Objects.equals(lowspeedpriceperminute, netFare.lowspeedpriceperminute) &&
                Objects.equals(nightpricepermile, netFare.nightpricepermile) &&
                Objects.equals(otherprice, netFare.otherprice) &&
                Objects.equals(nightpriceperminute, netFare.nightpriceperminute) &&
                Objects.equals(otherpeaktimeon, netFare.otherpeaktimeon) &&
                Objects.equals(prioritylevel, netFare.prioritylevel) &&
                Objects.equals(waitfree, netFare.waitfree) &&
                Objects.equals(ratio, netFare.ratio) &&
                Objects.equals(nightstart, netFare.nightstart) &&
                Objects.equals(waittime, netFare.waittime) &&
                Objects.equals(waitprice, netFare.waitprice) &&
                Objects.equals(waitstartbillingtime, netFare.waitstartbillingtime) &&
                Objects.equals(createtime, netFare.createtime) &&
                Objects.equals(updatetime, netFare.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fareid, faretype, faretypenote, farevalidon, farevalidoff, startfare, startmile, unitpricepermile, unitpriceperminute, upprice, uppricestartmile, morningpeaktimeon, morningpeaktimeoff, eveningpeaktimeon, eveningpeaktimeoff, otherpeaktimeoff, peakunitprice, peakpricestartmile, lowspeedpriceperminute, nightpricepermile, otherprice, pricestate, nightpriceperminute, otherpeaktimeon, prioritylevel, waitfree, ratio, nightstart, waittime, waitprice, waitstartbillingtime, createtime, updatetime);
    }
}
