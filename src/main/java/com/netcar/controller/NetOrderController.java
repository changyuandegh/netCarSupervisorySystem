package com.netcar.controller;

import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.OrderAfterSales;
import com.netcar.dataModle.OrderFeedBack;
import com.netcar.dataModle.ServiceScopeLevel;
import com.netcar.entity.NetOrder;
import com.netcar.entity.NetOrderpay;
import com.netcar.service.NetOrderPayService;
import com.netcar.service.NetOrderService;
import com.netcar.service.NetRatedpassengerService;
import com.netcar.service.NetRatedpassengercomplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mander on 2017/5/8.
 * 订单控制
 */
@Controller
@RequestMapping(value = "/order")
public class NetOrderController {

    @Autowired
    private  NetOrderService netOrderServiceImpl;

    @Autowired
    private NetRatedpassengerService netRatedpassengerServiceImpl;

    @Autowired
    private NetRatedpassengercomplaintService netRatedpassengercomplaintServiceImpl;

    @Autowired
    private NetOrderPayService netOrderPayServiceImpl;

    /**
     * 进入订单管理页
     * @return
     */
    @RequestMapping(value = "/list")
    private String list(){
        return "/market/orderManage";
    }


    @RequestMapping(value = "/findBycar")
    @ResponseBody
    private List<NetOrder> findOrder(String vehicleno, String starttime, String endtime){
        List<NetOrder> orderList=new ArrayList<>();
        if(!StringUtils.isEmpty(vehicleno)&&!StringUtils.isEmpty(starttime)&&!StringUtils.isEmpty(endtime)){
            orderList= netOrderServiceImpl.findBycar(vehicleno,starttime,endtime);
        }
        return  orderList;
    }

    /**
     * 订单查询
     * @param areacode
     * @param search
     * @param parameter
     * @param stime
     * @param etime
     * @param limit
     * @param offset
     * @return
     */
    @RequestMapping(value = "/findOrdersByparm")
    @ResponseBody
    private BaseTable findOrdersByparm(String areacode,String parameter, String search, String stime, String etime, Integer limit, Integer offset){
        BaseTable table=new BaseTable();
        List<NetOrder> orderList=new ArrayList<>();
        if(!StringUtils.isEmpty(parameter)&&!StringUtils.isEmpty(search)&&!StringUtils.isEmpty(areacode)){
            table= netOrderServiceImpl.findOrdersByparm(areacode,parameter,search,stime,etime,limit,offset);
        }else{
            table.setTotal(0);
            table.setRows(null);
        }
        return  table;
    }

    /**
     * 根据订单号
     *@orderid
     * @return
     */
    @RequestMapping(value = "/getOrderByorderid")
    @ResponseBody
    private NetOrder getOrderByorderid(String orderid){
       if(!StringUtils.isEmpty(orderid)){
           return netOrderServiceImpl.findOrderByorderid(orderid);
       }else{
           return null;
       }
    }


    /**
     *获取订单支付信息
     * @param orderid
     * @return
     */
    @RequestMapping(value = "/getOrderPayByorderid")
    @ResponseBody
    private NetOrderpay getOrderPayByorderid(String orderid){
        if(!StringUtils.isEmpty(orderid)){
            return netOrderPayServiceImpl.findbyorderid(orderid);
        }else{
            return null;
        }
    }


    /**
     * 获取订单售后信息
     * @param orderid
     * @return
     */
    @RequestMapping(value = "/getOrderAfterSales")
    @ResponseBody
    private OrderAfterSales getOrderAfterSales(String orderid){
        if(!StringUtils.isEmpty(orderid)){
            return netOrderServiceImpl.getOrderAfterSales(orderid);
        }else{
            return null;
        }
    }

    /**
     * 评价反馈页面===========================
     */
    @RequestMapping(value = "/feedback")
    private String orderFeedBack(){
        return "market/feedback";
    }






    /**
     * 信誉体系页面===========================
     */
    @RequestMapping(value = "/credibility")
    private String credibility(){
        return "market/credibility";
    }


    /**
     * 获取公司的服务评价各个等级数
     * @param companyidc
     * @return
     */
    @RequestMapping(value ="/getServiceScopegroupByCompanyidc")
    @ResponseBody
    private List<ServiceScopeLevel> getServiceScopegroupByCompanyidc(String companyidc){
        if (!StringUtils.isEmpty(companyidc)){
            return netRatedpassengerServiceImpl.getServiceScopegroupByCompanyidc(companyidc);
        }else{
            return null;
        }
    }

    /**
     * 获取公司的投诉处理率
     * @param companyidc
     * @return
     */
    @RequestMapping(value ="/getComplaintForCompany")
    @ResponseBody
    private  Double getComplaintForCompany(String companyidc){
        if (!StringUtils.isEmpty(companyidc)){
            return netRatedpassengercomplaintServiceImpl.getServiceScopegroupByCompanyidc(companyidc);
        }else{
            return null;
        }
    }

    /**
     * 订单爽约率
     * @param companyidc
     * @return
     */
    @RequestMapping(value ="/getOrderBreakRate")
    @ResponseBody
    private  Double getOrderBreakRate(String companyidc){
        if (!StringUtils.isEmpty(companyidc)){
            return netOrderServiceImpl.getOrderBreakRate(companyidc);
        }else{
            return null;
        }
    }


    /**
     * 订单评价反馈页面查询内容
     * @param orderid
     */
    @RequestMapping(value = "/getFeedBackByorderid")
    @ResponseBody
    private OrderFeedBack getFeedBackByorderid(String orderid){
        if(!StringUtils.isEmpty(orderid)){
            return netOrderServiceImpl.getFeedBackByorderid(orderid);
        }else{
            return null;
        }
    }







}
