package com.netcar.controller;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.service.NetAuthorityService;
import com.netcar.service.NetCompanybaseinfoService;
import com.netcar.service.NetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mander on 2017/4/25.
 * 平台公司控制器
 */

@Controller
@RequestMapping(value = "/netcompany")
public class NetCompanyController {


    @Autowired
    private NetUserService netUserServiceImpl;

    @Autowired
    private NetAuthorityService netAuthorityServiceImpl;

    @Autowired
    private  NetCompanybaseinfoService netCompanybaseinfoServiceImpl;

    /**
     * 进入
     * @return
     */
    @RequestMapping(value = "/list")
    private String list() {
        return "netcompany/company";
    }






    /**
     * 条件查询
     * @param search
     * @param parameter
     * @param limit
     * @param offset
     * @param areacode
     * @param order
     * @return
     */
    @RequestMapping(value = "/findByParm")
    @ResponseBody
    private BaseTable findByParm(String search,String parameter,int limit,int offset,int areacode,String order){
        System.out.println(search+"="+parameter+"="+limit+"="+offset+"="+areacode+"="+order);
        BaseTable table=null;
        if(!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(order)){
            if(StringUtils.isEmpty(search)){
                table=netCompanybaseinfoServiceImpl.findAll(limit,offset, areacode, order);
            }else{
                table=netCompanybaseinfoServiceImpl.findByParm(parameter,search,limit,offset,areacode,order);
            }
        }
        return  table;
    }


    @RequestMapping(value= "/findByareacode")
    @ResponseBody
    private List<AjaxMessage> findbyareacode(String areacode){
        List<AjaxMessage> list=new ArrayList<>();
        if(!StringUtils.isEmpty(areacode)){
              list= netCompanybaseinfoServiceImpl.findidcNameByareacode(areacode);
        }
        return list;
    }



}
