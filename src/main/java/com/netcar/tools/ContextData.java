package com.netcar.tools;

import com.netcar.entity.NetAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mander on 2017/4/26.
 */
public class ContextData {


    public static final String  loginuser="loginuser";

    public static final String socketUser="socketUser";

    //缓存功能列表
    public static  List<NetAuthority> NetAuthoritys=new ArrayList<>();



    //车辆照片文件编号
    private  String baseinfoVehiclePhotoId;

    //#驾驶员照片文件编号
    private  String baseinfoDriverPhotoId;

    //#驾驶证扫描件文件编号
    private  String baseinfoDriverLicensePhotoId;

    //#法人身份证照片
    private  String  baseinfoCompanyLeagPhoto;


    public String getBaseinfoVehiclePhotoId() {
        return baseinfoVehiclePhotoId;
    }

    public void setBaseinfoVehiclePhotoId(String baseinfoVehiclePhotoId) {
        this.baseinfoVehiclePhotoId = baseinfoVehiclePhotoId;
    }

    public String getBaseinfoDriverPhotoId() {
        return baseinfoDriverPhotoId;
    }

    public void setBaseinfoDriverPhotoId(String baseinfoDriverPhotoId) {
        this.baseinfoDriverPhotoId = baseinfoDriverPhotoId;
    }

    public String getBaseinfoDriverLicensePhotoId() {
        return baseinfoDriverLicensePhotoId;
    }

    public void setBaseinfoDriverLicensePhotoId(String baseinfoDriverLicensePhotoId) {
        this.baseinfoDriverLicensePhotoId = baseinfoDriverLicensePhotoId;
    }

    public String getBaseinfoCompanyLeagPhoto() {
        return baseinfoCompanyLeagPhoto;
    }

    public void setBaseinfoCompanyLeagPhoto(String baseinfoCompanyLeagPhoto) {
        this.baseinfoCompanyLeagPhoto = baseinfoCompanyLeagPhoto;
    }


}
