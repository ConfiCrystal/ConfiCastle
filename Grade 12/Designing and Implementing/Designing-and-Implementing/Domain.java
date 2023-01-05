/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Domain.java
 * Description: This is the Domain class which is a subclass of Location.
*/

// Imported Class
import java.util.*;
import java.io.*;

public class Domain extends Location {
  
    /**
     * Attributes of the Domain class
     */
    private int recommendedLevel;
    private ArrayList <Chest> rewards = new ArrayList <Chest> ();
    
    // trounce is a concept that will be saved for future sprints.  It represents a domain that resets only after a certain timeframe
    private boolean trounce;

    /**
     * Default Constructor of Domain
     */
    public Domain () {
        super ();
        this.recommendedLevel = 0;
        this.trounce = false;
    }

    // Accessor Methods
    /**
     * Method: Gets the recommendedLevel of this Domain
     * @return this Domain's recommendedLevel
     */
    public int getRecommendedLevel () {

        return this.recommendedLevel;

    }

    /**
     * Method: Gets the trounce of this Domain
     * @return this Domain's trounce
     */
    public boolean getTrounce () {

        return this.trounce;

    }

    // Mutator Methods
    /**
     * Method: Changes the recommended level of this Domain
     * @param newRecLevel This is the new recommended level
     */
    public void changeRecommendedLevel (int newRecommendedLevel) {

        this.recommendedLevel = newRecommendedLevel;

    }

    /**
     * Method: Changes the trounce boolean
     * @param newTrounce This is the new trounce boolean
     */
    public void changeTrounce (boolean newTrounce) {

        this.trounce = newTrounce;

    }

    /**
     * Method: Adds a reward to this domain
     * @param Chest chest
     * @return void
     */
    public void getReward (Chest chest) {

        this.rewards.add (chest);

    }

    //

    /**
     * Method: Fills this domain with random monsters 
     */
    public void fill () {

        Random r = new Random ();

        this.clearMonsters();
        
        for (int i = 0; i < (r.nextInt (1) + 1) * 5; i++) {
          
            this.addMonster (new Monster ());

            // Initialization
            Monster monster = this.getMonster (i);

            // Adds sample values for monsters, slightly randomized for quantifiable values
            monster.changeName ("Hilichurl " + (i+1));
            monster.changeElement ("Geo");
            monster.changeWeapon (new Weapon ());
            monster.changeHp (r.nextInt (400) + 1);
            monster.changeHpMax (monster.getHp ()); 
            monster.changeBaseDamage (r.nextInt (20) + 1);

        }

        this.addMonster (new Boss());
        Monster monster = ((Boss)this.getMonster (this.getMonsterSize () - 1));
        monster.changeName ("Lawachurl");
        monster.changeElement ("Geo");
        monster.changeWeapon (new Weapon ());
        monster.changeHp (r.nextInt (1000) + 1);
        monster.changeHpMax (monster.getHp ());
        monster.changeBaseDamage (r.nextInt (50) + 1);
        monster.changeSkill ("Smash with rock");
        monster.changeBurst ("Smash with large rock");
        
    }
    
    /**
     * Method: default toString
     * @return ret This Domain's attributes
     */
    public String toString () {

        String ret = "Adjacency: " + getAdjacency () +
                    "Items: " + getItems () +
                    "Chests: " + getChests () + 
                    "Monsters: " + getMonsters () +
                    "Players: " + getPlayers () +
                    "Recommended Level: " + recommendedLevel +
                    "Description: " + getDescription () +
                    "Name: " + getName () +
                    "Trounce: " + trounce; 
        return ret;

    }

    /**
   * Method: retrieveBaseLocation
   * @params name This is the name of the Location being retrieved
   * @params locations This is an ArrayList of the locations in this Domain
   * @return void
   * Description: Retrieves a base location from a properly formatted text file
   */
   public void retrieveBaseLocation (String name, ArrayList <Location> locations) {

        try {

            // To read from the file
            BufferedReader reader = new BufferedReader (new FileReader ((name + ".txt")));
            
            int index = Integer.parseInt (reader.readLine ());
            for (int i = 0; i < index; i++) {

                // Adjacency inputs
                String input = reader.readLine ();
                
                for (int j = 0; j < locations.size (); j++) {

                    if (input.equalsIgnoreCase (locations.get (j).getName ())) this.addAdjacency (locations.get (j));

                }

            }
            
            this.changeName (reader.readLine());
            this.changeDescription (reader.readLine());
            this.changeFountain (Boolean.valueOf (reader.readLine()));
            
            // Fills in stored Locaiton info from base file
            this.changeRecommendedLevel (Integer.parseInt (reader.readLine()));
            this.changeTrounce (Boolean.valueOf (reader.readLine()));

            // Closes the reader
            reader.close ();

        } catch (IOException e) {

        }

   } // retrieveBaseLocaiton
    
}