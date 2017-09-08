package com.netcar.service;

import com.netcar.dataModle.ServiceScopeLevel;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.entity.NetRatedDriver;

import java.util.List;

/**
 * Created by Mander on 2017/6/13.
 */
public interface NetRatedDriverService {

    NetRatedDriver findParm(String parn, String value);



    /**
     * 司机信誉
     * @param licenseid
     * @return
     */
    List<ServiceScopeLevel> findRateDriverByLicenseid(String licenseid);



    NetRatedDriver findLastTestDateRateDriverByLicenseid(String licenseid);




}
