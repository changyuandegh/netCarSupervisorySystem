package com.netcar.serviceImpl;

import com.netcar.dao.NetDeviceInfoDAO;
import com.netcar.dao.NetDriverbaseinfoDAO;
import com.netcar.dao.NetRedisDAO;
import com.netcar.dao.NetStatisticsDAO;
import com.netcar.dataModle.*;
import com.netcar.entity.NetDevice;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.service.NetStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Work on 2017/5/18.
 */
@Service
public class NetStatisticsServiceImpl implements NetStatisticsService {

    @Autowired
    NetStatisticsDAO netStatisticsDAOImpl;
    @Autowired
    NetRedisDAO netRedisDAOImpl;
    @Autowired
    NetDeviceInfoDAO netDeviceInfoDAOImpl;
    @Autowired
    NetDriverbaseinfoDAO netDriverbaseinfoDAOImpl;

    @Override
    public ShowOrderStatistics getOrderStatistics(String areaCode, Date stTime, Date endTime) {
        ShowOrderStatistics showOrderStatistics = new ShowOrderStatistics();
        showOrderStatistics.setTimeStatistics(filterData(netStatisticsDAOImpl.getTimeOrderStatistics(areaCode, stTime, endTime)));
       List<OrderStatisticsData> ls=netStatisticsDAOImpl.getCompanyOrderStatistics(areaCode, stTime, endTime);
        showOrderStatistics.setCompanyStatistics(filterData(ls));
        return showOrderStatistics;
    }

    private List<AjaxMessage> filterData(List<OrderStatisticsData> datas){
        List<AjaxMessage> list = new ArrayList<>();

        for(int i=0; i<datas.size(); i++){
            AjaxMessage msg = new AjaxMessage();
            msg.setName(datas.get(i).getNamne());
            msg.setDesc(Integer.toString(datas.get(i).getNetOrderstatistics().getTotal()));
            msg.setValue(Integer.toString(datas.get(i).getNetOrderstatistics().getCompletecount()));
            list.add(msg);
        }

        return list;
    }



    /**
     * 获取数量统计。
     *
     * @param areaCode
     * @return
     */
    @Override
    public StatisticsNumData getStatisticsNum(String areaCode) {
        Calendar calendar = Calendar.getInstance();
        Date endTime = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -100);
        Date stTime = calendar.getTime();

        StatisticsNumData statisticsNumData = netStatisticsDAOImpl.getOrderStatistics(areaCode, stTime, endTime);
        if (statisticsNumData == null) return null;
        statisticsNumData.setDriverNum(netStatisticsDAOImpl.getDriverRegisterNum(areaCode));
        statisticsNumData.setPsgNum(netStatisticsDAOImpl.getPassengerRegisterNum());
        return statisticsNumData;
    }

    /**
     * 获取报警数
     *
     * @param areaCode
     * @return
     */
    @Override
    public int getAlarmNum(String areaCode) {
        return netStatisticsDAOImpl.getTodayAlarmNum(areaCode);
    }


    /**
     * 终端在线率
     *
     * @param areaCode
     * @return
     */
    @Override
    public ProportionData getOnlineProportion(String areaCode) {
        return new ProportionData("在线比例", String.format("%.2f", netRedisDAOImpl.getOnlineDevice(areaCode) * 100.0 / netDeviceInfoDAOImpl.findAllCount(areaCode)), "");
    }

    /**
     * 重载率
     *
     * @param areaCode
     * @return
     */
    @Override
    public ProportionData getOperationProportion(String areaCode) {
        return new ProportionData("重载率", String.format("%.2f", netStatisticsDAOImpl.getGetonRate(areaCode) * 100.0 / netStatisticsDAOImpl.getSigninRate(areaCode)), "");
    }

    /**
     * 司机签到率
     *
     * @param areaCode
     * @return
     */
    @Override
    public ProportionData getSignProportion(String areaCode) {
        return new ProportionData("司机签到率", String.format("%.2f", netStatisticsDAOImpl.getSigninRate(areaCode) * 100.0 / netDriverbaseinfoDAOImpl.findAllCount(areaCode)), "");
    }

    /**
     * 返回用户活跃度
     *
     * @param areaCode
     * @return
     */
    @Override
    public ProportionData getUserLiveness(String areaCode) {
        Calendar calendar = Calendar.getInstance();
        Date endTime = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date stTime = calendar.getTime();
        return new ProportionData("用户活跃度", String.format("%.2f", netStatisticsDAOImpl.getActiveRate(areaCode, stTime, endTime) * 100.0 / netDriverbaseinfoDAOImpl.findAllCount(areaCode)), "");
    }

    /**
     * 获取一段时间内订单点（热力图）
     *
     * @param areaCode
     * @param stTime
     * @param endTime
     * @return
     */
    @Override
    public List<ThermalPoint> getOrderPoint(String areaCode, Date stTime, Date endTime) {
        return netStatisticsDAOImpl.getOrderThermalPoint(areaCode, stTime, endTime);
    }

    /**
     * 获取乘客位置（热力图)
     *
     * @param areaCode
     * @param stTime
     * @param endTime
     * @return
     */
    @Override
    public List<ThermalPoint> getPsgPotin(String areaCode, Date stTime, Date endTime) {
        return netStatisticsDAOImpl.getPassengerThermalPoint(areaCode, stTime, endTime);
    }

    /**
     * 获取司机位置点（热力图）
     *
     * @param areaCode
     * @param stTime
     * @param endTime
     * @return
     */
    @Override
    public List<ThermalPoint> getDriverPotin(String areaCode, Date stTime, Date endTime) {
        return netStatisticsDAOImpl.getDriverThermalPoint(areaCode, stTime, endTime);
    }


    @Override
    public int getOnlineNum(String areaCode) {
        return netRedisDAOImpl.getOnlineDevice(areaCode);
    }


}
