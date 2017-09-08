package com.netcar.daoImpl;

import com.netcar.dao.NetCompanyAuthDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mander on 2017/7/5.
 */
@Repository
public class NetCompanyAuthDAOImpl implements NetCompanyAuthDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.openSession();
    }

    /**
     * 添加新认证公司
     * @param companyidc
     * @return
     */
    @Override
    public boolean addCompanyAuth(String companyidc) {
        boolean reg=false;

        try {
            StringBuffer  sql=new StringBuffer("insert into net_company_auth(companyidc,interfaceid,checked,authstate)values");
            sql.append("(:companyidc,1,0,1)");
            sql.append(",(:companyidc,2,0,1)");
            sql.append(",(:companyidc,3,0,1)");
            sql.append(",(:companyidc,4,0,1)");
            sql.append(",(:companyidc,5,0,1)");
            sql.append(",(:companyidc,6,0,1)");
            sql.append(",(:companyidc,7,0,1)");
            sql.append(",(:companyidc,8,0,1)");
            sql.append(",(:companyidc,9,0,1)");
            sql.append(",(:companyidc,10,0,1)");
            sql.append(",(:companyidc,11,0,1)");
            sql.append(",(:companyidc,12,0,1)");
            sql.append(",(:companyidc,13,0,1)");
            sql.append(",(:companyidc,14,0,1)");
            sql.append(",(:companyidc,15,0,1)");
            sql.append(",(:companyidc,16,0,1)");
            sql.append(",(:companyidc,17,0,1)");
            sql.append(",(:companyidc,18,0,1)");
            sql.append(",(:companyidc,19,0,1)");
            sql.append(",(:companyidc,20,0,1)");
            sql.append(",(:companyidc,21,0,1)");
            sql.append(",(:companyidc,22,0,1)");
            sql.append(",(:companyidc,23,0,1)");
            sql.append(",(:companyidc,24,0,1)");
            sql.append(",(:companyidc,25,0,1)");
            sql.append(",(:companyidc,26,0,1)");
            sql.append(",(:companyidc,27,0,1)");
            sql.append(",(:companyidc,28,0,1)");
            sql.append(",(:companyidc,29,0,1)");
            Query query=getSession().createSQLQuery(sql.toString());
            query.setString("companyidc",companyidc);
            int i= query.executeUpdate();
            if(i>0){
                reg=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return reg;
    }

    /**
     * 将所有 不是companyidc的项改为历史认证
     * @param companyidc
     * @return
     */
    @Override
    public int updateByCompanyidc(String companyidc) {
        int i=0;
        try {
            String sql="update net_company_auth set authstate=0 where companyidc=:companyidc";
            Query query=getSession().createSQLQuery(sql);
            query.setString("companyidc",companyidc);
            i= query.executeUpdate();
        }catch (Exception e){

        }
        return i;
    }


    /**
     * 历史认证
     * @param companyidc
     * @return
     */
    @Override
    public Integer findCountHisAuthToByCompanyidc(String companyidc) {
        int i=0;
        try {
            String sql="select count(c.id)from net_company_auth c INNER join net_interfaceinfo i on i.interfaceid=c.interfaceid where c.companyidc=:companyidc";
            Query query=getSession().createSQLQuery(sql);
            query.setString("companyidc",companyidc);
            List list= query.list();
            System.out.println(list.get(0));
            i=list!=null&&list.size()!=0?Integer.parseInt(list.get(0).toString()):0;
        }catch (Exception e){

        }
        return i;
    }


    /**
     * 历史认证
     * @param companyidc
     * @param limit
     *@param offset @return
     */
    @Override
    public List findHisAuthToByCompanyidc(String companyidc, Integer limit, Integer offset) {
        try {
            String sql="select c.id, c.companyidc,c.checked,i.interfacename from net_company_auth c INNER join net_interfaceinfo i on i.interfaceid=c.interfaceid where c.companyidc=:companyidc order by i.interfacename";
            Query query=getSession().createSQLQuery(sql);
            query.setString("companyidc",companyidc);
            query.setMaxResults(limit);
            query.setFirstResult(offset);
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            return query.list();
        }catch (Exception e){
            return null;
        }
    }


    @Override
    public List<Object> findAllCompanyidc() {
        try {
            String sql="select companyidc from net_company_auth GROUP BY companyidc";
            Query query=getSession().createSQLQuery(sql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }





}
