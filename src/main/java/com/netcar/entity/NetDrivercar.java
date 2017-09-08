package com.netcar.entity;

import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetDrivercar {

    private int drivercarid;
    private int driverid;
    private int carid;
    private int state;

    public int getDrivercarid() {
        return drivercarid;
    }

    public void setDrivercarid(int drivercarid) {
        this.drivercarid = drivercarid;
    }

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
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
        NetDrivercar that = (NetDrivercar) o;
        return drivercarid == that.drivercarid &&
                driverid == that.driverid &&
                carid == that.carid &&
                state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drivercarid, driverid, carid, state);
    }
}
