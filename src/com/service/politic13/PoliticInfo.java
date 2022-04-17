package com.service.politic13;

import java.util.HashMap;
import java.util.Map;


/**
 * Manage all the politicians that clients can add
 * <p>
 * We get back to client all the informations about the politicians with this class
 * </p>
 * <p>
 * All the information : the age, the politicla party
 * </p>
 * <p>
 * We manage all the politicians in HashMap with a string for the key that is politician name, and for the value the PoliticInfo's instance
 * </p>
 * @author Jerrinald | Yanis
 */
public class PoliticInfo {

	private int age; //age of the politician
	private String politicParty; //political party of the politician
	private String twitterName; //Twitter Name of the politician
	
	int o;
	
	/**
	 * Constructor to call and create an instance of this class in PoliticUser class to get the informations from the hash map
	 * 
	 */
	public PoliticInfo() {
		this.o=0;
	}

	/**
	 * Another constructor to create an instance whith age, political party and Twitter name in parameter in the hash map in the method managePolitic()
	 * 
	 * Returns the following status code :
	 * 'name' is added : succesfully added
	 * 
	 * @param age
	 * @param politicParty
	 * @param twitterName 
	 */
	public PoliticInfo(int age, String politicParty, String twitterName) {
		this.age = age;
		this.politicParty = politicParty;
		this.twitterName = twitterName;
	}

	/**
	 * Get the age of a politician
	 * 
	 * Returns the following status code :
	 * age
	 * 
	 * @return this.age the age of a politician
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Get the political Party of a politician
	 * 
	 * Returns the following status code :
	 * political Party
	 * 
	 * @return this.politicParty the political Party of a politician
	 */
	public String getPoliticParty() {
		return this.politicParty;
	}
	
	/**
	 * Get the Twitter name of a political party
	 * 
	 * Returns the following status code :
	 * Twittter Name
	 * 
	 * @return this.twitterName the Twitter name of a political party
	 */
	public String getTwitterName() {
		return this.twitterName;
	}

	/**
	 * Return the list of all the politicians with all the informations about them
	 * 
	 * This hash map will be called in the PoliticUser class to give informations found in this hash map to the client
	 * 
	 * Returns the following status code :
	 * politicalPeople : an hash map of all these politicians and their informations
	 * 
	 * @return politicPeople the hash map
	 */
	public Map<String, PoliticInfo> managePolitic() {

		Map<String, PoliticInfo> politicPeople = new HashMap<String, PoliticInfo>();

		politicPeople.put("Emmanuel Macron", new PoliticInfo(42, "La Republique En Marche", "enmarchefr"));
		politicPeople.put("Marine Le Pen", new PoliticInfo(53, "Rassemblement national", "RNational_off"));
		politicPeople.put("Jean-Luc Melenchon", new PoliticInfo(53, "La France insoumise", "FranceInsoumise"));
		politicPeople.put("Eric Zemmour", new PoliticInfo(53, "Reconquete", "Reconquete2022"));
		politicPeople.put("Valerie Pecresse", new PoliticInfo(53, "Les Republicains", "lesRepublicains"));

		return politicPeople;
	}

	
	/**
	 * Display a particular description of a politician entered in parameter
	 * 
	 * Returns the following status code :
	 * description : the description of a politician 
	 * "" : unable to get the description
	 * 
	 * @param politicName the name of the politician entered in the parameter by the client
	 * @return description the description of a politician whith the age and the political party's name
	 */
	public String displayPolitic(String politicName) {

		String description = "";

		Map<String, PoliticInfo> dispPolitic = managePolitic();

		if (dispPolitic.containsKey(politicName)) { //check if the name entered in parameter is in the hash map

			PoliticInfo info = dispPolitic.get(politicName);
			int age = info.getAge(); //get the age
			String politicParty = info.getPoliticParty(); //get the political party

			String s = Integer.toString(age);

			description = "| Age : " + s + " | Political party : " + politicParty + " |";
		}

		return description;
	}
	
	
	/**
	 * Get the political party's Twitter Name of a politician entered in parameter
	 * 
	 * This method will be called in PoliticUser to get with the political party's Twitter Name the recents Tweets of the political party
	 * 
	 * Returns the following status code :
	 * tn : the twitter name of the political party
	 * "" : unable to get the twitter name of the political party
	 * 
	 * @param politicName the name of the politician entered in the parameter
	 * @return tn the political party's Twitter Name
	 */
	public String getTweetPolitic(String politicName) {

		String description = "";

		Map<String, PoliticInfo> dispPolitic = managePolitic(); //retrieve the hash map of the politicians with their informations
		
		String tn ="";

		if (dispPolitic.containsKey(politicName)) { //check if the politician in parameter is in the hash map

			PoliticInfo info = dispPolitic.get(politicName); //get only the line about the politician in parameter in the hash map
			tn = info.getTwitterName(); //retrieve the twitter name
		}

		return tn;
	}
}
