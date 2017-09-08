package com.netcar.daoImpl;

import com.netcar.dao.NetAreaDAO;
import com.netcar.entity.NetArea;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mander on 2017/5/3.
 */
@Repository
public class NetAreaDAOImpl implements NetAreaDAO {

    private static Logger logger=Logger.getLogger(NetAreaDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }



    @Override
    public List<NetArea> findChildrenBycode(String code) {
        try {
            Query query= getSession().createQuery("from NetArea where fathercode=:code and state=1");
            query.setString("code",code);
            return query.list();
        }catch (Exception e){
            logger.debug(e);
            return null;
        }

    }



}
