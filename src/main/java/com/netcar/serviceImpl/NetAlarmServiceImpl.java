package com.netcar.serviceImpl;

import com.netcar.dao.NetAlarmDAO;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.ProportionData;
import com.netcar.dataModle.SOSStatisticsData;
import com.netcar.dataModle.ThermalPoint;
import com.netcar.entity.*;
import com.netcar.service.NetAlarmService;
import org.apache.http.util.TextUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Work on 2017/5/10.
 */
@Service
public class NetAlarmServiceImpl implements NetAlarmService {

    private Logger logger = Logger.getLogger(NetAlarmServiceImpl.class);


    String[] alarmColor_company = new String[]{
            "#EBB43E", "#EA5F30", "#CCA968", "#56D1CA", "#C9413E", "#404040", "#54D287", "#AA55DC", "#595CE8", "#D7467B"
    };
    String[] alarmColor_type = new String[]{
            "#E08E35", "#DF8336", "#DF8336", "#DC6C39", "#DC6C39", "#DB603C", "#D9543D", "#DB493E", "#D63D3F", "#D53241", "#D32643"
    };


    @Autowired
    NetAlarmDAO netAlarmDAOImpl;

    /**
     * 各报警类型占比
     *
     * @param areacode  地区编码
     * @param cycleTime 可能值: 1(月),2(周),3(日)
     * @return
     */
    @Override
    public List<ProportionData> getProportionAlarmType(String areacode, int cycleTime) {
        String[] times = getTimes(cycleTime);
        List<SOSStatisticsData> sosList = netAlarmDAOImpl.getSOSStatistics(areacode, times[1], times[0]);
        if (sosList == null) return null;
        List<NetAlarmtype> alarmTypes = netAlarmDAOImpl.getAlarmType();
        Map<String, Integer> alarmCount = new HashMap<>();
        Map<Integer, NetAlarmtype> alarmMap = getAlarmType(alarmTypes);
        if (alarmMap == null) return null;
        int total = 0;
        SOSStatisticsData sosData;
        if(sosList!=null&&sosList.size()!=0){
        for (int i = 0; i < sosList.size(); i++) {
            sosData = sosList.get(i);
            total += sosData.getTotal();
            String[] category = sosData.getCategory().split(";|\\:");
            for (int m = 0; m < category.length; m += 2) {
                if (alarmCount.containsKey(category[m])) {
                    alarmCount.put(category[m], alarmCount.get(category[m]) + Integer.valueOf(category[m + 1]));
                } else {
                    alarmCount.put(category[m], Integer.valueOf(category[m + 1]));
                }
            }
        }
        }
        List<ProportionData> data = new ArrayList<>();
        int count = 0;
        for (String key : alarmCount.keySet()) {
            ProportionData proportionData = new ProportionData();
            proportionData.setName(alarmMap.get(Integer.valueOf(key)).getName());
            proportionData.setValue(String.format("%.2f", alarmCount.get(key) * 100.0 / total));
            proportionData.setColor(alarmColor_type[count]);
            data.add(proportionData);
            if (count++ == alarmColor_type.length) count = 0;
        }
        return data;
    }

    /**
     * 各公司报警占比
     *
     * @param areacode  地区编码
     * @param cycleTime 可能值: 1(月),2(周),3(日)
     * @return
     */
    @Override
    public List<ProportionData> getProportionCompanyAlarm(String areacode, int cycleTime) {
        String[] times = getTimes(cycleTime);
        List<SOSStatisticsData> sosList = netAlarmDAOImpl.getSOSStatistics(areacode, times[1], times[0]);
        if (sosList == null) return null;
        Map<String, Integer> companyCount = new HashMap<>();
        int total = 0;
        SOSStatisticsData sosData;
        if(sosList!=null&& sosList.size()!=0){
            for (int i = 0; i < sosList.size(); i++) {
                sosData = sosList.get(i);
                total += sosData.getTotal();
                if (companyCount.containsKey(sosData.getCompanyName())) {
                    companyCount.put(sosData.getCompanyName(), companyCount.get(sosData.getCompanyName()) + sosData.getTotal());
                } else {
                    companyCount.put(sosData.getCompanyName(), sosData.getTotal());
                }
            }
        }
        List<ProportionData> data = new ArrayList<>();
        int count = 0;
        for (String key : companyCount.keySet()) {
            ProportionData proportionData = new ProportionData();
            proportionData.setName(key);
            proportionData.setValue(String.format("%.2f", companyCount.get(key) * 100.0 / total));
            proportionData.setColor(alarmColor_company[count]);
            data.add(proportionData);
            if (count++ == alarmColor_type.length) count = 0;
        }
        return data;
    }


    /**
     * 获取报警点
     *
     * @param areacode  地区编码
     * @param cycleTime 可能值: 1(月),2(周),3(日)
     * @return
     */
    @Override
    public List<ThermalPoint> getThermalPointAlarm(String areacode, int cycleTime) {
        try {
            List<NetAlarmtype> alarmtypes = netAlarmDAOImpl.getAlarmType();
            if (alarmtypes == null) return null;
            String[] times = getTimes(cycleTime);
            List<ThermalPoint> data = new ArrayList<>();
            for (NetAlarmtype type : alarmtypes) {
                if (!TextUtils.isEmpty(type.getTablename()) && type.getId() != 2 && type.getId() != 4 && type.getId() != 8) {
                    List<ThermalPoint> alarmPoints = netAlarmDAOImpl.getAlarmPoint(areacode, type.getTablename(), times[1], times[0]);
                    if (alarmPoints != null)
                        data.addAll(alarmPoints);

                }
            }
            return data;
        } catch (Exception e) {
            System.out.println(" 异常 -- > " + e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    /**
     * 获取各类型报警历史
     *
     * @param areacode    地区编码
     * @param alarmTypeid 报警类型id
     * @param starttme    开始时间
     * @param endtime     结束时间
     * @param sort
     * @param limit
     * @param offset
     * @return
     */
    @Override
    public BaseTable getAlarmByTypeTime(String areacode, int alarmTypeid, Date starttme, Date endtime, String sort, int limit, int offset) {
        BaseTable table = new BaseTable();
        java.sql.Date stTime = new java.sql.Date(starttme.getTime());
        java.sql.Date eTime = new java.sql.Date(endtime.getTime());
        switch (alarmTypeid) {
            case 1:
                table.setTotal(netAlarmDAOImpl.getNetDriversosCount(areacode, stTime, eTime));
                table.setRows(netAlarmDAOImpl.getNetDriversosalarm(areacode, stTime, eTime, limit, offset, sort));
                break;
            case 2:
                table.setTotal(netAlarmDAOImpl.getNetOutagealarmCount(areacode, stTime, eTime));
                table.setRows(netAlarmDAOImpl.getNetOutagealarm(areacode, stTime, eTime, limit, offset, sort));
                break;
            case 3:
                table.setTotal(netAlarmDAOImpl.getAggregationalarmCount(areacode, stTime, eTime));
                table.setRows(netAlarmDAOImpl.getAggregationalarm(areacode, stTime, eTime, limit, offset, sort));
                break;
            case 4:
                table.setTotal(netAlarmDAOImpl.getNetKeyareaalarmCount(areacode, stTime, eTime));
                table.setRows(netAlarmDAOImpl.getNetKeyareaalarmalarm(areacode, stTime, eTime, limit, offset, sort));
                break;
            case 5:
                table.setTotal(netAlarmDAOImpl.getNetElectricfencealarmCount(areacode, stTime, eTime));
                table.setRows(netAlarmDAOImpl.getNetElectricfencealarm(areacode, stTime, eTime, limit, offset, sort));
                break;
            case 6:
                table.setTotal(netAlarmDAOImpl.getNetOperatealarmCount(areacode, stTime, eTime));
                table.setRows(netAlarmDAOImpl.getNetOperatealarm(areacode, stTime, eTime, limit, offset, sort));
                break;
            case 7:
                table.setTotal(netAlarmDAOImpl.getNetOuttownalarmCount(areacode, stTime, eTime));
                table.setRows(netAlarmDAOImpl.getNetOuttownalarm(areacode, stTime, eTime, limit, offset, sort));
                break;
            case 8:
                table.setTotal(netAlarmDAOImpl.getNetSeparatealarmCount(areacode, stTime, eTime));
                table.setRows(netAlarmDAOImpl.getNetSeparatealarm(areacode, stTime, eTime, limit, offset, sort));
                break;
            case 9:
                table.setTotal(0);
                table.setRows(null);
                break;
            case 10:
                table.setTotal(netAlarmDAOImpl.getNetPricealarmCount(areacode, stTime, eTime));
                table.setRows(netAlarmDAOImpl.getNetPricealarm(areacode, stTime, eTime, limit, offset, sort));
                break;
            default:
                table.setTotal(0);
                table.setRows(null);
                break;
        }
        return table;
    }


    /**
     * 获取开始结束时间点
     *
     * @param cycleTime 1：月 2：周 3：日
     * @return
     */
    private String[] getTimes(int cycleTime) {
        String[] strs = new String[2];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        strs[0] = format.format(calendar.getTime());
        if (cycleTime == 1) {
            calendar.add(Calendar.MONTH, -1);
        } else if (cycleTime == 2) {
            calendar.add(Calendar.WEEK_OF_MONTH, -1);
        } else if (cycleTime == 3) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        strs[1] = format.format(calendar.getTime());
        System.out.println("  时间  ---> " + strs[0] + " > " + strs[1]);
        return strs;
    }

    /**
     * 获取异常类型map
     *
     * @param list 异常list
     * @return
     */
    private Map<Integer, NetAlarmtype> getAlarmType(List<NetAlarmtype> list) {
        if (list == null) return null;
        Map<Integer, NetAlarmtype> map = new HashMap<>();
        for (NetAlarmtype alarmtype : list) {
            map.put(alarmtype.getId(), alarmtype);
        }
        return map;
    }

    /**
     * 获取所有报警类型
     *
     * @return
     */
    @Override
    public List<NetAlarmtype> findAllAlarmType() {
        return netAlarmDAOImpl.getAlarmType();
    }

    /**
     * 修改订阅的报警
     *
     * @param userid     用户id
     * @param alarmTypes 报警类型id集合
     * @return
     */
    @Override
    public boolean updateAlarmSubscription(int userid, List<Integer> alarmTypes) {
        return netAlarmDAOImpl.updateAlarmSubscription(userid, alarmTypes);
    }

    /**
     * 获取订阅信息
     *
     * @param userid 用户id
     * @return
     */
    @Override
    public List<NetAlarmsubscription> getAlarmSubscription(int userid) {
        return netAlarmDAOImpl.getAlarmSubscription(userid);
    }

    /**
     * 获取订阅的报警
     *
     * @param userid 用户id
     * @return
     */
    @Override
    public List<NetAlarmtype> getAlarmTypeBySubscription(int userid) {
        return netAlarmDAOImpl.getAlarmTypeBySubscription(userid);
    }

    /**
     * 获取当日报警
     *
     * @param areaCode
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @Override
    public BaseTable getTodayAlarm(String areaCode, int limit, int offset, String sort) {
        return new BaseTable(netAlarmDAOImpl.getTodayAlarmAllCount(areaCode), netAlarmDAOImpl.getTodayAlarmAll(areaCode, limit, offset, sort));
    }


    /**
     * 获取当日报警
     * @param areaCode
     * @param alarmType
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @Override
    public BaseTable getTodayAlarm(String areaCode,String alarmType, int limit, int offset, String sort) {
        return new BaseTable(netAlarmDAOImpl.getTodayAlarmAllCount(areaCode,alarmType), netAlarmDAOImpl.getTodayAlarmAll(areaCode,alarmType,limit, offset, sort));
    }




}
