package com.netcar.dao;

import com.netcar.entity.NetOrderpay;

/**
 * Created by Mander on 2017/6/15.
 */
public interface NetOrderPayDAO {


    NetOrderpay findbyorderid(String orderid);

}
