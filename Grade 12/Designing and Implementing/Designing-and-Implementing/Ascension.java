/**
 * Name: Andy, Christine, Lisa 
 * Date: November 23, 2021 
 * Filename: Ascension.java
 * Description: This is the Ascension class which is a subclass of Item.
 */
 
public class Ascension extends Item {
    
   // Default Constructor
   public Ascension () {

      super();

   }
   
   /*
    * Method: Default toString
    * @return ret This Ascension's attributes
    */
   public String toString () {

      String ret = "\nAscension\nName: " + this.getName() + "\nrarity: " + this.getRarity();
      return ret;
      
   }
   
}