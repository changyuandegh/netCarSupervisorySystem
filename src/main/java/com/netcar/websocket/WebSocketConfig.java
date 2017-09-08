package com.netcar.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 注册服务：
 * 注册两种：ws 和http 实现websocket。 
 * @author WinU10
 *
 */

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements
		WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		System.out.println("registerWebSocketHandlers===============");
		 registry.addHandler(systemWebSocketHandler(),"/webSocketServer").addInterceptors(new MyHandshakeInterceptor());
	        registry.addHandler(systemWebSocketHandler(), "/socktjs/webSocketServer").addInterceptors(new MyHandshakeInterceptor())
	                .withSockJS();
	}


	@Bean
	public WebSocketHandler systemWebSocketHandler(){
		return new SystemWebSocketHandler();
	}
	
	
	
	
}
