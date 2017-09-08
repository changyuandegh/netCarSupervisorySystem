package com.netcar.service;

import com.netcar.dataModle.ServiceScopeLevel;

import java.util.List;

/**
 * Created by Mander on 2017/6/13.
 */
public interface NetRatedpassengerService {

    List<ServiceScopeLevel> getServiceScopegroupByCompanyidc(String companyidc);


}
