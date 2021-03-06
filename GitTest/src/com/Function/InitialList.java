package com.Function;
import java.util.ArrayList; 
import com.Data.*;

/**
 * Represents the initial information lists containing
 * info on players and the properties within the game. 
 */
public class InitialList {
	
	/**
	 * Method adds players into a list and names them.
	 * It assigns intelligences to CPU players.
	 * @return the list of players
	 */
	public static ArrayList<Player> playersList() {
		System.out.println("Initializing...please enter your name.");
		Player p0 = new Player(0);
		p0.setPlayerName("Bob");
	    Player c1 = new Player(1);
	    Player p1=createCP.createComputerPlayer(c1,2);
	    p1.setPlayerName("Aeson");
	    Player c2 = new Player(2);
	    Player p2=createCP.createComputerPlayer(c2,1);
	    p2.setPlayerName("Aster");
	    Player c3 = new Player(3);
	    Player p3=createCP.createComputerPlayer(c3,2);
	    p3.setPlayerName("Lumen");

	    ArrayList<Player> playerList =new ArrayList<Player>();
	    playerList.add(p0);
	    playerList.add(p1);
	    playerList.add(p2);
	    playerList.add(p3);
	    
		return playerList;	
	}
	
	/**
	 * Method adds players to a list without intialization of names
	 * or CPU intelligences
	 * @param test the
	 * @return the list of players
	 */
	public static ArrayList<Player> playersList(String test) {

		Player p0 = new Player(1);
		Player p1 = new Player(2);
		Player c2 = new Player(3);
		Player c3 = new Player(4);

		ArrayList<Player> playerList =new ArrayList<Player>();
		playerList.add(p0);
		playerList.add(p1);
		playerList.add(c2);
		playerList.add(c3);
		return playerList;	
	}
	
	/**
	 * Method initializes a list of properties to be added
	 * into a list.
	 * @return the list of properties.
	 */
	public static ArrayList<Property> propertiesList() {
		Property b0 = new Property(0,"Start");
		Property b1 = new Property(1,"Canada");
		Property b2 = new Property(2,"Brazil");
		Property b3 = new Property(3,"Russia");
		Property b4 = new Property(4, "Mexico");
		Property b5 = new Property(5,"Random");
		Property b6 = new Property(6,"Egypt");
		Property b7 = new Property(7,"Turkey");
		Property b8 = new Property(8,"Germany");
		Property b9 = new Property(9,"United Kingdom");
		Property b10 = new Property(10,"Jail");
		Property b11 = new Property(11,"Italy");
		Property b12 = new Property(12,"South Africa");
		Property b13 = new Property(13,"South Korea");
		Property b14 = new Property(14,"Colombia");
		Property b15 = new Property(15,"Radom");
		Property b16 = new Property(16,"China");
		Property b17 = new Property(17,"India");
		Property b18 = new Property(18,"United States");
		Property b19 = new Property(19,"Japan");
		ArrayList<Property> propertiesList = new ArrayList<Property>();
		propertiesList.add(b0);
		propertiesList.add(b1);
		propertiesList.add(b2);
		propertiesList.add(b3);
		propertiesList.add(b4);
		propertiesList.add(b5);
		propertiesList.add(b6);
		propertiesList.add(b7);
		propertiesList.add(b8);
		propertiesList.add(b9);
		propertiesList.add(b10);
		propertiesList.add(b11);
		propertiesList.add(b12);
		propertiesList.add(b13);
		propertiesList.add(b14);
		propertiesList.add(b15);
		propertiesList.add(b16);
		propertiesList.add(b17);
		propertiesList.add(b18);
		propertiesList.add(b19);
		return propertiesList;
	}

}
