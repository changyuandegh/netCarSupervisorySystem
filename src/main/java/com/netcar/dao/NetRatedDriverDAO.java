package com.netcar.dao;

import com.netcar.dataModle.ServiceScopeLevel;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.entity.NetRatedDriver;

import java.util.List;

/**
 * Created by Mander on 2017/6/13.
 */
public interface NetRatedDriverDAO {


    NetRatedDriver findParm(String parn,String value);


    List<ServiceScopeLevel> findRateDriverByLicenseid(String licenseid);


    NetRatedDriver findLastTestDateRateDriverByLicenseid(String licenseid);



}
