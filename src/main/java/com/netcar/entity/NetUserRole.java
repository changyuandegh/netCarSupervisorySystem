package com.netcar.entity;

import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetUserRole {

    private int id;
    private int userid;
    private int roleid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetUserRole that = (NetUserRole) o;
        return id == that.id &&
                userid == that.userid &&
                roleid == that.roleid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, roleid);
    }
}
