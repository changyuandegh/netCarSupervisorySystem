package com.netcar.service;

import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetElectricfence;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
public interface NetElectricfenceService {

    /**
     * 查询电子围栏信息
     * @param address 行政区划代码
     * @param limit 总条数
     * @param offset 开始条数
     * @return
     */
    BaseTable findAll(String address, int limit, int offset);

    /**
     * 通过条件查询围栏信息
     * @param address 行政区划代码
     * @param param 字段名
     * @param value 字段值
     * @param limit 查询总数
     * @param offset 开始条数
     * @return
     */
    BaseTable findByParam(String address, String param, String value, int limit, int offset);



    /**
     *@条件查询
     * @param address 地区
     * @param type 类型
     * @param shape 形状
     * @param name  名称
     * @return
     */
    BaseTable findByParms(String address,String type,String shape,String name,int limit,int offset);

    List<?> findRowsByParms(String address, String type, String shape, String name,int limit,int offset);

    int  findCountByParms(String address,String type,String shape,String name);


    /**
     * 添加电子围栏信息
     * @param item 电子围栏信息
     * @return
     */
    boolean add(NetElectricfence item);

    /**
     * 删除电子围栏
     * @param item
     * @return
     */
    boolean delete(NetElectricfence item);

    /**
     * 修改电子围栏信息
     * @param item
     * @return
     */
    boolean update(NetElectricfence item);


    boolean deleteByfenceid(int fenceid);

}
