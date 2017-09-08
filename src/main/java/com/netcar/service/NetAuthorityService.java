package com.netcar.service;

import com.netcar.dataModle.Menu;
import com.netcar.entity.NetAuthority;

import java.util.List;

/**
 * Created by Mander on 2017/4/26.
 */
public interface NetAuthorityService {

    List<NetAuthority> findAll();

    List<NetAuthority> findMenuByUserid(int userid);

    List<Menu> findMenuByuserid(int userid);



}
