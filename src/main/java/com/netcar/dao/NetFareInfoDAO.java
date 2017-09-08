package com.netcar.dao;

import com.netcar.dataModle.FareInfoData;

import java.util.List;

/**
 * 运价信息
 * Created by Administrator on 2017/6/14.
 */

public interface NetFareInfoDAO {


    /**
     * 查询运价信息
     * @param company
     * @param areacode
     * @param stime
     * @param etime
     * @return
     */
   List<FareInfoData> findFareInfo(String company, String areacode, String stime, String etime,int limit,int offset);

    /**
     * 查询条数
     * @param company
     * @param areacode
     * @param stime
     * @param etime
     * @return
     */
   int findcount(String company,String areacode,String stime,String etime);

    /**
     * 运价信息明细
     * @param fareid
     * @return
     */
    FareInfoData findFareInfoDatail(String fareid);
}
