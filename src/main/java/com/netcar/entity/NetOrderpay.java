package com.netcar.entity;

import java.sql.Timestamp;

/**
 * Created by Mander on 2017/6/15.
 */
public class NetOrderpay {

    private int id;
    private String companyid;
    private String orderid;
    private int onarea;
    private String drivername;
    private String licenseid;
    private String faretype;
    private String vehicleno;
    private Timestamp bookdeptime;
    private Integer waittime;
    private double deplongitude;
    private double deplatitude;
    private String deparea;
    private Timestamp deptime;
    private double destlongitude;
    private double destlatitude;
    private String destarea;
    private Timestamp destTime;
    private String bookmodel;
    private String model;
    private double drivemile;
    private int drivetime;
    private Double waitmile;
    private double factprice;
    private Double price;
    private Double cashprice;
    private String linename;
    private Double lineprice;
    private String posname;
    private Double posprice;
    private Double benfitprice;
    private Double booktip;
    private Double passengertip;
    private Double peakupprice;
    private Double nightupprice;
    private double farupprice;
    private double otherupprice;
    private String paystate;
    private Timestamp paytime;
    private Timestamp ordermatchtime;
    private String invoicestatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public int getOnarea() {
        return onarea;
    }

    public void setOnarea(int onarea) {
        this.onarea = onarea;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public String getFaretype() {
        return faretype;
    }

    public void setFaretype(String faretype) {
        this.faretype = faretype;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public Timestamp getBookdeptime() {
        return bookdeptime;
    }

    public void setBookdeptime(Timestamp bookdeptime) {
        this.bookdeptime = bookdeptime;
    }

    public Integer getWaittime() {
        return waittime;
    }

    public void setWaittime(Integer waittime) {
        this.waittime = waittime;
    }

    public double getDeplongitude() {
        return deplongitude;
    }

    public void setDeplongitude(double deplongitude) {
        this.deplongitude = deplongitude;
    }

    public double getDeplatitude() {
        return deplatitude;
    }

    public void setDeplatitude(double deplatitude) {
        this.deplatitude = deplatitude;
    }

    public String getDeparea() {
        return deparea;
    }

    public void setDeparea(String deparea) {
        this.deparea = deparea;
    }

    public Timestamp getDeptime() {
        return deptime;
    }

    public void setDeptime(Timestamp deptime) {
        this.deptime = deptime;
    }

    public double getDestlongitude() {
        return destlongitude;
    }

    public void setDestlongitude(double destlongitude) {
        this.destlongitude = destlongitude;
    }

    public double getDestlatitude() {
        return destlatitude;
    }

    public void setDestlatitude(double destlatitude) {
        this.destlatitude = destlatitude;
    }

    public String getDestarea() {
        return destarea;
    }

    public void setDestarea(String destarea) {
        this.destarea = destarea;
    }

    public Timestamp getDestTime() {
        return destTime;
    }

    public void setDestTime(Timestamp destTime) {
        this.destTime = destTime;
    }

    public String getBookmodel() {
        return bookmodel;
    }

    public void setBookmodel(String bookmodel) {
        this.bookmodel = bookmodel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDrivemile() {
        return drivemile;
    }

    public void setDrivemile(double drivemile) {
        this.drivemile = drivemile;
    }

    public int getDrivetime() {
        return drivetime;
    }

    public void setDrivetime(int drivetime) {
        this.drivetime = drivetime;
    }

    public Double getWaitmile() {
        return waitmile;
    }

    public void setWaitmile(Double waitmile) {
        this.waitmile = waitmile;
    }

    public double getFactprice() {
        return factprice;
    }

    public void setFactprice(double factprice) {
        this.factprice = factprice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCashprice() {
        return cashprice;
    }

    public void setCashprice(Double cashprice) {
        this.cashprice = cashprice;
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename;
    }

    public Double getLineprice() {
        return lineprice;
    }

    public void setLineprice(Double lineprice) {
        this.lineprice = lineprice;
    }

    public String getPosname() {
        return posname;
    }

    public void setPosname(String posname) {
        this.posname = posname;
    }

    public Double getPosprice() {
        return posprice;
    }

    public void setPosprice(Double posprice) {
        this.posprice = posprice;
    }

    public Double getBenfitprice() {
        return benfitprice;
    }

    public void setBenfitprice(Double benfitprice) {
        this.benfitprice = benfitprice;
    }

    public Double getBooktip() {
        return booktip;
    }

    public void setBooktip(Double booktip) {
        this.booktip = booktip;
    }

    public Double getPassengertip() {
        return passengertip;
    }

    public void setPassengertip(Double passengertip) {
        this.passengertip = passengertip;
    }

    public Double getPeakupprice() {
        return peakupprice;
    }

    public void setPeakupprice(Double peakupprice) {
        this.peakupprice = peakupprice;
    }

    public Double getNightupprice() {
        return nightupprice;
    }

    public void setNightupprice(Double nightupprice) {
        this.nightupprice = nightupprice;
    }

    public double getFarupprice() {
        return farupprice;
    }

    public void setFarupprice(double farupprice) {
        this.farupprice = farupprice;
    }

    public double getOtherupprice() {
        return otherupprice;
    }

    public void setOtherupprice(double otherupprice) {
        this.otherupprice = otherupprice;
    }

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }

    public Timestamp getPaytime() {
        return paytime;
    }

    public void setPaytime(Timestamp paytime) {
        this.paytime = paytime;
    }

    public Timestamp getOrdermatchtime() {
        return ordermatchtime;
    }

    public void setOrdermatchtime(Timestamp ordermatchtime) {
        this.ordermatchtime = ordermatchtime;
    }

    public String getInvoicestatus() {
        return invoicestatus;
    }

    public void setInvoicestatus(String invoicestatus) {
        this.invoicestatus = invoicestatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetOrderpay that = (NetOrderpay) o;

        if (id != that.id) return false;
        if (onarea != that.onarea) return false;
        if (Double.compare(that.deplongitude, deplongitude) != 0) return false;
        if (Double.compare(that.deplatitude, deplatitude) != 0) return false;
        if (Double.compare(that.destlongitude, destlongitude) != 0) return false;
        if (Double.compare(that.destlatitude, destlatitude) != 0) return false;
        if (Double.compare(that.drivemile, drivemile) != 0) return false;
        if (drivetime != that.drivetime) return false;
        if (Double.compare(that.factprice, factprice) != 0) return false;
        if (Double.compare(that.farupprice, farupprice) != 0) return false;
        if (Double.compare(that.otherupprice, otherupprice) != 0) return false;
        if (companyid != null ? !companyid.equals(that.companyid) : that.companyid != null) return false;
        if (orderid != null ? !orderid.equals(that.orderid) : that.orderid != null) return false;
        if (drivername != null ? !drivername.equals(that.drivername) : that.drivername != null) return false;
        if (licenseid != null ? !licenseid.equals(that.licenseid) : that.licenseid != null) return false;
        if (faretype != null ? !faretype.equals(that.faretype) : that.faretype != null) return false;
        if (vehicleno != null ? !vehicleno.equals(that.vehicleno) : that.vehicleno != null) return false;
        if (bookdeptime != null ? !bookdeptime.equals(that.bookdeptime) : that.bookdeptime != null) return false;
        if (waittime != null ? !waittime.equals(that.waittime) : that.waittime != null) return false;
        if (deparea != null ? !deparea.equals(that.deparea) : that.deparea != null) return false;
        if (deptime != null ? !deptime.equals(that.deptime) : that.deptime != null) return false;
        if (destarea != null ? !destarea.equals(that.destarea) : that.destarea != null) return false;
        if (destTime != null ? !destTime.equals(that.destTime) : that.destTime != null) return false;
        if (bookmodel != null ? !bookmodel.equals(that.bookmodel) : that.bookmodel != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (waitmile != null ? !waitmile.equals(that.waitmile) : that.waitmile != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (cashprice != null ? !cashprice.equals(that.cashprice) : that.cashprice != null) return false;
        if (linename != null ? !linename.equals(that.linename) : that.linename != null) return false;
        if (lineprice != null ? !lineprice.equals(that.lineprice) : that.lineprice != null) return false;
        if (posname != null ? !posname.equals(that.posname) : that.posname != null) return false;
        if (posprice != null ? !posprice.equals(that.posprice) : that.posprice != null) return false;
        if (benfitprice != null ? !benfitprice.equals(that.benfitprice) : that.benfitprice != null) return false;
        if (booktip != null ? !booktip.equals(that.booktip) : that.booktip != null) return false;
        if (passengertip != null ? !passengertip.equals(that.passengertip) : that.passengertip != null) return false;
        if (peakupprice != null ? !peakupprice.equals(that.peakupprice) : that.peakupprice != null) return false;
        if (nightupprice != null ? !nightupprice.equals(that.nightupprice) : that.nightupprice != null) return false;
        if (paystate != null ? !paystate.equals(that.paystate) : that.paystate != null) return false;
        if (paytime != null ? !paytime.equals(that.paytime) : that.paytime != null) return false;
        if (ordermatchtime != null ? !ordermatchtime.equals(that.ordermatchtime) : that.ordermatchtime != null)
            return false;
        if (invoicestatus != null ? !invoicestatus.equals(that.invoicestatus) : that.invoicestatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (companyid != null ? companyid.hashCode() : 0);
        result = 31 * result + (orderid != null ? orderid.hashCode() : 0);
        result = 31 * result + onarea;
        result = 31 * result + (drivername != null ? drivername.hashCode() : 0);
        result = 31 * result + (licenseid != null ? licenseid.hashCode() : 0);
        result = 31 * result + (faretype != null ? faretype.hashCode() : 0);
        result = 31 * result + (vehicleno != null ? vehicleno.hashCode() : 0);
        result = 31 * result + (bookdeptime != null ? bookdeptime.hashCode() : 0);
        result = 31 * result + (waittime != null ? waittime.hashCode() : 0);
        temp = Double.doubleToLongBits(deplongitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(deplatitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (deparea != null ? deparea.hashCode() : 0);
        result = 31 * result + (deptime != null ? deptime.hashCode() : 0);
        temp = Double.doubleToLongBits(destlongitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(destlatitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (destarea != null ? destarea.hashCode() : 0);
        result = 31 * result + (destTime != null ? destTime.hashCode() : 0);
        result = 31 * result + (bookmodel != null ? bookmodel.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        temp = Double.doubleToLongBits(drivemile);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + drivetime;
        result = 31 * result + (waitmile != null ? waitmile.hashCode() : 0);
        temp = Double.doubleToLongBits(factprice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (cashprice != null ? cashprice.hashCode() : 0);
        result = 31 * result + (linename != null ? linename.hashCode() : 0);
        result = 31 * result + (lineprice != null ? lineprice.hashCode() : 0);
        result = 31 * result + (posname != null ? posname.hashCode() : 0);
        result = 31 * result + (posprice != null ? posprice.hashCode() : 0);
        result = 31 * result + (benfitprice != null ? benfitprice.hashCode() : 0);
        result = 31 * result + (booktip != null ? booktip.hashCode() : 0);
        result = 31 * result + (passengertip != null ? passengertip.hashCode() : 0);
        result = 31 * result + (peakupprice != null ? peakupprice.hashCode() : 0);
        result = 31 * result + (nightupprice != null ? nightupprice.hashCode() : 0);
        temp = Double.doubleToLongBits(farupprice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(otherupprice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (paystate != null ? paystate.hashCode() : 0);
        result = 31 * result + (paytime != null ? paytime.hashCode() : 0);
        result = 31 * result + (ordermatchtime != null ? ordermatchtime.hashCode() : 0);
        result = 31 * result + (invoicestatus != null ? invoicestatus.hashCode() : 0);
        return result;
    }
}
