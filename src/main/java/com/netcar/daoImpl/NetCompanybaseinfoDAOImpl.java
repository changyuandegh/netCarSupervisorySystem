package com.netcar.daoImpl;

import com.netcar.dao.NetCompanybaseinfoDAO;
import com.netcar.dataModle.AjaxMessage;
import com.netcar.entity.NetCompanybaseinfo;
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
 * Created by Mander on 2017/5/2.
 */
@Repository
public class NetCompanybaseinfoDAOImpl implements NetCompanybaseinfoDAO {

    private Logger logger=Logger.getLogger(NetCompanybaseinfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }


    public List<NetCompanybaseinfo> findAll(int limit, int offset) {
        try {
            Query query=getSession().createQuery("from NetCompanybaseinfo");
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }


    /**
     *
     * @param address 行政区划代码
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    @Override
    public List<NetCompanybaseinfo> findAll(String address, String sort, int limit, int offset) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetCompanybaseinfo order by :sort");
            } else {
                query = getSession().createQuery("from NetCompanybaseinfo where address in (select code from NetArea where code=:areacode or fathercode=:areacode) order by :sort");
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

    /**
     *
     * @param address 行政区划代码
     * @param parm 字段名
     * @param value 字段值
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    @Override
    public List<NetCompanybaseinfo> findAllByParm(String address, String parm, String value, String sort, int limit, int offset) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("from NetCompanybaseinfo  where "+parm+" like :value order by :sort");
            } else {
                query = getSession().createQuery("from NetCompanybaseinfo where "+parm+" like :value and address in (select code from NetArea where code=:areacode or fathercode=:areacode) order by :sort");
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
    public int findAllCount(String address) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select count(*) from NetCompanybaseinfo");
            } else {
                query = getSession().createQuery("select count(*) from NetCompanybaseinfo where address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
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
                query = getSession().createQuery("select count(*) from NetCompanybaseinfo where "+parm+" like :value");
            } else {
                query = getSession().createQuery("select count(*) from NetCompanybaseinfo where "+parm+" like :value and address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
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
    public List<AjaxMessage> findidNameByareacode(String address) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select companyid,companyname from NetCompanybaseinfo");
            } else {
                query = getSession().createQuery("select companyid,companyname from NetCompanybaseinfo where address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", address);
            }
            List ls = query.list();
            if (ls!=null){
                return bindData(ls);
            } else {
                return null;
            }
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }



    @Override
    public List<AjaxMessage> findidcNameByareacode(String address) {
        try {
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createQuery("select companyidc,companyname from NetCompanybaseinfo");
            } else {
                query = getSession().createQuery("select companyidc,companyname from NetCompanybaseinfo where address in (select code from NetArea where code=:areacode or fathercode=:areacode)");
                query.setString("areacode", address);
            }
            List ls = query.list();
            if (ls!=null){
                return bindData(ls);
            } else {
                return null;
            }
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }

    /**
     * 获取正在认证的公司的idc,name
     * @return
     */
    @Override
    public String findIdcNameAuthing() {
        try {
            String result="";
            StringBuffer buffer=new StringBuffer("SELECT ca.companyidc from net_company_auth ca where ca.authstate=1");
            Query query =getSession().createSQLQuery(buffer.toString());
            List list= query.list();
            if(list!=null&&list.size()!=0){
                result=list.get(0).toString();
            }
            return  result;
        }catch ( Exception e){
            return null;
        }
    }

    /**
     * 获取公司接口认证状态
     * ajaxMessage.name=接口名称;
     * ajaxMessage.desc=状态值;
     * @param companyidc
     * @return
     */
    @Override
    public List<AjaxMessage> findCompanyAuthInterfaceState(String companyidc) {
        List<AjaxMessage> ajaxMessages=new ArrayList<>();

        try {
            Query query=getSession().createSQLQuery("select f.interfacename,ca.checked from net_company_auth  ca  INNER join net_interfaceinfo f on ca.interfaceid=f.id where ca.companyidc=:companyidc");
            query.setString("companyidc",companyidc);
            List list= query.list();
            if(list!=null&&list.size()!=0){
                for (Object object:list){
                    Object[] obj= (Object[]) object;
                    AjaxMessage message=new AjaxMessage();
                    message.setName(obj[0]!=null?obj[0].toString():null);
                    message.setDesc(obj[1]!=null?obj[1].toString():null);
                    ajaxMessages.add(message);
                }
            }
        }catch (Exception e){

        }
        return ajaxMessages;
    }


    /**
     * 获取认证照片
     * @param companyidc
     * @return
     */
    @Override
    public List<HashMap<String, Object>> findCompanyidcleagPhoto(String companyidc) {
        List<HashMap<String, Object>> list=new ArrayList<>();
        try {
            String sql="select  l.legalphoto,c.companyidc from net_companybaseinfo c INNER join net_legalperson l on l.legalpersonid=c.legalpersonid where c.companyidc=:companyidc";
            Query query=getSession().createSQLQuery(sql);
            query.setString("companyidc",companyidc);
            list=query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }


    private List<AjaxMessage> bindData(List ls){
        List<AjaxMessage> list = new ArrayList<>();

        for(int i=0; i< ls.size(); i++){
            AjaxMessage msg = new AjaxMessage();
            Object[] obj = (Object[]) ls.get(i);
            msg.setName(obj[0].toString());
            msg.setDesc(obj[1].toString());
            list.add(msg);
        }

        return list;
    }

}
