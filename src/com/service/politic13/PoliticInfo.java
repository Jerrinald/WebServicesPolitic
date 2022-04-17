package com.service.politic13;

import java.util.HashMap;
import java.util.Map;

public class PoliticInfo {

	private int age;
	private String politicParty;
	private String twitterName;
	
	int o;
	
	
	public PoliticInfo() {
		this.o=0;
	}

	public PoliticInfo(int age, String politicParty, String twitterName) {
		this.age = age;
		this.politicParty = politicParty;
		this.twitterName = twitterName;
	}

	public int getAge() {
		return this.age;
	}

	public String getPoliticParty() {
		return this.politicParty;
	}
	
	public String getTwitterName() {
		return this.twitterName;
	}

	public Map<String, PoliticInfo> managePolitic() {

		Map<String, PoliticInfo> politicPeople = new HashMap<String, PoliticInfo>();

		politicPeople.put("Emmanuel Macron", new PoliticInfo(42, "La Republique En Marche", "enmarchefr"));
		politicPeople.put("Marine Le Pen", new PoliticInfo(53, "Rassemblement national", "RNational_off"));
		politicPeople.put("Jean-Luc Melenchon", new PoliticInfo(53, "La France insoumise", "FranceInsoumise"));
		politicPeople.put("Eric Zemmour", new PoliticInfo(53, "Reconquete", "Reconquete2022"));
		politicPeople.put("Valerie Pecresse", new PoliticInfo(53, "Les Republicains", "lesRepublicains"));

		return politicPeople;
	}

	public String displayPolitic(String politicName) {

		String description = "";

		Map<String, PoliticInfo> dispPolitic = managePolitic();

		if (dispPolitic.containsKey(politicName)) {

			PoliticInfo info = dispPolitic.get(politicName);
			int age = info.getAge();
			String politicParty = info.getPoliticParty();

			String s = Integer.toString(age);

			description = "| Age : " + s + " | Political party : " + politicParty + " |";
		}

		return description;
	}
	
	public String getTweetPolitic(String politicName) {

		String description = "";

		Map<String, PoliticInfo> dispPolitic = managePolitic();
		
		String tn ="";

		if (dispPolitic.containsKey(politicName)) {

			PoliticInfo info = dispPolitic.get(politicName);
			tn = info.getTwitterName();
		}

		return tn;
	}
}
