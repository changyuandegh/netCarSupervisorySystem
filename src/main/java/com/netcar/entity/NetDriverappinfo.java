package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDriverappinfo {

    private int driverappinfoid;
    private int nettype;
    private String appversion;
    private int maptype;
    private String phonemodel;
    private String phonebrand;
    private String imei;
    private String macaddress;
    private String system;
    private String systemversion;
    private String ip;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getDriverappinfoid() {
        return driverappinfoid;
    }

    public void setDriverappinfoid(int driverappinfoid) {
        this.driverappinfoid = driverappinfoid;
    }

    public int getNettype() {
        return nettype;
    }

    public void setNettype(int nettype) {
        this.nettype = nettype;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public int getMaptype() {
        return maptype;
    }

    public void setMaptype(int maptype) {
        this.maptype = maptype;
    }

    public String getPhonemodel() {
        return phonemodel;
    }

    public void setPhonemodel(String phonemodel) {
        this.phonemodel = phonemodel;
    }

    public String getPhonebrand() {
        return phonebrand;
    }

    public void setPhonebrand(String phonebrand) {
        this.phonebrand = phonebrand;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getSystemversion() {
        return systemversion;
    }

    public void setSystemversion(String systemversion) {
        this.systemversion = systemversion;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
        NetDriverappinfo that = (NetDriverappinfo) o;
        return driverappinfoid == that.driverappinfoid &&
                nettype == that.nettype &&
                maptype == that.maptype &&
                Objects.equals(appversion, that.appversion) &&
                Objects.equals(phonemodel, that.phonemodel) &&
                Objects.equals(phonebrand, that.phonebrand) &&
                Objects.equals(imei, that.imei) &&
                Objects.equals(macaddress, that.macaddress) &&
                Objects.equals(system, that.system) &&
                Objects.equals(systemversion, that.systemversion) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverappinfoid, nettype, appversion, maptype, phonemodel, phonebrand, imei, macaddress, system, systemversion, ip, createtime, updatetime);
    }
}
