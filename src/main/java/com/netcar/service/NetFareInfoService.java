package com.netcar.service;

import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.FareInfoData;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface NetFareInfoService {
    /**
     * 运价信息
     * @param company
     * @param areacode
     * @param stime
     * @param etime
     * @param limit
     * @param offset
     * @return
     */
    public BaseTable findFareInfo(String company, String areacode, String stime, String etime,int limit,int offset);

    /**
     * 运价信息明细
     * @return
     */
    FareInfoData findFareInfoDatail(String fareid);
}
