package com.netcar.dao;

import com.netcar.entity.NetElectricfence;
import com.netcar.entity.NetUser;

import java.util.List;

/**
 * Created by wbj on 2017/5/11.
 */
public interface NetElectricfenceDAO {

    /**
     * 查询电子围栏信息
     *
     * @param address 行政区划代码
     * @param limit   总条数
     * @param offset  开始条数
     * @return
     */
    List<NetElectricfence> findAll(String address, int limit, int offset);


    /**
     * 查询电子围栏总数
     *
     * @param address 行政区划代码
     * @return
     */
    int findAllCount(String address);


    /**
     * 通过条件查询围栏信息
     *
     * @param address 行政区划代码
     * @param param   字段名
     * @param value   字段值
     * @param limit   查询总数
     * @param offset  开始条数
     * @return
     */
    List<NetElectricfence> findByParam(String address, String param, String value, int limit, int offset);

    /**
     * 通过条件查询围栏总数
     *
     * @param address 行政区划代码
     * @param param   字段名
     * @param value   字段值
     * @return
     */
    int findByParamCount(String address, String param, String value);


    List<NetElectricfence> findByParms(String address, String type, String shape, String name, int limit, int offset);

    int findByParamCount(String address, String type, String shape, String name);

    /**
     * 添加电子围栏信息
     *
     * @param item 电子围栏信息
     * @return
     */
    boolean add(NetElectricfence item);

    /**
     * 删除电子围栏
     *
     * @param item
     * @return
     */
    boolean delete(NetElectricfence item);

    /**
     * 修改电子围栏信息
     *
     * @param item
     * @return
     */
    boolean update(NetElectricfence item);


    boolean deleteByfenceid(int id);

}
