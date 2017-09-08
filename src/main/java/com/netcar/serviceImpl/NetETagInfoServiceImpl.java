package com.netcar.serviceImpl;

import com.netcar.dao.NetETagInfoDAO;
import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetEtag;
import com.netcar.service.NetETagInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Wby on 2017/5/4.
 * 标签分页查找服务
 */
@Service
public class NetETagInfoServiceImpl implements NetETagInfoService {

    @Autowired
    private NetETagInfoDAO netETagInfoDAOImpl;

    /**
     * 查找地区所有标签
     *
     * @param address 区划代码
     * @param sort    排序字段
     * @param limit   符合条件总条数
     * @param offset  查询开始条数
     * @return
     */
    @Override
    public BaseTable findAll(String address, String sort, int limit, int offset) {
        return new BaseTable(netETagInfoDAOImpl.findAllCount(address), netETagInfoDAOImpl.findAll(address, sort, limit, offset));
    }

    /**
     * 根据车辆信息查询标签
     *
     * @param address 区划代码
     * @param param   车辆表字段名
     * @param value   筛选字段值
     * @param sort    排序字段名
     * @param limit   符合条件总条数
     * @param offset  查询开始条数
     * @return
     */
    @Override
    public BaseTable findByCarInfo(String address, String param, String value, String sort, int limit, int offset) {
        return new BaseTable(netETagInfoDAOImpl.findByCarInfoCount(address, param, value), netETagInfoDAOImpl.findByCarInfo(address, param, value, sort, limit, offset));
    }



    /**
     * 添加/绑定标签信息
     *
     * @param info 标签信息
     * @param num  绑定车牌号
     * @return
     */
    @Override
    public boolean add(NetEtag info, String num) {
        return netETagInfoDAOImpl.add(info,num);
    }


    @Override
    public boolean edit(NetEtag netEtag) {
        return netETagInfoDAOImpl.edit(netEtag);
    }


    @Override
    public boolean delete(String etagid) {
        return netETagInfoDAOImpl.delete(etagid);
    }

}
