package com.netcar.dataModle;

import java.sql.Timestamp;

/**
 * Created by Mander on 2017/5/9.
 * 订单轨迹点实体
 */
public class OrderPoint {

    private Double lat;//纬度
    private Double lng;//经度
    private Timestamp locTime;//定位时间

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Timestamp getLocTime() {
        return locTime;
    }

    public void setLocTime(Timestamp locTime) {
        this.locTime = locTime;
    }

    public OrderPoint() {
    }

    public OrderPoint(Double lat, Double lng, Timestamp locTime) {
        this.lat = lat;
        this.lng = lng;
        this.locTime = locTime;
    }
}
