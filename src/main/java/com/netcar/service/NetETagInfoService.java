package com.netcar.service;

import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetDevice;
import com.netcar.entity.NetEtag;

/**
 * Created by Work on 2017/5/4.
 */
public interface NetETagInfoService {

    /**
     * 查找各地区所有电子标签
     * @param address 区划代码
     * @param sort 排序字段
     * @param limit 符合条件总条数
     * @param offset 查询开始条数
     * @return
     */
    BaseTable findAll(String address, String sort, int limit, int offset);

    /**
     * 查询符合条件车辆的标签信息
     * @param address 区划代码
     * @param param 车辆表字段名
     * @param value 筛选字段值
     * @param sort 排序字段名
     * @param limit 符合条件总条数
     * @param offset 查询开始条数
     * @return
     */
    BaseTable findByCarInfo(String address, String param, String value, String sort, int limit, int offset);

    /**
     * 添加/绑定标签信息
     * @param info 标签信息
     * @param num 绑定车牌号
     * @return
     */
    boolean add(NetEtag info, String num);


    /**
     * 编辑
     * @param netEtag
     * @return
     */
    boolean edit(NetEtag netEtag);


    /**
     * 删除
     * @param etagid
     * @return
     */
    boolean delete(String etagid);



}
