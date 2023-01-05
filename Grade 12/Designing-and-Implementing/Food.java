/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Food.java
 * Description: This is the Food class which is a subclass of Item. Significant interaction between this class and the game will be saved for future sprints
*/

public class Food  extends Item {
   //attributes
   private String quality;
   private String type;
   
   //default constructor
   public Food () {

      super();
      this.quality = "";
      this.type = "";

   }
   
   //accessor methods
   public String getQuality () {

      return this.quality;

   }
   public String getType () {

      return this.type;

   }
   
   //methods
   /**
   * Method: beEaten
   * @params String name
   * @return N/A
   * Description: returns message after player eats food
   */
   public void beEaten (String name) {

      System.out.println (name + " ate the " + this.getName());

   }
   
   /*
    * Method: Default toString 
    * @return ret This Food's attributes
    */
   public String toString () {

      String ret = "Name: " + this.getName() + "\nrarity: " + this.getRarity() + "\nQuality: " + this.getQuality() + "\ntype: " + this.getType();
      return ret;

   }
   
}