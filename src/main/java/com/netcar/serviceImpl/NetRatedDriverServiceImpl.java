package com.netcar.serviceImpl;

import com.netcar.dao.NetRatedDriverDAO;
import com.netcar.dataModle.ServiceScopeLevel;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.entity.NetRatedDriver;
import com.netcar.service.NetDriverbaseinfoService;
import com.netcar.service.NetRatedDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mander on 2017/6/13.
 */
@Service
public class NetRatedDriverServiceImpl implements NetRatedDriverService{

    @Autowired
    private NetRatedDriverDAO netRatedDriverDAOImpl;

    @Override
    public NetRatedDriver findParm(String parm, String value) {
        return netRatedDriverDAOImpl.findParm(parm,value);
    }

    /**
     * 司机信誉
     * @param licenseid
     * @return
     */
    @Override
    public List<ServiceScopeLevel> findRateDriverByLicenseid(String licenseid) {
        return netRatedDriverDAOImpl.findRateDriverByLicenseid(licenseid);
    }

    public  NetRatedDriver findLastTestDateRateDriverByLicenseid(String licenseid){
        return netRatedDriverDAOImpl.findLastTestDateRateDriverByLicenseid(licenseid);
    }



}
