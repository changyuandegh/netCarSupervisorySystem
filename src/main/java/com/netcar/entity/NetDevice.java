package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDevice {

    private long deviceid;
    private String brand;
    private String model;
    private String imei;
    private String sim;
    private Date installdate;
    private Timestamp createtime;
    private Timestamp updatetime;

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public Date getInstalldate() {
        return installdate;
    }

    public void setInstalldate(Date installdate) {
        this.installdate = installdate;
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
        NetDevice netDevice = (NetDevice) o;
        return deviceid == netDevice.deviceid &&
                Objects.equals(brand, netDevice.brand) &&
                Objects.equals(model, netDevice.model) &&
                Objects.equals(imei, netDevice.imei) &&
                Objects.equals(sim, netDevice.sim) &&
                Objects.equals(installdate, netDevice.installdate) &&
                Objects.equals(createtime, netDevice.createtime) &&
                Objects.equals(updatetime, netDevice.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceid, brand, model, imei, sim, installdate, createtime, updatetime);
    }
}
