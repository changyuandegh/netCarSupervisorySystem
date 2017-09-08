package com.netcar.dao;

import com.netcar.dataModle.ServiceScopeLevel;

import java.util.List;

/**
 * Created by Mander on 2017/6/13.
 */
public interface NetRatedpassengerDAO {

    List<ServiceScopeLevel> getServiceScopegroupByCompanyidc(String companyidc);

}
