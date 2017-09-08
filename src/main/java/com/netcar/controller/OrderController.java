package com.netcar.controller;

import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetOrder;
import com.netcar.service.NetOrderService;
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
@RequestMapping(value = "/order2")
public class OrderController {

    @Autowired
    private  NetOrderService netOrderServiceImpl;

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

    //订单明细
    @RequestMapping(value="/findorderDatail")
    @ResponseBody
    public BaseTable findOrderDatail(String search,String parameter,int limit,int offset,String areacode,String order, String stime, String etime,String company){
        BaseTable table=null;
        //首次进入如果为空不查询
        if(StringUtils.isEmpty(search)&&StringUtils.isEmpty(parameter) && StringUtils.isEmpty(order) && StringUtils.isEmpty(areacode) && StringUtils.isEmpty(stime)&& StringUtils.isEmpty(etime)&& StringUtils.isEmpty(company)){
                return null;
        }else {
            table=netOrderServiceImpl.findOrderDatail(parameter,limit,offset,areacode,search,stime,etime,company);
            }
        return table;
    }
}
