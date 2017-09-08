package com.netcar.dao;

import com.netcar.entity.NetDriverbaseinfo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Work on 2017/5/3.
 */
public interface NetDriverbaseinfoDAO {


    /**
     * 根据字段参数查询
     * @param address 行政区划代码
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    List<NetDriverbaseinfo> findAll(String address, String sort, int limit, int offset);


    int findAllCount(String address);


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
    List<NetDriverbaseinfo> findAllByParm(String address,String parm,String value, String sort, int limit,int offset);

    int findAllByParmCount(String address,String parm,String value);


    NetDriverbaseinfo  findBydriverByParm(String parm,String value);

    NetDriverbaseinfo  findDriverBaseinfoBylicenseid(String licenseid);
    /**
     * 查询接单司机信息
     * @param name
     * @return
     */
    public List<NetDriverbaseinfo> findDriverDarail(String name);

    List<HashMap<String,Object>> findlicenseidAllPic(String companyidc);
}
