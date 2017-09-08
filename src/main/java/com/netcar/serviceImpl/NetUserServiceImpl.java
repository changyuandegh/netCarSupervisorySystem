package com.netcar.serviceImpl;

import com.netcar.dao.NetUserDAO;
import com.netcar.entity.NetUser;
import com.netcar.service.NetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mander on 2017/4/25.
 */
@Service
public class NetUserServiceImpl implements NetUserService {

    @Autowired
    private NetUserDAO netUserDAOImpl;


    @Override
    public NetUser findByNamePass(String name, String pass) {
        return netUserDAOImpl.findByNamePass(name,pass);
    }




    @Override
    public List<NetUser> findAll(int limit, int offset) {
        return null;
    }




}
