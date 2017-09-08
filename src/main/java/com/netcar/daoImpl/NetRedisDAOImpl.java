package com.netcar.daoImpl;

import com.netcar.dao.NetCarbaseinfoDAO;
import com.netcar.dao.NetRedisDAO;
import com.netcar.entity.NetCarbaseinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Work on 2017/5/18.
 */
@Repository
public class NetRedisDAOImpl implements NetRedisDAO {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    NetCarbaseinfoDAO netCarbaseinfoDAOImpl;

    @Override
    public String findString(String key) {
        return redisTemplate.opsForValue().get(key).toString();
    }


    /**
     * 获取hash类型数据
     *
     * @param key
     * @return
     */
    @Override
    public Map<Object, Object> findHash(String key) {
        Map<Object, Object> maps = redisTemplate.opsForHash().entries(key);
        return maps;
    }


    @Override
    public Set findKey(String key) {
        return redisTemplate.keys(key);
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
    public Set<Object> getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }


    @Override
    public int getOnlineDevice(String areaCode) {
        int count = 0;
        String ptn = "net:device:devnums:";
        ptn += areaCode.substring(2, 6).equals("0000") ? areaCode.substring(0, 2) + "*" : (areaCode.substring(4, 6).equals("00") ? areaCode.substring(0, 4) + "*" : areaCode);
        Set set = redisTemplate.keys(ptn);
        if (set != null || set.size() > 0) {
            for (Object obj : set) {
                count += Integer.parseInt(redisTemplate.opsForValue().get(obj).toString());
            }
        }
        return count;
    }

    /**
     * 获取某地区在线车辆定位信息
     *
     * @param areaCode
     * @return
     */
    @Override
    public List<Map<Object, Object>> getDeviceLocation(final String areaCode) {
        return redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                String ptn = "net:device:gps:";
                ptn += areaCode.substring(2, 6).equals("0000") ? areaCode.substring(0, 2) + "*" : (areaCode.substring(4, 6).equals("00") ? areaCode.substring(0, 4) + "*" : areaCode + ":sort");
                Set set = redisTemplate.keys(ptn);
                if (set == null || set.size() == 0) return null;
                List keylist = new ArrayList();
                for (Object obj : set) {
                    keylist.addAll(redisTemplate.opsForSet().members(obj));
                }
                if (keylist == null || keylist.size() == 0) return null;
                for (Object o : keylist) {
                    redisConnection.hGetAll(redisTemplate.getStringSerializer().serialize(o));
                }
                return null;
            }
        });
    }

    /**
     * 获取某地区某公司在线车辆定位信息
     *
     * @param areaCode
     * @param companyId
     * @return
     */
    @Override
    public List<Map<Object, Object>> getDeviceLocationByCompany(final String areaCode, String companyId) {
        final List<NetCarbaseinfo> carbaseinfos = netCarbaseinfoDAOImpl.findByParm(areaCode, "companyidc", companyId, "vehicleno");
        return redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                String ptn = "net:device:gps:";
                ptn += areaCode.substring(2, 6).equals("0000") ? areaCode.substring(0, 2) + "*" : (areaCode.substring(4, 6).equals("00") ? areaCode.substring(0, 4) + "*" : areaCode);
                ptn += ":sort";
                Set set = redisTemplate.keys(ptn);
                if (set == null || set.size() == 0) return null;
                List keylist = new ArrayList();
                for (Object obj : set) {
                    keylist.addAll(redisTemplate.opsForSet().members(obj));
                }
                if (keylist == null || keylist.size() == 0) return null;
                for (NetCarbaseinfo info : carbaseinfos) {
                    String key = "net:device:gps:" + info.getAddress() + ":" + info.getVehicleno();
                    if (keylist.contains(key)) {
                        redisConnection.hGetAll(redisTemplate.getStringSerializer().serialize(key));
                    }
                }
                return null;
            }
        });
    }


}
