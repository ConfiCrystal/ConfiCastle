/**
*  Name: Andy Lee
*  Date: January, 4, 2022
*  Program: Enemy
*  Description: This Class represents a type of entity that the player must defeat
*/

public class Enemy extends Moving {

  // Attributes
  private int weight;
  private int hp;
  private String designation;

  /**
   * Method: Enemy
   * Description: Constructor Method
   */
  public Enemy () {

    super();
    this.weight = 0;
    this.hp = 0;
    this.designation = "";

  } // End Enemy

  /**
   * Method: Enemy
   * @param x
   * @param y
   * @param dx
   * @param dy
   * @param size
   * @param weight
   * @param hp
   * @param speed
   * Description: Constructor Method
   */
  public Enemy (int x, int y, int dx, int dy, int speed, int weight, int hp, String designation) {

    super (x, y, dx, dy, speed);
    this.weight = weight;
    this.hp = hp;
    this.designation = designation;

  } // End Enemy
  
  // Mutators ------------------------------------------------------------------------

   /**
   * Method: changeWeight
   * @param newWeight
   * @return void
   * Description: changes the weight of an enemy
   */
   public void changeWeight (int newWeight) {

     this.weight = newWeight;

   } // End changeWeight
   
   /**
   * Method: changeHp
   * @param newHp
   * @return void
   * Description: changes the hp of an enemy
   */
   public void changeHp (int newHp) {

     this.hp = newHp;

   } // End changeHp
   
   /**
   * Method: changeDesignation
   * @param newDesignation
   * @return void
   * Description: changes the designation of an enemy
   */
   public void changeDesignation (String newDesignation) {

     this.designation = newDesignation;

   } // End changeDesignation

   // Accessors ------------------------------------------------------------------------

   /**
   * Method: getWeight
   * @return int
   * Description: gets the weight of an enemy
   */
   public int getWeight () {

     return this.weight;

   } // End getWeight

   /**
   * Method: getHp
   * @return int
   * Description: gets the hp of an enemy
   */
   public int getHp () {

     return this.hp;

   } // End getHp

   /**
   * Method: getDesignation
   * @return String
   * Description: gets the designation of an enemy
   */
   public String getDesignation () {

     return this.designation;

   } // End getDesignation
   
}