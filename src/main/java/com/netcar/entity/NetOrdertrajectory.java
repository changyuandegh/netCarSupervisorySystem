package com.netcar.entity;

import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetOrdertrajectory {

    private long ordertrajectoryid;
    private long orderid;
    private String ordertrajectory;

    public long getOrdertrajectoryid() {
        return ordertrajectoryid;
    }

    public void setOrdertrajectoryid(long ordertrajectoryid) {
        this.ordertrajectoryid = ordertrajectoryid;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getOrdertrajectory() {
        return ordertrajectory;
    }

    public void setOrdertrajectory(String ordertrajectory) {
        this.ordertrajectory = ordertrajectory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetOrdertrajectory that = (NetOrdertrajectory) o;
        return ordertrajectoryid == that.ordertrajectoryid &&
                orderid == that.orderid &&
                Objects.equals(ordertrajectory, that.ordertrajectory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordertrajectoryid, orderid, ordertrajectory);
    }
}
