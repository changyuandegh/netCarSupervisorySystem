package com.netcar.dao;

import com.netcar.dataModle.OrderAfterSales;
import com.netcar.dataModle.OrderFeedBack;
import com.netcar.dataModle.OrderManagement;
import com.netcar.dataModle.OrderPoint;
import com.netcar.entity.NetOrder;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public interface NetOrderDAO {
    /**
     * 根据车牌,时间范围查询订单
     * @param vehicleno 车牌号
     * @param starttime 开始时间
     * @param endtime 结束时间
     * @return
     */
    List<NetOrder> findBycar(String vehicleno, String starttime, String endtime);


    List<NetOrder> findOrdersByparm(String areacode,String parameter,String search,String stime,String etime,int limit,int offset);

    int findOrdersCountByparm(String areacode,String parameter,String search,String stime,String etime);

    /**
     * 根据订单号查询订单轨迹点
     * @return
     */
    List<OrderPoint> findOrderPointsByorderid(String orderid);


    /**
     * 获取订单爽约率
     * @param comanyidc
     * @return
     */
    Double getOrderBreakRate(String comanyidc);


    OrderFeedBack getFeedBackByorderid(String orderid);

    NetOrder findOrderByorderid(String orderid);



    OrderAfterSales getOrderAfterSales(String orderid);



    /**
     * 订单管理查询
     * @return
     */
    List<OrderManagement> findOrderDatail(String parameter, int limit, int offset, String areacode, String search, String stime, String etime, String company);

    /**
     * 统计条数
     * @return
     */
    int findCount(String parameter,String areacode,String search,String stime,String etime,String company);
}
