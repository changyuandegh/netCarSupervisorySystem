package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetElectricfence {

    private int id;
    private String name;
    private int address;
    private int type;
    private int shape;
    private Double radius;
    private String points;
    private int encrypt;
    private Date startdate;
    private Date stopdate;
    private int creatorid;
    private Timestamp createtime;
    private Timestamp updatetime;
    private int state;


    public NetElectricfence() {
    }

    public NetElectricfence(int id, String name, int address, int type, int shape, Double radius, String points, int encrypt, Date startdate, Date stopdate, int creatorid, Timestamp createtime, Timestamp updatetime, int state) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.shape = shape;
        this.radius = radius;
        this.points = points;
        this.encrypt = encrypt;
        this.startdate = startdate;
        this.stopdate = stopdate;
        this.creatorid = creatorid;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.state = state;
    }

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

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public int getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(int encrypt) {
        this.encrypt = encrypt;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getStopdate() {
        return stopdate;
    }

    public void setStopdate(Date stopdate) {
        this.stopdate = stopdate;
    }

    public int getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(int creatorid) {
        this.creatorid = creatorid;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetElectricfence that = (NetElectricfence) o;
        return id == that.id &&
                address == that.address &&
                type == that.type &&
                shape == that.shape &&
                creatorid == that.creatorid &&
                state == that.state &&
                encrypt == that.encrypt &&
                Objects.equals(name, that.name) &&
                Objects.equals(radius, that.radius) &&
                Objects.equals(points, that.points) &&
                Objects.equals(startdate, that.startdate) &&
                Objects.equals(stopdate, that.stopdate) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, type, shape, radius, points, encrypt, startdate, stopdate, creatorid, createtime, updatetime, state);
    }

    @Override
    public String toString() {
        return "NetElectricfence{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", type=" + type +
                ", shape=" + shape +
                ", radius=" + radius +
                ", points='" + points + '\'' +
                ",encrypt='" + encrypt + '\'' +
                ", startdate=" + startdate +
                ", stopdate=" + stopdate +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", state=" + state +
                '}';
    }
}
