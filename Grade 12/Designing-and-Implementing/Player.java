/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Player.java
 * Description: This Class represents the player and their active team
*/

// Imported Classes
import java.util.ArrayList;

public class Player {
    
  // Attributes --------------------
  private ArrayList <Hero> activeTeam = new ArrayList <Hero> ();

  /**
   * Method: Player
   * @params N/A
   * @return N/A
   * Description: Default Constructor
   */
   public Player () {
     
     for (int i = 0; i < 4; i ++) {
     
       this.activeTeam.add(new Hero());
     
     }
      
   } // Player

    // Mutators ------------------------------
    /**
    * Method: Changes an active Hero
    * @params int index, Hero hero
    * @return void
    */
    public void changeActiveHero (int index, Hero hero) {

      this.activeTeam.set(index, hero);

    }

    // Accesors ------------------------------
   /**
    * Method: Gets an active Hero
    * @params int index
    * @return Hero
    */
    public Hero getActiveHero (int index) {

      return this.activeTeam.get(index);

    }

    // Misc ------------------------------
    /**
    * Method: Gets a string of all attributes
    * @params N/A
    * @return String
    */
    public String toString () {
      
      // Initialization of output String
      String output = "";

      // Gathers all attributes inside this string      
      for (int i = 0; i < 5; i++) {
        
        output += "Hero #" + (i + 1) + ": " + this.getActiveHero(i) + "\n";
      
      }

      return output;
      
    }

}