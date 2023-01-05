/**
*  Name: Andy Lee
*  Date: January, 4, 2022
*  Program: Entity
*  Description: This Class represents all interactable entities in Operation Umbra
*/

public class Entity {

  // Attributes
  private int x, y, dx, dy;

  /**
   * Method: Entity
   * Description: Constructor Method
   */
  public Entity () {

    this.x = 0;
    this.y = 0;
    this.dx = 0;
    this.dy = 0;

  } // End Entity

  /**
   * Method: Entity
   * @param x
   * @param y
   * @param dx
   * @param dy
   * Description: Constructor Method
   */
  public Entity (int x, int y, int dx, int dy) {

    this.x = x;
    this.y = y;
    this.dx = dx;
    this.dy = dy;

  } // End Entity

  // Mutators ------------------------------------------------------------------------
  /**
   * Method: changeX
   * @param newX
   * @return void
   * Description: changes the x value of an entity
   */
   public void changeX (int newX) {

     this.x = newX;

   } // End changeX
   
   /**
   * Method: changeY
   * @param newY
   * @return void
   * Description: changes the y value of an entity
   */
   public void changeY (int newY) {

     this.y = newY;

   } // End changeY

   /**
   * Method: changeDx
   * @param newDx
   * @return void
   * Description: changes the width of an entity
   */
   public void changeDx (int newDx) {

     this.dx = newDx;

   } // End changeDx

   /**
   * Method: changeDy
   * @param newDy
   * @return void
   * Description: changes the height of an entity
   */
   public void changeDy (int newDy) {

     this.dy = newDy;

   } // End changeDy

  // Accessors ------------------------------------------------------------------------
  /**
   * Method: getX
   * @return int
   * Description: gets the x value of an entity
   */
   public int getX () {

     return this.x;

   } // End getX

   /**
   * Method: getY
   * @return int
   * Description: gets the y value of an entity
   */
   public int getY () {

     return this.y;

   } // End getY

   /**
   * Method: getDx
   * @return int
   * Description: gets the width of an entity
   */
   public int getDx () {

     return this.dx;

   } // End getDx

   /**
   * Method: getDy
   * @return int
   * Description: gets the height of an entity
   */
   public int getDy () {

     return this.dy;

   } // End getDy

}