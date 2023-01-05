/**
*  Name: Andy Lee
*  Date: January, 17, 2022
*  Program: SqrEnemy
*  Description: This Class represents a type of enemy
*/

public class SqrEnemy extends Enemy {

  /**
   * Method: SqrEnemy
   * Description: Constructor Method
   */
  SqrEnemy () {

    super();

  } // End SqrEnemy

  /**
   * Method: Enemy
   * @param x
   * @param y
   * @param dx
   * @param dy
   * @param size
   * @param speed
   * @param weight
   * @param hp
   * @param designation
   * Description: Constructor Method
   */
  public SqrEnemy (int x, int y, int dx, int dy, int speed, int weight, int hp, String designation) {

    super (x, y, dx, dy, speed, weight, hp, designation);

  } // End SqrEnemy

}