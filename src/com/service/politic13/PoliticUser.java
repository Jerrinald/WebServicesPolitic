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

@WebService(targetNamespace = "http://politic13.service.com/", portName = "PoliticUserPort", serviceName = "PoliticUserService")
public class PoliticUser {
	
	Map<Integer, String> politicPeopleList = new HashMap<Integer, String>();
	int incrList = 1;
	

	@WebMethod(operationName = "getPoliticDescription", action = "urn:GetPoliticDescription")
	@WebResult(name = "return")
	public String getPoliticDescription(@WebParam(name = "arg0") String name) {

		PoliticInfo info = new PoliticInfo();

		String politicDescription = info.displayPolitic(name);
		
		if(politicDescription != "") {
			return politicDescription;
		}else {
			return "";
		}

	}
	

	@WebMethod(operationName = "addPolitician", action = "urn:AddPolitician")
	@WebResult(name = "return")
	public String addPolitician(@WebParam(name = "arg0") String name) {
		
		this.politicPeopleList.put(incrList, name);
		incrList++;
		
		return name + " is added !";
	}
	

	@WebMethod(operationName = "displayPoliticList", action = "urn:DisplayPoliticList")
	@WebResult(name = "return")
	public String displayPoliticList() {
		
		String politicList = "";
		
		for(Entry<Integer, String> element : this.politicPeopleList.entrySet()) {
			politicList += element.getValue() + " | ";
		}
		
		return politicList;
	}
	

	@WebMethod(operationName = "politicInList", action = "urn:PoliticInList")
	@WebResult(name = "return")
	public boolean politicInList(@WebParam(name = "arg0") String name) {
		
		if(this.politicPeopleList.containsValue(name)) {
			return true;
		}else {
			return false;
		}
	}
	

	@WebMethod(operationName = "getTweetPolitic", action = "urn:GetTweetPolitic")
	@WebResult(name = "return")
	public String[][] getTweetPolitic(@WebParam(name = "arg0") String name) {
		
		String twPolitic[][];
		
		//twPolitic = new String[10][2];

		PoliticInfo info = new PoliticInfo();

		String politicTwitterName = info.getTweetPolitic(name);
		
		String bearerToken = "AAAAAAAAAAAAAAAAAAAAAHO0bQEAAAAAepgXJrlMN9%2FYtY0D1t35PvLBDno%3DWJUa3JjgMw95ubNQEBJHoEcSoMckcFC30oTgGp8QyTMz99PCg6";

		TwitterManage pol = new TwitterManage(bearerToken);
		String usTw = "";

		try {
			usTw = pol.getUser(politicTwitterName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONArray array = null;
		try {
			array = pol.getTweets(usTw, bearerToken);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		twPolitic = new String[array.size()][2];
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonEntry = (JSONObject) array.get(i);
			String textTw = (String) jsonEntry.get("text");
			String timeTw = (String) jsonEntry.get("created_at");
			String replaceTime = timeTw.replace('T', ' ');
			replaceTime=replaceTime.replace('Z',' ');
			//System.out.println("Tweet date : " + replaceString);
			String replaceText = textTw.replace("\n\n", "\n");
			replaceText=replaceText.replace("\uD83D\uDD34"," ");
			replaceText=replaceText.replace("\uD83C\uDDEB\uD83C\uDDF7"," ");
  	     
			//System.out.println("Tweet text : " + replaceStringdd + "\n");
			
			twPolitic[i][0] = replaceTime;
			twPolitic[i][1] = replaceText;
		}
		
		return twPolitic;
	}
	

	@WebMethod(operationName = "clearList", action = "urn:ClearList")
	@WebResult(name = "return")
	public int clearList() {
		this.politicPeopleList.clear();
		return 0;
	}
}
