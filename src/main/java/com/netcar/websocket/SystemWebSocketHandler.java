package com.netcar.websocket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonObject;
import com.netcar.dataModle.Devicegps;
import com.netcar.dataModle.SocketMessage;
import com.netcar.entity.NetUser;
import com.netcar.service.NetCarGpsService;
import com.netcar.tools.ContextData;
import com.netcar.tools.StringAndDate;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.servlet.ServletOutputStream;
import javax.swing.event.SwingPropertyChangeSupport;

public class SystemWebSocketHandler implements WebSocketHandler {


	@Autowired
	private NetCarGpsService netCarGpsServiceImpl;


	private static Logger logger= Logger.getLogger(SystemWebSocketHandler.class);

	// 连接用户集合
	private static final ArrayList<WebSocketSession> users=new ArrayList<>();



	public SystemWebSocketHandler() {

	}

	//连接断开
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		users.remove(session);
		System.out.println(session.getId()+"断开连接====="+System.currentTimeMillis());
	}

	//连接完成后
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		NetUser user = (NetUser) session.getAttributes().get(ContextData.socketUser);
		logger.info(user.getName()+"加入连接area="+user.getName());
		users.add(session);
		System.out.println(session.getId()+"连接成功====="+System.currentTimeMillis());
	}


	/**
	 * 心跳接收到客户端消息时调用
	 * {'type':'gps','areacode':'410000','vehicleno':'豫AT0004'}
	 * @param session
	 * @param message
	 */
	@Override
	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message)  {
		try {
			SocketMessage socketMessage=new SocketMessage();
			////
			System.out.println("接收:" + message.getPayload().toString());
			JSONObject object=JSONObject.fromObject(message.getPayload());
			String dataType= object.get("type").toString();
			switch (dataType){
				case "gps":

					String areacode= object.get("areacode").toString();
                 	String vehicleno=object.get("vehicleno").toString();
					Devicegps devicegps= netCarGpsServiceImpl.findGPSByAreacodeVehicleno(areacode,vehicleno);
					if((StringAndDate.getDateFromStr(StringAndDate.getyyMMddHHmmss())-StringAndDate.getDateFromStr(devicegps.getLtime()))>1000){
						socketMessage.setState("outTime");
						socketMessage.setDataType("gps");
						socketMessage.setObject(devicegps);
					}else if(devicegps!=null){
					socketMessage.setState("success");
					socketMessage.setDataType("gps");
					socketMessage.setObject(devicegps);
				}
					else{
						socketMessage.setState("error");
					}
					break;
				case "companyGps":
					String com_areacode= object.get("areacode").toString();
					String com_companyidc=object.get("companyidc").toString();
					List<Devicegps> devicegpseList= netCarGpsServiceImpl.findGPSByAreaCompany(com_areacode,com_companyidc);
					if(devicegpseList!=null&&devicegpseList.size()!=0){
						socketMessage.setState("success");
						socketMessage.setDataType("companyGps");
						socketMessage.setObject(devicegpseList);
					}else{
						socketMessage.setState("error");
					}
					break;
				default:
					break;
			}
			JSONObject socketMessageJson=JSONObject.fromObject(socketMessage);
			TextMessage gpsmessage = new TextMessage(socketMessageJson.toString());
			session.sendMessage(gpsmessage);
		}catch (Exception e){
			e.printStackTrace();
		}
	}






	// 消息传输出错时调用
	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable throwable) throws Exception {
//		if (session.isOpen()) {
//			session.close();
//		}
//		users.remove(session);
	}


	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * 给所有在线用户发送消息
	 * @param message
	 */
	public void sendMessageToUsers(TextMessage message) {
		for (WebSocketSession user : users) {
			if (user.isOpen()) {
				try {
					user.sendMessage(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//发给特定用户
	public void sendMessageToUser(String webSocketUsername, TextMessage message) {
		for (WebSocketSession user : users) {
			if (user.getAttributes().get("socketUser").equals(webSocketUsername)) {
				try {
					if (user.isOpen()) {
						user.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}



}
