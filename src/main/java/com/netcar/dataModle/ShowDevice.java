package com.netcar.dataModle;


import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Work on 2017/5/4.
 */
public class ShowDevice {

   private String vechileno;
    private String  deviceid;
    private String brand;
    private String model;
    private String imei;
    private String  sim;
    private String installdate;
    private String createtime;
    private String updatetime;


    public String getVechileno() {
        return vechileno;
    }

    public void setVechileno(String vechileno) {
        this.vechileno = vechileno;
    }


    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }


    public String getInstalldate() {
        return installdate;
    }

    public void setInstalldate(String installdate) {
        this.installdate = installdate;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
