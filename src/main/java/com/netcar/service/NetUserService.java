package com.netcar.service;

import com.netcar.entity.NetUser;

import java.util.List;

/**
 * Created by Mander on 2017/4/25.
 *
 *用户操作业务接口
 */
public interface NetUserService {

    /**
     * 查询用户
     * @param name 用户名
     * @param pass 密码
     * @return  用户对象
     */
    NetUser findByNamePass(String name, String pass);


    /**
     * 查询所有用户
     * @param limit 显示的条数
     * @param offset 开始条数
     * @return
     */
    List<NetUser> findAll(int limit, int offset);


}
