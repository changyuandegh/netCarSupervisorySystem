package com.netcar.daoImpl;

import com.netcar.dao.NetElectricfenceDAO;
import com.netcar.entity.NetElectricfence;
import com.netcar.entity.NetUser;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.BlockingDeque;

/**
 * Created by wbj on 2017/5/11.
 */
@Repository
public class NetElectricfenceDAOImpl implements NetElectricfenceDAO {

    private Logger logger = Logger.getLogger(NetCarbaseinfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<NetElectricfence> findAll(String address, int limit, int offset) {
        try {
            if (address == null || address.length() < 6)
                return null;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetElectricfence where state=0");
            } else {
                query = getSession().createQuery("from NetElectricfence where state=0 and address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", address);
            }
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            logger.debug(e);
            return null;
        }
    }

    @Override
    public int findAllCount(String address) {
        try {
            if (address == null || address.length() < 6)
                return 0;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetElectricfence where state=0");
            } else {
                query = getSession().createQuery("select count(*) from NetElectricfence where state=0 and address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", address);
            }
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public List<NetElectricfence> findByParam(String address, String param, String value, int limit, int offset) {
        try {
            if (address == null || address.length() < 6)
                return null;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetElectricfence where " + param + " like :value and state=0");
            } else {
                query = getSession().createQuery("from NetElectricfence where " + param + " like :value and  state=0 and address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", address);
            }
            query.setString(value, "%" + value + "%");
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            logger.debug(e);
            return null;
        }
    }

    @Override
    public int findByParamCount(String address, String param, String value) {
        try {
            if (address == null || address.length() < 6)
                return 0;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetElectricfence where " + param + " like :value where state=0");
            } else {
                query = getSession().createQuery("select count(*) from NetElectricfence where " + param + " like :value and state=0 and address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", address);
            }
            query.setString(value, "%" + value + "%");
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public List<NetElectricfence> findByParms(String address, String type, String shape, String name, int limit, int offset) {
        try {
            if (address == null || address.length() < 6)
                return null;
            Query query;
            String hql = "from NetElectricfence";
            if (type != null || shape != null || name != null) {
                hql += " where ";
                if (type != null) {
                    hql += "type = :type";
                }
                if (shape != null) {
                    if (hql.contains("type")) hql += " and";
                    hql += " shape = :shape";
                }
                if (name != null) {
                    if (hql.contains("type") || hql.contains("shape")) hql += " and";
                    hql += " name like :name";
                }
            }
            if (!address.substring(2, 6).equals("0000")) {
                if (!hql.contains("where")) hql += " where";
                if (hql.contains("type") || hql.contains("name") || hql.contains("shape")) hql += " and";
                hql += " address in (select code from NetArea where code=:areacode or fathercode=:areacode)";
            }
            hql += " and state=0";
            query = getSession().createQuery(hql);
            if (!address.substring(2, 6).equals("0000")) {
                query.setString("areacode", address);
            }
            if (type != null) query.setString("type", type);
            if (shape != null) query.setString("shape", shape);
            if (name != null) query.setString("name", "%" + name + "%");
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            logger.debug(e);
            return null;
        }
    }

    @Override
    public int findByParamCount(String address, String type, String shape, String name) {
        try {
            if (address == null || address.length() < 6)
                return 0;
            Query query;
            String hql = "select count(*) from NetElectricfence";
            if (type != null || shape != null || name != null) {
                hql += " where ";
                if (type != null) {
                    hql += "type = :type";
                }
                if (shape != null) {
                    if (hql.contains("type")) hql += " and";
                    hql += " shape = :shape";
                }
                if (name != null) {
                    if (hql.contains("type") || hql.contains("shape")) hql += " and";
                    hql += " name like :name";
                }
            }
            if (!address.substring(2, 6).equals("0000")) {
                if (!hql.contains("where")) hql += " where";
                if (hql.contains("type") || hql.contains("name") || hql.contains("shape")) hql += " and";
                hql += " address in (select code from NetArea where code=:areacode or fathercode=:areacode)";
            }
            hql += " and state=0";
            query = getSession().createQuery(hql);
            if (!address.substring(2, 6).equals("0000")) {
                query.setString("areacode", address);
            }
            if (type != null) query.setString("type", type);
            if (shape != null) query.setString("shape", shape);
            if (name != null) query.setString("name", "%" + name + "%");
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public boolean add(NetElectricfence item) {
        boolean reg = true;
        try {
            getSession().save(item);
        } catch (Exception e) {
            reg = false;
        }
        return reg;
    }

    @Override
    public boolean delete(NetElectricfence item) {
        item.setState(1);//0:有效  1:无效
        return update(item);
//        Session session = getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.delete(item);
//            transaction.commit();
//            session.close();
//            return true;
//        } catch (Exception e) {
//            transaction.rollback();
//            logger.debug(e);
//        }
//        return false;
    }


    @Override
    public boolean update(NetElectricfence item) {
        try {
            StringBuffer hql=new StringBuffer("update NetElectricfence set name=:name,address=:address,type=:type,shape=:shape,points=:points,startdate=:startdate,stopdate=:stopdate,creatorid=:creatorid,createtime=:createtime,updatetime=:updatetime,state=:state where id = :id");
            if(item.getShape()==0){
                hql.replace(24,27,"set radius=:radius,");
            }
            Query query = getSession().createQuery(hql.toString());
            query.setString("id", item.getId() + "");
            query.setString("name", item.getName());
            query.setInteger("address", item.getAddress());
            query.setInteger("type", item.getType());
            query.setInteger("shape", item.getShape());
            if(item.getShape()==0){
                query.setDouble("radius", item.getRadius());
            }
            query.setString("points", item.getPoints());
            query.setDate("startdate", item.getStartdate());
            query.setDate("stopdate", item.getStopdate());
            query.setInteger("creatorid", item.getCreatorid());
            query.setTimestamp("createtime", item.getCreatetime());
            query.setTimestamp("updatetime", item.getUpdatetime());
            query.setInteger("state", item.getState());
            int line = query.executeUpdate();
            if (line == 0)
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug(e);
        }
        return true;
    }


    @Override
    public boolean deleteByfenceid(int id) {
        Boolean reg = false;
        try {
            Query query = getSession().createSQLQuery("delete from net_electricfence where id=:id");
            query.setInteger("id", id);
            int i = query.executeUpdate();
            if (i > 0) {
                reg = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug(e);
        }
        return reg;
    }



    public static void main(String[] args) {
        StringBuffer buffer=new StringBuffer("I like blue  uuuuu");
        buffer.replace(0,1,"youo");
        System.out.println(buffer.toString());
        String s="update NetElectricfence set";
        System.out.println(s.length());

    }



}


