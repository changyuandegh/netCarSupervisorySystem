package com.netcar.dataModle;

/**
 * Created by Mander on 2017/5/10.
 * 热力点
 *  {"lng":116.418261,"lat":39.921984,"count":50},
 *  {"lng":116.418261,"lat":39.921984,"count":50},
 *  {"lng":116.423332,"lat":39.916532,"count":51},
 */
public class ThermalPoint {

    private String lat;//纬度
    private String lng;//经度
    private int count;//次数


    public ThermalPoint() {

    }

    public ThermalPoint(String lat, String lng, int count) {
        this.lat = lat;
        this.lng = lng;
        this.count = count;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
