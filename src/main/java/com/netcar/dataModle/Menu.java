package com.netcar.dataModle;

import com.netcar.entity.NetAuthority;

import java.util.List;

/**
 * Created by Mander on 2017/4/26.
 * 菜单数据模型
 */
public class Menu {

    //一级主菜单
    private NetAuthority netAuthority;
    //子级主菜单
    private List<NetAuthority> netAuthorities;


    public NetAuthority getNetAuthority() {
        return netAuthority;
    }

    public void setNetAuthority(NetAuthority netAuthority) {
        this.netAuthority = netAuthority;
    }

    public List<NetAuthority> getNetAuthorities() {
        return netAuthorities;
    }

    public void setNetAuthorities(List<NetAuthority> netAuthorities) {
        this.netAuthorities = netAuthorities;
    }




}
