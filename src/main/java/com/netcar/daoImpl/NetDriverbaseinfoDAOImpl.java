package com.netcar.daoImpl;

import com.netcar.dao.NetDriverbaseinfoDAO;
import com.netcar.entity.NetDriverbaseinfo;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Work on 2017/5/3.
 */
@Repository
public class NetDriverbaseinfoDAOImpl implements NetDriverbaseinfoDAO {

    private Logger logger = Logger.getLogger(NetUserDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }


    @Override
    public List<NetDriverbaseinfo> findAll(String address, String sort, int limit, int offset) {
        try {
            if (address == null || address.length() < 6)
                return null;
            Query query=null;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetDriverbaseinfo order by :sort");
            } else {
                query = getSession().createQuery("from NetDriverbaseinfo where address in (select code from NetArea where code=:address or fathercode=:address) order by :sort");
                query.setString("address", address);
            }
            query.setString("sort", sort);
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
                query = getSession().createQuery("select count(*) from NetDriverbaseinfo");
            } else {
                query = getSession().createQuery("select count(*) from NetDriverbaseinfo where address in (select code from NetArea where code=:address or fathercode=:address)");
                query.setString("address", address);
            }
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public List<NetDriverbaseinfo> findAllByParm(String address, String parm, String value, String sort, int limit, int offset) {
        try {
            if (address == null || address.length() < 6)
                return null;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetDriverbaseinfo where " + parm + " LIKE :val order by :sort");
            } else {
                query = getSession().createQuery("from NetDriverbaseinfo where address in (select code from NetArea where code=:address or fathercode=:address) and " + parm + " like :val order by :sort");
                query.setString("address", address);
            }
            query.setString("val", "%" + value + "%");
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        } catch (Exception e) {
            logger.debug(e);
            return null;
        }
    }

    @Override
    public int findAllByParmCount(String address, String parm, String value) {
        try {
            if (address == null || address.length() < 6)
                return 0;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetDriverbaseinfo where " + parm + " LIKE :val");
            } else {
                query = getSession().createQuery("select count(*) from NetDriverbaseinfo where address in (select code from NetArea where code=:address or fathercode=:address) and " + parm + " LIKE :val");
                query.setString("address", address);
            }
            query.setString("val", "%" + value + "%");
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
            return 0;
        }
    }

    /**
     * 根据唯一性的参数类型查询:比如身份号码,手机号等
     * @param parm
     * @param value
     * @return
     */
    @Override
    public NetDriverbaseinfo findBydriverByParm(String parm, String value) {
        try {
            String hql="from NetDriverbaseinfo  where "+parm+"="+value;
            Query query = getSession().createQuery(hql);
            List<NetDriverbaseinfo> ls= query.list();
            return ls.get(0)!=null?ls.get(0):null;
        }catch ( Exception e){
            logger.debug(e);
         return null;
        }
    }


    @Override
    public NetDriverbaseinfo findDriverBaseinfoBylicenseid(String licenseid) {
        try {
            Query query=getSession().createQuery("from NetDriverbaseinfo where licenseid=:licenseid");
            query.setString("licenseid",licenseid);
            List<NetDriverbaseinfo> list= query.list();
            return list!=null&&list.size()!=0?list.get(0):null;
        }catch (Exception e){
            e.printStackTrace();
            logger.debug(e);
            return null;
        }
    }

    @Override
    public List<NetDriverbaseinfo> findDriverDarail(String name) {
        Query query=null;
        query=getSession().createQuery("");
        return null;
    }

    /**
     * 获取驾驶员扫描件和司机照片
     * @param companyidc
     * @return
     */
    @Override
    public List<HashMap<String, Object>> findlicenseidAllPic(String companyidc) {
        String sql="select d.licenseid,d.licensephotoid,d.photoid from net_driverbaseinfo d  INNER join net_companybaseinfo  c on c.companyid=d.companyid   where c.companyidc=:companyidc";
        List<HashMap<String, Object>> list=new ArrayList<>();
        try {
            Query query=getSession().createSQLQuery(sql);
            query.setString("companyidc",companyidc);
            list= query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

}
