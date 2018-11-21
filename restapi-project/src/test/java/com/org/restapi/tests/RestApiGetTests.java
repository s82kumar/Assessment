package com.org.restapi.tests;

import java.io.IOException;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.restapi.base.TestBase;
import com.org.restapi.client.RestClient;
import com.org.restapi.testutils.TestUtils;

/**
 * GetAPI Tests perform get call for Posts, USers, Comments 
 * it verifies the status code and then verify either name or Title within the response.
 * 
 */
public class RestApiGetTests extends TestBase {
	
	String urlPosts;
	String urlcommentResource;
	String urlUsers;
	RestClient restClient;
	CloseableHttpResponse httpgetResponse;
	int statusCode;
	String response;
	
	@BeforeMethod
	public void setUp()
	{
		urlPosts = url + posts;
		urlcommentResource = url + commentResource;
		urlUsers =url + Users;
		restClient = new RestClient();
	}
	
	@Test
	public void getPostsTest() throws ClientProtocolException, IOException {
		processResponse(urlPosts);
		verifyStatusCode();
		boolean verifyTitle = TestUtils.verifyTitle(response, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		Assert.assertTrue(verifyTitle, "Title is not verified for userId 1");
	}

	
	@Test
	public void getCommentsTest() throws ClientProtocolException, IOException {
		processResponse(urlcommentResource);
		verifyStatusCode();
		boolean verifyName = TestUtils.verifyName(response, "test put update");
		Assert.assertTrue(verifyName, "test put update name is not available");
	}

	@Test
	public void getUsersTest() throws ClientProtocolException, IOException {
		processResponse(urlUsers);
		verifyStatusCode();
		boolean verifyName = TestUtils.verifyName(response, "Bret");
		Assert.assertTrue(verifyName, "test put update name is not available");
	}
	
	private String processResponse(String url) throws ClientProtocolException, IOException {
		httpgetResponse =restClient.get(url);
		return response =EntityUtils.toString(httpgetResponse.getEntity(), "UTF-8");
	}

	// @Test(dependsOnMethods = {"getUsersTest","getCommentsTest", "getPostsTest"})
	private void verifyStatusCode() {
		statusCode = httpgetResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
	}


}
