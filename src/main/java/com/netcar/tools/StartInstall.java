package com.netcar.tools;

import com.netcar.dao.NetUserDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Mander on 2017/4/25.
 * 项目启动初始化操作
 */
public class StartInstall implements ServletContextListener  {


    @Autowired
    private NetUserDAO netUserDAOImpl;

    /**
     * 启动初始化
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //定义页面标题<title></title>
        servletContextEvent.getServletContext().setAttribute("webTitle","郑州市网约车监管台");
        //初始化菜单
//        List<NetUser> ls= netUserDAOImpl.findAll(10,1);
  //      System.out.println(ls.get(0).getCname());

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }



}
