package com.netcar.daoImpl;

import com.netcar.dao.NetFareInfoDAO;
import com.netcar.dataModle.FareInfoData;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
@Repository
public class NetFareInfoDAOImpl implements NetFareInfoDAO{

    private Logger logger=Logger.getLogger(NetFareInfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }

    /**
     * 查询运价信息
     * @param company
     * @param areacode
     * @param stime
     * @param etime
     * @return
     */
    @Override
    public List<FareInfoData> findFareInfo(String company, String areacode, String stime, String etime,int limit,int offset) {
        List<FareInfoData> fareinfoDataList=new ArrayList<FareInfoData>();
        try {
            if(areacode.substring(2,6).equals("0000")){
                String HQL="SELECT" +
                        " fa.fareid,"+
                        " com.companyname," +
                        " a.`name`," +
                        " fa.farevalidon," +
                        " fa.farevalidoff," +
                        " fa.startfare," +
                        " fa.startmile," +
                        " fa.unitpricepermile," +
                        " fa.unitpriceperminute," +
                        " fa.nightpricepermile," +
                        " fa.nightpriceperminute," +
                        " fa.pricestate" +
                        " FROM" +
                        " net_fare  fa" +
                        " INNER JOIN  net_companybaseinfo com ON com.companyidc=fa.companyidc" +
                        " INNER JOIN (SELECT are.`name`,co.companyidc FROM net_companybaseinfo co INNER JOIN net_area are ON are.code=co.address) a ON a.companyidc=fa.companyidc"+
                        " where 1=1 "
                        +" and com.address in(SELECT ne.`code` FROM net_area ne where 1=1 ";
                if (areacode != null && !"".equals(areacode)){
                    HQL+=" and com.address="+areacode + " OR ne.fathercode="+areacode +")";
                }
                if(company != null && !"".equals(company)){
                    HQL+=" and fa.companyidc= "+company;
                }
                if(stime != null && !"".equals(stime) && etime != null && !"".equals(etime)){
                    HQL+=" and fa.createtime BETWEEN '"+stime+"' and '"+etime+"'";
                }
                HQL+=" ORDER BY fa.fareid";
                Query query=getSession().createSQLQuery(HQL);
                query.setFirstResult(offset);
                query.setMaxResults(limit);
                List list= query.list();
                fareinfoDataList=Beanis(list);
            }
            return fareinfoDataList;
        }catch (Exception e){
            logger.debug(e);
            return null;
        }

    }

    /**
     * 运价信息条数
     * @param company
     * @param areacode
     * @param stime
     * @param etime
     * @return
     */
    @Override
    public int findcount(String company, String areacode, String stime, String etime) {
        int count=0;
        try{
            if(areacode.substring(2,6).equals("0000")){
                String HQL="SELECT COUNT(*)" +
                        " FROM" +
                        " net_fare  fa" +
                        " INNER JOIN  net_companybaseinfo com ON com.companyidc=fa.companyidc" +
                        " INNER JOIN (SELECT are.`name`,co.companyidc FROM net_companybaseinfo co INNER JOIN net_area are ON are.code=co.address) a ON a.companyidc=fa.companyidc"+
                        " where 1=1 "
                        +" and com.address in(SELECT ne.`code` FROM net_area ne where 1=1";
                if (areacode != null && !"".equals(areacode)){
                    HQL+=" and com.address="+areacode + " OR ne.fathercode="+areacode +")";
                }
                if(company != null && !"".equals(company)){
                    HQL+=" and fa.companyidc= "+company;
                }
                if(stime != null && !"".equals(stime) && etime != null && !"".equals(etime)){
                    HQL+=" and fa.createtime BETWEEN '"+stime+"' and '"+etime+"'";
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

    @Override
    public FareInfoData findFareInfoDatail(String fareid) {
        FareInfoData fareInfo=null;
        try{
                if(!StringUtils.isEmpty(fareid)){
                    String SQL="SELECT com.companyname ,a.`name`,fa.faretype,fa.faretypenote,fa.farevalidon ,fa.farevalidoff ,fa.startfare," +
                            "fa.startmile,fa.unitpricepermile ,fa.unitpriceperminute,fa.upprice,fa.uppricestartmile,fa.nightpricepermile,fa.nightpriceperminute," +
                            "fa.morningpeaktimeon,fa.morningpeaktimeoff,fa.eveningpeaktimeon,fa.eveningpeaktimeoff,fa.otherpeaktimeon,fa.otherpeaktimeoff," +
                            "fa.peakunitprice,fa.peakpricestartmile,fa.lowspeedpriceperminute,fa.otherprice,fa.pricestate,fa.updatetime" +
                            " FROM net_fare  fa" +
                            " INNER JOIN  net_companybaseinfo com ON com.companyidc=fa.companyidc" +
                            " INNER JOIN (SELECT are.`name`,co.companyidc FROM net_companybaseinfo co" +
                            " INNER JOIN net_area are ON are.code=co.address) a ON a.companyidc=fa.companyidc" +
                            " WHERE fa.fareid="+ fareid;
                    Query query=getSession().createSQLQuery(SQL);
                    List list=query.list();
                    if(list.size()>0){
                        fareInfo=Add(list);
                    }
                }
            return fareInfo;
        }catch(Exception e){
            logger.debug(e);
            return null;
        }

    }

    public List<FareInfoData> Beanis(List list){
        List<FareInfoData> infoDataList=new ArrayList<FareInfoData>();
        if(list.size() > 0){
            for (int i =0;i<list.size();i++){
                Object[] objects=(Object[]) list.get(i);
                FareInfoData fareInfoData=new FareInfoData();
                fareInfoData.setFareid(Integer.valueOf(objects[0].toString()));
                fareInfoData.setCompany(objects[1] != null?objects[1].toString():"");
                fareInfoData.setName(objects[2] != null?objects[2].toString():"");
                fareInfoData.setFarevalidon(objects[3] != null?Timestamp.valueOf(objects[3].toString()):null);
                fareInfoData.setFarevalidoff(Timestamp.valueOf(objects[4].toString()));
                fareInfoData.setStartfare(objects[5] != null?Double.valueOf(objects[5].toString()):0);
                fareInfoData.setStartmile(objects[6] != null?Double.valueOf(objects[6].toString()):0);
                fareInfoData.setUnitpricepermile(objects[7] != null?Double.valueOf(objects[7].toString()):0);
                fareInfoData.setUnitpriceperminute(objects[8] != null?Double.valueOf(objects[8].toString()):0);
                fareInfoData.setNightpricepermile(objects[9] != null?Double.valueOf(objects[9].toString()):0);
                fareInfoData.setNightpriceperminute(objects[10] != null?Double.valueOf(objects[10].toString()):0);
                fareInfoData.setPricestate(objects[11] !=null?Integer.valueOf(objects[11].toString()) :0);
                infoDataList.add(fareInfoData);
            }
        }
        return infoDataList;
    }

    public static Date format(String date)throws Exception{
        Date sdate=null;
        DateFormat simp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(StringUtils.isEmpty(date)){
            sdate=simp.parse(simp.format(date));
        }
        return sdate;
    }

    public FareInfoData Add(List list) {
        FareInfoData fare=new FareInfoData();
        try{
            Object[] object=(Object[]) list.get(0);
            fare.setCompany(object !=null?object[0].toString():"");
            fare.setName(object[1] != null?object[1].toString():"");
            fare.setFaretype(object[2] != null?object[2].toString():"");
            fare.setFaretypenote(object[3] != null?object[3].toString():"");
            fare.setFarevalidon(Timestamp.valueOf(object[4].toString()));
            fare.setFarevalidoff(Timestamp.valueOf(object[5].toString()));
            fare.setStartfare(object[6] != null?Double.valueOf(object[6].toString()):0);
            fare.setStartmile(object[7] != null?Double.valueOf(object[7].toString()):0);
            fare.setUnitpricepermile(object[8] != null?Double.valueOf(object[8].toString()):0);
            fare.setUnitpriceperminute(object[9] != null?Double.valueOf(object[9].toString()):0);
            fare.setUpprice(object[10] != null?Double.valueOf(object[10].toString()):0);
            fare.setUppricestartmile(object[11] != null?Double.valueOf(object[11].toString()):0);
            fare.setNightpricepermile(object[12] != null?Double.valueOf(object[12].toString()):0);
            fare.setNightpriceperminute(object[13] != null?Double.valueOf(object[13].toString()):0);
            fare.setMorningpeaktimeon(object[14] != null?Timestamp.valueOf(object[14].toString()):null);
            fare.setMorningpeaktimeoff(object[15] != null?Timestamp.valueOf(object[15].toString()):null);
            fare.setEveningpeaktimeon(object[16] != null?Timestamp.valueOf(object[16].toString()):null);
            fare.setEveningpeaktimeoff(object[17] != null?Timestamp.valueOf(object[17].toString()):null);
            fare.setOtherpeaktimeon(object[18] != null?Timestamp.valueOf(object[18].toString()):null);
            fare.setOtherpeaktimeoff(object[19] != null?Timestamp.valueOf(object[19].toString()):null);
            fare.setPeakunitprice(object[20] != null?Double.valueOf(object[20].toString()):0);
            fare.setPeakpricestartmile(object[21] != null?Double.valueOf(object[21].toString()):0);
            fare.setLowspeedpriceperminute(object[22] != null?Double.valueOf(object[22].toString()):0);
            fare.setOtherprice(object[23] != null?Double.valueOf(object[23].toString()):0);
            fare.setPricestate(object[24] != null?Integer.valueOf(object[24].toString()):null);
            fare.setUpdatetime(object[25] != null?Timestamp.valueOf(object[25].toString()):null);

        }catch(Exception e){
            e.printStackTrace();
        }
        return fare;
    }
}
