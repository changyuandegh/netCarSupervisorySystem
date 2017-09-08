package com.netcar.dataModle;

/**
 * Created by Mander on 2017/5/10.
 * 比例数据模型
 * var data = [
 {name : '神舟专车',value : 30,color:'#fedd74'},
 {name : '滴滴出行',value : 25,color:'#82d8ef'},
 {name : '99出行',value : 15,color:'#f76864'},
 {name : '首期约车',value : 20,color:'#80bd91'},
 {name : '一步用车',value : 10,color:'#fd9fc1'}
 ];
 注意: value相加为100,
 */
public class ProportionData {

    private  String name;//名称
    private String value;//百分比例值
    private String color;//显示的颜色

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ProportionData() {
    }

    public ProportionData(String name, String value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return "ProportionData{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
