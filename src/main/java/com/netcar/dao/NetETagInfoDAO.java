package com.netcar.dao;

import com.netcar.dataModle.ShowETag;
import com.netcar.entity.NetEtag;

import java.util.List;

/**
 * Created by Wby on 2017/5/4.
 * 标签数据库操作接口类
 */
public interface NetETagInfoDAO {


    /**
     * 根据字段参数查询
     *
     * @param address 行政区划代码
     * @param sort    排序字段名
     * @param limit   总条数
     * @param offset  开始条数
     * @return
     */
    List<ShowETag> findAll(String address, String sort, int limit, int offset);

    int findAllCount(String address);

    /**
     * 根据车牌号查询标签信息
     *
     * @param address 行政区划代码
     * @param param   字段名
     * @param value   字段值
     * @param sort    排序字段名
     * @param limit   总条数
     * @param offset  开始条数
     * @return
     */
    List<ShowETag> findByCarInfo(String address, String param, String value, String sort, int limit, int offset);

    int findByCarInfoCount(String address, String param, String value);

    /**
     * 添加标签信息
     *
     * @param info 终端信息
     * @param num  绑定车牌
     * @return
     */
    boolean add(NetEtag info, String num);

    boolean edit(NetEtag netEtag);

    boolean delete(String eTagId);

}
