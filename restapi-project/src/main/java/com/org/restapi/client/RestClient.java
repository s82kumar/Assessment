package com.org.restapi.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.org.restapi.base.TestBase;

public class RestClient extends TestBase {

	public CloseableHttpResponse get(String _Url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(_Url);
		CloseableHttpResponse httpGetResponse = httpClient.execute(httpget);
		return httpGetResponse;

	}

	public CloseableHttpResponse post(String _Url, String _Entity, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(_Url);
		for (Entry<String, String> entry : headerMap.entrySet()) {
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}
		httpPost.setEntity(new StringEntity(_Entity));
		CloseableHttpResponse httpPostResponse = httpClient.execute(httpPost);
		return httpPostResponse;
	}

	public CloseableHttpResponse put(String _Url, String _Entity, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut(_Url);
		for (Entry<String, String> entry : headerMap.entrySet()) {
			httpPut.addHeader(entry.getKey(), entry.getValue());
		}
		httpPut.setEntity(new StringEntity(_Entity));
		CloseableHttpResponse httpPostResponse = httpClient.execute(httpPut);
		return httpPostResponse;
	}

}
