package com.netcar.entity;

import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetAlarmtype {

    private int id;
    private String name;
    private String tablename;
    private String describe;

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

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetAlarmtype that = (NetAlarmtype) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(tablename, that.tablename) &&
                Objects.equals(describe, that.describe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tablename, describe);
    }

    @Override
    public String toString() {
        return "NetAlarmtype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tablename='" + tablename + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
