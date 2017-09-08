package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetEtag {

    private String etagid;
    private String brand;
    private String model;
    private String imei;
    private Date installdate;
    private Timestamp createtime;
    private Timestamp updatetime;

    public String getEtagid() {
        return etagid;
    }

    public void setEtagid(String etagid) {
        this.etagid = etagid;
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
        NetEtag netEtag = (NetEtag) o;
        return Objects.equals(etagid, netEtag.etagid) &&
                Objects.equals(brand, netEtag.brand) &&
                Objects.equals(model, netEtag.model) &&
                Objects.equals(imei, netEtag.imei) &&
                Objects.equals(installdate, netEtag.installdate) &&
                Objects.equals(createtime, netEtag.createtime) &&
                Objects.equals(updatetime, netEtag.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etagid, brand, model, imei, installdate, createtime, updatetime);
    }
}
