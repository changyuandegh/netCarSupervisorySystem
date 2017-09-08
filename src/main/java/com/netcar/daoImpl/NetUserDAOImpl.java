package com.netcar.daoImpl;

import com.netcar.dao.NetUserDAO;
import com.netcar.entity.NetUser;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mander on 2017/4/25.
 */
@Repository
public class NetUserDAOImpl implements NetUserDAO {

    private Logger logger=Logger.getLogger(NetUserDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }

    @Override
    public NetUser findByNamePass(String name, String pass) {
        NetUser user=null;
        try {
            Query query= getSession().createQuery("from NetUser where name=:name and password=:pass");
            query.setString("name",name);
            query.setString("pass",pass);
            List<NetUser> list= query.list();
           user=list!=null&&list.size()!=0?list.get(0):null;
        }catch (Exception e){
            logger.debug(e);
        }
        return user;
    }

    @Override
    public List<NetUser> findAll(int limit, int offset) {
        try {
            Query query=getSession().createQuery("from NetUser");
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        }catch (Exception e){
            return null;
        }
    }
}
