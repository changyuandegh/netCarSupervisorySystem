package com.netcar.daoImpl;

import com.netcar.dao.NetStatisticsDAO;
import com.netcar.dataModle.*;
import com.netcar.entity.NetOrderstatistics;
import com.netcar.tools.CoordinateConvert;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.spi.QueryResultsRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wbj on 2017/5/16.
 */
@Repository
public class NetStatisticsDAOImpl implements NetStatisticsDAO {
    private Logger logger = Logger.getLogger(NetCarbaseinfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }


    @Override
    public StatisticsNumData getOrderStatistics(String areaCode, Date stTime, Date endTime) {
        StatisticsNumData resData = new StatisticsNumData();
        if (areaCode == null || areaCode.length() != 6) return null;
        Query query;
        try {
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*),sum(depmileage),sum(depamount) from NetOrder where ordertime between :sttime and :endtime");
            } else {
                query = getSession().createQuery("select count(*),sum(depmileage),sum(depamount) from NetOrder where address in (select code from NetArea where code=:areacode or fathercode=:areacode) and ordertime between :sttime and :endtime");
                query.setString("areacode", areaCode);
            }
            query.setDate("sttime", stTime);
            query.setDate("endtime", endTime);
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                Object[] obj = (Object[]) ls.get(0);
                resData.setOrderNum(Integer.parseInt(obj[0].toString()));
                resData.setMileageNum(Integer.parseInt(obj[1].toString().substring(0, obj[1].toString().indexOf("."))));
                resData.setMoneyNum(Integer.parseInt(obj[2].toString().substring(0, obj[2].toString().indexOf("."))));
                return resData;
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }

    @Override
    public List<OrderStatisticsData> getCompanyOrderStatistics(String areaCode, Date stTime, Date endTime) {
        try {
            Query query;
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select a.companyid,b.companyname,sum(a.total),sum(a.completecount),sum(a.cancelcount),sum(a.immediatecount),sum(a.reservationcount),sum(a.money),sum(a.mileage),sum(a.duration),a.statisticsdate from net_orderstatistics a "
                        + "INNER JOIN net_companybaseinfo b on a.companyid=b.companyid "
                        + "where a.statisticsdate between :sttime and :endtime "
                        + "group by a.companyid order by a.statisticsdate");
            } else {
                query = getSession().createSQLQuery("select a.companyid,b.companyname,sum(a.total),sum(a.completecount),sum(a.cancelcount),sum(a.immediatecount),sum(a.reservationcount),sum(a.money),sum(a.mileage),sum(a.duration),a.statisticsdate from net_orderstatistics a "
                        + "INNER JOIN net_companybaseinfo b on a.companyid=b.companyid "
                        + "where a.address in (select code from net_area where code=:areacode or fathercode=:areacode) and a.statisticsdate between :sttime and :endtime "
                        + "group by a.companyid order by a.statisticsdate");
                query.setString("areacode", areaCode);
            }
            query.setDate("sttime", stTime);
            query.setDate("endtime", endTime);
            List ls = query.list();
            if (ls != null && ls.size() > 0) {
                return bindCompanyOrderData(0, ls);
            }
        } catch (Exception e) {
            logger.debug(e);
            return null;
        }
        return null;
    }

    @Override
    public List<OrderStatisticsData> getTimeOrderStatistics(String areaCode, Date stTime, Date endTime) {
        try {
            Query query;
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select a.companyid,b.companyname,sum(a.total),sum(a.completecount),sum(a.cancelcount),sum(a.immediatecount),sum(a.reservationcount),sum(a.money),sum(a.mileage),sum(a.duration),a.statisticsdate from net_orderstatistics a "
                        + "INNER JOIN net_companybaseinfo b on a.companyid=b.companyid "
                        + "where a.statisticsdate between :sttime and :endtime "
                        + "group by a.statisticsdate order by a.statisticsdate");
            } else {
                query = getSession().createSQLQuery("select a.companyid,b.companyname,sum(a.total),sum(a.completecount),sum(a.cancelcount),sum(a.immediatecount),sum(a.reservationcount),sum(a.money),sum(a.mileage),sum(a.duration),a.statisticsdate from net_orderstatistics a "
                        + "INNER JOIN net_companybaseinfo b on a.companyid=b.companyid "
                        + "where a.address in (select code from net_area where code=:areacode or fathercode=:areacode) and a.statisticsdate between :sttime and :endtime "
                        + "group by a.statisticsdate order by a.statisticsdate");
                query.setString("areacode", areaCode);
            }
            query.setDate("sttime", stTime);
            query.setDate("endtime", endTime);
            List ls = query.list();
            if (ls != null && ls.size() > 0) {
                return bindCompanyOrderData(1, ls);
            }
        } catch (Exception e) {
            logger.debug(e);
            return null;
        }
        return null;
    }

    /**
     *
     * @param type 类型 1:按时间统计  0：按公司统计
     * @param list
     * @return
     */
    private List<OrderStatisticsData> bindCompanyOrderData(int type, List list) {
        List<OrderStatisticsData> ls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            OrderStatisticsData item = new OrderStatisticsData("", new NetOrderstatistics());
            Object[] obj = (Object[]) list.get(i);
            item.getNetOrderstatistics().setCompanyid(Integer.parseInt(obj[0].toString()));
            if (type == 0)
                item.setNamne(obj[1].toString());
            else
                item.setNamne(obj[10].toString());
            item.getNetOrderstatistics().setTotal(Integer.parseInt(obj[2].toString()));
            item.getNetOrderstatistics().setCompletecount(Integer.parseInt(obj[3].toString()));
            item.getNetOrderstatistics().setCancelcount(Integer.parseInt(obj[4].toString()));
            item.getNetOrderstatistics().setImmediatecount(Integer.parseInt(obj[5].toString()));
            item.getNetOrderstatistics().setReservationcount(Integer.parseInt(obj[6].toString()));
            item.getNetOrderstatistics().setMoney(Double.valueOf(obj[7].toString()));
            item.getNetOrderstatistics().setMileage(Double.valueOf(obj[8].toString()));
            item.getNetOrderstatistics().setDuration(Double.valueOf(obj[9].toString()));
            item.getNetOrderstatistics().setStatisticsdate(Timestamp.valueOf(obj[10].toString()));
            ls.add(item);
        }
        return ls;
    }

    @Override
    public int getTodayAlarmNum(String areaCode) {
        try {
            Query query;
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetTodayalarm");
            } else {
                query = getSession().createQuery("select count(*) from NetTodayalarm where address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", areaCode);
            }
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public int getDriverRegisterNum(String areaCode) {
        try {
            Query query;
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetDriverbaseinfo ");
            } else {
                query = getSession().createQuery("select count(*) from NetDriverbaseinfo where address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", areaCode);
            }
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public int getPassengerRegisterNum() {
        try {
            Query query = getSession().createQuery("select count(*) from NetPassenger");
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public int getCarOnlineRate(String areaCode) {
        //查Redis
        return 0;
    }

    @Override
    public int getGetonRate(String areaCode) {
        try {
            Query query;
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetDrivergps where bizstatus=1");
            } else {
                query = getSession().createQuery("select count(*) from NetDrivergps where bizstatus=1 and driverregioncode in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", areaCode);
            }
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public int getSigninRate(String areaCode) {
        try {
            Query query;
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetDrivercar where state=0");
            } else {
                query = getSession().createQuery("select count(*) from NetDrivercar a inner join NetDriverbaseinfo b on a.driverid=b.driverid where a.state=0 and b.address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", areaCode);
            }
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public int getActiveRate(String areaCode, Date stTime, Date endTime) {
        try {
            Query query;
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetDrivergps where positiontime between :sttime and :endtime");
            } else {
                query = getSession().createQuery("select count(*) from NetDrivergps where positiontime between :sttime and :endtime and driverregioncode in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", areaCode);
            }
            query.setDate("sttime", stTime);
            query.setDate("endtime", endTime);
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public List<ThermalPoint> getOrderThermalPoint(String areaCode, Date stTime, Date endTime) {
        if (areaCode == null || areaCode.length() != 6) return null;
        Query query;
        try {
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select deplongitude,deplatitude,encrypt from NetOrder where ordertime between :sttime and :endtime");
            } else {
                query = getSession().createQuery("select deplongitude,deplatitude,encrypt from NetOrder where address in (select code from NetArea where code=:areacode or fathercode=:areacode) and ordertime between :sttime and :endtime");
                query.setString("areacode", areaCode);
            }
            query.setDate("sttime", stTime);
            query.setDate("endtime", endTime);
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                return bindThermalData(ls);
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }

    @Override
    public List<ThermalPoint> getDriverThermalPoint(String areaCode, Date stTime, Date endTime) {
        if (areaCode == null || areaCode.length() != 6) return null;
        Query query;
        try {
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select longitude,latitude,encrypt from NetDrivergps where isonline=1 and positiontime between :sttime and :endtime");
            } else {
                query = getSession().createQuery("select longitude,latitude,encrypt from NetDrivergps where isonline=1 and driverregioncode in (select code from NetArea where code=:areacode or fathercode=:areacode) and positiontime between :sttime and :endtime");
                query.setString("areacode", areaCode);
            }
            query.setDate("sttime", stTime);
            query.setDate("endtime", endTime);
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                return bindThermalData(ls);
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }

    @Override
    public List<ThermalPoint> getPassengerThermalPoint(String areaCode, Date stTime, Date endTime) {
        if (areaCode == null || areaCode.length() != 6) return null;
        Query query;
        try {
            if (areaCode.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select longitude,latitude,encrypt from NetPassengergps where positiontime between :sttime and :endtime");
            } else {
                query = getSession().createQuery("select longitude,latitude,encrypt from NetPassengergps where driverregioncode in (select code from NetArea where code=:areacode or fathercode=:areacode) and positiontime between :sttime and :endtime");
                query.setString("areacode", areaCode);
            }
            query.setDate("sttime", stTime);
            query.setDate("endtime", endTime);
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                return bindThermalData(ls);
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }

    /**
     * 经纬度转换，默认转换为百度坐标系
     *
     * @param list
     * @return
     */
    private List<ThermalPoint> bindThermalData(List list) {
        List<ThermalPoint> ls = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Object[] obj = (Object[]) list.get(i);
            ThermalPoint point = new ThermalPoint();
            point.setCount(list.size());
            double lng = Double.parseDouble(obj[0].toString());
            double lat = Double.parseDouble(obj[1].toString());
            double[] latlng = new double[2];
            int encrypt = Integer.parseInt(obj[2].toString());

            if (encrypt == 1) {//1:GCJ-02 2:WGS84 3:BD-09 4:CGCS2000
                latlng = CoordinateConvert.gcj2BD09(lat, lng);
            } else if (encrypt == 2) {
                latlng = CoordinateConvert.wgs2BD09(lat, lng);
            } else if (encrypt == 3) {
                latlng[0] = lat;
                latlng[1] = lng;
            } else if (encrypt == 4) {
                latlng = CoordinateConvert.wgs2BD09(lat, lng);
            } else {
                latlng[0] = lat;
                latlng[1] = lng;
            }
            point.setLng("" + latlng[1]);
            point.setLat("" + latlng[0]);
            ls.add(point);
        }
        return ls;
    }
}
