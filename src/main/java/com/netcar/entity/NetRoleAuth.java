package com.netcar.entity;

import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetRoleAuth {

    private int id;
    private int authorityid;
    private int roleid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(int authorityid) {
        this.authorityid = authorityid;
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
        NetRoleAuth that = (NetRoleAuth) o;
        return id == that.id &&
                authorityid == that.authorityid &&
                roleid == that.roleid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorityid, roleid);
    }
}
