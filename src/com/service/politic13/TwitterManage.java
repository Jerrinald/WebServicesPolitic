package com.service.politic13;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class TwitterManage {

	String bt = "";
	String descript = "";

	public TwitterManage(String bearerToken) {
		this.bt = bearerToken;
	}

	public String getUser(String name) throws IOException, URISyntaxException {

		String userResponse = null;

		HttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();

		URIBuilder uriBuilder = new URIBuilder("https://api.twitter.com/2/users/by");
		ArrayList<NameValuePair> queryParameters;
		queryParameters = new ArrayList<NameValuePair>();
		queryParameters.add(new BasicNameValuePair("usernames", name));
		queryParameters.add(new BasicNameValuePair("user.fields", "created_at,description,pinned_tweet_id"));
		uriBuilder.addParameters(queryParameters);

		HttpGet httpGet = new HttpGet(uriBuilder.build());
		httpGet.setHeader("Authorization", String.format("Bearer %s", this.bt));
		httpGet.setHeader("Content-Type", "application/json");

		HttpResponse response = httpClient.execute(httpGet);

		HttpEntity entity = response.getEntity();
		if (null != entity) {
			userResponse = EntityUtils.toString(entity, "UTF-8");
		}

		String respUser = userResponse;

		Object obj = JSONValue.parse(respUser);
		JSONObject jsonObject = (JSONObject) obj;

		JSONArray array = (JSONArray) jsonObject.get("data");
		// System.out.println(array);

		JSONObject jsonEntry = (JSONObject) array.get(0);
		this.descript = (String) jsonEntry.get("id");

		return this.descript;
	}

	public JSONArray getTweets(String userId, String bearerToken) throws IOException, URISyntaxException {
		String tweetResponse = null;

		HttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();

		URIBuilder uriBuilder = new URIBuilder(String.format("https://api.twitter.com/2/users/%s/tweets", userId));
		ArrayList<NameValuePair> queryParameters;
		queryParameters = new ArrayList<NameValuePair>();
		queryParameters.add(new BasicNameValuePair("exclude", "retweets"));
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

		String respUser = tweetResponse;

		Object obj = JSONValue.parse(respUser);
		JSONObject jsonObject = (JSONObject) obj;

		JSONArray array = (JSONArray) jsonObject.get("data");

		return array;
	}
}
