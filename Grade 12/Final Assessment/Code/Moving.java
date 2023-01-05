/**
*  Name: Andy Lee
*  Date: January, 19, 2022
*  Program: Moving
*  Description: This Class represents all entites that move, using a unifed targeting system to do so
*/

public class Moving extends Entity {

  // Attributes
  // The target to move towards
  private int tarX;
  private int tarY;

  // The incremental difference in x and y to the target being moved towards
  private int incX;
  private int incY;

  private int speed;

  /**
   * Method: Moving
   * Description: Constructor Method
   */
  public Moving () {

    super();
    this.speed = 0;
    this.tarX = -1000;

  } // End Moving

  /**
   * Method: Moving
   * @param x
   * @param y
   * @param dx
   * @param dy
   * Description: Constructor Method
   */
  public Moving (int x, int y, int dx, int dy, int speed) {

    super(x, y, dx, dy);
    this.speed = speed;
    this.tarX = -1000;

  } // End Moving

  // Mutators ------------------------------------------------

  /**
    * Method: changeSpeed
    * @param newSpeed
    * @return void
    * Description: changes the speed of a moving entity
    */
  public void changeSpeed (int newSpeed) {

    this.speed = newSpeed;

  } // End changeSpeed

  /**
    * Method: changeTar
    * @param newTarX
    * @param newTarY
    * @return void
    * Description: changes the target of a moving entity
    */
  public void changeTar (int newTarX, int newTarY) {

    // Calculates the angel to calculate increments for the x and y directions
    int diffX = newTarX - this.getX();
    int diffY = newTarY - this.getX();
    double angle;

    // Prevents / 0
    try {

      angle = Math.atan(diffY/diffX);

    } catch (ArithmeticException e) {

      if (diffY >= 0) angle = Math.PI / 2;
      else angle = Math.PI + Math.PI / 2;

    } // End try

    // Creates a an x and y increment of movement based on the target coordinates and current coordinates using trigonometry
    this.tarX = newTarX;
    this.incX = (int)(speed * Math.cos(angle));

    this.tarY = newTarY;
    this.incY = (int)(speed * Math.sin(angle));

  } // End changeTar

  // Accessors ------------------------------------------------
  /**
   * Method: getSpeed
   * @return int
   * Description: gets the speed of a moving entity
   */
  public int getSpeed () {

    return this.speed;

  } // End getSpeed

  /**
   * Method: getTarX
   * @return int
   * Description: gets the target x value of a moving entity
   */
  public int getTarX () {

    return this.tarX;

  } // End getTarX

  /**
   * Method: getTarY
   * @return int
   * Description: gets the target y value of a moving entity
   */
  public int getTarY () {

    return this.tarY;

  } // End getTarY

  /**
   * Method: getIncX
   * @return int
   * Description: gets the increment x value of a moving entity
   */
  public int getIncX () {

    return this.incX;

  } // End getIncX

  /**
   * Method: getIncY
   * @return int
   * Description: gets the increment y value of a moving entity
   */
  public int getIncY () {

    return this.incY;

  } // End getIncY

}