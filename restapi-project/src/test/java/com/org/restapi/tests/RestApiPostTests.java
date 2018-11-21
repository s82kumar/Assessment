package com.org.restapi.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.restapi.base.TestBase;
import com.org.restapi.client.RestClient;
import com.org.restapi.testutils.TestUtils;


/**
 * RestApiPostTests perform Post call for Posts, USers, Comments with header data and payload
 * it verifies the status code and then verify either name or Title within the response.
 * 
 */
public class RestApiPostTests  extends TestBase {
	String urlPosts;
	String urlcommentResource;
	String urlUsers;
	RestClient restClient;
	CloseableHttpResponse httpPostResponse;
	int statusCode;
	String response;
	String body;
	HashMap <String, String> postData;
	HashMap <String, String> headerMap;
	
	@BeforeMethod
	public void setUp()
	{
		urlPosts = url + posts;
		urlcommentResource = url + commentResource;
		urlUsers =url + Users;
		restClient = new RestClient();
		postData = new HashMap<String, String>();
		headerMap = new HashMap<String, String>();
		postData.put("name", "Sam1");
		postData.put("email", "sam1@abc.com");
		postData.put("title", "restApi");
		postData.put("body", "1restApi using HTTPClient");
		headerMap.put("Content-Type", "application/json");
	}
	
	
	@Test
	public void postPostsTest() throws ClientProtocolException, IOException {
		processPostResponse(urlPosts);
		verifyStatusCode();
		boolean verifyTitle = TestUtils.verifyName(response, "Sam1");
		Assert.assertTrue(verifyTitle, "Title is not verified for userId 1");
	}

	
	@Test
	public void postUsersTest() throws ClientProtocolException, IOException {
		processPostResponse(urlUsers);
		verifyStatusCode();
		boolean verifyTitle = TestUtils.verifyName(response, "Sam1");
		Assert.assertTrue(verifyTitle, "Title is not verified for userId 1");
	}
	
	
	@Test
	public void postCommentResourceTest() throws ClientProtocolException, IOException {
		processPostResponse(urlcommentResource);
		verifyStatusCode();
		boolean verifyTitle = TestUtils.verifyName(response, "Sam1");
		Assert.assertTrue(verifyTitle, "Title is not verified for userId 1");
	}

	private String processPostResponse(String url) throws JsonProcessingException, ClientProtocolException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(postData);
		httpPostResponse = restClient.post(url,jsonbody, headerMap);
		return response =EntityUtils.toString(httpPostResponse.getEntity(), "UTF-8");
	}

 //   @Test(dependsOnMethods = {"postUsersTest","postCommentResourceTest", "postPostsTest"})
	private void verifyStatusCode() {
		statusCode = httpPostResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_201, "Status code is not 201");
	}


}
