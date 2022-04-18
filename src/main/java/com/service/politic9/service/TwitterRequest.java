
package com.service.politic9.service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/*
 * Sample code to demonstrate the use of the v2 Users endpoint
 * */
public class TwitterRequest {

  // To set your enviornment variables in your terminal run the following line:
  // export 'BEARER_TOKEN'='<your_bearer_token>'

  public String Request(String bearerToken) throws IOException, URISyntaxException {
   if (null != bearerToken) {
      System.out.println("ok token");
    } else {
      System.out.println("There was a problem getting you bearer token. Please make sure you set the BEARER_TOKEN environment variable");
    }
	return "";
  }

  /*
   * This method calls the v2 Users endpoint with usernames as query parameter
   * */
  public static String getPoliticianBio(String usernames, String bearerToken) throws IOException, URISyntaxException {
    String userResponse = null;
 
    HttpClient httpClient = HttpClients.custom()
        .setDefaultRequestConfig(RequestConfig.custom()
            .setCookieSpec(CookieSpecs.STANDARD).build())
        .build();

    URIBuilder uriBuilder = new URIBuilder("https://api.twitter.com/2/users/by");
    ArrayList<NameValuePair> queryParameters;
    queryParameters = new ArrayList<>();
    queryParameters.add(new BasicNameValuePair("usernames", usernames));
    queryParameters.add(new BasicNameValuePair("user.fields", "created_at,description,pinned_tweet_id"));
    uriBuilder.addParameters(queryParameters);

    HttpGet httpGet = new HttpGet(uriBuilder.build());
    httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken));
    httpGet.setHeader("Content-Type", "application/json");

    HttpResponse response = httpClient.execute(httpGet);
    HttpEntity entity = response.getEntity();
    if (null != entity) {
      userResponse = EntityUtils.toString(entity, "UTF-8");
    }
    return userResponse;
  }
  
  public static String getPoliticianTweet(String ids, String bearerToken) throws IOException, URISyntaxException {
	    String tweetResponse = null;

	    HttpClient httpClient = HttpClients.custom()
	        .setDefaultRequestConfig(RequestConfig.custom()
	            .setCookieSpec(CookieSpecs.STANDARD).build())
	        .build();

	    URIBuilder uriBuilder = new URIBuilder("https://api.twitter.com/2/tweets");
	    ArrayList<NameValuePair> queryParameters;
	    queryParameters = new ArrayList<>();
	    queryParameters.add(new BasicNameValuePair("ids", ids));
	    queryParameters.add(new BasicNameValuePair("tweet.fields", "created_at"));
	    uriBuilder.addParameters(queryParameters);

	    HttpGet httpGet = new HttpGet(uriBuilder.build());
	    httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken));
	    httpGet.setHeader("Content-Type", "application/json");

	    HttpResponse response = httpClient.execute(httpGet);
	    HttpEntity entity = response.getEntity();
	    if (null != entity) {
	      tweetResponse = EntityUtils.toString(entity, "UTF-8");
	    }
	    return tweetResponse;
	  }
  
  public static String getPoliticianTweets(String userId, String bearerToken) throws IOException, URISyntaxException {
	    String tweetResponse = null;

	    HttpClient httpClient = HttpClients.custom()
	        .setDefaultRequestConfig(RequestConfig.custom()
	            .setCookieSpec(CookieSpecs.STANDARD).build())
	        .build();

	    URIBuilder uriBuilder = new URIBuilder(String.format("https://api.twitter.com/2/users/%s/tweets", userId));
	    ArrayList<NameValuePair> queryParameters;
	    queryParameters = new ArrayList<>();
	    queryParameters.add(new BasicNameValuePair("tweet.fields", "created_at"));
	    uriBuilder.addParameters(queryParameters);

	    HttpGet httpGet = new HttpGet(uriBuilder.build());
	    httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken));
	    httpGet.setHeader("Content-Type", "application/json");

	    HttpResponse response = httpClient.execute(httpGet);
	    HttpEntity entity = response.getEntity();
	    if (null != entity) {
	      tweetResponse = EntityUtils.toString(entity, "UTF-8");
	    }
	    return tweetResponse;
	  }

}
