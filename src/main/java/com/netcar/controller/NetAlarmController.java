package com.netcar.controller;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.ProportionData;
import com.netcar.dataModle.ThermalPoint;
import com.netcar.entity.NetAlarmsubscription;
import com.netcar.entity.NetUser;
import com.netcar.service.NetAlarmService;
import com.netcar.serviceImpl.NetAlarmServiceImpl;
import com.netcar.tools.ContextData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mander on 2017/5/10.
 * 报警控制器
 */
@Controller
@RequestMapping(value = "/alarm")
public class NetAlarmController {


    @Autowired
    private NetAlarmService netAlarmServiceImpl;





    /***
     * 获取各个报警类型占比
     * @param areacode
     * @param cycleTime
     * @return
     */
    @RequestMapping(value = "/getProportionAlarmType")
    @ResponseBody
    private  List<ProportionData> getProportionAlarmType(String areacode,String cycleTime){
        if(!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(cycleTime)){
            return  netAlarmServiceImpl.getProportionAlarmType(areacode,Integer.parseInt(cycleTime));
        }else{
            return  null;
        }
    }



    /**
     * 获取各个公司报警占比
     * @param areacode 地区编码
     * @param cycleTime 可能值: 1(月),2(周),3(日)
     * @return
     */
    @RequestMapping(value = "/getProportionCompanyAlarm")
    @ResponseBody
    private  List<ProportionData> getProportionCompanyAlarm(String areacode,String cycleTime){
        if (!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(cycleTime)){
            List<ProportionData> lsdata= netAlarmServiceImpl.getProportionCompanyAlarm(areacode,Integer.parseInt(cycleTime));
            if(lsdata!=null&&lsdata.size()!=0){
                for (int i = 0; i < lsdata.size(); i++) {
                    ProportionData pd= lsdata.get(i);
                    if(pd.getName().length()>2){
                        pd.setName(pd.getName().substring(0,2));
                    }
                }
            }
            //模拟数据
            if(lsdata==null||lsdata.size()<1){
                lsdata=new ArrayList<>();
                ProportionData proportionData1=new ProportionData();
                proportionData1.setName("神州");
                proportionData1.setValue("30");
                proportionData1.setColor("#fedd74");
                lsdata.add(proportionData1);
                ProportionData proportionData2=new ProportionData();
                proportionData2.setName("滴滴");
                proportionData2.setValue("45");
                proportionData2.setColor("#82d8ef");
                lsdata.add(proportionData2);
                ProportionData proportionData3=new ProportionData();
                proportionData3.setName("99");
                proportionData3.setValue("15");
                proportionData3.setColor("#f76864");
                lsdata.add(proportionData3);
                ProportionData proportionData4=new ProportionData();
                proportionData4.setName("一步");
                proportionData4.setValue("10");
                proportionData4.setColor("#fd9fc1");
                lsdata.add(proportionData4);
            }
            return  lsdata;
        }else {
            return null;
        }
    }





    /**
     * 获取各报警的位置点,(用于报警热力图)
     * @param areacode 地区编码
     * @param cycleTime 可能值: 1(月),2(周),3(日)
     * @return
     */
    @RequestMapping(value = "/getThermalPointAlarm")
    @ResponseBody
    private List<ThermalPoint> getThermalPointAlarm(String areacode, String cycleTime){
        if (!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(cycleTime)){
            return  netAlarmServiceImpl.getThermalPointAlarm(areacode,Integer.parseInt(cycleTime));
        }else {
            return  null;
        }
    }




    /**
     * 按报警类型获取时间段的报警信息
     * @param areacode 地区编码
     * @param alarmTypeid 报警类型id
     * @param starttme 开始时间
     * @param endtime 结束时间
     * @return
     */
    @RequestMapping(value = "/getAlarmByTypeTime")
    @ResponseBody
   private  BaseTable getAlarmByTypeTime(String areacode, String alarmTypeid, String starttme, String endtime, String sort, String limit, String offset){
       BaseTable table=new BaseTable();
       try {
           if(!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(alarmTypeid)&&!StringUtils.isEmpty(starttme)&&!StringUtils.isEmpty(endtime)&&!StringUtils.isEmpty(limit)&&!StringUtils.isEmpty(offset)){
               SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
               table=netAlarmServiceImpl.getAlarmByTypeTime(areacode,Integer.parseInt(alarmTypeid),format.parse(starttme),format.parse(endtime),sort,Integer.parseInt(limit),Integer.parseInt(offset));

           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return table;
   }


    /**
     * 获取报警订阅id
     * @param request
     * @return
     */
    @RequestMapping("getAlarmSubids")
    @ResponseBody
    private List<Integer> getAlarmSub(HttpServletRequest request){
        Object object= request.getSession().getAttribute(ContextData.loginuser);
        List<Integer> alarmTypeids=new ArrayList<>();
        if(object!=null){
            List<NetAlarmsubscription> ls= netAlarmServiceImpl.getAlarmSubscription(((NetUser) object).getId());
            if(ls!=null&&ls.size()!=0){
                for (int i = 0; i < ls.size(); i++) {
                    alarmTypeids.add(ls.get(i).getAlarmid());
                }
            }
        }
        return alarmTypeids;
    }


    /**
     * 更新用户报警订阅
     * @param alaryTypeids alarmIds
     * @param request
     * @return
     */
    @RequestMapping("updateAlarmSubids")
    @ResponseBody
    private AjaxMessage subAlarmSubids(String alaryTypeids, HttpServletRequest request){
        AjaxMessage ajaxMessage=new AjaxMessage();
        try {
            Object object= request.getSession().getAttribute(ContextData.loginuser);
            List<Integer> ls=new ArrayList<>();
            if(alaryTypeids.contains(",")){
                String[] ids=alaryTypeids.split(",");
                for (int i = 0; i < ids.length; i++) {
                    ls.add(Integer.parseInt(ids[i]));
                }
            }
            if (netAlarmServiceImpl.updateAlarmSubscription(((NetUser)object).getId(),ls)){
                ajaxMessage.setName("success");
                ajaxMessage.setDesc("更新成功");
            }else{
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("更新失败");
            }
        }catch (Exception e){
            ajaxMessage.setName("error");
            ajaxMessage.setDesc("解析失败,参数异常");
        }

        return ajaxMessage;
    }




    @RequestMapping(value = "/getTodayAlarmByalarmType")
    @ResponseBody
    private BaseTable getTodayAlarm(String areacode,String alarmtype,int limit,int offset ){
        BaseTable table=new BaseTable();
        if(!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(alarmtype)&&!StringUtils.isEmpty(limit)&&!StringUtils.isEmpty(offset)){
            table=netAlarmServiceImpl.getTodayAlarm(areacode,alarmtype,limit, offset,"");
          //  table=netAlarmServiceImpl.getTodayAlarm(areacode,limit,offset,"");
        }
        return table;
    }



}
