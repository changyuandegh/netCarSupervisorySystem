package com.netcar.service;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.entity.NetCompanybaseinfo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mander on 2017/5/2.
 */
public interface NetCompanybaseinfoService {



    List<NetCompanybaseinfo> findAll(int limit, int offset);


    /**
     * 查询所有公司
     * @param limit 显示总条数
     * @param offset 从第offset条开始
     * @param areacode 行政区划编号
     * @return
     */
    BaseTable findAll(int limit,int offset,int areacode, String sort);


    BaseTable findByParm(String parm,String value,int limit,int offset,int areacode, String sort);


    /**
     *
     *

     *
     */

    /**
     * 按地区查询公司id,name
     * @param areacode 地区编码
     * AjaxMessage.id=netcompanyid;
     * AjaxMessage.name=comapnyname;
     * @return
     */
    List<AjaxMessage> findidNameByareacode(String areacode);



    /**
     * 按地区查询公司idc,name
     * @param areacode 地区编码
     * AjaxMessage.id=netcompanyidc;
     * AjaxMessage.name=comapnyname;
     * @return
     */
    List<AjaxMessage> findidcNameByareacode(String areacode);


    String findIdcNameAuthing();

    List<AjaxMessage> findCompanyAuthInterfaceState(String companyidc);

    List<HashMap<String,Object>> findCompanyidcleagPhoto(String companyidc);
}
