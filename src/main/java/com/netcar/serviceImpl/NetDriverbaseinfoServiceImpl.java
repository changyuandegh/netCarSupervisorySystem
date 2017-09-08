package com.netcar.serviceImpl;

import com.netcar.dao.NetDriverbaseinfoDAO;
import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.service.NetDriverbaseinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Work on 2017/5/3.
 */
@Service
public class NetDriverbaseinfoServiceImpl implements NetDriverbaseinfoService {

    @Autowired
    private NetDriverbaseinfoDAO netDriverbaseinfoDAOImpl;

    @Override
    public BaseTable findAll(String address, String sort, int limit, int offset) {
        return new BaseTable(netDriverbaseinfoDAOImpl.findAllCount(address),netDriverbaseinfoDAOImpl.findAll(address, sort, limit, offset));
    }

    @Override
    public BaseTable findAllByParm(String address, String parm, String value, String sort, int limit, int offset) {
        return new BaseTable(netDriverbaseinfoDAOImpl.findAllByParmCount(address, parm, value),netDriverbaseinfoDAOImpl.findAllByParm(address,parm,value,sort,limit,offset));
    }


    @Override
    public NetDriverbaseinfo findBydriverByParm(String parm, String value) {
        return netDriverbaseinfoDAOImpl.findBydriverByParm(parm,value);
    }


    @Override
    public NetDriverbaseinfo findDriverBaseinfoBylicenseid(String licenseid) {
        return netDriverbaseinfoDAOImpl.findDriverBaseinfoBylicenseid(licenseid);
    }

    @Override
    public List<HashMap<String, Object>> findlicenseidAllPic(String companyidc) {
        return netDriverbaseinfoDAOImpl.findlicenseidAllPic(companyidc);
    }

    @Override
    public List<NetDriverbaseinfo> findDriverDatail(String name) {
        List<NetDriverbaseinfo> driverDatail=new ArrayList<NetDriverbaseinfo>();
        driverDatail=netDriverbaseinfoDAOImpl.findDriverDarail(name);
        return driverDatail;
    }
}
