package com.netcar.entity;

import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetArea {

    private int id;
    private String code;
    private String name;
    private String fathercode;
    private int level;
    private Integer state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathercode() {
        return fathercode;
    }

    public void setFathercode(String fathercode) {
        this.fathercode = fathercode;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetArea netArea = (NetArea) o;
        return id == netArea.id &&
                level == netArea.level &&
                Objects.equals(code, netArea.code) &&
                Objects.equals(name, netArea.name) &&
                Objects.equals(fathercode, netArea.fathercode) &&
                Objects.equals(state, netArea.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, fathercode, level, state);
    }
}
