package com.netcar.dataModle;

/**
 * Created by Administrator on 2017/6/10.
 *
 * 订单管理
 */
public class OrderManagement {
    private String orderid;
    private String netorderid;
    private int ordertype;
    private Double depamount;
    private Double depmileage;
    private String vehicleno;
    private String drivername;
    private String driverphone;
    private String compangname;
    private String departure;
    private String destination;
    private String passengerphone;
    public OrderManagement(String netorderid, int ordertype, Double depamount, Double depmileage, String vehicleno, String drivername, String driverphone, String compangname, String departure, String destination, String passengerphone) {
        this.netorderid = netorderid;
        this.ordertype = ordertype;
        this.depamount = depamount;
        this.depmileage = depmileage;
        this.vehicleno = vehicleno;
        this.drivername = drivername;
        this.driverphone = driverphone;
        this.compangname = compangname;
        this.departure = departure;
        this.destination = destination;
        this.passengerphone = passengerphone;
    }
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
    public String getNetorderid() {
        return netorderid;
    }
    public void setNetorderid(String netorderid) {
        this.netorderid = netorderid;
    }

    public int getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(int ordertype) {
        this.ordertype = ordertype;
    }

    public Double getDepamount() {
        return depamount;
    }

    public void setDepamount(Double depamount) {
        this.depamount = depamount;
    }

    public Double getDepmileage() {
        return depmileage;
    }

    public void setDepmileage(Double depmileage) {
        this.depmileage = depmileage;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
    }

    public String getCompangname() {
        return compangname;
    }

    public void setCompangname(String compangname) {
        this.compangname = compangname;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPassengerphone() {
        return passengerphone;
    }

    public void setPassengerphone(String passengerphone) {
        this.passengerphone = passengerphone;
    }

    public OrderManagement(){}
    @Override
    public String toString() {
        return "OrderManagement{" +
                "netorderid='" + netorderid + '\'' +
                ", ordertype=" + ordertype +
                ", depamount=" + depamount +
                ", depmileage=" + depmileage +
                ", vehicleno='" + vehicleno + '\'' +
                ", drivername='" + drivername + '\'' +
                ", driverphone='" + driverphone + '\'' +
                ", compangname='" + compangname + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", passengerphone='" + passengerphone + '\'' +
                '}';
    }
}
