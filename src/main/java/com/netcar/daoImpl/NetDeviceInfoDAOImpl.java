package com.netcar.daoImpl;

import com.netcar.dao.NetDeviceInfoDAO;
import com.netcar.dataModle.ShowDevice;
import com.netcar.entity.NetDevice;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wby on 2017/5/4.
 * 终端信息数据库操作实现
 */
@Repository
public class NetDeviceInfoDAOImpl implements NetDeviceInfoDAO {

    private Logger logger = Logger.getLogger(NetDeviceInfoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    private Session getSession() {
        return sessionFactory.openSession();
    }



    @Override
    public List<ShowDevice> findAll(String address, String sort, int limit, int offset) {
        try {
            if (address == null || address.length() < 6)
                return null;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select car.vehicleno,dvc.deviceid,dvc.brand,dvc.model,dvc.imei,dvc.sim,dvc.installdate,dvc.createtime,dvc.updatetime from net_carbaseinfo car inner join net_device dvc on car.deviceid = dvc.deviceid order by :sort");
            } else {
                query = getSession().createSQLQuery("select car.vehicleno,dvc.deviceid,dvc.brand,dvc.model,dvc.imei,dvc.sim,dvc.installdate,dvc.createtime,dvc.updatetime from net_carbaseinfo car inner join net_device dvc on car.deviceid = dvc.deviceid where car.address in (select area.code from net_area area where area.code=:address or area.fathercode=:address) order by :sort");
                query.setString("address", address);
            }
            query.setString("sort", sort);
            query.setFirstResult(offset); //表示从哪个位置开始查询，返回query对象
            query.setMaxResults(limit); //表示当页共几条记录，返回一个集合
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                return bindData(ls);
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return new ArrayList<>();
    }

    @Override
    public int findAllCount(String address) {
        try {
            if (address == null || address.length() < 6)
                return 0;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select count(dvc.deviceid) from net_carbaseinfo car inner join net_device dvc on car.deviceid = dvc.deviceid ");
            } else {
                query = getSession().createSQLQuery("select  count(dvc.deviceid) from net_carbaseinfo car inner join net_device dvc on car.deviceid = dvc.deviceid where car.address in (select area.code from net_area area where area.code=:address or area.fathercode=:address)");
                query.setString("address", address);
            }
            List list= query.list();

            return Integer.parseInt(list.get(0).toString());
        } catch (Exception e) {
            logger.debug(e);
        }
        return 0;
    }



    @Override
    public List<ShowDevice> findByCarInfo(String address, String param, String value, String sort, int limit, int offset) {
        try {
            if (address == null || address.length() < 6)
                return null;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select car.vehicleno,dvc.deviceid,dvc.brand,dvc.model,dvc.imei,dvc.sim,dvc.installdate,dvc.createtime,dvc.updatetime from net_carbaseinfo car inner join net_device dvc on car.deviceid = dvc.deviceid where car." + param + " LIKE :val order by :sort");
            } else {
                query = getSession().createSQLQuery("select car.vehicleno,dvc.deviceid,dvc.brand,dvc.model,dvc.imei,dvc.sim,dvc.installdate,dvc.createtime,dvc.updatetime from net_carbaseinfo car inner join net_device dvc on car.deviceid = dvc.deviceid where car.address in (select area.code from net_area area where area.code=:address or area.fathercode=:address) and car." + param + " LIKE :val order by :sort");
                query.setString("address", address);
            }
            query.setString("val", "%" + value + "%");
            query.setString("sort", sort);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            List ls = query.list();
            if (ls != null && ls.size() != 0) {
                return bindData(ls);
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return new ArrayList<>();
    }

    @Override
    public int findByCarInfoCount(String address, String param, String value) {
        try {
            if (address == null || address.length() < 6)
                return 0;
            Query query;
            if (address.substring(2, 6).equals("0000")) {
                query = getSession().createSQLQuery("select count(car.carid) from net_carbaseinfo car inner join net_device dvc on car.deviceid = dvc.deviceid where car." + param + " LIKE :val");
            } else {
                query = getSession().createSQLQuery("select count(car.carid) from net_carbaseinfo car inner join net_device dvc on car.deviceid = dvc.deviceid where car.address in (select area.code from net_area area where area.code=:address or area.fathercode=:address) and car." + param + " LIKE :val");
                query.setString("address", address);
            }
            query.setString("val", "%" + value + "%");
            return ((Long) query.uniqueResult()).intValue();
        } catch (Exception e) {
            logger.debug(e);
        }
        return 0;
    }

    @Override
    public boolean add(NetDevice info, String num) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = getSession().createQuery("update NetCarbaseinfo set deviceid=:id where vehicleno = :num");
            query.setLong("id", info.getDeviceid());
            query.setString("num", num);
            int line = query.executeUpdate();
            if (line == 0) {
                return false;
            }
            session.save(info);
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.debug(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return false;
    }


    @Override
    public boolean saveDevice(NetDevice device1) {
        boolean reg=true;
        try {
            // getSession().save(device1);
            getSession().persist(device1);
            NetDevice device = new NetDevice();
            device.setDeviceid(1999990122);
            device.setBrand("厂商101");
            device.setModel("xx2");
            device.setImei("10000000012");
            device.setSim("1330090900");
            device.setCreatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
            device.setUpdatetime(Timestamp.valueOf("2017-06-01 16:15:00"));
            String sql="insert into net_device(deviceid,brand,model,imei,sim,installdate,createtime,updatetime) VALUES('21111111','厂商101','3432','4356','1212120','2016-10-11','2017-06-01 16:15:00','2017-06-01 16:15:00')";
            getSession().flush();
            //Query query=getSession().createSQLQuery(sql);
            //int i= query.executeUpdate();
            //reg=i>0?true:false;
        }catch (Exception e){
            System.out.println("===============");
            e.printStackTrace();
            System.out.println("===============");
            reg=false;
           // logger.debug(e);
        }
        return reg;
    }


    @Override
    public boolean edit(NetDevice netDevice) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(netDevice);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(String deviceid) {
        NetDevice device = new NetDevice();

        device.setDeviceid(Long.parseLong(deviceid));
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = getSession().createQuery("update NetCarbaseinfo set deviceid=NULL where deviceid = :id");
            query.setLong("id",Long.parseLong(deviceid));
            int line = query.executeUpdate();
            if (line == 0)
                return false;
            session.delete(device);
            transaction.commit();
            return true;
        } catch (Exception e) {
      //      transaction.rollback();
            logger.debug(e);
        } finally {
            session.close();
        }
        return false;
    }

//   @Override
//    public boolean add(NetDeviceInfo info, String num) {
//        Session session = getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            Query query = session.createQuery("update NetCarbaseinfo set deviceid=:deviceid where vehicleno = :num");
//            query.setLong("deviceid", info.getDeviceid());
//            query.setString("num", num);
//            int line = query.executeUpdate();
//            System.out.println("影响行数 -- > " + line);
//            if (line == 0)
//                return false;
//            session.save(info);
//            transaction.commit();
//            session.close();
//            return true;
//        } catch (Exception e) {
//            transaction.rollback();
//            logger.debug(e);
//            System.out.println(e.getMessage());
//        } finally {
//        }
//        return false;
//    }





    /**
     * 绑定返回信息
     * @param list 数据库结构
     * @return
     */
    private List<ShowDevice> bindData(List list) {
        List<ShowDevice> showDevices = new ArrayList<>();
        SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < list.size(); i++) {
            ShowDevice showDevice = new ShowDevice();
            try {
            Object[] obj = (Object[]) list.get(i);
            showDevice.setVechileno(obj[0].toString());
            showDevice.setDeviceid(obj[1].toString());
            showDevice.setBrand(obj[2].toString());
            showDevice.setModel(obj[3].toString());
            showDevice.setImei(obj[4].toString());
            showDevice.setSim(obj[5].toString());
            showDevice.setInstalldate(formatdate.format(formatdate.parse(obj[6].toString())));
            showDevice.setCreatetime(formatTime.format(formatTime.parse(obj[7].toString())));
            showDevice.setUpdatetime(formatTime.format(formatTime.parse(obj[8].toString())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            showDevices.add(showDevice);
        }
        return showDevices;
    }


}
