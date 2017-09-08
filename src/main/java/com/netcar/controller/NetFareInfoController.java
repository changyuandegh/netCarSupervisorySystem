package com.netcar.controller;

import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.FareInfoData;
import com.netcar.service.NetFareInfoService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 运价信息
 * Created by Administrator on 2017/6/14.
 */
@Controller
@RequestMapping( value="/fare")
public class NetFareInfoController {

    @Autowired
    private NetFareInfoService netFareInfoServiceImpl;

    @RequestMapping(value="/list")
    public String list(){
        return "/market/fareInfo";
    }

    @RequestMapping(value = "/findFareInfoData")
    @ResponseBody
    public BaseTable findFareInfo(String company,String areacode,String stime,String etime,int limit,int offset){
        BaseTable baseTable=null;
        if(StringUtils.isEmpty(company)&&StringUtils.isEmpty(areacode)&&StringUtils.isEmpty(stime)&&StringUtils.isEmpty(stime)){
            return null;
        }else {
            baseTable=netFareInfoServiceImpl.findFareInfo(company,areacode,stime,etime,limit,offset);
        }
        System.out.print("====================================");
        return baseTable;
    }
    @RequestMapping(value = "/findFareInfoDatail")
    @ResponseBody
    public FareInfoData findFareInfoDatail(HttpServletRequest request,HttpServletResponse responsey) throws IOException {
        FareInfoData fareLis=null;
        String fareid=request.getParameter("fareid");
        if(!StringUtils.isEmpty(fareid)){
            fareLis=netFareInfoServiceImpl.findFareInfoDatail(fareid);
        }
        return fareLis;
    }

}
