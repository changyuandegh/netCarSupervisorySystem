package com.netcar.controller;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetUser;
import com.netcar.service.NetCarbaseinfoService;
import com.netcar.service.NetCompanyAuthService;
import com.netcar.service.NetCompanybaseinfoService;
import com.netcar.service.NetDriverbaseinfoService;
import com.netcar.tools.ContextData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mander on 2017/7/4.
 * 在线认证模块
 */
@RequestMapping(value = "/auth")
@Controller
public class AuthController {

    private static Logger logger = Logger.getLogger(AuthController.class);

    @Autowired
    private NetCompanybaseinfoService netCompanybaseinfoServiceImpl;

    @Autowired
    private NetCompanyAuthService netCompanyAuthServiceImpl;

    @Autowired
    private ContextData contextData;

    @Autowired
    private NetCarbaseinfoService netCarbaseinfoServiceImpl;

    @Autowired
    private NetDriverbaseinfoService netDriverbaseinfoServiceImpl;


    /**
     * 进入在线认证
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/companyAuth")
    private String onlineAuth(HttpServletResponse response, HttpServletRequest request) {
        Object object = request.getSession().getAttribute(ContextData.loginuser);
        if (object != null) {
            NetUser netUser = (NetUser) object;
            //获取正在认证的公司(system和公司本身用户才能获取到)
            String companyidc = netCompanybaseinfoServiceImpl.findIdcNameAuthing();
            request.setAttribute("companyidc", companyidc);

//            if (netUser.getName().equals("system")) {
//
//            } else {
//                String companyidc = netCompanybaseinfoServiceImpl.findIdcNameAuthingBycompanyid(netUser.getCompanyid());
//                request.setAttribute("companyidc", companyidc);
//            }

        }

        return "auth/auth";
    }


//select ca.checked,f.interfacename from net_company_auth  ca  INNER join net_interfaceinfo f on ca.interfaceid=f.id where ca.companyidc='shenzhou410101';

    /**
     * 根据公司idc获取接口认证状态
     * ajaxMessage.name=接口名称;
     * ajaxMessage.desc=认证状态;
     *
     * @return
     */
    @RequestMapping(value = "/getCompanyAuthInterfaceState")
    @ResponseBody
    private List<AjaxMessage> findCompanyAuthInterfaceState(String companyidc, HttpServletRequest request, HttpServletResponse response) {
        List<AjaxMessage> list = new ArrayList<>();
        AjaxMessage ajaxMessage = new AjaxMessage();
        if (!StringUtils.isEmpty(companyidc)) {
            list = netCompanybaseinfoServiceImpl.findCompanyAuthInterfaceState(companyidc);
        }
        boolean reg_fileInterface=true;//文件接口状态

        //判断状态是否通过,如果通过则判断基础数据的文件是否存在,不存在或不一致则显示不通过
        //一.司机基础信息接口,照片,驾驶证扫描证件照[d.licenseid,d.licensephotoid,d.photoid ]
        List<HashMap<String,Object>> drivers =netDriverbaseinfoServiceImpl.findlicenseidAllPic(companyidc);
        //二.公司基础信息接口,法人身份证扫描照片[ l.legalphoto,c.companyidc]
        List<HashMap<String,Object>> companys=netCompanybaseinfoServiceImpl.findCompanyidcleagPhoto(companyidc);
        //三.车辆照片[vehicleno,photoId ]
        List<HashMap<String,Object>> cars= netCarbaseinfoServiceImpl.findVehiclePhoto(companyidc);
        File file=null;
        for (HashMap<String,Object> driver :drivers){
            if(!StringUtils.isEmpty(driver.get("photoid"))){
                file=new File(contextData.getBaseinfoDriverPhotoId()+"/"+driver.get("photoid")+".jpg");
                if(!file.isFile()){
                    reg_fileInterface=false;
                    //驾驶员基本信息接口不通过
                    logger.info("警告:司机照片=[驾驶证号]"+driver.get("licenseid")+"[照片]"+driver.get("photoid")+".jpg");
                }
            }
            if(!StringUtils.isEmpty(driver.get("licensephotoid"))){
                file=new File(contextData.getBaseinfoDriverLicensePhotoId()+"/"+driver.get("licensephotoid")+".jpg");
                if(!file.isFile()){
                    reg_fileInterface=false;
                    //驾驶员基本信息接口不通过
                    logger.info("警告:驾驶证扫描件=[驾驶证号]"+driver.get("licenseid")+"[证件扫描照]"+driver.get("licensephotoid")+".jpg");
                }
            }
        }

        for (HashMap<String,Object> company :companys){
            if(!StringUtils.isEmpty(company.get("legalphoto"))){
                file=new File(contextData.getBaseinfoCompanyLeagPhoto()+"/"+company.get("legalphoto")+".jpg");
                if(!file.isFile()){
                    reg_fileInterface=false;
                    //平台基本信息接口不通过  .legalphoto,c.companyidc
                    logger.info("警告:法人照片=[companyidc]"+company.get("companyidc")+"[法人证件扫描照]"+company.get("legalphoto")+".jpg");
                }
            }
        }

        for (HashMap<String,Object> car :cars){
            if(!StringUtils.isEmpty(car.get("photoId"))){
                file=new File(contextData.getBaseinfoVehiclePhotoId()+"/"+car.get("photoId")+".jpg");
                if(!file.isFile()){
                    reg_fileInterface=false;
                    //平台基本信息接口不通过vehicleno,photoId
                    logger.info("警告:车辆照片=[vehicleno]"+car.get("vehicleno")+"[车辆照]"+car.get("photoId")+".jpg");
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("文件接口")){
                if(!reg_fileInterface){
                    list.get(i).setDesc("false");
                    break;
                }else{
                    list.get(i).setDesc("true");
                }
            }
        }
        return list;
    }





    /**
     * 根据companyidc获取所有司机照片
     * @param companyidc
     */
    private void findlicenseidLicensePhotoid(String companyidc) {



    }


    /**
     * 添加companyidc
     */
    @RequestMapping(value = "/addCompanyidc")
    @ResponseBody
    private AjaxMessage addComapnyidc(String companyidc, HttpServletRequest request, HttpServletResponse response) {
        AjaxMessage ajaxMessage = new AjaxMessage();
        try {
            if (!StringUtils.isEmpty(companyidc)) {
                ajaxMessage = netCompanyAuthServiceImpl.addCompanyAuth(companyidc);
            } else {
                ajaxMessage.setName("fail");
                ajaxMessage.setDesc("输入为空");
            }
        } catch (Exception e) {

        }
        return ajaxMessage;
    }


    @RequestMapping(value = "/hisAuth")
    private String toHistAuth(HttpServletRequest request, HttpServletResponse response) {
        //
        NetUser netUser = (NetUser) request.getSession().getAttribute(ContextData.loginuser);
        //获取自身companyidc
        //        if(!StringUtils.isEmpty(netUser.getCompanyid())){
        //            List<Object> companyids= netCompanybaseinfoServiceImpl.findCompanyidcBycompanyid(netUser.getCompanyid());
        //            request.setAttribute("companyidcs",companyids);
        //        }else if(netUser.getName().equals("system")){
        //
        //        }
        //系统列出所有认证companyidc
        List<Object> companyids = netCompanyAuthServiceImpl.findAllCompanyidc();
        request.setAttribute("companyidcs", companyids);
        return "auth/historyAuth";
    }


    @RequestMapping(value = "/findHisAuthToTableByCompanyidc")
    @ResponseBody
    private BaseTable findHisAuthToTableBy(String companyidc, Integer limit, Integer offset) {
        BaseTable table = new BaseTable();
        if (!StringUtils.isEmpty(companyidc)) {
            table = netCompanyAuthServiceImpl.findHisAuthToTableBy(companyidc, limit, offset);
        }
        return table;
    }


}
