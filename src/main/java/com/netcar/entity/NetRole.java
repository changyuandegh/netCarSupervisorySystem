package com.netcar.entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetRole {

    private int id;
    private String name;
    private String title;
    private Integer enable;
    private String desciption;
    private Integer creator;
    private Timestamp createtime;
    private Timestamp updatetime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
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
        NetRole netRole = (NetRole) o;
        return id == netRole.id &&
                Objects.equals(name, netRole.name) &&
                Objects.equals(title, netRole.title) &&
                Objects.equals(enable, netRole.enable) &&
                Objects.equals(desciption, netRole.desciption) &&
                Objects.equals(creator, netRole.creator) &&
                Objects.equals(createtime, netRole.createtime) &&
                Objects.equals(updatetime, netRole.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, title, enable, desciption, creator, createtime, updatetime);
    }
}
