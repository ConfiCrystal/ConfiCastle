/**
*  Name: Andy Lee
*  Date: January, 4, 2022
*  Program: Tower
*  Description: This Class represents a tower tile that will fight enemies
*/

public class Tower extends Tile {

  // Attributes
  private int damage;
  private double speed;

  /**
   * Method: Tower
   * Description: Constructor Method
   */
  public Tower () {

  } // End Tower
  
  // Mutators ---------------------------------------------------------------
  /**
   * Method: changeDamage
   * @param newDamage
   * @return void
   * Description: Changes a tower's damage
   */
  public void changeDamage (int newDamage) {

    this.damage = newDamage;

  } // End changeDamage

   /**
   * Method: changeSpeed
   * @param newSpeed
   * @return void
   * Description: Changes a tower's speed
   */
  public void changeSpeed (double newSpeed) {

    this.speed = newSpeed;

  } // End changeSpeed
  
  // Accessors ---------------------------------------------------------------
  /**
   * Method: getDamage
   * @return int
   * Description: Gets a tower's damage
   */
  public int getDamage () {

    return this.damage;

  } // End getDamage

  /**
   * Method: getSpeed
   * @return double
   * Description: Gets a tower's speed
   */
  public double getSpeed () {

    return this.speed;

  } // End getSpeed

}