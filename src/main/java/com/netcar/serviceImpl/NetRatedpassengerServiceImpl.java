package com.netcar.serviceImpl;

import com.netcar.dao.NetRatedpassengerDAO;
import com.netcar.dataModle.ServiceScopeLevel;
import com.netcar.service.NetRatedpassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mander on 2017/6/13.
 */
@Service
public class NetRatedpassengerServiceImpl implements NetRatedpassengerService {


    @Autowired
    private NetRatedpassengerDAO NetRatedpassengerDAOImpl;


    @Override
    public List<ServiceScopeLevel> getServiceScopegroupByCompanyidc(String companyidc) {
        return NetRatedpassengerDAOImpl.getServiceScopegroupByCompanyidc(companyidc);
    }
}
