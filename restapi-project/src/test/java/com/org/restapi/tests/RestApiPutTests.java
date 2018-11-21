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
import com.org.restapi.data.Comments;
import com.org.restapi.testutils.TestUtils;

/**
 * RestApiPutTests perform Put call for Posts, USers, Comments with header data and payload
 * it verifies the status code and then verify either name or Title within the response.
 * 
 */
public class RestApiPutTests extends TestBase {
	String urlPosts;
	String urlcommentResource;
	String urlUsers;
	RestClient restClient;
	CloseableHttpResponse httpPostResponse;
	int statusCode;
	String response;
	HashMap <String, String> headerMap;
	String name = "Sam1";
	String title ="restApi";
	String body ="1restApi using HTTPClient";
	String email ="sam1@abc.com";
	String id=  "423453453678";
	
	@BeforeMethod
	public void setUp()
	{
		urlPosts = url + posts;
		urlcommentResource = url + commentResource;
		urlUsers =url + Users;
		restClient = new RestClient();
		headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
	}
	
	
	@Test
	public void putPostsTest() throws ClientProtocolException, IOException {
		processPutResponse(urlPosts+postsPathParameter);
		verifyStatusCode();
		boolean verifyName = TestUtils.verifyName(response, "Sam1");
		Assert.assertTrue(verifyName, "Name is not verified");
	}

	
	@Test
	public void putUsersTest() throws ClientProtocolException, IOException {
		processPutResponse(urlUsers+pathParameter);
		verifyStatusCode();
		boolean verifyName = TestUtils.verifyName(response, "Sam1");
		Assert.assertTrue(verifyName, "Name is not verified");
	}
	
	
	@Test
	public void putCommentResourceTest() throws ClientProtocolException, IOException {
		processPutResponse(urlcommentResource+pathParameter);
		verifyStatusCode();
		boolean verifytitme = TestUtils.verifyTitle(response, "restApi");
		Assert.assertTrue(verifytitme, "Name is not verified");
	}

	private String processPutResponse(String url) throws JsonProcessingException, ClientProtocolException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Comments comments = new Comments(name,title,body,email,id);
		String jsonbody = mapper.writeValueAsString(comments);
		System.out.println("this is the body" +jsonbody);
		httpPostResponse = restClient.put(url,jsonbody, headerMap);
		return response =EntityUtils.toString(httpPostResponse.getEntity(), "UTF-8");
	}

  //  @Test(dependsOnMethods = {"putPostsTest","putCommentResourceTest", "putUsersTest"})
	private void verifyStatusCode() {
		statusCode = httpPostResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
	}



}
