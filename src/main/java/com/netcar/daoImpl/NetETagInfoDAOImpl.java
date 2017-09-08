package com.netcar.daoImpl;

import com.netcar.dao.NetETagInfoDAO;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.ShowETag;
import com.netcar.entity.NetEtag;
import com.netcar.service.NetETagInfoService;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Wby on 2017/5/4.
 * 电子标签数据库操作实现
 */
@Repository
public class NetETagInfoDAOImpl implements NetETagInfoDAO {

    private Logger logger = Logger.getLogger(NetETagInfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }


    @Override
    public List<ShowETag> findAll(String address, String sort, int limit, int offset) {
        try {
            if (address == null || address.length() < 6)
                return null;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select car.vehicleno,tag.etagid,tag.brand,tag.model,tag.imei,tag.installdate,tag.createtime,tag.updatetime from net_carbaseinfo car inner join net_etag tag on car.etagid = tag.etagid order by :sort");
            } else {
                query = getSession().createSQLQuery("select car.vehicleno,tag.etagid,tag.brand,tag.model,tag.imei,tag.installdate,tag.createtime,tag.updatetime from net_carbaseinfo car inner join net_etag tag on car.etagid = tag.etagid where car.address in (select area.code from net_area area where area.code=:address or area.fathercode=:address) order by :sort");
                query.setString("address", address);
            }
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                return bindData(ls);
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return new ArrayList<>();
    }

    public int findAllCount(String address) {
        try {
            if (address == null || address.length() < 6)
                return 0;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select count(car.carid) from net_carbaseinfo car inner join net_etag tag on car.etagid = tag.etagid ");
            } else {
                query = getSession().createSQLQuery("select count(car.carid) from net_carbaseinfo car inner join net_etag tag on car.etagid = tag.etagid where car.address in (select area.code from net_area area where area.code=:address or area.fathercode=:address)");
                query.setString("address", address);
            }
            return Integer.parseInt(query.list().get(0).toString());
        } catch (Exception e) {
            logger.debug(e);
        }
        return 0;
    }

    @Override
    public List<ShowETag> findByCarInfo(String address, String param, String value, String sort, int limit, int offset) {
        try {
            if (address == null || address.length() < 6)
                return null;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select car.vehicleno,tag.etagid,tag.brand,tag.model,tag.imei,tag.installdate,tag.createtime,tag.updatetime from net_carbaseinfo  car inner join net_etag  tag on car.etagid = tag.etagid  where car." + param + " LIKE :val order by :sort");
            } else {
                query = getSession().createSQLQuery("select car.vehicleno,tag.etagid,tag.brand,tag.model,tag.imei,tag.installdate,tag.createtime,tag.updatetime from net_carbaseinfo car inner join net_etag tag on car.etagid = tag.etagid where car.address in (select area.code from net_area area where area.code=:address or area.fathercode=:address) and car." + param + " LIKE :val order by :sort");
                query.setString("address", address);
            }
            query.setString("val", "%" + value + "%");
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                return bindData(ls);
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return new ArrayList<>();
    }


    public int findByCarInfoCount(String address, String param, String value) {
        try {
            if (address == null || address.length() < 6)
                return 0;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select count(car.carid) from net_carbaseinfo car inner join net_etag tag on car.deviceid = tag.etagid  where car." + param + " LIKE :val order by :sort");
            } else {
                query = getSession().createSQLQuery("select count(car.carid) from net_carbaseinfo car inner join net_etag tag on car.deviceid = tag.etagid where car.address in (select area.code from net_area area where area.code=:address or area.fathercode=:address) and car." + param + " LIKE :val order by :sort");
                query.setString("address", address);
            }
            query.setString("val", "%" + value + "%");
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
        }
        return 0;
    }


    @Override
    public boolean add(NetEtag info, String num) {
        Session session = getSession();
      //  Transaction transaction = session.beginTransaction();
        try {
            Query query = getSession().createQuery("update NetCarbaseinfo set etagid=:id where vehicleno = :num");
            query.setString("id", info.getEtagid());
            query.setString("num", num);
            int line = query.executeUpdate();
            if (line == 0)
                return false;
            session.save(info);
        //    transaction.commit();
            return true;
        } catch (Exception e) {
            logger.debug(e);
        //    System.out.println("err -- > " + e.getMessage());
       //     transaction.rollback();
        } finally {
        //    session.close();
        }
        return false;
    }

    @Override
    public boolean edit(NetEtag netEtag) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(netEtag);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(String eTagId) {
        NetEtag etag = new NetEtag();
        etag.setEtagid(eTagId);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = getSession().createQuery("update NetCarbaseinfo set etagid=NULL where etagid = :id");
            query.setString("id", eTagId);
            int line = query.executeUpdate();
            if (line == 0)
                return false;
            session.delete(etag);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.debug(e);
        } finally {
            session.close();
        }

        return false;
    }

    private List<ShowETag> bindData(List list) {
        List<ShowETag> showETags = new ArrayList<>();
        SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < list.size(); i++) {
            ShowETag eTagInfo = new ShowETag();
            Object[] obj = (Object[]) list.get(i);
            eTagInfo.setVechileno(obj[0].toString());
            eTagInfo.setEtagid(obj[1].toString());
            eTagInfo.setBrand(obj[2].toString());
            eTagInfo.setModel(obj[3].toString());
            eTagInfo.setImei(obj[4].toString());
            try {
                eTagInfo.setInstalldate(formatdate.format(formatdate.parse(obj[5].toString())));
                eTagInfo.setCreatetime(formatTime.format(formatTime.parse(obj[6].toString())));
                eTagInfo.setUpdatetime(formatTime.format(formatTime.parse(obj[7].toString())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            showETags.add(eTagInfo);
        }
        return showETags;
    }

}
