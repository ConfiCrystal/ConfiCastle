/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Location.java
 * Description: This is the Location class.
*/

// Imported Classes
import java.util.ArrayList;
import java.io.*;

public class Location {

    /**
     * Attributes of the Location class
     */
    private ArrayList <Location> adjacency = new ArrayList <Location> ();
    private ArrayList <Item> items = new ArrayList <Item> ();
    private ArrayList <Chest> chests = new ArrayList <Chest> ();
    private ArrayList <Monster> monsters = new ArrayList <Monster> ();
    private ArrayList <Player> players = new ArrayList <Player> ();
    private String description;
    private String name;

    // Represents if you can heal here or not
    private boolean fountain;

    /**
     * General Constructor of Location
     * @param adjacency This is an ArrayList for the current Location of all adjacent locations that can be travelled to
     * @param items This is an ArrayList of all items in the current Location that are on the ground
     * @param chests This is an ArrayList of all chests in the current Location
     * @param monsters This is an ArrayList of all monsters in the current Location
     * @param players This is an ArrayList of all players in the current Location
     * @param description This is the description of this Location
     * @param name This is the name of this Location
     */
    public Location (ArrayList <Location> adjacency, ArrayList <Item> items, ArrayList <Chest> chests, ArrayList <Monster> monsters, ArrayList <Player> players, String description, String name) {
        
        this.adjacency = adjacency;
        this.items = items;
        this.chests = chests;
        this.monsters = monsters;
        this.players = players;
        this.description = description;
        this.name = name;

    }

    /**
     * Default Constructor of Location
     */
    public Location () {

      this.description = "";
      this.name = "";
      this.fountain = false;

    }

    // Accessor Methods  
    /**
     * Method: Gets a monster from this location
     * @param index This is the index at which the monster will be retrieved
     */
    public Monster getMonster (int index) {

        return this.monsters.get (index);

    }

    /**
     * Method: Gets the adjacency of this Location
     * @return ArrayList <Location> This Location's adjacencies
     */
    public ArrayList <Location> getAdjacency () {

        return this.adjacency;

    }

    /**
     * Method: Gets the adjacency of this Location
     * @param index This is the ArrayList index of the adjacency to be accessed
     * @return this Location's adjacency
     */
    public Location getAdjacencyValue (int index) {

        return getAdjacency ().get (index);

    }

    /** 
     * Method: Gets the items of this Location
     * @return ArrayList <Item> This Location's items
     */
    public ArrayList <Item> getItems () {

        return this.items;

    }

    /**
     * Method: Gets the chests of this Location
     * @return ArrayList <Chest> This Location's chests
     */
    public ArrayList <Chest> getChests () {

        return this.chests;

    }

    /**
     * Method: Gets a chest in this Location
     * @param index This is the ArrayList index of the chest to be accessed
     * @return a specifc chest in this Location
     */
    public Chest getChest (int index) {

        return this.chests.get (index);

    }

    /**
     * Method: Gets the monsters of this Location
     * @return ArrayList <Monster> This Location's monsters
     */
    public ArrayList <Monster> getMonsters () {

        return this.monsters;

    }

    /**
     * Method: Gets the size of the monsters at this location
     * @return integer of what the Monster ArrayList size is
     */
    public int getMonsterSize () {

        return this.monsters.size();

    }

    /**
     * Method: Gets the players of this Location
     * @return ArrayList <Player> This Location's players
     */
    public ArrayList <Player> getPlayers () {

        return this.players;

    }

    /**
     * Method: Gets the description of this location
     * @return this Location's description
     */
    public String getDescription () {

        return this.description;

    }

    /**
     * Method: Gets the name of this location
     * @return this Location's name
     */
    public String getName () {

        return this.name;

    }

    /**
     * Method: Gets the fountain status of this location
     * @return this Location's fountain status
     */
    public boolean getFountain () {

        return this.fountain;

    }
    
    // Mutator Methods
    /**
     * Method: Changes the adjacency of this Location
     * @param index This is the ArrayList index that needs to be changed
     * @param newAdjacency This is the new adjacency that will replace the original at a specified index
     */
    public void changeAdjacency (int index, Location newAdjacency) {

        this.adjacency.set (index, newAdjacency);

    }
    /**
     * Method: Adds an adjacency to this Location
     * @param newAdjacency This is the new adjacency that will be added
     */
    public void addAdjacency (Location newAdjacency) {

        this.adjacency.add (newAdjacency);

    }

    /**
     * Method: Adds a Chest to this domain
     * @param newChest This is the new chest that will be added
     * @return void
     */
    public void addChest (Chest newChest) {

      this.chests.add (newChest);

    }

    /**
     * Method: Adds a monster to this locaiton
     * @param newMonster This is the new monster that will be added
     */
    public void addMonster (Monster newMonster) {

        this.monsters.add (newMonster);

    }

    /**
     * Method: Removes the monster at a specific index
     * @param index This is the index at which the monster will be removed
     */
    public void removeMonster (int index) {

        this.monsters.remove (index);

    }

    /**
     * Method: Clears the monster ArrayList
     */
    public void clearMonsters () {

        this.monsters.clear ();

    }

    /**
     * Method: Changes the items of this Location
     * @param index This is the ArrayList index that needs to be changed
     * @param newItem This is the new item that will replace the original at a specified index
     */
    public void changeItems (int index, Item newItem) {

        this.items.set (index, newItem);

    }
    
    /**
     * Method: Changes the chests of this Location
     * @param index This is the ArrayList index that needs to be changed
     * @param newChest This is the new chest that will replace the original at a specified index
     */
    public void changeChests (int index, Chest newChest) {

        this.chests.set (index, newChest);

    }

    /**
     * Method: Changes the monsters of this Location
     * @param index This is the ArrayList index that needs to be changed
     * @param newMonster This is the new monster that will replace the original at a specified index
     */
    public void changeMonsters (int index, Monster newMonster) {

        this.monsters.set (index, newMonster);
        
    }

    /**
     * Method: Changes the players of this Location
     * @param index This is the ArrayList index that needs to be changed
     * @param newPlayer This is the new monster that will replace the original at a specified index
     */
    public void changePlayers (int index, Player newPlayer) {

        this.players.set (index, newPlayer);

    }

    /**
     * Method: Changes the description of this location
     * @param newDescription This is the new description that will replace the original
     */
    public void changeDescription (String newDescription) {

        this.description = newDescription;

    }

    /**
     * Method: Changes the name of this location
     * @param newName This is the new name that will replace the original
     */
    public void changeName (String newName) {

        this.name = newName;

    }

    /**
     * Method: Changes the fountain status of this locaiton
     * @param newFountain This is the new fountain status that will replace the original
     */
    public void changeFountain (boolean newFountain) {

        this.fountain = newFountain;

    }

    //

    /**
     * Method: default toString
     * @return ret This is this Location's attributes
     */
    public String toString () {

        String ret = "Adjacency: " + adjacency +
                    "Items: " + items +
                    "Chests: " + chests + 
                    "Monsters: " + monsters +
                    "Players: " + players; 

        return ret;

    }

    /**
     * Method: Ends combat
     * @param combat
     */
    public void endCombat (Combat combat) {

        combat = null;

    }
    
    /**
     * Method: Collect Rewards
     */
    public void collectRewards () {

        System.out.println ("A reward has beeen collected.");

    }

    /**
   * Method: retrieveBaseLocation
   * @params name This is the name of the Location being retrieved
   * @params locations This is ArrayList of the locations 
   * @return void
   * Description: Retrieves a base location from a properly formatted text file
   */
   public void retrieveBaseLocation (String name, ArrayList <Location> locations) {
     
        try {

            // To read from the file
            BufferedReader reader = new BufferedReader (new FileReader ((name + ".txt")));
            
            // Fills in stored Location info from base file
            int index = Integer.parseInt (reader.readLine ());
            for (int i = 0; i < index; i++) {

                // Adjacency inputs
                String input = reader.readLine ();
                
                for (int j = 0; j < locations.size(); j++) {

                if (input.equalsIgnoreCase (locations.get (j).getName ())) this.addAdjacency (locations.get (j));

                }

            }
            
            this.changeName (reader.readLine ());
            this.changeDescription (reader.readLine ());
            this.changeFountain (Boolean.valueOf (reader.readLine ()));

            // Closes the reader
            reader.close ();

        } catch (IOException e) {

        }

   } // retrieveBaseLocation
    
}