package com.netcar.controller;

import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.ServiceScopeLevel;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.entity.NetRatedDriver;
import com.netcar.entity.NetDriverbaseinfo;
import com.netcar.entity.NetOrder;
import com.netcar.service.NetDriverbaseinfoService;
import com.netcar.service.NetRatedDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Mander on 2017/5/4.
 */
@Controller
@RequestMapping(value = "/netdriver")
public class NetDriverController {


    @Autowired
    private NetDriverbaseinfoService netDriverbaseinfoServiceImpl;


    @Autowired
    private NetRatedDriverService netRatedDriverServiceImpl;



    @RequestMapping(value = "/list")
    private  String list(){

        return "netdriver/driver";
    }


    @RequestMapping(value = "/test")
    @ResponseBody
    private List<String> test(){
        List<String> list=new ArrayList<>();
        list.add("8888");list.add("8888");
        list.add("8888");list.add("8888");

        return  list;
    }


    @RequestMapping(value = "/findByParm")
    @ResponseBody
    private BaseTable findParm(String areacode,String parameter,String search,String order,int limit,int offset){
        BaseTable table=null;
            if(!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(order)){
                if(StringUtils.isEmpty(search)){
                    table= netDriverbaseinfoServiceImpl.findAll(areacode,order,limit,offset);
                }else{
                    table=netDriverbaseinfoServiceImpl.findAllByParm(areacode,parameter,search,order,limit,offset);
                }
            }
        return  table;
    }

    /**
     * 根据参数查询单个司机
     * @param licenseid 根据身份证号查询;
     * @param licenseidVaue 身份证号
     * @return
     */
    @RequestMapping(value = "/findBydriverByParm")
    @ResponseBody
    private NetDriverbaseinfo findBydriverByParm(String licenseid,String licenseidVaue){
        if(!StringUtils.isEmpty(licenseid)&&!StringUtils.isEmpty(licenseidVaue)){
            return netDriverbaseinfoServiceImpl.findBydriverByParm(licenseid,licenseidVaue);
        }else{
            return null;
        }
    }


    /**
     * 单个司机信誉
     * @param licenseid 根据身份证号;
     * @return
     */
    @RequestMapping(value = "/findRateDriverByLicenseid")
    @ResponseBody
    private  List<ServiceScopeLevel> findRateDriverByLicenseid(String licenseid){
        if(!StringUtils.isEmpty(licenseid)){
            return netRatedDriverServiceImpl.findRateDriverByLicenseid(licenseid);
        }else{
            return null;
        }
    }


    /**
     * 获取最新考核机构和日期
     * @param licenseid
     * @return
     */
    @RequestMapping(value = "/findLastTestDateRateDriverByLicenseid")
    @ResponseBody
    private NetRatedDriver  findLastTestDateRateDriverByLicenseid(String licenseid){
        if(!StringUtils.isEmpty(licenseid)){
            return netRatedDriverServiceImpl.findLastTestDateRateDriverByLicenseid(licenseid);
        }else{
            return null;
        }
    }


    //
    /**
     * 获取司机信息
     * @param licenseid
     * @return
     */
    @RequestMapping(value = "/findDriverBylicenseid")
    @ResponseBody
    private NetDriverbaseinfo  findDriverBaseinfoBylicenseid(String licenseid){
        if(!StringUtils.isEmpty(licenseid)){
            NetDriverbaseinfo net=  netDriverbaseinfoServiceImpl.findDriverBaseinfoBylicenseid(licenseid);
            System.out.println(net);
            return net;
        }else{
            return null;
        }
    }

    /**
     * 订单管理-加载司机信息
     * @param name
     * @param vehicleno
     * @param orderID
     * @return
     */
    @RequestMapping(value="/findDriver")
    @ResponseBody
    public List<NetDriverbaseinfo> findDriverDatail(String name,String vehicleno,String orderID){
        List<NetDriverbaseinfo> driverbaseinfoList=new ArrayList<NetDriverbaseinfo>();
        if(StringUtils.isEmpty(name)){
            driverbaseinfoList=netDriverbaseinfoServiceImpl.findDriverDatail(name);
        }
        return driverbaseinfoList;
    }
}
