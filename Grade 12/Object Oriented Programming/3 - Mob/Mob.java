/**
*  Name: Andy Lee
*  Date: October, 13, 2021
*  Program: Mob
*  Description: This program is a class for the mob object
*/

// Mob Class
public class Mob {

   private int x,y,z;
   private int hp;
   
   /**
   * Method: Mob
   * @params int x, int y, int z, int hp
   * @return N/A
   * Description: Constructor Method
   */
   public Mob(int x, int y, int z, int hp) {
   
      this.x = x;
      this.y = y;
      this.z = z;
      this.hp = hp;
      
   } // End Mob

   //Accessors
   /**
   * Method: getX
   * @params N/A
   * @return int
   * Description: Accessor Method
   */
   public int getX() {
   
      return this.x;
      
   } // End getX

   /**
   * Method: getY
   * @params N/A
   * @return int
   * Description: Accessor Method
   */
   public int getY() {
   
      return this.y;
      
   } // End getY

   /**
   * Method: getZ
   * @params N/A
   * @return int
   * Description: Accessor Method
   */
   public int getZ() {
   
      return this.z;
      
   } // End getZ

   /**
   * Method: getHP
   * @params N/A
   * @return int
   * Description: Accessor Method
   */
   public int getHP() {
   
      return this.hp;
      
   } // End getHP

   //Mutators
   /**
   * Method: move
   * @params int xChagne, int yChange, int zChange
   * @return void
   * Description: moves a mob
   */
   public void move(int xChange, int yChange, int zChange) {
   
      this.x += xChange;
      this.y += yChange;
      this.z += zChange;
      
   } // End move
   
   /**
   * Method: sound
   * @params N/A
   * @return void
   * Description: Causes a mob to make a sound
   */
   public void sound() {
   
      System.out.println("????");
      
   } // End sound
   
} // End class