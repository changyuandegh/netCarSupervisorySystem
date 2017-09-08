package com.netcar.daoImpl;

import com.netcar.dao.NetCarbaseinfoDAO;
import com.netcar.entity.NetCarbaseinfo;
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
 * Created by Administrator on 2017/5/4.
 *
 */
@Repository
public class NetCarbaseinfoDAOImpl implements NetCarbaseinfoDAO{

    private Logger logger=Logger.getLogger(NetCarbaseinfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }


    @Override
    public List<NetCarbaseinfo> findAll(String address, String sort, int limit, int offset) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetCarbaseinfo order by :sort");
            } else {
                query = getSession().createQuery("from NetCarbaseinfo where address in (select code from NetArea where code=:areacode or fathercode=:areacode) order by :sort");
                query.setString("areacode", address);
            }
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }

    @Override
    public List<NetCarbaseinfo> findByParm(String address, String parm, String value, String sort, int limit, int offset) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetCarbaseinfo where "+parm+" like :value order by :sort");
            } else {
                query = getSession().createQuery("from NetCarbaseinfo where "+parm+" like :value and address in (select code from NetArea where code=:areacode or fathercode=:areacode) order by :sort");
                query.setString("areacode", address);
            }
            query.setString("value", "%"+value+"%");

            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }

    @Override
    public List<NetCarbaseinfo> findByParm(String address, String parm, String value, String sort) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetCarbaseinfo where "+parm+" like :value order by :sort");
            } else {
                query = getSession().createQuery("from NetCarbaseinfo where "+parm+" like :value and address in (select code from NetArea where code=:areacode or fathercode=:areacode) order by :sort");
                query.setString("areacode", address);
            }
            query.setString("value", "%"+value+"%");

            query.setString("sort", sort);
            return query.list();
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }

    @Override
    public int findAllCount(String address) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetCarbaseinfo");
            } else {
                query = getSession().createQuery("select count(*) from NetCarbaseinfo where address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", address);
            }

            return ((Long) query.uniqueResult()).intValue();
        }catch (Exception e){
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public int findByParmCount(String address, String parm, String value) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetCarbaseinfo where "+parm+" like :value");
            } else {
                query = getSession().createQuery("select count(*) from NetCarbaseinfo where "+parm+" like :value and address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", address);
            }
            query.setString("value", "%"+value+"%");

            return ((Long) query.uniqueResult()).intValue();
        }catch (Exception e){
            logger.debug(e);
            return 0;
        }
    }

    @Override
    public NetCarbaseinfo findByCarNum(String address, String vehicleno) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetCarbaseinfo where vehicleno=:vehicleno");
            } else {
                query = getSession().createQuery("from NetCarbaseinfo where vehicleno=:vehicleno and address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", address);
            }
            query.setString("vehicleno", vehicleno);
            List<NetCarbaseinfo> ls= query.list();
            if (ls!=null&&ls.size()>0){
                return ls.get(0);
            } else {
                return null;
            }
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }


    @Override
    public List<HashMap<String, Object>> findVehiclePhoto(String companyidc) {
        List<HashMap<String,Object>> list=new ArrayList<>();
        try {
            String sql="select vehicleno,photoId from net_carbaseinfo car  where companyIdc=:companyidc";
            Query query=getSession().createSQLQuery(sql);
            query.setString("companyidc",companyidc);
            list=query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
