package com.netcar.dao;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.entity.NetCompanybaseinfo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mander on 2017/5/2.
 */
public interface NetCompanybaseinfoDAO {



    /**
     * 根据字段参数查询
     * @param address 行政区划代码
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    List<NetCompanybaseinfo> findAll(String address, String sort, int limit, int offset);


    /**
     * 根据字段参数查询
     * @param address 行政区划代码
     * @param parm 字段名
     * @param value 字段值
     * @param sort 排序字段名
     * @param limit  总条数
     * @param offset 开始条数
     * @return
     */
    List<NetCompanybaseinfo> findAllByParm(String address,String parm,String value, String sort, int limit,int offset);



    /**
     *
     * @param address 行政区划代码
     * @return
     */
    int findAllCount(String address);

    /**
     *
     * @param address 行政区划代码
     * @param parm 字段名
     * @param value 字段值
     * @return
     */
    int findByParmCount(String address, String parm, String value);

    /**
     * 按地区查询公司id,name
     * @param address
     * @return
     */
    List<AjaxMessage> findidNameByareacode(String address);



    /**
     * 按地区查询公司idc,name
     * @param areacode
     * @return
     */
    List<AjaxMessage> findidcNameByareacode(String areacode);

    String findIdcNameAuthing();

    List<AjaxMessage> findCompanyAuthInterfaceState(String companyidc);

    List<HashMap<String,Object>> findCompanyidcleagPhoto(String companyidc);
}
