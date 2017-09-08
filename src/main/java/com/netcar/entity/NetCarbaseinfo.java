package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetCarbaseinfo {

    private int carid;
    private String companyIdc;
    private int address;
    private String vehicleno;
    private String platecolor;
    private int seats;
    private String brand;
    private String model;
    private String vehicletype;
    private String ownername;
    private String vehiclecolor;
    private String engineid;
    private String vin;
    private Date certifydatea;
    private String fueltype;
    private String enginedisplace;
    private String photoId;
    private String certificate;
    private String transagency;
    private String transarea;
    private Date transdatestart;
    private Date transdatestop;
    private Date certifydateb;
    private int fixstate;
    private Date nextfixdata;
    private int checkstate;
    private String feeprintId;
    private String gpsbrand;
    private String gpsmodel;
    private String gpsimei;
    private Date gpsinstalldate;
    private Date registerdate;
    private int commercialtype;
    private int state;
    private double totalmile;
    private Integer fareid;
    private Long deviceid;
    private Integer insurid;
    private String etagid;
    private Timestamp createtime;
    private Timestamp updatetime;
    private String fisstate;

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getCompanyIdc() {
        return companyIdc;
    }

    public void setCompanyIdc(String companyIdc) {
        this.companyIdc = companyIdc;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public String getPlatecolor() {
        return platecolor;
    }

    public void setPlatecolor(String platecolor) {
        this.platecolor = platecolor;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getVehiclecolor() {
        return vehiclecolor;
    }

    public void setVehiclecolor(String vehiclecolor) {
        this.vehiclecolor = vehiclecolor;
    }

    public String getEngineid() {
        return engineid;
    }

    public void setEngineid(String engineid) {
        this.engineid = engineid;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getCertifydatea() {
        return certifydatea;
    }

    public void setCertifydatea(Date certifydatea) {
        this.certifydatea = certifydatea;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getEnginedisplace() {
        return enginedisplace;
    }

    public void setEnginedisplace(String enginedisplace) {
        this.enginedisplace = enginedisplace;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getTransagency() {
        return transagency;
    }

    public void setTransagency(String transagency) {
        this.transagency = transagency;
    }

    public String getTransarea() {
        return transarea;
    }

    public void setTransarea(String transarea) {
        this.transarea = transarea;
    }

    public Date getTransdatestart() {
        return transdatestart;
    }

    public void setTransdatestart(Date transdatestart) {
        this.transdatestart = transdatestart;
    }

    public Date getTransdatestop() {
        return transdatestop;
    }

    public void setTransdatestop(Date transdatestop) {
        this.transdatestop = transdatestop;
    }

    public Date getCertifydateb() {
        return certifydateb;
    }

    public void setCertifydateb(Date certifydateb) {
        this.certifydateb = certifydateb;
    }

    public int getFixstate() {
        return fixstate;
    }

    public void setFixstate(int fixstate) {
        this.fixstate = fixstate;
    }

    public Date getNextfixdata() {
        return nextfixdata;
    }

    public void setNextfixdata(Date nextfixdata) {
        this.nextfixdata = nextfixdata;
    }

    public int getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(int checkstate) {
        this.checkstate = checkstate;
    }

    public String getFeeprintId() {
        return feeprintId;
    }

    public void setFeeprintId(String feeprintId) {
        this.feeprintId = feeprintId;
    }

    public String getGpsbrand() {
        return gpsbrand;
    }

    public void setGpsbrand(String gpsbrand) {
        this.gpsbrand = gpsbrand;
    }

    public String getGpsmodel() {
        return gpsmodel;
    }

    public void setGpsmodel(String gpsmodel) {
        this.gpsmodel = gpsmodel;
    }

    public String getGpsimei() {
        return gpsimei;
    }

    public void setGpsimei(String gpsimei) {
        this.gpsimei = gpsimei;
    }

    public Date getGpsinstalldate() {
        return gpsinstalldate;
    }

    public void setGpsinstalldate(Date gpsinstalldate) {
        this.gpsinstalldate = gpsinstalldate;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public int getCommercialtype() {
        return commercialtype;
    }

    public void setCommercialtype(int commercialtype) {
        this.commercialtype = commercialtype;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getTotalmile() {
        return totalmile;
    }

    public void setTotalmile(double totalmile) {
        this.totalmile = totalmile;
    }

    public Integer getFareid() {
        return fareid;
    }

    public void setFareid(Integer fareid) {
        this.fareid = fareid;
    }

    public Long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Long deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getInsurid() {
        return insurid;
    }

    public void setInsurid(Integer insurid) {
        this.insurid = insurid;
    }

    public String getEtagid() {
        return etagid;
    }

    public void setEtagid(String etagid) {
        this.etagid = etagid;
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

    public String getFisstate() {
        return fisstate;
    }

    public void setFisstate(String fisstate) {
        this.fisstate = fisstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetCarbaseinfo that = (NetCarbaseinfo) o;
        return carid == that.carid &&
                address == that.address &&
                seats == that.seats &&
                fixstate == that.fixstate &&
                checkstate == that.checkstate &&
                commercialtype == that.commercialtype &&
                state == that.state &&
                Double.compare(that.totalmile, totalmile) == 0 &&
                Objects.equals(companyIdc, that.companyIdc) &&
                Objects.equals(vehicleno, that.vehicleno) &&
                Objects.equals(platecolor, that.platecolor) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model) &&
                Objects.equals(vehicletype, that.vehicletype) &&
                Objects.equals(ownername, that.ownername) &&
                Objects.equals(vehiclecolor, that.vehiclecolor) &&
                Objects.equals(engineid, that.engineid) &&
                Objects.equals(vin, that.vin) &&
                Objects.equals(certifydatea, that.certifydatea) &&
                Objects.equals(fueltype, that.fueltype) &&
                Objects.equals(enginedisplace, that.enginedisplace) &&
                Objects.equals(photoId, that.photoId) &&
                Objects.equals(certificate, that.certificate) &&
                Objects.equals(transagency, that.transagency) &&
                Objects.equals(transarea, that.transarea) &&
                Objects.equals(transdatestart, that.transdatestart) &&
                Objects.equals(transdatestop, that.transdatestop) &&
                Objects.equals(certifydateb, that.certifydateb) &&
                Objects.equals(nextfixdata, that.nextfixdata) &&
                Objects.equals(feeprintId, that.feeprintId) &&
                Objects.equals(gpsbrand, that.gpsbrand) &&
                Objects.equals(gpsmodel, that.gpsmodel) &&
                Objects.equals(gpsimei, that.gpsimei) &&
                Objects.equals(gpsinstalldate, that.gpsinstalldate) &&
                Objects.equals(registerdate, that.registerdate) &&
                Objects.equals(fareid, that.fareid) &&
                Objects.equals(deviceid, that.deviceid) &&
                Objects.equals(insurid, that.insurid) &&
                Objects.equals(etagid, that.etagid) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime) &&
                Objects.equals(fisstate, that.fisstate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carid, companyIdc, address, vehicleno, platecolor, seats, brand, model, vehicletype, ownername, vehiclecolor, engineid, vin, certifydatea, fueltype, enginedisplace, photoId, certificate, transagency, transarea, transdatestart, transdatestop, certifydateb, fixstate, nextfixdata, checkstate, feeprintId, gpsbrand, gpsmodel, gpsimei, gpsinstalldate, registerdate, commercialtype, state, totalmile, fareid, deviceid, insurid, etagid, createtime, updatetime, fisstate);
    }
}
