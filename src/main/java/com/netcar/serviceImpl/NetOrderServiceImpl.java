package com.netcar.serviceImpl;

import com.netcar.dao.NetOrderDAO;
import com.netcar.dataModle.BaseTable;
import com.netcar.dataModle.OrderAfterSales;
import com.netcar.dataModle.OrderFeedBack;
import com.netcar.dataModle.OrderManagement;
import com.netcar.dataModle.OrderPoint;
import com.netcar.entity.NetOrder;
import com.netcar.service.NetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
@Service
public class NetOrderServiceImpl implements NetOrderService {

    @Autowired
    private NetOrderDAO netOrderdaoImpl;

    @Override
    public List<NetOrder> findBycar(String vehicleno, String starttime, String endtime) {
        return netOrderdaoImpl.findBycar(vehicleno, starttime, endtime);
    }

    @Override
    public List<OrderPoint> findOrderPointsByorderid(String orderid) {
        return netOrderdaoImpl.findOrderPointsByorderid(orderid);
    }

    /**
     * 查询订单
     * @param areacode
     * @param parameter
     * @param search
     * @param stime
     * @param etime
     * @param limit
     * @param offset
     * @return
     */
    @Override
    public BaseTable findOrdersByparm(String areacode, String parameter, String search, String stime, String etime, int limit, int offset) {
        BaseTable table=new BaseTable();
        table.setRows(netOrderdaoImpl.findOrdersByparm(areacode,parameter,search,stime,etime,limit,offset));
        table.setTotal(netOrderdaoImpl.findOrdersCountByparm(areacode,parameter,search,stime,etime));
        return table;
    }

    /**
     * 订单爽约率
     * @param companyidc
     * @return
     */
    @Override
    public Double getOrderBreakRate(String companyidc) {
        return netOrderdaoImpl.getOrderBreakRate(companyidc);
    }

    @Override
    public OrderFeedBack getFeedBackByorderid(String orderid) {
        return   netOrderdaoImpl.getFeedBackByorderid(orderid);
    }

    @Override
    public NetOrder findOrderByorderid(String orderid) {
        return netOrderdaoImpl.findOrderByorderid(orderid);
    }


    @Override
    public OrderAfterSales getOrderAfterSales(String orderid) {
        return netOrderdaoImpl.getOrderAfterSales(orderid);
    }



    @Override
    public BaseTable findOrderDatail(String parameter, int limit, int offset, String areacode, String search, String stime, String etime, String company) {
        BaseTable baseTable=new BaseTable();
        List<OrderManagement> order=netOrderdaoImpl.findOrderDatail(parameter,limit,offset,areacode,search,stime,etime,company);
        int count=netOrderdaoImpl.findCount(parameter,areacode,search,stime,etime,company);
        baseTable.setTotal(Integer.valueOf(count));
        baseTable.setRows(order);
        return baseTable;
    }
}
