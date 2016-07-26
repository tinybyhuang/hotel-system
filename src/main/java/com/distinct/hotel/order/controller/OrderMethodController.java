package com.distinct.hotel.order.controller;

import javax.annotation.Resource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.distinct.hotel.order.model.Order;
import com.distinct.hotel.order.model.UserConfig;
import com.distinct.hotel.order.service.UserConfigManagerService;
import com.distinct.hotel.service.provider.vo.CancelOrder;
import com.google.gson.Gson;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Resource
	private UserConfigManagerService userConfig;

	private Gson gson = new Gson();
	@RequestMapping(value="cancelmmOrder",method=RequestMethod.POST)
	@ResponseBody
	public String cancelOrder(Order order){
		int configerType = 2;
	UserConfig user =	userConfig.findUserConfigRecordByUserIdNConfigTypeNConfigId(configerType, order.getMarketId());
		CancelOrder cancelOrder = new CancelOrder();
		cancelOrder.setAction("http://localhost:8080/hotel-system/cancelOrder");
		cancelOrder.setOrderNo(order.getMarketOrderNo());
		cancelOrder.setUsername(user.getUserNo());
		cancelOrder.setPassword(user.getUserPwd());
		  String url = "http://localhost:8080/hotel-system/provider/order/"+order.getMarketId()+"/cancelOrder.do";
		 CloseableHttpClient httpClient = HttpClients.createDefault();  
	        // 创建httppost    
		//创建参数队列
	      
			
	    	String result = null;
			HttpPost post = new HttpPost(url);
			System.out.println(url);
			try {
				post.setHeader("Content-type", "application/json");
				String cancelOrderString = gson.toJson(cancelOrder);
				System.out.println(cancelOrderString);
				StringEntity stringEntity = new StringEntity(cancelOrderString, "UTF-8");
				post.setEntity(stringEntity);
				CloseableHttpResponse response = httpClient.execute(post);
				result = EntityUtils.toString(response.getEntity());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			String message = null;
			if(result.contains("取消订单成功")){
				 message = "取消订单申请成功";
			}else if(result.contains("用户授权失败")){
				 message = "用户授权失败，当前用户不具有此操作权限";
			}else if(result.contains("该订单数据不存在")){
				 message = "该订单数据不存在，请刷新后重试";
			}
			return message;
		 
	    }  
		
	}

