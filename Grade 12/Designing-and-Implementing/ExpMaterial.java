/**
 * Name: Andy, Christine, Lisa
 * Date: November 23, 2021
 * Filename: ExpMaterial.java
 * Description: This is the ExpMaterial class which is a subclass of Item.
*/

public class ExpMaterial extends Item {

   // Default Constructor
   public ExpMaterial(){

      super();

   }
   
   /*
    * Method: Default toString
    * @return ret This ExpMaterial's attributes
    */
   public String toString(){

      String ret = "\nExp Material\nName: " + this.getName() + "\nrarity: " + this.getRarity();
      return ret;

   }
   
}