package com.netcar.service;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;

import java.util.List;

/**
 * Created by Mander on 2017/7/5.
 * 公司认证接口
 */
public interface NetCompanyAuthService {


    AjaxMessage addCompanyAuth(String companyidc);

    BaseTable findHisAuthToTableBy(String companyidc, Integer limit, Integer offset);



    List<Object> findAllCompanyidc();
}
