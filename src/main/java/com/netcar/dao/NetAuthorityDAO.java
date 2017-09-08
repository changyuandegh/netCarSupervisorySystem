package com.netcar.dao;

import com.netcar.entity.NetAuthority;

import java.util.List;

/**
 * Created by Mander on 2017/4/26.
 */
public interface NetAuthorityDAO {


    List<NetAuthority> findAll();

    /**
     * 查询用户所有主菜单功能操作level>3
     * @param userid
     * @return
     */
    List<NetAuthority> findMenuByUserid(int userid);


}
