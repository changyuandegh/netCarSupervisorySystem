package com.netcar.dao;

import com.netcar.entity.NetUser;

import java.util.List;

/**
 * Created by Mander on 2017/4/25.
 * 用户
 */
public interface NetUserDAO {

    /**
     * 根据用户名查找
     * @param name 名称
     * @param pass 密码
     * @return 用户对象
     */
    NetUser findByNamePass(String name, String pass);


    /**
     * 返回所有用户(分页)
     * @param limit 显示条数
     * @param offset 开始条数
     * @return 用户对象集合
     */
    List<NetUser> findAll(int limit,int offset);

}
