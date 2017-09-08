package com.netcar.service;

import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetDriverbaseinfo;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Mander on 2017/5/3.
 */
public interface NetDriverbaseinfoService {


    /**
     * 根据字段参数查询
     * @param address 行政区划代码
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    BaseTable findAll(String address, String sort, int limit, int offset);


    /**
     * 根据字段参数查询
     * @param address 行政区划代码
     * @param parm 字段名
     * @param value 字段值
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    BaseTable findAllByParm(String address, String parm, String value, String sort, int limit, int offset);

    public List<NetDriverbaseinfo> findDriverDatail(String name);

    NetDriverbaseinfo  findBydriverByParm(String parm, String value);



    NetDriverbaseinfo findDriverBaseinfoBylicenseid(String licenseid);

    List<HashMap<String,Object>> findlicenseidAllPic(String companyidc);
}
