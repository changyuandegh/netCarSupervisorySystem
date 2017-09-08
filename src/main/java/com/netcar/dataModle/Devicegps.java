package com.netcar.dataModle;

/**
 * Created by Mander on 2017/5/18.
 */
public class Devicegps {

    private double longitude;
    private double latitude;
    private int islocate;//是否定位
    private String  ltime;//定位时间
    private  int isfull;//是否载客
    private String deviceid;
    private double speed;
    private int alarm;//报警状态
    private  int status;
    private double direction;
    private String uptime;
    private int isonline;//是否在线
    private  int sosalarm;//是否报警
    private String vehicleno;//车牌


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getIslocate() {
        return islocate;
    }

    public void setIslocate(int islocate) {
        this.islocate = islocate;
    }

    public String getLtime() {
        return ltime;
    }

    public void setLtime(String ltime) {
        this.ltime = ltime;
    }

    public int getIsfull() {
        return isfull;
    }

    public void setIsfull(int isfull) {
        this.isfull = isfull;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getAlarm() {
        return alarm;
    }

    public void setAlarm(int alarm) {
        this.alarm = alarm;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double ditection) {
        this.direction = ditection;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public int getIsonline() {
        return isonline;
    }

    public void setIsonline(int isonline) {
        this.isonline = isonline;
    }

    public int getSosalarm() {
        return sosalarm;
    }

    public void setSosalarm(int sosalarm) {
        this.sosalarm = sosalarm;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }


    @Override
    public String toString() {
        return "Devicegps{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", islocate=" + islocate +
                ", ltime='" + ltime + '\'' +
                ", isfull=" + isfull +
                ", deviceid='" + deviceid + '\'' +
                ", speed=" + speed +
                ", alarm=" + alarm +
                ", status=" + status +
                ", direction=" + direction +
                ", uptime='" + uptime + '\'' +
                ", isonline=" + isonline +
                ", sosalarm=" + sosalarm +
                ", vehicleno='" + vehicleno + '\'' +
                '}';
    }
}
