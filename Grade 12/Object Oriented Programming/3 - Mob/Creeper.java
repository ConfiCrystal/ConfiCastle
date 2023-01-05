/**
*  Name: Andy Lee
*  Date: October, 13, 2021
*  Program: Creeper
*  Description: This program is a class for the creeper object, extending the mob class
*/

// Creeper Class
public class Creeper extends Mob {
   
   /**
   * Method: Creeper
   * @params int x, int y, int z, int hp
   * @return N/A
   * Description: Constructor Method
   */
   public Creeper(int x, int y, int z, int hp) {
   
      super(x, y, z, hp);
      
   } // End Creeper
   
   /**
   * Method: sound
   * @params N/A
   * @return void
   * Description: Makes the creeper make a sound
   */
   public void sound() {
   
      System.out.println("Hiss");
      
   } // End sound

   /**
   * Method: explode
   * @params N/A
   * @return void
   * Description: Makes the creeper make a sound and then explode
   */
   public void explode() {
   
      this.sound();
      System.out.println("Explode");
      
   } // End explode
   
} // End Class