package com.netcar.serviceImpl;

import com.netcar.dao.NetFareInfoDAO;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.FareInfoData;
import com.netcar.service.NetFareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 运价信息管理
 * Created by Administrator on 2017/6/14.
 */
@Service
public class NetFareInfoServiceImpl implements NetFareInfoService{

    @Autowired
    private NetFareInfoDAO netFareInfoDAO;

    @Override
    public BaseTable findFareInfo(String company, String areacode, String stime, String etime,int limit,int offset) {
        BaseTable baseTable=new BaseTable();
        int count=0;
        List<FareInfoData> fareInfoDataList=netFareInfoDAO.findFareInfo(company,areacode,stime,etime,limit,offset);
        count=netFareInfoDAO.findcount(company,areacode,stime,etime);
        baseTable.setRows(fareInfoDataList);
        baseTable.setTotal(count);
        return baseTable;
    }

    @Override
    public FareInfoData findFareInfoDatail(String fareid) {
         FareInfoData fareLIst=netFareInfoDAO.findFareInfoDatail(fareid);
        return fareLIst;
    }
}
