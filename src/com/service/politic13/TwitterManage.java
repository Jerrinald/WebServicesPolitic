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


/**
 * Manage the API Twitter requests with the class PoliticUser
 * <p>
 * In this class we get with Twitter API v2 a Twitter's user detail(especially the ID) and a user's recents tweets
 * </p>
 * <p>
 * The bearerToken for the authentification with Twitter's API v2
 * </p>
 * @author Jerrinald | Yanis
 */
public class TwitterManage {

	String bt = "";
	String descript = "";

	/**
	 * Get the bearerToken from the PoliticUser class
	 * Constructor for this class to call this class by PoliticUser class
	 * 
	 * @param bearerToken the bearerToken
	 */
	public TwitterManage(String bearerToken) {
		this.bt = bearerToken;
	}

	/**
	 * Get the Twitter's ID from a Twitter name entered in parameter
	 * 
	 * Returns one of the following status codes :
	 * id : ID of the Twitter'account
	 * "" : unable to get the ID of the Twitter'account
	 * 
	 * @param name the twitter's account(Twitter Name)
	 * 
	 * @throws IOException
	 * @throws URISyntaxException
	 * 
	 * @return the ID of a Twitter'account
	 */
	public String getUser(String name) throws IOException, URISyntaxException {

		String userResponse = null;

		HttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();

		URIBuilder uriBuilder = new URIBuilder("https://api.twitter.com/2/users/by");
		ArrayList<NameValuePair> queryParameters;
		queryParameters = new ArrayList<NameValuePair>();
		queryParameters.add(new BasicNameValuePair("usernames", name)); // the parameter in the URL
		queryParameters.add(new BasicNameValuePair("user.fields", "created_at,description,pinned_tweet_id")); // the parameter in the URL
		uriBuilder.addParameters(queryParameters);

		HttpGet httpGet = new HttpGet(uriBuilder.build());
		httpGet.setHeader("Authorization", String.format("Bearer %s", this.bt));
		httpGet.setHeader("Content-Type", "application/json");

		HttpResponse response = httpClient.execute(httpGet);

		HttpEntity entity = response.getEntity();
		if (null != entity) {
			userResponse = EntityUtils.toString(entity, "UTF-8");
		}

		String respUser = userResponse; // get the data from the request 

		Object obj = JSONValue.parse(respUser);
		JSONObject jsonObject = (JSONObject) obj;

		JSONArray array = (JSONArray) jsonObject.get("data");
		// System.out.println(array);

		JSONObject jsonEntry = (JSONObject) array.get(0);
		this.descript = (String) jsonEntry.get("id"); //filter by only the ID

		return this.descript;
	}

	/**
	 * Get the recents tweets of a Twitter account with the ID entered in parameter
	 * 
	 * Returns one of the following status codes :
	 * array : A JSONArray instance with all the recents tweets
	 * "" : unable to get the recents tweets
	 * 
	 * @param userId the twitter's ID account
	 * @param bearerToken the bearerToken
	 * 
	 * @throws IOException
	 * @throws URISyntaxException
	 * 
	 * @return the recents tweets in a JSONArray
	 */
	public JSONArray getTweets(String userId, String bearerToken) throws IOException, URISyntaxException {
		String tweetResponse = null;

		HttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();

		URIBuilder uriBuilder = new URIBuilder(String.format("https://api.twitter.com/2/users/%s/tweets", userId));
		ArrayList<NameValuePair> queryParameters;
		queryParameters = new ArrayList<NameValuePair>();
		queryParameters.add(new BasicNameValuePair("exclude", "retweets")); // exclude the retweets
		queryParameters.add(new BasicNameValuePair("tweet.fields", "created_at")); // get the tweets's text with the date
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
