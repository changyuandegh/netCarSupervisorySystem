package com.netcar.dao;

import java.util.List;

/**
 * Created by Mander on 2017/7/5.
 */
public interface NetCompanyAuthDAO {


     boolean addCompanyAuth(String companyidc);

    int  updateByCompanyidc(String companyidc);


    Integer findCountHisAuthToByCompanyidc(String companyidc);

    List findHisAuthToByCompanyidc(String companyidc, Integer limit, Integer offset);

    List<Object> findAllCompanyidc();
}
