/**
*  Name: Andy Lee
*  Date: October, 13, 2021
*  Program: Skeleton
*  Description: This program is a class for the skeleton object, extending the mob class
*/

// Skeleton Class
public class Skeleton extends Mob {

  //Attributes
  private int range;


  /**
   * Method: Skeleton
   * @params int x, int y, int z, int hp
   * @return N/A
   * Description: Constructor Method
   */
   public Skeleton(int x, int y, int z, int hp, int range) {
   
      super(x, y, z, hp);
      this.range = range;
      
   } // End Skeleton
   
   /**
   * Method: sound
   * @params N/A
   * @return void
   * Description: Makes the skeleton make a sound
   */
   public void sound() {
   
      System.out.println("Bone Sound");
      
   } // End sound


  //Methods
  /**
   * Method: attack
   * @params int distance
   * @return void
   * Description: Makes the skeleton attack
   */
   public void attack (int distance) {
      
      // Checks if target is hit
      if (distance > range) {
      
         System.out.println("Miss!");
      
      } else {
      
         System.out.println("Hit!");
      
      } // End if
      
   } // End attack
  
} // End Skeleton