package com.netcar.daoImpl;

import com.netcar.dao.NetOrderDAO;
import com.netcar.dataModle.OrderAfterSales;
import com.netcar.dataModle.OrderFeedBack;
import com.netcar.dataModle.OrderManagement;
import com.netcar.dataModle.OrderPoint;
import com.netcar.entity.NetOrder;
import com.netcar.entity.NetOrdertrajectory;
import com.sun.xml.internal.xsom.impl.ListSimpleTypeImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.ordering.antlr.OrderByAliasResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
@Repository
public class NetOrderDAOImpl implements NetOrderDAO{

    private Logger logger=Logger.getLogger(NetCarbaseinfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }

    @Override
    public List<NetOrder> findBycar(String vehicleno, String starttime, String endtime) {
        try {
            Query query=getSession().createQuery("from NetOrder where vehicleno=:vehicleno and ordertime between :starttime and :endtime");
            query.setString("vehicleno", vehicleno);
            query.setString("starttime", starttime);
            query.setString("endtime", endtime);
            return query.list();
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }


    /**
     * 订单查询
     * @param areacode
     * @param parameter
     * @param search
     * @param stime
     * @param etime
     * @param limit
     * @param offset
     * @return
     */
    @Override
    public List<NetOrder> findOrdersByparm(String areacode, String parameter, String search, String stime, String etime, int limit, int offset) {
        try {
            StringBuffer hql=new StringBuffer("");
            if (areacode.substring(2, 6).equals("0000")) {
                hql.append("from NetOrder where "+parameter+"='"+search+"'");
                if(!StringUtils.isEmpty(stime)&&!StringUtils.isEmpty(etime)){
                    hql.append(" and createtime between '"+stime+"' and '"+etime+"'");
                }
            } else {
                hql.append("from NetOrder where "+parameter+"='"+search+"' and address='"+areacode+"'");
                if(!StringUtils.isEmpty(stime)&&!StringUtils.isEmpty(etime)){
                    hql.append(" and createtime between '"+stime+"' and '"+etime+"'");
                }
            }
            Query query=getSession().createQuery(hql.toString());
            query.setMaxResults(limit);
            query.setFirstResult(offset);
           return query.list();
        }catch (Exception e){
         logger.debug(e);
            return null;
        }
    }



    /**
     * 订单数量查询
     * @param areacode
     * @param parameter
     * @param search
     * @param stime
     * @param etime
     * @return
     */
    @Override
    public int findOrdersCountByparm(String areacode, String parameter, String search, String stime, String etime) {
        int i=0;
        try {
            StringBuffer hql=new StringBuffer("");
            if (areacode.substring(2, 6).equals("0000")) {
                hql.append("select count(orderid) from NetOrder where "+parameter+"='"+search+"'");
                if(!StringUtils.isEmpty(stime)&&!StringUtils.isEmpty(etime)){
                    hql.append(" and createtime between '"+stime+"' and '"+etime+"'");
                }
            } else {
                hql.append("select count(orderid) from NetOrder where "+parameter+"='"+search+"' and address='"+areacode+"'");
                if(!StringUtils.isEmpty(stime)&&!StringUtils.isEmpty(etime)){
                    hql.append(" and createtime between '"+stime+"' and '"+etime+"'");
                }
            }
            Query query=getSession().createQuery(hql.toString());
            List list =query.list();
            i=list!=null&&list.size()!=0?Integer.parseInt(list.get(0).toString()):0;

        }catch (Exception e){
            logger.debug(e);
        }
        return i;
    }

    @Override
    public List<OrderPoint> findOrderPointsByorderid(String orderid) {
        try {
            Query query=getSession().createQuery("from NetOrdertrajectory where orderid=:orderid");
            query.setString("orderid", orderid);
            List<NetOrdertrajectory> ls = query.list();
            if (ls!=null && ls.size()>0){
                return bindData(ls.get(0).getOrdertrajectory());
            } else {
                return null;
            }
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }

    /**
     * 订单爽约率
     * @param comanyidc
     * @return
     */
    public  Double getOrderBreakRate(String comanyidc){
        try {
            String sql="select concat(left((select count(orderid) from net_order where companyid=(SELECT companyid from net_companybaseinfo where companyidc='"+comanyidc+"') and canceltypecode is null) /(select count(orderid) from net_order where companyid=(SELECT companyid from net_companybaseinfo where companyidc='"+comanyidc+"'))*100,5))";
            Query query=getSession().createSQLQuery(sql);
            return Double.parseDouble(query.list().get(0).toString());
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }

    /**
     * 订单反馈内容
     * @param orderid
     * @return
     */
    @Override
    public OrderFeedBack getFeedBackByorderid(String orderid) {
        OrderFeedBack orderFeedBack=new OrderFeedBack();
        try {
            String hql_order="select orderid,createtime,passengerphone,licenseid,vehicleno from net_order where orderid='"+orderid+"'";
            String hql_ratedpsg="select servicescore,detail from net_ratedpassenger where orderid='"+orderid+"'";
            String hql_complaint="select detail,result from net_ratedpassengercomplaint where orderid='"+orderid+"'";

            Query query_order=getSession().createSQLQuery(hql_order);
            Query query_ratedpsg=getSession().createSQLQuery(hql_ratedpsg);
            Query query_complaint=getSession().createSQLQuery(hql_complaint);
            List list_order= query_order.list();
            List list_ratepsg=query_ratedpsg.list();
            List list_complaint=query_complaint.list();
            if(list_order!=null&&list_order.size()!=0){
              Object[] obj=(Object[]) list_order.get(0);
                orderFeedBack.setOrderid(obj[0]!=null?obj[0].toString():null);
                orderFeedBack.setOrdertime(obj[1]!=null?obj[1].toString():null);
                orderFeedBack.setPassagetPhone(obj[2]!=null?obj[2].toString():null);
                orderFeedBack.setLicenseid(obj[3]!=null?obj[3].toString():null);
                orderFeedBack.setVechelno(obj[4]!=null?obj[4].toString():null);
            }
            if(list_ratepsg!=null&&list_ratepsg.size()!=0){
                Object[] obj=(Object[]) list_ratepsg.get(0);
                orderFeedBack.setServicescore(obj[0]!=null?obj[0].toString():null);
                orderFeedBack.setDetail(obj[1]!=null?obj[1].toString():null);
            }
            if(list_complaint!=null&&list_complaint.size()!=0){
                Object[] obj=(Object[]) list_complaint.get(0);
                orderFeedBack.setComplaintDetail(obj[0]!=null?obj[0].toString():null);
                orderFeedBack.setResult(obj[1]!=null?obj[1].toString():null);
            }

        }catch (Exception e){
            logger.debug(e);
        }
        return orderFeedBack;
    }

    /**
     * 根据订单号查询
     * @param orderid
     * @return
     */
    @Override
    public NetOrder findOrderByorderid(String orderid) {
        try {
            Query query= getSession().createQuery("from NetOrder where orderid=:orderid");
            query.setString("orderid",orderid);
            List<NetOrder> orderList= query.list();
            return orderList!=null&&orderList.size()!=0?orderList.get(0):null;
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }




    @Override
    public List<OrderManagement> findOrderDatail(String parameter, int limit, int offset, String areacode, String search, String stime, String etime, String company) {
        List<OrderManagement>  OrderManagement=new ArrayList<OrderManagement>();
        try {
            if(areacode.substring(2,6).equals("0000")){
                String HQL="select od.netorderid,od.ordertype ,od.depamount,od.depmileage,od.vehicleno,dv.drivername," +
                        "dv.driverphone,comp.companyname,od.departure,od.destination ,od.passengerphone" +
                        " from net_order od " +
                        " LEFT JOIN net_driverbaseinfo dv on od.licenseid=dv.licenseid" +
                        " LEFT JOIN net_companybaseinfo comp on od.companyid=comp.companyid" +
                       " where 1=1 ";
                if (areacode != null && !"".equals(areacode)){
                    HQL+=" and od.address="+areacode;
                }else {
                    HQL+=" ";
                }
                if(parameter !=null&&!"".equals(parameter)&& search !=null && !"".equals(search)){
                    if(parameter.equals("netorderid")){
                        HQL+=" and od.netorderid like  '%"+search+"%'";
                    }else if(parameter.equals("vehicleno")){
                        HQL+=" and od.vehicleno like  '%"+search+"%'";
                    }else if(parameter.equals("driverphone")){
                        HQL+=" and dv.driverphone like  '%"+search+"%'";
                    }else if(parameter.equals("passengerphone")){
                        HQL+=" and od.passengerphone like  '%"+search+"%'";
                    }
                }else {
                    HQL+=" ";
                }
                if(stime != null && !"".equals(stime) && etime != null && !"".equals(etime)){
                    HQL+=" and od.createtime BETWEEN '"+stime+"' and '"+etime+"'";
                }else{
                    HQL+=" ";
                }
                if (company != null && !"".equals(company)){
                    HQL+=" and od.companyid= "+company;
                }else {
                    HQL+=" ";
                }
                HQL+= " GROUP BY od.netorderid";
            Query query=getSession().createSQLQuery(HQL);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            List list= query.list();
            OrderManagement = Beans(list);
            }
            return OrderManagement;
        }catch (Exception e){
            System.out.println(e);
            logger.debug(e);
            return null;
        }
    }

    @Override
    public int findCount(String parameter, String areacode, String search, String stime, String etime, String company) {
        int count=0;
        try{
            if (areacode.substring(2,6).equals("0000")){
                String HQL="select count(od.netorderid) " +
                        " from net_order od " +
                        " LEFT JOIN net_driverbaseinfo dv on od.licenseid=dv.licenseid" +
                        " LEFT JOIN net_companybaseinfo comp on od.companyid=comp.companyid" +
                        " where 1=1 ";
                if (areacode != null && !"".equals(areacode)){
                    HQL+=" and od.address="+areacode;
                }else {
                    HQL+=" ";
                }
                if(parameter !=null&&!"".equals(parameter)&& search !=null && !"".equals(search)){
                    if(parameter.equals("netorderid")){
                        HQL+=" and od.netorderid like  '%"+search+"%'";
                    }else if(parameter.equals("vehicleno")){
                        HQL+=" and od.vehicleno like like  '%"+search+"%'";
                    }else if(parameter.equals("driverphone")){
                        HQL+=" and dv.driverphone like  '%"+search+"%'";
                    }else if(parameter.equals("passengerphone")){
                        HQL+=" and od.passengerphone like  '%"+search+"%'";
                    }
                }else {
                    HQL+=" ";
                }
                if(stime != null && !"".equals(stime) && etime != null && !"".equals(etime)){
                    HQL+=" and od.createtime BETWEEN '"+stime+"' and '"+etime+"'";
                }else{
                    HQL+=" ";
                }
                if (company != null && !"".equals(company)){
                    HQL+=" and od.companyid= "+company;
                }else {
                    HQL+=" ";
                }
                Query query=getSession().createSQLQuery(HQL);
                count=Integer.valueOf(query.list().get(0).toString());
            }
            return count;
        }catch (Exception e){
            logger.debug(e);
            return 0;
        }
    }

    private List<OrderPoint> bindData(String ordertrajectory){
        List<OrderPoint> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        JSONArray jsonArray = JSONArray.fromObject(ordertrajectory);
        for(Object obj:jsonArray){
            OrderPoint point = new OrderPoint();

            JSONObject json = JSONObject.fromObject(obj);
            point.setLng(json.getDouble("longitude"));
            point.setLat(json.getDouble("latitude"));
            try {
                point.setLocTime(Timestamp.valueOf(sdf1.format(sdf.parse(json.getString("lTime")))));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            list.add(point);
        }
        return list;
    }


    /**
     * 订单售后
     * @param orderid
     * @return
     */
    public  OrderAfterSales getOrderAfterSales(String orderid){
        OrderAfterSales orderAfterSales=new OrderAfterSales();
        try {
            String sql_ratedpassenger="select servicescore,detail from net_ratedpassenger where orderid='"+orderid+"'";
             String sql_ratedpassengercomplaint="select complainttime from net_ratedpassengercomplaint where orderid='"+orderid+"'";

            Query query_ratepassenger=getSession().createSQLQuery(sql_ratedpassenger);
            Query query_ratedpassengercompalain=getSession().createSQLQuery(sql_ratedpassengercomplaint);
            List list_sql_ratedpassenger= query_ratepassenger.list();
            List list_ratedpassengercompalain= query_ratedpassengercompalain.list();
            if(list_sql_ratedpassenger!=null&&list_sql_ratedpassenger.size()!=0){
                for (Object object: list_sql_ratedpassenger) {
                    Object[] obj=(Object[]) object;
                    orderAfterSales.setServicescore(obj[0]!=null?obj[0].toString():null);
                    orderAfterSales.setDetail(obj[0]!=null?obj[0].toString():null);
                }
            }
        if(list_ratedpassengercompalain!=null&&list_ratedpassengercompalain.size()!=0){
            for (Object object: list_ratedpassengercompalain) {
                Object[] obj=(Object[]) object;
                orderAfterSales.setComplaintDetail(obj[0]!=null?obj[0].toString():null);
            }
        }
        }catch (Exception e){
            logger.debug(e);
        }
        return orderAfterSales;
    }






    public List<OrderManagement> Beans(List list){
        List<OrderManagement> order=new ArrayList<OrderManagement>();
        for (int i=0;i <list.size();i++ ){
            OrderManagement orderManagement=new OrderManagement();
            Object[] object=(Object[])list.get(i);
            orderManagement.setNetorderid(object[0].toString());
            orderManagement.setOrdertype(object[1] != null ?Integer.valueOf(object[1].toString()):1);
            orderManagement.setDepamount(object[2] != null ? Double.valueOf(object[2].toString()):0);
            orderManagement.setDepmileage(object[3] != null ?Double.valueOf(object[3].toString()):0);
            orderManagement.setVehicleno(object[4] != null ?object[4].toString():"");
            orderManagement.setDrivername(object[5] != null ?object[5].toString():"");
            orderManagement.setDriverphone(object[6] != null ?object[6].toString():"");
            orderManagement.setCompangname(object[7] != null ?object[7].toString():"");
            orderManagement.setDeparture(object[8] != null ?object[8].toString():"");
            orderManagement.setDestination(object[9] != null ?object[9].toString():"");
            orderManagement.setPassengerphone(object[10] != null ?object[10].toString():"");
            order.add(orderManagement);
        }
        return order;
    }
}
