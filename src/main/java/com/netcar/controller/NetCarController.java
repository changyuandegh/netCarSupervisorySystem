package com.netcar.controller;

import com.netcar.dataModle.*;
import com.netcar.entity.NetCarbaseinfo;
import com.netcar.entity.NetElectricfence;
import com.netcar.entity.NetUser;
import com.netcar.service.NetAuthorityService;
import com.netcar.service.NetCarbaseinfoService;
import com.netcar.service.NetElectricfenceService;
import com.netcar.service.NetUserService;
import com.netcar.tools.ContextData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mander on 2017/4/25.
 * 用户控制器
 */

@Controller
@RequestMapping(value = "/netcar")
public class NetCarController {


    @Autowired
    private NetUserService netUserServiceImpl;

    @Autowired
    private NetAuthorityService netAuthorityServiceImpl;

    @Autowired
    private  NetCarbaseinfoService netCarbaseinfoServiceImpl;

    @Autowired
    private NetElectricfenceService netElectricfenceServiceImpl;

    /**
     * 进入
     * @return
     */
    @RequestMapping(value = "/list")
    private String list() {

        return "netcar/car";
    }


    @RequestMapping(value = "/findByParm")
    @ResponseBody
    private BaseTable findByParm(String search,String parameter,int limit,int offset,String areacode,String order){
        BaseTable table=null;
        if(!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(order)){
            if(StringUtils.isEmpty(search)){
                table= netCarbaseinfoServiceImpl.findAll(areacode,order,limit,offset);
            }else{
                table=netCarbaseinfoServiceImpl.findByParm(areacode,parameter,search,order,limit,offset);
            }
        }
        return  table;
    }


    /**
     * 根据地区插叙车辆
     * @param areacode
     * @param vehicheno
     * AjaxMessage.id=carid;
     * AjaxMessage.name=vehicleno;
     * @return
     */
    @RequestMapping(value = "/findByaAreaVehicheno")
    @ResponseBody
    private List<AjaxMessage> findByareacodeCarName(String areacode,String vehicheno){
     if(!StringUtils.isEmpty(areacode)&&!StringUtils.isEmpty(vehicheno)){
      return   netCarbaseinfoServiceImpl.findidNameby(areacode,vehicheno);
     }else{
         return null;
     }
    }




    /**
     * 历史报警
     * @return
     */
    @RequestMapping(value = "/history")
    private String historyAlarm(){
        return "alarm/historyAlarm";
    }


    /**
     * 进入轨迹页面
     * @return
     */
    @RequestMapping(value = "/trance")
    private String carTrance(){

        return "controRoom/trance";
    }

    /**
     * 进入车辆监控
     * @return
     */
    @RequestMapping(value = "/monitor")
    private String monitor(){
        return "controRoom/monitor";
    }





    /**
     * 获取根据车牌获取历史驾驶司机
     * @param vehicleno
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping(value = "/getByVehiclenoTime")
    @ResponseBody
    private Cardriver getByVehiclenoTime(String address,String vehicleno,String starttime,String endtime){
        Cardriver cardriver=new  Cardriver();
        if(!StringUtils.isEmpty(vehicleno)&&!StringUtils.isEmpty(starttime)&&!StringUtils.isEmpty(endtime)){
            cardriver= netCarbaseinfoServiceImpl.findbyVehicleno(address,vehicleno,starttime,endtime);
        }
        return  cardriver;
    }

    /**
     * 轨迹查询
     * @param vehicleno
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping(value = "/getDevicegps")
    @ResponseBody
    private List<ShowGps> getDevicePgs(String vehicleno,String starttime,String endtime){
        List<ShowGps> showGpsList=new ArrayList<>();
        if(!StringUtils.isEmpty(vehicleno)&&!StringUtils.isEmpty(starttime)&&!StringUtils.isEmpty(endtime)){
           showGpsList= netCarbaseinfoServiceImpl.getDevicePgs(vehicleno,starttime,endtime);
        }
       return showGpsList;
    }






    /******************车辆围栏****************/



//    @RequestMapping(value ="/findfence")
//    @ResponseBody
//    private BaseTable findfencePage(String address,String parm,String value,Integer limit,Integer offset){
//        BaseTable table=new BaseTable();
//        if(!StringUtils.isEmpty(address)&&!StringUtils.isEmpty(limit.toString())&&!StringUtils.isEmpty(offset.toString())){
//            if(StringUtils.isEmpty(value)){
//                table=netElectricfenceServiceImpl.findAll(address,limit,offset);
//            }else{
//                table=netElectricfenceServiceImpl.findByParam(address,parm,value,limit,offset);
//            }
//        }
//       return  table;
//    }
//
//
//    @RequestMapping(value ="/addFence")
//    @ResponseBody
//    private AjaxMessage addFence(String name,String address,String type,String shape,String radius,List points,String startdate,String stopdate, HttpServletRequest request, HttpServletResponse response){
//        AjaxMessage ajaxMessage=new AjaxMessage();
//
//        if (!StringUtils.isEmpty(name)&&!StringUtils.isEmpty(address)&&!StringUtils.isEmpty(type)&&!StringUtils.isEmpty(shape)&&!StringUtils.isEmpty(radius)&&points!=null&&points.size()!=0&&!StringUtils.isEmpty(startdate)&&!StringUtils.isEmpty(stopdate)){
//            NetElectricfence netElectricfence=new NetElectricfence();
//
//
//
//            NetUser netUser=(NetUser) request.getSession().getAttribute(ContextData.loginuser);
//            netElectricfence.setCreatorid(netUser.getId());
//            netElectricfence.setCreatetime(new Timestamp(System.currentTimeMillis()));
//            netElectricfence.setUpdatetime(new Timestamp(System.currentTimeMillis()));
//            netElectricfence.setState(0);
//           boolean reg=true;// netElectricfenceServiceImpl.add(netElectricfence);
//            if(reg){
//                ajaxMessage.setName("success");
//                ajaxMessage.setName("添加成功");
//            }else{
//                ajaxMessage.setName("error");
//                ajaxMessage.setName("添加失败");
//            }
//        }
//        return ajaxMessage;
//    }



    public static void main(String[] args) {
        String string="2017-05-19";
        Timestamp.valueOf("");

    }


}
