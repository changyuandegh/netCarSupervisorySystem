package com.netcar.entity;

import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetLogger {

    private int loggerid;
    private String userid;
    private String worktype;
    private String workdesc;

    public int getLoggerid() {
        return loggerid;
    }

    public void setLoggerid(int loggerid) {
        this.loggerid = loggerid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getWorkdesc() {
        return workdesc;
    }

    public void setWorkdesc(String workdesc) {
        this.workdesc = workdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetLogger netLogger = (NetLogger) o;
        return loggerid == netLogger.loggerid &&
                Objects.equals(userid, netLogger.userid) &&
                Objects.equals(worktype, netLogger.worktype) &&
                Objects.equals(workdesc, netLogger.workdesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loggerid, userid, worktype, workdesc);
    }
}
