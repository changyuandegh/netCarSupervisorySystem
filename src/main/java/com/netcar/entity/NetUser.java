package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetUser {

    private int id;
    private String name;
    private String cname;
    private String password;
    private Integer status;
    private Integer creator;
    private Timestamp loginouttime;
    private Integer areaid;
    private Integer companyid;
    private String loginIp;
    private Timestamp logintime;
    private Timestamp updatetime;
    private Timestamp createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Timestamp getLoginouttime() {
        return loginouttime;
    }

    public void setLoginouttime(Timestamp loginouttime) {
        this.loginouttime = loginouttime;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetUser netUser = (NetUser) o;
        return id == netUser.id &&
                Objects.equals(name, netUser.name) &&
                Objects.equals(cname, netUser.cname) &&
                Objects.equals(password, netUser.password) &&
                Objects.equals(status, netUser.status) &&
                Objects.equals(creator, netUser.creator) &&
                Objects.equals(loginouttime, netUser.loginouttime) &&
                Objects.equals(areaid, netUser.areaid) &&
                Objects.equals(companyid, netUser.companyid) &&
                Objects.equals(loginIp, netUser.loginIp) &&
                Objects.equals(logintime, netUser.logintime) &&
                Objects.equals(updatetime, netUser.updatetime) &&
                Objects.equals(createtime, netUser.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cname, password, status, creator, loginouttime, areaid, companyid, loginIp, logintime, updatetime, createtime);
    }
}
