package com.netcar.service;

import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.OrderAfterSales;
import com.netcar.dataModle.OrderFeedBack;
import com.netcar.dataModle.OrderPoint;
import com.netcar.entity.NetOrder;

import java.util.List;

/**
 * Created by Mander on 2017/5/9.
 * 订单接口
 */
public interface NetOrderService {

    /**
     * 根据车牌,时间范围查询订单
     * @param vehicleno 车牌号
     * @param starttime 开始时间
     * @param endtime 结束时间
     * @return
     */
    List<NetOrder> findBycar(String vehicleno, String starttime, String endtime);


    /**
     * 根据订单号查询订单轨迹点
     * @return
     */
    List<OrderPoint> findOrderPointsByorderid(String orderid);



    BaseTable findOrdersByparm(String areacode,String parameter,String search, String stime, String etime,int limit,int offset);

    /**订单爽约率
     * companyidc
     * @return
     */
    Double getOrderBreakRate(String companyidc);



    OrderFeedBack getFeedBackByorderid(String orderid);


     NetOrder findOrderByorderid(String orderid);


    OrderAfterSales getOrderAfterSales(String orderid);

    /**
     * 订单管理
     * @param parameter
     * @param limit
     * @param offset
     * @param areacode
     * @param search
     * @param stime
     * @param etime
     * @param company
     * @return
     */
    BaseTable  findOrderDatail(String parameter,int limit,int offset,String areacode,String search,String stime,String etime,String company );


}
