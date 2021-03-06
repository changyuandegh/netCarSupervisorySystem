package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetLegalphoto {

    private int id;
    private String legalphotoid;
    private String companyidc;
    private String address;
    private Timestamp createtime;
    private byte[] photo;
    private Timestamp updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLegalphotoid() {
        return legalphotoid;
    }

    public void setLegalphotoid(String legalphotoid) {
        this.legalphotoid = legalphotoid;
    }

    public String getCompanyidc() {
        return companyidc;
    }

    public void setCompanyidc(String companyidc) {
        this.companyidc = companyidc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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
        NetLegalphoto that = (NetLegalphoto) o;
        return id == that.id &&
                Objects.equals(legalphotoid, that.legalphotoid) &&
                Objects.equals(companyidc, that.companyidc) &&
                Objects.equals(address, that.address) &&
                Objects.equals(createtime, that.createtime) &&
                Arrays.equals(photo, that.photo) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, legalphotoid, companyidc, address, createtime, photo, updatetime);
    }
}
