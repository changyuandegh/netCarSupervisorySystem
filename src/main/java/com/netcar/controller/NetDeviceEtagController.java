package com.netcar.controller;

import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.ShowDevice;
import com.netcar.entity.NetDevice;
import com.netcar.entity.NetEtag;
import com.netcar.service.NetDeviceInfoService;
import com.netcar.service.NetETagInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Mander on 2017/6/2.
 * 设备
 */
@Controller
@RequestMapping(value = "/deviceEtag")
public class NetDeviceEtagController {

    @Autowired
    private NetDeviceInfoService netDeviceInfoServiceImpl;

    @Autowired
    private NetETagInfoService netETagInfoServiceImpl;


    @RequestMapping(value = "/list")
    private String deviceEtag(){

        return "netcar/deviceEtag";
    }

    @RequestMapping(value = "/findDeviceByParm")
    @ResponseBody
    private BaseTable findDeviceAll(String parameter ,String value,String areacode,String sort, String limit,String offset){
        BaseTable table=new BaseTable();
        if (!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(limit)&&!StringUtils.isEmpty(offset)){
            if(StringUtils.isEmpty(value)){
             table= netDeviceInfoServiceImpl.findAll(areacode,sort,Integer.parseInt(limit),Integer.parseInt(offset));
            }else{
                table= netDeviceInfoServiceImpl.findByCarInfo(areacode,parameter,value,sort,Integer.parseInt(limit),Integer.parseInt(offset));
            }
        }
        return  table;
    }


    @RequestMapping(value = "/findEtagByParm")
    @ResponseBody
    private BaseTable findEtagByParm(String parameter ,String value,String areacode,String sort, String limit,String offset){
        BaseTable table=new BaseTable();
        if (!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(limit)&&!StringUtils.isEmpty(offset)){
            if(StringUtils.isEmpty(value)){
                table= netETagInfoServiceImpl.findAll(areacode,sort,Integer.parseInt(limit),Integer.parseInt(offset));
            }else{
                table= netETagInfoServiceImpl.findByCarInfo(areacode,parameter,value,sort,Integer.parseInt(limit),Integer.parseInt(offset));
            }
        }
        return  table;
    }


    @RequestMapping(value = "/deleteEtag")
    @ResponseBody
    private AjaxMessage deleteEtag(String etagid){
        AjaxMessage ajaxMessage=new AjaxMessage("success","删除成功");
        if(StringUtils.isEmpty(etagid)){
            if(!netETagInfoServiceImpl.delete(etagid)){
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("删除失败");
            }
        }else{
            ajaxMessage.setName("error");
            ajaxMessage.setDesc("删除失败");
        }
        return  ajaxMessage;
    }


    @RequestMapping(value = "/deleteDevice")
    @ResponseBody
    private AjaxMessage deleteDevice(String deviceid){
        AjaxMessage ajaxMessage=new AjaxMessage("success","删除成功");
        if(!StringUtils.isEmpty(deviceid)){
            if(!netDeviceInfoServiceImpl.delete(deviceid)){
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("删除失败");
            }
        }else{
            ajaxMessage.setName("error");
            ajaxMessage.setDesc("删除失败");
        }
        return  ajaxMessage;
    }

    @RequestMapping(value = "/updateDevice")
    @ResponseBody
    private AjaxMessage updateDevice(String deviceid,String brand,String model,String imei,String sim,String installdate,String createtime){
        AjaxMessage ajaxMessage=new AjaxMessage("success","修改成功");
        try {
            SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
            NetDevice netDevice=new NetDevice();
            netDevice.setDeviceid(Long.decode(deviceid));
            netDevice.setBrand(brand);
            netDevice.setModel(model);
            netDevice.setImei(imei);
            netDevice.setSim(sim);
            netDevice.setInstalldate(new Date(formatdate.parse(installdate).getTime()));
            netDevice.setCreatetime(Timestamp.valueOf(createtime));
            netDevice.setUpdatetime(new Timestamp(System.currentTimeMillis()));
            if(!netDeviceInfoServiceImpl.edit(netDevice)){
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("修改失败");
            }
        }catch (Exception e){
            ajaxMessage.setName("error");
            ajaxMessage.setDesc("修改失败");
        }
        return  ajaxMessage;
    }

    @RequestMapping(value = "/updateEtag")
    @ResponseBody
    private AjaxMessage updateEtag(String etagid,String brand,String model,String imei,String installdate,String createtime){
        AjaxMessage ajaxMessage=new AjaxMessage("success","修改成功");
        try {
            SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
            NetEtag etag=new NetEtag();
            etag.setEtagid(etagid);
            etag.setBrand(brand);
            etag.setModel(model);
            etag.setImei(imei);
            etag.setInstalldate(new Date(formatdate.parse(installdate).getTime()));
            etag.setCreatetime(Timestamp.valueOf(createtime));
            etag.setUpdatetime(new Timestamp(System.currentTimeMillis()));
            if(!netETagInfoServiceImpl.edit(etag)){
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("修改失败");
            }
        }catch (Exception e){
            ajaxMessage.setName("error");
            ajaxMessage.setDesc("修改失败");
        }
        return  ajaxMessage;
    }

    @RequestMapping(value = "/addDevice")
    @ResponseBody
    private AjaxMessage  addDevice(String vechileno,String deviceid,String brand,String model,String imei,String sim,String installdate,String createtime){
        AjaxMessage ajaxMessage=new AjaxMessage("success","添加成功");
        try {
            SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formattime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            NetDevice netDevice=new NetDevice();

            if(!StringUtils.isEmpty(vechileno)&&!StringUtils.isEmpty(deviceid)&&!StringUtils.isEmpty(brand)&&!StringUtils.isEmpty(model)&&!StringUtils.isEmpty(imei)&&!StringUtils.isEmpty(sim)&&!StringUtils.isEmpty(installdate)){


            netDevice.setDeviceid(Long.parseLong(deviceid));
            netDevice.setBrand(brand);
            netDevice.setModel(model);
            netDevice.setImei(imei);
            netDevice.setSim(sim);
            netDevice.setInstalldate(new Date(formatdate.parse(installdate).getTime()));
            netDevice.setCreatetime(new Timestamp(System.currentTimeMillis()));
            netDevice.setUpdatetime(new Timestamp(System.currentTimeMillis()));

            if(!netDeviceInfoServiceImpl.add(netDevice,vechileno)){
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("操作失败!");
            }
            }else{
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("有空输入项!");
            }
        }catch (Exception e){
            ajaxMessage.setName("error");
            ajaxMessage.setDesc("添加失败,请重试!");
        }
        return ajaxMessage;
    }


    @RequestMapping(value = "/addEtag")
    @ResponseBody
    private AjaxMessage  addEtag(String vechileno,String etagid,String brand,String model,String imei,String installdate){
        AjaxMessage ajaxMessage=new AjaxMessage("success","添加成功");
        try {
            SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formattime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            if(!StringUtils.isEmpty(vechileno)&&!StringUtils.isEmpty(etagid)&&!StringUtils.isEmpty(brand)&&!StringUtils.isEmpty(model)&&!StringUtils.isEmpty(imei)&&!StringUtils.isEmpty(installdate)){

                NetEtag netEtag=new NetEtag();
                netEtag.setEtagid(etagid);
                netEtag.setBrand(brand);
                netEtag.setModel(model);
                netEtag.setImei(imei);
                netEtag.setInstalldate(new Date(formatdate.parse(installdate).getTime()));
                netEtag.setCreatetime(new Timestamp(System.currentTimeMillis()));
                netEtag.setUpdatetime(new Timestamp(System.currentTimeMillis()));

                if(!netETagInfoServiceImpl.add(netEtag,vechileno)){
                    ajaxMessage.setName("error");
                    ajaxMessage.setDesc("操作失败!");
                }
            }else{
                ajaxMessage.setName("error");
                ajaxMessage.setDesc("有空输入项!");
            }
        }catch (Exception e){
            ajaxMessage.setName("error");
            ajaxMessage.setDesc("操作失败!");
        }
        return ajaxMessage;
    }





}
