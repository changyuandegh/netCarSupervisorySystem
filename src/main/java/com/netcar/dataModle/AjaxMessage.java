package com.netcar.dataModle;

/**
 * Created by Mander on 2017/5/12.
 * 异步请求返回消息
 */
public class AjaxMessage {

    private String name;//名称
    private  String  desc;//描述
    private  String value;//值



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    public AjaxMessage() {
    }

    public AjaxMessage(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    @Override
    public String toString() {
        return "AjaxMessage{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
