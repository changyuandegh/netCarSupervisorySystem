package com.netcar.daoImpl;

import com.netcar.dao.NetAlarmDAO;
import com.netcar.dataModle.*;
import com.netcar.entity.*;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wby on 2017/5/10.
 * 报警数据库操作实现
 */
@Repository
public class NetAlarmDAOImpl implements NetAlarmDAO {

    private Logger logger = Logger.getLogger(NetAlarmDAOImpl.class);


    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    /**
     * 获取一段时间内报警统计
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @return
     */
    @Override
    public List<SOSStatisticsData> getSOSStatistics(String addressCode, String stTime, String endTime) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("SELECT sos.companyid,sos.address,sos.total,sos.category,com.companyname,area.name from net_sosstatistics sos  inner join net_companybaseinfo com on com.companyid = sos.companyid  inner join net_area area on area.code=sos.address  where statisticsdate between :sttime and :endtime");
            } else {
                query = getSession().createSQLQuery("SELECT sos.companyid,sos.address,sos.total,sos.category,com.companyname,area.name from net_sosstatistics sos inner join net_companybaseinfo com on com.companyid = sos.companyid inner join net_area area on area.code=sos.address  where sos.address in (select code from net_area where code=:address or fathercode=:address) and statisticsdate between :sttime and :endtime");
                query.setString("address", addressCode);
            }
            query.setString("sttime", stTime);
            query.setString("endtime", endTime);
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                return bindName(ls);
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }

    /**
     * 根据类型获取一段时间内历史报警
     *
     * @param addressCode
     * @param stTime
     * @param endTime
     * @param alarmType
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @Override
    public List getAlarmAllByType(String addressCode, Date stTime, Date endTime, int alarmType, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from " + getClassName(alarmType) + " where alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("from " + getClassName(alarmType) + " where address in (select code from net_area where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getAlarmAllByTypeCount(String addressCode, Date stTime, Date endTime, int alarmType) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from " + getClassName(alarmType) + " where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from " + getClassName(alarmType) + " where address in (select code from net_area where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }


    /**
     * 获取停运报警信息
     *
     * @param addressCode
     * @param stTime
     * @param endTime
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @Override
    public List<OutageAlarmData> getNetOutagealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select new com.netcar.dataModle.OutageAlarmData(ala.id,ala.companyid,com.companyname,ala.address,area.name,ala.outagenum,ala.vehicletotal,ala.alarmtime,ala.state,ala.result,ala.processtime) from NetOutagealarm ala,NetCompanybaseinfo com,NetArea area where ala.address = area.code and ala.companyid=com.companyid and ala.alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("select new com.netcar.dataModle.OutageAlarmData(ala.id,ala.companyid,com.companyname,ala.address,area.name,ala.outagenum,ala.vehicletotal,ala.alarmtime,ala.state,ala.result,ala.processtime) from NetOutagealarm ala,NetCompanybaseinfo com,NetArea area where ala.address in (select area.code from area where area.code =:address or area.fathercode =:address) and ala.address = area.code and ala.companyid=com.companyid and ala.alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getNetOutagealarmCount(String addressCode, Date stTime, Date endTime) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetOutagealarm where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from NetOutagealarm where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }

    @Override
    public List<DriverSOSData> getNetDriversosalarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select new com.netcar.dataModle.DriverSOSData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.address,area.name,sos.position,sos.longitude,sos.latitude,sos.encrypt,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetDriversos sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv,NetArea area where sos.address = area.code and sos.companyid=cpn.companyid and sos.driverid = dv.driverid and sos.alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("select new com.netcar.dataModle.DriverSOSData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.address,area.name,sos.position,sos.longitude,sos.latitude,sos.encrypt,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetDriversos sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv,NetArea area where sos.address in (select area.code from area where area.code =:address or area.fathercode =:address) and sos.address = area.code and sos.companyid=cpn.companyid and sos.driverid = dv.driverid and sos.alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            List<DriverSOSData> ls=query.list();
            System.out.println(ls.get(0).getAlarmTime().getTime());

            System.out.println(ls.get(0).getProcessTime().getTime());

            return ls;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getNetDriversosCount(String addressCode, Date stTime, Date endTime) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetDriversos where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from NetDriversos where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }

    /**
     * 获取一段时间内重点区域报警
     *
     * @param addressCode
     * @param stTime
     * @param endTime
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @Override
    public List<KeyAreaData> getNetKeyareaalarmalarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select new com.netcar.dataModle.KeyAreaData(sos.id,sos.areaid,ele.name,sos.address,area.name,sos.vehiclenum,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetKeyareaalarm sos,NetElectricfence ele,NetArea area where sos.address = area.code and sos.areaid=ele.id and sos.alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("select new com.netcar.dataModle.KeyAreaData(sos.id,sos.areaid,ele.name,sos.address,area.name,sos.vehiclenum,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetKeyareaalarm sos,NetElectricfence ele,NetArea area where sos.address in (select area.code from area where area.code =:address or area.fathercode =:address) and sos.address = area.code and sos.areaid=ele.id and sos.alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getNetKeyareaalarmCount(String addressCode, Date stTime, Date endTime) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetKeyareaalarm where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from NetKeyareaalarm where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }

    /**
     * 获取围栏报警信息
     *
     * @param addressCode
     * @param stTime
     * @param endTime
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @Override
    public List<ElectricfenceAlarmData> getNetElectricfencealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select new com.netcar.dataModle.ElectricfenceAlarmData(sos.id,sos.fenceid,ele.name,sos.address,area.name,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.longitude,sos.latitude,sos.encrypt,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetElectricfencealarm sos,NetElectricfence ele,NetCompanybaseinfo cpn,NetDriverbaseinfo dv,NetArea area where sos.address = area.code and sos.fenceid=ele.id and sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("select new com.netcar.dataModle.ElectricfenceAlarmData(sos.id,sos.fenceid,ele.name,sos.address,area.name,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.longitude,sos.latitude,sos.encrypt,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetElectricfencealarm sos,NetElectricfence ele,NetCompanybaseinfo cpn,NetDriverbaseinfo dv,NetArea area where sos.address in (select area.code from area where area.code =:address or area.fathercode =:address) and sos.address = area.code and sos.fenceid=ele.id and sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            System.out.println("err -- >" + e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getNetElectricfencealarmCount(String addressCode, Date stTime, Date endTime) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetElectricfencealarm where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from NetElectricfencealarm where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }

    /**
     * 获取一段时间的跨区经营报警
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    @Override
    public List<OperatealarmData> getNetOperatealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select new com.netcar.dataModle.OperatealarmData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.orderid,sos.depposition,sos.deplng,sos.deplat,sos.destposition,sos.destlng,sos.destlat,sos.address,sos.realaddress,sos.longitude,sos.latitude,sos.encrypt,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetOperatealarm sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv where sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("select new com.netcar.dataModle.OperatealarmData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.orderid,sos.depposition,sos.deplng,sos.deplat,sos.destposition,sos.destlng,sos.destlat,sos.address,sos.realaddress,sos.longitude,sos.latitude,sos.encrypt,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetOperatealarm sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv where sos.realaddress in (select code from NetArea where code =:address or fathercode =:address) and sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            System.out.println("err -- >" + e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getNetOperatealarmCount(String addressCode, Date stTime, Date endTime) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetOperatealarm where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from NetOperatealarm where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }

    /**
     * 获取一段时间聚集报警
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    @Override
    public List<NetAggregationalarm> getAggregationalarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetAggregationalarm where alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("from NetAggregationalarm where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            System.out.println("err -- >" + e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getAggregationalarmCount(String addressCode, Date stTime, Date endTime) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetAggregationalarm where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from NetAggregationalarm where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }

    /**
     * 获取一段时间的出城报警
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    @Override
    public List<OuttownalarmData> getNetOuttownalarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select new com.netcar.dataModle.OuttownalarmData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.address,sos.position,sos.longitude,sos.latitude,sos.encrypt,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetOuttownalarm sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv where sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("select new com.netcar.dataModle.OuttownalarmData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.address,sos.position,sos.longitude,sos.latitude,sos.encrypt,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetOuttownalarm sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv where sos.address in (select code from NetArea where code =:address or fathercode =:address) and sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            System.out.println("err -- >" + e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getNetOuttownalarmCount(String addressCode, Date stTime, Date endTime) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetOuttownalarm where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from NetOuttownalarm where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }

    /**
     * 获取一段时间内的分离报警
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    @Override
    public List<SeparatealarmData> getNetSeparatealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select new com.netcar.dataModle.SeparatealarmData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.address,sos.driverposition,sos.driverlng,sos.driverlat,sos.vehicleposition,sos.vehiclelng,sos.vehiclelat,sos.encrypt,sos.orderid,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetSeparatealarm sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv where sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("select new com.netcar.dataModle.SeparatealarmData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.address,sos.driverposition,sos.driverlng,sos.driverlat,sos.vehicleposition,sos.vehiclelng,sos.vehiclelat,sos.encrypt,sos.orderid,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetSeparatealarm sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv where sos.address in (select code from NetArea where code =:address or fathercode =:address) and sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            System.out.println("err -- >" + e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getNetSeparatealarmCount(String addressCode, Date stTime, Date endTime) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetSeparatealarm where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from NetSeparatealarm where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }

    /**
     * 获取一段时间内的计价异常
     *
     * @param addressCode 区划
     * @param stTime      开始时间
     * @param endTime     结束时间
     * @param limit       查询总数
     * @param offset      开始项
     * @param sort        排序列
     * @return
     */
    @Override
    public List<PricealarmData> getNetPricealarm(String addressCode, Date stTime, Date endTime, int limit, int offset, String sort) {
        if (addressCode == null || addressCode.length() != 6) return null;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select new com.netcar.dataModle.PricealarmData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.address,sos.orderid,sos.ordermileage,sos.ordertime,sos.ordermoney,sos.avespeed,sos.type,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetPricealarm sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv where sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
            } else {
                query = getSession().createQuery("select new com.netcar.dataModle.PricealarmData(sos.id,sos.companyid,cpn.companyname,sos.driverid,dv.drivername,sos.vehicleno,sos.address,sos.orderid,sos.ordermileage,sos.ordertime,sos.ordermoney,sos.avespeed,sos.type,sos.alarmtime,sos.state,sos.result,sos.processtime) from NetPricealarm sos,NetCompanybaseinfo cpn,NetDriverbaseinfo dv where sos.address in (select code from NetArea where code =:address or fathercode =:address) and sos.companyid = cpn.companyid and sos.driverid = dv.driverid  and sos.alarmtime between :stTime and :endTime order by :sort");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            System.out.println("err -- >" + e.getMessage());
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getNetPricealarmCount(String addressCode, Date stTime, Date endTime) {
        if (addressCode == null || addressCode.length() != 6) return 0;
        Query query;
        try {
            if (addressCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetPricealarm where alarmtime between :stTime and :endTime");
            } else {
                query = getSession().createQuery("select count(*) from NetPricealarm where address in (select code from NetArea where code =:address or fathercode =:address) and alarmtime between :stTime and :endTime");
                query.setString("address", addressCode);
            }
            query.setDate("stTime", stTime);
            query.setDate("endTime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }


    /**
     * 获取报警类型
     *
     * @return
     */
    @Override
    public List<NetAlarmtype> getAlarmType() {
        try {
            Query query = getSession().createQuery("from NetAlarmtype");
            return query.list();
        } catch (Exception e) {
            logger.debug(e);
        }

        return null;
    }

    /**
     * 根据类型id获取报警类型
     *
     * @param alarmType
     * @return
     */
    @Override
    public NetAlarmtype getAlarmType(int alarmType) {
        try {
            Query query = getSession().createQuery("from NetAlarmtype where id =:type");
            query.setInteger("type", alarmType);
            return (NetAlarmtype) query.list().get(0);
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }

    /**
     * 获取各类型报警的位置
     *
     * @param areaCode  区划
     * @param tablename 报警表名
     * @param stTime    开始时间
     * @param endTime
     * @return
     */
    @Override
    public List<ThermalPoint> getAlarmPoint(String areaCode, String tablename, String stTime, String endTime) {
        if (areaCode == null || areaCode.length() != 6) return null;
        Query query;
        try {
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select longitude,latitude from " + tablename + " where alarmtime between :sttime and :endtime");
            } else {
                query = getSession().createSQLQuery("select longitude,latitude from " + tablename + " where address in (select code from net_area where code =:address or fathercode=:address) and  alarmtime between :sttime and :endtime ");
                query.setString("address", areaCode);
            }
            query.setString("sttime", stTime);
            query.setString("endtime", endTime);
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                return bindLatLng(ls);
            }
        } catch (Exception e) {
            System.out.println("==>");
            logger.debug(e);
        }
        return null;
    }

    /**
     * 修改用户的报警订阅
     *
     * @param userid
     * @param alarmTypes
     * @return
     */
    @Override
    public boolean updateAlarmSubscription(int userid, List<Integer> alarmTypes) {
        Session session = getSession();
        try {
            Query query = session.createQuery("delete NetAlarmsubscription where userid =:userid");
            query.setInteger("userid", userid);
            query.executeUpdate();
            for (int i = 0; i < alarmTypes.size(); i++) {
                NetAlarmsubscription netAlarmsubscription = new NetAlarmsubscription();
                netAlarmsubscription.setUserid(userid);
                netAlarmsubscription.setAlarmid(alarmTypes.get(i));
                session.save(netAlarmsubscription);
            }
            return true;
        } catch (Exception e) {
            System.out.println("err ---- >" + e.getMessage());
            logger.debug(e);
        }
        return false;
    }

    /**
     * 获取用户订阅的报警
     *
     * @param userid 用户id
     * @return
     */
    @Override
    public List<NetAlarmsubscription> getAlarmSubscription(int userid) {
        Query query = getSession().createQuery("from NetAlarmsubscription where userid=:userid");
        query.setInteger("userid",userid);
        return query.list();
    }

    /**
     * 获取订阅的报警类型
     *
     * @param userid
     * @return
     */
    @Override
    public List<NetAlarmtype> getAlarmTypeBySubscription(int userid) {
        try {
            Query query = getSession().createQuery("from NetAlarmtype where id in (select alarmid from NetAlarmsubscription where userid =:userid)");
            query.setInteger("userid", userid);
            return query.list();
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }

    /**
     * 获取当日报警
     * @param areaCode
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @Override
    public List<NetTodayalarm> getTodayAlarmAll(String areaCode,int limit, int offset, String sort) {
        if (areaCode == null || areaCode.length() != 6) return null;
        Query query;
        try {
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetTodayalarm order by :sort");
            } else {
                query = getSession().createQuery("from NetTodayalarm where address in (select code from net_area where code =:address or fathercode=:address) order by :sort");
                query.setString("address", areaCode);
            }
            query.setString("sort",sort);
            query.setMaxResults(limit);
            query.setFirstResult(offset);
            return query.list();
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }

    @Override
    public int getTodayAlarmAllCount(String areaCode) {
        if (areaCode == null || areaCode.length() != 6) return 0;
        Query query;
        try {
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetTodayalarm");
            } else {
                query = getSession().createQuery("select count(*) from NetTodayalarm where address in (select code from NetArea where code =:address or fathercode =:address)");
                query.setString("address", areaCode);
            }
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }



    @Override
    public int getTodayAlarmAllCount(String areaCode, String alarmType) {
        if (areaCode == null || areaCode.length() != 6) return 0;
        Query query;
        try {
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(id) from NetTodayalarm where alarmtype=:alarmtype");
                query.setString("alarmtype",alarmType);
            } else {
                query = getSession().createQuery("select count(id) from NetTodayalarm where address in (select code from NetArea where code =:address or fathercode =:address)");
                query.setString("address", areaCode);
                query.setString("alarmtype",alarmType);
            }
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.debug(e);
        }
        return 0;
    }

    @Override
    public List<NetTodayalarm> getTodayAlarmAll(String areaCode, String alarmType, int limit, int offset, String sort) {
        if (areaCode == null || areaCode.length() != 6) return null;
        Query query;
        try {
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetTodayalarm where alarmtype=:alarmtype order by :sort");
                query.setString("alarmtype",alarmType);
            } else {
                query = getSession().createQuery("from NetTodayalarm where alarmtype=:alarmtype and address in (select code from net_area where code =:address or fathercode=:address) order by :sort");
                query.setString("address", areaCode);
                query.setString("alarmtype",alarmType);
            }
            query.setString("sort",sort);
            query.setMaxResults(limit);
            query.setFirstResult(offset);
            List<NetTodayalarm> ls= query.list();
            return ls;
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }






    private List<SOSStatisticsData> bindName(List list) {
        List<SOSStatisticsData> rtlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            SOSStatisticsData data = new SOSStatisticsData();
            Object[] obj = (Object[]) list.get(i);
            data.setCompanyid(Integer.valueOf(obj[0].toString()));
            data.setAreaCode(Integer.valueOf(obj[1].toString()));
            data.setTotal(Integer.valueOf(obj[2].toString()));
            data.setCategory(obj[3].toString());
            data.setCompanyName(obj[4].toString());
            data.setArea(obj[5].toString());
            rtlist.add(data);
        }
        return rtlist;
    }

    private List<ThermalPoint> bindLatLng(List list) {
        List<ThermalPoint> llList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Object[] objs = (Object[]) list.get(i);
            llList.add(new ThermalPoint(objs[1].toString(), objs[0].toString(), 1));
        }
        return llList;
    }

    private String getClassName(int alarmType) {
        switch (alarmType) {
            case 1:
                return "NetDriversos";
            case 2:
                return "NetOutagealarm";
            case 3:
                return "NetAggregationalarm";
            case 4:
                return "NetKeyareaalarm";
            case 5:
                return "NetElectricfencealarm";
            case 6:
                return "NetOperatealarm";
            case 7:
                return "NetOuttownalarm";
            case 8:
                return "NetSeparatealarm";
            case 9:
                return "";
            case 10:
                return "NetPricealarm";
            default:
                return "";
        }
    }
}

