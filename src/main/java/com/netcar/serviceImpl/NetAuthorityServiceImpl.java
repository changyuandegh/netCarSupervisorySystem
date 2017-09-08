package com.netcar.serviceImpl;

import com.netcar.dao.NetAuthorityDAO;
import com.netcar.dataModle.Menu;
import com.netcar.entity.NetAuthority;
import com.netcar.service.NetAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mander on 2017/4/26.
 */
@Service
public class NetAuthorityServiceImpl implements NetAuthorityService {



    @Autowired
    private NetAuthorityDAO netAuthorityDAOImpl;

    @Override
    public List<NetAuthority> findAll() {
        return netAuthorityDAOImpl.findAll();
    }

    @Override
    public List<NetAuthority> findMenuByUserid(int userid) {
        return netAuthorityDAOImpl.findMenuByUserid(userid);
    }


    /**
     * 根据用户id,获取菜单
     * @param userid
     * @return
     */
    @Override
    public List<Menu> findMenuByuserid(int userid) {
        List<NetAuthority> netAuthorityList= netAuthorityDAOImpl.findMenuByUserid(userid);
        List<Menu> menuList=new ArrayList<>();
        //获取一级菜单
        for (int i = 0; i < netAuthorityList.size(); i++) {
            if(netAuthorityList.get(i).getLevel()==1){
                Menu menu=new Menu();
                menu.setNetAuthority(netAuthorityList.get(i));
                menuList.add(menu);
            }
        }
        //获取一级菜单下的子菜单
        for (int i = 0; i < menuList.size(); i++) {
            NetAuthority mainNet= menuList.get(i).getNetAuthority();
            List<NetAuthority> secondAuth=new ArrayList<>();
            for (int j = 0; j < netAuthorityList.size(); j++) {
                NetAuthority netAuthority= netAuthorityList.get(j);
                if (mainNet.getGroupid()==netAuthority.getGroupid()&&netAuthority.getLevel()==2){
                    secondAuth.add(netAuthority);
                }
            }
            menuList.get(i).setNetAuthorities(secondAuth);
        }
        return menuList;
    }



}
