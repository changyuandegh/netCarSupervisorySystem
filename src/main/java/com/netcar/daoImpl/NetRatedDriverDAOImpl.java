package com.netcar.daoImpl;

import com.netcar.dao.NetRatedDriverDAO;
import com.netcar.dataModle.ServiceScopeLevel;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.entity.NetRatedDriver;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mander on 2017/6/13.
 */
@Repository
public class NetRatedDriverDAOImpl implements NetRatedDriverDAO {

    private Logger logger=Logger.getLogger(NetRatedDriverDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }

    @Override
    public NetRatedDriver findParm(String parm, String value) {
        try {
            String hql="from NetRatedDriver where "+parm+"="+value;
            Query query=getSession().createQuery(hql);
            List<NetRatedDriver> netRatedDrivers= query.list();
            return netRatedDrivers!=null&&netRatedDrivers.size()!=0?netRatedDrivers.get(0):null;
        }catch ( Exception e){
            logger.debug(e);
            return null;
        }
    }

    /**
     * 单个司机信誉
     * @param licenseid
     * @return
     */
    @Override
    public List<ServiceScopeLevel> findRateDriverByLicenseid(String licenseid) {
        List<ServiceScopeLevel> serviceScopeLevels=new ArrayList<>();
        try {
            String hql="select level ,count(level)  from NetRatedDriver  where licenseid=:licenseid GROUP BY level order by level desc";
            Query query=getSession().createQuery(hql);
            query.setString("licenseid",licenseid);
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
            return null;
        }
    }

    /**
     * 获取最新考核日期机构
     * @param licenseid
     * @return
     */
    @Override
    public NetRatedDriver findLastTestDateRateDriverByLicenseid(String licenseid) {
        try {
            Query query=getSession().createQuery("from NetRatedDriver  where testdate=(select max(testdate) from NetRatedDriver) and licenseid=:licenseid");
            query.setString("licenseid",licenseid);
            List<NetRatedDriver> netRatedDrivers= query.list();
            return netRatedDrivers!=null&&netRatedDrivers.size()!=0?netRatedDrivers.get(0):null;
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }


}
