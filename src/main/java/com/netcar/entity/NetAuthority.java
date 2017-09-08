package com.netcar.entity;

import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetAuthority {

    private int id;
    private String title;
    private int level;
    private String type;
    private int groupid;
    private String url;
    private String icon;
    private String desciption;
    private int isUse;
    private int creatorid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    public int getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(int creatorid) {
        this.creatorid = creatorid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetAuthority that = (NetAuthority) o;
        return id == that.id &&
                level == that.level &&
                groupid == that.groupid &&
                isUse == that.isUse &&
                creatorid == that.creatorid &&
                Objects.equals(title, that.title) &&
                Objects.equals(type, that.type) &&
                Objects.equals(url, that.url) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(desciption, that.desciption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, level, type, groupid, url, icon, desciption, isUse, creatorid);
    }
}
