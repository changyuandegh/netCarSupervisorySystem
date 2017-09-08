package com.netcar.serviceImpl;

import com.netcar.dao.NetRatedpassengercomplaintDAO;
import com.netcar.service.NetRatedpassengercomplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mander on 2017/6/13.
 */
@Service
public class NetRatedpassengercomplaintServiceImpl implements NetRatedpassengercomplaintService {

    @Autowired
    private NetRatedpassengercomplaintDAO netRatedpassengercomplaintDAOImpl;

    /**
     * 获得公司投诉处理率
     * @param companyidc
     * @return
     */
    @Override
    public Double getServiceScopegroupByCompanyidc(String companyidc) {
        return netRatedpassengercomplaintDAOImpl.getServiceScopegroupByCompanyidc(companyidc);
    }




}
