package com.hackerearth.sender.utility;

import java.io.IOException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class RESTUtility {
	
	public static CloseableHttpResponse post(String url,List<NameValuePair>data) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		post.setEntity(new UrlEncodedFormEntity(data));
		return client.execute(post);
	}
	
	

}
