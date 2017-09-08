package com.netcar.dataModle;

import com.netcar.entity.NetOrderstatistics;

/**
 * Created by Wby on 2017/5/16.
 */
public class OrderStatisticsData {
    private String name;
    private NetOrderstatistics netOrderstatistics;

    public OrderStatisticsData() {
    }

    public OrderStatisticsData(String name, NetOrderstatistics netOrderstatistics) {
        this.name = name;
        this.netOrderstatistics = netOrderstatistics;
    }

    public String getNamne() {
        return name;
    }

    public void setNamne(String namne) {
        this.name = namne;
    }

    public NetOrderstatistics getNetOrderstatistics() {
        return netOrderstatistics;
    }

    public void setNetOrderstatistics(NetOrderstatistics netOrderstatistics) {
        this.netOrderstatistics = netOrderstatistics;
    }

    @Override
    public String toString() {
        return "OrderStatisticsData{" +
                "name='" + name + '\'' +
                ", netOrderstatistics=" + netOrderstatistics.toString() +
                '}';
    }
}
