package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetOrder {

    private long orderid;
    private String netorderid;
    private Integer companyid;
    private int address;
    private Timestamp departtime;
    private Timestamp ordertime;
    private String passengernote;
    private String departure;
    private double deplongitude;
    private double deplatitude;
    private String destination;
    private Double destlongitute;
    private Double destlatitude;
    private int encrypt;
    private  int state;
    private Integer fareid;
    private Double longitude;
    private Double latitude;
    private String licenseid;
    private String driverphone;
    private String vehicleno;
    private Timestamp destributetime;
    private Timestamp canceltime;
    private String canceltypecode;
    private String operator;
    private Integer cartype;
    private Integer businesstype;
    private Integer ordertype;
    private int callphone;
    private String passengerphone;
    private int passengercount;
    private int ordercalltype;
    private Double acceptlongitude;
    private Double acceptlatitude;
    private String actualgoonbus;
    private int ispay;
    private int ispingjia;
    private Integer deptime;
    private Double depmileage;
    private Double depamount;
    private Timestamp createtime;
    private Timestamp updatetime;
    private long ordertrajectoryid;


    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getNetorderid() {
        return netorderid;
    }

    public void setNetorderid(String netorderid) {
        this.netorderid = netorderid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public Timestamp getDeparttime() {
        return departtime;
    }

    public void setDeparttime(Timestamp departtime) {
        this.departtime = departtime;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public String getPassengernote() {
        return passengernote;
    }

    public void setPassengernote(String passengernote) {
        this.passengernote = passengernote;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getDestlongitute() {
        return destlongitute;
    }

    public void setDestlongitute(Double destlongitute) {
        this.destlongitute = destlongitute;
    }

    public Double getDestlatitude() {
        return destlatitude;
    }

    public void setDestlatitude(Double destlatitude) {
        this.destlatitude = destlatitude;
    }

    public int getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(int encrypt) {
        this.encrypt = encrypt;
    }

    public Integer getFareid() {
        return fareid;
    }

    public void setFareid(Integer fareid) {
        this.fareid = fareid;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public Timestamp getDestributetime() {
        return destributetime;
    }

    public void setDestributetime(Timestamp destributetime) {
        this.destributetime = destributetime;
    }

    public Timestamp getCanceltime() {
        return canceltime;
    }

    public void setCanceltime(Timestamp canceltime) {
        this.canceltime = canceltime;
    }

    public String getCanceltypecode() {
        return canceltypecode;
    }

    public void setCanceltypecode(String canceltypecode) {
        this.canceltypecode = canceltypecode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getCartype() {
        return cartype;
    }

    public void setCartype(Integer cartype) {
        this.cartype = cartype;
    }

    public Integer getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(Integer businesstype) {
        this.businesstype = businesstype;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public int getCallphone() {
        return callphone;
    }

    public void setCallphone(int callphone) {
        this.callphone = callphone;
    }

    public String getPassengerphone() {
        return passengerphone;
    }

    public void setPassengerphone(String passengerphone) {
        this.passengerphone = passengerphone;
    }

    public int getPassengercount() {
        return passengercount;
    }

    public void setPassengercount(int passengercount) {
        this.passengercount = passengercount;
    }

    public int getOrdercalltype() {
        return ordercalltype;
    }

    public void setOrdercalltype(int ordercalltype) {
        this.ordercalltype = ordercalltype;
    }

    public Double getAcceptlongitude() {
        return acceptlongitude;
    }

    public void setAcceptlongitude(Double acceptlongitude) {
        this.acceptlongitude = acceptlongitude;
    }

    public Double getAcceptlatitude() {
        return acceptlatitude;
    }

    public void setAcceptlatitude(Double acceptlatitude) {
        this.acceptlatitude = acceptlatitude;
    }

    public String getActualgoonbus() {
        return actualgoonbus;
    }

    public void setActualgoonbus(String actualgoonbus) {
        this.actualgoonbus = actualgoonbus;
    }

    public int getIspay() {
        return ispay;
    }

    public void setIspay(int ispay) {
        this.ispay = ispay;
    }

    public int getIspingjia() {
        return ispingjia;
    }

    public void setIspingjia(int ispingjia) {
        this.ispingjia = ispingjia;
    }

    public Integer getDeptime() {
        return deptime;
    }

    public void setDeptime(Integer deptime) {
        this.deptime = deptime;
    }

    public Double getDepmileage() {
        return depmileage;
    }

    public void setDepmileage(Double depmileage) {
        this.depmileage = depmileage;
    }

    public Double getDepamount() {
        return depamount;
    }

    public void setDepamount(Double depamount) {
        this.depamount = depamount;
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

    public long getOrdertrajectoryid() {
        return ordertrajectoryid;
    }

    public void setOrdertrajectoryid(long ordertrajectoryid) {
        this.ordertrajectoryid = ordertrajectoryid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetOrder netOrder = (NetOrder) o;
        return orderid == netOrder.orderid &&
                address == netOrder.address &&
                Double.compare(netOrder.deplongitude, deplongitude) == 0 &&
                Double.compare(netOrder.deplatitude, deplatitude) == 0 &&
                encrypt == netOrder.encrypt &&
                callphone == netOrder.callphone &&
                passengercount == netOrder.passengercount &&
                ordercalltype == netOrder.ordercalltype &&
                ispay == netOrder.ispay &&
                ispingjia == netOrder.ispingjia &&
                ordertrajectoryid == netOrder.ordertrajectoryid &&
                Objects.equals(companyid, netOrder.companyid) &&
                Objects.equals(companyid, netOrder.companyid) &&
                Objects.equals(departtime, netOrder.departtime) &&
                Objects.equals(ordertime, netOrder.ordertime) &&
                Objects.equals(passengernote, netOrder.passengernote) &&
                Objects.equals(departure, netOrder.departure) &&
                Objects.equals(destination, netOrder.destination) &&
                Objects.equals(destlongitute, netOrder.destlongitute) &&
                Objects.equals(destlatitude, netOrder.destlatitude) &&
                Objects.equals(fareid, netOrder.fareid) &&
                Objects.equals(longitude, netOrder.longitude) &&
                Objects.equals(latitude, netOrder.latitude) &&
                Objects.equals(licenseid, netOrder.licenseid) &&
                Objects.equals(driverphone, netOrder.driverphone) &&
                Objects.equals(vehicleno, netOrder.vehicleno) &&
                Objects.equals(destributetime, netOrder.destributetime) &&
                Objects.equals(canceltime, netOrder.canceltime) &&
                Objects.equals(canceltypecode, netOrder.canceltypecode) &&
                Objects.equals(operator, netOrder.operator) &&
                Objects.equals(cartype, netOrder.cartype) &&
                Objects.equals(businesstype, netOrder.businesstype) &&
                Objects.equals(ordertype, netOrder.ordertype) &&
                Objects.equals(passengerphone, netOrder.passengerphone) &&
                Objects.equals(acceptlongitude, netOrder.acceptlongitude) &&
                Objects.equals(acceptlatitude, netOrder.acceptlatitude) &&
                Objects.equals(actualgoonbus, netOrder.actualgoonbus) &&
                Objects.equals(deptime, netOrder.deptime) &&
                Objects.equals(depmileage, netOrder.depmileage) &&
                Objects.equals(depamount, netOrder.depamount) &&
                Objects.equals(createtime, netOrder.createtime) &&
                Objects.equals(updatetime, netOrder.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, companyid, address, departtime, ordertime, passengernote, departure, deplongitude, deplatitude, destination, destlongitute, destlatitude, encrypt, fareid, longitude, latitude, licenseid, driverphone, vehicleno, destributetime, canceltime, canceltypecode, operator, cartype, businesstype, ordertype, callphone, passengerphone, passengercount, ordercalltype, acceptlongitude, acceptlatitude, actualgoonbus, ispay, ispingjia, deptime, depmileage, depamount, createtime, updatetime, ordertrajectoryid);
    }
}
