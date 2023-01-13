/**
*  Name: Andy Lee
*  Date: October, 14, 2021
*  Program: Entity
*  Description: This class creates entities and is the super class to player, coins, and enemies
*/

// Imported Libraries
import java.awt.Color;

// Square class
public class Entity {

   // Attributes
   private int x, y, length, width;
   private Color color;
   
   /**
   * Method: Entity
   * @param N/A
   * @return N/A
   * Description: Constructor Method
   */
   public Entity (int x, int y, int length, int width, Color color) {
   
      this.x = x;
      this.y = y;
      this.length = length;
      this.width = width;
      this.color = color;
      
   } // End Entity
   
   /*
      ACCESSORS
   */
   
   /**
   * Method: x
   * @param N/A
   * @return int x
   * Description: Returns the x position of the entity
   */
   public int x () {
   
      return this.x;
   
   } // End x
   
   /**
   * Method: y
   * @param N/A
   * @return int y
   * Description: Returns the y position of the entity
   */
   public int y () {
   
      return this.y;
   
   } // End y
   
   /**
   * Method: length
   * @param N/A
   * @return int length
   * Description: Returns the length of the entity
   */
   public int length () {
   
      return this.length;
   
   } // End length
   
   /**
   * Method: width
   * @param N/A
   * @return int width
   * Description: Returns the width of the entity
   */
   public int width () {
   
      return this.width;
   
   } // End width
   
   /**
   * Method: color
   * @param N/A
   * @return Color color
   * Description: Returns the color of the entity
   */
   public Color color () {
   
      return this.color;
   
   } // End color
   
   /*
      MUTATORS
   */
   
   /**
   * Method: xSet
   * @param int x
   * @return void
   * Description: Sets the x position of the entity
   */
   public void xSet (int x) {
   
      this.x = x;
   
   } // End xSet
   
   /**
   * Method: ySet
   * @param int y
   * @return void
   * Description: Sets the y position of the entity
   */
   public void ySet (int y) {
   
      this.y = y;
   
   } // End ySet
   
   /**
   * Method: lengthSet
   * @param int length
   * @return void
   * Description: Sets the length of the entity
   */
   public void lengthSet (int length) {
   
      this.length = length;
   
   } // End lengthSet
   
   /**
   * Method: widthSet
   * @param int width
   * @return void
   * Description: Sets the width of the entity
   */
   public void widthSet (int width) {
   
      this.width = width;
   
   } // End widthSet
   
   /**
   * Method: colorSet
   * @param Color color
   * @return void
   * Description: Sets the color of the entity
   */
   public void colorSet (Color color) {
   
      this.color = color;
   
   } // End xSet

   
} // End class