/**
*  Name: Andy Lee
*  Date: October, 14, 2021
*  Program: Coin
*  Description: This class creates coins
*/

// Imported Libraries
import java.awt.Color;

// Square class
public class Coin extends Entity{

   // Attributes
   private boolean claimed;
   
   /**
   * Method: Coin
   * @params N/A
   * @return N/A
   * Description: Constructor Method
   */
   public Coin (int x, int y, int length, int width, Color color, boolean claimed) {
   
      super(x, y, length, width, color);
      this.claimed = claimed;
      
   } // End Coin
   
   /*
      ACCESSORS
   */
   
   /**
   * Method: claimed
   * @param N/A
   * @return boolean claimed
   * Description: Returns the claimed status of the coin
   */
   public boolean claimed () {
   
      return this.claimed;
   
   } // End claimed
   
   /*
      MUTATORS
   */
   
   /**
   * Method: claimedSet
   * @param boolean claimed
   * @return void
   * Description: Sets the claimed status of the coin
   */
   public void claimedSet (boolean claimed) {
   
      this.claimed = claimed;
   
   } // End claimedSet
   
} // End class