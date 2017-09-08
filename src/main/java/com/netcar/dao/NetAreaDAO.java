package com.netcar.dao;

import com.netcar.entity.NetArea;

import java.util.List;

/**
 * Created by Mander on 2017/5/3.
 */
public interface NetAreaDAO {

    List<NetArea> findChildrenBycode(String code);


}
