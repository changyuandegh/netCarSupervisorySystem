package com.netcar.dataModle;

/**
 * Created by Work on 2017/5/16.
 */
public class StatisticsNumData {

    private int orderNum;
    private int mileageNum;
    private int moneyNum;
    private int driverNum;
    private int psgNum;


    public StatisticsNumData() {
    }

    public StatisticsNumData(int orderNum, int mileageNum, int moneyNum, int driverNum, int psgNum) {
        this.orderNum = orderNum;
        this.mileageNum = mileageNum;
        this.moneyNum = moneyNum;
        this.driverNum = driverNum;
        this.psgNum = psgNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getMileageNum() {
        return mileageNum;
    }

    public void setMileageNum(int mileageNum) {
        this.mileageNum = mileageNum;
    }

    public int getMoneyNum() {
        return moneyNum;
    }

    public void setMoneyNum(int moneyNum) {
        this.moneyNum = moneyNum;
    }

    public int getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(int driverNum) {
        this.driverNum = driverNum;
    }

    public int getPsgNum() {
        return psgNum;
    }

    public void setPsgNum(int psgNum) {
        this.psgNum = psgNum;
    }

    @Override
    public String toString() {
        return "StatisticsNumData{" +
                "orderNum=" + orderNum +
                ", mileageNum=" + mileageNum +
                ", moneyNum=" + moneyNum +
                ", driverNum=" + driverNum +
                ", psgNum=" + psgNum +
                '}';
    }
}
