package com.netcar.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.netcar.entity.NetUser;
import com.netcar.tools.ContextData;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


@Component
public class MyHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

	
	
	/**
	 * 握手前
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler handler,
			Map map) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			//servletRequest.getSession(true);//若存在会话则返回该会话，否则新建一个会话。
			servletRequest.getServletRequest().getSession(true);
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			 if (session != null) {
				//使用userName区分WebSocketHandler，以便定向发送消息
				 NetUser user= (NetUser) session.getAttribute(ContextData.loginuser);
				 map.put(ContextData.socketUser,user);
	            }
		}
		return true;
	}
	
	
	
	/**
	 *握手后
	 */
	@Override
	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		//System.out.println("握手后="+request.getURI().toString());
	}
	
	
	
	
}
