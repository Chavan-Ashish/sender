package com.hackerearth.sender.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;

public class RESTUtility {
	
	public static CloseableHttpResponse post(String url,List<NameValuePair>data) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		post.setEntity(new UrlEncodedFormEntity(data));
		return client.execute(post);
	}
	
	public static JSONObject postWithBody(String url, String payload, Map<String, String> headers)
		      throws Exception {
		    CloseableHttpClient client = HttpClientBuilder.create().build();
		    HttpPost request = new HttpPost(url);

		    headers.forEach((key, value) -> request.addHeader(key, value));
		    StringEntity postingString = new StringEntity(payload);
		    request.setEntity(postingString);
		    HttpResponse response = (HttpResponse) client.execute(request);
		    String body = new BufferedReader(new InputStreamReader(((org.apache.http.HttpResponse) response).getEntity().getContent()))
		        .lines().collect(Collectors.joining());
		    if (body != null && body.length() > 0) {
		      return new JSONObject(body);
		    }
		    return null;
		  }
	

	

}
