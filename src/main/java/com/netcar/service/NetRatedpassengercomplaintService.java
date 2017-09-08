package com.netcar.service;

/**
 * Created by Mander on 2017/6/13.
 */
public interface NetRatedpassengercomplaintService {

    /**
     * 获得公司投诉处理率
     * @param companyidc
     * @return
     */
    Double getServiceScopegroupByCompanyidc(String companyidc);

}
