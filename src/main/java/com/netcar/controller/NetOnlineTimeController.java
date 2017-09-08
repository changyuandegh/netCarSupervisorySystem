package com.netcar.controller;

import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.DriverOnlineTime;
import com.netcar.service.NetDriverOnlineTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 司机在线时长
 * Created by Administrator on 2017/6/13.
 */
@Controller
@RequestMapping(value ="/onlinetime")
public class NetOnlineTimeController {

    @Autowired
    private NetDriverOnlineTimeService netDriverOnlineTimeServiceImpl;

    @RequestMapping(value = "/list")
    private String list(){
        return "/onlinetime/onlinetime";
    }

    @RequestMapping(value = "/selectOnlineTime")
    @ResponseBody
    public BaseTable findOnlinTime(String search,String stime,String  etime,String company,String areacode){
        BaseTable baseTable =null;
        baseTable=netDriverOnlineTimeServiceImpl.findOnlinTime(search,stime,etime,company,areacode);
        return baseTable;
    }
}
