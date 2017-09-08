package com.netcar.dataModle;

import java.sql.Timestamp;

/**
 * Created by Mander on 2017/5/8.
 * 显示的pgs信息
 */
public class ShowGps {

    private String lng;//经度
    private String lat;//纬度
    private int encrypt;//坐标类型
    private String speed;//速度
    private Timestamp time;//定位时间


    public ShowGps() {
    }

    public ShowGps(String lng, String lat, String speed, Timestamp time) {
        this.lng = lng;
        this.lat = lat;
        this.speed = speed;
        this.time = time;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(int encrypt) {
        this.encrypt = encrypt;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
