package com.netcar.serviceImpl;

import com.netcar.dao.NetCarbaseinfoDAO;
import com.netcar.dao.NetRedisDAO;
import com.netcar.dao.RedisDAO;
import com.netcar.dataModle.AjaxMessage;
import com.netcar.dataModle.Devicegps;
import com.netcar.entity.NetCarbaseinfo;
import com.netcar.entity.NetDevicegps;
import com.netcar.service.NetCarGpsService;
import com.netcar.tools.CoordinateConvert;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Mander on 2017/5/18.
 */
@Service
public class NetGpsServiceImpl implements NetCarGpsService {


    /**
     * 地区与车牌前缀的对应
     */
    private static List<AjaxMessage> areacodeRsCar;
    static {
//        AjaxMessage ajaxMessage1=new AjaxMessage();
//        ajaxMessage1.setName("豫A");
//        ajaxMessage1.setDesc("410101");
//        areacodeRsCar.add(ajaxMessage1);
//        AjaxMessage ajaxMessage2=new AjaxMessage();
//        ajaxMessage2.setName("豫B");
//        ajaxMessage2.setDesc("410301");
//        areacodeRsCar.add(ajaxMessage2);
    }

    @Autowired
    private NetRedisDAO netRedisDAOImpl;

    @Autowired
    NetCarbaseinfoDAO netCarbaseinfoDAOImpl;

    @Autowired
    private  RedisDAO redisDAOImpl;


    @Override
    public Devicegps findGPSByAreacodeVehicleno(String areacode, String vehicleno) {
        //areacode=410000省
        //areacode=410100市
        //areacode=410101县/区
        //areacode=410301县/区 410302
        //"net:device:gps:410101:豫AT0003"
        NetCarbaseinfo info = netCarbaseinfoDAOImpl.findByCarNum(areacode, vehicleno);
        if (info == null) return null;
        String key = "net:device:gps:410101:"+vehicleno;
        //key += info.getAddress() + ":" + vehicleno;
  //      Map<Object, Object> obj = netRedisDAOImpl.findHash(key);
        // 坐标转换(真实转百度)

        //410000
//
//        String key="net:device:gps:410101:"+vehicleno;
//        //key+=areacode+":"+vehicleno;
//
        Devicegps gps =new Devicegps();
        Map<Object ,Object> obj=redisDAOImpl.findHash(key);
//
            if(obj!=null&&obj.size()!=0) {
                gps.setAlarm(Integer.parseInt(obj.get("alarm").toString()));
                gps.setDeviceid(obj.get("deviceid").toString());
                gps.setDirection(Double.parseDouble(obj.get("direction").toString()));
                gps.setIsfull(Integer.parseInt(obj.get("isfull").toString()));
                gps.setIslocate(Integer.parseInt(obj.get("islocate").toString()));
                gps.setIsonline(Integer.parseInt(obj.get("isonLine").toString()));

                double lat = Double.parseDouble(obj.get("latitude").toString());
                double lng = Double.parseDouble(obj.get("longitude").toString());
                double[] latlng = CoordinateConvert.wgs2BD09(lat, lng);
                gps.setLatitude(latlng[0]);
                gps.setLongitude(latlng[1]);

//                gps.setLatitude(Double.parseDouble(obj.get("latitude").toString()));
//                gps.setLongitude(Double.parseDouble(obj.get("longitude").toString()));

                gps.setLtime(obj.get("lTime").toString());
                gps.setSosalarm(Integer.parseInt(obj.get("sosalarm").toString()));
                gps.setSpeed(Double.parseDouble(obj.get("speed").toString()));
                gps.setStatus(Integer.parseInt(obj.get("status").toString()));
                gps.setVehicleno(vehicleno);
                gps.setUptime(obj.get("uptime").toString());


//                double[] pt = PointTransfor.wgs2BD09(Double.parseDouble(obj.get("latitude").toString()),Double.parseDouble(obj.get("longitude").toString()));
//                point.setLatitude(Double.toString(pt[0]));
//                point.setLongitude(Double.toString(pt[1]));
//                point.setIsOnLine(obj.get("isOnLine").toString());
//                point.setUpTime(obj.get("upTime").toString());
            }
        //if (obj == null) return null;
        return gps;// map2dv(obj);
    }

    /**
     * 获取某地区车辆定位信息
     * @param areaCode
     * @return
     */
    @Override
    public List<Devicegps> findGPSByAreacode(String areaCode) {
        List<Map<Object, Object>> list = netRedisDAOImpl.getDeviceLocation(areaCode);
        if (list == null) return null;
        List<Devicegps> devicegpsList = new ArrayList<>();
        for (Map<Object, Object> obj : list) {
            if (obj.toString().equals("{}")) continue;
            if (obj != null && obj.size() != 0)
                devicegpsList.add(map2dv(obj));
        }
        return devicegpsList;
    }

    /**
     * 获取地区某公司在线车辆定位信息
     *
     * @param areaCode
     * @param companyidc
     * @return
     */
    @Override
    public List<Devicegps> findGPSByAreaCompany(String areaCode, String companyidc) {
        List<Map<Object, Object>> list = netRedisDAOImpl.getDeviceLocationByCompany(areaCode, companyidc);
        if (list == null) return null;
        List<Devicegps> devicegpsList = new ArrayList<>();
        for (Map<Object, Object> obj : list) {
            if (obj.toString().equals("{}")) continue;
            if (obj != null && obj.size() != 0)
                devicegpsList.add(map2dv(obj));
        }
        return devicegpsList;
    }


    private Devicegps map2dv(Map<Object, Object> obj) {
        try {
            Devicegps gps = new Devicegps();
            gps.setAlarm(Integer.parseInt(obj.get("alarm").toString()));
            gps.setDeviceid(obj.get("deviceid").toString());
            gps.setDirection(Double.parseDouble(obj.get("direction").toString()));
            gps.setIsfull(Integer.parseInt(obj.get("isfull").toString()));
            gps.setIslocate(Integer.parseInt(obj.get("islocate").toString()));
            gps.setIsonline(Integer.parseInt(obj.get("isonLine").toString()));
            double lat = Double.parseDouble(obj.get("latitude").toString());
            double lng = Double.parseDouble(obj.get("longitude").toString());
            double[] latlng = CoordinateConvert.wgs2BD09(lat, lng);
            gps.setLatitude(latlng[0]);
            gps.setLongitude(latlng[1]);
//            gps.setLatitude(Double.parseDouble(obj.get("latitude").toString()));
//            gps.setLongitude(Double.parseDouble(obj.get("longitude").toString()));
            gps.setLtime(obj.get("lTime").toString());
            gps.setSosalarm(Integer.parseInt(obj.get("sosalarm").toString()));
            gps.setSpeed(Double.parseDouble(obj.get("speed").toString()));
            gps.setStatus(Integer.parseInt(obj.get("status").toString()));
//                gps.setVehicleno(vehicleno);
            gps.setUptime(obj.get("uptime").toString());
            System.out.println(gps.toString());
            return gps;
        } catch (Exception e) {

        }
        return null;

    }


}
