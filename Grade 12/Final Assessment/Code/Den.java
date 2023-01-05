/**
*  Name: Andy Lee
*  Date: January, 4, 2022
*  Program: Den
*  Description: This Class represents a specific tile that enemies will emerge from
*/

public class Den extends Tile {

  // Attributes
  private String direction;

  /**
   * Method: Den
   * Description: Constructor Method
   */
  public Den () {

    direction = "U";

  } // End Den

  /**
   * Method: Den
   * @param direction
   * Description: Constructor Method
   */
  public Den (String direction) {

    this.direction = direction;

  } // End Den

  // Accessors --------------------------------------------------------------------
  /**
   * Method: getDirection
   * @return String
   * Description: gets the direction of the den
   */
  public String getDirection () {

    return this.direction;

  } // End Den

}