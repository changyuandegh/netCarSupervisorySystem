package com.netcar.service;

import com.netcar.entity.NetOrderpay;
import org.springframework.stereotype.Service;

/**
 * Created by Mander on 2017/6/15.
 */

public interface NetOrderPayService {


    NetOrderpay findbyorderid(String orderid);



}
