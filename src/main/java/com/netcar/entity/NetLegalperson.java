package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetLegalperson {

    private int legalpersonid;
    private String legalname;
    private String legalid;
    private String legalphone;
    private String legalphoto;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getLegalpersonid() {
        return legalpersonid;
    }

    public void setLegalpersonid(int legalpersonid) {
        this.legalpersonid = legalpersonid;
    }

    public String getLegalname() {
        return legalname;
    }

    public void setLegalname(String legalname) {
        this.legalname = legalname;
    }

    public String getLegalid() {
        return legalid;
    }

    public void setLegalid(String legalid) {
        this.legalid = legalid;
    }

    public String getLegalphone() {
        return legalphone;
    }

    public void setLegalphone(String legalphone) {
        this.legalphone = legalphone;
    }

    public String getLegalphoto() {
        return legalphoto;
    }

    public void setLegalphoto(String legalphoto) {
        this.legalphoto = legalphoto;
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
        NetLegalperson that = (NetLegalperson) o;
        return legalpersonid == that.legalpersonid &&
                Objects.equals(legalname, that.legalname) &&
                Objects.equals(legalid, that.legalid) &&
                Objects.equals(legalphone, that.legalphone) &&
                Objects.equals(legalphoto, that.legalphoto) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legalpersonid, legalname, legalid, legalphone, legalphoto, createtime, updatetime);
    }
}
