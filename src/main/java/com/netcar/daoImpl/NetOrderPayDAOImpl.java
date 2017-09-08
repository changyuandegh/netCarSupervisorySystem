package com.netcar.daoImpl;

import com.netcar.dao.NetOrderPayDAO;
import com.netcar.entity.NetOrderpay;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mander on 2017/6/15.
 */
@Repository
public class NetOrderPayDAOImpl implements NetOrderPayDAO {

    private Logger logger=Logger.getLogger(NetOrderPayDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }



    @Override
    public NetOrderpay findbyorderid(String orderid) {
        try {
            Query query=getSession().createQuery("from NetOrderpay where orderid=:orderid");
            query.setString("orderid",orderid);
            List<NetOrderpay> list= query.list();
            return list!=null&&list.size()!=0?list.get(0):null;
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }
}
