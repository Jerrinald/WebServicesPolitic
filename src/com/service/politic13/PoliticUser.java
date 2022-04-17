package com.service.politic13;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * The class whith Jax-ws annotations that will be called by the client
 * <p>
 * In this class we manage the client's politician list, all the information that will be retrieved by the client
 * </p>
 * We call for that 2 class : TwitterManage, PoliticInfo
 *  <p>
 * We retrieve API Twitter request from the class TwitterManage
 * </p>
 * @author Jerrinald | Yanis
 */
@WebService(targetNamespace = "http://politic13.service.com/", portName = "PoliticUserPort", serviceName = "PoliticUserService")
public class PoliticUser {
	
	Map<Integer, String> politicPeopleList = new HashMap<Integer, String>(); // the client's politician list where he can add politican
	
	int incrList = 1; //for id key in client's politician list
	

	/**
	 * Get the description(age, political party) of a politician
	 * 
	 * Returns one of the following status codes :
	 * politicDescription : the politician's description
	 * "" : unable to got the politician's description
	 * 
	 * @param name the name of the politician entered by the client
	 * @return the politician's description to the client
	 */
	@WebMethod(operationName = "getPoliticDescription", action = "urn:GetPoliticDescription")
	@WebResult(name = "return")
	public String getPoliticDescription(@WebParam(name = "arg0") String name) {

		PoliticInfo info = new PoliticInfo();

		String politicDescription = info.displayPolitic(name); //get the description with the class PoliticInfo
		
		if(politicDescription != "") { //if we get null the name of the politician in parameter is not correct
			return politicDescription;
		}else {
			return "";
		}

	}
	
	/**
	 * Add a new politician in client's list
	 * 
	 * Returns the following status code :
	 * 'name' is added : succesfully added
	 * 
	 * @param name the name of the politician entered by the client
	 * @return the succesfully add mention to the client
	 */
	@WebMethod(operationName = "addPolitician", action = "urn:AddPolitician")
	@WebResult(name = "return")
	public String addPolitician(@WebParam(name = "arg0") String name) {
		
		this.politicPeopleList.put(incrList, name); //add in the list
		incrList++; //increment the id key
		
		return name + " is added !";
	}
	
	/**
	 * Display the client's politician list
	 * 
	 * Returns the following status code :
	 * politicList : the client's politicians list
	 * "" : unable to display the politicians list
	 * 
	 * @return the client's politicians list to him
	 */
	@WebMethod(operationName = "displayPoliticList", action = "urn:DisplayPoliticList")
	@WebResult(name = "return")
	public String displayPoliticList() {
		
		String politicList = "";
		
		for(Entry<Integer, String> element : this.politicPeopleList.entrySet()) {
			politicList += element.getValue() + " | ";
		}
		
		return politicList;
	}
	
	/**
	 * Detect if a politician is in client's politician list
	 * 
	 * Returns the following status code :
	 * true : the politician is in the list
	 * false : the politician is not in the list
	 * 
	 * This method is called when the client wants to get Information about one his politicians list
	 * 
	 * @param name the politician entered by the client
	 * @return true or false 
	 */
	@WebMethod(operationName = "politicInList", action = "urn:PoliticInList")
	@WebResult(name = "return")
	public boolean politicInList(@WebParam(name = "arg0") String name) {
		
		if(this.politicPeopleList.containsValue(name)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Get The recents tweets of the politician's political party put in parameter
	 * 
	 * Returns the following status code :
	 * string[][] : the politician's political party recents tweets 
	 * "" : unable to get the politician's recent tweets
	 * 
	 * @param name the politician entered by the client
	 * @return the political party's recents tweets in double String Array with the the date and the text of the tweets 
	 */
	@WebMethod(operationName = "getTweetPolitic", action = "urn:GetTweetPolitic")
	@WebResult(name = "return")
	public String[][] getTweetPolitic(@WebParam(name = "arg0") String name) {
		
		String twPolitic[][];
		
		PoliticInfo info = new PoliticInfo();

		String politicTwitterName = info.getTweetPolitic(name); //get the twitter name of the politician
		
		//the token to authentificate to Twittter API
		String bearerToken = "AAAAAAAAAAAAAAAAAAAAAHO0bQEAAAAAepgXJrlMN9%2FYtY0D1t35PvLBDno%3DWJUa3JjgMw95ubNQEBJHoEcSoMckcFC30oTgGp8QyTMz99PCg6";

		//call the TwitterManage class to get the recents tweets
		TwitterManage pol = new TwitterManage(bearerToken);
		String usTw = "";

		try {
			usTw = pol.getUser(politicTwitterName); // the politician's ID Twitter account
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONArray array = null;
		try {
			array = pol.getTweets(usTw, bearerToken); //the politician's recents tweets in a JSONArray
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		twPolitic = new String[array.size()][2]; // we retrieve the recents tweets in a double array to get the date and the text of the tweets 
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonEntry = (JSONObject) array.get(i);
			String textTw = (String) jsonEntry.get("text");
			String timeTw = (String) jsonEntry.get("created_at");
			
			String replaceTime = timeTw.replace('T', ' ');
			replaceTime=replaceTime.replace('Z',' ');
			
			String replaceText = textTw.replace("\n\n", "\n");
			replaceText=replaceText.replace("\uD83D\uDD34"," "); //clear the emoji unicode
			replaceText=replaceText.replace("\uD83C\uDDEB\uD83C\uDDF7"," "); //clear the emoji unicode
  	     			
			twPolitic[i][0] = replaceTime; //the date of the tweet
			twPolitic[i][1] = replaceText; //the text of the tweet
		}
		
		return twPolitic; //return the double array of the politician's recents tweets
	}
	
	/**
	 * clear the client's politicians list and finish the program
	 * 
	 * Returns the following status code :
	 * 0 : finish execution of the program 
	 * 
	 * @return 0 to finish the program when the client is done with the program
	 */
	@WebMethod(operationName = "clearList", action = "urn:ClearList")
	@WebResult(name = "return")
	public int clearList() {
		this.politicPeopleList.clear();
		return 0;
	}
}
