package com.netcar.tools;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Mander on 2017/4/25.
 *拦截器
 */
public class UserAccessFilter implements Filter {



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 未登录拦截
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String uri = request.getServletPath();
        // jsp或/,需要拦截
        if (StringUtils.endsWith(uri, "jsp") || StringUtils.endsWith(uri, "/")) {
            //判断是否登录
            Object loginForm = session.getAttribute("loginUser");
            if (loginForm != null) {
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect(request.getContextPath()+ "/index.jsp");
            }
         }
      }





    @Override
    public void destroy() {

    }



}
