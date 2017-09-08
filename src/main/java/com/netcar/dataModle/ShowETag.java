package com.netcar.dataModle;


import com.netcar.entity.NetEtag;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Work on 2017/5/4.
 */
public class ShowETag {


    private String vechileno;
    private String etagid;
    private String brand;
    private String model;
    private String imei;
    private String installdate;
    private String createtime;
    private String updatetime;

    public String getVechileno() {
        return vechileno;
    }

    public void setVechileno(String vechileno) {
        this.vechileno = vechileno;
    }


    public String getEtagid() {
        return etagid;
    }

    public void setEtagid(String etagid) {
        this.etagid = etagid;
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
