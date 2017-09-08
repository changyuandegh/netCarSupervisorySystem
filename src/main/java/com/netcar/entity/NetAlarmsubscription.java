package com.netcar.entity;

import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetAlarmsubscription {

    private int id;
    private int userid;
    private int alarmid;

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

    public int getAlarmid() {
        return alarmid;
    }

    public void setAlarmid(int alarmid) {
        this.alarmid = alarmid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetAlarmsubscription that = (NetAlarmsubscription) o;
        return id == that.id &&
                userid == that.userid &&
                alarmid == that.alarmid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, alarmid);
    }
}
