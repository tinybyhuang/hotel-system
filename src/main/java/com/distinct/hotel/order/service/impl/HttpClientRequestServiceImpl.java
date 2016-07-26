package com.distinct.hotel.order.service.impl;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.distinct.hotel.order.service.HttpClientRequestService;

@Service
public class HttpClientRequestServiceImpl implements HttpClientRequestService {

	// 创建一个默认httpClient例子
	private static CloseableHttpClient httpClient = HttpClients.createDefault();

	

	@Override
	public String post(String url, String data) {
		String result = null;
		HttpPost post = new HttpPost(url);
		try {
			post.setHeader("Content-type", "application/json");
			// 这里加了UTF-8防止数据到了接口变成乱码
			StringEntity stringEntity = new StringEntity(data, "UTF-8");
			post.setEntity(stringEntity);

			// 请求的回复
			CloseableHttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				// 把entity格式化为String
				result = EntityUtils.toString(response.getEntity());
				// 把回复得到的结果转为jsonObject对象
			 
			} else if (response.getStatusLine().getStatusCode() == 500) {
				result = "服务器出错!!!";
			} else {
				result = "出错了!!!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String get(String url) {
		String result = null;
		HttpGet get = new HttpGet(url);
		get.setHeader("Content-type", "application/json");
		try {
			CloseableHttpResponse response = httpClient.execute(get);
			// getEntity才能得到网页内容
			result = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
