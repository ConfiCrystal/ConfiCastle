/**
 * Name: Andy, Christine, Lisa 
 * Date: November 23, 2021 
 * Filename: SpiralAbyss.java 
 * Description: This is the SpiralAbyss class which is a subclass of Location. Spiral Abyss is very similar to domain. It's distinctive features will be implemented in future sprints
*/

// Imported Classes
import java.util.ArrayList;

public class SpiralAbyss extends Location {

    /**
     * Attributes of the SpiralAbyss class
     */
    private int floor;
    private String leyLineDisorder;
    private int chamber;
    private String enemies;
    private boolean divergence;
    private String reward;
    private boolean reset;

    /**
     * Default Constructor of SpiralAbyss
     */
    public SpiralAbyss () {

        super ();
        this.floor = 0;
        this.leyLineDisorder = "";
        this.chamber = 0;
        this.enemies = "";
        this.divergence = true;
        this.reward = "";
        this.reset = false;

    }

    // Accessor Methods
    /**
     * Method: Gets the floor of this SpiralAbyss
     * @return this SpiralAbyss's floor
     */
    public int getFloor () {

        return this.floor;

    }

    /**
     * Method: Gets the leyLineDisorder of this SpiralAbyss
     * @return this SpiralAbyss's leyLineDisorder
     */
    public String getLeyLineDisorder () {

        return this.leyLineDisorder;

    }

    /**
     * Method: Gets the chamber of this SpiralAbyss
     * @return this SpiralAbyss's chamber
     */
    public int getChamber () {

        return this.chamber;

    }

    /**
     * Method: Gets the enemies of this SpiralAbyss
     * @return this SpiralAbyss's enemies
     */
    public String getEnemies () {

        return this.enemies;

    }

    /**
     * Method: Get the divergence of this SpiralAbyss
     * @return this SpiralAbyss's divergence
     */
    public boolean getDivergence () {

        return this.divergence;

    }

    /**
     * Method: Gets the reward of this SpiralAbyss
     * @return this SpiralAbyss's reward
     */
    public String getReward () {

        return this.reward;

    }

    /**
     * Method: Gets the reset of this SpiralAbyss
     * @return this SpiralAbyss's reset boolean
     */
    public boolean getReset () {

        return this.reset;

    }

    // Mutator Methods
    /**
     * Method: Changes the floor 
     * @param newFloor This is the new floor 
     */
    public void changeFloor (int newFloor) {

        this.floor = newFloor;

    }

    /**
     * Method: Changes the leyLineDisorder
     * @param newLeyLineDisorder This is the new leyLineDisorder 
     */
    public void changeLeyLineDisorder (String newLeyLineDisorder) {

        this.leyLineDisorder = newLeyLineDisorder;

    }

    /**
     * Method: Changes the chamber
     * @param newChamber This is the new chamber 
     */
    public void changeChamber (int newChamber) {

        this.chamber = newChamber;

    }

    /**
     * Method: Changes the enemies 
     * @param newEnemies This is the new enemies variable 
     */
    public void changeEnemies (String newEnemies) {

        this.enemies = newEnemies;

    }

    /**
     * Method: Changes the divergence boolean
     * @param newDivergence This is the new divergence boolean
     */
    public void changeDivergence (boolean newDivergence) {

        this.divergence = newDivergence;

    }

    /**
     * Method: Changes the reward
     * @param newReward This is the new reward 
     */
    public void changeReward (String newReward) {

        this.reward = newReward;

    }

    /**
     * Method: Changes the reset boolean
     * @param newReset This is the new reset boolean 
     */
    public void changeReset (boolean newReset) {

        this.reset = newReset;

    }

    //

    /**
     * Method: default toString
     * @return ret This SpiralAbyss's attributes
     */
    public String toString () {

        String ret = "Adjacency: " + getAdjacency () +
                    "Items: " + getItems () +
                    "Chests: " + getChests () + 
                    "Monsters: " + getMonsters () +
                    "Players: " + getPlayers () +
                    "Floor: " + floor +
                    "Ley Line Disorder: " + leyLineDisorder +
                    "Chamber: " + chamber +
                    "Enemies: " + enemies +
                    "Divergence: " + divergence +
                    "Reward: " + reward +
                    "Reset: " + reset; 
        return ret;
        
    }
}