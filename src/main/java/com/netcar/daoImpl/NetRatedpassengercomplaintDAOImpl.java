package com.netcar.daoImpl;

import com.netcar.dao.NetRatedpassengercomplaintDAO;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Mander on 2017/6/13.
 */
@Repository
public class NetRatedpassengercomplaintDAOImpl implements NetRatedpassengercomplaintDAO {

    private Logger logger=Logger.getLogger(NetRatedpassengercomplaintDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.openSession();
    }



    /**
     * 获取投诉处理率
     * @param companyidc
     * @return
     */
    @Override
    public Double getServiceScopegroupByCompanyidc(String companyidc) {
        double i=0;
        String sql="select concat(left((SELECT count(orderid)from net_ratedpassengercomplaint where companyidc='"+companyidc+"' and result is not null)/(SELECT count(orderid)from net_ratedpassengercomplaint where companyidc='"+companyidc+"')*100,5))";
        try {
            Query query=getSession().createSQLQuery(sql);
            i=Double.parseDouble(query.list().get(0).toString());
        }catch (Exception e){
            logger.debug(e);
        }
        return i;
    }







}
