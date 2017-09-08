package com.netcar.tools;

import com.netcar.entity.NetAuthority;
import com.netcar.service.NetAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

/**
 * Created by Mander on 2017/4/26.
 * bean 初始化完成后操作
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private NetAuthorityService netAuthorityServiceImpl;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //加载所有菜单项,放入缓存

        List<NetAuthority> netAuthorities=netAuthorityServiceImpl.findAll();
        ContextData.NetAuthoritys=netAuthorityServiceImpl.findAll();

    }


}
