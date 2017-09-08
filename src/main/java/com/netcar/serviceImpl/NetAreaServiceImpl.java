package com.netcar.serviceImpl;

import com.netcar.dao.NetAreaDAO;
import com.netcar.entity.NetArea;
import com.netcar.service.NetAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mander on 2017/5/3.
 */
@Service
public class NetAreaServiceImpl implements NetAreaService {

    @Autowired
    private NetAreaDAO netAreaDAOImpl;



    @Override
    public List<NetArea> findChildrenBycode(String code) {
        return netAreaDAOImpl.findChildrenBycode(code);
    }



}
