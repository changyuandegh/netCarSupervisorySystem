package com.netcar.daoImpl;

import com.netcar.dao.NetDevicegpsDAO;
import com.netcar.dataModle.ShowGps;
import com.netcar.tools.ChineseToPingyin;
import com.netcar.tools.CoordinateConvert;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
@Repository
public class NetDevicegpsDAOImpl implements NetDevicegpsDAO {

    private Logger logger=Logger.getLogger(NetCarbaseinfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return  sessionFactory.openSession();
    }

    @Override
    public List<ShowGps> findByTime(String vehicleno, String starttime, String endtime) {
        try {
            //轨迹表名：net_devicegps_(车牌号)
            String table = "net_devicegps"+"_"+ChineseToPingyin.getPingYin(vehicleno).toLowerCase();
            Query query = getSession().createSQLQuery("select longitude,latitude,encrypt,speed,positiontime from "+table
            +" where positiontime between :starttime and :endtime order by positiontime asc");
            query.setString("starttime", starttime);
            query.setString("endtime", endtime);

            List ls = query.list();
            if (ls!=null){
                return bindGpsData(ls);
            } else {
                return null;
            }
        }catch (Exception e){
            logger.debug(e);
            return null;
        }
    }



    private List<ShowGps> bindGpsData(List list){
        List<ShowGps> GpsList = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            ShowGps gps = new ShowGps();
            Object[] obj = (Object[]) list.get(i);
            double lng = Double.parseDouble(obj[0].toString());
            double lat = Double.parseDouble(obj[1].toString());
            double[] latlng = new double[2];
            gps.setEncrypt(Integer.parseInt(obj[2].toString()));

            if (gps.getEncrypt() == 1){//1:GCJ-02 2:WGS84 3:BD-09 4:CGCS2000
                latlng = CoordinateConvert.gcj2BD09(lat, lng);
            } else if (gps.getEncrypt() == 2){
                latlng = CoordinateConvert.wgs2BD09(lat, lng);
            } else if (gps.getEncrypt() == 3){
                latlng[0] = lat;
                latlng[1] = lng;
            } else if (gps.getEncrypt() == 4){
                latlng = CoordinateConvert.wgs2BD09(lat, lng);
            } else {
                latlng[0] = lat;
                latlng[1] = lng;
            }
            gps.setLng(""+latlng[1]);
            gps.setLat(""+latlng[0]);

            gps.setSpeed(obj[3].toString());
            gps.setTime(Timestamp.valueOf(obj[4].toString()));
            GpsList.add(gps);
        }

        return GpsList;
    }
}
