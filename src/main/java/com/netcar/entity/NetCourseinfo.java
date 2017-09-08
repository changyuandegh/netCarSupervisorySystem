package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetCourseinfo {

    private int courseid;
    private String coursename;
    private Date coursedate;
    private Timestamp starttime;
    private Timestamp stoptime;
    private int duration;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Date getCoursedate() {
        return coursedate;
    }

    public void setCoursedate(Date coursedate) {
        this.coursedate = coursedate;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getStoptime() {
        return stoptime;
    }

    public void setStoptime(Timestamp stoptime) {
        this.stoptime = stoptime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
        NetCourseinfo that = (NetCourseinfo) o;
        return courseid == that.courseid &&
                duration == that.duration &&
                Objects.equals(coursename, that.coursename) &&
                Objects.equals(coursedate, that.coursedate) &&
                Objects.equals(starttime, that.starttime) &&
                Objects.equals(stoptime, that.stoptime) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseid, coursename, coursedate, starttime, stoptime, duration, createtime, updatetime);
    }
}
