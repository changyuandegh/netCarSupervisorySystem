package com.netcar.serviceImpl;

import com.netcar.dao.NetElectricfenceDAO;
import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetElectricfence;
import com.netcar.service.NetElectricfenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Service
public class NetElectricfenceServiceImpl implements NetElectricfenceService {


    @Autowired
    private NetElectricfenceDAO netElectricfencedaoImpl;

    @Override
    public BaseTable findAll(String address, int limit, int offset) {
        BaseTable baseTable = new BaseTable();
        List<NetElectricfence> list = netElectricfencedaoImpl.findAll(address, limit, offset);
        if (list != null) {
            baseTable.setTotal(netElectricfencedaoImpl.findAllCount(address));
            baseTable.setRows(list);
        } else {
            baseTable.setTotal(0);
        }
        return baseTable;
    }

    @Override
    public BaseTable findByParam(String address, String param, String value, int limit, int offset) {
        BaseTable baseTable = new BaseTable();
        List<NetElectricfence> list = netElectricfencedaoImpl.findByParam(address, param, value, limit, offset);
        if (list != null) {
            baseTable.setTotal(netElectricfencedaoImpl.findByParamCount(address, param, value));
            baseTable.setRows(list);
        } else {
            baseTable.setTotal(0);
        }
        return baseTable;
    }

    /**
     * 条件查询
     *
     * @param address 地区
     * @param type    类型
     * @param shape   形状
     * @param name    名称
     * @return
     */
    @Override
    public BaseTable findByParms(String address, String type, String shape, String name, int limit, int offset) {
        return new BaseTable(netElectricfencedaoImpl.findByParamCount(address, type, shape, name), netElectricfencedaoImpl.findByParms(address, type, shape, name, limit, offset));
    }


    @Override
    public List<?> findRowsByParms(String address, String type, String shape, String name,int limit,int offset) {
        return netElectricfencedaoImpl.findByParms(address, type, shape, name, limit, offset);
    }


    @Override
    public int findCountByParms(String address, String type, String shape, String name) {
        return netElectricfencedaoImpl.findByParamCount(address, type, shape, name);
    }


    @Override
    public boolean add(NetElectricfence item) {
        return netElectricfencedaoImpl.add(item);
    }

    @Override
    public boolean delete(NetElectricfence item) {
        return netElectricfencedaoImpl.delete(item);
    }


    @Override
    public boolean update(NetElectricfence item) {
        return netElectricfencedaoImpl.update(item);
    }


    @Override
    public boolean deleteByfenceid(int fenceid) {
        return netElectricfencedaoImpl.deleteByfenceid(fenceid);
    }
}
