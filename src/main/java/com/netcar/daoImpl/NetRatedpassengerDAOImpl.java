package com.netcar.daoImpl;

import com.netcar.dao.NetRatedpassengerDAO;
import com.netcar.dataModle.ServiceScopeLevel;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mander on 2017/6/13.
 */
@Repository
public class NetRatedpassengerDAOImpl implements NetRatedpassengerDAO {

    private Logger logger=Logger.getLogger(NetRatedpassengerDAOImpl.class);


    @Autowired
    private SessionFactory sessionFactory;


    private Session getSession(){
        return  sessionFactory.openSession();
    }

    @Override
    public List<ServiceScopeLevel> getServiceScopegroupByCompanyidc(String companyidc) {
        List<ServiceScopeLevel> serviceScopeLevels=new ArrayList<>();
        try {
            Query query=getSession().createQuery("select servicescore ,count(servicescore)  from NetRatedpassenger  where companyidc=:companyidc GROUP BY servicescore order by servicescore desc");
            query.setString("companyidc",companyidc);
            List list =  query.list();
            for (Object object :list) {
                Object[] obj=(Object[]) object;
                ServiceScopeLevel serviceScopeLevel=new ServiceScopeLevel();
                serviceScopeLevel.setServiceScopeLevle(Integer.parseInt(obj[0].toString()));
                serviceScopeLevel.setServiceScopeCount(Integer.parseInt(obj[1].toString()));
                serviceScopeLevels.add(serviceScopeLevel);
            }
            return serviceScopeLevels;
        }catch (Exception e){
            logger.debug(e);
            return  null;
        }
    }





}
