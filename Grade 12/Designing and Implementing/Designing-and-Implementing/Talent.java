/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: Talent.java
 * Description: This is the Talent class which is a subclass of Item. Talent's interactions with other classes will be done through the instanceof keyword.
*/

public class Talent extends Item{
   
   //default constructor
   public Talent(){

      super();

   }
   
   /*
    * Method: Default toString
    * @return ret This Talent's attributes
    */
   public String toString(){

      String ret = "\nTalent\nName: " + this.getName() + "\nrarity: " + this.getRarity();

      return ret;

   }
   
}