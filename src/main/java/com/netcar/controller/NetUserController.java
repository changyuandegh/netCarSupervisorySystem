package com.netcar.controller;

import com.google.gson.JsonObject;
import com.netcar.dataModle.*;
import com.netcar.entity.NetArea;
import com.netcar.entity.NetUser;
import com.netcar.service.NetAreaService;
import com.netcar.service.NetAuthorityService;
import com.netcar.service.NetStatisticsService;
import com.netcar.service.NetUserService;
import com.netcar.tools.ContextData;
import com.netcar.tools.MD5Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mander on 2017/4/25.
 * 用户控制器
 */

@Controller
@RequestMapping(value = "/user")
public class NetUserController {


    @Autowired
    private NetUserService netUserServiceImpl;

    @Autowired
    private NetAuthorityService netAuthorityServiceImpl;

    @Autowired
    private NetAreaService netAreaServiceImpl;

    @Autowired
    private NetStatisticsService netStatisticsServiceImpl;


    String[] alarmColor_company = new String[]{"#EBB43E", "#EA5F30", "#CCA968", "#56D1CA", "#C9413E", "#404040", "#54D287", "#AA55DC", "#595CE8", "#D7467B"};




    /**
     * 进入登录
     * @return
     */
    @RequestMapping(value = "/login")
    private String login() {
        return "login";
    }

    /**
     * 登录
     *
     * @param name
     * @param pass
     * @param request
     * @param reponse
     * @return
     */
    @RequestMapping(value = "/dologin")
    private String dologin(String name, String pass, HttpServletRequest request, HttpServletResponse reponse) {
        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(pass)) {
            NetUser netUser = netUserServiceImpl.findByNamePass(name,MD5Util.MD5(pass));
            if (netUser != null) {
                String areacode=netUser.getAreaid().toString();
                request.getSession().setAttribute(ContextData.loginuser, netUser);
                //获取用户功能;
                List<Menu> menus = netAuthorityServiceImpl.findMenuByuserid(netUser.getId());
                request.setAttribute("Menus",menus);
                //地区
                List<NetArea> netAreas= netAreaServiceImpl.findChildrenBycode(areacode);
                String dd= netUser.getAreaid().toString().substring(2,6);
                if(dd.equals("0000")){
                    NetArea ourArea= new NetArea();
                    ourArea.setCode(netUser.getAreaid().toString());
                    ourArea.setLevel(netAreas.get(0).getLevel());
                    ourArea.setName("所有");
                    netAreas.add(0,ourArea);
                }
                request.setAttribute("netAreas",netAreas);

                //首页统计(头部) StatisticsNumData
                StatisticsNumData  statisticsNumData= netStatisticsServiceImpl.getStatisticsNum(areacode);
                if(statisticsNumData==null){
                    statisticsNumData=new StatisticsNumData(0,0,0,0,0);
                }
                request.setAttribute("statisticsNumData",statisticsNumData);
                //重载率
                request.setAttribute("operationProportion",netStatisticsServiceImpl.getOperationProportion(areacode));
                //报警数量
                request.setAttribute("alarmNum",netStatisticsServiceImpl.getAlarmNum(areacode));

                //车辆在线率
                request.setAttribute("onlineProportion",netStatisticsServiceImpl.getOnlineProportion(areacode));
                //签到率
                request.setAttribute("signProportion",netStatisticsServiceImpl.getSignProportion(areacode));
                //用户活跃率
                request.setAttribute("userLiveness",netStatisticsServiceImpl.getUserLiveness(areacode));

                //各公司订单占比
                try {
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date sdate= format.parse("2017-04-01 00:00:00");
                    ShowOrderStatistics showOrderStatistics= netStatisticsServiceImpl.getOrderStatistics(areacode,sdate,new Date());

                    List<ProportionData> companyProportion =new ArrayList<>();//当日各公司订单占比
                    int count = 0;
                    for (int i = 0; i < showOrderStatistics.getCompanyStatistics().size(); i++) {
                        List<AjaxMessage> orderstatisticsdata= showOrderStatistics.getCompanyStatistics();
                        ProportionData proportionData = new ProportionData();
                        proportionData.setName(orderstatisticsdata.get(i).getName());
                        proportionData.setValue(Integer.toString(Integer.parseInt(orderstatisticsdata.get(i).getDesc())/1000));
                        proportionData.setColor(alarmColor_company[count]);

                        companyProportion.add(proportionData);
                        if (count++ == alarmColor_company.length) count = 0;
                    }
                    //叫车辆
                    JSONArray jsonArray= JSONArray.fromObject(showOrderStatistics.getTimeStatistics());
                    System.out.println(jsonArray.toString());
                    List<AjaxMessage> timestatics= showOrderStatistics.getTimeStatistics();
                    for (int i = 0; i < timestatics.size(); i++) {
                        String[] datetime= timestatics.get(i).getName().split(" ");
                        timestatics.get(i).setName(datetime[1]);
                    }

                    request.setAttribute("timeStatistics", JSONArray.fromObject(timestatics));

                    //订单量
                    request.setAttribute("companyStatistics",JSONArray.fromObject(showOrderStatistics.getCompanyStatistics()).toString());
                    //订单比例
                    request.setAttribute("companyProportion",JSONArray.fromObject(companyProportion).toString());

                    //热力点(默认订单)

                    request.setAttribute("orderPoint",JSONArray.fromObject(netStatisticsServiceImpl.getOrderPoint(areacode,sdate,new Date())).toString());
//                    request.setAttribute("driverPoint",netStatisticsServiceImpl.getDriverPotin(areacode,sdate,new Date()));
//                    request.setAttribute("psgPoint",netStatisticsServiceImpl.getPsgPotin(areacode,sdate,new Date()));
//

                }catch (Exception e){
                    e.printStackTrace();
                }

                List<OrderStatisticsData> timeStatistics;//当日各时段订单量、完成量图表数据
                List<OrderStatisticsData> companyStatistics;//当日各公司订单量、完成量图标数据
                List<ProportionData> companyProportion;//当日各公司订单占比


                return "index";
            } else {
                request.setAttribute("reg", "账户密码不匹配");
                return "login";
            }
        } else {
            return "login";
        }
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/firstpage")
    private String tofirstPage(){
        return "firstPage";
    }


    /**
     * 司机热力点
     * @param request
     * @return
     */
    @RequestMapping(value = "/getDriverPoint")
    @ResponseBody
    private List<ThermalPoint> getDriverPoint(HttpServletRequest request){
        try {
            Object object= request.getSession().getAttribute(ContextData.loginuser);
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           Date sdate =format.parse("2017-04-10 00:00:00");
            return   netStatisticsServiceImpl.getDriverPotin(((NetUser)object).getAreaid().toString(),sdate,new Date());
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 乘客热力点
     * @param
     * @return
     */
    @RequestMapping(value = "/getPsgPoint")
    @ResponseBody
    private List<ThermalPoint> getPsgPoint(HttpServletRequest request){
        try {
            Object object= request.getSession().getAttribute(ContextData.loginuser);
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date sdate =format.parse("2017-04-10 00:00:00");
            return   netStatisticsServiceImpl.getPsgPotin(((NetUser)object).getAreaid().toString(),sdate,new Date());
        }catch (Exception e){
            return null;
        }
    }



    @RequestMapping(value = "/getOrderPoint")
    @ResponseBody
    private List<ThermalPoint> getOrderPoint(HttpServletRequest request){
        try {
            Object object= request.getSession().getAttribute(ContextData.loginuser);
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date sdate =format.parse("2017-04-10 00:00:00");
            return   netStatisticsServiceImpl.getOrderPoint(((NetUser)object).getAreaid().toString(),sdate,new Date());
        }catch (Exception e){
            return null;
        }
    }




    @RequestMapping(value = "/findChildrenBycode")
    @ResponseBody
    private List<NetArea> findChildrenBycode(String areacode){
        return netAreaServiceImpl.findChildrenBycode(areacode);
    }




}
