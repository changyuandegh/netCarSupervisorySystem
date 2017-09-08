package com.netcar.serviceImpl;

import com.netcar.dao.NetDeviceInfoDAO;
import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetDevice;
import com.netcar.service.NetDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by Wby on 2017/5/4.
 * 终端分页查找服务
 */
@Service
public class NetDeviceInfoServiceImpl implements NetDeviceInfoService {


    @Autowired
    private NetDeviceInfoDAO netDeviceInfoDAOImpl;

    /**
     * 查找地区所有终端
     *
     * @param address 区划代码
     * @param sort    排序字段
     * @param limit   符合条件总条数
     * @param offset  查询开始条数
     * @return
     */
    @Override
    public BaseTable findAll(String address, String sort, int limit, int offset) {
        return new BaseTable(netDeviceInfoDAOImpl.findAllCount(address), netDeviceInfoDAOImpl.findAll(address, sort, limit, offset));
    }

    /**
     * 根据车辆信息查询终端
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
        return new BaseTable(netDeviceInfoDAOImpl.findByCarInfoCount(address, param, value), netDeviceInfoDAOImpl.findByCarInfo(address, param, value, sort, limit, offset));
    }

    @Override
    public boolean add(NetDevice info, String num) {
        return netDeviceInfoDAOImpl.add(info, num);
    }

    @Override
    public boolean edit(NetDevice device) {
        return netDeviceInfoDAOImpl.edit(device);
    }

    @Override
    public boolean delete(String deviceid) {
        try {
            return netDeviceInfoDAOImpl.delete(deviceid);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 添加终端
     * @param info 终端信息
     * @param num 绑定车牌号
     * @return
     */

}
