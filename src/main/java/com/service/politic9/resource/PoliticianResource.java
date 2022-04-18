package com.service.politic9.resource;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import com.service.politic9.service.TwitterRequest;
@Path("/politician")
public class PoliticianResource{
	
	TwitterRequest twitterRequest = new TwitterRequest();
	String bearerToken = "AAAAAAAAAAAAAAAAAAAAAE1EbQEAAAAAI4lMeoIxSrBbNexvj1zlF1kQ9ks%3DOTkkgFVA4F9h7lBdfjSoAqjsOi9yelvyUMimI9z2XJ9rl4mVQ9";
	
    @GET
    @Path("bio/{userId}")
    @Produces("text/plain")
    public String getBio(@PathParam("userId") String userId) throws IOException, URISyntaxException{
    	return twitterRequest.getPoliticianTweets(userId, bearerToken);
    }
    
    @GET
    @Path("tweet/{ids}")
    @Produces("text/plain")
    public String getTweet(@PathParam("ids") String ids) throws IOException, URISyntaxException{
    	return twitterRequest.getPoliticianTweet(ids, bearerToken);
    }
    
    @GET
    @Path("tweets/{userId}")
    @Produces("text/plain")
    public String getTweets(@PathParam("userId") String userId) throws IOException, URISyntaxException{
    	return twitterRequest.getPoliticianTweets(userId, bearerToken);
    }
    
}