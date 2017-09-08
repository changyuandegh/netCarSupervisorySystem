package com.netcar.serviceImpl;

import com.netcar.dao.NetOrderPayDAO;
import com.netcar.entity.NetOrderpay;
import com.netcar.service.NetOrderPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mander on 2017/6/15.
 */
@Service
public class NetOrderPayServiceImpl implements NetOrderPayService {

    @Autowired
    private NetOrderPayDAO netOrderPayDAOImpl;


    @Override
    public NetOrderpay findbyorderid(String orderid) {

        return netOrderPayDAOImpl.findbyorderid(orderid);
    }
}
