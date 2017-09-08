package com.netcar.service;

import com.netcar.entity.NetArea;

import java.util.List;

/**
 * Created by Mander on 2017/5/3.
 */
public interface NetAreaService {


    /**
     * 查询该编码的所有子级可用地区编码(state=1)
     * @param code
     * @return
     */
    List<NetArea> findChildrenBycode(String code);




}
