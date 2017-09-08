package com.netcar.dataModle;

/**
 * Created by Mander on 2017/5/21.
 */
public class SocketMessage {

    private String state;//["error","success]
    private String dataType;//["gps","trip"]
    private Object object;//data[]



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
