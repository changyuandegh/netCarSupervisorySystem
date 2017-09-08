package com.netcar.serviceImpl;

import com.netcar.dao.NetCompanybaseinfoDAO;
import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetCompanybaseinfo;
import com.netcar.service.NetCompanybaseinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mander on 2017/5/2.
 */
@Service
public class NetCompanybaseinfoServiceImpl implements NetCompanybaseinfoService {

    @Autowired
    private NetCompanybaseinfoDAO netCompanybaseinfodaoImpl;

    /**
     *
     * @param limit
     * @param offset
     * @return
     */
    @Override
    public List<NetCompanybaseinfo> findAll(int limit, int offset) {
        return null;
    }

    /**
     *
     * @param limit 显示总条数
     * @param offset 从第offset条开始
     * @param areacode 行政区划编号
     * @param sort
     * @return
     */
    @Override
    public BaseTable findAll(int limit, int offset, int areacode, String sort) {
        BaseTable baseTable = new BaseTable();
        List<NetCompanybaseinfo> list = netCompanybaseinfodaoImpl.findAll(areacode+"", sort, limit, offset);
        if (list!=null) {
            baseTable.setTotal(netCompanybaseinfodaoImpl.findAllCount(areacode+""));
            baseTable.setRows(list);
        } else {
            baseTable.setTotal(0);
        }
        return baseTable;
    }

    @Override
    public BaseTable findByParm(String parm, String value, int limit, int offset, int areacode, String sort) {
        BaseTable baseTable = new BaseTable();
        List<NetCompanybaseinfo> list = netCompanybaseinfodaoImpl.findAllByParm(areacode+"", parm, value, sort, limit, offset);
        if (list!=null) {
            baseTable.setTotal(netCompanybaseinfodaoImpl.findByParmCount(areacode+"", parm, value));
            baseTable.setRows(list);
        } else {
            baseTable.setTotal(0);
        }
        return baseTable;
    }


    @Override
    public List<AjaxMessage> findidNameByareacode(String areacode) {
        return netCompanybaseinfodaoImpl.findidNameByareacode(areacode);
    }

    @Override
    public List<AjaxMessage> findidcNameByareacode(String areacode) {
        return netCompanybaseinfodaoImpl.findidcNameByareacode(areacode);
    }

    @Override
    public String findIdcNameAuthing() {

         return netCompanybaseinfodaoImpl.findIdcNameAuthing();
    }

    @Override
    public List<AjaxMessage> findCompanyAuthInterfaceState(String companyidc) {
        return netCompanybaseinfodaoImpl.findCompanyAuthInterfaceState(companyidc);
    }

    @Override
    public List<HashMap<String, Object>> findCompanyidcleagPhoto(String companyidc) {
        return netCompanybaseinfodaoImpl.findCompanyidcleagPhoto(companyidc);
    }


}
