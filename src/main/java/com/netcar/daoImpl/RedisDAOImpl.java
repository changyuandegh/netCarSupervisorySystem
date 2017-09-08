package com.netcar.daoImpl;

import com.netcar.dao.RedisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;



@Repository
public class RedisDAOImpl implements RedisDAO {

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public String findString(String key) {
        return  redisTemplate.opsForValue().get(key).toString();
    }


    /**
     * 获取hash类型数据
     * @param key
     * @return
     */
    @Override
    public Map<Object,Object> findHash(String key) {
        Map<Object ,Object> maps=  redisTemplate.opsForHash().entries(key);
        return maps;
    }



//    public LocationPoint getLocationPointBykey(String key){
//        try{
//            Map<Object ,Object> obj=redisTemplate.opsForHash().entries(key);
//            LocationPoint point =new LocationPoint();
//            if(obj!=null&&obj.size()!=0){
//                //LocationPoint point =new LocationPoint();
//                point.setCarId(obj.get("carId").toString());
//                point.setDeviceId(obj.get("deviceId").toString());
//                point.setDirection(obj.get("direction").toString());
//                point.setDriverId(obj.get("driverId").toString());
//                point.setlTime(obj.get("lTime").toString());
//                point.setSpeed(obj.get("speed").toString());
//                // 坐标转换(真实转百度)
//                double[] pt = PointTransfor.wgs2BD09(Double.parseDouble(obj.get("latitude").toString()),Double.parseDouble(obj.get("longitude").toString()));
//                point.setLatitude(Double.toString(pt[0]));
//                point.setLongitude(Double.toString(pt[1]));
//                point.setIsOnLine(obj.get("isOnLine").toString());
//                point.setUpTime(obj.get("upTime").toString());
//
//            }
//            return point;
//        }catch(Exception e){
//            e.printStackTrace();
//            return null;
//        }
//
//    }


    /**
     * 获取Set类型数据
     * @param key
     * @return
     */
    public Set<Object> getSet(String key){
        return  redisTemplate.opsForSet().members(key);
    }




}
