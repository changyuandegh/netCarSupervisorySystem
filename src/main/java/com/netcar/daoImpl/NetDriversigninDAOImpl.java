package com.netcar.daoImpl;

import com.netcar.dao.NetDriversigninDAO;
import com.netcar.entity.NetDriversignin;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
@Repository
public class NetDriversigninDAOImpl implements NetDriversigninDAO {

    private Logger logger=Logger.getLogger(NetCarbaseinfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }

    @Override
    public List<NetDriversignin> findByCarTime(String vehicleno, String starttime, String endtime) {
        try {
            Query query = getSession().createQuery("from NetDriversignin where vehicleno=:vehicleno and "
                    +"("+"(ontime>:starttime and outtime<:endtime)"
                    + " or (ontime<:starttime and outtime>:endtime)"
                    + " or (ontime<:starttime and outtime>:starttime and outtime<:endtime)"
                    + " or (ontime>:starttime and ontime<:endtime and outtime>:endtime)"
                    +")");
            query.setString("vehicleno", vehicleno);
            query.setString("starttime", starttime);
            query.setString("endtime", endtime);
            return query.list();
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }
}
